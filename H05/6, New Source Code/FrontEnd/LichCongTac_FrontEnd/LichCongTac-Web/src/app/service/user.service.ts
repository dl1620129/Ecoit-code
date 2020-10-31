import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, Inject, LOCALE_ID } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { LichCongTac } from '../model/lichcongtac.model';
import { CommonService } from './common.service';
import { Constants } from '../common/constants';
import { DomSanitizer } from '@angular/platform-browser';

declare const Liferay: any;

@Injectable({
  providedIn: 'root'
})export class UserService {
    constructor(private http: HttpClient) {}

    public getSuggestedUsers(limit: number, searchKey: string) {
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });

        let getUrl = Constants.baseUrl + '/o/lichcongtac/app/get/suggested-user' + '?limit=' + limit + '&q=' + searchKey;
        return this.http.get(getUrl).pipe(catchError(CommonService.handleError));
    }
}