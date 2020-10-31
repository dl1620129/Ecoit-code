import { Component, OnInit } from '@angular/core';

import { HttpClient } from '@angular/common/http';

import { HttpHeaders } from '@angular/common/http';
// import * as AlfrescoApi from 'alfresco-js-api';

import { NgbModal, ModalDismissReasons, NgbDropdownConfig } from '@ng-bootstrap/ng-bootstrap';
import { DocumentService } from '../../../services/document.service';
import { Folder } from '../../../core/model/doucment/folder';
import { Constant } from 'src/app/core/config/constant';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { TokenService } from '../../../core/authen/token.service';
import { Item } from '@syncfusion/ej2-angular-navigations';
import { UserService } from 'src/app/services/user.service';
import { CategoryService } from 'src/app/services/category.service';
import { Category } from "../../../core/model/domain/category";
import { Buffer } from 'buffer';
import * as FileSaver from 'file-saver';
import { saveAs as importedSaveAs } from "file-saver";
import { Observable, Subscription } from 'rxjs';
import 'rxjs/add/operator/timeout';
import {OrganizationService} from 'src/app/services/organization.service';
import { SharedPreferences } from 'src/app/core/config/shared-preferences';
import {HttpParams} from '@angular/common/http';
import { DomSanitizer } from '@angular/platform-browser';
import { switchMap } from 'rxjs/operators';
import {TreeNode} from "primeng/api";
@Component({
  selector: 'app-document-list',
  templateUrl: './document-list.component.html',
  styleUrls: ['./document-list.component.css']
})
export class DocumentListComponent implements OnInit {

  constructor(private service: DocumentService,
    private organizationService: OrganizationService,
    private tokenService: TokenService,
    private route: ActivatedRoute,
    private toastr: ToastrService,
    private modalService: NgbModal,
    private userService: UserService,
    private router: Router,
    private categoryService: CategoryService,
    private sharedPreferences: SharedPreferences,
    private dropdownConfig: NgbDropdownConfig,
    private sanitizer: DomSanitizer) {
    dropdownConfig.placement = "bottom-center";
  }
  unsb: Subscription;
  unsb1: Subscription;

  searchUserList: any;
  searchForm = {
    name: '',
  };
  isSearch = false;
  paging = {
    itemsPerPage: Constant.ITEMS_PER_PAGE,
    currentPage: 1,
    totalRecord: -1,
    totalItems: -1,
  };
  searchFields = {
    fullName: '',
    userName: '',
    email: '',
    phone: '',
    sex: null,
    indentity: '',
    title: null,
    employeeId: null,
    employeeCode: null,
    salt: null,
    role: null,
    position: null,
    lead: null,
    birthday: null,
    org: null,
    page: 1,
    sortBy: '',
    direction: Constant.SORT_TYPE.DECREASE,
    size: Constant.PAGING.SIZE,
  };

  position: null;
  positionsSearch;
  positionOfRole;
  userOfRole;//Danh sách user hiện tại theo role
  users;
  textSearch: '';
  usersSearch: any[];
  groupsSearch: any[];
  listFolder: any[];
  listFile: any[];
  ticKet = '';
  folderName = '';
  closeResult = '';
  sortName: string = 'name'
  root: string;
  showSort: boolean = true;
  historyNodeId: any[] = new Array();
  historyNum = 0;
  nodeId = '';
  showTable = true;
  folder: Folder = new Folder();
  oderBy: number = 1;
  disableRemoveBtn: boolean = true;
  listNodeIds: any[] = new Array();
  showView: boolean = true;
  modal: any;
  type: number = 3
  modalUpload: any;
  listLuong:any[]= new Array();
  modalDelete: any;
  searchList;
  showAdd: boolean = true;
  selectedLuong;
  viewImg;

  processTreeData: TreeNode[];
  dataTree: TreeNode = {};
  mainTree;
  showTree;
  listChildTreeFolder;
  currentSelect = null;
  cols;

  ngOnInit() {
    this.ticKet = this.tokenService.getTickets();
    let nodeId = this.route.snapshot.paramMap.get('id');
    if (nodeId == null || nodeId == undefined) {
      nodeId = '';
    }
    this.searchFields.page = 1;
    this.getAllData(nodeId, 3, this.searchFields.page, this.searchFields.size);
    // this.getAllFile(nodeId);
    this.getAllUser();
    this.getAllPosition();
    this.getAllLuonData();
    // this.service.getTicket().subscribe((data: any) => {
    //   this.ticKet = data.data.entry.id;

    // })

    this.historyNodeId.push("-root-")
    this.cols = [
      { field: 'name', header: 'Tên' },
    ];

  }
listTreeFolder;
  creatDataTree() {
    this.listTreeFolder = Array.from(this.listFolder);
    for (let i = 0; i < this.listTreeFolder.length; i++) {
      if(this.listTreeFolder[i].entry.isFolder){
        this.dataTree.data = this.listTreeFolder[i];
        this.processTreeData.push(this.dataTree);
        this.dataTree = {};
      }

    }

    this.mainTree = <TreeNode[]>this.processTreeData;
    if (this.mainTree && this.mainTree.length > 0) {
      this.showTree = <TreeNode[]>this.mainTree;
    }
  }
  childTreeFolder;
  FolderChildren = [];
  listTexxt;
  clickViewChild(item){
    this.listTexxt = item;
    this.service.getAllFolder(this.ticKet, item.entry.id, 1, this.oderBy, this.sortName, 0, 100).subscribe((res: any) => {
      this.childTreeFolder = res.data.list.entries;
      console.log("item entries",res.data.list.entries)
      this.listChildTreeFolder = Array.from(this.childTreeFolder);
      for (let i = 0; i < this.listChildTreeFolder.length; i++) {
          this.FolderChildren.push(this.listChildTreeFolder[i]);
      }
      console.log("processTreeData",this.processTreeData)
      console.log("FolderChildren",this.FolderChildren)

      this.checkParentTree(this.processTreeData,this.FolderChildren);
      console.log("listTexxt",this.listTexxt)
      this.mainTree = <TreeNode[]>this.processTreeData;
      if (this.mainTree && this.mainTree.length > 0) {
        this.showTree = <TreeNode[]>this.mainTree;
      }
    })
  }
  checkParentTree(listParent, listChildren) {
    for (let i = 0; i < listParent.length; i++) {
      for (let j = 0; j < listChildren.length; j++) {
        console.log("listChildren",listChildren[j].entry)
        if(listChildren[j].entry != undefined){
          if (listParent[i].data.entry.id == listChildren[j].entry.parentId) {
            if (!listParent[i].children) {
              listParent[i].children = [];
            }
            this.dataTree.data = listChildren[j];
            listChildren[j] = [];
            listParent[i].children.push(this.dataTree);
            this.dataTree = {};
            this.checkParentTree(listParent[i].children, listChildren);
          }
        }
      }
    }
  }
  getAllLuonData(){
    this.service.getLuong().subscribe((res:any)=>{
      this.listLuong= res.data.content;
    })
  }
  downLoadFolder(id: string, name: any, nodeType: string) {

    this.service.asZip(this.ticKet, id).subscribe((result: any) => {
      let downloadId: string;
      downloadId = result.data.entry.id;
      console.log(result.data.entry.status);
      if (result.data.entry.status == 'PENDING') {
        this.getAsZipFolder(this.ticKet, downloadId, name, nodeType);
      }
    })
  }
  getAsZipFolder(key: string, downloadId: string, name: string, nodeType: string) {
    this.service.getAsZipFile(key, downloadId).subscribe((res) => {
      console.log(res.data.entry.status);
      if (res.data.entry.status == 'DONE') {
        if (downloadId !== null && downloadId !== undefined) {
          this.service.downloadAsZipFile(this.ticKet, downloadId).subscribe((response) => {
            console.log(response);
            if (nodeType == 'cm:content') {
              FileSaver.saveAs(response, name);
            } else FileSaver.saveAs(response, name + '.zip');
          }), error => console.log('Error downloading the file'),
            () => console.info('File downloaded successfully');
        }
      } else {
        setTimeout(() => {
          this.getAsZipFolder(key, downloadId, name, nodeType);
        }, 1000);;
      }

    });
  }
  downLoadFile(id: string) {
    this.service.downLoad(id, this.ticKet).subscribe((data: any) => {
    })
  }

  getAllData(id: String, type: number, start: number, pageSize: number) {
    this.processTreeData = [];
    this.service.getAllFolder(this.ticKet, id, 3, this.oderBy, this.sortName, this.searchFields.size*(this.searchFields.page-1)+1, this.searchFields.size).subscribe((res: any) => {
      this.listFolder = res.data.list.entries;
      this.paging.totalItems = res.data.list.pagination.totalItems;
      this.listFolder.forEach(element => {
        if(element.entry.isFile){
          this.service.previewDocument(this.ticKet, element.entry.id, "doclib").pipe(switchMap(blob => 
            this.convertBlobToBase64(blob))).subscribe(
                base64ImageUrl =>  element.thumbnail = base64ImageUrl
            );   
        }
      });
      this.creatDataTree();
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
      this.service.getAllFolder(this.ticKet, nodeId, 3, this.oderBy, this.sortName, this.searchFields.size*(this.searchFields.page-1)+1, this.searchFields.size).subscribe((res: any) => {
        this.listFolder = res.data.list.entries;
      })
    })
  }
  showTableEvent() {
    this.showTable = false;
  }
  back() {
    this.historyNodeId.pop();
    this.historyNum--;
    this.nodeId = this.historyNodeId.pop();
    this.historyNum--;
    this.getFolderByNodeId(this.nodeId)
  }

  CreateFolderAlfresco(id: string) {

    let nodeId = this.route.snapshot.paramMap.get('id');
    if (nodeId == null) nodeId = '';
    if (id != null || id != undefined) {
      this.service.updateFolder(this.folder, this.ticKet, id).subscribe((data: any) => {
        if (data.resultCode == 200) {
          if(data.data.entry.nodeType=='cm:folder'){
            this.service.updateFolderDb(this.folder,id,nodeId).subscribe();
          }else{
            this.service.updateFileDb(this.folder,id,nodeId).subscribe();
          }
          this.toastr.success('Cập nhật thành công!', 'Thành công');
          this.modal.close();
          this.getAllData(nodeId, this.type, this.searchFields.size*(this.searchFields.page-1)+1, this.searchFields.size);
        }
      })
    } else {
      this.service.createFolder(this.folder, this.ticKet, nodeId).subscribe((res: any) => {
        let id = res.data.entry.id;
        console.log(id);
        console.log(res);
        if (res.resultCode == 200) {

          this.service.createFolderDb(this.folder, id, nodeId).subscribe((result: any) => {
            if (result.resultCode == 200) {
              console.log(result);
              this.toastr.success('Thêm thư mục thành công!', 'Thành công');
              this.modal.close();
              this.getAllData(nodeId, this.type, this.searchFields.size*(this.searchFields.page-1)+1, this.searchFields.size);
            } else {
              this.toastr.error('Thêm thư mục thất bại', 'Thất bại');
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
  openDelete(content) {
    this.modalDelete = this.modalService.open(content, { size: 'sm', centered: true, windowClass: 'no-box-shadow' });
  }
  idUpdate: null;
  open(content, id: any) {
    this.idUpdate = id;
    if (id != undefined || id != null) {
      this.service.getFolder(this.ticKet, id).subscribe((res: any) => {
        this.folder.name = res.data.entry.name;
      })
    }
    else this.folder.name = '';
    this.modal = this.modalService.open(content, {centered: true, windowClass: 'no-box-shadow' });
  }
  openFile(content, id: any) {

    this.modal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow' });
  }
  openModalUpload(upload) {
    // this.modal=this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
    //   this.closeResult = `Closed with: ${result}`;
    // }, (reason) => {
    //   this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    // });
    this.modalUpload = this.modalService.open(upload, { size: 'lg', centered: true, windowClass: 'no-box-shadow' });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }
  onSubmit(form: any) {

  }
  getNodeId(id: any) {
  }
  showSortBtnUp() {
    let nodeId = this.route.snapshot.paramMap.get('id');
    this.showSort = true;
    this.oderBy = 1;
    this.getAllData(nodeId, this.type, this.searchFields.size*(this.searchFields.page-1)+1, this.searchFields.size);
  }
  showSortBtnDown() {
    let nodeId = this.route.snapshot.paramMap.get('id');
    this.showSort = false;
    this.oderBy = 2;
    this.getAllData(nodeId, this.type, this.searchFields.size*(this.searchFields.page-1)+1, this.searchFields.size);
  }
  sortKey(event: any) {
    this.sortName = event.target.value;
  }
  getListNodeId(event: any, id: String) {
    let isChecked = event.target.checked;
    if (isChecked) {
      this.listNodeIds.push(id);
    } else {
      const index: number = this.listNodeIds.indexOf(id);
      if (index !== -1) {
        this.listNodeIds.splice(1, 1);
      }
    }
    if (this.listNodeIds.length > 0) {
      this.disableRemoveBtn = false;
    }
    else {
    } this.disableRemoveBtn = true;

  }
  listNodeIdFile: any[] = new Array();
  listFileName: any[] = new Array();
  listFileBeforUpload: any[] = new Array();
  createFile() {
    let nodeId = this.route.snapshot.paramMap.get('id');
    this.service.createFile(this.listFileBeforUpload, this.ticKet, nodeId).subscribe((data) => {
      if (data.resultCode == 200) {
        let luongId: number = + this.selectedLuong;
        this.toastr.success('Tải File lên thành công!', 'Thành công');
        this.modal.close();
        this.getAllData(nodeId, this.type, this.searchFields.size*(this.searchFields.page-1)+1, this.searchFields.size);
        this.listFileBeforUpload = [];
        for (let index = 0; index < data.data.length; index++) {
          this.service.createFileDb(data.data[index].entry.name, data.data[index].entry.id, nodeId, luongId).subscribe();
        }
      }
    })
  }

  deleteFileBeforeUpload(index: number) {
    this.listFileBeforUpload.splice(index, 1);
  }
  viewFileUpload(event: any) {
    for (let index = 0; index < event.target.files.length; index++) {
      this.listFileBeforUpload.push(event.target.files[index]);

    }
  }
  removeNode() {
    let nodeId = this.route.snapshot.paramMap.get('id');
    this.service.deleteFolder(this.ticKet, this.listNodeIds).subscribe(data => {
      this.toastr.success('Xóa mục thành công!', 'Thành công');
      this.listNodeIds = [];
      this.getAllData(nodeId, this.type, this.searchFields.size*(this.searchFields.page-1)+1, this.searchFields.size);
      
    })
  }
  listNodeIdSingle: any[] = new Array();
  deleteSingleNode(id: string) {
    let nodeId = this.route.snapshot.paramMap.get('id');
    this.listNodeIdSingle.push(id);
    this.service.deleteFolder(this.ticKet, this.listNodeIdSingle).subscribe(data => {
      this.toastr.success('Xóa mục thành công!', 'Thành công');
      this.listNodeIdSingle = [];
      this.modal.close();
      this.getAllData(nodeId, this.type, this.searchFields.size*(this.searchFields.page-1)+1, this.searchFields.size);
    });
  }
  viewList() {
    this.showView = true;
  }
  viewTable() {
    this.showView = false;
  }

  doSearchUser() {
    this.usersSearch = [];
    this.userService.searchUserActive(this.textSearch).subscribe(data => {
      if (data)
        this.usersSearch = data;
    })
  }
  getAllUser() {
    this.userService.getUsersActive().subscribe(data => {
      if (data) {
        this.users = data;
      }
    }
    )
  }
  getAllFile(id: String) {
    this.service.getAllFile(this.ticKet, id, 2, this.oderBy, this.sortName).subscribe((res: any) => {
      this.listFile = res.data.list.entries;
      this.listFile.forEach(element => {
        this.service.previewDocument(this.ticKet, element.entry.id, "doclib").pipe(switchMap(blob => 
          this.convertBlobToBase64(blob))).subscribe(
              base64ImageUrl =>  element.thumbnail = base64ImageUrl
          );   
      });
    })
    
  }
  getAllPosition() {
    this.categoryService.getCategoryWithCode(Constant.CATEGORYTYPE_CODE.USER_POSITION).subscribe(
      res => {
        this.positionsSearch = res as Category[];
      },
      err => {
      }
    )
  }
  hienthi(id: number) {
    this.router.navigate(['fileview', id])
  }
  searchSubmit(){
    console.log('searchSubmit :', this.searchList);
    
    this.isSearch = true;
    // this.searchList = this.childMenus;
    this.paging.currentPage = 1;
    this.organizationService.searchOrganization(this.paging.currentPage, this.searchForm).subscribe(
      data => {
        this.searchList = data.content;
        this.paging.totalRecord = data.totalElements;
      }
    );
    this.toastr.success('Tìm kiếm người dùng thành công!', 'Thành công');
  }
  pageChanged($event) {
    this.paging.currentPage = $event;
    this.organizationService.searchOrganization(this.paging.currentPage, this.searchForm).subscribe(
      data => {
        console.log(data);
        this.searchList = data.content;
        this.paging.totalRecord = data.totalElements;
      }
    );
  }
  onSearch(showSuccess, pageNo: number) {
    this.searchFields.page = pageNo
    let params = new HttpParams()
      .set('fullName', this.searchFields.fullName)
      .set('userName', this.searchFields.userName)
      .set('email', this.searchFields.email)
      .set('phone', this.searchFields.phone)
      .set('sex', this.searchFields.sex == null ? '' : this.searchFields.sex)
      .set('indentity', this.searchFields.indentity)
      .set('title', this.searchFields.title == null ? '' : this.searchFields.title)
      .set('employeeId', this.searchFields.employeeId == null ? '' : this.searchFields.employeeId)
      .set('employeeCode', this.searchFields.employeeCode == null ? '' : this.searchFields.employeeCode)
      .set('salt', this.searchFields.salt == null ? '' : this.searchFields.salt)
      .set('org', this.searchFields.org == null ? '' : this.searchFields.org)
      .set('position', this.searchFields.position == null ? '' : this.searchFields.position)
      .set('lead', this.searchFields.lead == null ? '' : this.searchFields.lead)
      .set('birthday', this.searchFields.birthday ? this.searchFields.birthday.toString() : '')
      .set('page', this.searchFields.page.toString())
      .set('sortBy', this.searchFields.sortBy)
      .set('direction', this.searchFields.direction)
      .set('size', this.searchFields.size.toString());
    this.userService.searchUser(params).subscribe(
      data => {
        this.searchUserList = data.content;
        this.paging.totalItems = data.totalElements;
        if (showSuccess == true) {
          if(this.searchFields.fullName!='' || this.searchFields.userName!='' || this.searchFields.phone!='' 
          || this.searchFields.email!='' || this.searchFields.title!=null || this.searchFields.org!=null || this.searchFields.birthday!=null||this.searchFields.indentity!=''){
          this.toastr.success('Tìm kiếm người dùng thành công!', 'Thành công');
          }
        }
        this.sharedPreferences.setDataLocal("user_query", this.searchFields);
      },
      err => {
      }
    );
  }
  onSearchBtClick() {
    this.searchFields.page = 1;
    this.onSearch(true, 1);
  }
  pageChangedUser($event) {
    this.searchFields.page = $event.toString();
    this.onSearch(false, $event);
  }
  viewUser(){
    this.showAdd = true;
  }
  viewGroup(){
    this.showAdd = false;
  }
  
  convertBlobToBase64(blob: Blob) {
    return Observable.create(observer => {
      const reader = new FileReader();
      const binaryString = reader.readAsDataURL(blob);
      reader.onload = (event: any) => {
        this.viewImg = event.target.result;
        observer.next(event.target.result);
        observer.complete();
      };
      reader.onerror = (event: any) => {
        console.log("File could not be read: " + event.target.error.code);
        observer.next(event.target.error.code);
        observer.complete();
      };
    });
  }

  pageChangeFolderAll($event) {
    this.searchFields.page = $event.toString();
    this.getAllData(this.nodeId, 3, this.searchFields.size*this.searchFields.page+1, this.searchFields.size);
  }

  changePageSize($event) {
    this.searchFields.size = $event
    this.getAllData(this.nodeId, 3, 1, this.searchFields.size);
  }
}
