import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, tap } from 'rxjs/operators';
import { Constants } from '../common/constants';
import { CommonService } from './common.service';

@Injectable({
  providedIn: 'root'
})export class QuestionService {
    constructor(private http: HttpClient) {}

    public getQuestionInfo() {
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });

        let createUrl = Constants.baseUrl + '/o/qaquestion/app/get/statistic/' + Constants.scopeGroupId + '/' + Constants.languageId;
        return this.http.get(createUrl, {headers: headers}).pipe(catchError(CommonService.handleError));
    }
}