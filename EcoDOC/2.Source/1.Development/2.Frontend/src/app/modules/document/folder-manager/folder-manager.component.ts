import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TreeNode } from 'primeng/api';
import { TokenService } from 'src/app/core/authen/token.service';
import { Constant } from 'src/app/core/config/constant';
import { DocumentService } from 'src/app/services/document.service';
import * as FileSaver from 'file-saver';
import { Folder } from 'src/app/core/model/doucment/folder';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-folder-manager',
  templateUrl: './folder-manager.component.html',
  styleUrls: ['./folder-manager.component.css']
})
export class FolderManagerComponent implements OnInit {
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
  historyNodeId: any[] = new Array();
  historyNum = 0;
  disableRemoveBtn = true;
  listNodeIds: any[] = new Array();
  ticKet = '';
  oderBy = 1;
  sortName = 'name';
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
  paging = {
    itemsPerPage: Constant.ITEMS_PER_PAGE,
    currentPage: 1,
    totalRecord: -1,
    totalItems: -1,
  };
  // tho added
  listFolder: any[];
  loading: boolean;
  files: TreeNode[];
  totalRecords: number;
  selectedNode: TreeNode;
  constructor(
    private service: DocumentService,
    private tokenService: TokenService,
    private route: ActivatedRoute,
    private router: Router,
    private modalService: NgbModal,
    private toastr: ToastrService,
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
  }
  loadNodesForTree(nodeId) {
    this.loading = true;
    this.service.getAllFolder(this.ticKet, nodeId, 1, this.oderBy, this.sortName, 0, 100).subscribe((res: any) => {
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
      this.loadNodesForList(nodeId, null, null);
    });
  }
  loadNodesForList(nodeId, page, size) {
    this.searchFields.size = size != null ? size : this.searchFields.size;
    this.searchFields.page = page != null ? page : 1;
    this.loading = true;
    this.service.getAllFolder(this.ticKet, nodeId, 3, this.oderBy, this.sortName, this.searchFields.size*(this.searchFields.page-1), this.searchFields.size).subscribe((res: any) => {
      const folderList = res.data.list.entries;
      this.paging.totalItems = res.data.list.pagination.totalItems;
      console.log('this.listFolder : ', folderList);
      setTimeout(() => {
        this.loading = false;
        this.listFolder = [];

        for(let i = 0; i < folderList.length; i++) {
          console.log('this.listFolder[i].entry.isFolder : ', folderList[i].entry.isFolder);
            let node = {
                data: folderList[i].entry,
                leaf: folderList[i].entry.isFolder ? false : true,
            };
            this.listFolder.push(node);
        }
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
        for(let i = 0; i < folderList.length; i++) {
          console.log('this.listFolder[i].entry.isFolder : ', folderList[i].entry.isFolder);
            const nodechild = {
                data: folderList[i].entry,
                leaf: folderList[i].entry.isFolder ? false : true,
            };

            node.children.push(nodechild);
        }
        if(isSelected) {
          this.loadNodesForList(this.nodeId, null, null);
          event.node.expanded = true;
        }
        this.files = [...this.files];
      }, 250);
    });
    console.log('Lazy tree :: onNodeExpand event = ', event, this.files);
  }
  nodeSelect(event) {
    if(!event.node.expanded) {
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
      this.service.getAllFolder(this.ticKet, nodeId, 3, this.oderBy, this.sortName, this.searchFields.size*(this.searchFields.page-1)+1, this.searchFields.size).subscribe((res: any) => {
        this.listFolder = res.data.list.entries;
      })
    })
  }
  hienthi(id: number) {
    this.router.navigate(['fileview', id])
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
  deleteSingleNode(id: string) {
    let nodeId = this.route.snapshot.paramMap.get('id');
    this.listNodeIdSingle.push(id);
    this.service.deleteFolder(this.ticKet, this.listNodeIdSingle).subscribe(data => {
      this.toastr.success('Xóa mục thành công!', 'Thành công');
      this.listNodeIdSingle = [];
      this.modal.close();
      // this.getAllData(nodeId, this.type, this.searchFields.size*(this.searchFields.page-1)+1, this.searchFields.size);
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
    this.selectedNode = event;
    this.loading = true;
    const nodeId = event.data.id;
    this.service.getAllFolder(this.ticKet, nodeId, 3, this.oderBy, this.sortName, this.searchFields.size*(this.searchFields.page-1)+1, this.searchFields.size).subscribe((res: any) => {
      const folderList = res.data.list.entries;
      console.log('this.listFolder : ', folderList);
      setTimeout(() => {
        this.loading = false;
        const node = event;
        node.children = [];
        for(let i = 0; i < folderList.length; i++) {
          console.log('this.listFolder[i].entry.isFolder : ', folderList[i].entry.isFolder);
            const nodechild = {
                data: folderList[i].entry,
                leaf: folderList[i].entry.isFolder ? false : true,
            };

            node.children.push(nodechild);
        }
        if(isSelected) {
          this.listFolder = node.children;
          event.expanded = true;
          console.log('Lazy tree :: onNodeExpand this.listFolde = ', this.listFolder);
        }
        this.files = [...this.files];
      }, 250);
    });
    console.log('Lazy tree :: onNodeExpand event = ', event, this.files);
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
        this.modal.close();
        // this.getAllData(nodeId, this.type, this.searchFields.size * (this.searchFields.page - 1) , this.searchFields.size);
        this.listFileBeforUpload = [];
        console.log(data.data);
        for (let index = 0; index < data.data.length; index++) {
          console.log('---' + data.data[index].resultCode);
          if (data.data[index].resultCode != undefined && data.data[index].resultCode != 500) {
            this.service.createFileDb(data.data[index].entry.name, data.data[index].entry.properties['cm:title'], data.data[index].entry.properties['cm:description'], data.data[index].entry.id, nodeId, luongId).subscribe(response => {
              console.log(response);
              this.toastr.success('Tải File '+data.data[index].entry.name+' lên thành công!', 'Thành công');
            });
          }else{
            this.toastr.error( 'Có file chưa được cấu hình tải lên!', 'Thất bại');
          }
        
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
  createFolderAlfresco(id: string) {
    let nodeId = this.selectedNode ? this.selectedNode.data.id : '';
    if (nodeId == null) nodeId = '';
    if (id != null || id != undefined) {
      this.service.updateFolder(this.folder, this.ticKet, id).subscribe((data: any) => {
        if (data.resultCode == 200) {
          if (data.data.entry.nodeType == 'cm:folder') {
            this.service.updateFolderDb(this.folder, id, nodeId).subscribe();
          } else {
            this.service.updateFileDb(this.folder, id, nodeId).subscribe();
          }
          this.toastr.success('Cập nhật thành công!', 'Thành công');
          this.modal.close();
          // this.getAllData(nodeId, this.type, this.searchFields.size * (this.searchFields.page - 1) , this.searchFields.size);
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
              // this.getAllData(nodeId, this.type, this.searchFields.size * (this.searchFields.page - 1) , this.searchFields.size);
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
  removeNode() {
    this.service.deleteFolder(this.ticKet, this.listNodeIds).subscribe(data => {
      this.toastr.success('Xóa mục thành công!', 'Thành công');
      this.listNodeIds = [];
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
}

