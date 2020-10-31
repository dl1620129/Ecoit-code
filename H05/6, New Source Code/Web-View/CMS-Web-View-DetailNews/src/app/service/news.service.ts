import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import{ Constants } from '../common/constants';
import { NewsComment } from '../model/NewsComment';
import { create } from 'domain';

@Injectable({
    providedIn: 'root'
})export class NewsService {

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
    
    public getDetailNews(articleId: any, friendlyURL: any, categoryId: number) {
        if (!categoryId || categoryId < 0) {
            categoryId = -1;
        }
        let url = Constants.baseUrl + '/o/news/app/detail/get?typeArtId=' + articleId + '&urlTitle=' + friendlyURL + '&categoryId=' + categoryId;
        console.log(url);
        return this.http.get(url).pipe(catchError(this.handleError));
    }

    public submitComment(commentForm: any, newsArticleId: any, responseComment: NewsComment) {
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });

        let body = {
            'name': commentForm.get('name').value,
            'email': commentForm.get('email').value,
            'content': commentForm.get('content').value
        };
        console.log(body);
        if (responseComment !== null) {
            let createUrl = Constants.baseUrl + '/o/news/app/detail/create/comment/' + Constants.scopeGroupId + '/' + newsArticleId + '?action=child&commentId=' + responseComment.commentId;
            console.log(createUrl);
            return this.http.post(createUrl, body, {headers: headers}).pipe(catchError(this.handleError));
        }

        let createUrl = Constants.baseUrl + '/o/news/app/detail/create/comment/' + Constants.scopeGroupId + '/' + newsArticleId;
        return this.http.post(createUrl, body, {headers: headers}).pipe(catchError(this.handleError));
    }

}
