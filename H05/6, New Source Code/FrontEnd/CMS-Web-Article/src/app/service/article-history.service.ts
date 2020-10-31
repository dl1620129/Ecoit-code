import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, tap } from 'rxjs/operators';
import { CommonService } from './common.service';
import { Constants } from '../common/constants';

@Injectable({
  providedIn: 'root'
})export class ArticleHistoryService {
    constructor(private http: HttpClient) {}

    public getArticleHistoriesList(start: number, pageSize: number, articleId: any) {
        let getUrl = Constants.baseUrl + '/o/article/app/history/getall/' + Constants.languageId + '/' + articleId +  '?start=' + start + '&limit=' + pageSize;
        return this.http.get(getUrl).pipe(catchError(CommonService.handleError));
    }


    public getArticleHistory(id: any){
        let getUrl = Constants.baseUrl + '/o/article/app/history/get-detail/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '?articleHistoryId=' + id;
        return this.http.get(getUrl).pipe(catchError(CommonService.handleError));
    }

    public deleteArticleHistory(id: number) {
        let url = Constants.baseUrl + '/o/article/app/history/delete/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '/' + id;
        return this.http.delete(url).pipe(catchError(CommonService.handleError));
    }
    
    public reviveArticleHistory(historyId: any, articleId: any) {
        let reviveUrl = Constants.baseUrl + '/o/article/app/history/get-detail/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '?action=revive&historyId=' + historyId + '&articleId=' + articleId;
        return this.http.get(reviveUrl).pipe(catchError(CommonService.handleError));
    }
}