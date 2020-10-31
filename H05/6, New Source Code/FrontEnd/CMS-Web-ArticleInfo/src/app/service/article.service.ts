import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, tap } from 'rxjs/operators';
import { Constants } from '../common/constants';
import { CommonService } from '../service/common.service';

@Injectable({
  providedIn: 'root'
})export class ArticleService {
    constructor(private http: HttpClient) {}

    public getArticlesInfo() {
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });

        let body = {
            'inTitle': false,
            'eventNames': '',
            'tagNames': '',
            'inSummary': false,
            'inContent': false,
            'inDate': false,
            'fromDate': 0,
            'toDate': 0,
            'inAuthor': false,
            'userKiemDuyet': false
        };
        console.log(body);

        let createUrl = Constants.baseUrl + '/o/article/app/get-by-config/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '/' + Constants.CONFIGURATION;
        return this.http.post(createUrl, body, {headers: headers}).pipe(catchError(CommonService.handleError));
    }
}