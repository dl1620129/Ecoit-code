import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import{ Constants } from '../common/constants';

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
    
    public getAllNews(categoryId : number) {
        let url = Constants.baseUrl + '/o/news/app/list-new-by-category/getall/' + Constants.scopeGroupId + '?listCategoryId=' + categoryId + '&limit=' + Constants.DISPLAY_LIMIT;
        return this.http.get(url).pipe(catchError(this.handleError));
    }

    public getFeaturedNews() {
        let url = Constants.baseUrl + '/o/news/app/featured-new/get-all/' + Constants.languageId + '/' + Constants.scopeGroupId;
        console.log(url);
        return this.http.get(url).pipe(catchError(this.handleError));
    }

    public getAllCategories(parentId: number) {
        let url = Constants.baseUrl + '/o/news/app/detail/getall/category?parentId=' + parentId;
        console.log(url);
        return this.http.get(url).pipe(catchError(this.handleError));
    }

    public checkAdmin() {
        let url = Constants.baseUrl + '/o/news/app/featured-new/check/admin/' + Constants.companyId + '/' + Constants.userId;
        return this.http.get(url).pipe(catchError(this.handleError));
    }
}
