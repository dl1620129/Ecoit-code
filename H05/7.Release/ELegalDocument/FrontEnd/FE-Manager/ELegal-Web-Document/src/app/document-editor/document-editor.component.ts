import { Component, OnInit, Inject, LOCALE_ID } from '@angular/core';
import { DocumentService } from '../service/document.service';
import { Observable } from 'rxjs';
import {debounceTime, map} from 'rxjs/operators';
import { SignerService } from '../service/signer.service';

import { LegalSigner } from '../model/legal-signer.model';
import { Document } from '../model/document.model';
import LiferayParams from '../../types/LiferayParams';
import { Constants } from '../common/constants';

import { ActivatedRoute, Router } from '@angular/router';
import { DocumentConstants } from '../common/document-constants';
import { formatDate } from '@angular/common';
import { NotifierService } from 'angular-notifier';
import { LegalType } from '../model/legal-type.model';
import { Organization } from '../model/organization.model';
import { LegalField } from '../model/legal-field';
import { OrganizationService } from '../service/organization.service';
import { Attachment } from '../model/attachment.model';
import { Suggestion } from '../model/suggestion.model';
import { DateTimeAdapter } from 'ng-pick-datetime';
import { of } from 'rxjs';
import {filter} from 'rxjs/operators';

declare const Liferay: any;
declare var $: any;

@Component({
    selector: 'app-document-editor',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + 
    '/o/ELegal-Web-Document/app/document-editor.component.html',
    styleUrls: [],
    providers: [],
})
export class DocumentEditorComponent implements OnInit {

    arrayOne(n: number): any[] {
        return Array(n);
    }

    attachmentsList: Attachment[] = new Array();

    params: LiferayParams;
    docId: number = 0;

    document = new Document();

    documentsList: Document[];

    selectedCategories: any = [];

    categories: any = [];
    usersList: any =[];
    groups: any = [];

    get DocumentConstants () {
        return DocumentConstants;
    }

    get configuration () {
        return Constants.CONFIGURATION;
    }
    
    userPermissions: string[] = new Array();
    typesList: LegalType[] = new Array();
    organizationsList: Organization[] = new Array();
    fieldsList: LegalField[] = new Array();
    suggestionsList: Suggestion[] = new Array();

    selectedSignersList: LegalSigner[] = new Array();
    selectedReplacedDocumentsList: Document[] = new Array();
    selectedRelatedDocumentsList: Document[] = new Array();
    
    constructor(private documentService : DocumentService,
        private signerService: SignerService,
        private routes: ActivatedRoute,
        private router: Router,
        @Inject(LOCALE_ID) private locale: string,
        private notifierService: NotifierService,
        private organizationService: OrganizationService,
        dateTimeAdapter: DateTimeAdapter<any>) { 
            //dateTimeAdapter.setLocale("vi-VN");
        }

    ngOnInit() {
        this.routes.paramMap.subscribe(params => {
            if (params.get('id')) {
                this.docId = parseInt(params.get('id'));
                this.documentService.getDocument(this.docId).subscribe((response: any) => {
                    console.log(response);
                    if (response.error_code == Constants.SUCCESSFUL_CODE) {
                        this.document = this.documentService.convertDateToDocument(response.data.document);
                        this.suggestionsList = response.data.suggestions;
                        this.selectedSignersList = response.data.selectedSignersList;
                        this.selectedRelatedDocumentsList = response.data.selectedRelatedDocumentsList;
                        this.selectedReplacedDocumentsList = response.data.selectedReplacedDocumentsList;
                    }
                });
            } 

            this.documentService.getSelectedOption(this.docId).subscribe((response: any) => {
                console.log(response);
                if (response.error_code == Constants.SUCCESSFUL_CODE) {
                    this.fieldsList = response.data.fields;
                    this.organizationsList = this.organizationService.convertOrganizationList(response.data.organizations, 0);
                    this.typesList = response.data.types;
                    this.userPermissions = response.data.permissions;
                }
            });
        });
    }
    

    saveForm(action: number) {
        if (this.document.typesList.length <= 0) {
            this.notifierService.notify('warning', DocumentConstants.TYPE_NOT_SELECTED);
            return;
        }

        if (this.document.organizationId <= 0) {
            this.notifierService.notify('warning', DocumentConstants.ORGANIZATION_NOT_SELECTED);
            return;
        }

        if (this.document.fieldId <= 0) {
            this.notifierService.notify('warning', DocumentConstants.FIELD_NOT_SELECTED);
            return;
        }

        this.documentService.submitDocumentForm(this.document, this.docId, action, this.attachmentsList).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.router.navigate(['/document-list']);
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    fetchSelectedType(item: any, target: any) {
        if ($(target).prop('checked')) {
            this.document.typesList.push(item.typeId);
            let parentListItems = $(target).parent().parent().parents('li');
            if (parentListItems.length > 0) {
                let inputCheck =  $(parentListItems[0]).children('.form-check').find('input[name="typeCheck"]');
                if (!$(inputCheck).prop('checked')) {
                    $(inputCheck).click();
                }
            }
        } else {
            this.document.typesList.forEach((element: any, index: any) => {
                if (element == item.typeId) {
                    this.document.typesList.splice(index, 1);
                }
            });
            let childrenListItems = $(target).parent().next('ul');
            if (childrenListItems.length > 0) {
                let inputChecks =  $(childrenListItems).children('li');         
                inputChecks.each(function(index: number, element: any) {
                    let checkBox = $(element).children('.form-check').find('input[name="typeCheck"]');
                    if($(checkBox).prop('checked')) {
                        $(checkBox).click();
                    }
                });
            }
        }
        console.log(this.document.typesList);
    }

    /* -- Find suggested signer -- */
    signersList: String[] = new Array();
    /*searchSigner = (text$: Observable<string>) =>
    text$.pipe(
        debounceTime(100),
        map(term => term.length < 2 ? []: this.signersList.filter((obj: any) => {
            let isContained = false;
            this.document.signerRels.forEach((element: any) => {
                if (element == obj.id) {
                    isContained = true;
                }
            });
            return (!isContained);
        }))  
    )*/

    filteredSignersList(event: any) {
        this.signerService.getSignersList(0, 5, event).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                /*response.data.data.forEach((element: LegalSigner) => {
                    this.signersList.push(element.fullName);
                });*/
                this.signersList = response.data.data;
                console.log(this.signersList);
            }
        });
    }

    public onAddingSigner = (signer: any): Observable<any> => {
        let legalSigner = new LegalSigner;
        if (typeof signer == 'string') {
            let listSize = this.document.signerRels.length;
            legalSigner.sigId = 0 - listSize;
            legalSigner.fullName = signer;
        } else {
            legalSigner.sigId = signer.sigId;
            legalSigner.fullName = signer.fullName;
        }
        return of(legalSigner).pipe(filter((temp: any) => temp));
    }
    
    checkSigner() {
        console.log(this.document.signerRels);
    }

    signerFormatter = (obj: any) => obj.fullName;

    /*signerText = "";
    addSigner(event : any) {
        event.preventDefault();
        this.signersList.forEach((element: any) => {
            if (element.sigId == event.item.sigId) {
                this.selectedSignersList.push(event.item);
                this.document.signerRels.push(event.item.sigId);
                return;
            }
        });
        this.signerText = "";
    }

    removeSigner(index: number) {
        this.document.signerRels.splice(index, 1);
        this.selectedSignersList.splice(index, 1);
    }*/
    /* -- Find suggested signer -- */

    /* -- Find suggested document for related and replaced -- */
    searchRelatedDocument = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(100),
      map(term => term.length < 1 ? []: this.documentsList.filter((obj: any) => {
        let isContained = false;
        this.document.docRelation.forEach((element: any) => {
            if (element == obj.docId) {
                isContained = true;
            }
        });
        return (!isContained);
      }))  
    )

    searchReplacedDocument = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(100),
      map(term => term.length < 1 ? []: this.documentsList.filter((obj: any) => {
        let isContained = false;
        this.document.replaceDoc.forEach((element: any) => {
            if (element == obj.docId) {
                isContained = true;
            }
        });
        return (!isContained);
      }))  
    )

    filteredDocumentsList(event: any) {
        this.documentService.getSuggestDocument(event.target.value, 5).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.documentsList = response.data;
            }
        });
    }
    
    documentFormatter = (obj: any) => obj.symbol;

    relatedDocumentText = "";
    addRelatedDocument(event : any) {
        event.preventDefault();
        this.documentsList.forEach((element: any) => {
            if (element.docId == event.item.docId) {
                this.document.docRelation.push(event.item.docId);
                this.selectedRelatedDocumentsList.push(event.item);
                return;
            }
        });
        this.relatedDocumentText = "";
    }

    replacedDocumentText = "";
    addReplacedDocument(event : any) {
        event.preventDefault();
        this.documentsList.forEach((element: any) => {
            if (element.docId == event.item.docId) {
                this.document.replaceDoc.push(event.item.docId);
                this.selectedReplacedDocumentsList.push(event.item);
                return;
            }
        });
        this.replacedDocumentText = "";
    }

    removeRelatedDocument(index: number) {
        this.document.docRelation.splice(index, 1);
        this.selectedRelatedDocumentsList.splice(index, 1);
    }

    removeReplacedDocument(index: number) {
        this.document.replaceDoc.splice(index, 1);
        this.selectedReplacedDocumentsList.splice(index, 1);
    }
    /* -- Find suggested document for related and replaced -- */

    validExts = [".doc",".docx",".pdf",".zip",".rar"];

    uploadAttachment(index: any, event: any) {
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
                        this.readFile(event, index);
                    }
                } else {
                    this.readFile(event, index);
                }
            }
        }
    }

    readFile(event: any, index: any) {
        var file = event.target.files;
        if (file && file[0]) {
            const reader = new FileReader();
            let temp = {
                "fileName": file[0].name,
                "file": file[0]
            }
            this.attachmentsList[index] = temp;
            console.log( this.attachmentsList);
            /*reader.onload = (e: any) => {
                //this.attachmentsList[index].file = e.target.result;

            };
            reader.readAsDataURL(file[0]);*/
        }
    }

    addAttachment() {
        if (this.attachmentsList.length <= 7) {
            this.attachmentsList.push(new Attachment());
        }
    }

    deleteAttachment(index: any) {
        console.log(index);
        this.attachmentsList.splice(index, 1);
    }

    deleteServerAttachment(index: any, attachmentId: number) {
        this.documentService.deleteAttachment(attachmentId).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.document.attachmentURLsList.splice(index, 1);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    /*formatDate(event: any) {
        console.log(event);
        let formattedDate = formatDate(event.value, 'dd/MM/yyyy HH:mm', this.locale);
        $(event.input).val(formattedDate);
    }*/
}