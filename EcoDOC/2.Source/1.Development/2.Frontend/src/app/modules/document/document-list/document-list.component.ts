import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TreeNode } from 'primeng/api';
import { TokenService } from 'src/app/core/authen/token.service';
import { Constant } from 'src/app/core/config/constant';
import { DocumentService } from 'src/app/services/document.service';
import * as FileSaver from 'file-saver';
import { Folder } from 'src/app/core/model/doucment/folder';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { switchMap } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { OrganizationService } from 'src/app/services/organization.service';
import { HttpParams } from '@angular/common/http';
import { SharedPreferences } from 'src/app/core/config/shared-preferences';
import { UserService } from 'src/app/services/user.service';
import { CategoryService } from 'src/app/services/category.service';
import { Category } from 'src/app/core/model/domain/category';
import { Decentralization } from 'src/app/core/model/decentralization/decentralization';
import { data } from 'jquery';
import { BpmnService } from 'src/app/services/bpmn.service';
import { Rule } from '../../../core/model/domain/Rules';
import { AlfrescoDocumentModel } from 'src/app/core/model/domain/alfresco_document';
import { SignatureService } from 'src/app/services/signature.service';
import { CommonUtils } from 'src/app/core/common/common-utils';
import { TranslateService } from '@ngx-translate/core';

@Component({
  selector: 'app-document-list',
  templateUrl: './document-list.component.html',
  styleUrls: ['./document-list.component.css']
})

export class DocumentListComponent implements OnInit {

  alfrescoDocument: AlfrescoDocumentModel = new AlfrescoDocumentModel();
  isshowDoneButton;
  listNextNode;
  showSort = true;
  showRules = false;
  modalPermission: any;
  position: null;
  listRules: any[] = new Array();
  positionsSearch;
  disabledAupload = true;
  positionOfRole;
  userOfRole;//Danh sách user hiện tại theo role
  users;
  ruleModel: Rule = new Rule();
  listLuong: any[] = new Array();
  searchList;
  isSearch = false;
  showAdd = true;
  showView = true;
  viewImg;
  selectedLuong;
  modalUpload: any;
  searchUserList: any;
  searchForm = {
    name: '',
  };
  listNodeIdSingle: any[] = new Array();
  modal: any;
  folder = new Folder();
  idUpdate;
  nodeId = '';
  nodeType: number;
  typee: number;
  idPermission: number;
  historyNodeId: any[] = new Array();
  historyNum = 0;
  disableRemoveBtn = true;
  listNodeIds: any[] = new Array();
  listConditions: any[] = new Array();
  listConditionsNoInvert: any[] = new Array();
  listConditionsWithInvert: any[] = new Array();
  listActions: any[] = new Array();
  ticKet = '';
  oderBy = 1;
  sortName = 'name';
  searchFields = {
    fullName: '',
    userName: '',
    page: 1,
    sortBy: '',
    direction: Constant.SORT_TYPE.DECREASE,
    size: Constant.PAGING.SIZE,
  };
  paging = {
    itemsPerPage: Constant.ITEMS_PER_PAGE,
    currentPage: 1,
    totalRecord: -1,
    totalItems: -1,
  };
  isSign: boolean = false;
  modalRef;

  // tho added
  currentSelected = [];
  listFolder: any[];
  loading: boolean;
  files: TreeNode[];
  totalRecords: number;
  selectedNode: TreeNode;
  decen = new Decentralization();
  constructor(
    private sharedPreferences: SharedPreferences,
    private userService: UserService,
    private service: DocumentService,
    private tokenService: TokenService,
    private route: ActivatedRoute,
    private router: Router,
    private modalService: NgbModal,
    private toastr: ToastrService,
    private organizationService: OrganizationService,
    private categoryService: CategoryService,
    private bpmnService: BpmnService,
    private signService: SignatureService,
    private commomUtils: CommonUtils,
    private translateService: TranslateService
  ) { }

  ngOnInit() {
    this.totalRecords = 1000;
    this.loading = true;
    this.ticKet = this.tokenService.getTickets();
    this.nodeId = this.route.snapshot.paramMap.get('id');
    if (this.nodeId == null || this.nodeId == undefined) {
      this.nodeId = '';
    }
    this.loadNodesForTree(this.nodeId);
    this.searchFields.page = 1;

    this.getAllUser();
    this.getAllPosition();
    this.getAllLuonData();
  }
  plusConditionWithInvert() {
    this.listConditionsWithInvert.push(this.conditions);
  }
  minusConditionWithInvert(i) {
    this.listConditionsWithInvert.splice(i, 1);
    console.log(this.listConditionsWithInvert);
  }
  condition = {
    'conditionDefinitionName': '',
    'parameterValues': {
      'operation': '',
      'value': 0,
      'content-property': '',
      'property': ''
    }
  }
  conditions = {
    'conditionDefinitionName': '',
    'parameterValues': {
      'operation': '',
      'value': 0,
      'content-property': '',
      'property': ''
    },
    'invertCondition': true,
  }
  selectAllIf(event: any) {


    if (event.target.checked) {
      this.listConditionsNoInvert.push(this.condition);
    } else {
      this.listConditionsNoInvert = [];
    }
  }
  selectUnAllIf(event: any) {

    if (event.target.checked) {
      this.listConditionsWithInvert.push(this.conditions);
    } else {
      this.listConditionsWithInvert = [];
    }
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
  getAllUser() {
    this.userService.getUsersActive().subscribe(data => {
      if (data) {
        this.users = data;
      }
    }
    )
  }
  loadNodesForTree(nodeId) {
    this.loading = true;
    this.service.getAllFolder(this.ticKet, nodeId, 1, this.oderBy, this.sortName, 0, 100).subscribe((res: any) => {
      const folderList = res.data.list.entries;
      console.log('this.listFolder : ', folderList);
      setTimeout(() => {
        this.loading = false;
        this.files = [];

        for (let i = 0; i < folderList.length; i++) {
          console.log('this.listFolder[i].entry.isFolder : ', folderList[i].entry.isFolder);
          let node = {
            data: folderList[i].entry,
            leaf: folderList[i].entry.isFolder ? false : true,
          };

          this.files.push(node);
        }
      }, 1000);
      this.loadNodesForList(nodeId, null, null);
    });
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
        console.log('File could not be read: ' + event.target.error.code);
        observer.next(event.target.error.code);
        observer.complete();
      };
    });
  }
  loadNodesForList(nodeId, page, size) {
    this.searchFields.size = size != null ? size : this.searchFields.size;
    this.searchFields.page = page != null ? page : 1;
    this.loading = true;
    this.service.getAllFolder(this.ticKet, nodeId, 3, this.oderBy, this.sortName, this.searchFields.size * (this.searchFields.page - 1), this.searchFields.size).subscribe((res: any) => {
      const folderList = res.data.list.entries;
      this.paging.totalItems = res.data.list.pagination.totalItems;
      console.log('this.listFolder : ', folderList);
      setTimeout(() => {
        this.loading = false;
        this.listFolder = [];

        for (let i = 0; i < folderList.length; i++) {
          console.log('this.listFolder[i].entry.isFolder : ', folderList[i].entry.isFolder);
          let node = {
            data: folderList[i].entry,
            leaf: folderList[i].entry.isFolder ? false : true,
          };
          this.listFolder.push(node);
        }
        this.listFolder.forEach(element => {
          if (element.data.isFile) {
            console.log('load thumbnail');
            this.service.previewDocument(this.ticKet, element.data.id, 'doclib').pipe(switchMap(blob =>
              this.convertBlobToBase64(blob))).subscribe(
                base64ImageUrl => {
                  element.thumbnail = base64ImageUrl;
                },
                err => {
                  element.thumbnail = 'assets/images/File.jpg';
                }
              );
          }
        });
      }, 1000);
    });
  }
  onClick(node, row) {
    console.log('onClick event : ', node, row);
  }
  onNodeExpandTree(event, isSelected) {
    this.loading = true;
    this.nodeId = event.node.data.id;
    this.service.getAllFolder(this.ticKet, this.nodeId, 1, this.oderBy, this.sortName, 0, 100).subscribe((res: any) => {
      const folderList = res.data.list.entries;
      console.log('this.listFolder : ', folderList);
      setTimeout(() => {
        this.loading = false;
        const node = event.node;
        node.children = [];
        for (let i = 0; i < folderList.length; i++) {
          console.log('this.listFolder[i].entry.isFolder : ', folderList[i].entry.isFolder);
          const nodechild = {
            data: folderList[i].entry,
            leaf: folderList[i].entry.isFolder ? false : true,
          };

          node.children.push(nodechild);
        }
        if (isSelected) {
          this.loadNodesForList(this.nodeId, null, null);
          event.node.expanded = true;
        }
        this.files = [...this.files];
      }, 250);
    });
    console.log('Lazy tree :: onNodeExpand event = ', event, this.files);
  }
  nodeSelect(event) {
    if (!event.node.expanded) {
      this.onNodeExpandTree(event, true);
    } else {
      this.nodeId = event.node.data.id;
      this.loadNodesForList(this.nodeId, null, null);
    }
    console.log('nodeSelect : ', event, this.listFolder);
  }
  nodeUnselect(event) {
    console.log('nodeUnselect : ', event);
  }
  getFolderByNodeId(nodeId: any) {
    this.historyNodeId.push(nodeId);
    this.historyNum++;
    this.service.getTicket().subscribe((res: any) => {
      this.ticKet = res.data.entry.id;
      this.nodeId = this.route.snapshot.paramMap.get('id');
      this.service.getAllFolder(this.ticKet, nodeId, 3, this.oderBy, this.sortName, this.searchFields.size * (this.searchFields.page - 1) + 1, this.searchFields.size).subscribe((res: any) => {
        this.listFolder = res.data.list.entries;
      })
    })
  }
  hienthi(id: number) {
    this.router.navigate(['fileview', id])
  }
  getAllLuonData() {
    this.service.getLuong().subscribe((res: any) => {
      this.listLuong = res.data.content;
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
        }, 1000);
      }

    });
  }

  openPermission(content, id: any) {
    this.idPermission = id;
    this.modalPermission = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow' });
  }
  idRulesParent;
  openRules(content, id) {
    this.idRulesParent = id;
    this.getAllRule(id);
    this.modalPermission = this.modalService.open(content, { centered: true, windowClass: 'no-box-shadow' });
  }
  getAllRule(id) {
    this.service.getAllRules(id, this.ticKet).subscribe((res: any) => {
      this.listRules = res.data.data;
    })
  }
  createRulesAlfreco() {
    console.log(this.listConditionsWithInvert);
    this.service.createRulesAlfresco(this.ticKet, this.idRulesParent, this.ruleModel).subscribe();
  }
  removeRules(id) {
    this.service.deleteRules(this.idRulesParent, this.ticKet, id).subscribe((res: any) => {
      this.toastr.success('Xóa Rules thành công', 'Thành công');
      this.getAllRule(this.idRulesParent);
    })
  }
  open(content, id: any) {
    this.idUpdate = id;
    if (id != undefined || id != null) {
      this.service.getFolder(this.ticKet, id).subscribe((res: any) => {
        this.folder.name = res.data.entry.name;
        this.folder.title = res.data.entry.properties['cm:title'];
        this.folder.description = res.data.entry.properties['cm:description'];
      })
    }
    else this.folder.name = '';
    this.modal = this.modalService.open(content, { centered: true, windowClass: 'no-box-shadow' });
  }
  deleteSingleNode(id: string) {
    let nodeId = this.route.snapshot.paramMap.get('id');
    this.listNodeIdSingle.push(id);
    this.service.deleteFolder(this.ticKet, this.listNodeIdSingle).subscribe(data => {
      this.service.deactiveFolderDB(this.ticKet, this.listNodeIdSingle).subscribe(data2 => {
        this.toastr.success('Xóa mục thành công!', 'Thành công');
        this.listNodeIdSingle = [];
        this.modal.close();
        this.loadNodesForList(this.nodeId, null, null);
      })
    });
  }
  back() {
    this.historyNodeId.pop();
    this.historyNum--;
    this.nodeId = this.historyNodeId.pop();
    this.historyNum--;
    this.getFolderByNodeId(this.nodeId);
  }

  onListSelect(event: TreeNode, isSelected) {
    console.log('onListSelect : ', event, this.selectedNode);
    this.searchFields.page = 1;
    this.selectedNode = event;
    this.nodeId = event.data.id;
    this.loading = true;
    const nodeId = event.data.id;
    this.service.getAllFolder(this.ticKet, nodeId, 3, this.oderBy, this.sortName, this.searchFields.size * (this.searchFields.page - 1), this.searchFields.size).subscribe((res: any) => {
      const folderList = res.data.list.entries;
      this.paging.totalItems = res.data.list.pagination.totalItems;
      console.log('this.listFolder : ', folderList);
      setTimeout(() => {
        this.loading = false;
        const node = event;
        node.children = [];
        for (let i = 0; i < folderList.length; i++) {
          console.log('this.listFolder[i].entry.isFolder : ', folderList[i].entry.isFolder);
          const nodechild = {
            data: folderList[i].entry,
            leaf: folderList[i].entry.isFolder ? false : true,
          };
          node.children.push(nodechild);
        }
        if (isSelected) {
          this.listFolder = node.children;
          event.expanded = true;
          console.log('Lazy tree :: onNodeExpand this.listFolde = ', this.listFolder, event);
        }
        this.files = [...this.files];
      }, 250);
    });
    console.log('Lazy tree :: onNodeExpand event = ', event, this.files);
  }
  listMenuType: any[] = new Array();
  listMenuAction: any[] = new Array();
  listMenuMap: any[] = new Array();
  acCompareOperations: any[] = new Array();
  selectCompare(event: any, i: number) {
    this.acCompareOperations = Constant.COMPARE_OPERATIONS;
    console.log(event.target.value);
    if (event.target.value == 'd:text') this.showInput = true;
    else this.showInput = false;
    console.log(i)
    for (let index = 0; index < this.listConditionsWithInvert.length; index++) {
      if (index == i) {
        this.acCompareOperations[index] = this.acCompareOperations[event.target.value];
        this.listConditionsWithInvert[index].parameterValues.property = event.target.value;
      }
    }
    console.log(this.listConditionsWithInvert)
  }
  showInput = false;
  getValueOperation(event, i) {
    for (let index = 0; index < this.listConditionsWithInvert.length; index++) {
      if (i == index) {
        this.listConditionsWithInvert[i].parameterValues.operation = event.target.value;
      }
    }

  }
  getValueConditon(event, i) {
    for (let index = 0; index < this.listConditionsWithInvert.length; index++) {
      if (i == index) {
        this.listConditionsWithInvert[i].parameterValues.value = event.target.value;
      }
    }
    console.log(this.listConditionsWithInvert);
  }
  viewRules() {
    this.listMenuType = Constant.MENU_TYPE_DATA;

    for (let index = 0; index < this.listMenuType.length; index++) {
      console.log(this.listMenuType[index]);
    }
    this.listMenuMap = Constant.MENU_MAP_DATA;
    this.listMenuAction = Constant.MENU_ACTION_DATA;

    this.showRules = true;
  }

  createTemplate() {
    let luongId: number = + this.selectedLuong;
    let nodeId = this.selectedNode ? this.selectedNode.data.id : '';
    this.service.createDocument(this.alfrescoDocument, this.ticKet, nodeId).subscribe((res: any) => {
      if (res.resultCode == 200) {
        let id = res.data.body.persistedObject.slice(res.data.body.persistedObject.lastIndexOf("/") + 1, res.data.body.persistedObject.length);
        this.service.createFileDb(this.alfrescoDocument.name, this.alfrescoDocument.title,this.alfrescoDocument.description, id, nodeId, luongId).subscribe(result => {
          if(result.resultCode == 200) {
            console.log(res);
            this.service.createDocumentDB(this.alfrescoDocument, result.data.folderId, result.data.fileId).subscribe(res => {
              this.toastr.success('Thêm tài liệu thành công!', 'Thành công');
              this.modal.close();
              this.loadNodesForList(this.nodeId, null, null);
            })
            }
        })
      } else {
        this.toastr.error('Thêm tài liệu thất bại', 'Thất bại');
      }
    })
  }

  unViewRules() {
    this.showRules = false;
  }

  openFile(content, id: any) {
    this.getStartNode();
    this.modal = this.modalService.open(content, {backdrop: 'static', keyboard: false, centered: true, windowClass: 'no-box-shadow' }).result.then(
      result => {
        this.listFileBeforUpload = [];
        this.currentSelected = [];
      }
    );
  }
  openModalUpload(upload) {
    this.modalUpload = this.modalService.open(upload, { size: 'lg', centered: true, windowClass: 'no-box-shadow' });
  }
 openTemplate(content, id) {
    this.modal = this.modalService.open(content, { centered: true, windowClass: 'no-box-shadow' });
  }
  isSelected(listFolder, item) {
    console.log('isSelected', listFolder, item);
    listFolder.forEach(x => {
      if (x.data.id == item.data.id && x.data.selected) {
        x.data.selected = false;
        // this.currentSelected = null;
        this.currentSelected = this.currentSelected.filter(y => y.data.id != item.data.id);
      } else if (x.data.id == item.data.id && !x.data.selected) {
        // this.currentSelected = x;
        this.currentSelected.push(x);
        x.data.selected = true;
        if (x.data.nodeId == null) {
          this.listNextNode = null;
          this.getStartNode();
        } else {
          this.listNextNode = null;
          this.getNextNode(x.data.nodeId);
        }
      } else {
        // x.data.selected = false;
      }
    });
    console.log('isSelected :: this.currentSelected = ', this.currentSelected);
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
    this.service.createFile(this.listFileBeforUpload, this.ticKet, this.nodeId).subscribe((data) => {
      if (data.resultCode == 200) {
        let luongId: number = + this.selectedLuong;
        this.listFileBeforUpload = [];
        for (let index = 0; index < data.data.length; index++) {
          console.log('---' + data.data[index].resultCode);
          if (data.data[index].resultCode == 500) {
            this.toastr.error('Có file chưa được cấu hình tải lên!', 'Thất bại');
          } else {
            this.service.createFileDb(data.data[index].entry.name, data.data[index].entry.properties['cm:title'], data.data[index].entry.properties['cm:description'], data.data[index].entry.id, this.nodeId, luongId).subscribe(response => {
              console.log(response);
              this.toastr.success('Tải File ' + data.data[index].entry.name + ' lên thành công!', 'Thành công');
            });

          }

        }
      }
      this.loadNodesForList(this.nodeId, null, null);
    });
  }
  deleteFileBeforeUpload(index: number) {
    this.listFileBeforUpload.splice(index, 1);
    if (this.listFileBeforUpload.length > 0) {
      this.disabledAupload = false;
    } else {
      this.disabledAupload = true;
    }
  }
  viewFileUpload(event: any) {
    console.log(event);
    this.prepareFilesList(event.target.files);

  }
  createFolderAlfresco(id: string) {
    if (this.folder.name.trim() == "") {
      this.toastr.warning('Bạn chưa nhập tên', 'Cảnh báo');
    } else {
      let nodeId = this.selectedNode ? this.selectedNode.data.id : '';
      if (nodeId == null) nodeId = '';
      if (id != null || id != undefined) {
        this.service.updateFolder(this.folder, this.ticKet, id).subscribe((data: any) => {
          console.log(data)
          let id = data.data.body.persistedObject.slice(data.data.body.persistedObject.lastIndexOf("/") + 1, data.data.body.persistedObject.length);
          this.service.getFolder(this.ticKet, id).subscribe((resdt: any) => {
            if (resdt.resultCode == 200) {
              if (resdt.data.entry.nodeType == 'cm:folder') {
                this.service.updateFolderDb(this.folder, id, nodeId).subscribe();
              } else {
                this.service.updateFileDb(this.folder, id, nodeId).subscribe();
              }
              this.toastr.success('Cập nhật thành công!', 'Thành công');
              this.modal.close();
              this.loadNodesForList(this.nodeId, null, null);
            }
          })

        })
      } else {
        this.service.createFolder(this.folder, this.ticKet, nodeId).subscribe((res: any) => {
          let id = res.data.body.persistedObject.slice(res.data.body.persistedObject.lastIndexOf("/") + 1, res.data.body.persistedObject.length);
          console.log(id);
          console.log(res);
          if (res.resultCode == 200) {

            this.service.createFolderDb(this.folder, id, nodeId).subscribe((result: any) => {
              if (result.resultCode == 200) {
                console.log(result);
                this.toastr.success('Thêm thư mục thành công!', 'Thành công');
                this.modal.close();
                this.loadNodesForList(this.nodeId, null, null);
              } else {
                this.toastr.error('Thêm thư mục thất bại', 'Thất bại');
              }
            })
          } else if (res.resultCode == 500) {
            console.log('res.resultCode :' + res.resultCode)
          } else {
            this.toastr.error('Thêm thư mục thất bại', 'Thất bại');
          }
        })

      }
    }


  }
  removeNode() {
    this.service.deleteFolder(this.ticKet, this.listNodeIds).subscribe(data => {
      this.toastr.success('Xóa mục thành công!', 'Thành công');
      this.listNodeIds = [];
      this.loadNodesForList(this.nodeId, null, null);
    })
  }

  pageChangeFolderAll($event) {
    this.searchFields.page = $event.toString();
    this.loadNodesForList(this.nodeId, this.searchFields.page, null);
  }

  changePageSize($event) {
    this.searchFields.size = $event;
    this.loadNodesForList(this.nodeId, null, this.searchFields.size);
  }

  viewList() {
    this.showView = true;
  }
  viewTable() {
    this.showView = false;
  }
  searchSubmit() {
    console.log('searchSubmit :', this.searchList);

    this.isSearch = true;
    // this.searchList = this.childMenus;
    this.paging.currentPage = 1;

    if (this.searchForm.name != '') {
      this.organizationService.searchOrganization(this.paging.currentPage, this.searchForm).subscribe(
        data => {
          this.searchList = data.content;
          this.paging.totalRecord = data.totalElements;
        }
      );
      this.toastr.success('Tìm kiếm người dùng thành công!', 'Thành công');
    } else {
      this.toastr.error('Nhập tên cần tìm kiếm!', 'Yêu cầu');
    }
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
      .set('page', this.searchFields.page.toString())
      .set('size', this.searchFields.size.toString());
    if (this.searchFields.fullName != '') {
      this.userService.searchUser(params).subscribe(
        data => {
          this.searchUserList = data.content;
          this.paging.totalItems = data.totalElements;
          if (showSuccess == true) {

            if (this.searchFields.fullName != '' || this.searchFields.userName != '') {
              this.toastr.success('Tìm kiếm người dùng thành công!', 'Thành công');
            }
          }
          this.sharedPreferences.setDataLocal('user_query', this.searchFields);
        },
        err => {
        }
      );
    } else {
      this.toastr.error('Nhập tên cần tìm kiếm!', 'Yêu cầu');
    }
  }
  onSearchBtClick() {
    this.searchFields.page = 1;
    this.onSearch(true, 1);
  }
  pageChangedUser($event) {
    this.searchFields.page = $event.toString();
    this.onSearch(false, $event);
  }
  viewUser() {
    this.showAdd = true;
  }
  viewGroup() {
    this.showAdd = false;
  }
  sortKey(event: any) {
    this.sortName = event.target.value;
  }
  showSortBtnUp() {
    // let nodeId = this.route.snapshot.paramMap.get('id');
    this.showSort = true;
    this.oderBy = 1;
    this.loadNodesForList(this.nodeId, null, null);
    // this.getAllData(nodeId, this.type, this.searchFields.size * (this.searchFields.page - 1) , this.searchFields.size);
  }
  showSortBtnDown() {
    // let nodeId = this.route.snapshot.paramMap.get('id');
    this.showSort = false;
    this.oderBy = 2;
    this.loadNodesForList(this.nodeId, null, null);
    // this.getAllData(nodeId, this.type, this.searchFields.size * (this.searchFields.page - 1) , this.searchFields.size);
  }
  checkAll() {
    this.listFolder.forEach((item: any) => (
      item.data.selected = true,
      this.listNodeIds.push(item.data.id)
    ));
  }
  unCheckAll() {
    this.listFolder.forEach((item: any) => (item.data.selected = false, this.listNodeIds = []));
  }
  listPermissionUpdate: any[] = new Array();
  createPermission(id: string) {
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
      this.service.addDecen(this.decen, nodeId, this.nodeType, this.typee, this.idPermission).subscribe((res: any) => {
        let id = res.data.entry.id;
        console.log(id);
        console.log(res);
        if (res.resultCode == 200) {
          this.service.addDecen(this.decen, nodeId, this.nodeType, this.typee, this.idPermission).subscribe((result: any) => {
            if (result.resultCode == 200) {
              console.log(result);
              this.toastr.success('Thêm quyền thành công!', 'Thành công');
              this.modal.close();
            } else {
              this.toastr.error('Thêm quyền thất bại!', 'Thất bại');
            }
          })
        } else if (res.resultCode == 500) {
          console.log('res.resultCode :' + res.resultCode)
        } else {
          this.toastr.error('Thêm thư mục thất bại', 'Thất bại');
        }
      })
    }
  }
  @ViewChild('fileDropRef', { static: false }) fileDropEl: ElementRef;
  filess: any[] = [];

  /**
   * on file drop handler
   */
  onFileDropped(event: any) {
    console.log(event);
    this.prepareFilesList(event);
  }

  /**
   * handle file from browsing
   */
  // fileBrowseHandler(filess) {
  //   this.prepareFilesList(filess);
  // }

  /**
   * Delete file from files list
   * @param index (File index)
   */
  // deleteFile(index: number) {
  //   if (this.filess[index].progress < 100) {
  //     console.log("Upload in progress.");
  //     return;
  //   }
  //   this.filess.splice(index, 1);
  // }

  /**
   * Simulate the upload process
   */
  uploadFilesSimulator(index: number) {
    setTimeout(() => {
      if (index === this.listFileBeforUpload.length) {
        console.log('fasle')
        this.disabledAupload = false;
        return;
      } else {
        const progressInterval = setInterval(() => {
          if (this.listFileBeforUpload[index].progress === 100) {
            clearInterval(progressInterval);
            this.disabledAupload = true;
            console.log('ok')
            this.uploadFilesSimulator(index + 1);
          } else {
            this.listFileBeforUpload[index].progress += 5;
          }
        }, 200);
      }
    }, 1000);

  }

  /**
   * Convert Files list to normal array list
   * @param filess (Files List)
   */
  prepareFilesList(filess: Array<any>) {
    for (const item of filess) {
      item.progress = 0;
      this.listFileBeforUpload.push(item);
    }
    // this.fileDropEl.nativeElement.value = "";
    this.uploadFilesSimulator(0);
  }

  /**
   * format bytes
   * @param bytes (File size in bytes)
   * @param decimals (Decimals point)
   */
  formatBytes(bytes, decimals = 2) {
    if (bytes === 0) {
      return '0 Bytes';
    }
    const k = 1024;
    const dm = decimals <= 0 ? 0 : decimals;
    const sizes = ['Bytes', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'];
    const i = Math.floor(Math.log(bytes) / Math.log(k));
    return parseFloat((bytes / Math.pow(k, i)).toFixed(dm)) + ' ' + sizes[i];
  }

  getStartNode() {
    this.bpmnService.getListStartNode(Constant.THREAD_TYPE.EXAM_FOR_OTHERS).subscribe(
      data => {
        this.listNextNode = data;
        console.log('getListStartNode :: this.listNextNode :', this.listNextNode);
        // this.checkProcessDone();
      }
    );
  }
  getNextNode(nodeId) {
    this.bpmnService.getNextNode(nodeId).subscribe(
      data => {
        this.listNextNode = data;
        console.log('this.listNextNode :', this.listNextNode);
        // this.checkProcessDone();
      }
    );
  }
  checkProcessDone() {
    const oldLength = this.listNextNode.length;
    this.listNextNode = this.listNextNode.filter(e => !e.lastNode);
    this.isshowDoneButton = this.listNextNode.length != oldLength;
    console.log('checkProcessDone', this.listNextNode, this.isshowDoneButton);
  }
  uploadFile(listFile, node){
    if (node == undefined || node == ""){
      this.createFile();
    }else{
      this.doTransferUploadFile(listFile, node);
    }
  }
  doTransferUploadFile(listFile, node) {
    console.log('doTransferUploadFile : ', listFile, node);
    let folderNode = [];
    if(node.conditions && node.conditions.length > 0) {
      node.conditions.forEach(
        condItem => {
          if(condItem.folderId != null) {
            folderNode = folderNode.concat(condItem.folderId.split(','));
          }
        }
      );
      console.log('doTransferUploadFile :: folderNode = ', folderNode);
      if(folderNode.length <= 0) {
        this.toastr.warning('Chưa cấu hình thư mục cho luồng ' + node.name + ' !', 'Thông báo');
        return;
      }
    } else {
      this.toastr.warning('Chưa cấu hình thư mục cho luồng ' + node.name + ' !', 'Thông báo');
      return;
    }
    // call api : create listFile => move listFile to folder in node's condition => save node id to listFile
    this.service.createFile(listFile, this.ticKet, this.nodeId).subscribe(
      res => {
        this.listFileBeforUpload = [];
        this.modal.close();
        for (let index = 0; index < res.data.length; index++) {
          console.log('---' + res.data[index].resultCode);
          if (res.data[index].resultCode == 500) {
            this.toastr.error('Có file chưa được cấu hình tải lên!', 'Thất bại');
          } else {
            this.service.createFileDb(res.data[index].entry.name, res.data[index].entry.properties['cm:title'], res.data[index].entry.properties['cm:desciption'], res.data[index].entry.id, this.nodeId, node.id).subscribe(response => {
              console.log(response);
              this.toastr.success('Tải File ' + res.data[index].entry.name + ' lên thành công!', 'Thành công');
              // call copy or move file
              // res.data[index].entry.fileId
              folderNode.forEach(
                (item, index, arr) => {
                  console.log(item, index, arr.length);
                  if(index < arr.length - 1) {
                    // call copy
                    this.service.copyFile(this.ticKet, response.data.fileId, item).subscribe(
                      res => {
                        this.toastr.success('Chuyển xử lý tệp ' + response.data.name + ' thành công!', 'Thành công');
                      },
                      err => {
                        this.toastr.error('Chuyển xử lý tệp ' + response.data.name + ' thất bại!', 'thất bại');
                      }
                    );
                  } else {
                    // call move
                    this.service.moveFile(this.ticKet, response.data.fileId, item).subscribe(
                      res => {
                        this.toastr.success('Chuyển xử lý tệp ' + response.data.name + ' thành công!', 'Thành công');
                      },
                      err => {
                        this.toastr.error('Chuyển xử lý tệp ' + response.data.name + ' thất bại!', 'thất bại');
                      }
                    );
                  }
                }
              );
            });

          }
        }
        this.loadNodesForList(this.nodeId, null, null);
      },
      err => {
        this.toastr.error('Tải File lên thất bại!', 'Thất bại');
      }
    );
  }
  doTransferFolderFile(listFolderFile, node) {
    console.log('doTransferFolderFile : ', listFolderFile, node);
    // call api move listFile to folder in node's condition and save node id to listFile
    let folderNode = [];
    if(node.conditions && node.conditions.length > 0) {
      node.conditions.forEach(
        condItem => {
          if(condItem.folderId != null) {
            folderNode = folderNode.concat(condItem.folderId.split(','));
          }
        }
      );
      console.log('doTransferFolderFile :: folderNode = ', folderNode);
      if(folderNode.length <= 0) {
        this.toastr.warning('Chưa cấu hình thư mục cho luồng ' + node.name + ' !', 'Thông báo');
        return;
      }
      folderNode.forEach(
        (item, index, arr) => {
          console.log(item, index, arr.length);
          if(index < arr.length - 1) {
            // call copy
            listFolderFile.forEach(
              x => {
                this.service.copyFile(this.ticKet, x.data.id, item).subscribe(
                  res => {
                    this.toastr.success(x.data.isFolder ? 'Chuyển xử lý thư mục ' + x.data.name + ' thành công!' : 'Chuyển xử lý tệp ' + x.data.name + ' thành công!', 'Thành công');
                  },
                  err => {
                    this.toastr.error(x.data.isFolder ? 'Chuyển xử lý thư mục ' + x.data.name + ' thất bại!' : 'Chuyển xử lý tệp ' + x.data.name + ' thất bại!', 'thất bại');
                  }
                );
              }
            );
          } else {
            // call move
            listFolderFile.forEach(
              x => {
                this.service.moveFile(this.ticKet, x.data.id, item).subscribe(
                  res => {
                    this.toastr.success(x.data.isFolder ? 'Chuyển xử lý thư mục ' + x.data.name + ' thành công!' : 'Chuyển xử lý tệp ' + x.data.name + ' thành công!', 'Thành công');
                    this.loadNodesForList(this.nodeId, null, null);
                  },
                  err => {
                    this.toastr.error(x.data.isFolder ? 'Chuyển xử lý thư mục ' + x.data.name + ' thất bại!' : 'Chuyển xử lý tệp ' + x.data.name + ' thất bại!', 'thất bại');
                  }
                );
              }
            );
          }
        }
      );
    } else {
      this.toastr.warning('Chưa cấu hình thư mục cho luồng ' + node.name + ' !', 'Thông báo');
    }
  }

  selectFlow(node){
    if (node.conditions!=null){
      let conditions = node.conditions;
      conditions.forEach(element => {
        if (element.allowSign == true){
          this.isSign = true;
        }
      });
    }
  }

  signPdf(fileName, signType, attachId, attachType, position, successCallback, failCallback) {
    const prms = {};
    const userInfo = JSON.parse(this.tokenService.getUserInfo());
    prms['signType'] = signType;
    prms['fileName'] = fileName;
    prms['attachId'] = attachId;
    prms['userName'] = userInfo.userName;
    prms['phoneCA'] = userInfo.phoneCA ? userInfo.phoneCA : '';
    prms['phoneProvider'] = userInfo.phoneCAProvider ? userInfo.phoneCAProvider : '';
    prms['signImage'] = userInfo.signature;
    prms['email'] = userInfo.email;
    prms['orgName'] = userInfo.orgModel.name;
    prms['signPosition'] = position;
    prms['serialToken'] = userInfo.serialToken;
    // prms['apiDownload'] = Constant.API_ENDPOINT + this.getDownloadFileUrl(attachType);
    if (fileName.indexOf('.doc') > 0) {
      prms['apiUpload'] = Constant.API_ENDPOINT + '/doc_out_attach/update-sign-file/word/';
    } else {
      prms['apiUpload'] = Constant.API_ENDPOINT + '/doc_out_attach/update-sign-file/pdf/';
    }
    prms['token'] = this.tokenService.getToken();
    console.log(prms);
    // this.showPopupWaiting('Đang xử lý. Vui lòng chờ!');
    this.signService.signPdfFile(prms, (data) => {
      console.log(data);
      this.modalRef.componentInstance.closePopup();
      if (data === '0') {
        this.commomUtils.showPopupOK(this.translateService.instant('signature.sign-successed'));
        if (fileName.indexOf('.doc') > 0) {
          this.signService.resetCallback();
          successCallback();
          return;
        }
      } else if (data == '-1') {
        this.commomUtils.showPopupOK(this.translateService.instant('signature.sign-phone-missing'));
           } else if (data == '-2') {
        this.commomUtils.showPopupOK(this.translateService.instant('signature.sign-insert-cert-error'));
           } else if (data == '-3') {
        this.commomUtils.showPopupOK(this.translateService.instant('signature.sign-wait-timeout'));
           } else if (data == '-4') {
        this.commomUtils.showPopupOK(this.translateService.instant('signature.sign-error'));
      } else if (data == '-5') {
        this.commomUtils.showPopupOK(this.translateService.instant('signature.sign-provider-error'));
           } else if (data == '-6') {
        this.commomUtils.showPopupOK(this.translateService.instant('signature.sign-error-download-attachment'));
           } else if (data == '-7') {
        this.commomUtils.showPopupOK(this.translateService.instant('signature.sign-error-download-signature'));
           } else if (data == '-8') {
        this.commomUtils.showPopupOK(this.translateService.instant('signature.sign-no-cert'));
           } else if (data == '-10') {
        this.commomUtils.showPopupOK(this.translateService.instant('signature.sign-conflict'));
      } else if (data == '-11') {
        this.commomUtils.showPopupOK(this.translateService.instant('signature.sign-error'));
      } else if (data == '-12') {
        this.commomUtils.showPopupOK(this.translateService.instant('signature.sign-wrong-token'));
      } else if (data == '-100') {
        this.commomUtils.showPopupOK(this.translateService.instant('signature.sign-no-connect'));
      } else if (data == '1006') {
        this.commomUtils.showPopupOK(this.translateService.instant('signature.sign-no-connect-vgca'));
      }
      this.signService.resetCallback();
      failCallback();
    });
  }

  signListFile(listFile){
    listFile.forEach(element => {
      this.signPdf(element.name, "UsbSign", null, null, null, null, null);
    });
  }
}

