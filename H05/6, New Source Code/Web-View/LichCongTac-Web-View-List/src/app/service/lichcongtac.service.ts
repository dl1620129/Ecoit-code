import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, Inject, LOCALE_ID } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { CommonService } from './common.service';
import { Constants } from '../common/constants';
import { LichChiTiet } from '../model/lichchitiet.model';
import { formatDate } from '@angular/common';
import { DateObject } from '../model/dateObject.model';
import { LichConstants } from '../common/lich-constants';

declare const Liferay: any;

@Injectable({
  providedIn: 'root'
})export class LichCongTacService {
    constructor(private http: HttpClient,
        @Inject(LOCALE_ID) private locale: string) {}

    public getFilteredLichChiTiet(startDate: Date, endDate: Date) {
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
            let tempEndDate = new Date(endDate.getFullYear(), endDate.getMonth(), endDate.getDate(), 23);
            endDateString = formatDate(tempEndDate, 'yyyy-MM-dd', this.locale);
        }

        let body = {
            'action': LichConstants.SCHEDULE_PUBLISH,
            'fromDate': startDateString,
            'toDate' : endDateString
        }

        console.log(body);
        let getUrl = Constants.baseUrl + '/o/lichcongtac/app/get/publish/' + Constants.scopeGroupId + '/' + Constants.languageId;
        return this.http.post(getUrl, body, {headers: headers}).pipe(catchError(CommonService.handleError));
    }

    public convertDataToLichChiTiet(lichChiTietData: any) {
        let lichChiTietList = new Array();
        if (lichChiTietData) {
            lichChiTietData.forEach((element: any) => {
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
        return lichChiTietList;
    }

    public createDateObject(dateObject: DateObject, lichChiTiet: LichChiTiet[]) {
        let morningList = new Array();
        let afternoonList = new Array();
        lichChiTiet.forEach((lichElement: any) => {
            if (lichElement.selectedDate.getDate() == dateObject.day.getDate()) {
                dateObject.isDisplay = true;
                if (lichElement.startTime.getHours() < 12) {
                    morningList.push(lichElement);
                } else {
                    afternoonList.push(lichElement);
                }
            }
        });
        dateObject.morningList = morningList;
        dateObject.afternoonList = afternoonList;
        return dateObject;
    }
}