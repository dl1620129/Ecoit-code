import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, tap } from 'rxjs/operators';
import { CommonService } from './common.service';
import { Constants } from '../common/constants';

declare const Liferay: any;

@Injectable({
  providedIn: 'root'
})export class SuggestionService {
    constructor(private http: HttpClient) {}

    public getAllSuggestions(start: number, pageSize: number, docId: number) {
        let url = Constants.baseUrl + '/o/elegal/app/suggest-doc/getall/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + docId + '?start=' + start + '&limit=' + pageSize;
        return this.http.get(url).pipe(catchError(CommonService.handleError));
    }

    public getSuggestion(id: any){
        let getUrl = Constants.baseUrl + '/o/elegal/app/suggest-doc/get/item/' + id;
        return this.http.get(getUrl).pipe(catchError(CommonService.handleError));
    }

    //delete suggestion
    public deleteSuggestion(id: number) {
        let url = Constants.baseUrl + '/o/elegal/app/suggest-doc/delete/suggesion/' + id;
        return this.http.delete(url).pipe(catchError(CommonService.handleError));
    }

    public submitSuggestion(suggestForm: any, docId: any, sugId: number) {
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });

        let body = {
            'docId': docId,
            'userName': suggestForm.get('name').value,
            'email': suggestForm.get('email').value,
            'title': suggestForm.get('title').value,
            'content': suggestForm.get('content').value,
            'approved': suggestForm.get('isApproved').value
        };
        console.log(body);

        let createUrl = Constants.baseUrl + '/o/elegal/app/suggest-doc/update/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '/' + sugId;
        return this.http.put(createUrl, body, {headers: headers}).pipe(catchError(CommonService.handleError));
    }

    public approvedSuggestion(isApproved: boolean, sugId: number) {
        let createUrl = Constants.baseUrl + '/o/elegal/app/suggest-doc/approved/' + Constants.userId + '/' + isApproved + '/' + sugId;
        return this.http.get(createUrl).pipe(catchError(CommonService.handleError));
    }
}