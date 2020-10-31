import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import{ Constants } from '../common/constants';

@Injectable({
    providedIn: 'root'
})export class CaptchaService {

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

    public getCaptcha() {
        let createUrl = Constants.baseUrl + '/o/captcha/app/get-captcha';
        return this.http.get(createUrl).pipe(catchError(this.handleError));
    }

    public submitCaptcha(questionForm: any) {
        let body = new FormData();
        body.append("captchaText", questionForm.get('captchaText').value);
        console.log(questionForm.get('captchaText').value);

        let createUrl = Constants.baseUrl + '/o/captcha/app/validate-captcha';
        return this.http.post(createUrl, body).pipe(catchError(this.handleError));
    }

}
