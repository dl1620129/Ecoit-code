import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import{ Constants } from '../common/constants';

@Injectable({
    providedIn: 'root'
})export class DocumentService {

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
    
    getSelectOptions() {
        let url = Constants.baseUrl + '/o/elegal/app/doc/get/web-view/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.companyId;
        return this.http.get(url).pipe(catchError(this.handleError));
    }
  
    public getPopularDocuments() {
        let url = Constants.baseUrl + '/o/elegal/app/doc/get-popular/' + Constants.scopeGroupId + '/' + Constants.languageId + '?limit=5';
        return this.http.get(url).pipe(catchError(this.handleError));
    }

    public getDocument(documentId: any) {
        let url = Constants.baseUrl + '/o/elegal/app/doc/get/publish/' + Constants.languageId + '/' + documentId;
        return this.http.get(url).pipe(catchError(this.handleError));
    }

    public updateAttachmentView(attachmentId: number) {
        let url = Constants.baseUrl + '/o/elegal/app/doc/update/view/attachment/' + attachmentId;
        return this.http.get(url).pipe(catchError(this.handleError));
    }

    public submitComment(commentForm: any, docId: any) {
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });

        let body = {
            'docId': docId,
            'userName': commentForm.get('name').value,
            'email': commentForm.get('email').value,
            'title': commentForm.get('title').value,
            'content': commentForm.get('content').value
        };
        console.log(body);

        let createUrl = Constants.baseUrl + '/o/elegal/app/suggest-doc/create/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId;
        return this.http.post(createUrl, body, {headers: headers}).pipe(catchError(this.handleError));
    }

}
