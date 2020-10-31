import { Component, OnInit } from "@angular/core";

import { Routes } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { GroupLinkService } from "../service/groupLink.service";
import { GroupLinksModel } from "../model/groupLink.model";
import { Constants } from '../common/Constants';
import { NotifierService } from "angular-notifier";
import { NgbDropdownConfig } from '@ng-bootstrap/ng-bootstrap';

declare const Liferay: any;
@Component({
    selector: 'app-list',
    templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/GroupLink-FrontEnd/app/grouplink-list.component.html'
})
export class GroupLinkComponent implements OnInit{
    pageSize= 10;
    page = 1;
    listSize = 0;
    searchKey = '';
    groupLinkModel: GroupLinksModel[];
    removedEvent: any;
    constructor(public grouplinkService: GroupLinkService, public modalService:NgbModal, public notifierService: NotifierService,private  dropdownConfig:NgbDropdownConfig){
        dropdownConfig.placement = "bottom-right";
    }
    ngOnInit() {
        this.getGroupLinkData(0);
    }
    getGroupLinkData(start: number){
        this.grouplinkService.getAllGroupLinks(this.pageSize,start,this.searchKey).subscribe((res: any) =>{
            this.groupLinkModel = res.data.data;
            this.listSize=res.data.total;
        })
    }
    pageChange(event: any){
        let startPage = (event - 1) * this.pageSize;
        this.getGroupLinkData(startPage);
    }
    removeGroupLink(id:number){
        this.grouplinkService.deleteGroupLinks(id).subscribe((data:any) =>{
            
            if (data.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getGroupLinkData(startPage);
                this.openedModal.close();
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (data.error_code == Constants.NOT_ACCESS_CODE) {
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
        this.getGroupLinkData(0);
    }
    listId: any[] = new Array();
    masterSelected: boolean;
    selectAll(event: any) {
        let isChecked = event.target.checked;
        if (isChecked) {
            for (let i = 0; i < this.groupLinkModel.length; i++) {
                this.groupLinkModel[i].selected = this.masterSelected;
                if(this.listId.indexOf(this.groupLinkModel[i].linksgroupid) == -1){
                    this.listId.push(this.groupLinkModel[i].linksgroupid);
                }
            }
        } else {
            for (let i = 0; i < this.groupLinkModel.length; i++) {
                this.groupLinkModel[i].selected = this.masterSelected;
                if (this.listId.indexOf(this.groupLinkModel[i].linksgroupid) !== -1) {
                    this.listId.splice(this.listId.indexOf(this.groupLinkModel[i].linksgroupid), 1);
                }
            }
        }

    }
    checkIfAllSelected(event: any, id: number) {
        this.masterSelected = this.groupLinkModel.every(function (item: any) {
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
        this.grouplinkService.deleteMutiple(this.listId).subscribe((data:any) => {
            if (data.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getGroupLinkData(startPage);
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