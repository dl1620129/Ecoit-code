import { Component, OnInit } from '@angular/core';
import { OrganizationService } from '../service/organization.service';
import { Organization } from '../model/organization.model';
import { Constants } from '../common/constants';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { NotifierService } from 'angular-notifier';
import { Router } from '@angular/router';
import { NgbDropdownConfig } from '@ng-bootstrap/ng-bootstrap';

declare const Liferay: any;
declare const $: any;

@Component({
    selector: 'app-organization-list',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + '/o/ELegal-Web-Organization/app/organization-list.component.html',
    styleUrls: [],
    providers: [],
})
export class OrganizationListComponent implements OnInit {

    arrayOne(n: number): any[] {
        return Array(n);
    }

    pageSize = 5;
    page = 1;
    listSize = 0;
    searchKey = '';

    //declare list of categories
    listOfOrganizations : Organization[] = [];

    removedOrganization: any;
    constructor(private organizationService : OrganizationService,
        private modalService: NgbModal,
        private notifierService: NotifierService,
        private dropdownConfig: NgbDropdownConfig,
        private router: Router) { 
            dropdownConfig.placement = "bottom-right";
    } 

    ngOnInit() {
        this.getAllOrganizations(0);
    }
    
    getAllOrganizations(start: number) {
        this.organizationService.getAllOrganizations(start, this.pageSize, this.searchKey).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.listOfOrganizations = response.data;
                this.listSize = this.listOfOrganizations.length;
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    filterList() {
        this.page = 1;
        this.orgIdList = new Array();
        this.getAllOrganizations(0);
    }

    gotoEdit(organizationId: number) {
        this.router.navigate(['/organization-edit', organizationId]);
    }

    // Check Box Action
    orgIdList: number[] = new Array();
    updateOrgId(event: any, orgId :any){
        let isChecked = event.target.checked;
        if (isChecked) {
            this.orgIdList.push(orgId);
        } else {
            const index: number = this.orgIdList.indexOf(orgId);
            if (index !== -1) {
                this.orgIdList.splice(index, 1);
            }        
        } 
        console.log('list: '+this.orgIdList);
    }

    // Check Box Action
    checkArray(content: any) {
        if (Array.isArray(content)) {
            return true;
        }
        return false;
    }

    openedModal: any;
    openDeleteModal(permission: Organization, content: any) {
        this.removedOrganization = permission;
        this.openedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow'});
    }

    deleteOrganization(orgId: any) {
        let orgList = new Array();
        if (typeof orgId == 'number') {
            orgList.push(orgId);
        } else if (Array.isArray(orgId)) {
            orgList = orgId;
        }
        this.organizationService.deleteOrganization(orgList).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getAllOrganizations(startPage);
                this.openedModal.close();
                this.orgIdList = new Array();
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
        this.getAllOrganizations(startPage);
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