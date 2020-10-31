import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';

declare const Liferay: any;

@Injectable({
  providedIn: 'root'
})export class CommonService {
    constructor(private http: HttpClient) {}

    public static handleError(error : HttpErrorResponse) {
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

    public parseXmlList(sitesList: any[]): any[] {
        let newList = new Array();
        let parser = new DOMParser();
        if (sitesList.length > 0) {
            sitesList.forEach((element: any) => {
                let newElement = {};
                newElement['checked'] = element.checked;
                newElement['id'] = element.id;
                let domElement = parser.parseFromString(element.name, 'text/xml');
                if (domElement.children && domElement.children.length > 0
                    && domElement.children[0].children.length > 0) {
                        newElement['name'] = domElement.children[0].children[0].textContent;
                }
                newList.push(newElement);
            });
        }
        return newList;
    }
}