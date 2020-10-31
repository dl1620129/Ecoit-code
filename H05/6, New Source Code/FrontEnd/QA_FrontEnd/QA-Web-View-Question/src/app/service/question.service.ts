import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import{ Constants } from '../common/constants';
import { Category } from '../model/category.model';

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
    
    public convertTreeList(treeList: Category[], level: number) {
        let newCategoriesList = new Array();
        treeList.forEach((element: Category) => {
            let newTitle = '';
            for(let i = 0; i < level; i++) {
                newTitle += '\u00A0\u00A0\u00A0';
            }
            newTitle += element.name;
            let newElement = element;
            newElement.name = newTitle;
            newCategoriesList.push(newElement);

            let childList = this.convertTreeList(element.child, level+1);
            childList.forEach((childElement: Category) => {
                newCategoriesList.push(childElement);
            });
        });
        return newCategoriesList;
    }

    public getCategory() {
        let url = Constants.baseUrl + '/o/qacategory/app/getall-category/' + Constants.scopeGroupId;
        return this.http.get(url).pipe(catchError(this.handleError));
    }

    public submitQuestion(questionForm: any, attachmentsList: File[]) {
        let body = new FormData();
        body.append("name", questionForm.get('name').value);
        body.append("email", questionForm.get('email').value);
        body.append("content", questionForm.get('content').value);
        body.append("phoneNumber", questionForm.get('phoneNumber').value);
        body.append("address", questionForm.get('address').value);
        body.append("categoryId", questionForm.get('categoryId').value);
        body.append("title", questionForm.get('title').value);
        for (let i = 0; i < attachmentsList.length; i++) {
            if (attachmentsList[i]) {
                //atttachmentFiles.push(element.file);
                body.append('attachments', attachmentsList[i]);
            }
        }
        console.log(body);

        let createUrl = Constants.baseUrl + '/o/qaquestion/app/create-question/' + Constants.scopeGroupId + '/' + Constants.userId + '/' + Constants.languageId;
        return this.http.post(createUrl, body).pipe(catchError(this.handleError));
    }

}
