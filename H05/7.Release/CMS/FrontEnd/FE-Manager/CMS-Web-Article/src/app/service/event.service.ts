import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import{ Constants } from '../common/constants';
import { CommonService } from './common.service';

@Injectable({
    providedIn: 'root'
})export class EventService {

    private accessToken = '';
    constructor(private http: HttpClient) { };
    
    public getFilteredEvents(start: number, pageSize: number, searchKey: string) {
        let url = Constants.baseUrl + '/o/event/app/' + Constants.userId + '/' + Constants.scopeGroupId + '/' + Constants.languageId + '/getlist?start=' + start + '&limit=' + pageSize + '&q=' + searchKey;
        return this.http.get(url).pipe(catchError(CommonService.handleError));
    }
}
