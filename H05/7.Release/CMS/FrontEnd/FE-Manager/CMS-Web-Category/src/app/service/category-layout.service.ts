import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Constants } from '../common/constants';

declare const Liferay: any;

@Injectable({
    providedIn: 'root'
})export class CategoryLayoutService {

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

    public getAllCategoryLayouts() {
        let url = Constants.baseUrl + '/o/categorylayout/app/update/view/' + Constants.scopeGroupId + '/' + Constants.languageId;   
        return this.http.get(url).pipe(catchError(this.handleError));
    }
 
    public getCategoryLayout(categoryId: number) {
        let url = Constants.baseUrl + '/o/categorylayout/app/get/map-layout-by-category/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + categoryId;   
        return this.http.get(url).pipe(catchError(this.handleError));
    }

    public updateCategoryLayout(categoryId: number, layoutId: number, mapCateLayoutId: any) {
        let url = Constants.baseUrl + '/o/categorylayout/app/update/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + categoryId + '/' + layoutId + '/' + Constants.companyId;
        let body = new URLSearchParams();
        if (mapCateLayoutId) {
            body.append('mapCateLayoutId', mapCateLayoutId);
        }
        return this.http.put(url, body).pipe(catchError(this.handleError));
    }
}
