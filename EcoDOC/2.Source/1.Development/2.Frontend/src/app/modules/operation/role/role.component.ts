import {Component, OnInit} from '@angular/core';
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {ToastrService} from 'ngx-toastr';
import {PermissionService} from 'src/app/services/permission.service';
import {TokenService} from 'src/app/core/authen/token.service';
import {UserService} from 'src/app/services/user.service';
import {SlimLoadingBarService} from "ng2-slim-loading-bar";
import {TranslateService} from "@ngx-translate/core";
import {CommonUtils} from 'src/app/core/common/common-utils';
import {SharedPreferences} from "../../../core/config/shared-preferences";
import {Category} from "../../../core/model/domain/category";
import { Constant } from 'src/app/core/config/constant';
import { CategoryService } from 'src/app/services/category.service';
import { DocumentService } from '../../../services/document.service';
import { ActivatedRoute } from '@angular/router';
import { Folder } from '../../../core/model/doucment/folder';
import { Decentralization } from 'src/app/core/model/decentralization/decentralization';
import { TreeNode } from 'primeng/api';

@Component({
  selector: 'app-role',
  templateUrl: './role.component.html',
  styleUrls: ['./role.component.css']
})
export class RoleComponent implements OnInit {
  selectedNode: TreeNode;
  users;
  roles;
  roleEdit;
  roleNew;
  userOfRole;//Danh sách user hiện tại theo role
  userSelected = [];//Lưu User cho việc thêm mới vào role
  moduleAll = [];
  modulesSelected;
  roleSelectedIndex = 0;
  dropdownUserAll = {};
  roleEditIndex = -1;
  isNewRole = false;
  modal: any;
  positionsSearch;
  positionOfRole;
  positionSelected = [];//Lưu Position cho việc thêm mới vào role
  historyNodeId: any[] = new Array();
  moduleField;
  disableRemoveBtn: boolean = true;
  listNodeIds: any[] = new Array();
  sortName: string = 'name'
  listFolder: Folder[] = new Array();
  oderBy: number = 1;
  ticKet = '';
  historyNum = 0;
  nodeId = '';
  nodeType: number;
  typee: number;
  idPermission: number;
  showSort: boolean = true;
  decen = new Decentralization();
  searchFields = {
    fullName: '',
    userName: '',
    page: 1,
    sortBy: '',
    direction: Constant.SORT_TYPE.DECREASE,
    size: Constant.PAGING.SIZE,
  };

  constructor(private toastr: ToastrService,
              private permissionService: PermissionService,
              private modalService: NgbModal,
              private userService: UserService,
              private slimLoader: SlimLoadingBarService,
              private tokenService: TokenService,
              private translateService: TranslateService,
              private commonUtils: CommonUtils,
              private service: DocumentService,
              private route: ActivatedRoute, 
              private categoryService: CategoryService
              ) {
    SharedPreferences.IS_LOADING_CONTEN = true;
  }

  ngOnInit() {
    this.getAllModule();
    this.getAllRole();
    this.getAllUser();
    this.getAllPosition();
    let nodeId = this.route.snapshot.paramMap.get('id');
    this.ticKet=this.tokenService.getTickets();
    this.historyNodeId.push("-root-")
    this.getAllData(nodeId, 1, this.searchFields.page, this.searchFields.size);
    this.dropdownUserAll = {
      singleSelection: false,
      idField: 'id',
      textField: 'fullName',
      selectAllText: this.translateService.instant('label.selectall'),
      unSelectAllText: this.translateService.instant('label.unselect'),
      itemsShowLimit: 10,
      allowSearchFilter: true
    };
  }

  getAllUser() {
    this.userService.getUsersActive().subscribe(data => {
      if (data) {
        this.users = data;
      }
    })
  }

  doEditRole(content, roleIndex) {
    this.roleEditIndex = roleIndex;
    this.roleEdit = JSON.parse(JSON.stringify(this.roles[roleIndex]));
  }

  doNewRole() {
    this.roleNew = {};
    this.isNewRole = true;
    this.cancelEditRole();
  }

  doSaveRole() {
    if (!this.roleEdit.name && !this.roleNew.name) {
      this.toastr.error(this.translateService.instant('error.rolename-require'), this.translateService.instant('label.notification'));
      return;
    }
    this.permissionService.doSaveRole(this.roleEdit).subscribe(data => {
      this.roles[this.roleEditIndex] = data;
      this.cancelEditRole();
      this.toastr.success(this.translateService.instant('result-mes.update-success'), this.translateService.instant('label.notification'));
    });
  }

  doSaveNewRole() {
    if (!this.roleNew.name) {
      this.toastr.error(this.translateService.instant('error.rolename-require'), this.translateService.instant('label.notification'));
      return;
    }
    this.roleNew.active = true;
    this.permissionService.doSaveRole(this.roleNew).subscribe(data => {
      this.cancelNewRole();
      this.roles.push(data);
      this.toastr.success(this.translateService.instant('result-mes.add-success'), this.translateService.instant('label.notification'));
    });
  }

  cancelEditRole() {
    this.roleEditIndex = -1;
    this.roleEdit = {};
  }

  cancelNewRole() {
    this.isNewRole = false;
    this.roleNew = {};
  }

  showUserModal(content) {
    this.modalService.open(content, {centered: true})
      .result.then(
      result => {
        if (result)
          this.doAssignUserToRole();
      }
    );
  }

  getAllRole() {
    this.permissionService.getRole().subscribe(data => {
      if (data) {
        this.roles = data;
        this.roleSelectedIndex = 0;
        this.modulesSelected = this.roles[0].modules;
        this.checkModuleIsSelected();
        this.getUserByRole(this.roles[0].id);
        this.getPositionByRole(this.roles[0].id);
        // this.moduleField = { dataSource: this.moduleAll, id: 'id', text: 'name', child: 'subModule' };
      }
    });
  }

  refreshRoleList() {
    this.permissionService.getRole().subscribe(data => {
      if (data) {
        this.roles = data;
        console.log('roles : ', this.roles);
        this.modulesSelected = this.roles[this.roleSelectedIndex].modules;
        this.checkModuleIsSelected();
      }
    });
  }

  getUserByRole(roleId) {
    this.userOfRole = [];
    this.userSelected = []
    this.permissionService.getUserByRole(roleId).subscribe(data => {
      if (data) {
        this.userOfRole = data;
        this.userSelected = data;
      }
      SharedPreferences.IS_LOADING_CONTEN = false;
    })
  }

  doActiveUserToRole(userId) {
    this.permissionService.doActiveUserToRole(userId, this.roles[this.roleSelectedIndex].id).subscribe(data => {
      if (data) {
        this.userOfRole = data;
        this.userSelected = data;
        this.toastr.success(this.translateService.instant('user.permission-success'), this.translateService.instant('label.notification'));
      }
    })
  }

  doSelectRole(roleId, index) {
    if (this.roleSelectedIndex != index) {
      this.roleEditIndex = -1;
      this.roleEdit = {};

      this.roleSelectedIndex = index;
      this.getUserByRole(roleId);
      this.getPositionByRole(roleId);
      this.modulesSelected = this.roles[index].modules;
      this.checkModuleIsSelected();

    }
  }

  checkModuleIsSelected() {
    this.moduleAll = JSON.parse(this.tokenService.getModuleAll());
    if (this.moduleAll && this.modulesSelected) {
      console.log('module selected : ', this.modulesSelected);
      for(let i = 0; i < this.modulesSelected.length; i ++) {
        this.checkModuleSelected(this.moduleAll, this.modulesSelected[i]);
      }
    }
    console.log('final : ',(this.moduleAll));
    this.moduleField = { dataSource: this.moduleAll, id: 'id', text: 'name', child: 'subModule' };
  }
  checkModuleSelected(list, mSelected ) {
    for(let i = 0; i < list.length; i ++) {
        if(mSelected.id == list[i].id) {
          if(list[i].subModule && list[i].subModule.length > 0) {
            // list[i].isChecked = false;
            list[i].expanded = true;
            list[i].isAdded = true;
          } else {
            list[i].expanded = true;
            list[i].isChecked = true;
          }
          return;
        } else {
          if(list[i].subModule && list[i].subModule.length > 0) {
            this.checkModuleSelected(list[i].subModule, mSelected);
          }
        }
    }
  }

  doAssignUserToRole() {
    this.permissionService.doAssignUserToRole(this.userSelected, this.roles[this.roleSelectedIndex].id).subscribe(data => {
      this.userOfRole = data;
      this.userSelected = data;
      this.usersSearch = [];
      this.textSearch = "";
      this.toastr.success(this.translateService.instant('user.permission-success'), this.translateService.instant('label.notification'));
    });
  }

  doSaveModuleToRole() {
    this.prettyJsonModule(this.moduleAll);
    console.log('prettyJsonModule : ', this.moduleAll);
    this.permissionService.doSaveModuleToRole(this.moduleAll, this.roles[this.roleSelectedIndex].id).subscribe(data => {
      this.roles[this.roleSelectedIndex].modules = data;
      this.refreshRoleList();
      this.toastr.success(this.translateService.instant('role.permission-success'), this.translateService.instant('label.notification'));
    });
  }

  doActiveOrDeactiveRole(role) {
    this.commonUtils.showPopupConfirm(role.active ? 'Bạn có muốn ngừng kích hoạt vai trò?' : 'Bạn có muốn kích hoạt vai trò?', () => {
      this.permissionService.doActiveOrDeactiveRole(role).subscribe(data => {
        if (role.active) {
          this.toastr.success('Ngừng kích hoạt vai trò thành công', this.translateService.instant('label.notification'));
        } else {
          this.toastr.success('Kích hoạt vai trò thành công', this.translateService.instant('label.notification'));
        }
        this.getAllRole();
      });
    });

  }

  doDeleteRole(roleId) {
    this.commonUtils.showPopupConfirm('Bạn có muốn xóa vai trò?', () => {
      this.permissionService.doDeleteRole(roleId).subscribe(data => {
        this.toastr.success('Xóa vai trò thành công', this.translateService.instant('label.notification'));
        this.getAllRole();
      });
    });
  }

  usersSearch: any[];
  textSearch: '';

  doSearchUser() {
    this.usersSearch = [];
    this.userService.searchUserActive(this.textSearch).subscribe(data => {
      if (data)
        this.usersSearch = data;
    })
  }

  checkExistJoin(id) {
    if (this.userSelected)
      if (this.userSelected.find(x => x.id === id)) {
        return true;
      } else return false;
  }

  doAddUser(index) {
    if (!this.checkExistJoin(this.usersSearch[index].id)) {
      this.userSelected.push(this.usersSearch[index]);
    } else
      this.toastr.error(this.translateService.instant('Người dùng đã được gán vai trò'), this.translateService.instant('label.notification'));
  }

  doRemoveUser(id) {
    if (this.userSelected) {
      let index = -1;
      this.userSelected.forEach((item, i) => {
        if (item.id == id) {
          index = i;
          return;
        }
      })
      if (index > -1) {
        this.userSelected.splice(index, 1);
      }
    }
  }

  getAllModule(){
    this.moduleAll = JSON.parse(this.tokenService.getModuleAll());
  }
  nodeChecked(event) {
    console.log(event);
    let arr = event.data;
    for(let i = 0; i < arr.length; i++) {
      // tslint:disable-next-line: radix
      arr[i].id = parseInt(arr[i].id);
    }
    for(let i = 0; i < arr.length; i++) {
      this.checkNodeInModuleAll(arr[i], this.moduleAll);
    }
    console.log('node checked : ', this.moduleAll);
  }
  checkNodeInModuleAll(arrObj, moduleList){
    if(moduleList && moduleList.length > 0) {
      for(let j = 0; j < moduleList.length; j++) {
        if(arrObj.id == moduleList[j].id) {
          moduleList[j].isChecked = arrObj.isChecked;
          if(moduleList[j].isChecked == 'true' && moduleList[j].subModule && moduleList[j].subModule.length > 0) {
            this.setStatusSub(true, moduleList[j].subModule);
          }
          if(moduleList[j].isChecked == 'false' && moduleList[j].subModule && moduleList[j].subModule.length > 0) {
            if(moduleList[j].isAdded) {
              moduleList[j].isAdded = false;
            }
            this.setStatusSub(false, moduleList[j].subModule);
          }
        } else if(moduleList[j].subModule && moduleList[j].subModule.length > 0) {
          this.checkNodeInModuleAll(arrObj, moduleList[j].subModule);
        }
      }
    }
  }
  setStatusSub(isTrue, list) {
    for(let i = 0; i < list.length; i++) {
      list[i].isChecked = isTrue;
      if(list[i].isAdded) {
        list[i].isAdded = isTrue;
      }
      if(list[i].subModule && list[i].subModule.length > 0) {
        this.setStatusSub(isTrue, list[i].subModule);
      }
    }
  }


  prettyJsonModule(list) {
    list.forEach(
      x => {
        if(x.isChecked == 'true' || x.isChecked == 'mixed' || x.isAdded == true) {
          x.isChecked = true;
        } else if(x.isChecked == 'false' || x.isChecked == null){
          x.isChecked = false;
        }
        if(x.subModule && x.subModule.length > 0) {
          this.prettyJsonModule(x.subModule);
        }
      }
    );
  }

  doActivePositionToRole(posId) {
    console.log('doActivePositionToRole');
    this.permissionService.doActivePositionToRole(posId, this.roles[this.roleSelectedIndex].id).subscribe(data => {
      if (data) {
        console.log('doActivePositionToRole : ',data);
        this.positionOfRole = data;
        this.positionSelected = data;
        this.toastr.success('Thiết lập vai trò chức danh thành công', this.translateService.instant('label.notification'));
      }
    })
  }
  showPositionModal(content) {
    this.modalService.open(content, {centered: true})
      .result.then(
      result => {
        if (result)
          this.doAssignPositionToRole();
      }
    );
  }
  doAssignPositionToRole() {
    console.log('doAssignPositionToRole');
    this.permissionService.doAssignPositionToRole(this.positionSelected, this.roles[this.roleSelectedIndex].id).subscribe(data => {
      console.log('doAssignPositionToRole : ', data);
      this.positionOfRole = data;
      this.positionSelected = data;
      this.toastr.success('Thiết lập vai trò chức danh thành công', this.translateService.instant('label.notification'));
    });
  }
  checkPositionExistJoin(id) {
    if (this.positionSelected) {
      if (this.positionSelected.find(x => x.id === id)) {
        return true;
      } else { return false; }
    }
  }

  doAddPosition(index) {
    if (!this.checkPositionExistJoin(this.positionsSearch[index].id)) {
      this.positionSelected.push(this.positionsSearch[index]);
    } else {
      this.toastr.error('Chức danh đã được gán vai trò', this.translateService.instant('label.notification'));
    }
  }

  doRemovePosition(id) {
    if (this.positionSelected) {
      let index = -1;
      this.positionSelected.forEach((item, i) => {
        if (item.id == id) {
          index = i;
          return;
        }
      });
      if (index > -1) {
        this.positionSelected.splice(index, 1);
      }
    }
  }
  getPositionByRole(roleId) {
    this.positionOfRole = [];
    this.positionSelected = []
    this.permissionService.getPositionByRole(roleId).subscribe(data => {
      if (data) {
        this.positionOfRole = data;
        this.positionSelected = data;
      }
      SharedPreferences.IS_LOADING_CONTEN = false;
    })
  }
  getAllPosition() {
    this.categoryService.getCategoryWithCode(Constant.CATEGORYTYPE_CODE.USER_POSITION).subscribe(
      res => {
        this.positionsSearch = res as Category[];
      },
      err => {
        console.log(err);
      }
    )
  }
  openRole(content) {
  
    this.modal = this.modalService.open(content, { centered: true, windowClass: 'no-box-shadow' });
  }
  getAllData(id: String, type: number, start: number, pageSize: number) {
    this.service.getAllFolder(this.ticKet, id, 1, this.oderBy, this.sortName, this.searchFields.size*(this.searchFields.page-1), this.searchFields.size).subscribe((res: any) => {
      this.listFolder = res.data.list.entries;
      console.log(this.listFolder)
    })
  }
  checkAll() {
    this.listFolder.forEach((item: any) => (
      item.selected = true,
      this.listNodeIds.push(item.entry.id)
    ));
  }
  unCheckAll() {
    this.listFolder.forEach((item: any) => (item.selected = false, this.listNodeIds = []));
  }
  getFolderByNodeId(nodeId: any) {
    this.historyNodeId.push(nodeId);
    this.historyNum++;
    this.service.getTicket().subscribe((res: any) => {
      this.ticKet = res.data.entry.id;
      this.nodeId = this.route.snapshot.paramMap.get('id');
      this.service.getAllFolder(this.ticKet, nodeId, 1, this.oderBy, this.sortName, this.searchFields.size*(this.searchFields.page-1), this.searchFields.size).subscribe((res: any) => {
        this.listFolder = res.data.list.entries;
      })
    })
    console.log(this.listFolder)
  }
  back() {
    this.historyNodeId.pop();
    this.historyNum--;
    this.nodeId = this.historyNodeId.pop();
    this.historyNum--;
    this.getFolderByNodeId(this.nodeId)
  }
  createPermission(id: string){
    let nodeId = this.selectedNode ? this.selectedNode.data.id : '';
    if (id != null || id != undefined) {
      this.service.updateDecen(this.decen).subscribe((data: any) => { 
        if (data.resultCode == 200) { 
          this.service.updateDecen(this.decen).subscribe();
        }
        this.toastr.success('Cập nhật thành công!', 'Thành công');
        this.modal.close();
      })
    } else {
      this.service.addDecen(this.decen, nodeId, this.nodeType, this.typee, this.idPermission).subscribe((res: any) =>{
        let id = res.data.entry.id;
        console.log(id);
        console.log(res);
        if(res.resultCode == 200){
          this.service.addDecen(this.decen, nodeId, this.nodeType, this.typee, this.idPermission).subscribe((result: any)=>{
            if (result.resultCode == 200) {
              console.log(result);
              this.toastr.success('Thêm quyền thành công!', 'Thành công');
              this.modal.close();
            }else{
              this.toastr.error('Thêm quyền thất bại!', 'Thất bại');
            }
          })
        } else if (res.resultCode == 500) {
          console.log("res.resultCode :" + res.resultCode)
        } else {
        this.toastr.error('Thêm thư mục thất bại', 'Thất bại');
        }
      })
    }
  }
}
