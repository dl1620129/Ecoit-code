import { Component, OnInit, EventEmitter, Input, Output } from '@angular/core';
import { TreeNode } from 'primeng/api';
import { OrganizationService } from 'src/app/services/organization.service';
import { Organization } from 'src/app/core/model/domain/organization'
import { IProcess } from '../../../../../core/model/domain/process';

@Component({
  selector: 'app-organization-tree',
  templateUrl: './organization-tree.component.html',
  styleUrls: ['./organization-tree.component.css']
})
export class OrganizationTreeComponent implements OnInit {

  // for testing
  userList;
  idSearch;
  org: Organization

  processTreeData: TreeNode[];
  dataTree: TreeNode = {};
  orgList;
  orgChildren = [];
  selectedUsersAndOrgs = []

  currentSelectedUserIds = []
  currentSelectedOrgIds = []

  onlyOrgTree = []

  isChecked = false;
  dataMainChecked = [];
  dataSubChecked = [];
  dataKnowChecked = [];
  cols: any[];

  mainTree;
  showTree;
  closeResult = '';

  
  currentNode
  currentConditions


  // @Output() selectedUsersAndOrgs = new EventEmitter<>();
  @Output() sendOrg = new EventEmitter<Organization>();
  @Input() process: IProcess;

  constructor(private organizationService: OrganizationService) { 
    this.org = new Organization();
  }

  ngOnInit() {
    this.getOrganizationList();
    console.log("current node and conditions")
    
    this.cols = [
        { field: 'name', header: 'Tên đơn vị, cá nhân' },
    ];
    console.log('this.orgList after : ', this.orgList);
  }

  checkMainProcess(isChecked: any, rowData) {
    this.unSelectAllOrgs(this.showTree, rowData.id);
    this.org.id = rowData.id
    this.org.name = rowData.name
    
    this.sendOrg.emit(this.org);
    console.log("emit org")

    if (isChecked) {
      this.dataMainChecked.push(this.org);
    } else {
      for (let i = 0; i < this.dataMainChecked.length; i++) {
        if (this.dataMainChecked[i].id == this.org.id) {
            this.dataMainChecked.splice(i, 1);
            break;
        }
      }
    }
  }

  getOrganizationList() {
    this.processTreeData = [];
    this.organizationService.getOrganizations({active: true}).subscribe(
      data => {
        if (data) {
          this.orgList = data;
          this.creatDataTree();
        }
    });
  }
  creatDataTree() {
    console.log("create data tree ádsadsadsadasdsadsadsad")
    for (let i = 0; i < this.orgList.length; i++) {
    // get parent
    // first selected node for org
      // console.log("what new", this.process.id, this.orgList[i].id)
      if (this.process && this.process.orgId == this.orgList[i].id) {
        this.orgList[i].isMainChecked = true
        this.orgList[i].type = "Org"
        console.log("what org")
        console.log(this.orgList[i])
        let obj = {
            'id': this.orgList[i].id,
            'type': 'Org',
            'orgId': this.orgList[i].id,
            'name': this.orgList[i].name,
            'highestTitle': "Trưởng Phòng" 
        };
        this.dataMainChecked.push(obj)
      }
      if (this.orgList[i].parentId == null) {
        // this.orgList[i].isMainChecked=true
        this.dataTree.data = this.orgList[i];
        this.processTreeData.push(this.dataTree);
        this.dataTree = {};
      } else {
        this.orgChildren.push(this.orgList[i]);
      }
    }
    this.onlyOrgTree = this.processTreeData
    this.checkParent(this.processTreeData, this.orgChildren);
    this.mainTree = <TreeNode[]>this.processTreeData;
    if(!this.showTree) {
      this.showTree = <TreeNode[]>this.mainTree;
    }
    this.onlyOrgTree = this.showTree
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

  unSelectAllOrgs(orgTree, currentSelectedId) {
    for(let j = 0; j < orgTree.length; j++) {
      if (currentSelectedId != orgTree[j].data.id ) {
        orgTree[j].data.isMainChecked  = false
      }
      if(orgTree[j].children && orgTree[j].children.length > 0) {
        this.unSelectAllOrgs(orgTree[j].children, currentSelectedId);
      }
    }
  }
}
