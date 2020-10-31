import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, Inject, LOCALE_ID } from '@angular/core';
import { catchError, tap } from 'rxjs/operators';
import { Document } from '../model/document.model';
import { CommonService } from './common.service';
import { Constants } from '../common/constants';
import { formatDate } from '@angular/common';
import { DomSanitizer } from '@angular/platform-browser';
import { Attachment } from '../model/attachment.model';

declare const Liferay: any;

@Injectable({
  providedIn: 'root'
})export class DocumentService {
    constructor(private http: HttpClient,
        @Inject(LOCALE_ID) private locale: string,
        private sanitizer: DomSanitizer) {}

    public getFilteredDocument(searchForm: any) {
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });

        let formattedDateFrom = null;
        if (searchForm.get('fromDate').value != null && searchForm.get('fromDate').value != '') {
            searchForm.get('fromDate').value.setHours(0);
            formattedDateFrom = searchForm.get('fromDate').value.getTime();
        }
        let formattedDateTo = null;
        if (searchForm.get('toDate').value != null && searchForm.get('toDate').value != '') {
            searchForm.get('toDate').value.setHours(23);
            formattedDateTo = searchForm.get('toDate').value.getTime();
        }

        let formattedPromulDate = null;
        if (searchForm.get('promulDate').value != null && searchForm.get('promulDate').value !== '') {
            searchForm.get('promulDate').value.setHours(0);
            formattedPromulDate = searchForm.get('promulDate').value.getTime();
        }

        let body = {
            'typeId': searchForm.get('typeId').value,
            'organizationId': searchForm.get('organizationId').value,
            'symbol': searchForm.get('symbol').value,
            'signerId': searchForm.get('signerId').value,
            'fieldId': searchForm.get('fieldId').value,
            'fromDate': formattedDateFrom,
            'toDate': formattedDateTo,
            'promulDate': formattedPromulDate,
            'newGopY': searchForm.get('newGopY').value
        };
        console.log(body);

        let createUrl = Constants.baseUrl + '/o/elegal/app/doc/get-by-config/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '/' + Constants.companyId + '/' + Constants.CONFIGURATION;
        return this.http.post(createUrl, body, {headers: headers}).pipe(catchError(CommonService.handleError));
    }

    public getSuggestDocument(searchValue: any, limit: number) {
        let getUrl = Constants.baseUrl + '/o/elegal/app/doc/get-suggestion/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.companyId + '?searchValue=' + searchValue + '&limit=' + limit;
        return this.http.get(getUrl).pipe(catchError(CommonService.handleError));
    }

    public getSelectedOption(docId: any) {
        let getUrl = Constants.baseUrl + '/o/elegal/app/doc/get/view/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.companyId + '/' + Constants.userId + '?docId=' + docId;
        return this.http.get(getUrl).pipe(catchError(CommonService.handleError));
    }

    public getDocument(id: any){
        let getUrl = Constants.baseUrl + '/o/elegal/app/doc/get/item/' + id;
        return this.http.get(getUrl).pipe(catchError(CommonService.handleError));
    }

    //delete article
    public deleteDocument(docIdList: number[]) {
        let body = new FormData();
        docIdList.forEach((element: number) => {
            body.append('docId', element.toString());
        });
        let url = Constants.baseUrl + '/o/elegal/app/doc/delete/document/' + Constants.scopeGroupId + '/' + Constants.userId;
        return this.http.post(url, body).pipe(catchError(CommonService.handleError));
    }

    //delete image
    public deleteAttachment(attachmentId: number) {
        let url = Constants.baseUrl + '/o/elegal/app/doc/delete/attachment/' + attachmentId;
        return this.http.delete(url).pipe(catchError(CommonService.handleError));
    }

    public submitDocumentForm(form: Document, id: number, action: number, attachmentsList: Attachment[]) {

        console.log(form);
        let body = new FormData();
        body.append('symbol', form.symbol);
        if (form.promulDate != null) {
            let formattedPromulDate = formatDate(form.promulDate, 'dd/MM/yyyy HH:ss', this.locale);
            body.append('promulDate', formattedPromulDate);
        }

        if (form.effectivedDate != null) {
            let formattedEffectiveDate = formatDate(form.effectivedDate, 'dd/MM/yyyy HH:ss', this.locale);
            body.append('effectivedDate', formattedEffectiveDate);
        }

        if (form.expiredDate != null && !form.isNeverExpired) {
            let formattedExpiredDate = formatDate(form.expiredDate, 'dd/MM/yyyy HH:ss', this.locale);
            body.append('expiredDate', formattedExpiredDate);
        }

        body.append('replaceDoc', JSON.stringify(form.replaceDoc));
        body.append('summary', form.summary.trim());
        body.append('content', form.content.trim());
        body.append('statusDoc', action.toString());
        body.append('isPublic', form.isPublic);
        body.append('fieldId', form.fieldId.toString());
        body.append('organizationId', form.organizationId.toString());
        body.append('docRelation', JSON.stringify(form.docRelation));
        body.append('typeIds', form.typesList.toString());
        body.append('signerRels', JSON.stringify(form.signerRels));
        if (action && action >= 0) {
            body.append('action', JSON.stringify(action));
        }
        let atttachmentFiles:File[] = new Array();
        attachmentsList.forEach((element: Attachment) => {
            if (element.file) {
                //atttachmentFiles.push(element.file);
                body.append('attachments', element.file);
            }
        });
        
        console.log(JSON.stringify(atttachmentFiles));
        if (id && id > 0) {
            let updateUrl = Constants.baseUrl + '/o/elegal/app/doc/update/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' +  Constants.companyId + '/' + Constants.userId + '/' + id;
            return this.http.post(updateUrl, body).pipe(catchError(CommonService.handleError));
        }

        let createUrl = Constants.baseUrl + '/o/elegal/app/doc/create/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.companyId + '/' + Constants.userId;
        return this.http.post(createUrl, body).pipe(catchError(CommonService.handleError));
    }

    public convertDateToDocument(documentData: any) {
        let document = new Document;
        document.docId = documentData.docId;
        document.num = documentData.num;
        document.symbol = documentData.symbol;
        document.isPublic = JSON.stringify(documentData.isPublic);
        document.summary = documentData.summary;
        document.organizationId = documentData.organizationId;
        document.typesList = documentData.typesList;
        document.fieldId = documentData.fieldId;
        document.signerRels = documentData.signerRels;
        document.docRelation = documentData.docRelation;
        document.replaceDoc = documentData.replaceDoc;
        document.content = documentData.content;
        document.attachmentURLsList = documentData.attachmentURLsList;
        document.isNeverExpired = documentData.isNeverExpired;
        if (documentData.promulDate) {
            let tempDate = new Date(documentData.promulDate);
            document.promulDate = new Date(tempDate.getUTCFullYear(), tempDate.getUTCMonth(), tempDate.getUTCDate(), tempDate.getUTCHours());
        }

        if (documentData.effectivedDate) {
            let tempDate = new Date(documentData.effectivedDate);
            document.effectivedDate = new Date(tempDate.getUTCFullYear(), tempDate.getUTCMonth(), tempDate.getUTCDate(), tempDate.getUTCHours());
        }

        if (documentData.expiredDate) {
            let tempDate = new Date(documentData.expiredDate);
            document.expiredDate = new Date(tempDate.getUTCFullYear(), tempDate.getUTCMonth(), tempDate.getUTCDate(), tempDate.getUTCHours());
        }
        console.log(document);
        return document;
    }

    public updateStatus(action: number, docIdList: number[]) {
        let body = new FormData();
        docIdList.forEach((element: number) => {
            body.append('docId', element.toString());
        });
        body.append('action', action.toString());

        let createUrl = Constants.baseUrl + '/o/elegal/app/doc/update/status/' + Constants.userId;
        return this.http.post(createUrl, body).pipe(catchError(CommonService.handleError));
    }
}