import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import{ Constants } from '../common/constants';
import { Category } from '../model/Category';

@Injectable({
    providedIn: 'root'
})export class EventService {

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

    getAllEvent() {
        let url = Constants.baseUrl + '/o/news/app/search-new/get-event/' + Constants.languageId;
        return this.http.get(url).pipe(catchError(this.handleError));
    }
}
