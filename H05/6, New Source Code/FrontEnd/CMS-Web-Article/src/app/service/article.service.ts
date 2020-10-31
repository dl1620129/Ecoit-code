import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable, Inject, LOCALE_ID } from '@angular/core';
import { catchError, tap } from 'rxjs/operators';
import { Article } from '../class/article';
import { CommonService } from './common.service';
import { Constants } from '../common/constants';
import { formatDate } from '@angular/common';
import { FocusMonitor } from '@angular/cdk/a11y';
import { DomSanitizer } from '@angular/platform-browser';
import { ArticleComment } from '../class/comment';

declare const Liferay: any;

@Injectable({
  providedIn: 'root'
})export class ArticleService {
    constructor(private http: HttpClient,
        @Inject(LOCALE_ID) private locale: string,
        private sanitizer: DomSanitizer) {}

    /*public getFakeField() {
        let url = Liferay.ThemeDisplay.getPortalURL() + '/o/oauth2/token';
        let headers = new HttpHeaders({
          'Content-Type': 'application/x-www-form-urlencoded',
        });

        let body = new URLSearchParams();
        body.append('client_id', Liferay.ThemeDisplay.getUserId());
        body.append('grant_type', 'client_credentials');
        body.append('client_secret', 'secret-68bea224-4d74-b83c-2bf6-bc6e6dbe5bb');
          
        let temp = this.http.post(url, body.toString(), {headers: headers}).pipe(
          catchError(CommonService.handleError));
        console.log(url);
        console.log(temp);
        console.log('call proxy API');
        return temp;
    }*/

    public getFilteredArticle(searchForm: any, start: number, pageSize: number) {
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });

        let formattedDateFrom = 0;
        if (searchForm.get('fromDate').value != null && searchForm.get('fromDate').value != '') {
            formattedDateFrom = searchForm.get('fromDate').value.getTime();
        }
        let formattedDateTo = 0;
        if (searchForm.get('toDate').value != null && searchForm.get('toDate').value != '') {
            formattedDateTo = searchForm.get('toDate').value.getTime();
        }

        let body = {
            'categoryId': searchForm.get('categoryId').value,
            'inTitle': searchForm.get('inTitle').value,
            'eventNames': searchForm.get('eventNames').value,
            'tagNames': searchForm.get('tagNames').value,
            'inSummary': searchForm.get('inSummary').value,
            'inContent': searchForm.get('inContent').value,
            'inDate': searchForm.get('inDate').value,
            'fromDate': formattedDateFrom,
            'toDate': formattedDateTo,
            'inAuthor': searchForm.get('inAuthor').value,
            'userKiemDuyet': searchForm.get('userKiemDuyet').value
        };
        console.log(body);

        let createUrl = Constants.baseUrl + '/o/article/app/get-by-config/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '/' + Constants.CONFIGURATION + '?start=' + start + '&limit=' + pageSize + '&q=' + searchForm.get('searchKey').value;
        return this.http.post(createUrl, body, {headers: headers}).pipe(catchError(CommonService.handleError));
    }

    public getSourceInvolveArticle(title: any, source: any, limit: number) {
        let getUrl = Constants.baseUrl + '/o/article/app/get/article-involve-source/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '?title=' + title + '&source=' + source + '&limit=' + limit;
        return this.http.get(getUrl).pipe(catchError(CommonService.handleError));
    }

    public getArticle(id: any){
        let getUrl = Constants.baseUrl + '/o/article/app/get/article/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '/' + id + '/' + Constants.CONFIGURATION;
        return this.http.get(getUrl).pipe(catchError(CommonService.handleError));
    }

    public getSubsites(){
        let getUrl = Constants.baseUrl + '/o/article/app/get-sub-site/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId;
        return this.http.get(getUrl).pipe(catchError(CommonService.handleError));
    }

    public convertArticleResponse(responseData: any) {
        //convert involves to correct format

        let newTags = new Array();
        if (responseData.tags) {
            newTags = responseData.tags
        }

        let newEvents = new Array();
        if (responseData.events) {
            newEvents = responseData.events;
        }

        let newUsers = new Array();
        if (responseData.humanAccesses) {
            newUsers = responseData.humanAccesses;
        }

        let newInvolves = new Array();
        if (responseData.involveArt) {
            responseData.involveArt.forEach((element: any) => {
                let newItem = {};
                newItem['id'] = element.id;
                newItem['title'] = element.name;
                newInvolves.push(newItem);
            });
        }

        let newCategories = new Array();
        if (responseData.categories) {
            responseData.categories.forEach((element: any) => {
                let newItem = {};
                newItem['id'] = element.id;
                newItem['name'] = element.name;
                newItem['checked'] = true;
                newCategories.push(newItem);
            });
        }

        let henGio = false;
        let reserveDate = null;
        if (responseData.henGio) {
            henGio = responseData.henGio;
            reserveDate = new Date(responseData.publishedDateFrom);
        }

        let isNeverExpire = true;
        let startDate = null;
        let endDate = null;
        if (responseData.publishedDateFrom && responseData.publishedDateTo) {
            isNeverExpire = false;
            startDate = new Date(responseData.publishedDateFrom);
            endDate = new Date(responseData.publishedDateTo);
        } 

        let newCommentData = {
            "parentCommentList": new Array(),
            "childCommentList": new Array()
        }
        if (responseData.comment) {
            let newParentList = new Array();
            responseData.comment.parentCommentList.forEach((element: any) => {
                let parentComment = new ArticleComment();
                parentComment.parentId = element.parentId;
                parentComment.commentId = element.commentId;
                parentComment.username = element.username;
                parentComment.content = element.content;
                parentComment.createdDate = new Date(element.createdDate);
                parentComment.approved = element.approved;
                parentComment.likes = element.likes;
                newParentList.push(parentComment);
            });
            newCommentData.parentCommentList = newParentList;

            let newChildList = new Array();
            responseData.comment.childCommentList.forEach((element: any) => {
                let childComment = new ArticleComment();
                childComment.parentId = element.parentId;
                childComment.commentId = element.commentId;
                childComment.username = element.username;
                childComment.content = element.content;
                childComment.createdDate = new Date(element.createdDate);
                childComment.approved = element.approved;
                childComment.likes = element.likes;
                newChildList.push(childComment);
            });
            newCommentData.childCommentList = newChildList;
        }
        let detailArticle = new Article(responseData.articleId, responseData.title, responseData.summary, 
            responseData.content, responseData.imageTitle, responseData.author, responseData.source,
            null, newCategories, responseData.subsite, newInvolves, responseData.allowComent, responseData.isNoiBat, 
            responseData.isHomePage, responseData.thuTu.toString(), newUsers, newTags, newEvents, henGio, reserveDate, isNeverExpire,
            startDate, endDate, responseData.UserPermissison, newCommentData);
        return detailArticle;
    }

    //delete article
    public deleteArticle(id: number) {
        let url = Constants.baseUrl + '/o/article/app/delete/article/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '/' + id;
        return this.http.delete(url).pipe(catchError(CommonService.handleError));
    }

    //delete image
    public deleteImage(articleId: number, imageId: number) {
        let url = Constants.baseUrl + '/o/article/app/delete/image/' + articleId + '/' + imageId;
        return this.http.delete(url).pipe(catchError(CommonService.handleError));
    }

    public pendingArticle(articleId: any) {
        let getUrl = Constants.baseUrl + '/o/article/app/pending-article/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '/' + articleId + '?content=pending-article';
        return this.http.get(getUrl).pipe(catchError(CommonService.handleError));
    }

    public approveArticle(articleId: any) {
        let getUrl = Constants.baseUrl + '/o/article/app/approved-article/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '/' + articleId;
        return this.http.get(getUrl).pipe(catchError(CommonService.handleError));
    }

    public publishArticle(articleId: any) {
        let getUrl = Constants.baseUrl + '/o/article/app/publish-article/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '/' + articleId;
        return this.http.get(getUrl).pipe(catchError(CommonService.handleError));
    }

    public denyApprovedArticle(articleId: any) {
        let getUrl = Constants.baseUrl + '/o/article/app/denied-approve-article/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '/' + articleId;
        return this.http.get(getUrl).pipe(catchError(CommonService.handleError));
    }

    public denyPublishedArticle(articleId: any) {
        let getUrl = Constants.baseUrl + '/o/article/app/denied-publish-article/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '/' + articleId + '?content=denied-publish-article';
        return this.http.get(getUrl).pipe(catchError(CommonService.handleError));
    }

    public submitArticleForm(form: Article, id: any, action: number) {

        let body = new FormData();
        body.append('title', form.title.trim());
        body.append('summary', form.summary.trim());
        body.append('content', form.content);
        body.append('imageDes', form.imageDes);
        body.append('author', form.author.trim());
        body.append('source', form.source.trim());
        body.append('images', form.images);
        body.append('category', JSON.stringify(form.category));
        body.append('site', JSON.stringify(form.site));
        body.append('involve', JSON.stringify(form.involve));
        body.append('isComment', JSON.stringify(form.isComment));
        body.append('isNoiBat', JSON.stringify(form.isNoibat));
        body.append('homePage', JSON.stringify(form.homePage));
        body.append('orderShowHomePage', form.orderShowHomePage);
        body.append('humanAccessArticle', JSON.stringify(form.humanAccessArticle));
        body.append('tags', JSON.stringify(form.tags));
        body.append('events', JSON.stringify(form.events));
        body.append('henGio', JSON.stringify(form.henGio));
        if (form.henGio) {
            let formattedDate = formatDate(form.thoiGianHenGio, 'dd/MM/yyyy HH:ss', this.locale);
            body.append('thoiGianHenGio', formattedDate);
        }
        body.append('action', JSON.stringify(action));
        body.append('never-expire', form.neverExpire.toString());
        if (!form.neverExpire && form.publishedDateFrom !== '' && form.publishedDateTo !== '') {
            let formattedDateFrom = formatDate(form.publishedDateFrom, 'yyyy/MM/dd HH:ss', this.locale);
            body.append('date_from', formattedDateFrom);
            let formattedDateTo = formatDate(form.publishedDateTo, 'yyyy/MM/dd HH:ss', this.locale);
            body.append('date_to', formattedDateTo);
        }

        if (id) {
            let updateUrl = Constants.baseUrl + '/o/article/app/update/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '?articleId=' + id;
            console.log(updateUrl);
            return this.http.post(updateUrl, body).pipe(catchError(CommonService.handleError));
        }

        let createUrl = Constants.baseUrl + '/o/article/app/update/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId;
        console.log(createUrl);
        return this.http.post(createUrl, body).pipe(catchError(CommonService.handleError));
    }
}