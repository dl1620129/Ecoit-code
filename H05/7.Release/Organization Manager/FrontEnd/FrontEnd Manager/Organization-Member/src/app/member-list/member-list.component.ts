import { Component, OnInit } from "@angular/core";

import { Routes } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Constants } from '../common/Constants';
import { NotifierService } from 'angular-notifier';
import { MemberModel } from '../model/member.model';
import { MemberService } from '../service/Member.service';
import { OrganizationModel } from '../model/organization.model';

declare const Liferay: any;
@Component({
    selector: 'app-list',
    templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/Organization-Member/app/member-list.component.html'
})
export class MemberComponent implements OnInit{
    pageSize= 5;
    page = 1;
    listSize = 0;
    searchKey = '';
    organId=0;
    memberModels: MemberModel[];
    removedEvent: any;
    masterSelected: boolean;
    listIdChecked: any= [];
    constructor(public memberService: MemberService, public modalService:NgbModal,public notifierService: NotifierService){}
    ngOnInit() {
        
        this.getMemberByOrganData(0);
        this.getOrganData();
    }
    getMemberByOrganData(start: number){
        this.memberService.getAllMemberByOrgan(this.pageSize,start,this.organId).subscribe((res: any) =>{
            if(res.error_code == Constants.SUCCESSFUL_CODE){
              
            this.memberModels = res.data[0].data;
            this.listSize=res.data[0].total;
        } else if (res.error_code == Constants.NOT_ACCESS_CODE) {
            this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
        }else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        })
    }
    getMemberData(start: number){
        this.memberService.getAllMember(this.pageSize,start,this.searchKey).subscribe((res: any) =>{
            if(res.error_code == Constants.SUCCESSFUL_CODE){
            this.memberModels = res.data[0].data;
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
        this.getMemberByOrganData(startPage);
    }
    removeImage(id:number){
        this.memberService.deleteImage(id).subscribe((response:any) =>{
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getMemberByOrganData(startPage);
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
        this.getMemberByOrganData(this.page);
    }
    listOrgan: any=[];
    listOrgan2: any=[];
    getOrganData(){
        this.memberService.getAllOrgan().subscribe((res: any)=>{
            this.listOrgan2=res.data.data;
            this.memberService.convertTreeList(this.listOrgan2,1,this.listOrgan);
            console.log(JSON.stringify(this.listOrgan));
        })

    }
    getData(event:any){
        this.organId= event.target.value;
        console.log(this.organId);
        this.getMemberByOrganData(0);
    }


}