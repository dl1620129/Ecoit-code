import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import{ Constants } from '../common/constants';

@Injectable({
    providedIn: 'root'
})export class SignerService {

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
    
    public getSignersList(start: number, pageSize: number, searchKey: string) {
        let url = Constants.baseUrl + '/o/legalsigner/app/getall/' + Constants.scopeGroupId + '/' + Constants.companyId + '?start=' + start + '&limit=' + pageSize + '&q=' + searchKey;
        return this.http.get(url).pipe(catchError(this.handleError));
    }

    public getSigner(id: number) {
        let url = Constants.baseUrl + '/o/legalsigner/app/get/item/' + id;
        return this.http.get(url).pipe(catchError(this.handleError));
    }

    public deleteSigner(sigIdList: number[]) {
        let body = new FormData();
        sigIdList.forEach((element: number) => {
            body.append('sigId', element.toString());
        });
        let url = Constants.baseUrl + '/o/legalsigner/app/delete/'+  Constants.userId + '/' + Constants.scopeGroupId;
        return this.http.post(url, body).pipe(catchError(this.handleError));
    }

    public submitField(form: any, id: any) {
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });

        let body = {
            'firstName': form.get('firstName').value,
            'lastName': form.get('lastName').value,
            'language': form.get('language').value
        };

        console.log(body);
        if (id) {  
            let updateUrl = Constants.baseUrl + '/o/legalsigner/app/update/' + Constants.userId + '/' + Constants.scopeGroupId + '/' + Constants.companyId + '/' + id;
            console.log(updateUrl);
            return this.http.put(updateUrl, body, {headers: headers}).pipe(catchError(this.handleError));
        }

        let createUrl = Constants.baseUrl + '/o/legalsigner/app/create/' +  Constants.userId + '/' + Constants.scopeGroupId + '/' + Constants.companyId;
        return this.http.post(createUrl, body, {headers: headers}).pipe(catchError(this.handleError));
    }

    public getLanguagesList() {
        let url = Constants.baseUrl + '/o/legalsigner/app/get/' +  Constants.scopeGroupId + '/language-list';
        return this.http.get(url).pipe(catchError(this.handleError));
    }
}
