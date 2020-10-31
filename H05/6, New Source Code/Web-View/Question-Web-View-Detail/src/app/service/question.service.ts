import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import{ Constants } from '../common/constants';

@Injectable({
    providedIn: 'root'
})export class QuestionService {

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

    public getQuestion(questionId: any){
        let getUrl = Constants.baseUrl + '/o/qaquestion/app/get-publish/item/' + questionId;
        return this.http.get(getUrl).pipe(catchError(this.handleError));
    }

    public getCategory(){
        let url= Constants.baseUrl + '/o/qacategory/app/getall-category/' + Constants.scopeGroupId;
        return this.http.get(url).pipe(catchError(this.handleError));
    }

    public getQuestionCountView(){
        let url= Constants.baseUrl + '/o/qaquestion/app/get/popular/' + Constants.languageId + '/' + Constants.scopeGroupId + '?limit=5';
        return this.http.get(url).pipe(catchError(this.handleError));
    }
}
