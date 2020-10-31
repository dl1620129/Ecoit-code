import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import{ Constants } from '../common/constants';

@Injectable({
    providedIn: 'root'
})export class AdvertisementService {

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
    
    public getAllAdvertisements(start: number, pageSize: number, searchKey: string) {
        let url = Constants.baseUrl + '/o/adv/app/getall/' + Constants.scopeGroupId + '/' + Constants.languageId + '?start=' + start + '&limit=' + pageSize + '&q=' + searchKey;
        return this.http.get(url).pipe(catchError(this.handleError));
    }

    public getAdvertisement(id: number) {
        let url = Constants.baseUrl + '/o/adv/app/get/item/' +  Constants.scopeGroupId + '/' + id;
        return this.http.get(url).pipe(catchError(this.handleError));
    }

    public deleteAdvertisement(id: number) {
        let url = Constants.baseUrl + '/o/adv/app/delete/' + id;
        return this.http.delete(url).pipe(catchError(this.handleError));
    }

    public submitAdvertisement(form: any, id: any) {

        let body = new FormData();
        body.append('nameAdv', form.get('nameAdv').value);
        body.append('description', form.get('description').value);
        body.append('target', form.get('target').value);
        body.append('url', form.get('url').value);
        body.append('isShow', form.get('isShow').value);
        body.append('imageId', form.get('imageFile').value);

        console.log(body);
        if (id) {  
            let updateUrl = Constants.baseUrl + '/o/adv/app/update/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '?advId=' + id;
            console.log(updateUrl);
            return this.http.post(updateUrl, body).pipe(catchError(this.handleError));
        }

        let createUrl = Constants.baseUrl + '/o/adv/app/update/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId;
        return this.http.post(createUrl, body).pipe(catchError(this.handleError));
    }

    public deleteImage(advertisementId: number, imageId: number) {
        let url = Constants.baseUrl + '/o/adv/app/delete/image/' + advertisementId + '/' + imageId;
        return this.http.delete(url).pipe(catchError(this.handleError));
    }
}
