import { Component, OnInit } from '@angular/core';
import { TreeNode } from 'primeng/api';
import { OrganizationService } from 'src/app/services/organization.service';
import { UserService } from 'src/app/services/user.service';
import { ToastrService } from 'ngx-toastr';

@Component({
    selector: 'app-tabletree',
    templateUrl: './tabletree.component.html',
    styleUrls: ['./tabletree.component.css']
})
export class TabletreeComponent implements OnInit {
  // for testing
  userList;
  idSearch;

  processTreeData: TreeNode[];
  dataTree: TreeNode = {};
  orgList;
  orgChildren = [];

  isChecked = false;
  dataMainChecked = [];
  dataSubChecked = [];
  dataKnowChecked = [];
  cols: any[];

  mainTree;
  showTree;

  constructor(
    private organizationService: OrganizationService,
    private toastr: ToastrService,
    private userService: UserService
  ) { }

  ngOnInit() {
    this.getOrganizationList();
    this.addUserToOrgTree();
    this.cols = [
        { field: 'name', header: 'Tên đơn vị, cá nhân' },
    ];
    console.log('this.orgList after : ', this.orgList);
  }
  checkMainProcess(isChecked: any, rowData) {
    let obj;
    if (rowData.hasOwnProperty('userName')) {
      obj = {'type': 'User', 'id': rowData.id};
    } else {
      obj = {'type': 'Org', 'id': rowData.id};
    }
    if (isChecked) {
      this.dataMainChecked.push(obj);
    } else {
      for (let i = 0; i < this.dataMainChecked.length; i++) {
        if ( this.dataMainChecked[i].type == obj.type &&  this.dataMainChecked[i].id == obj.id) {
            this.dataMainChecked.splice(i, 1);
            break;
        }
      }
    }
    console.log('this.dataMainChecked : ', this.dataMainChecked);
  }
  checkSubProcess(isChecked: any, rowData) {
    let obj;
    if (rowData.hasOwnProperty('userName')) {
      obj = {'type': 'User', 'id': rowData.id};
    } else {
      obj = {'type': 'Org', 'id': rowData.id};
    }
    if (isChecked) {
      this.dataSubChecked.push(obj);
    } else {
      for (let i = 0; i < this.dataSubChecked.length; i++) {
        if ( this.dataSubChecked[i].type == obj.type &&  this.dataSubChecked[i].id == obj.id) {
            this.dataSubChecked.splice(i, 1);
            break;
        }
      }
    }
    console.log('this.dataSubChecked : ', this.dataSubChecked);
  }
  checkKnowProcess(isChecked: any, rowData) {
    let obj;
    if (rowData.hasOwnProperty('userName')) {
      obj = {'type': 'User', 'id': rowData.id};
    } else {
      obj = {'type': 'Org', 'id': rowData.id};
    }
    if (isChecked) {
      this.dataKnowChecked.push(obj);
    } else {
      for (let i = 0; i < this.dataKnowChecked.length; i++) {
        if ( this.dataKnowChecked[i].type == obj.type &&  this.dataKnowChecked[i].id == obj.id) {
            this.dataKnowChecked.splice(i, 1);
            break;
        }
      }
    }
    console.log('this.dataKnowChecked : ', this.dataKnowChecked);
  }

  getOrganizationList() {
    this.processTreeData = [];
    this.organizationService.getOrganizations().subscribe(
      data => {
        if (data) {
          this.orgList = data;
          this.creatDataTree();
        }
    });
  }
  creatDataTree() {
    for (let i = 0; i < this.orgList.length; i++) {
    // get parent
      if (this.orgList[i].parentId == null) {
        this.dataTree.data = this.orgList[i];
        this.processTreeData.push(this.dataTree);
        this.dataTree = {};
      } else {
        this.orgChildren.push(this.orgList[i]);
      }
    }
    this.checkParent(this.processTreeData, this.orgChildren);
    this.mainTree = <TreeNode[]>this.processTreeData;
    if(!this.showTree) {
      this.showTree = <TreeNode[]>this.mainTree;
      console.log('assign tree', this.showTree);
      console.log('assign tree', this.mainTree);
    }
  }
  checkParent (listParent, listChildren) {
    for (let i = 0; i < listParent.length; i++) {
      for (let j = 0; j < listChildren.length; j++) {
        if (listParent[i].data.id == listChildren[j].parentId) {
          if(!listParent[i].children) {
            listParent[i].children = [];
          }
          this.dataTree.data = listChildren[j];
          listChildren[j] = [];
          listParent[i].children.push(this.dataTree);
          this.dataTree = {};
          this.checkParent(listParent[i].children, listChildren);
        }
      }
    }
  }

  getTreeById(id) {
    for (let i = 0; i < this.mainTree.length; i++) {
      if(id == this.mainTree[i].data.id) {
        let temp =[];
        temp.push(this.mainTree[i]);
        this.showTree = [];
        this.showTree = <TreeNode[]> temp;
        return;
      } else {
        if(this.mainTree[i].children) {
          if(this.searchTreeByID(id, this.mainTree[i].children) == true) {
            let temp =[];
            temp.push(this.mainTree[i]);
            this.showTree = [];
            this.showTree = <TreeNode[]> temp;
            return;
          }
        }
      }
    }
  }
  searchTreeByID(id, parentTree) {
    for(let i = 0; i < parentTree.length; i++) {
      if(id == parentTree[i].data.id) {
        return true;
      } else if (parentTree[i].children) {
        if(this.searchTreeByID(id, parentTree[i].children) == true) {
          return true;
        }
      }
    }
    return false;
  }

  addUserToOrgTree() {
    this.userService.getAllUsers().subscribe (
      data => {
        this.userList = data;
        for(let i = 0; i < this.userList.length; i++) {
          this.checkUserInOrgTree(this.userList[i], this.showTree);
        }
        console.log('Org and user tree : ', this.showTree);
      }
    );
  }
  checkUserInOrgTree (user, orgTree) {
    for(let j = 0; j < orgTree.length; j++) {
      if(!orgTree[j].data.hasOwnProperty('userName')) {
        if(user.org == orgTree[j].data.id) {
          if(orgTree[j].children) {
            let userData = {'data': null,};
            userData.data = user;
            orgTree[j].children.push(userData);
          } else {
            orgTree[j].children = [];
            let userData = {'data': null,};
            userData.data = user;
            orgTree[j].children.push(userData);
          }
        } else {
          if(orgTree[j].children && orgTree[j].children.length > 0) {
            this.checkUserInOrgTree (user, orgTree[j].children);
          }
        }
      }
    }
  }
}
