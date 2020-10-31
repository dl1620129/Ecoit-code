import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Constants } from '../common/constants';
import { Config } from '../model/config.model';

declare const Liferay: any;

@Injectable({
    providedIn: 'root'
})export class ConfigService {

    private accessToken = '';
    constructor(private http: HttpClient) { };
    private handleError(error : HttpErrorResponse) {
        if (error.error instanceof ErrorEvent) {
            // A client-side or network error occurred. Handle it accordingly.
            console.error('An error occurred:', error.error.message);
          } else {
            // The backend returned an unsuccessful response code.
            // The response body may contain clues as to what went wrong,
            console.error(
              `Backend returned code ${error.status}, ` +
              `body was: ${error.error}`);
          }
          // return an observable with a user-facing error message
          return throwError(
            'Something bad happened; please try again later.');
    };

    public getConfig() {
        let url = Constants.baseUrl + '/o/cmsconfig/app/get-config/' + Constants.portletId;
        return this.http.get(url).pipe(catchError(this.handleError));
    }

    public submitConfig(currentConfig: Config) {    
        let createBody = new FormData();
        createBody.append("categoryId", currentConfig.categoryId.toString());
        let createUrl = Constants.baseUrl + '/o/cmsconfig/app/update/config/' + Constants.userId + '/' + currentConfig.portletId;
        return this.http.put(createUrl, createBody).pipe(catchError(this.handleError));
    }
}
