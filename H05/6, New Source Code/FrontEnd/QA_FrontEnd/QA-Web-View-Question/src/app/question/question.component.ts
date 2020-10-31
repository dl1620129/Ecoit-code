import { Component, OnInit, ViewChild } from '@angular/core';
import { QuestionService } from '../service/question.service';
import { CaptchaService } from '../service/captcha.service';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { Constants } from '../common/constants';
import { Category } from '../model/category.model';
import { URLConstants } from '../common/URLConstants';
declare const Liferay: any;
declare const $: any;

@Component({
    selector: 'app-question',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + 
    '/o/QA-Web-View-Question/app/question.component.html',
    styleUrls: [],
    providers: [],
}) export class QuestionComponent implements OnInit {

    captchaImg = Constants.baseUrl + '/o/captcha/app/get-captcha';

    questionForm = this.fb.group({
        email: ['', [Validators.required, Validators.email, Validators.maxLength(75)]],
        name: ['', [Validators.required, Validators.maxLength(200)]],
        phoneNumber: ['', [Validators.pattern("[0-9]{8,11}")]],
        address: ['', [Validators.maxLength(200)]],
        title: ['', [Validators.required, Validators.maxLength(200)]],
        attachFile: [''],
        categoryId: [0],
        content: ['', [Validators.required, Validators.maxLength(3000)]],
        captchaText: ['']
    });

    get HOME_URL() {
        return URLConstants.HOME_URL;
    }

    public urlWebSite= Liferay.ThemeDisplay.getLayoutRelativeURL();

    get HOIDAP_URL() {
        return Constants.baseUrl + this.urlWebSite.substring(0,this.urlWebSite.lastIndexOf('/'))+ URLConstants.HOIDAP_URL;
    }

    get CHI_TIET_PHAN_HOI_URL() {
        return Constants.baseUrl + this.urlWebSite.substring(0,this.urlWebSite.lastIndexOf('/'))+ URLConstants.CHI_TIET_PHAN_HOI_URL;
    }

    get name() {
        return this.questionForm.get('name');
    };

    get email() {
        return this.questionForm.get('email');
    };

    get phoneNumber() {
        return this.questionForm.get('phoneNumber');
    };

    get address() {
        return this.questionForm.get('address');
    };

    get title() {
        return this.questionForm.get('title');
    };

    get content() {
        return this.questionForm.get('content');
    };
    
    categoriesList: Category[] = new Array();

    attachmentFilesList: File[] = new Array();

    constructor (private questionService: QuestionService, private fb: FormBuilder, private captchaService: CaptchaService){};

    ngOnInit() {
        this.questionService.getCategory().subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.categoriesList = this.questionService.convertTreeList(response.data, 0);
            }
        });
    }
    
    validExts = [".doc",".docx",".pdf"];
    uploadAttachment(event: any) {
        let fileExt = event.target.value;
        if(fileExt != ''){
            fileExt = fileExt.substring(fileExt.lastIndexOf('.'));
            console.log(fileExt);
            if (this.validExts.indexOf(fileExt.toLowerCase()) < 0) {
                
                alert("Không đúng định dạng " +
                       this.validExts.toString());
                this.questionForm.patchValue({
                    attachFile: ''
                });
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
                        this.attachmentFilesList = null;
                        alert("File đính kèm không được quá 10 Mb");
                        this.questionForm.patchValue({
                            attachFile: ''
                        });
                        return false;
                    } else {
                        let multiFiles = event.target.files;
                        if(multiFiles) {
                            this.attachmentFilesList = new Array();
                            this.readMultilFile(multiFiles);
                            console.log(this.attachmentFilesList);
                        }
                    }
                } else {
                    var multiFiles = event.target.files;
                    if(multiFiles) {
                        this.attachmentFilesList = new Array();
                        this.readMultilFile(multiFiles);
                        console.log(this.attachmentFilesList);
                    }
                }
            }
        }
    }

    readMultilFile(multiFiles: any) {
        //const reader = new FileReader();
        for (var i = 0; i < multiFiles.length; i++) {
            this.attachmentFilesList.push(multiFiles[i]);
        }
        console.log( this.attachmentFilesList);
        /*reader.onload = (e: any) => {
            this.attachmentFilesList.push(file);
        };*/
        /*reader.readAsDataURL(file);
        this.attachmentFilesList.push(file);*/
    }

    getCaptcha() {
        let currentTime = new Date();
        this.captchaImg = Constants.baseUrl + '/o/captcha/app/get-captcha' + '?' + currentTime.getTime();
    }

    submitQuestion() {
        if (this.questionForm.get("categoryId").value <= 0) {
            alert("Bạn chưa chọn lĩnh vực phản hồi");
            return;
        }
        this.captchaService.submitCaptcha(this.questionForm).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE && response.data == true) {
                this.questionService.submitQuestion(this.questionForm, this.attachmentFilesList).subscribe((qaResponse: any) => {
                    console.log(qaResponse);
                    if (qaResponse.error_code == Constants.SUCCESSFUL_CODE) {
                        alert("Phản hồi của bạn đã được gửi thành công");
                        this.questionForm.reset();
                    }
                });
            } else {
                alert("Xin bạn nhập lại mã captcha.");
            }
            this.getCaptcha();
        });
    }
}