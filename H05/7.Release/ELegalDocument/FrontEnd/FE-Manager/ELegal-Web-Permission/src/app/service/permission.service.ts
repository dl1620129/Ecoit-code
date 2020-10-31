import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, from, throwError } from 'rxjs';
import { PermissionRole } from '../model/PermissionRole.model';
import { catchError } from 'rxjs/operators';
import { Constants } from '../common/Constants';
import LiferayParams from '../../types/LiferayParams'
import { Category } from '../model/Category.model';
import { PermissionObject } from '../model/PermissionObject.model';

declare const Liferay: any;
@Injectable({
    providedIn: 'root',
})


export class PermissionService {
    // url: 'http://118.71.99.245:5000/o/permisstion/app';
    // tokenApi: 'http://118.71.99.245:5000/o/oauth2/token';
    
    params: LiferayParams;
    labels: any;
    accessToken= '';

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

    constructor(private httpClient: HttpClient) {
     }

    getAllPermission(start: number, pageSize:number, searchKey: string ){
        let url = Constants.baseUrl+ '/o/elegal/app/permission/getall/'+ Constants.userId + '/' + Constants.scopeGroupId +'/'+ Constants.languageId +'?limit='+pageSize+'&start='+start+'&q='+searchKey;
        return this.httpClient.get(url).pipe(catchError(this.handleError));
    }

    updateViewPermission(id: any): Observable<any>{
        let url = Constants.baseUrl+ '/o/elegal/app/permission/update/view/'+ Constants.userId + '/' + Constants.scopeGroupId +'/'+ Constants.languageId + '/' + Constants.companyId + '/' + id;
        return this.httpClient.get(url).pipe(catchError(this.handleError));
    }

    savePermission(permissionObject: PermissionObject, permissionGroupId: number) {
        const headers = new HttpHeaders({
            'Content-Type': 'application/json'
            ,'Access-Control-Allow-Origin' : '*'
          });
        let body = JSON.stringify({
            groupName: permissionObject.groupName,
            description: permissionObject.description,
            users: permissionObject.users,
            permissions: permissionObject.permissions,
            categories: permissionObject.categories,
            organizations: permissionObject.organizations,
            fields: permissionObject.fields
        });

        if (permissionGroupId) {
            let updateUrl = Constants.baseUrl + '/o/elegal/app/permission/update/' + Constants.userId + '/' + Constants.scopeGroupId + '/' + permissionGroupId;
            return this.httpClient.put(updateUrl, body, {headers: headers}).pipe(catchError(this.handleError));
        }

        console.log(body);
        let createUrl = Constants.baseUrl + '/o/elegal/app/permission/create/' + Constants.userId + '/' + Constants.scopeGroupId;
        return this.httpClient.post(createUrl, body, {headers: headers}).pipe(catchError(this.handleError));
    }

    deletePermissionGroup(groupUserIdList: number[]) {
        let body = new FormData();
        groupUserIdList.forEach((element: number) => {
            body.append('groupUserId', element.toString());
        });
        let deleteUrl = Constants.baseUrl + '/o/elegal/app/permission/delete/' + Constants.userId + '/' + Constants.scopeGroupId;
        return this.httpClient.post(deleteUrl, body).pipe(catchError(this.handleError));
    }
}