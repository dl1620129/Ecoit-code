import { HttpClient } from '@angular/common/http';
import { ParseError } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { Constants } from '../common/constants';
import { catchError } from 'rxjs/operators';
import { CommonService } from './common.service';

@Injectable({ providedIn: 'root' })
export class HistoryService {
    constructor(public http: HttpClient) { }
    public getHistoryByReport(id: number,start:number,limit:number) {
        let url = Constants.baseUrl + '/o/memberreport/app/history/getall/' + Constants.scopeGroupId + '/' + Constants.userId + '/' + id+'?start='+start+'&limit='+limit;
        return this.http.get(url).pipe(catchError(CommonService.handleError));
    }
    public getDetail(id: number) {
        let url = Constants.baseUrl + '/o/memberreport/app/history/get-detail/' + Constants.scopeGroupId + '/' + Constants.userId + '/' + id;
        this.http.get(url).pipe(catchError(CommonService.handleError));
    }
   
}