import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { PermissionService } from '../../service/permission.service';
import { RoleConstant } from '../../model/RoleConstants.model';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { PermissionModel } from '../../model/PermissionModel.model';
import { ActivatedRoute, ParamMap, Router, Params } from '@angular/router';
import { Category } from '../../model/CategoryModel.model';
import { reserveSlots } from '@angular/core/src/render3/instructions';
import { Constants } from '../../common/Constants';
import { NotifierService } from 'angular-notifier';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
declare const Liferay: any;
declare const $: any;
@Component({
    selector: 'app-crud',
    templateUrl: 
    Liferay.ThemeDisplay.getPathContext() + 
    '/o/CMSWebViewPermission/app/permissions/child/child.component.html'
})

export class childComponent implements OnInit {
    roleConstant: RoleConstant[];
    // roleCategory: any;
    permission: PermissionModel;
    users: any;
    resData: PermissionModel;
    groupUserId: any;
    roleConstants: any;
    rolePermissions: any;
    listOfCategories : any = [];
    listOfCategories2 : any = [];
    listUser: any =[];
    listPermisson: any =[];
    listCategoies: any =[];
    checkCate: any= [];
    constructor(public service: PermissionService,
        public httpClient : HttpClient,
        private route: ActivatedRoute,
        public rt: Router,
        public notifierService: NotifierService) {
            this.permission = new PermissionModel();
         

        }
        arrayOne(n: number): any[] {
            return Array(n);
        }
    
    permissionForm = new FormGroup({
        namePermission:  new FormControl('', Validators.required),
        description: new FormControl(),
        user: new FormControl(),
        permiss:new FormControl(),
        cate: new FormControl()
    })
    get namePermission(){  
        return this.permissionForm.get('namePermission');  
      } 

      checkId(id: number){
        const found = this.checkCate.find((element:any) => element === id);
        if(found == undefined){
          return false
        }else return true;
    }
    ngOnInit() {
        this.route.paramMap.subscribe((params: ParamMap) =>{
            this.groupUserId = params.get('id');
            if(this.groupUserId != null){
                this.service.updateViewPermission(this.groupUserId).subscribe((res:any)=>{
                    this.listOfCategories2 = res.data.categoriesNode;
                    this.service.convertTreeList(this.listOfCategories2, 1, this.listOfCategories);
                    for (var i = 0; i <  res.data.categories.length; i++) {
                        this.checkCate.push(res.data.categories[i].categoryId);
                    }
                    this.permissionForm.patchValue({
                        namePermission: res.data.name,
                        description: res.data.description
                    })
                    res.data.users.forEach((user:any) => {
                        if(user.checked) {
                            this.listUser.push(user.userId);
                        }
                    });
                    res.data.categories.forEach((category:any) => {
                        if(category.checked) {
                            this.listCategoies.push(category.categoryId);
                        }
                    });
                    
                    this.service.convertTreeList(this.listOfCategories2, 1, this.listOfCategories);
                    this.users = res.data.users;
               
                });
            }else{
                this.service.createViewSearchPermission().subscribe((res:any)=>{
                    this.listOfCategories2 = res.data.categoriesNode;
                    this.resData = res.data;
                    this.service.convertTreeList(this.listOfCategories2, 1, this.listOfCategories);

                    this.users = res.data.users;
                    this.listUser = [];
                    this.listPermisson =[];
                });
            }
        });
          
       

    
        this.getRoleConstants();
        this.getCategoryData();
    }
  
   
    updateUser(event: any,userId :any){
       let isChecked = event.target.checked;
       if(isChecked) {
            this.listUser.push(userId);
       } else {
            const index: number = this.listUser.indexOf(userId);
            if (index !== -1) {
                this.listUser.splice(index, 1);
            }        
       }    
    }
    updatePermission(event: any,permissionId :any){
        let isChecked = event.target.checked;
        if(isChecked) {
             this.listPermisson.push(permissionId);
        } else {
             const index: number = this.listPermisson.indexOf(permissionId);
             if (index !== -1) {
                 this.listPermisson.splice(index, 1);
             }        
        } 
    }
    updateCategory(event: any, categoryId: any){
        
        let isChecked= event.target.checked;
        if(isChecked){
            this.listCategoies.push(categoryId);
        }else{
            const index: number = this.listCategoies.indexOf(categoryId);
            if(index!=-1){
                this.listCategoies.splice(index,1);
            }
        }
    }
    getRoleConstants(){
        if (this.route.params != null) {

            const id = this.route.snapshot.params.id;
            if(id != null ) {
                this.service.updateViewPermission(id).subscribe((res:any)=>{
               
                    this.rolePermissions = res.data.permissions;
                    res.data.permissions.forEach((permision:any) => {
                        if(permision.checked) {
                            this.listPermisson.push(permision.permissionId);
                        }
                    });
                    this.selectRole(this.rolePermissions)
                });
            }else {
                this.service.createViewSearchPermission().subscribe((res:any)=>{
               
                    this.rolePermissions = res.data.permissions;
                    res.data.permissions.forEach((permision:any) => {
                        if(permision.checked) {
                            this.listPermisson.push(permision.permissionId);
                        }
                    });
                    this.selectRole(this.rolePermissions)
                });
            }
        }
       
    }
    
    selectRole(list: any = []) {
        for(let i=0; i<list.length; i++){
            if(this.rolePermissions[i].permissionId == 0){
                this.rolePermissions[i].role = 'Tạo bài viết mới';
            }if(this.rolePermissions[i].permissionId == 1){
                this.rolePermissions[i].role = 'Xóa bài viết';
            }if(this.rolePermissions[i].permissionId == 2){
                this.rolePermissions[i].role = 'Gửi chờ duyệt bài viết';
            }if(this.rolePermissions[i].permissionId == 3){
                this.rolePermissions[i].role = 'Duyệt bài viết mới';
            }if(this.rolePermissions[i].permissionId == 4){
                this.rolePermissions[i].role = 'Hủy duyệt bài viết';
            }if(this.rolePermissions[i].permissionId == 5){
                this.rolePermissions[i].role = 'Xuất bản bài viết';
            }if(this.rolePermissions[i].permissionId == 6){
                this.rolePermissions[i].role = 'Hủy xuất bản bài viết';
            }if(this.rolePermissions[i].permissionId == 7){
                this.rolePermissions[i].role = 'Chỉnh sửa chuyên mục';
            }if(this.rolePermissions[i].permissionId == 8){
                this.rolePermissions[i].role ='Chỉnh sửa sự kiện';
            }if(this.rolePermissions[i].permissionId == 9){
                this.rolePermissions[i].role = 'Chỉnh sửa Tags';
            }if(this.rolePermissions[i].permissionId == 10){
                this.rolePermissions[i].role = 'Chỉnh sửa bình luận';
            }if(this.rolePermissions[i].permissionId == 11){
                this.rolePermissions[i].role = 'Phân quyền người dùng';
            }if(this.rolePermissions[i].permissionId == 12){
                this.rolePermissions[i].role ='Chỉnh sửa lịch sử';
            }if(this.rolePermissions[i].permissionId == 13){
                this.rolePermissions[i].role = 'Gửi chờ duyệt bài viết';
            }if(this.rolePermissions[i].permissionId == 14){
                this.rolePermissions[i].role = 'Chỉnh sửa lịch sử bài viết';
            }if(this.rolePermissions[i].permissionId == 15){
                this.rolePermissions[i].role = 'Xem tất cả bài viết';
            }if(this.rolePermissions[i].permissionId == 16){
                this.rolePermissions[i].role ='Quản lý cộng tác viên';
            }
        }
    }

    onUpdate(event: any){
        this.route.paramMap.subscribe((params: ParamMap) =>{
            this.groupUserId = params.get('id');
            if(this.groupUserId != null){
        let groupname =  event.target.namePermission.value;
        let description = event.target.description.value;
        this.service.updatePermission(this.groupUserId, groupname, description, this.listUser, this.listPermisson, this.listCategoies ).subscribe((response: any)=>{
            if (response.error_code == Constants.SUCCESSFUL_CODE) {              
                this.rt.navigate(['/list']);
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        })
    }else{
        let groupname =  event.target.namePermission.value;
        let description = event.target.description.value;
        this.service.savePermission(groupname,description,this.listUser,this.listPermisson,this.listCategoies).subscribe((res: any)=>{
            if (res.error_code == Constants.SUCCESSFUL_CODE) {              
                this.rt.navigate(['/list']);
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (res.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
            
        })
    }
    });
    
    }

   
    displayDropDown(event: any) {
        event.preventDefault();
        let isVisible = $(event.currentTarget).data('visible');
        $(event.currentTarget).data('visible', !isVisible);
        if (isVisible) {
            //switch to plus
            $(event.currentTarget).html('<i class="fa fa-fw" aria-hidden="true"></i>');
        } else {
            //switch to minus
            $(event.currentTarget).html('<i class="fa fa-fw" aria-hidden="true"></i>');
        }
        let targetLevel = $(event.currentTarget).data('target');
        let currentRow = $(event.currentTarget).parents('.parenttree').next();
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

            if (($(currentRow).next().data('level') - targetLevel) == 1) {
                mainVisible = isVisible;
            } else {
                if ($(currentRow).find('.dropdown-btn').length > 0 && isShow) {
                    mainVisible = !$(currentRow).find('.dropdown-btn').data('visible');
                }
            }
            currentRow = $(currentRow).next();
            currentLevel = $(currentRow).data('level');
        }
    }
    getCategoryData(){
        this.service.getAllCategory().subscribe((res:any)=> {
        });
    }
}  