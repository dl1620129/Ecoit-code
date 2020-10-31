import { Component, OnInit } from "@angular/core";
import { LinkService } from "../service/Link.service";
import { LinksModel } from "../model/Link.model";
import { Routes } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { NotifierService } from "angular-notifier";
import { Constants } from '../common/Constants';
import { NgbDropdownConfig } from '@ng-bootstrap/ng-bootstrap';
declare const Liferay: any;
@Component({
    selector: 'app-list',
    templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/Link-FrontEnd/app/links-list.component.html'
})
export class LinksComponent implements OnInit{
    pageSize= 10;
    page = 1;
    listSize = 0;
    searchKey = '';
    linkModels: LinksModel[];
    removedEvent: any;
    grouplink:any;
    constructor(public linkService: LinkService, public modalService:NgbModal,public notifierService: NotifierService,private  dropdownConfig:NgbDropdownConfig){
        dropdownConfig.placement = "bottom-right";
    }
    ngOnInit() {

        this.getLinkData(0);
        
    }
    getLinkData(start: number){
        this.linkService.getAllLinks(this.pageSize,start,this.searchKey).subscribe((res: any) =>{
            this.linkModels = res.data[0].data;
            this.listSize=res.data[0].total;
        //    for(let item of this.linkModels){
        //         this.linkService.getGroupLinkById(item.linksgroupid).subscribe((respone:any)=>{
        //             this.grouplink= respone.data;
        //             for(let itemgroup of this.grouplink){
        //                 if(item.linksgroupid= itemgroup.linksgroupid){
        //                 }
        //             }
        //         })
        //    }
           
        })
    }
   

    pageChange(event: any){
        let startPage = (event - 1) * this.pageSize;
        this.getLinkData(startPage);
    }
    removeLink(id:number){
        this.linkService.deleteLinks(id).subscribe((data:any) =>{
            let startPage = (this.page - 1) * this.pageSize;
            this.getLinkData(startPage);
            if (data.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getLinkData(startPage);
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
        this.getLinkData(0);
    }
    listId: any[] = new Array();
    masterSelected: boolean;
    selectAll(event: any) {
        let isChecked = event.target.checked;
        if (isChecked) {
            for (let i = 0; i < this.linkModels.length; i++) {
                this.linkModels[i].selected = this.masterSelected;
                if(this.listId.indexOf(this.linkModels[i].linksid) == -1){
                    this.listId.push(this.linkModels[i].linksid);
                }
            }
        } else {
            for (let i = 0; i < this.linkModels.length; i++) {
                this.linkModels[i].selected = this.masterSelected;
                if (this.listId.indexOf(this.linkModels[i].linksid) !== -1) {
                    this.listId.splice(this.listId.indexOf(this.linkModels[i].linksid), 1);
                }
            }
        }

    }
    checkIfAllSelected(event: any, id: number) {
        this.masterSelected = this.linkModels.every(function (item: any) {
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
        this.linkService.deleteMutiple(this.listId).subscribe((data:any) => {
            if (data.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getLinkData(startPage);
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