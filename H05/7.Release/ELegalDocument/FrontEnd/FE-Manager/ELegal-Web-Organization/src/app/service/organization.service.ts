import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Constants } from '../common/constants';

declare const Liferay: any;

@Injectable({
    providedIn: 'root'
})export class OrganizationService {

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
    
    public getAllOrganizations(start: number, pageSize: number, searchKey: string) {
        let url = Constants.baseUrl + '/o/elegal/app/organization/getall/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '/' + Constants.companyId + '?start=' + start + '&limit=' + pageSize + '&q=' + searchKey;
        return this.http.get(url).pipe(catchError(this.handleError));
    }

    public getOrganization(id: number) {
        let url = Constants.baseUrl + '/o/elegal/app/organization/get/item/' + id;
        return this.http.get(url).pipe(catchError(this.handleError));
    }

    public deleteOrganization(orgIdList: number[]) {
        let body = new FormData();
        orgIdList.forEach((element: number) => {
            body.append('organizationId', element.toString());
        });
        let url = Constants.baseUrl + '/o/elegal/app/organization/delete/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '/' + Constants.companyId;
        console.log(url);
        return this.http.post(url, body).pipe(catchError(this.handleError));
    }

    public submitOrganization(form: any, id: any) {
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });

        let body = {
            'name': form.get('name').value,
            'description': form.get('description').value,
            'position': form.get('position').value,
            'status': form.get('status').value,
            'parentId': form.get('parentId').value
        };

        if (id) {
            let updateUrl = Constants.baseUrl + '/o/elegal/app/organization/update/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '/' + id;
            return this.http.put(updateUrl, body, {headers: headers}).pipe(catchError(this.handleError));
        }

        console.log(body);
        let createUrl = Constants.baseUrl + '/o/elegal/app/organization/create/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '/' + Constants.companyId;
        return this.http.post(createUrl, body, {headers: headers}).pipe(catchError(this.handleError));
    }

    public getPosition(parentId: any) {
        let url = Constants.baseUrl + '/o/elegal/app/organization/get/max-order-number/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.companyId + '/' + parentId;
        return this.http.get(url).pipe(catchError(this.handleError));
    }
}
