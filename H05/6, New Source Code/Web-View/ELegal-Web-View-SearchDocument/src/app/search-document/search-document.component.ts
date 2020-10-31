import { Component, OnInit } from '@angular/core';
import { Constants } from '../common/constants';
import { DocumentService } from '../service/document.service';
import { FormBuilder } from '@angular/forms';
import { LegalField } from '../model/legal-field';
import { LegalType } from '../model/legal-type.model';
import { Organization } from '../model/organization.model';
import { URLConstants } from '../common/URLConstants';
import { TreeUtilService } from '../service/tree-util.service';
import { DateTimeAdapter } from 'ng-pick-datetime';

declare const Liferay: any;
declare const $: any;
@Component({
    selector: 'app-search-document-list',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + 
    '/o/ELegal-Web-View-SearchDocument/app/search-document.component.html',
    styleUrls: [],
    providers: [],
}) export class SearchDocumentComponent implements OnInit {

    arrayOne(n: number): any[] {
        return Array(n);
    }

    public urlWebSite= Liferay.ThemeDisplay.getLayoutRelativeURL();
    pageSize = 10;
    page = 1;
    documentsList: Document[] = new Array();
    popularList: Document[] = new Array();
    searchForm = this.fb.group({
        typeId: 0,
        organizationId: 0,
        searchKey: [''],
        symbol: [''],
        fieldId: 0,
        fromDate: [''],
        toDate: ['']
    });

    get HOME_URL() {
        return URLConstants.HOME_URL;
    }
	
	get DETAIL_DOCUMENT_URL() {
        return Constants.baseUrl + this.urlWebSite.substring(0,this.urlWebSite.lastIndexOf('/')) + URLConstants.DETAIL_DOCUMENT_URL;
    }

    get CURRENT_URL() {
		let currentUrl = Liferay.ThemeDisplay.getLayoutURL();
        return currentUrl;
    }

    currentDate = new Date();

    isPublic = 0;
    typesList: LegalType[] = new Array();
    selectTypesList: LegalType[] = new Array();
    fieldsList: LegalField[] = new Array();
    organizationsList: Organization[] = new Array();
    selectOrgsList:  Organization[] = new Array();
    mainOrgId: number;
    isAdvancedSearch = false;

    constructor(private documentService: DocumentService, 
        private fb: FormBuilder, 
        private treeUtilService: TreeUtilService,
        dateTimeAdapter: DateTimeAdapter<any>,) {
            dateTimeAdapter.setLocale("vi-VN"); 
    }
    
    closedForm = this.fb.group({
        typeId: 0,
        organizationId: 0,
        symbol: [''],
        fieldId: 0,
        fromDate: [''],
        toDate: ['']
    });

    ngOnInit() {
        let queryData = this.getQueryString();
        if (parseInt(queryData['typeId'])) {
            this.searchForm.patchValue({
                typeId: parseInt(queryData['typeId'])
            });
            this.closedForm.patchValue({
                typeId: parseInt(queryData['typeId'])
            });
        }

        if (parseInt(queryData['fieldId'])) {
            this.searchForm.patchValue({
                fieldId: parseInt(queryData['fieldId'])
            });
            this.closedForm.patchValue({
                fieldId: parseInt(queryData['fieldId'])
            });
        }

        if (parseInt(queryData['organizationId'])) {
            this.mainOrgId = parseInt(queryData['organizationId']);
            this.searchForm.patchValue({
                organizationId: parseInt(queryData['organizationId'])
            });

            this.closedForm.patchValue({
                organizationId: parseInt(queryData['organizationId'])
            });
        }
        this.documentService.getSelectOptions().subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.selectTypesList = this.treeUtilService.convertTypeTreeList(response.data.types, 0);
                this.typesList = response.data.types;
                this.fieldsList = response.data.fields;
                this.selectOrgsList = this.treeUtilService.convertOrgTreeList(response.data.organizations, 0);
                this.organizationsList = response.data.organizations;
            }
        });

		this.documentService.getPopularDocuments().subscribe((response: any) => {
			console.log(response);
			if (response.error_code == Constants.SUCCESSFUL_CODE) {
				this.popularList = response.data;
			}
		});

        if (parseInt(queryData['isPublic'])) {
            this.isPublic = parseInt(queryData['isPublic']);
        }
        this.isPublic = 0;

        this.submitSearchForm();
    }

    openCloseAdvancedSearch(event: any) {
        event.preventDefault();
        if (this.isAdvancedSearch) {
            //store form value before reset
            this.closedForm.patchValue({
                typeId: this.searchForm.get('typeId').value,
                organizationId: this.searchForm.get('organizationId').value,
                symbol: this.searchForm.get('symbol').value,
                fieldId: this.searchForm.get('fieldId').value,
                fromDate: this.searchForm.get('fromDate').value,
                toDate: this.searchForm.get('toDate').value
            });
            //reset form value before close
            this.searchForm.patchValue({
                typeId: 0,
                organizationId: 0,
                symbol: '',
                fieldId: 0,
                fromDate: '',
                toDate: ''
            });
            this.isAdvancedSearch = false;
        } else {
            //restore old form value when open
            this.searchForm.patchValue({
                typeId: this.closedForm.get('typeId').value,
                organizationId: this.closedForm.get('organizationId').value,
                symbol: this.closedForm.get('symbol').value,
                fieldId: this.closedForm.get('fieldId').value,
                fromDate: this.closedForm.get('fromDate').value,
                toDate: this.closedForm.get('toDate').value
            });
            this.isAdvancedSearch = true;
        }
    } 

    openDetail(popover: any, document: Document) {
        popover.open({document});
    }

    closeDetail(popover: any) {
        popover.close();
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

    submitSearchForm() {
        this.documentService.getFilteredDocument(this.searchForm, this.isPublic).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.documentsList = response.data;
            }
        })
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
}