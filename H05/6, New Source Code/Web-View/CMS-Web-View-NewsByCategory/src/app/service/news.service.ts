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

    public getPageNews(searchForm: any, start: number, limit: number, mainCategoryId: number) {
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });

        let formattedDateFrom = null;
        if (searchForm.get('fromDate').value != null && searchForm.get('fromDate').value != '') {
            formattedDateFrom = searchForm.get('fromDate').value.getTime();
        }
        let formattedDateTo = null;
        if (searchForm.get('toDate').value != null && searchForm.get('toDate').value != '') {
            formattedDateTo = searchForm.get('toDate').value.getTime();
        }

        let categoryIdsList = [];
        if (mainCategoryId > 0) {
            categoryIdsList.push(mainCategoryId);
        }
        categoryIdsList.push(parseInt(searchForm.get('categoryId').value));

        let body = {
            'tags': searchForm.get('tag').value,
            'keyword': searchForm.get('searchKey').value,
            'fromDate': formattedDateFrom,
            'toDate': formattedDateTo,
            'categoryIds': categoryIdsList,
            'eventId': searchForm.get('eventId').value
        };
        console.log(body);
        let url = Constants.baseUrl + '/o/news/app/search-new/get-all/' + Constants.languageId + '/' + Constants.scopeGroupId + '?start=' + start + '&limit=' + limit;
        return this.http.post(url, body, {headers: headers}).pipe(catchError(this.handleError));
    }

    public checkAdmin() {
        let url = Constants.baseUrl + '/o/news/app/featured-new/check/admin/' + Constants.companyId + '/' + Constants.userId;
        return this.http.get(url).pipe(catchError(this.handleError));
    }
}
