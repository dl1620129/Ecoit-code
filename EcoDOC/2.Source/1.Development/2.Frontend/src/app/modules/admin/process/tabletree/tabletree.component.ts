import { TokenService } from 'src/app/core/authen/token.service';
import { Component, EventEmitter, OnInit, Input, Output, ViewChild } from '@angular/core';
import { TreeNode } from 'primeng/api';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { OrganizationService } from 'src/app/services/organization.service';
import { UserService } from 'src/app/services/user.service';
import { PositionService } from 'src/app/services/position.service';
import { ToastrService } from 'ngx-toastr';
import { IProcess } from 'src/app/core/model/domain/process';
import { Position } from 'src/app/core/model/domain/position';
import { Constant } from '../../../../core/config/constant';
import { ConstantPool } from '@angular/compiler';
import { remove } from '@syncfusion/ej2-base';
import { DocumentService } from 'src/app/services/document.service';

@Component({
    selector: 'app-tabletree',
    templateUrl: './tabletree.component.html',
    styleUrls: ['./tabletree.component.css']
})
export class TabletreeComponent implements OnInit {
  folderList;
  urlQuery = {
    page: 1
  };
  // for testing
  userList;
  idSearch;

  processTreeData: TreeNode[];
  dataTree: TreeNode = {};
  orgList;
  orgChildren = [];
  selectedUsersAndOrgs = [];

  currentSelectedUserIds = [];
  currentSelectedOrgIds = [];

  onlyOrgTree = [];

  isChecked = false;
  dataMainChecked = [];
  dataSubChecked = [];
  dataKnowChecked = [];
  cols: any[];

  mainTree;
  showTree;
  closeResult = '';
  positionsByOrg: Position[] = [];
  currentSelectedPostions = [];
  currentSelectedPostionIds = [];
  currentPositionPopUpSelectedOrgId;
  selectedPositionOrgIds = [];

  @Output() opened = new EventEmitter<boolean>();

  @Input() isOpenChoosedUsers = false;
  @Input() selectedTaskId = '';

  selectedTaskName = '';

  @Input() process: IProcess;
  currentNode;
  currentConditions;

  positionPaging = {
    itemsPerPage: Constant.PAGING.SIZE,
    currentPage: 1,
    totalRecord: '',
    previous: Constant.PAGING.PRIVIOUS,
    next: Constant.PAGING.NEXT,
    orgId: 1
  };


  @Output() updateProcess = new EventEmitter<IProcess>();
  ticKet: any;
  files: TreeNode[];
  loading = true;
  nodeId: any;
  selectedNode: TreeNode[];
  editFolderSelected: any;
  // @Output() currentNodeName = new EventEmitter<string>();

  // @Output() selectedUsersAndOrgs = new EventEmitter<>();

  constructor(
    private modalService: NgbModal,
    private organizationService: OrganizationService,
    private toastr: ToastrService,
    private userService: UserService,
    private positionService: PositionService,
    private tokenService: TokenService,
    private documentService: DocumentService,
  ) { }

  makeOpen(opened: boolean) {
    this.opened.emit(opened);
  }

  selectedPositionOrgs = [];
  currentSelectedOrgs = [];
  currentSelectedUsers = [];


  ngOnInit() {
    this.loadNodesForTree('');
    this.loadRootFolderList();
    this.getOrganizationList();
    this.setCurrentNodeandConditions();

    this.currentSelectedOrgs = this.currentConditions.filter(condition => condition.userId == null && condition.orgId != null && condition.position == null);
    this.currentSelectedOrgIds = this.currentSelectedOrgs.map(condition => condition.orgId);

    this.currentSelectedUsers = this.currentConditions.filter(condition => condition.userId != null);
    this.currentSelectedUserIds = this.currentSelectedUsers.map(condition => condition.userId);

    this.currentSelectedPostions = this.currentConditions.filter(condition => condition.userId == null && condition.positionId != null );
    this.currentSelectedPostionIds = this.currentSelectedPostions.map(position => position.positionId);
    // this.dataMainChecked.push

    // get list org by selected positions and unique

    console.log('ab', this.currentSelectedPostionIds, this.currentSelectedOrgIds, this.currentSelectedUserIds);
    let selectedPositionOrgIds = this.currentSelectedPostions.map(position => position.orgId);
    this.selectedPositionOrgIds = selectedPositionOrgIds.filter(function(item, pos) {
                                      return selectedPositionOrgIds.indexOf(item) == pos;
                                  });

    // this.currentSelectedOrgIds = this.currentSelectedOrgIds.concat(this.selectedPositionOrgIds)

    for(let i = 0; i < this.currentSelectedPostions.length; i++) {
      this.currentSelectedPostions[i].type = 'Position';
      console.log('this.currentSelectedPostions', this.currentSelectedPostions);
      let positionName;
      let orgName;
      if(this.currentSelectedPostions[i].position) {
        positionName = this.currentSelectedPostions[i].position.name;
      }
      if(this.currentSelectedPostions[i].org) {
        orgName = this.currentSelectedPostions[i].org.name;

      }
      let obj = {
              'type': 'Position',
              'positionId': this.currentSelectedPostions[i].positionId,
              'name': positionName,
              'orgName': orgName,
              'id': this.currentSelectedPostions[i].orgId,
              'orgId': this.currentSelectedPostions[i].orgId,
              'allowConfig': this.currentSelectedPostions[i].allowConfig,
              'allowSign': this.currentSelectedPostions[i].allowSign,
              'folderId': this.currentSelectedPostions[i].folderId,
              'folderIdList': this.getFolderIdList(this.currentSelectedPostions[i].folderId),
            };

      this.dataMainChecked.push(obj);
    }

    this.cols = [
        { field: 'name', header: 'Tên đơn vị, cá nhân' }

    ];
    console.log('this.orgList after : ', this.orgList);
  }
  checkMainProcess(isChecked: any, rowData) {
    let obj;
    console.log('row Data:' + rowData);
    console.log(rowData);
    if (rowData.hasOwnProperty('userName')) {
      obj = {
              'type': 'User',
              'id': rowData.id,
              'userId': rowData.id,
              'name': rowData.fullName,
              'orgName': rowData.orgName,
              'title': rowData.title,
              'positionName': rowData.positionName,
              'orgId': rowData.orgId,
              'userName': rowData.userName,
              'allowConfig': rowData.allowConfig,
              'allowSign': rowData.allowSign,
              'folderId': rowData.folderId,
            };
    } else {
      obj = {
            'type': 'Org',
            'id': rowData.id,
             'orgId': rowData.id,
             'name': rowData.name,
             'allowConfig': rowData.allowConfig,
             'allowSign': rowData.allowSign,
             'folderId': rowData.folderId,
            };
    }
    if (isChecked) {
      this.dataMainChecked.push(obj);
    } else {
      for (let i = 0; i < this.dataMainChecked.length; i++) {
        console.log('ádas', obj);
        if ( this.dataMainChecked[i].type == obj.type &&  this.dataMainChecked[i].id == obj.id) {
            this.dataMainChecked.splice(i, 1);
            break;
        }
      }

      if (obj.type == 'Org') {
        // let position = new Position()
        // position.orgId =
        console.log('org hể', obj.orgId);
        this.removeAllPositionByOrg(obj.orgId);
      }
    }
  }

  removeAllPositionByOrg(orgId) {
    let positions = this.dataMainChecked.filter(data => data.orgId == orgId && data.type == 'Position');
    for (let position of positions) {
      this.removePosition(position);
    }
  }

  getOrganizationList() {
    this.processTreeData = [];
    this.organizationService.getOrganizations({active: true}).subscribe(
      data => {
        if (data) {
          this.orgList = data;
          this.creatDataTree();
          // console.log("only org tree1")
          // console.log(this.showTree)
          // console.log("over there")
          this.addUserToOrgTree();
        }
    });
  }
  creatDataTree() {
    for (let i = 0; i < this.orgList.length; i++) {
      this.orgList[i].allowConfig = this.currentSelectedOrgs.find(item => item.orgId == this.orgList[i].id) ? this.currentSelectedOrgs.find(item => item.orgId == this.orgList[i].id).allowConfig : false;
      this.orgList[i].allowSign = this.currentSelectedOrgs.find(item => item.orgId == this.orgList[i].id) ? this.currentSelectedOrgs.find(item => item.orgId == this.orgList[i].id).allowSign : false;
      this.orgList[i].folderId = this.currentSelectedOrgs.find(item => item.orgId == this.orgList[i].id) ? this.currentSelectedOrgs.find(item => item.orgId == this.orgList[i].id).folderId : null;
      this.orgList[i].folderIdList = this.currentSelectedOrgs.find(item => item.orgId == this.orgList[i].id) ? this.currentSelectedOrgs.find(item => item.orgId == this.orgList[i].id).folderIdList : null;
    // get parent
    // first selected node for org
    if (this.selectedPositionOrgIds.includes(this.orgList[i].id)) {
      this.orgList[i].isMainChecked = true;
    }
      if (this.currentSelectedOrgIds.includes(this.orgList[i].id)) {
        this.orgList[i].isMainChecked = true;
        this.orgList[i].type = 'Org';
        console.log('what org');
        console.log(this.orgList[i]);
        let obj = {
            'id': this.orgList[i].id,
            'type': 'Org',
            'orgId': this.orgList[i].id,
            'name': this.orgList[i].name,
            'allowConfig': this.orgList[i].allowConfig,
            'allowSign': this.orgList[i].allowSign,
            'folderId': this.orgList[i].folderId,
            'folderIdList': this.getFolderIdList(this.orgList[i].folderId),
        };
        this.dataMainChecked.push(obj);
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
    this.onlyOrgTree = this.processTreeData;
    this.checkParent(this.processTreeData, this.orgChildren);
    this.mainTree = <TreeNode[]>this.processTreeData;
    if(!this.showTree) {
      // console.log("mainTree")
      // console.log(this.mainTree)
      this.showTree = <TreeNode[]>this.mainTree;
      // console.log('assign tree', this.showTree);
      // console.log('assign tree', this.mainTree);
    }
    // console.log("only org trê")
    // console.log(this.mainTree)
    this.onlyOrgTree = this.showTree;
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
        // console.log('this.maintree')
        // console.log(this.mainTree)
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
    this.userService.getAllUsersOrderPosition().subscribe (
      data => {
        this.userList = data;
        console.log('user data', data);
        // this.userList = this.userList.reverse()
        for(let i = 0; i < this.userList.length; i++) {
          this.checkUserInOrgTree(this.userList[i], this.showTree);
        }
        this.firstLoadSelectedUsersAndOrgs();
        // console.log('Org and user tree : ', this.showTree);
      }
    );
  }
  checkUserInOrgTree (user, orgTree) {
    user.allowConfig = this.currentSelectedUsers.find(item => item.userId == user.id) ? this.currentSelectedUsers.find(item => item.userId == user.id).allowConfig : false;
    for(let j = 0; j < orgTree.length; j++) {
      if(!orgTree[j].data.hasOwnProperty('userName')) {
        if(user.orgId == orgTree[j].data.id) {
          user.orgName = orgTree[j].data.name;
          if (this.currentSelectedUserIds.includes(user.id)) {
            user.isMainChecked = true;
            user.type = 'User';
            user.name = user.fullName;
            // console.log("what user")
            // console.log(user)
            let obj = {'type': 'User',
              'id': user.id,
              'userId': user.id,
              'name': user.fullName,
              'orgName': user.orgName,
              'title': user.title,
              'positionName': user.positionName,
              'orgId': user.orgId,
              'userName': user.userName,
              'allowConfig': user.allowConfig,
              'allowSign': user.allowSign,
              'folderId': user.folderId,
              'folderIdList': this.getFolderIdList(user.folderId),
            };
            console.log('push 1');
            this.dataMainChecked.push(obj);
          }
          if(orgTree[j].children) {
            let userData = {'data': null,};
            userData.data = user;
            orgTree[j].children.unshift(userData);
          } else {
            orgTree[j].children = [];
            let userData = {'data': null,};
            userData.data = user;
            orgTree[j].children.unshift(userData);
          }
        } else {
          if(orgTree[j].children && orgTree[j].children.length > 0) {
            this.checkUserInOrgTree (user, orgTree[j].children);
          }
        }
      }
    }
  }

  open(content) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title', size: 'lg'}).result.then((result) => {
      this.selectedUsersAndOrgs = this.dataMainChecked;
      this.closeResult = `Closed with: ${result}`;
    });
  }

  openTablePopUpContent(content, orgId) {
    this.currentPositionPopUpSelectedOrgId = orgId;
    console.log('org ID', this.currentPositionPopUpSelectedOrgId);
    this.setPositionsByOrg(1, orgId);
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title', size: 'lg'}).result.then((result) => {
      this.selectedUsersAndOrgs = this.dataMainChecked;

      this.closeResult = `Closed with: ${result}`;
    });
  }
  openFolderPopup(content, selectedUserOrOrg) {
    console.log('openFolderPopup :: selectedUserOrOrg = ', selectedUserOrOrg);
    this.editFolderSelected = selectedUserOrOrg;
    if(this.editFolderSelected.folderIdList && this.editFolderSelected.folderIdList.length > 0) {
      this.selectedNode = this.editFolderSelected.folderIdList;
    } else {
      this.selectedNode = [];
    }
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title', size: 'lg'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    });
  }

  log(val) { console.log(val); }

  closeConfigPosition() {
    this.isOpenChoosedUsers = false;
  }

  checkAllowConfig(selectedUserOrOrg) {
    console.log('here', selectedUserOrOrg, this.dataKnowChecked);
    if (selectedUserOrOrg.type === 'User') {
      for (let i = 0; i < this.dataMainChecked.length; i++) {
        if ( this.dataMainChecked[i].type == selectedUserOrOrg.type &&  this.dataMainChecked[i].id == selectedUserOrOrg.id) {
          if (selectedUserOrOrg.allowConfig == true) {
            console.log('comehere1', this.dataMainChecked[i].id, selectedUserOrOrg.id);
            selectedUserOrOrg.allowConfig = false;
            this.dataMainChecked[i].allowConfig = false;
          }
          else {
            console.log('comehere2');
            selectedUserOrOrg.allowConfig = true;
            this.dataMainChecked[i].allowConfig = true;

          }

        }
      }
    }
    else if (selectedUserOrOrg.type === 'Org') {
      for (let i = 0; i < this.dataMainChecked.length; i++) {
        if ( this.dataMainChecked[i].type == selectedUserOrOrg.type &&  this.dataMainChecked[i].id == selectedUserOrOrg.id) {
          if (selectedUserOrOrg.allowConfig == true) {
            console.log('comehere1', this.dataMainChecked[i].id, selectedUserOrOrg.id);
            selectedUserOrOrg.allowConfig = false;
            this.dataMainChecked[i].allowConfig = false;
          }
          else {
            console.log('comehere2');
            selectedUserOrOrg.allowConfig = true;
            this.dataMainChecked[i].allowConfig = true;

          }
        }
      }
    }
    else if (selectedUserOrOrg.type === 'Position') {
      for (let i = 0; i < this.dataMainChecked.length; i++) {
        if ( this.dataMainChecked[i].type == selectedUserOrOrg.type
          &&  this.dataMainChecked[i].id == selectedUserOrOrg.id
          &&  this.dataMainChecked[i].positionId == selectedUserOrOrg.positionId) {
          if (selectedUserOrOrg.allowConfig == true) {
            console.log('comehere1', this.dataMainChecked[i].id, selectedUserOrOrg.id);
            selectedUserOrOrg.allowConfig = false;
            this.dataMainChecked[i].allowConfig = false;
          }
          else {
            console.log('comehere2');
            selectedUserOrOrg.allowConfig = true;
            this.dataMainChecked[i].allowConfig = true;

          }
        }
      }
      // this.addOrRemovePosition(selectedUserOrOrg, selectedUserOrOrg.orgId)
    }
  }

  checkAllowSign(selectedUserOrOrg) {
    console.log('here', selectedUserOrOrg, this.dataKnowChecked);
    if (selectedUserOrOrg.type === 'User') {
      for (let i = 0; i < this.dataMainChecked.length; i++) {
        if ( this.dataMainChecked[i].type == selectedUserOrOrg.type &&  this.dataMainChecked[i].id == selectedUserOrOrg.id) {
          if (selectedUserOrOrg.allowSign == true) {
            console.log('comehere1', this.dataMainChecked[i].id, selectedUserOrOrg.id);
            selectedUserOrOrg.allowSign = false;
            this.dataMainChecked[i].allowSign = false;
          }
          else {
            console.log('comehere2');
            selectedUserOrOrg.allowSign = true;
            this.dataMainChecked[i].allowSign = true;

          }

        }
      }
    }
    else if (selectedUserOrOrg.type === 'Org') {
      for (let i = 0; i < this.dataMainChecked.length; i++) {
        if ( this.dataMainChecked[i].type == selectedUserOrOrg.type &&  this.dataMainChecked[i].id == selectedUserOrOrg.id) {
          if (selectedUserOrOrg.allowSign == true) {
            console.log('comehere1', this.dataMainChecked[i].id, selectedUserOrOrg.id);
            selectedUserOrOrg.allowSign = false;
            this.dataMainChecked[i].allowSign = false;
          }
          else {
            console.log('comehere2');
            selectedUserOrOrg.allowSign = true;
            this.dataMainChecked[i].allowSign = true;

          }
        }
      }
    }
    else if (selectedUserOrOrg.type === 'Position') {
      for (let i = 0; i < this.dataMainChecked.length; i++) {
        if ( this.dataMainChecked[i].type == selectedUserOrOrg.type
          &&  this.dataMainChecked[i].id == selectedUserOrOrg.id
          &&  this.dataMainChecked[i].positionId == selectedUserOrOrg.positionId) {
          if (selectedUserOrOrg.allowSign == true) {
            console.log('comehere1', this.dataMainChecked[i].id, selectedUserOrOrg.id);
            selectedUserOrOrg.allowSign = false;
            this.dataMainChecked[i].allowSign = false;
          }
          else {
            console.log('comehere2');
            selectedUserOrOrg.allowSign = true;
            this.dataMainChecked[i].allowSign = true;

          }
        }
      }
      // this.addOrRemovePosition(selectedUserOrOrg, selectedUserOrOrg.orgId)
    }
  }

  uncheckSelectedUserOrOrg(selectedUserOrOrg) {
    console.log('here', selectedUserOrOrg);
    if (selectedUserOrOrg.type === 'User') {
      console.log('here', selectedUserOrOrg);
      this.unSelectUser(selectedUserOrOrg, this.showTree);
      for (let i = 0; i < this.dataMainChecked.length; i++) {
        console.log(this.dataMainChecked[i].type == selectedUserOrOrg.type &&  this.dataMainChecked[i].id == selectedUserOrOrg.id);
        console.log(this.dataMainChecked.length);
        if ( this.dataMainChecked[i].type == selectedUserOrOrg.type &&  this.dataMainChecked[i].id == selectedUserOrOrg.id) {
            console.log('vao day roi', this.dataMainChecked[i]);
            this.dataMainChecked.splice(i, 1);
            console.log(this.dataMainChecked.length);
            console.log(this.dataMainChecked);
            break;
        }
      }
    }
    else if (selectedUserOrOrg.type === 'Org') {
      this.unSelectOrg(selectedUserOrOrg.id, this.showTree);
      for (let i = 0; i < this.dataMainChecked.length; i++) {
        if ( this.dataMainChecked[i].type == selectedUserOrOrg.type &&  this.dataMainChecked[i].id == selectedUserOrOrg.id) {
            this.dataMainChecked.splice(i, 1);
            console.log(this.dataMainChecked);
            break;
        }
      }
    }
    else if (selectedUserOrOrg.type === 'Position') {
      console.log('positiona', selectedUserOrOrg, this.dataMainChecked);
      console.log('==============');
      console.log(selectedUserOrOrg);
      this.addOrRemovePosition(selectedUserOrOrg, selectedUserOrOrg.orgId);
    }
  }

  unSelectOrg(selectedOrgId, orgTree) {
    for(let j = 0; j < orgTree.length; j++) {
      if(!orgTree[j].data.hasOwnProperty('userName')) {
        if(selectedOrgId == orgTree[j].data.id) {
          orgTree[j].data.isMainChecked = false;
        } else {
          if(orgTree[j].children && orgTree[j].children.length > 0) {
            this.unSelectOrg(selectedOrgId, orgTree[j].children);
          }
        }
      }
    }
  }

  selectOrg(orgId, orgTree) {
    console.log('in select progress', orgId);
    for(let j = 0; j < orgTree.length; j++) {
      if(!orgTree[j].data.hasOwnProperty('userName')) {
        if(orgId == orgTree[j].data.id) {
          orgTree[j].data.isMainChecked = true;
        } else {
          if(orgTree[j].children && orgTree[j].children.length > 0) {
            this.selectOrg(orgId, orgTree[j].children);
          }
        }
      }
    }
  }

  unSelectUser(selecedUser, orgTree) {
    for(let j = 0; j < orgTree.length; j++) {
      if(!orgTree[j].data.hasOwnProperty('userName')) {
        if(selecedUser.orgId == orgTree[j].data.id) {
          for(let t = 0; t < orgTree[j].children.length ; t++ ) {
            if (selecedUser.id == orgTree[j].children[t].data.id) {
              orgTree[j].children[t].data.isMainChecked = false;
            }
          }
        } else {
          if(orgTree[j].children && orgTree[j].children.length > 0) {
            this.unSelectUser(selecedUser, orgTree[j].children);
          }
        }
      }
    }
  }

  saveInCurrentSelectedNode() {
    let nodes = this.process.nodes;
    for (var i = 0; i < nodes.length; i++) {
      if (nodes[i].ident == this.selectedTaskId) {
        this.process.nodes[i].conditions = this.dataMainChecked;
        console.log('current this.dataMainChecked', this.dataMainChecked);
        console.log('in save', this.process.nodes[i].conditions);
        this.process.nodes[i].conditions.forEach(
          x => {
            delete x.folderIdList;
          }
        );
        this.process.nodes[i].name = this.selectedTaskName;
        console.log('selected Task Name', this.selectedTaskName);
        break;
      }
    }
    console.log(this.process);
    console.log('ádsa', this.dataMainChecked);
    this.updateProcess.emit(this.process);
  }


  firstLoadSelectedUsersAndOrgs() {
  }

  setCurrentNodeandConditions() {
    for (var i = 0; i < this.process.nodes.length; i++) {
      if (this.process.nodes[i].ident == this.selectedTaskId) {
        this.currentNode = this.process.nodes[i];
        this.selectedTaskName = this.process.nodes[i].name;
        this.currentConditions = this.currentNode.conditions;
        break;
      }
    }
  }

  addOrRemovePosition(position, orgId) {
    position.allowConfig = this.currentSelectedPostions.find(item => item.positionId == position.id) ? this.currentSelectedPostions.find(item => item.positionId == position.id).allowConfig : false;
    // = this.currentSelectedPostionIds.includes(position.positionId)
    console.log('position', position);
    let isPositionChecked;
    let positions = this.dataMainChecked.filter(data => data.type == 'Position' && data.orgId == orgId);
    for (let checkedPosition of positions) {
      console.log('gg', isPositionChecked);
      console.log(this.dataMainChecked);
      if (checkedPosition.positionId == position.positionId) {
        isPositionChecked = true;
        break;
      }
      else {
        isPositionChecked = false;
      }
    }

    let orgName;
    if(position.org) {
      orgName = position.orgName;
    }
    let obj = {
              'type': 'Position',
              'positionId': position.positionId,
              'name': position.positionName,
              'orgName': position.orgName,
              'orgId': position.orgId,
              'id': position.orgId,
              'allowConfig': position.allowConfig,
              'allowSign': position.allowSign,
              'folderId': position.folderId,
              'folderIdList': this.getFolderIdList(position.folderId),
            };

    console.log('position', obj);

    if (isPositionChecked) {
      this.removePosition(position);
      if (positions.length == 1 ) {
        this.unSelectOrg(position.orgId, this.showTree);
      }
    } else {
      console.log('here is position');
      // position.type = "position"
      this.dataMainChecked.push(obj);

      this.removeAndSelectOrg(position.orgId);

      this.currentSelectedPostions.push(position);
      this.currentSelectedPostionIds.push(position.positionId);
    }
  }


  removeAndSelectOrg(orgId) {
    for (let i = 0; i < this.dataMainChecked.length; i++) {
      if ( this.dataMainChecked[i].orgId == orgId && this.dataMainChecked[i].type == 'Org'
            &&  this.dataMainChecked[i].positionId == null) {
          this.dataMainChecked.splice(i, 1);
          break;
      }
    }
    this.selectOrg(orgId, this.showTree);
  }

  // addPosition() {
  //   console.log("here is position")
  //     // position.type = "position"
  //     this.dataMainChecked.push(obj);

  //     for (let i = 0; i < this.dataMainChecked.length; i++) {
  //       if ( this.dataMainChecked[i].orgId == position.orgId &&  this.dataMainChecked[i].positionId == null) {
  //           this.dataMainChecked.splice(i, 1);
  //           break;
  //       }
  //     }
  //     this.currentSelectedPostions.push(position)
  //     this.currentSelectedPostionIds.push(position.positionId)

  // }

  removePosition(position) {
    for (let i = 0; i < this.dataMainChecked.length; i++) {
      if ( this.dataMainChecked[i].orgId == position.orgId &&  this.dataMainChecked[i].positionId == position.positionId) {
        this.dataMainChecked.splice(i, 1);
        break;
      }
    }

    for (let i = 0; i < this.currentSelectedPostions.length; i++) {
      if ( this.currentSelectedPostions[i].orgId == position.orgId &&  this.currentSelectedPostions[i].positionId == position.positionId) {
          this.currentSelectedPostions.splice(i, 1);
          break;
      }
    }

    let index = this.currentSelectedPostionIds.indexOf(position.positionId);
    this.currentSelectedPostionIds.splice(index, 1);

  }

  private findSelectedUserAndOrgByTaskId(taskId, taskList){
    for (var i=0; i < taskList.length; i++) {
        if (taskList[i].ident === taskId) {
            return taskList[i].conditions;
        }
    }
  }

  // pagination action
  setPositionsByOrg($event, orgId) {
    this.urlQuery.page = $event.toString();
    this.positionPaging.orgId = orgId;
    this.positionService.getWithPaginations(orgId, this.urlQuery).subscribe({
      next: data => {
        this.positionsByOrg = data.objList ? data.objList : [];
        this.positionPaging.totalRecord = data.totalRecord,
        this.positionPaging.currentPage = $event;

      },
      error: err => console.log('error')
    });
  }

  isCheckedPosition(positionId, currentPositionPopUpSelectedOrgId) {
    let positions = this.dataMainChecked.filter(data => data.type == 'Position');
    for (let position of positions) {
      if (position.positionId == positionId && position.orgId == currentPositionPopUpSelectedOrgId ) {
        return true;
      }
    }
    return false;
  }

  loadRootFolderList() {
    this.ticKet = this.tokenService.getTickets();
    this.documentService.getAllFolder(this.ticKet, '', 1, 1, '', 0, 100).subscribe((res: any) => {
      this.folderList = res.data.list.entries;
    });
  }

  onNodeExpandTree(event, isSelected) {
    this.loading = true;
    this.nodeId = event.node.data.id;
    this.documentService.getAllFolder(this.ticKet, this.nodeId, 1, 1, '', 0, 100).subscribe((res: any) => {
      const folderList = res.data.list.entries;
      console.log('this.listFolder : ', folderList);
      setTimeout(() => {
        this.loading = false;
        const node = event.node;
        node.children = [];
        for(let i = 0; i < folderList.length; i++) {
          console.log('this.listFolder[i].entry.isFolder : ', folderList[i].entry.isFolder);
            const nodechild = {
                data: folderList[i].entry,
                leaf: folderList[i].entry.isFolder ? false : true,
            };

            node.children.push(nodechild);
        }
        this.files = [...this.files];
      }, 250);
    });
    console.log('Lazy tree :: onNodeExpand event = ', event, this.files);
  }
  loadNodesForTree(nodeId) {
    this.ticKet = this.tokenService.getTickets();
    this.loading = true;
    this.documentService.getAllFolder(this.ticKet, nodeId, 1, 1, '', 0, 100).subscribe((res: any) => {
      const folderList = res.data.list.entries;
      console.log('this.listFolder : ', folderList);
      setTimeout(() => {
        this.loading = false;
        this.files = [];

        for(let i = 0; i < folderList.length; i++) {
          console.log('this.listFolder[i].entry.isFolder : ', folderList[i].entry.isFolder);
            let node = {
                data: folderList[i].entry,
                leaf: folderList[i].entry.isFolder ? false : true,
            };

            this.files.push(node);
        }
    }, 1000);
    });
  }
  onClick(event, selectedNode) {
    console.log('selectedNode : ', selectedNode);
    if (this.editFolderSelected.type === 'User') {
      for (let i = 0; i < this.dataMainChecked.length; i++) {
        if ( this.dataMainChecked[i].type == this.editFolderSelected.type &&  this.dataMainChecked[i].id == this.editFolderSelected.id) {
          this.editFolderSelected.folderIdList = selectedNode;
          this.dataMainChecked[i].folderIdList = selectedNode;
          this.editFolderSelected.folderId = this.getFolderId(this.editFolderSelected.folderIdList);
          this.dataMainChecked[i].folderId = this.getFolderId(this.dataMainChecked[i].folderIdList);
        }
      }
    } else if (this.editFolderSelected.type === 'Org') {
      for (let i = 0; i < this.dataMainChecked.length; i++) {
        if ( this.dataMainChecked[i].type == this.editFolderSelected.type &&  this.dataMainChecked[i].id == this.editFolderSelected.id) {
          this.editFolderSelected.folderIdList = selectedNode;
          this.dataMainChecked[i].folderIdList = selectedNode;
          this.editFolderSelected.folderId = this.getFolderId(this.editFolderSelected.folderIdList);
          this.dataMainChecked[i].folderId = this.getFolderId(this.dataMainChecked[i].folderIdList);
        }
      }
    } else if (this.editFolderSelected.type === 'Position') {
      for (let i = 0; i < this.dataMainChecked.length; i++) {
        if ( this.dataMainChecked[i].type == this.editFolderSelected.type
          &&  this.dataMainChecked[i].id == this.editFolderSelected.id
          &&  this.dataMainChecked[i].positionId == this.editFolderSelected.positionId) {
          this.editFolderSelected.folderIdList = selectedNode;
          this.dataMainChecked[i].folderIdList = selectedNode;
          this.editFolderSelected.folderId = this.getFolderId(this.editFolderSelected.folderIdList);
          this.dataMainChecked[i].folderId = this.getFolderId(this.dataMainChecked[i].folderIdList);
        }
      }
    }
  }
  getFolderId(folderIdList) {
    let tmp = '';
    folderIdList.forEach(
      element => {
        tmp = tmp == '' ? element.data.id : tmp + ',' + element.data.id;
      }
    );
    return tmp;
  }
  getFolderIdList(folderIdstr) {
    let tmpArr = [];
    if(folderIdstr) {
      const tmp = folderIdstr.split(',');
      for(let i = 0; i < tmp.length; i++) {
        this.documentService.getFolder(this.ticKet, tmp[i]).subscribe(
          data => {
            let tmp = data.data.entry;
            delete tmp.aspectNames;
            delete tmp.properties;
            const node = {
              data: tmp,
              leaf: false,
            };
            tmpArr.push(node);
          }
        );
      }
    }
    return tmpArr;
  }
}
