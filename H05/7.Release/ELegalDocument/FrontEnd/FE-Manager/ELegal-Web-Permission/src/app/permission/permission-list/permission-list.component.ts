import { Component, OnInit } from '@angular/core';
import { PermissionGroup } from '../../model/PermissionGroup.model';
import { PermissionService } from "../../service/permission.service";
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { NotifierService } from 'angular-notifier';
import { Constants } from '../../common/Constants';
import { NgbDropdownConfig } from '@ng-bootstrap/ng-bootstrap';

declare const Liferay: any;

@Component({
    selector: 'app-permission-list',
    templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/ELegal-Web-Permission/app/permission-list.component.html'
})

export class PermissionListComponent implements OnInit {

    groupUsersList: PermissionGroup[];
    access_Token_ ='';
    pageSize = 5;
    listSize = 0;
    page = 1;
    searchKey='';
    constructor( public service: PermissionService ,public router: Router, 
        private modalService: NgbModal,
        private notifierService: NotifierService,
        private dropdownConfig: NgbDropdownConfig) {
            dropdownConfig.placement = "bottom-right";
    }

    ngOnInit() {
        this.getAllPermissionData(0); 
    }

    gotoEdit(groupUserId: number) {
        this.router.navigate(['/permission-edit', groupUserId]);
    }

    getAllPermissionData(start: number) {
        this.service.getAllPermission(start, this.pageSize,this.searchKey).subscribe((response: any) =>{
            // console.log('data: '+JSON.stringify(respone.data));
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.groupUsersList = response.data.data;
                this.listSize= response.data.total;
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('warning', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
            
        })
    }
    
    filterList() {
        this.page = 1;
        this.groupIdList = new Array();
        this.getAllPermissionData(0);
    }

    // Check Box Action
    groupIdList: number[] = new Array();
    updatePermissionGroup(event: any, groupId :any){
        let isChecked = event.target.checked;
        if (isChecked) {
             this.groupIdList.push(groupId);
        } else {
             const index: number = this.groupIdList.indexOf(groupId);
             if (index !== -1) {
                 this.groupIdList.splice(index, 1);
             }        
        } 
        console.log('list: '+ this.groupIdList);   
    }
    // Check Box Action

    checkArray(content: any) {
        if (Array.isArray(content)) {
            return true;
        }
        return false;
    }

    removedPermission: PermissionGroup;
    openedModal: any;
    openDeleteModal(permission: PermissionGroup, content: any) {
        this.removedPermission = permission;
        this.openedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow'});
    }

    deletePermission(groupId: number) {
        let groupList = new Array();
        if (typeof groupId == 'number') {
            groupList.push(groupId);
        } else if (Array.isArray(groupId)) {
            groupList = groupId;
        }
        this.service.deletePermissionGroup(groupList).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getAllPermissionData(startPage);
                this.openedModal.close();
                this.groupIdList = new Array();
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('warning', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    pageChange(event : any) {
        let startPage = (event - 1) * this.pageSize;
        this.getAllPermissionData(startPage);
    }
    
   
} 