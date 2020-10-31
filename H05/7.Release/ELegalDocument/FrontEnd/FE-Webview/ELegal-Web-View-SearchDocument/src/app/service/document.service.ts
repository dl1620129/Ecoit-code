import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Constants } from '../common/constants';

@Injectable({providedIn: 'root'})
export class DocumentService {
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

    public getFilteredDocument(searchForm: any, isPublic: number) {
      let headers = new HttpHeaders({
          'Content-Type': 'application/json'
      });

      let formattedDateFrom = null;
      if (searchForm.get('fromDate').value !== '' && searchForm.get('fromDate').value !== null) {
          searchForm.get('fromDate').value.setHours(0);
          formattedDateFrom = searchForm.get('fromDate').value.getTime();
      }
      let formattedDateTo = null;
      if (searchForm.get('toDate').value !== '' && searchForm.get('toDate').value !== null) {
          searchForm.get('toDate').value.setHours(23);
          formattedDateTo = searchForm.get('toDate').value.getTime();
      }

      let body = {
          'typeId': searchForm.get('typeId').value,
          'organizationId': searchForm.get('organizationId').value,
          'searchKey': searchForm.get('searchKey').value,
          'symbol': searchForm.get('symbol').value,
          'fieldId': searchForm.get('fieldId').value,
          'fromDate': formattedDateFrom,
          'toDate': formattedDateTo,
          'isPublic': isPublic
      };
      console.log(body);

      let searchUrl = Constants.baseUrl + '/o/elegal/app/doc/search-publish/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.companyId;
      return this.http.post(searchUrl, body, {headers: headers}).pipe(catchError(this.handleError));
  }

}
 