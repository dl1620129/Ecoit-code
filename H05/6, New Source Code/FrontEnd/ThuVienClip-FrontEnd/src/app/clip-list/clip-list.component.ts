import { Component, OnInit } from "@angular/core";
import { Routes } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ClipService } from "../service/clip.service";
import { ClipModel } from '../model/Clip.model';
import { NotifierService } from 'angular-notifier';
import { Constants } from '../common/Constants';
import { NgbDropdownConfig } from '@ng-bootstrap/ng-bootstrap';
declare const Liferay: any;
@Component({
    selector: 'app-list',
    templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/ThuVienClip-FrontEnd/app/clip-list.component.html'
})
export class ClipComponent implements OnInit{
    page= 1;
    pageSize= 5;
    searchKey = '';
    listSize =0;
    clipModels : ClipModel[];
    removedEvent: any;
    clipCategory:any;
    constructor(public clipService: ClipService,public modalService: NgbModal,public notifierService: NotifierService, private  dropdownConfig:NgbDropdownConfig){
        dropdownConfig.placement = "bottom-right";

    }
    ngOnInit() {
        this.getClipData(0);
    }
    getClipData(start: number){
        // this.clipService.getAllClip(this.pageSize,start,this.searchKey).subscribe((res:any)=>{
        //     this.clipModels= res.data[0].data;
        //     this.listSize= res.data[0].total;
        // })
        this.clipService.getAllClip(this.pageSize,start,this.searchKey).subscribe((res: any) =>{
            if(res.error_code == Constants.SUCCESSFUL_CODE){
                this.clipModels= res.data[0].data;
                this.listSize= res.data[0].total;
        } else if (res.error_code == Constants.NOT_ACCESS_CODE) {
            this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
        }else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        })
    }
    getClipCategoryData(){
        this.clipService.getClipcategory().subscribe((respone:any)=>{
            this.clipCategory= respone.data[0].data;
        })
    }
    removeClip(id: number){
       
        this.clipService.deleteClip(id).subscribe((response:any) =>{
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getClipData(startPage);
                this.openedModal.close();
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        })
    }
    pageChange(event: any){
        let start=(event-1)*this.pageSize;
        this.getClipData(start);
    }
    openedModal: any;
    openDeleteModal(event: any, content: any) {
        this.removedEvent = event;
        this.openedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow'});
    }
    filterList(){
        this.page=1;
        this.getClipData(0);
    }
    listId: any[] = new Array();
    masterSelected: boolean;
    selectAll(event: any) {
        let isChecked = event.target.checked;
        if (isChecked) {
            for (let i = 0; i < this.clipModels.length; i++) {
                this.clipModels[i].selected = this.masterSelected;
                if(this.listId.indexOf(this.clipModels[i].id) == -1){
                    this.listId.push(this.clipModels[i].id);
                }
            }
        } else {
            for (let i = 0; i < this.clipModels.length; i++) {
                this.clipModels[i].selected = this.masterSelected;
                if (this.listId.indexOf(this.clipModels[i].id) !== -1) {
                    this.listId.splice(this.listId.indexOf(this.clipModels[i].id), 1);
                }
            }
        }

    }
    checkIfAllSelected(event: any, id: number) {
        this.masterSelected = this.clipModels.every(function (item: any) {
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
        this.clipService.deleteMutiple(this.listId).subscribe((data:any) => {
           
            if (data.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
            this.getClipData(startPage);
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