import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, Inject, LOCALE_ID } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { LichCongTac } from '../model/lichcongtac.model';
import { CommonService } from './common.service';
import { Constants } from '../common/constants';
import { LichChiTiet } from '../model/lichchitiet.model';
import { formatDate } from '@angular/common';

declare const Liferay: any;

@Injectable({
  providedIn: 'root'
})export class LichCongTacService {
    constructor(private http: HttpClient,
        @Inject(LOCALE_ID) private locale: string) {}

    public getFilteredLichCongTac(start: number, pageSize: number, searchKey: string, orgId: number, startDate: Date, endDate: Date) {
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });

        let startDateString = '';
        if (startDate != null) {
            let tempStartDate = new Date(startDate.getFullYear(), startDate.getMonth(), startDate.getDate(), startDate.getHours());
            startDateString = formatDate(tempStartDate, 'yyyy-MM-dd', this.locale);
        }

        let endDateString = '';
        if (endDate != null) {
            let tempEndDate = new Date(endDate.getFullYear(), endDate.getMonth(), endDate.getDate(), 0);
            endDateString = formatDate(tempEndDate, 'yyyy-MM-dd', this.locale);
        }

        let body = {
            'searchKey': searchKey,
            'fromDate': startDateString,
            'toDate' : endDateString
        }

        let getUrl = Constants.baseUrl + '/o/lichcongtac/app/getall/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' 
        + Constants.userId + '/' + Constants.CONFIGURATION + '/' + Constants.companyId
        + '?start=' + start + '&limit=' + pageSize + '&orgId=' + orgId;
        return this.http.post(getUrl, body, {headers: headers}).pipe(catchError(CommonService.handleError));
    }

    public getLichCongTac(id: any){
        let getUrl = Constants.baseUrl + '/o/lichcongtac/app/get/item/' + Constants.userId + '/' + id;
        return this.http.get(getUrl).pipe(catchError(CommonService.handleError));
    }

    public checkPermission(){
        let getUrl = Constants.baseUrl + '/o/lichcongtac/app/get/permission/' + Constants.userId;
        return this.http.get(getUrl).pipe(catchError(CommonService.handleError));
    }

    //delete article
    public deleteLichCongTac(lichIdList: number[]) {
        let body = new FormData();
        lichIdList.forEach((element: number) => {
            body.append('lichCongTacId', element.toString());
        });
        let url = Constants.baseUrl + '/o/lichcongtac/app/delete-lich/' + Constants.userId;
        return this.http.post(url, body).pipe(catchError(CommonService.handleError));
    }

    public submitLichCongTacForm(form: LichCongTac, id: number, action: number, coLyDo: boolean, lyDoTraVe: string) {

        let body = {
            'startDate': form.startDate,
            'endDate': form.endDate,
            'name': form.name,
            'organizationId': form.organizationId,
            'coLyDo': coLyDo,
            'lyDoTraVe': lyDoTraVe,
            'organizations': form.organizations,
            'users': form.users,
            'lichChiTietList': form.lichChiTietList,
            'action': action,
        };
        console.log(body);
        if (id && id > 0) {
            let updateUrl = Constants.baseUrl + '/o/lichcongtac/app/update/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' +   Constants.userId + '/' + Constants.companyId + '/' + id;
            return this.http.put(updateUrl, body).pipe(catchError(CommonService.handleError));
        }

        let createUrl = Constants.baseUrl + '/o/lichcongtac/app/create/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '/' + Constants.companyId + '/' ;
        return this.http.post(createUrl, body).pipe(catchError(CommonService.handleError));
    }

    public convertDataToLichCongTac(lichCongTacData: any) {
        let lichCongTac = new LichCongTac();
        if (lichCongTacData.startDate) {
            let tempDate = new Date(lichCongTacData.startDate);
            lichCongTac.startDate = new Date(tempDate.getTime());
        }

        if (lichCongTacData.endDate) {
            let tempDate = new Date(lichCongTacData.endDate);
            lichCongTac.endDate = new Date(tempDate.getTime());
        }

        lichCongTac.name = lichCongTacData.name;
        lichCongTac.lichCongTacId = lichCongTacData.lichCongTacId;
        lichCongTac.organizations = lichCongTacData.organizations;
        lichCongTac.organizationId = lichCongTacData.organizationId;
        lichCongTac.users = lichCongTacData.users;
        lichCongTac.lyDoTraVe = lichCongTacData.lyDoTraVe;
        let lichChiTietList = new Array();
        if (lichCongTacData.lichChiTietList) {
            lichCongTacData.lichChiTietList.forEach((element: any) => {
                let lichChiTiet = new LichChiTiet();
                lichChiTiet.selectedDate = new Date(element.selectedDate);
                lichChiTiet.startTime = new Date(element.startTime);
                lichChiTiet.description = element.description;
                lichChiTiet.nguoiThamDu = element.nguoiThamDu;
                lichChiTiet.nguoiChuTri = element.nguoiChuTri;
                lichChiTiet.address = element.address;
                lichChiTiet.note = element.note;
                lichChiTietList.push(lichChiTiet);
            });
        }
        lichCongTac.lichChiTietList = lichChiTietList;
        return lichCongTac;
    }

    public getSuggestedOrgs(limit: number, searchKey: string) {
        /*let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });*/

        let getUrl = Constants.baseUrl + '/o/lichcongtac/app/get/suggested-org' + '?limit=' + limit + '&q=' + searchKey;
        return this.http.get(getUrl).pipe(catchError(CommonService.handleError));
    }

    public updateStatus(action: number, lichIdList: number[], lyDoTraVe: string, coLyDo: boolean) {
        let body = new FormData();
        lichIdList.forEach((element: number) => {
            body.append('lichCongTacId', element.toString());
        });
        body.append('action', action.toString());
        body.append('lyDoTraVe', lyDoTraVe);
        body.append('coLyDo', coLyDo.toString());
        let createUrl = Constants.baseUrl + '/o/lichcongtac/app/update/status/' + Constants.userId;
        return this.http.post(createUrl, body).pipe(catchError(CommonService.handleError));
    }

    public exportExcelFile(lichIdList: number[]) {
        let body = new FormData();
        lichIdList.forEach((element: number) => {
            body.append('lichCongTacId', element.toString());
        });

        let getUrl = Constants.baseUrl + '/o/lichcongtac/app/export/' + Constants.userId + '/' + Constants.companyId;
        return this.http.post(getUrl, body).pipe(catchError(CommonService.handleError));
    }
}