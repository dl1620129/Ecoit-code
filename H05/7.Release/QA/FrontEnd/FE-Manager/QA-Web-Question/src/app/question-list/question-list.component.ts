import { Component, OnInit, Inject, LOCALE_ID } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Constants } from '../common/constants';
import { QuestionService } from '../service/question.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { QuestionConstants } from '../common/question-constants';
import { Router } from '@angular/router';
import { formatDate } from '@angular/common';
import { NotifierService } from "angular-notifier";
import { NgbDropdownConfig } from '@ng-bootstrap/ng-bootstrap';
import { Category } from '../model/category.model';
import { CategoryService } from '../service/category.service';
import { Question } from '../model/question.model';

declare const Liferay: any;
declare var $: any;

@Component({
    selector: 'app-question-list',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + '/o/QA-Web-Question/app/question-list.component.html',
    styleUrls: [],
    providers: [],
})
export class QuestionListComponent implements OnInit {

    pageSize = 5;
    collectionSize = 0;
    page = 1;
    searchKey: any;

    categoriesList: Category[] = new Array();

    oldSearchForm: any;
    searchForm = this.fb.group({
        categoryId: 0,
        searchKey: ['']
    });

    userPermissions: string[] = new Array();
    questionsList: Question[] = new Array();

    constructor(private fb: FormBuilder,
        private questionService: QuestionService,
        private modalService: NgbModal,
        private router: Router,
        @Inject(LOCALE_ID) private locale: string,
        private notifierService: NotifierService,
        dropdownConfig: NgbDropdownConfig,
        private categoryService: CategoryService){
            dropdownConfig.placement = "bottom-right";
        };

    ngOnInit() {
        this.oldSearchForm = this.searchForm;
        this.page = 1;
        this.categoryService.getCategory().subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.categoriesList = this.categoryService.convertCategoryList(response.data, 0);
            }
        });
        this.getFilteredQuestion(0);
    }

    get QuestionConstants () {
        return QuestionConstants;
    }

    get configuration () {
        return Constants.CONFIGURATION;
    }
    
    submitSearchForm() {
        this.oldSearchForm = this.searchForm;
        this.page = 1;
        this.questionIdList = new Array();
        this.getFilteredQuestion(0);
    }

    pageChange(event : any) {
        let startPage = (event - 1) * this.pageSize;
        this.getFilteredQuestion(startPage);
    }

    getFilteredQuestion(start: number) {
        this.questionService.getFilteredQuestion(this.oldSearchForm, start, this.pageSize).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.collectionSize = response.data.total;
                this.questionsList = response.data.questions;
                this.userPermissions = response.data.permissions;
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    // Check Box Action
    questionIdList: number[] = new Array();
    updateQuestionId(event: any, questionId :any){
        let isChecked = event.target.checked;
        if (isChecked) {
             this.questionIdList.push(questionId);
        } else {
             const index: number = this.questionIdList.indexOf(questionId);
             if (index !== -1) {
                 this.questionIdList.splice(index, 1);
             }        
        } 
        console.log('list: '+ this.questionIdList);   
    }
    // Check Box Action

    checkArray(content: any) {
        if (Array.isArray(content)) {
            return true;
        }
        return false;
    } 

    updateStatus(action: number, questionId: any) {
        let questionList = new Array();
        if (typeof questionId == 'number') {
            questionList.push(questionId);
        } else if (Array.isArray(questionId)) {
            questionList = questionId;
        }
        this.questionService.updateStatus(action, questionList).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getFilteredQuestion(startPage);
                this.questionIdList = new Array();
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    openedModal: any;
    removedQuestion: any;
    openDeleteModal(question: any, content: any) {
        this.removedQuestion = question;
        this.openedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow'});
    }

    deleteQuestion(questionId: number) {
        let questionList = new Array();
        if (typeof questionId == 'number') {
            questionList.push(questionId);
        } else if (Array.isArray(questionId)) {
            questionList = questionId;
        }
        this.questionService.deleteQuestion(questionList).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getFilteredQuestion(startPage);
                this.openedModal.close();
                this.questionIdList = new Array();
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    gotoEdit(questionId: number) {
        this.router.navigate(['/question-edit', questionId]);
    }
}