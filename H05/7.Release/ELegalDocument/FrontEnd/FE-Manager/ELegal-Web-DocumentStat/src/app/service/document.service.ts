import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, tap } from 'rxjs/operators';
import { Constants } from '../common/constants';
import { CommonService } from './common.service';

@Injectable({
  providedIn: 'root'
})export class DocumentService {
    constructor(private http: HttpClient) {}

    public getDocumentsStat() {
        let getUrl = Constants.baseUrl + '/o/elegal/app/doc/get/statistic';
        return this.http.get(getUrl).pipe(catchError(CommonService.handleError));
    }
}