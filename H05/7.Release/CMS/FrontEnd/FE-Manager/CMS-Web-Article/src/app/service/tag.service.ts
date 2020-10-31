import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/operators';
import{ Constants } from '../common/constants';
import { CommonService } from './common.service';

@Injectable({
    providedIn: 'root'
})export class TagService {

    constructor(private http: HttpClient) { };
    
    public getFilteredTags(start: number, pageSize: number, searchKey: string) {
        let url = Constants.baseUrl + '/o/tag/app/getall/' + Constants.scopeGroupId + '/' + Constants.languageId + '?start=' + start + '&limit=' + pageSize + '&q=' + searchKey;
        return this.http.get(url).pipe(catchError(CommonService.handleError));
    }
}
