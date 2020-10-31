import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, Inject, LOCALE_ID } from '@angular/core';
import { catchError, tap } from 'rxjs/operators';
import { CommonService } from './common.service';
import { Constants } from '../common/constants';
import { Question } from '../model/question.model';
import { Answer } from '../model/answer.model';
import { AttachmentFile } from '../model/attachFile.model';

declare const Liferay: any;

@Injectable({
  providedIn: 'root'
})export class QuestionService {
    constructor(private http: HttpClient,
        @Inject(LOCALE_ID) private locale: string) {}

    public getFilteredQuestion(searchForm: any, start: number, pageSize: number) {
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });

        let body = {
            'categoryId': searchForm.get('categoryId').value,
            'searchKey': searchForm.get('searchKey').value
        };
        console.log(body);

        let createUrl = Constants.baseUrl + '/o/qaquestion/app/get-by-config/' + Constants.languageId + '/' + Constants.scopeGroupId + '/' +  Constants.userId + '/' +  Constants.CONFIGURATION + '?start=' + start + '&limit=' + pageSize;
        return this.http.post(createUrl, body, {headers: headers}).pipe(catchError(CommonService.handleError));
    }

    public getQuestion(questionId: any){
        let getUrl = Constants.baseUrl + '/o/qaquestion/app/get/item/' + Constants.userId + '/' + questionId;
        return this.http.get(getUrl).pipe(catchError(CommonService.handleError));
    }

    public updateStatus(action: number, questionIdList: number[]) {
        let body = new FormData();
        questionIdList.forEach((element: number) => {
            body.append('questionId', element.toString());
        });
        body.append("action", action.toString());

        let createUrl = Constants.baseUrl + '/o/qaquestion/app/update/status/' + Constants.userId;
        return this.http.post(createUrl, body).pipe(catchError(CommonService.handleError));
    }

    //delete question
    public deleteQuestion(questionIdList: number[]) {
        let body = new FormData();
        questionIdList.forEach((element: number) => {
            body.append('questionId', element.toString());
        });
        let url = Constants.baseUrl + '/o/qaquestion/app/delete/question/' + Constants.userId;
        return this.http.post(url, body).pipe(catchError(CommonService.handleError));
    }

    //delete question attachment
    public deleteQuestionAttachment(questionId: number, attachmentId: number) {
        let url = Constants.baseUrl + '/o/qaquestion/app/delete/question-attachment/' + Constants.userId + '/' + questionId + '/' + attachmentId;
        console.log(url);
        return this.http.delete(url).pipe(catchError(CommonService.handleError));
    }

    //delete answer attachment
    public deleteAnswerAttachment(answerId: number, attachmentId: number) {
        let url = Constants.baseUrl + '/o/qaquestion/app/delete/answer-attachment/' + Constants.userId + '/' + answerId + '/' + attachmentId;
        console.log(url);
        return this.http.delete(url).pipe(catchError(CommonService.handleError));
    }

    public submitQuestion(questionForm: Question, action: number, attachmentsList: AttachmentFile[], answerForm: Answer, answerAttachmentsList: AttachmentFile[]) {
        let body = new FormData();
        body.append("name", questionForm.userName);
        body.append("email", questionForm.email);
        body.append("content", questionForm.content);
        body.append("phoneNumber", questionForm.phoneNumber);
        body.append("address", questionForm.address);
        body.append("categoryId", questionForm.categoryId.toString());
        body.append("title", questionForm.title);
        attachmentsList.forEach((element: AttachmentFile) => {
            if (element.file) {
                //atttachmentFiles.push(element.file);
                body.append('attachments', element.file);
            }
        });
        body.append("action", action.toString());
        answerAttachmentsList.forEach((element: AttachmentFile) => {
            if (element.file) {
                //atttachmentFiles.push(element.file);
                body.append('answerAttachments', element.file);
            }
        });
        body.append("answerContent", answerForm.content);

        let createUrl = Constants.baseUrl + '/o/qaquestion/app/update-question/' + Constants.scopeGroupId + '/' + Constants.userId + '/' + Constants.languageId + '/' + questionForm.questionId;
        return this.http.put(createUrl, body).pipe(catchError(CommonService.handleError));
    }
}