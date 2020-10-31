import { Component, OnInit, Inject, LOCALE_ID } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Constants } from '../common/constants';
import { DocumentService } from '../service/document.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { DocumentConstants } from '../common/document-constants';
import { Router } from '@angular/router';
import { formatDate } from '@angular/common';
import { NotifierService } from "angular-notifier";
import { NgbDropdownConfig } from '@ng-bootstrap/ng-bootstrap';
import { LegalType } from '../model/legal-type.model';
import { Organization } from '../model/organization.model';
import { LegalField } from '../model/legal-field';
import { LegalSigner } from '../model/legal-signer.model';
import { OrganizationService } from '../service/organization.service';
import { TypeService } from '../service/type.service';
import { DateTimeAdapter } from 'ng-pick-datetime';

declare const Liferay: any;
declare var $: any;

@Component({
    selector: 'app-document-list',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + '/o/ELegal-Web-Document/app/document-list.component.html',
    styleUrls: [],
    providers: [],
})
export class DocumentListComponent implements OnInit {

    pageSize = 5;
    collectionSize = 0;
    page = 1;

    typesList: LegalType[] = new Array();
    organizationsList: Organization[] = new Array();
    fieldsList: LegalField[] = new Array();
    signersList: LegalSigner[] = new Array();

    oldSearchForm: any;
    searchForm = this.fb.group({
        typeId: 0,
        organizationId: 0,
        symbol: [''],
        signerId: 0,
        fieldId: 0,
        promulDate: [''],
        fromDate: [''],
        toDate: [''],
        newGopY: ['both']
    });

    userPermissions: string[] = new Array();
    documentsList: Document[] = new Array();

    constructor(private fb: FormBuilder,
        private documentService: DocumentService,
        private modalService: NgbModal,
        private router: Router,
        @Inject(LOCALE_ID) private locale: string,
        private notifierService: NotifierService,
        dropdownConfig: NgbDropdownConfig,
        private organizationService: OrganizationService,
        private typeService: TypeService,
        dateTimeAdapter: DateTimeAdapter<any>){
            dropdownConfig.placement = "bottom-right";
            //dateTimeAdapter.setLocale("vi-VN");
        };

    ngOnInit() {
        this.oldSearchForm = this.searchForm;
        this.page = 1;
        this.documentService.getSelectedOption(0).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.fieldsList = response.data.fields;
                this.signersList = response.data.signers;
                this.organizationsList = this.organizationService.convertOrganizationList(response.data.organizations, 0);
                this.typesList = this.typeService.convertTypeList(response.data.types, 0);
            }
        });
        this.getFilteredDocument();
    }

    get promulDate() {
        return this.searchForm.get('promulDate');
    };

    get fromDate() {
        return this.searchForm.get("fromDate");
    }

    get toDate() {
        return this.searchForm.get("toDate");
    }

    get DocumentConstants () {
        return DocumentConstants;
    }

    get configuration () {
        return Constants.CONFIGURATION;
    }

    closedForm = this.fb.group({
        typeId: 0,
        organizationId: 0,
        signerId: 0,
        fieldId: 0,
        promulDate: [''],
        fromDate: [''],
        toDate: [''],
        newGopY: ['both']
    });
    isAdvancedSearch = false;
    openCloseAdvancedSearch(event: any) {
        event.preventDefault();
        if (this.isAdvancedSearch) {
            //store form value before reset
            this.closedForm.patchValue({
                typeId: this.searchForm.get('typeId').value,
                organizationId: this.searchForm.get('organizationId').value,
                signerId: this.searchForm.get('signerId').value,
                fieldId: this.searchForm.get('fieldId').value,
                fromDate: this.searchForm.get('fromDate').value,
                toDate: this.searchForm.get('toDate').value,
                newGopY: this.searchForm.get('newGopY').value
            });
            //reset form value before close
            this.searchForm.patchValue({
                typeId: 0,
                organizationId: 0,
                signerId: 0,
                fieldId: 0,
                fromDate: '',
                toDate: '',
                newGopY: 'both'
            });
            this.isAdvancedSearch = false;
        } else {
            //restore old form value when open
            this.searchForm.patchValue({
                typeId: this.closedForm.get('typeId').value,
                organizationId: this.closedForm.get('organizationId').value,
                signerId: this.closedForm.get('signerId').value,
                fieldId: this.closedForm.get('fieldId').value,
                fromDate: this.closedForm.get('fromDate').value,
                toDate: this.closedForm.get('toDate').value,
                newGopY: this.closedForm.get('newGopY').value
            });
            this.isAdvancedSearch = true;
        }
    } 


    submitSearchForm() {
        this.oldSearchForm = this.searchForm;
        this.page = 1;
        this.docIdList = new Array();
        this.getFilteredDocument();
    }

    pageChange(event : any) {
        let startPage = (event - 1) * this.pageSize;
        this.getFilteredDocument();
    }

    getFilteredDocument() {
        this.documentService.getFilteredDocument(this.oldSearchForm).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.collectionSize = response.data.total;
                this.documentsList = response.data.data;
                this.userPermissions = response.data.permissions;
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    // Check Box Action
    docIdList: number[] = new Array();
    updateDocument(event: any, docId :any){
        let isChecked = event.target.checked;
        if (isChecked) {
            this.docIdList.push(docId);
        } else {
            const index: number = this.docIdList.indexOf(docId);
            if (index !== -1) {
                this.docIdList.splice(index, 1);
            }        
        } 
        console.log('list: '+this.docIdList);
    }
    // Check Box Action
    checkArray(content: any) {
        if (Array.isArray(content)) {
            return true;
        }
        return false;
    }
    
    updateStatus(action: number, docId: number) {
        let docList = new Array();
        if (typeof docId == 'number') {
            docList.push(docId);
        } else if (Array.isArray(docId)) {
            docList = docId;
        }
        this.documentService.updateStatus(action, docList).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.getFilteredDocument();
                this.docIdList = new Array();
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    openedModal: any;
    removedDocument: any;
    openDeleteModal(document: any, content: any) {
        this.removedDocument = document;
        this.openedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow'});
    }

    deleteDocument(docId: any) {
        let docList = new Array();
        if (typeof docId == 'number') {
            docList.push(docId);
        } else if (Array.isArray(docId)) {
            docList = docId;
        }
        this.documentService.deleteDocument(docList).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.getFilteredDocument();
                this.openedModal.close();
                this.docIdList = new Array();
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    gotoEdit(articleId: number) {
        this.router.navigate(['/document-edit', articleId]);
    }

    formatDate(event: any) {
        console.log(event);
        let formattedDate = formatDate(event.value, 'dd/MM/yyyy HH:mm', this.locale);
        $(event.input).val(formattedDate);
    }
}