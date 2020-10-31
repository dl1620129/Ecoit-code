import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, Inject, LOCALE_ID } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { LichCongTac } from '../model/lichcongtac.model';
import { CommonService } from './common.service';
import { Constants } from '../common/constants';
import { DomSanitizer } from '@angular/platform-browser';
import { LichChiTiet } from '../model/lichchitiet.model';
import { formatDate } from '@angular/common';
import { LichConstants } from '../common/lich-constants';
import { User } from '../model/user.model';

declare const Liferay: any;

@Injectable({
  providedIn: 'root'
})export class LichChiTietService {
    constructor(private http: HttpClient,
        @Inject(LOCALE_ID) private locale: string) {}

    public getFilteredLichChiTiet(start: number, pageSize: number, orgId: number, startDate: Date, endDate: Date, config: any) {
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
            'searchKey': '',
            'fromDate': startDateString,
            'toDate' : endDateString
        }
        console.log(body);
    
        let getUrl = Constants.baseUrl + '/o/lichcongtac/app/lichchitiet/getall/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' 
            + Constants.userId + '/' + config + '/' + Constants.companyId
            + '?start=' + start + '&limit=' + pageSize + '&orgId=' + orgId;
        console.log(getUrl);
        return this.http.post(getUrl, body, {headers: headers}).pipe(catchError(CommonService.handleError));
    }

    public getLichChiTiet(id: any){
        let getUrl = Constants.baseUrl + '/o/lichcongtac/app/lichchitiet/get/item/' + Constants.userId + '/' + id;
        return this.http.get(getUrl).pipe(catchError(CommonService.handleError));
    }

    //delete article
    public deleteLichChiTiet(id: number) {
        let url = Constants.baseUrl + '/o/lichcongtac/app/lichchitiet/delete/' + id;
        return this.http.delete(url).pipe(catchError(CommonService.handleError));
    }

    public updateStatusLichChiTiet(action: number, lichChiTietId: number, lyDoTraVe: string, coLyDo: boolean) {
        let body = new FormData();
        body.append('lichChiTietId', lichChiTietId.toString());
        body.append('action', action.toString());
        body.append('lyDoTraVe', lyDoTraVe);
        body.append('coLyDo', coLyDo.toString());
        let createUrl = Constants.baseUrl + '/o/lichcongtac/app/lichchitiet/update/chitiet-status/' + Constants.userId;
        return this.http.post(createUrl, body).pipe(catchError(CommonService.handleError));
    }

    public submitLichChiTietForm(form: LichChiTiet, id: number, action: number, coLyDo: boolean, lyDoTraVe: string) {
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });
        let body = {
            'startTime': form.startTime,
            'selectedDate': form.selectedDate,
            'description': form.description,
            'nguoiThamDu': form.nguoiThamDu,
            'nguoiChuTri': form.nguoiChuTri,
            'address': form.address,
            'coLyDo': coLyDo,
            'lyDoTraVe': lyDoTraVe,
            'note': form.note,
            'action': action,
        };
        console.log(body);
        if (id && id > 0) {
            let updateUrl = Constants.baseUrl + '/o/lichcongtac/app/lichchitiet/update/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' +   Constants.userId + '/' + Constants.companyId + '/' + id;
            return this.http.put(updateUrl, body).pipe(catchError(CommonService.handleError));
        }

        let createUrl = Constants.baseUrl + '/o/lichcongtac/app/lichchitiet/create/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '/' + Constants.companyId;
        return this.http.post(createUrl, body, {headers: headers}).pipe(catchError(CommonService.handleError));
    }
    
    public convertListDataToLichChiTiet(lichChiTietData: any) {
        let lichChiTietList = new Array();
        if (lichChiTietData) {
            lichChiTietData.forEach((element: any) => {
                let lichChiTiet = this.convertDataToLichChiTiet(element);
                lichChiTietList.push(lichChiTiet);
            });
        }
        return lichChiTietList;
    }

    public convertDataToLichChiTiet(data: any) {
        let lichChiTiet = new LichChiTiet();
        lichChiTiet.lichChiTietId = data.lichChiTietId;
        lichChiTiet.selectedDate = new Date(data.selectedDate);
        lichChiTiet.startTime = new Date(data.startTime);
        lichChiTiet.tenLich = data.tenLich;
        lichChiTiet.description = data.description;
        lichChiTiet.nguoiThamDu = data.nguoiThamDu;
        lichChiTiet.nguoiChuTri = data.nguoiChuTri;
        lichChiTiet.address = data.address;
        lichChiTiet.note = data.note;
        lichChiTiet.organizationId = data.organizationId;
        lichChiTiet.organizationName = data.organizationName;
        lichChiTiet.lyDoTraVe = data.lyDoTraVe;
        return lichChiTiet;
    }
}