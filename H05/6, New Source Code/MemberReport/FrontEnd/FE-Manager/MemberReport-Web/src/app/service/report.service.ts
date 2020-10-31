import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, Inject, LOCALE_ID } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { CommonService } from './common.service';
import { Constants } from '../common/constants';
import { formatDate } from '@angular/common';

declare const Liferay: any;

@Injectable({
    providedIn: 'root'
}) export class ReportService {
    constructor(private http: HttpClient,
        @Inject(LOCALE_ID) private locale: string) { }

    public getFilteredReport(searchForm: any, start: number, pageSize: number) {
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });

        let modifiedDate = '';
        if (searchForm.get('modifiedDate').value != null && searchForm.get('modifiedDate').value != '') {
            let formattedDateFrom = formatDate(searchForm.get('modifiedDate').value, 'dd/MM/yyyy', this.locale);
            modifiedDate = formattedDateFrom;
        }
        let body = {
            'modifiedDate': modifiedDate,
            'unitId': searchForm.get('unitId').value,
        }

        let getUrl = Constants.baseUrl + '/o/memberreport/app/report/getall/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.companyId + '?start=' + start + '&limit=' + pageSize;
        return this.http.post(getUrl, body, { headers: headers }).pipe(catchError(CommonService.handleError));
    }

    public getReportDetail(id: any) {
        let getUrl = Constants.baseUrl + '/o/memberreport/app/report/get/item/' + id;
        return this.http.get(getUrl).pipe(catchError(CommonService.handleError));
    }

    //delete report
    public deleteReport(id: number) {
        let url = Constants.baseUrl + '/o/memberreport/app/report/delete/' + Constants.userId + '/' + id + '/' + Constants.scopeGroupId;
        return this.http.delete(url).pipe(catchError(CommonService.handleError));
    }
    congTacList: any[] = []
    hocTapLisst: any[] = []
    nghiOmList: any[] = []
    nghiPhepList: any[] = []
    nghiBuList : any[] = []
    lyDoKhacList: any[] = []
    public submitReportForm(form: any, id: number) {
        this.congTacList=[];
        this.hocTapLisst=[];
        this.nghiOmList=[];
        this.nghiPhepList=[];
        this.nghiBuList=[];
        this.lyDoKhacList=[];
        for (let index = 0; index < form.get('listCongTac').value.length; index++) {
            this.congTacList.push(form.get('listCongTac').value[index]);
        }
        for (let index = 0; index < form.get('listHocTap').value.length; index++) {
            this.hocTapLisst.push(form.get('listHocTap').value[index]);
        }
        for (let index = 0; index < form.get('listNghiPhep').value.length; index++) {
            this.nghiPhepList.push(form.get('listNghiPhep').value[index]);
        }
        for (let index = 0; index < form.get('listNghiOm').value.length; index++) {
            this.nghiOmList.push(form.get('listNghiOm').value[index]);
        }
        for (let index = 0; index < form.get('listNghiBu').value.length; index++) {
            this.nghiBuList.push(form.get('listNghiBu').value[index]);
        }
        for (let index = 0; index < form.get('listLiDoKhac').value.length; index++) {
            this.lyDoKhacList.push(form.get('listLiDoKhac').value[index]);
        }
        let body = {
            'memberReportId': id,
            'tong': form.get('tong').value,
            'congTac': form.get('congTac').value,
            'hocTap': form.get('hocTap').value,
            'nghiPhep': form.get('nghiPhep').value,
            'nghiOm': form.get('nghiOm').value,
            'nghiBu': form.get('nghiBu').value,
            'liDoKhac': form.get('liDoKhac').value,
            'note': form.get('note').value,
            'unitId': form.get('unitId').value,
            'listCongTac': JSON.stringify(this.congTacList),
            'listHocTap': JSON.stringify(this.hocTapLisst),
            'listNghiPhep': JSON.stringify(this.nghiPhepList),
            'listNghiOm': JSON.stringify(this.nghiOmList),
            'listNghiBu': JSON.stringify(this.nghiBuList),
            'listLiDoKhac': JSON.stringify(this.lyDoKhacList)
        };
        console.log(JSON.stringify(this.congTacList));
        if (id && id > 0) {
            let updateUrl = Constants.baseUrl + '/o/memberreport/app/report/update/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '/' + Constants.companyId;
            return this.http.put(updateUrl, body).pipe(catchError(CommonService.handleError));
        }

        let createUrl = Constants.baseUrl + '/o/memberreport/app/report/create/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '/' + Constants.companyId;
        return this.http.post(createUrl, body).pipe(catchError(CommonService.handleError));
    }
    public createHistory(form: any, id: number, type: number) {
        let body = {
            'tong': form.get('tong').value,
            'congTac': form.get('congTac').value,
            'hocTap': form.get('hocTap').value,
            'nghiPhep': form.get('nghiPhep').value,
            'nghiOm': form.get('nghiOm').value,
            'nghiBu': form.get('nghiBu').value,
            'liDoKhac': form.get('liDoKhac').value,
            'note': form.get('note').value,
        };
        let createUrl = Constants.baseUrl + '/o/memberreport/app/history/create/' + Constants.scopeGroupId + '/' + Constants.userId + '/' + id + '/' + type;
        return this.http.post(createUrl, body).pipe(catchError(CommonService.handleError));
    }
    getPermission() {
        let getUrl = Constants.baseUrl + '/o/memberreport/app/report/get/permission/' + Constants.userId;
        return this.http.get(getUrl).pipe(catchError(CommonService.handleError));
    }
    public getAllUnits() {
        let getUrl = Constants.baseUrl + '/o/memberreport/app/unit/getall/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.companyId + '?limit=0&start=0';
        return this.http.get(getUrl).pipe(catchError(CommonService.handleError));
    }
    public getSuggestedUsers(limit: number, searchKey: string) {
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });

        let getUrl = Constants.baseUrl + '/o/lichcongtac/app/get/suggested-user' + '?limit=' + limit + '&q=' + searchKey;
        return this.http.get(getUrl).pipe(catchError(CommonService.handleError));
    }
    getAlllUSer() {
        let url = Constants.baseUrl + '/o/ldap/app/get-list-user';
        return this.http.get(url).pipe(catchError(CommonService.handleError));
    }
    public getAllusersByOrg(id:number) {
        let url = Constants.baseUrl + '/o/ldap/app/get-user-org/'+id
        return this.http.get(url).pipe(catchError(CommonService.handleError));
    }
}