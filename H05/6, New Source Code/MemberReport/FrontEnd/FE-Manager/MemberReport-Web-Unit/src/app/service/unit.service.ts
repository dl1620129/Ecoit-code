import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import{ Constants } from '../common/constants';

@Injectable({
    providedIn: 'root'
})export class UnitService {

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
    
    public getAllUnits(start: number, pageSize: number, searchKey: string) {
        let url = Constants.baseUrl + '/o/memberreport/app/unit/getall/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.companyId + '?start=' + start + '&limit=' + pageSize + '&q=' + searchKey;
        return this.http.get(url).pipe(catchError(this.handleError));
    }

    public getUnit(id: number) {
        let url = Constants.baseUrl + '/o/memberreport/app/unit/get/item/' + id;
        return this.http.get(url).pipe(catchError(this.handleError));
    }

    public deleteUnit(id: number) {
        let url = Constants.baseUrl + '/o/memberreport/app/unit/delete/'+  Constants.userId + '/' + id;
        return this.http.delete(url).pipe(catchError(this.handleError));
    }

    public submitUnit(form: any, id: any) {
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });

        let body = {
            'unitId': id,
            'name': form.get('name').value,
            'description': form.get('description').value
        };

        console.log(body);
        if (id && id > 0) {  
            let updateUrl = Constants.baseUrl + '/o/memberreport/app/unit/update/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' +   Constants.userId + '/' + Constants.companyId;
            console.log(updateUrl);
            return this.http.put(updateUrl, body, {headers: headers}).pipe(catchError(this.handleError));
        }

        let createUrl = Constants.baseUrl + '/o/memberreport/app/unit/create/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' +   Constants.userId + '/' + Constants.companyId;
        return this.http.post(createUrl, body, {headers: headers}).pipe(catchError(this.handleError));
    }
}
