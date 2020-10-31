import { Component, OnInit } from '@angular/core';
import { TypeService } from '../service/type.service';
import { LegalType } from '../model/type.model';
import { Constants } from '../common/constants';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { NotifierService } from 'angular-notifier';
import { Router } from '@angular/router';
import { NgbDropdownConfig } from '@ng-bootstrap/ng-bootstrap';

declare const Liferay: any;
declare const $: any;

@Component({
    selector: 'app-type-list',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + '/o/ELegal-Web-Type/app/type-list.component.html',
    styleUrls: [],
    providers: [],
})
export class TypeListComponent implements OnInit {

    arrayOne(n: number): any[] {
        return Array(n);
    }

    pageSize = 5;
    page = 1;
    listSize = 0;
    searchKey = '';

    //declare list of categories
    listOfTypes : LegalType[] = [];

    removedType: any;
    constructor(private typeService : TypeService,
        private modalService: NgbModal,
        private notifierService: NotifierService,
        private router: Router,
        private dropdownConfig: NgbDropdownConfig) {
            dropdownConfig.placement = "bottom-right";
    } 

    ngOnInit() {
        this.getTypesList(0);
    }
    
    getTypesList(start: number) {
        this.typeService.getTypesList(start, this.pageSize, this.searchKey).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {         
                this.listOfTypes = response.data;
                this.listSize = this.listOfTypes.length;
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    filterList() {
        this.page = 1;
        this.typeIdList = new Array();
        this.getTypesList(0);
    }

    gotoEdit(typeId: number) {
        this.router.navigate(['/type-edit', typeId]);
    }

    // Check Box Action
    typeIdList: number[] = new Array();
    updateTypeId(event: any, typeId :any){
        let isChecked = event.target.checked;
        if (isChecked) {
            this.typeIdList.push(typeId);
        } else {
            const index: number = this.typeIdList.indexOf(typeId);
            if (index !== -1) {
                this.typeIdList.splice(index, 1);
            }        
        } 
        console.log('list: '+ this.typeIdList);   
    }
    // Check Box Action

    checkArray(content: any) {
        if (Array.isArray(content)) {
            return true;
        }
        return false;
    }

    openedModal: any;
    openDeleteModal(permission: LegalType, content: any) {
        this.removedType = permission;
        this.openedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow'});
    }

    deleteType(typeId: number) {
        let typeList = new Array();
        if (typeof typeId == 'number') {
            typeList.push(typeId);
        } else if (Array.isArray(typeId)) {
            typeList = typeId;
        }
        this.typeService.deleteType(typeList).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getTypesList(startPage);
                this.openedModal.close();
                this.typeIdList = new Array();
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

    /*pageChange(event : any) {
        console.log(event);
        let startPage = (event - 1) * this.pageSize;
        this.getTypesList(startPage);
    }*/

    displayDropDown(event: any) {
        event.preventDefault();
        console.log('testing');
        let isVisible = $(event.currentTarget).data('visible');
        $(event.currentTarget).data('visible', !isVisible);
        if (isVisible) {
            //switch to plus
            $(event.currentTarget).html('<i class="fa fa-fw" aria-hidden="true"></i>');
        } else {
            //switch to minus
            $(event.currentTarget).html('<i class="fa fa-fw" aria-hidden="true"></i>');
        }
        let targetLevel = $(event.currentTarget).data('target');
        let currentRow = $(event.currentTarget).parents('tr').next();
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