import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PermissionService } from '../../service/permission.service';
import { PermissionRole } from '../../model/PermissionRole.model';
import { ActivatedRoute, ParamMap, Router, Params } from '@angular/router';
import { Constants } from '../../common/Constants';
import { PermissionObject } from '../../model/PermissionObject.model';
import { User } from '../../model/User.model';
import { NotifierService } from 'angular-notifier';
declare const Liferay: any;
declare const $: any;
@Component({
    selector: 'app-permission-editor',
    templateUrl: 
    Liferay.ThemeDisplay.getPathContext() + 
    '/o/MemberReport-Permission/app/permission-editor.component.html'
})

export class PermissionEditorComponent implements OnInit {

    arrayOne(n: number): any[] {
        return Array(n);
    }

    usersList: User[] = new Array();
    permissionsList: PermissionRole[] = new Array();


    groupUserId: any;


    permissionObject: PermissionObject = new PermissionObject();

    constructor(public service: PermissionService,
        public httpClient : HttpClient,
        private route: ActivatedRoute,
        public rt: Router,
        private notifierService: NotifierService) {
    }

    ngOnInit() {
        this.route.paramMap.subscribe((params: ParamMap) =>{
            // console.log("groupid: " + this.groupUserId)
            let paramGroupUserId = "0";
            if (params.get('id')) {
                paramGroupUserId = params.get('id');
                this.groupUserId = params.get('id');
            }
            this.service.updateViewPermission(paramGroupUserId).subscribe((response: any) => {
                console.log(response);
                if (response.error_code == Constants.SUCCESSFUL_CODE) {
                    this.permissionObject.groupName = response.data.name;
                    this.permissionObject.description = response.data.description;
                    this.usersList = response.data.users;
                    this.filterRolesList(response.data.permissions);

                    //initialize form value
                    this.usersList.forEach((element: User) => {
                        if (element.checked) {
                            this.permissionObject.users.push(element.id);
                        }
                    });
                } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                    this.notifierService.notify('warning', Constants.NOT_ACCESS_MESSAGE);
                } else {
                    this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
                }
            });
        });
    }

    submitPermission() {
        this.service.savePermission(this.permissionObject, this.groupUserId).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.rt.navigate(['/permission-list']);
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('warning', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }
  
    // onSubmit(){
    //     this.service.savePermission(this.permission).subscribe((data: any)=>{
    //         this.rt.navigate(['/list']);
    //     })
    // }
    updateUser(event: any,userId :any){
       let isChecked = event.target.checked;
       if(isChecked) {
            this.permissionObject.users.push(userId);
       } else {
            const index: number = this.permissionObject.users.indexOf(userId);
            if (index !== -1) {
                this.permissionObject.users.splice(index, 1);
            }        
       }    
    //    console.log('list: '+this.listUser);
    }

    updatePermission(event: any,permissionId :any){
        let isChecked = event.target.checked;
        if(isChecked) {
             this.permissionObject.permissions.push(permissionId);
        } else {
             const index: number = this.permissionObject.permissions.indexOf(permissionId);
             if (index !== -1) {
                 this.permissionObject.permissions.splice(index, 1);
             }        
        } 
        console.log('list: '+this.permissionObject.permissions);   
    }

    filterRolesList(rawList: PermissionRole[]) {
        rawList.forEach((element: any) => {
            let permissionRole = new PermissionRole();
            permissionRole.name = Liferay.Language.get(element.name);

            switch(element.name) {
                case "ecoit.baocao.manage.permission.option0":
                    permissionRole.name = "Tạo báo cáo";
                    break;
                case "ecoit.baocao.manage.permission.option1":
                    permissionRole.name = "Gửi báo cáo";
                    break;
                case "ecoit.baocao.manage.permission.option2":
                    permissionRole.name = "Chỉnh sửa báo cáo";
                    break;
                case "ecoit.baocao.manage.permission.option3":
                    permissionRole.name = "Xóa báo cáo";
                    break;
                case "ecoit.baocao.manage.permission.option4":
                    permissionRole.name = "Xem tất cả báo cáo";
                    break;
                case "ecoit.baocao.manage.permission.option5":
                    permissionRole.name = "Phân quyền";
                    break;
            };

            permissionRole.id = element.id;
            permissionRole.checked = element.checked;
            if (element.checked) {
                this.permissionObject.permissions.push(element.id);
            }
            this.permissionsList.push(permissionRole);
        });
    }

    displayDropDown(event: any) {
        event.preventDefault();
        console.log('envent: '+JSON.stringify(event));
        let isVisible = $(event.currentTarget).data('visible');
        $(event.currentTarget).data('visible', !isVisible);
        if (isVisible) {
            //switch to plus
            $(event.currentTarget).html('<i class="fa fa-fw" aria-hidden="true"></i>');
        } else {
            //switch to minus
            $(event.currentTarget).html('<i class="fa fa-fw" aria-hidden="true"></i>').css('display', 'none');
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

            if ($(currentRow).find('.dropdown-btn').length > 0 && isShow) {
                if (($(currentRow).next().data('level') - targetLevel) !== 1) {
                    mainVisible = !$(currentRow).find('.dropdown-btn').data('visible');
                } else {
                    mainVisible = isVisible;
                }
            }
            currentRow = $(currentRow).next();
            currentLevel = $(currentRow).data('level');
        }

    }
}  