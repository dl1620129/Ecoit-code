import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PermissionService } from '../../service/permission.service';
import { PermissionRole } from '../../model/PermissionRole.model';
import { ActivatedRoute, ParamMap, Router, Params } from '@angular/router';
import { Constants } from '../../common/Constants';
import { Category } from '../../model/Category.model';
import { PermissionObject } from '../../model/PermissionObject.model';
import { User } from '../../model/User.model';
import { NotifierService } from 'angular-notifier';
declare const Liferay: any;
declare const $: any;
@Component({
    selector: 'app-permission-editor',
    templateUrl: 
    Liferay.ThemeDisplay.getPathContext() + 
    '/o/QA-Web-Permission/app/permission-editor.component.html'
})

export class PermissionEditorComponent implements OnInit {

    arrayOne(n: number): any[] {
        return Array(n);
    }

    usersList: User[] = new Array();
    permissionsList: PermissionRole[] = new Array();
    categoriesList: Category[] = new Array();


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
                    this.permissionObject.name = response.data.name;
                    this.permissionObject.description = response.data.description;
                    this.usersList = response.data.users;
                    this.filterRolesList(response.data.permissions);
                    this.categoriesList = response.data.categories;

                    //initialize form value
                    this.usersList.forEach((element: User) => {
                        if (element.checked) {
                            this.permissionObject.users.push(element.id);
                        }
                    });
                    this.appendFormCategories(this.categoriesList);
                } else {
                    this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
                }
            });
        });
    }

    appendFormCategories(rawCategoriesList: Category[]) {
        rawCategoriesList.forEach((element: Category) => {
            if (element.checked) {
                this.permissionObject.categories.push(element.categoryId);
            }
            this.appendFormCategories(element.child);
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

    updateCategory(event: any, categoryId: any){
        
        let isChecked= event.target.checked;
        if(isChecked){
            this.permissionObject.categories.push(categoryId);
        }else{
            const index: number = this.permissionObject.categories.indexOf(categoryId);
            if(index!=-1){
                this.permissionObject.categories.splice(index,1);
            }
           
        }
        this.setCheckBoxforRecursiveTree(isChecked, event, "categoryCheck");
        console.log('category: '+this.permissionObject.categories);
    }
    

    setCheckBoxforRecursiveTree(isChecked: boolean, event: any, checkBoxName: string) {
        if(isChecked) {
            let parentListItems = $(event.target).parent().parent().parents('li');
            if (parentListItems.length > 0) {
                let inputCheck =  $(parentListItems[0]).children('.form-check').find('input[name="' + checkBoxName + '"]');
                if (!$(inputCheck).prop('checked')) {
                    $(inputCheck).click();
                }
            }
       } else {
           let childrenListItems = $(event.target).parent().next('ul');
           if (childrenListItems.length > 0) {
               let inputChecks =  $(childrenListItems).children('li');         
               inputChecks.each(function(index: number, element: any) {
                   let checkBox = $(element).children('.form-check').find('input[name="' + checkBoxName + '"]');
                   if($(checkBox).prop('checked')) {
                       $(checkBox).click();
                   }
               });
           }
       } 
    }

    filterRolesList(rawList: PermissionRole[]) {
        rawList.forEach((element: any) => {
            let permissionRole = new PermissionRole();
            permissionRole.name = Liferay.Language.get(element.name);

            switch(element.name) {
                case "ecoit.doc.manage.permission.option0":
                    permissionRole.name = "Chỉnh sửa phản hồi";
                    break;
                case "ecoit.doc.manage.permission.option1":
                    permissionRole.name = "Xóa phản hồi";
                    break;
                case "ecoit.doc.manage.permission.option2":
                    permissionRole.name = "Duyệt phản hồi";
                    break;
                case "ecoit.doc.manage.permission.option3":
                    permissionRole.name = "Hủy duyệt phản hồi";
                    break;
                case "ecoit.doc.manage.permission.option4":
                    permissionRole.name = "Xuất bản phản hồi";
                    break;
                case "ecoit.doc.manage.permission.option5":
                    permissionRole.name = "Hủy xuất bản phản hồi";
                    break;
                case "ecoit.doc.manage.permission.option6":
                    permissionRole.name = "Chỉnh sửa chuyên mục";
                    break;
                case "ecoit.doc.manage.permission.option7":
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
}  