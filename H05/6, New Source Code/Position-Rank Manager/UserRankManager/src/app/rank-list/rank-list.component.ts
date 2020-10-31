import { Component, OnInit } from "@angular/core";

import { Routes } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Constants } from '../common/Constants';
import { NotifierService } from 'angular-notifier';
import { RankService } from '../service/rank.service';
import { RankModel } from '../model/rank.model';
import { NgbDropdownConfig } from '@ng-bootstrap/ng-bootstrap';
declare const Liferay: any;
@Component({
    selector: 'app-list',
    templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/UserRankManager/app/rank-list.component.html'
})
export class RankComponent implements OnInit{
    pageSize= 5;
    page = 1;
    listSize = 0;
    searchKey = '';
    rankModels: RankModel[];
    removedEvent: any;
    constructor(public rankservice: RankService, public modalService:NgbModal,public notifierService: NotifierService,private  dropdownConfig:NgbDropdownConfig){
        dropdownConfig.placement = "bottom-right"; 

    }
    ngOnInit() {
        this.getCategoryData(0);
    }
    getCategoryData(start: number){
        this.rankservice.getAllCategory(this.pageSize,start,this.searchKey).subscribe((res: any) =>{
            if(res.error_code == Constants.SUCCESSFUL_CODE){
                console.log(res);
            this.rankModels = res.data[0].userRank;
            this.listSize=res.data[0].total;
        } else if (res.error_code == Constants.NOT_ACCESS_CODE) {
            this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
        }else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        })
    }
    pageChange(event: any){
        let startPage = (event - 1) * this.pageSize;
        this.getCategoryData(startPage);
    }
    removeCategory(id:number){
        this.rankservice.deleteCategory(id).subscribe((response:any) =>{
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getCategoryData(startPage);
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
        this.getCategoryData(0);
    }
    listId: any[] = new Array();
    masterSelected: boolean;
    selectAll(event: any) {
        let isChecked = event.target.checked;
        if (isChecked) {
            for (let i = 0; i < this.rankModels.length; i++) {
                this.rankModels[i].selected = this.masterSelected;
                if(this.listId.indexOf(this.rankModels[i].userRankId) == -1){
                    this.listId.push(this.rankModels[i].userRankId);
                }
            }
        } else {
            for (let i = 0; i < this.rankModels.length; i++) {
                this.rankModels[i].selected = this.masterSelected;
                if (this.listId.indexOf(this.rankModels[i].userRankId) !== -1) {
                    this.listId.splice(this.listId.indexOf(this.rankModels[i].userRankId), 1);
                }
            }
        }

    }
    checkIfAllSelected(event: any, id: number) {
        this.masterSelected = this.rankModels.every(function (item: any) {
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
        this.rankservice.deleteMutiple(this.listId).subscribe(data => {
            let startPage = (this.page - 1) * this.pageSize;
            this.getCategoryData(startPage);
            this.listId = [];
        });

    }

}