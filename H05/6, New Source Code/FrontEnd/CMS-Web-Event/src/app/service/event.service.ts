import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import{ Constants } from '../common/constants';

@Injectable({
    providedIn: 'root'
})export class EventService {

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
    
    public getAllEvents(start: number, pageSize: number, searchKey: string) {
        let url = Constants.baseUrl + '/o/event/app/' + Constants.userId + '/' + Constants.scopeGroupId + '/' + Constants.languageId + '/getlist?start=' + start + '&limit=' + pageSize + '&q=' + searchKey;
        return this.http.get(url).pipe(catchError(this.handleError));
    }

    public getEvent(id: number) {
        let url = Constants.baseUrl + '/o/event/app/' + Constants.userId + '/'+  Constants.scopeGroupId + '/get/' + id;
        console.log('Event id: ' + id);
        return this.http.get(url).pipe(catchError(this.handleError));
    }

    public deleteEvent(id: number) {
        let url = Constants.baseUrl + '/o/event/app/' + Constants.userId + '/' + Constants.scopeGroupId + '/delete/' + id;
        return this.http.delete(url).pipe(catchError(this.handleError));
    }

    public submitEvent(form: any, id: any) {
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });

        let body = {
            'eventName': form.get('name').value,
            'description': form.get('description').value,
            'language': Constants.languageId
        };
        console.log(body);
        if (id) {  
            let updateUrl = Constants.baseUrl + '/o/event/app/' + Constants.userId + '/' + Constants.scopeGroupId + '/update/' + id;
            console.log(updateUrl);
            return this.http.put(updateUrl, body, {headers: headers}).pipe(catchError(this.handleError));
        }

        let createUrl = Constants.baseUrl + '/o/event/app/' + Constants.userId + '/' + Constants.scopeGroupId + '/create';
        return this.http.post(createUrl, body, {headers: headers}).pipe(catchError(this.handleError));
    }
}
