import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Constants } from '../common/constants';
import { Category } from '../class/category';

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
    
    public getAllConfig(start: number, pageSize: number, searchKey: string) {
        let url = Constants.baseUrl + '/o/cmsconfig/app/getall/' + Constants.userId + '?start=' + start + '&limit=' + pageSize + '&q=' + searchKey;   
        return this.http.get(url).pipe(catchError(this.handleError));
    }

    public getConfig(id: number) {
        let url = Constants.baseUrl + '/o/cmsconfig/app/get-config/' + id;
        return this.http.get<Category>(url).pipe(catchError(this.handleError));
    }

    public deleteConfig(id: number) {
        let url = Constants.baseUrl + '/o/cmsconfig/app/delete/config/' + Constants.userId + '/' + id;
        console.log(url);
        return this.http.delete(url).pipe(catchError(this.handleError));
    }

    public submitConfig(categoryId: any, id: any) {    
        let createBody = new FormData();
        createBody.append("categoryId", categoryId.toString());
        let createUrl = Constants.baseUrl + '/o/cmsconfig/app/update/config/' + Constants.userId + '/' + id;
        return this.http.put(createUrl, createBody).pipe(catchError(this.handleError));
    }
}
