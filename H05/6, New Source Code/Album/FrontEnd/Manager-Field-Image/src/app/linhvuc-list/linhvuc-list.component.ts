import { Component, OnInit } from "@angular/core";

import { Routes } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { LinhVucModel } from '../model/LinhVuc.model';
import { LinhVucService } from '../service/linhVuc.service';
import { Constants } from '../common/Constants';
import { NotifierService } from 'angular-notifier';

declare const Liferay: any;
@Component({
    selector: 'app-list',
    templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/Manager-Field-Image/app/linhvuc-list.component.html'
})
export class LinhVucComponent implements OnInit{
    pageSize= 5;
    page = 1;
    listSize = 0;
    searchKey = '';
    linhVucModels: LinhVucModel[];
    removedEvent: any;
    constructor(public linhVucService: LinhVucService, public modalService:NgbModal,public notifierService: NotifierService){}
    ngOnInit() {
        this.getGroupLinkData(0);
    }
    getGroupLinkData(start: number){
        this.linhVucService.getAllLinhVuc(this.pageSize,start,this.searchKey).subscribe((res: any) =>{
            if(res.error_code == Constants.SUCCESSFUL_CODE){
            this.linhVucModels = res.data[0].data;
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
        this.getGroupLinkData(startPage);
    }
    removeLinhVuc(id:number){
        this.linhVucService.deleteLinhVuc(id).subscribe((response:any) =>{
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getGroupLinkData(startPage);
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
        this.getGroupLinkData(0);
    }

}