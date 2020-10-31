import { Component, OnInit, Inject, LOCALE_ID } from '@angular/core';
import { QuestionService } from '../service/question.service';

import { Question } from '../model/question.model';
import LiferayParams from '../../types/LiferayParams';
import { Constants } from '../common/constants';

import { ActivatedRoute, Router } from '@angular/router';
import { QuestionConstants } from '../common/question-constants';
import { NotifierService } from 'angular-notifier';
import { Category } from '../model/category.model';
import { CategoryService } from '../service/category.service';
import { Answer } from '../model/answer.model';
import { AttachmentFile } from '../model/attachFile.model';

declare const Liferay: any;
declare var $: any;

@Component({
    selector: 'app-questions-editor',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + 
    '/o/QA-Web-Question/app/question-editor.component.html',
    styleUrls: [],
    providers: [],
})
export class QuestionEditorComponent implements OnInit {

    arrayOne(n: number): any[] {
        return Array(n);
    }

    liferayParams: LiferayParams;
    answerId: number = 0;

    question = new Question();
    answer = new Answer();

    get QuestionConstants () {
        return QuestionConstants;
    }

    get configuration () {
        return Constants.CONFIGURATION;
    }
    
    userPermissions: string[] = new Array();
    categoriesList: Category[] = new Array();

    questionAttachmentsList: AttachmentFile[] = new Array();
    answerAttachmentsList: AttachmentFile[] = new Array();

    constructor(private questionService : QuestionService,
        private routes: ActivatedRoute,
        private router: Router,
        @Inject(LOCALE_ID) private locale: string,
        private notifierService: NotifierService,
        private categoryService: CategoryService) { }

    ngOnInit() {
        this.routes.paramMap.subscribe(params => {
            if (params.get('id')) {
                this.questionService.getQuestion(parseInt(params.get('id'))).subscribe((response: any) => {
                    console.log(response);
                    if (response.error_code == Constants.SUCCESSFUL_CODE) {
                        this.question = response.data.question;
                        this.userPermissions = response.data.permissions;
                        if (response.data.answer) {
                            this.answer = response.data.answer;
                        }
                    }
                });
            }
        });

        this.categoryService.getCategory().subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.categoriesList = this.categoryService.convertCategoryList(response.data, 0);
            }
        });
    }
    

    saveForm(action: number) {
        this.questionService.submitQuestion(this.question, action, this.questionAttachmentsList, this.answer, this.answerAttachmentsList).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.router.navigate(['/question-list']);
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    uploadAttachment(index: any, event: any) {
        let fileExt = event.target.value;
        if(fileExt != ''){
            fileExt = fileExt.substring(fileExt.lastIndexOf('.'));
            console.log(fileExt);
            let totalSize = event.target.files[0].size;
            let fSExt = new Array('Bytes', 'KB', 'MB', 'GB');
            let fSize = totalSize; 
            let i=0;
            while(fSize>900){fSize/=1024;i++;}
            var total = (Math.round(fSize*100)/100);
            if(fSExt[i] == 'MB'){
                if(total >= 10){
                    alert("File đính kèm không được quá 10 Mb");
                    return false;
                } else {
                    let F = event.target.files;
                    if(F && F[0]) this.readFile(F[0], index);
                }
            } else {
                var F = event.target.files;
                if(F && F[0]) this.readFile(F[0], index);
            }
        }
    }

    readFile(file: any, index: any) {
        //const reader = new FileReader();
        let temp = {
            "fileName": file.name,
            "file": file
        }
        this.questionAttachmentsList[index] = temp;
        /*reader.onload = (e: any) => {
            this.attachmentFile = file;
        };
        reader.readAsDataURL(file);*/
    }

    deleteQTempAttachment(index: any) {
        this.questionAttachmentsList.splice(index, 1);
    }

    addQuestionAttachment() {
        this.questionAttachmentsList.push(new AttachmentFile());
    }

    deleteQuestionAttachment(index: any, attachmentId: number) {
        this.questionService.deleteQuestionAttachment(this.question.questionId, attachmentId).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.question.attachments.splice(index, 1);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    validExts = [".doc",".docx",".pdf"];
    uploadAnswerAttachment(index: any, event: any) {
        let fileExt = event.target.value;
        if(fileExt != ''){
            fileExt = fileExt.substring(fileExt.lastIndexOf('.'));
            console.log(fileExt);
            if (this.validExts.indexOf(fileExt.toLowerCase()) < 0) {
                
                alert("Không đúng định dạng " +
                       this.validExts.toString());
                return false;
            } else {
                let totalSize = event.target.files[0].size;
                let fSExt = new Array('Bytes', 'KB', 'MB', 'GB');
                let fSize = totalSize; 
                let i=0;
                while(fSize>900){fSize/=1024;i++;}
                var total = (Math.round(fSize*100)/100);
                if(fSExt[i] == 'MB'){
                    if(total >= 10){
                        alert("File đính kèm không được quá 10 Mb");
                        return false;
                    } else {
                        let F = event.target.files;
                        if(F && F[0]) this.readAnswerFile(F[0], index);
                    }
                } else {
                    var F = event.target.files;
                    if(F && F[0]) this.readAnswerFile(F[0], index);
                }
            }
        }
    }

    readAnswerFile(file: any, index: any) {
        let temp = {
            "fileName": file.name,
            "file": file
        }
        this.answerAttachmentsList[index] = temp;
        /*const reader = new FileReader();
        reader.onload = (e: any) => {
            this.answerAttachmentFile = file;
        };
        reader.readAsDataURL(file);*/
    }

    deleteATempAttachment(index: any) {
        this.answerAttachmentsList.splice(index, 1);
    }

    addAnswerAttachment() {
        this.answerAttachmentsList.push(new AttachmentFile());
    }

    deleteAnswerAttachment(index: any, attachmentId: number) {
        this.questionService.deleteAnswerAttachment(this.answer.answerId, attachmentId).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.answer.attachments.splice(index, 1);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }
}