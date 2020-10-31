import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PermissionService } from '../../service/permission.service';
import { PermissionRole } from '../../model/PermissionRole.model';
import { ActivatedRoute, ParamMap, Router, Params } from '@angular/router';
import { Constants } from '../../common/Constants';
import { Category } from '../../model/Category.model';
import { PermissionObject } from '../../model/PermissionObject.model';
import { User } from '../../model/User.model';
import { Field } from '../../model/Field.model';
import { Organization } from '../../model/Organization.model';
import { NotifierService } from 'angular-notifier';
declare const Liferay: any;
declare const $: any;
@Component({
    selector: 'app-permission-editor',
    templateUrl: 
    Liferay.ThemeDisplay.getPathContext() + 
    '/o/ELegal-Web-Permission/app/permission-editor.component.html'
})

export class PermissionEditorComponent implements OnInit {

    arrayOne(n: number): any[] {
        return Array(n);
    }

    usersList: User[] = new Array();
    permissionsList: PermissionRole[] = new Array();
    organizationsList: Organization[] = new Array();
    fieldsList: Field[] = new Array();
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
                    this.permissionObject.groupName = response.data.name;
                    this.permissionObject.description = response.data.description;
                    this.usersList = response.data.users;
                    this.filterRolesList(response.data.permissions);
                    this.organizationsList = response.data.organs;
                    this.fieldsList = response.data.fields;
                    this.categoriesList = response.data.categories;

                    //initialize form value
                    this.usersList.forEach((element: User) => {
                        if (element.checked) {
                            this.permissionObject.users.push(element.id);
                        }
                    });
                    this.fieldsList.forEach((element: Field) => {
                        if (element.checked) {
                            this.permissionObject.fields.push(element.id);
                        }
                    });
                    this.appendFormCategories(this.categoriesList);
                    this.appendFormOrganization(this.organizationsList);
                } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                    this.notifierService.notify('warning', Constants.NOT_ACCESS_MESSAGE);
                } else {
                    this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
                }
            });
        });
    }

    appendFormCategories(rawCategoriesList: Category[]) {
        rawCategoriesList.forEach((element: Category) => {
            if (element.checked) {
                this.permissionObject.categories.push(element.typeId);
            }
            this.appendFormCategories(element.child);
        });
    }

    appendFormOrganization(rawCategoriesList: Organization[]) {
        rawCategoriesList.forEach((element: Organization) => {
            if (element.checked) {
                this.permissionObject.organizations.push(element.organizationId);
            }
            this.appendFormOrganization(element.child);
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

    updateOrganization(event: any, organizationId :any){
        let isChecked = event.target.checked;
        if(isChecked) {
             this.permissionObject.organizations.push(organizationId);
        } else {
            const index: number = this.permissionObject.organizations.indexOf(organizationId);
            if (index !== -1) {
                 this.permissionObject.organizations.splice(index, 1);
            }
        }
        this.setCheckBoxforRecursiveTree(isChecked, event, "organizationCheck");
        console.log('list: '+this.permissionObject.organizations);   
    }

    updateField(event: any, fieldId :any){
        let isChecked = event.target.checked;
        if(isChecked) {
             this.permissionObject.fields.push(fieldId);
        } else {
             const index: number = this.permissionObject.fields.indexOf(fieldId);
             if (index !== -1) {
                 this.permissionObject.fields.splice(index, 1);
             }        
        } 
        console.log('list: '+this.permissionObject.fields);   
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
                    permissionRole.name = "Tạo văn bản";
                    break;
                case "ecoit.doc.manage.permission.option1":
                    permissionRole.name = "Chỉnh sửa văn bản";
                    break;
                case "ecoit.doc.manage.permission.option2":
                    permissionRole.name = "Xóa văn bản";
                    break;
                case "ecoit.doc.manage.permission.option3":
                    permissionRole.name = "Duyệt văn bản";
                    break;
                case "ecoit.doc.manage.permission.option4":
                    permissionRole.name = "Hủy duyệt văn bản";
                    break;
                case "ecoit.doc.manage.permission.option5":
                    permissionRole.name = "Xuất bản văn bản";
                    break;
                case "ecoit.doc.manage.permission.option6":
                    permissionRole.name = "Hủy xuất bản văn bản";
                    break;
                case "ecoit.doc.manage.permission.option7":
                    permissionRole.name = "Chỉnh sửa lĩnh vực văn bản";
                    break;
                case "ecoit.doc.manage.permission.option8":
                    permissionRole.name = "Chỉnh sửa loại văn bản";
                    break;
                case "ecoit.doc.manage.permission.option9":
                    permissionRole.name = "Chỉnh sửa cơ quan ban hành";
                    break;
                case "ecoit.doc.manage.permission.option10":
                    permissionRole.name = "Chỉnh sửa người ký";
                    break;
                case "ecoit.doc.manage.permission.option11":
                    permissionRole.name = "Phân quyền";
                    break;
                case "ecoit.doc.manage.permission.option12":
                    permissionRole.name = "Gửi chờ duyệt văn bản";
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