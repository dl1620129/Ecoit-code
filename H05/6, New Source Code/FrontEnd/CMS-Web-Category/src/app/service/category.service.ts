import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Constants } from '../common/constants';
import { Category } from '../class/category';

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
    
    public getAllCategories(start: number, pageSize: number, searchKey: string) {
        let url = Constants.baseUrl + '/o/category/app/getall/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '?start=' + start + '&limit=' + pageSize + '&q=' + searchKey;   
        return this.http.get(url).pipe(catchError(this.handleError));
    }

    public getCategory(id: number) {
        let url = Constants.baseUrl + '/o/category/app/get/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '/' + id;
        return this.http.get<Category>(url).pipe(catchError(this.handleError));
    }

    public deleteCategory(id: number) {
        let url = Constants.baseUrl + '/o/category/app/delete/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '/' + id;
        console.log(url);
        return this.http.delete(url).pipe(catchError(this.handleError));
    }

    public submitCategory(form: any, id: any) {
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });
        if (id) {
            let updateBody = {
                'categoryId': id,
                'title': form.get('title').value,
                'description': form.get('description').value,
                'thutu': form.get('orderNumber').value,
                'link': form.get('link').value
            };
            console.log(updateBody);
            let updateUrl = Constants.baseUrl + '/o/category/app/update/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '/' + form.get('parentId').value;
            return this.http.put(updateUrl, updateBody, {headers: headers}).pipe(catchError(this.handleError));
        }

        
        let createBody = {
            'title': form.get('title').value,
            'description': form.get('description').value,
            'thutu': form.get('orderNumber').value,
            'link': form.get('link').value
        };
        console.log(createBody);
        let createUrl = Constants.baseUrl + '/o/category/app/create/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '/' + form.get('parentId').value;
        return this.http.post(createUrl, createBody, {headers: headers}).pipe(catchError(this.handleError));
    }

    public getMaxOrderNumber(parentId: any) {
        let url = Constants.baseUrl + '/o/category/app/get/max-order-number/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '/' + parentId;
        return this.http.get(url).pipe(catchError(this.handleError));
    }
}
