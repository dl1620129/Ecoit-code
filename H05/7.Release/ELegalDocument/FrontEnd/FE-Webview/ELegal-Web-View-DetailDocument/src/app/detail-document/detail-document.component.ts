import { Component, OnInit } from '@angular/core';
import { DocumentService } from '../service/document.service';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { Constants } from '../common/constants';
import { LegalDocument } from '../model/document.model';
import { URLConstants } from '../common/URLConstants';
import { CaptchaService } from '../service/captcha.service';
import { Suggestion } from '../model/suggestion.model';
import { LegalType } from '../model/legal-type.model';
import { LegalField } from '../model/legal-field';
import { Organization } from '../model/organization.model';

declare const Liferay: any;
declare const $: any;

@Component({
    selector: 'app-detail-document',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + 
    '/o/ELegal-Web-View-DetailDocument/app/detail-document.component.html',
    styleUrls: [],
    providers: [],
}) export class DetailDocumentComponent implements OnInit {

    arrayOne(n: number): any[] {
        return Array(n);
    }

    public urlWebSite= Liferay.ThemeDisplay.getLayoutRelativeURL();
    captchaImg = Constants.baseUrl + '/o/captcha/app/get-captcha';
    currentDate = new Date();
    suggestForm = this.fb.group({
        email: ['', [Validators.required, Validators.email, Validators.maxLength(75)]],
        name: ['', [Validators.required, Validators.maxLength(200)]],
        title: ['', [Validators.required, Validators.maxLength(200)]],
        content: ['', [Validators.required, Validators.maxLength(500)]],
        captchaText: ['']
    });

    get HOME_URL() {
        return URLConstants.HOME_URL;
    }

    get DOCUMENT_URL() {
        return Constants.baseUrl + this.urlWebSite.substring(0,this.urlWebSite.lastIndexOf('/'))+ URLConstants.DOCUMENT_URL;
    }

    get DETAIL_DOCUMENT_URL() {
        return Constants.baseUrl + this.urlWebSite.substring(0,this.urlWebSite.lastIndexOf('/')) + URLConstants.DETAIL_DOCUMENT_URL;
    }

    get name() {
        return this.suggestForm.get('name');
    };

    get email() {
        return this.suggestForm.get('email');
    };

    get title() {
        return this.suggestForm.get('title');
    };

    get content() {
        return this.suggestForm.get('content');
    };

    typesList: LegalType[] = new Array();
    fieldsList: LegalField[] = new Array();
    organizationsList: Organization[] = new Array();
    popularList: Document[] = new Array();
    commentsListSize = 0;
    constructor (private documentService: DocumentService, private fb: FormBuilder, private captchaService: CaptchaService){};

    detailDocument: LegalDocument;
    suggestionsList: Suggestion[] = new Array();

    relatedDocumentsList: LegalDocument[] = new Array();
    replacedDocumentsList: LegalDocument[] = new Array();
    ngOnInit() {
        let queryData = this.getQueryString();
        if (queryData['documentId']) {
            this.getDetailContent(queryData['documentId']);
        }

        this.documentService.getSelectOptions().subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.typesList = response.data.types;
                this.fieldsList = response.data.fields;
                this.organizationsList = response.data.organizations;
            }
        });

		this.documentService.getPopularDocuments().subscribe((response: any) => {
			console.log(response);
			if (response.error_code == Constants.SUCCESSFUL_CODE) {
				this.popularList = response.data;
			}
		});
    }
    
    getCaptcha() {
        let currentTime = new Date();
        this.captchaImg = Constants.baseUrl + '/o/captcha/app/get-captcha' + '?' + currentTime.getTime();
    }

    submitSuggest() {
        this.captchaService.submitCaptcha(this.suggestForm).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE && response.data == true) {
                this.documentService.submitComment(this.suggestForm, this.detailDocument.docId).subscribe((submitResponse: any) => {
                    console.log(submitResponse);
                    if (submitResponse.error_code == Constants.SUCCESSFUL_CODE) {
                        //this.getDetailContent(this.detailDocument.docId);
                        alert("Góp ý của bạn đã được gửi thành công.");
                        this.suggestForm.reset();
                    } 
                });
            } else {
                alert("Xin bạn nhập lại mã captcha.");
            }
            this.getCaptcha();
        });

    }

    updateAttachmentView(attachmentId: number) {
        this.documentService.updateAttachmentView(attachmentId).subscribe((response: any) => {
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let queryData = this.getQueryString();
                if (queryData['documentId']) {
                    this.getDetailContent(queryData['documentId']);
                }
            }
        });
    }

    getDetailContent(documentId: any) {
        this.documentService.getDocument(documentId).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.detailDocument = response.data.document;
                this.detailDocument.fieldName = response.data.fieldName;
                this.detailDocument.organizationName = response.data.organizationName;
                this.detailDocument.typeName = response.data.typeName;
                this.detailDocument.signerName = response.data.signerName;
                this.suggestionsList = response.data.suggestions;
                this.relatedDocumentsList = response.data.selectedRelatedDocumentsList;
                this.replacedDocumentsList = response.data.selectedReplacedDocumentsList;
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

    displayDropDown(event: any) {
        event.preventDefault();
        console.log('testing');
        let isVisible = $(event.currentTarget).data('visible');
        $(event.currentTarget).data('visible', !isVisible);
        if (isVisible) {
            //switch to plus
            $(event.currentTarget).html('<i class="fa fa-plus bg-white" aria-hidden="true"></i>');
        } else {
            //switch to minus
            $(event.currentTarget).html('<i class="fa fa-minus bg-white" aria-hidden="true"></i>');
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

    gotoSite(link: any) {
        window.location = link;
    }
}