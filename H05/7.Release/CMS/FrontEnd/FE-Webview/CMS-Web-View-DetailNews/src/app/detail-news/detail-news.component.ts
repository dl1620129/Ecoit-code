import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { NewsService } from '../service/news.service';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { Constants } from '../common/constants';
import { NewsArticle } from '../model/NewsArticle';
import { NewsComment } from '../model/NewsComment';
import { Category } from '../model/Category';
import { URLConstants } from '../common/URLConstants';
import { CaptchaService } from '../service/captcha.service';

declare const Liferay: any;
declare const $: any;

@Component({
    selector: 'app-detail-news',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + 
    '/o/CMS-Web-View-DetailNews/app/detail-news.component.html',
    styleUrls: [],
    providers: [],
}) export class DetailNewsComponent implements OnInit {
    public urlWebSite= Liferay.ThemeDisplay.getLayoutRelativeURL();
    captchaImg = Constants.baseUrl + '/o/captcha/app/get-captcha';

	isPrint = false;
    commentForm = this.fb.group({
        email: ['', [Validators.required, Validators.email]],
        name: ['', Validators.required],
        content: ['', Validators.required],
        captchaText: ['']
    });
   
    get HOME_URL() {
        return URLConstants.HOME_URL;
    }

    get ARTICLE_URL() {
        return Constants.baseUrl + this.urlWebSite.substring(0,this.urlWebSite.lastIndexOf('/'))+ URLConstants.ARTICLE_URL;
    }

    get CATEGORY_URL() {
        return URLConstants.CATEGORY_URL;
    }

    get name() {
        return this.commentForm.get('name');
    };

    get email() {
        return this.commentForm.get('email');
    };

    get content() {
        return this.commentForm.get('content');
    };

    get CURRENT_URL() {
        return URLConstants.CURRENT_URL;
    }
    
    previousURL: string = Constants.baseUrl;
    commentsListSize = 0;
    constructor (private newsService: NewsService, private fb: FormBuilder, private captchaService: CaptchaService){};

    category: Category;
    detailNews: NewsArticle;
    responseComment: NewsComment = null;
    ngOnInit() {
        let queryData = this.getQueryString();
        if (queryData['typeArtId'] && queryData['urlTitle']) {
            this.getDetailContent(queryData['typeArtId'], queryData['urlTitle'], queryData['categoryId']);
        }

        if (queryData['previousURL']) {
            this.previousURL += queryData['previousURL'];
        }
    }
    
    getCaptcha() {
        let currentTime = new Date();
        this.captchaImg = Constants.baseUrl + '/o/captcha/app/get-captcha' + '?' + currentTime.getTime();
    }

    submitComment() {
        this.captchaService.submitCaptcha(this.commentForm).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE && response.data == true) {
                this.newsService.submitComment(this.commentForm, this.detailNews.articleId, this.responseComment).subscribe((submitResponse: any) => {
                    console.log(submitResponse);
                    if (submitResponse.error_code == Constants.SUCCESSFUL_CODE) {
                        //this.getDetailContent(this.detailNews.articleId, this.detailNews.friendlyURL, this.category.id);
                        alert("Bình luận của bạn đã được gửi thành công.");
                        this.commentForm.reset();
                    } 
                });
            } else {
                alert("Xin bạn nhập lại mã captcha.");
            }
            this.getCaptcha();
        });

    }

    getDetailContent(articleId: any, urlTitle: any, categoryId: any) {
        this.newsService.getDetailNews(articleId, urlTitle, categoryId).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.detailNews = response.data.baiViet;
                if (response.data.category) {
                    this.category = response.data.category;
                }
                if (this.detailNews.comment) {
                    this.commentsListSize = this.detailNews.comment.parentCommentList.length + this.detailNews.comment.childCommentList.length;
                }
            }
        });
    }

    addResponseComment(comment: NewsComment, event: any) {
        event.preventDefault();
        this.responseComment = comment;
    }


    removeResponseComment() {
        this.responseComment = null;
    }

    getQueryString() {
        let hashMap = {};
        let queries = Liferay.currentURL.slice(Liferay.currentURL.indexOf('?') + 1).split('&');
        for (let i = 0; i < queries.length; i++) {
            let hash = queries[i].split('=');
            hashMap[hash[0]] = hash[1];
        }
        console.log(hashMap);
        return hashMap;
    }

    fontSizeReduce(content: any) {
        let fontSize = $(content).css('font-size');
        let currentSize = parseInt(fontSize);
        if (currentSize >= 8) {
            currentSize -= 1;
        }
        $(content).css('font-size', currentSize + 'px');
    }

    fontSizeIncrease(content: any) {
        let fontSize = $(content).css('font-size');
        let currentSize = parseInt(fontSize);
        if (currentSize <= 40) {
            currentSize += 1;
        }
        $(content).css('font-size', currentSize + 'px');
    }

    @ViewChild('printDoc') printDoc: ElementRef;
    printNews() {
        let restorePage = $('body').html();
        let printContent = $(this.printDoc.nativeElement).clone();
        $('body').empty().html(printContent);
        window.print();
        $('body').html(restorePage);
        console.log(this.printDoc.nativeElement);
    }
}