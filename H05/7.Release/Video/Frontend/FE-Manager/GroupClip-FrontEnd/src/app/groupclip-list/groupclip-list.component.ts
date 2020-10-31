import { Component, OnInit } from "@angular/core";

import { Routes } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { GroupClipService } from "../service/groupClip.service";
import { GroupClipModel } from '../model/groupClip.model';
import { Constants } from '../common/Constants';
import { NotifierService } from 'angular-notifier';
import { NgbDropdownConfig } from '@ng-bootstrap/ng-bootstrap';
declare const Liferay: any;
@Component({
    selector: 'app-list',
    templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/GroupClip-FrontEnd/app/groupclip-list.component.html'
})
export class GroupClipComponent implements OnInit{
    pageSize= 10;
    page = 1;
    listSize = 0;
    searchKey = '';
    groupclipModels: GroupClipModel[];
    clipmodel: GroupClipModel= new GroupClipModel();
    removedEvent: any;
    constructor(public groupclipService: GroupClipService, public modalService:NgbModal, public notifierService: NotifierService,private  dropdownConfig:NgbDropdownConfig){
        dropdownConfig.placement = "bottom-right";

    }
    ngOnInit() {
        this.getGroupclipData(0);
    }
    getGroupclipData(start: number){
     
        this.groupclipService.getAllGroupClips(this.pageSize, start, this.searchKey).subscribe((res: any) => {
            if (res.error_code == Constants.SUCCESSFUL_CODE) {
                this.groupclipModels = res.data[0].data;
                this.listSize = res.data[0].total;
            } else if (res.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        })
    }
    pageChange(event: any){
        let startPage = (event - 1) * this.pageSize;
        this.getGroupclipData(startPage);
    }
    removeGroupclip(id:number){
        this.openedModal.close();
        this.groupclipService.deleteGroupClips(id).subscribe((response: any) => {
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getGroupclipData(startPage);
                this.openedModal.close();
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        })
    }
    openedModal: any;
    openDeleteModal(event: any, content: any) {
        this.removedEvent = event;
        this.openedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow'});
       
    }
    filterList(){
        this.page=1;
        this.getGroupclipData(0);
    }
    listId: any[] = new Array();
    masterSelected: boolean;
    selectAll(event: any) {
        let isChecked = event.target.checked;
        if (isChecked) {
            for (let i = 0; i < this.groupclipModels.length; i++) {
                this.groupclipModels[i].selected = this.masterSelected;
                if(this.listId.indexOf(this.groupclipModels[i].id) == -1){
                    this.listId.push(this.groupclipModels[i].id);
                }
            }
        } else {
            for (let i = 0; i < this.groupclipModels.length; i++) {
                this.groupclipModels[i].selected = this.masterSelected;
                if (this.listId.indexOf(this.groupclipModels[i].id) !== -1) {
                    this.listId.splice(this.listId.indexOf(this.groupclipModels[i].id), 1);
                }
            }
        }

    }
    checkIfAllSelected(event: any, id: number) {
        this.masterSelected = this.groupclipModels.every(function (item: any) {
            return item.selected == true;
        })
        let isChecked = event.target.checked;
        if (isChecked) {
            this.listId.push(id)
        }
        else {
            const index: number = this.listId.indexOf(id);
            if (index !== -1) {
                this.listId.splice(index, 1);
            }
        }
    }
    removeMutiple() {
        this.groupclipService.deleteMutiple(this.listId).subscribe((data:any) => {
           
            if (data.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
            this.getGroupclipData(startPage);
            this.listId = [];
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (data.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });

    }
    

}