import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Constants } from '../common/constants';

declare const Liferay: any;

@Injectable({
    providedIn: 'root'
})export class CategoryService {

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
    
    public getCategoriesList(start: number, pageSize: number, searchKey: string) {
        let url = Constants.baseUrl + '/o/qacategory/app/getall/' + Constants.scopeGroupId + '?start=' + start + '&limit=' + pageSize + '&q=' + searchKey;
        return this.http.get(url).pipe(catchError(this.handleError));
    }

    public getCategory(id: number) {
        let url = Constants.baseUrl + '/o/qacategory/app/get/item/' + id;
        return this.http.get(url).pipe(catchError(this.handleError));
    }

    public deleteCategory(categoryIdList: number[]) {
        let body = new FormData();
        categoryIdList.forEach((element: number) => {
            body.append('categoryId', element.toString());
        });
        let url = Constants.baseUrl + '/o/qacategory/app/delete/' + Constants.scopeGroupId + '/' + Constants.userId;
        console.log(url);
        return this.http.post(url, body).pipe(catchError(this.handleError));
    }

    public submitCategory(form: any, id: any) {
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });

        let body = {
            'name': form.get('name').value,
            'description': form.get('description').value,
            'position': form.get('position').value,
            'parentId': form.get('parentId').value
        };

        if (id) {
            let updateUrl = Constants.baseUrl + '/o/qacategory/app/update/' + Constants.scopeGroupId + '/' + Constants.userId + '/' + Constants.companyId + '/' + id;
            return this.http.put(updateUrl, body, {headers: headers}).pipe(catchError(this.handleError));
        }

        console.log(body);
        let createUrl = Constants.baseUrl + '/o/qacategory/app/create/' + Constants.scopeGroupId + '/' + Constants.userId + '/' + Constants.companyId;
        return this.http.post(createUrl, body, {headers: headers}).pipe(catchError(this.handleError));
    }

    public getPosition(parentId: any) {
        let url = Constants.baseUrl + '/o/qacategory/app/get/max-order-number/' + Constants.scopeGroupId  + '/' + Constants.companyId + '/' + parentId;
        return this.http.get(url).pipe(catchError(this.handleError));
    }
}
