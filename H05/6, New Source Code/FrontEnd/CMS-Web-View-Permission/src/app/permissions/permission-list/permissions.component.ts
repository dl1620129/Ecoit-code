import { Component, OnInit } from '@angular/core';
import { PermissionModel } from '../../model/PermissionModel.model';
import { PermissionService } from "../../service/permission.service";
import { Observable } from 'rxjs';
import { HttpHeaders, HttpParams, HttpClient } from '@angular/common/http';
import { TokenParams } from '../../model/Tokenparams.model';
import { Router } from '@angular/router';
import { Constants } from '../../common/Constants';
import { NotifierService } from 'angular-notifier';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
declare const Liferay: any;

@Component({
    selector: 'app-list',
    templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/CMSWebViewPermission/app/permissions/permissions.component.html'
})

export class permissionsComponent implements OnInit {

    listUser: any =[];
    listPermisson: any =[];
    listCategory: any =[];
    removedEvent: any;
    tokenParams: TokenParams;
    permissions: PermissionModel[];
    permission: PermissionModel = new PermissionModel();
    access_Token_ ='';
    pageSize = 5;
    listSize = 1;
    page = 1;
    searchKey='';
    constructor( public service: PermissionService,public httpClient : HttpClient,public modalService:NgbModal,public router: Router,public notifierService: NotifierService ) { }

    ngOnInit() {
        this.ViewPermission();
        this.getAllPermissionData(0); 
    }
    ViewPermission(){
        this.service.viewPermission().subscribe(data=>{
        });
    }
    
    getAllPermissionData(start: number){
       
        this.service.getAllPermission(start, this.pageSize,this.searchKey).subscribe((respone: any) =>{
            this.permissions = respone.data.data;
            this.listSize= respone.data.total;
        })
     
    }
    
    filterList() {
        this.page = 1;
        this.getAllPermissionData(0);
    }
    viewPermission(id: number){
        this.service.updateViewPermission(id).subscribe((res:any) => {
            this.permission = res.data;
        });
        
    }
    deletePermission(id: number){
        this.service.deletePermission(id).subscribe((response:any) =>{
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getAllPermissionData(startPage);
                this.openedModal.close();
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        })
      
    }
    pageChange(event : any) {
        let startPage = (event - 1) * this.pageSize;
        this.getAllPermissionData(startPage);
    }
    openedModal: any;
    openDeleteModal(event: any, content: any) {
        this.removedEvent = event;
        this.openedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow'});
       
    }
    
   
} 