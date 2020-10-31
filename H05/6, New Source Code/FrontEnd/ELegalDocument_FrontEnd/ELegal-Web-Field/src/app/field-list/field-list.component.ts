import { Component, OnInit } from '@angular/core';
import { FieldService } from '../service/field.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Constants } from '../common/constants';
import { NotifierService } from 'angular-notifier';
import { LegalField } from '../model/legal-field.model';
import { Router } from '@angular/router';
import { NgbDropdownConfig } from '@ng-bootstrap/ng-bootstrap';

declare const Liferay: any;

@Component({
    selector: 'app-field-list',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + '/o/ELegal-Web-Field/app/field-list.component.html',
    styleUrls: [],
    providers: [],
})
export class FieldListComponent implements OnInit {

    legalFields: LegalField[] = new Array();

    constructor(private fieldService: FieldService, 
        private modalService: NgbModal, 
        private notifierService: NotifierService,
        private dropdownConfig: NgbDropdownConfig,
        private router: Router){
            dropdownConfig.placement = "bottom-right";
    }

    pageSize = 5;
    page = 1;
    listSize = 0;
    searchKey = '';
    removedField: any;

    ngOnInit() {
        this.getAllFields(0);
    }

    getAllFields(start: number) {
        this.fieldService.getAllFields(start, this.pageSize, this.searchKey).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.listSize = response.data.total;
                this.legalFields = response.data.data;
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    pageChange(event : any) {
        let startPage = (event - 1) * this.pageSize;
        this.getAllFields(startPage);
    }

    gotoEdit(fieldId: number) {
        this.router.navigate(['/field-edit', fieldId]);
    }

    filterList() {
        this.page = 1;
        this.fieldIdList = new Array();
        this.getAllFields(0);
    }

    // Check Box Action
    fieldIdList: number[] = new Array();
    updateLegalFieldId(event: any, fieldId :any){
        let isChecked = event.target.checked;
        if (isChecked) {
            this.fieldIdList.push(fieldId);
        } else {
            const index: number = this.fieldIdList.indexOf(fieldId);
            if (index !== -1) {
                this.fieldIdList.splice(index, 1);
            }        
        } 
        console.log('list: '+this.fieldIdList);
    }

    // Check Box Action
    checkArray(content: any) {
        if (Array.isArray(content)) {
            return true;
        }
        return false;
    }

    openedModal: any;
    openDeleteModal(legalField: any, content: any) {
        this.removedField = legalField;
        this.openedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow'});
    }

    deleteField(fieldId: any) {
        let fieldList = new Array();
        if (typeof fieldId == 'number') {
            fieldList.push(fieldId);
        } else if (Array.isArray(fieldId)) {
            fieldList = fieldId;
        }
        this.fieldService.deleteField(fieldList).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getAllFields(startPage);
                this.openedModal.close();
                this.fieldIdList = new Array();
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else if (response.error_code == Constants.CONFLICT_ERROR) {
                this.notifierService.notify('warning', Constants.DELETE_PARAM_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }
}