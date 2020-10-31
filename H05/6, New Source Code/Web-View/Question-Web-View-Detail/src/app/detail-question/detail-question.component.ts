import { Component, OnInit } from '@angular/core';
import { QuestionService } from '../service/question.service';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { Constants } from '../common/constants';
import { URLConstants } from '../common/URLConstants';
import { Question } from '../model/question.model';
import { Answer } from '../model/answer.model';
import { CategoryModel } from '../model/category.model';

declare const Liferay: any;
declare const $: any;

@Component({
    selector: 'app-detail-question',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + 
    '/o/Question-Web-View-Detail/app/detail-question.component.html',
    styleUrls: [],
    providers: [],
}) export class DetailNewsComponent implements OnInit {
    public urlWebSite= Liferay.ThemeDisplay.getLayoutRelativeURL();

    arrayOne(n: number): any[] {
        return Array(n);
    }

    commentForm = this.fb.group({
        email: ['', [Validators.required, Validators.email]],
        name: ['', Validators.required],
        content: ['', Validators.required],
        captchaText: ['']
    });

    categoryModel: CategoryModel[];
    selectCategory:  CategoryModel[] = new Array();
    questionModelView: Question[];

    question = new Question();
    answer = new Answer();
   
    get HOME_URL() {
        return URLConstants.HOME_URL;
    }

    get HOIDAP_URL() {
        return Constants.baseUrl + this.urlWebSite.substring(0,this.urlWebSite.lastIndexOf('/'))+ URLConstants.HOIDAP_URL;
    }

    get CHI_TIET_PHAN_HOI_URL() {
        return Constants.baseUrl + this.urlWebSite.substring(0,this.urlWebSite.lastIndexOf('/'))+ URLConstants.CHI_TIET_PHAN_HOI_URL;
    }
    constructor (private questionService: QuestionService, private fb: FormBuilder){};

    ngOnInit() {
        let queryData = this.getQueryString();
        if (queryData['questionId']) {
            this.getDetailQuestion(queryData['questionId']);
        }

        this.getCategoryData();
        this.getView();
    }

    getDetailQuestion(questionId: any) {
        this.questionService.getQuestion(questionId).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.question = response.data.question;
                if (response.data.answer) {
                    this.answer = response.data.answer;
                }
            }
        });
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

    getCategoryData(){
        this.questionService.getCategory().subscribe((result: any)=>{
             console.log(result.data);
             this.categoryModel= result.data;
        })
    }

    getView(){
        this.questionService.getQuestionCountView().subscribe((respone: any)=>{
             this.questionModelView= respone.data;
        })
    }

    displayDropDown(event: any) {
        event.preventDefault();
        console.log('testing');
        let isVisible = $(event.currentTarget).data('visible');
        $(event.currentTarget).data('visible', !isVisible);
        if (isVisible) {
            //switch to plus
            $(event.currentTarget).html('<i class="fa fa-chevron-right" aria-hidden="true"></i>');
        } else {
            //switch to minus
            $(event.currentTarget).html('<i class="fa fa-chevron-down" aria-hidden="true"></i>');
        }
        let targetLevel = $(event.currentTarget).data('target');
        let currentRow = $(event.currentTarget).parents('li').next();
        let currentLevel = $(currentRow).data('level');
        let mainVisible = isVisible;
        while (currentLevel > targetLevel) {
            let isShow = false;
            if (mainVisible) {
                if ($(currentRow).is(':visible')) {
                    $(currentRow).hide();
                }
            } else {
                isShow = true;
                $(currentRow).show();
            }

            if (($(currentRow).next().data('level') - targetLevel) == 1) {
                mainVisible = isVisible;
            } else {
                if ($(currentRow).find('.dropdown-btn').length > 0 && isShow) {
                    mainVisible = !$(currentRow).find('.dropdown-btn').data('visible');
                }
            }
            currentRow = $(currentRow).next();
            currentLevel = $(currentRow).data('level');
        }
    }
}