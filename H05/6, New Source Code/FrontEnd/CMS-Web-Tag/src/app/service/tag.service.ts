import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import{ Constants } from '../common/constants';

@Injectable({
    providedIn: 'root'
})export class TagService {

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
    
    public getAllTags(start: number, pageSize: number, searchKey: string) {
        let url = Constants.baseUrl + '/o/tag/app/getall/' + Constants.scopeGroupId + '/' + Constants.languageId + '?start=' + start + '&limit=' + pageSize + '&q=' + searchKey;
        return this.http.get(url).pipe(catchError(this.handleError));
    }

    public getTag(id: number) {
        let url = Constants.baseUrl + '/o/tag/app/get/item/' +  Constants.scopeGroupId + '/' + Constants.languageId + '/' + id;
        return this.http.get(url).pipe(catchError(this.handleError));
    }

    public deleteTag(id: number) {
        let url = Constants.baseUrl + '/o/tag/app/delete/' + id;
        return this.http.delete(url).pipe(catchError(this.handleError));
    }

    public submitTag(form: any, id: any) {
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });

        let body = {
            'name': form.get('name').value,
            'description': form.get('description').value
        };

        console.log(body);
        if (id) {  
            let updateUrl = Constants.baseUrl + '/o/tag/app/update/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + id;
            console.log(updateUrl);
            return this.http.put(updateUrl, body, {headers: headers}).pipe(catchError(this.handleError));
        }

        let createUrl = Constants.baseUrl + '/o/tag/app/create/' + Constants.scopeGroupId + '/' + Constants.languageId;
        return this.http.post(createUrl, body, {headers: headers}).pipe(catchError(this.handleError));
    }
}
