import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { Constants } from '../common/constants';
import { CommonService } from './common.service';

declare const Liferay: any;

@Injectable({
    providedIn: 'root'
})export class CommentService {

    constructor(private http: HttpClient) { };
    
    public approvedComment(id: any) {
        let url = Constants.baseUrl + '/o/article/app/comment/approve/' + Constants.scopeGroupId + '/' + id;   
        return this.http.get(url).pipe(catchError(CommonService.handleError));
    }

    public deleteComment(id: any) {
        let url = Constants.baseUrl + '/o/article/app/comment/delete/' + id;   
        return this.http.delete(url).pipe(catchError(CommonService.handleError));
    }
}
