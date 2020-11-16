import { Component, ViewChild, ElementRef, AfterViewInit, OnInit, Input } from '@angular/core';
import { DatePipe } from '@angular/common';
import { DocumentService } from '../../../services/document.service';
import { Router, ActivatedRoute, NavigationExtras } from '@angular/router';
import { Observable, Observer } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { TokenService } from 'src/app/core/authen/token.service';
import * as FileSaver from 'file-saver';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Folder } from 'src/app/core/model/doucment/folder';
import { ToastrService } from 'ngx-toastr';
import { Constant } from 'src/app/core/config/constant';
import { TreeNode } from 'primeng/api';
import * as moment from 'moment';
import { BpmnService } from 'src/app/services/bpmn.service';


@Component({
  selector: 'app-document-list-file',
  templateUrl: './document-view-file.component.html',
  styleUrls: ['./document-view-file.component.css']

})
export class DocumentViewFile implements OnInit {
  @ViewChild('pdfViewerOnDemand', {static: false}) pdfViewerOnDemand;
  @ViewChild('canvasEl', { static: true }) canvasEl: ElementRef;
  @Input() public fileName;
  @Input() public type = "";
  private context: CanvasRenderingContext2D;
  constructor(
    private toastr: ToastrService,
    private modalService: NgbModal,
    private service: DocumentService,
    private datepipe: DatePipe,
    private router: Router,
    private routers: ActivatedRoute,
    private tokenService: TokenService,
    private route: ActivatedRoute,
    private bpmnService: BpmnService,
  ) {
  }
   isCollapsed = true;
   isCollapsed1 = true;
   isCollapsed2 = true;
   isCollapsed3 = true;
   isCollapsed4 = true;
   folder = new Folder();
  ticKet = '';
  url= "";
  size : number;
  document: string;
  list: any[];
  abc: string;
  date: string;
  date_create :string;
  name: any;
  text: any;
  id: any;
  item:any;
  viewImg ="";
  viewFile: any[];
  textview :any;
  comment = true;
  link:string;
  modal : any;
  addcommment : string;
  addcommment1;
  properties;
  properties_name;

  searchFields = {
    fullName: '',
    userName: '',
    page: 1,
    sortBy: '',
    direction: Constant.SORT_TYPE.DECREASE,
    size: Constant.PAGING.SIZE,
  };
  loading: boolean;
  oderBy = 1;
  sortName = 'name';
  paging = {
    itemsPerPage: Constant.ITEMS_PER_PAGE,
    currentPage: 1,
    totalRecord: -1,
    totalItems: -1,
  };
  nodeId = '';
  listFolder: any[];
  files: TreeNode[];
  selectedNode: TreeNode;

  isshowDoneButton;
  listNextNode;
  ngOnInit() {

    this.routers.paramMap.subscribe(params => {
      this.id = params.get('id');
      console.log(name)
      console.log(this.id)
    })
    this.ticKet = this.tokenService.getTickets();
    if(this.id != null && this.id != undefined){
      this.getId(this.id, this.tokenService.getTickets());
      
      this.getview(this.id, this.tokenService.getTickets());
      this.viewimgage(this.id, this.tokenService.getTickets());
      this.nodeId = '';
      
      this.loadNodesForTree(this.nodeId);
      this.searchFields.page = 1;  
      
    }
  
    this.link=window.location.href;
    this.getAllComment();
    this.getproperties();
  }


mimetype;
modifiedByUser;
  getId(id: String, ticKet: string) {
    this.service.getIdFile(ticKet, id).subscribe((res: any) => {
      this.item = res.data.entry;
      this.mimetype=res.data.entry.content.mimeType;
      this.modifiedByUser=res.data.entry.modifiedByUser.displayName;
      console.log('item', this.item)
      if (res.data.entry.content.mimeType == "application/pdf") {
        this.viewpdf(this.tokenService.getTickets(), this.id);
      }
      else {
        console.log('âcsdasdasd')
        this.View(this.id, this.ticKet);
        console.log('ticke', this.ticKet)
      }
      this.date = this.datepipe.transform(res.data.entry.modifiedAt, 'dd-MM-yyyy');
      this.date_create = this.datepipe.transform(res.data.entry.createdAt, 'dd-MM-yyyy');
      this.size=((res.data.entry.content.sizeInBytes)/1000);
      console.log('size',this.size)
      if (!this.item.nodeId) {
        this.listNextNode = null;
        this.getStartNode();
      } else {
        this.listNextNode = null;
        this.getNextNode(this.item.nodeId);
      }
    })
  }
  dataURItoBlob(dataURI: string): Observable<Blob> {
    return Observable.create((observer: Observer<Blob>) => {
      const byteString: string = window.atob(dataURI);
      const arrayBuffer: ArrayBuffer = new ArrayBuffer(byteString.length);
      const int8Array: Uint8Array = new Uint8Array(arrayBuffer);
      for (let i = 0; i < byteString.length; i++) {
        int8Array[i] = byteString.charCodeAt(i);
      }
      const blob = new Blob([int8Array], { type: "image/jpeg" });
      observer.next(blob);
      observer.complete();
    });
  }
  generateName(): any {
    const date: number = new Date().valueOf();
    let text: string = "";
    const possibleText: string =
      "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    for (let i = 0; i < 5; i++) {
      text += possibleText.charAt(
        Math.floor(Math.random() * possibleText.length)
      );
    }
  }
  View(id: String, ticKet: string) {
    this.service.generatePreview(this.ticKet, this.id,'application/pdf').subscribe(data => {
    });
    console.log('dddddddddd')
    this.service.previewDocument(ticKet, id, 'pdf').subscribe(data => {
      console.log('tùng ăn cứt')
      console.log( data)
      this.pdfViewerOnDemand.pdfSrc = new Blob([data], { type: 'application/octet-stream' });
      console.log('-------------------------------------')
      this.pdfViewerOnDemand.refresh();
    });
  }
  viewimgage(id: String, ticKet: string) {
    this.service.generatePreview(this.ticKet, this.id,'image/png').subscribe(data => {
    });
    this.service.previewDocument(ticKet, id, "imgpreview").pipe(switchMap(blob => this.convertBlobToBase64(blob))).subscribe(base64ImageUrl =>
      console.log(base64ImageUrl))
  }
  viewpdf(ticKet: string, id: String) {
    this.service.img(ticKet, id).subscribe(data => {
      console.log('data',data)
      this.pdfViewerOnDemand.pdfSrc = data;
      this.pdfViewerOnDemand.refresh();
      console.log('data1',     this.pdfViewerOnDemand.refresh())
      console.log('1', this.pdfViewerOnDemand)
    });
  }

  convertBlobToBase64(blob: Blob) {
    return Observable.create(observer => {
      const reader = new FileReader();
      const binaryString = reader.readAsDataURL(blob);
      reader.onload = (event: any) => {
        // console.log('Image in Base64: ', event.target.result);
        this.viewImg=event.target.result;
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
  

  getview(id: String, ticKet: string) {
    this.service.getview(ticKet, id).subscribe((res: any) => {
      this.textview=res;
  
    
    })
  }
  Comment() {
    this.comment = false;
  }
  thoat() {
    this.comment = true;
  }
  exit(){
    this.router.navigate(['folder']);
  }

 
  downLoadFolder() {

    this.service.asZip(this.ticKet, this.id).subscribe((result: any) => {
      let downloadId: string;
      downloadId = result.data.entry.id;
      console.log(result.data.entry.status);
      if (result.data.entry.status == 'PENDING') {
        this.getAsZipFolder(this.ticKet, downloadId, this.item.name, this.item.nodeType);
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
            FileSaver.saveAs(response, name + '.zip');
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
  open(content) {
    if (this.id != undefined || this.id != null) {
      this.service.getFolder(this.ticKet, this.id).subscribe((res: any) => {
        this.folder.name = res.data.entry.name;
      })
    }
  
    this.modal = this.modalService.open(content, {centered: true, windowClass: 'no-box-shadow' });
  }
  AllComment: string;
  length_comment: string;
  getAllComment() {
    this.service.getAllComment(this.ticKet, this.id, 0, 100).subscribe((res: any) => {
      this.AllComment = res.data.list.entries;
      this.length_comment= res.data.list.entries.length;
      console.log("comemt", this.AllComment)
    })
  }
  deleteComment(deletid :string) {

    this.service.deleteComment(this.ticKet, this.id,deletid).subscribe(res => {
      this.toastr.success('Xóa bình luận thành công!', 'Thành công');
      this.getAllComment();
    })
  }
  createcomment(comment : string){
    console.log('comement',comment)
    this.service.creatComment(this.ticKet, this.id,comment).subscribe(res => {
      this.getAllComment();
      
    })
  }
  timecreat;
  name_pro;
  title_pro;
  description_pro;
  author_pro;
  creator_pro;
  created_pro;
  modifier_pro;
  modified_pro;
  getproperties() {
    console
    this.service.getProperties(this.ticKet, this.id).subscribe((res: any) => {
      this.properties = res.data.item;
      this.properties_name = '';
      console.log('properties', this.properties);
      this.timecreat = moment(this.properties.node.properties['cm:created'].iso8601, "YYYY-MM-DD HH:mm:ss").locale('vi').fromNow();
      console.log('time', this.timecreat);
      this.name_pro = this.properties.node.properties['cm:name'];
      this.title_pro = this.properties.node.properties['cm:title'];
      this.description_pro = this.properties.node.properties['cm:description'];
      this.author_pro = this.properties.node.properties['cm:author'];
      this.creator_pro=this.properties.node.properties['cm:creator'].displayName;
      this.created_pro=this.properties.node.properties['cm:created'].value;
      this.modifier_pro= this.properties.node.properties['cm:modifier'].displayName;
      this.modified_pro=this.properties.node.properties['cm:modified'].value;
    })
  }

  listNodeIdSingle: any[] = new Array();
  deleteSingleNode() {
    this.service.deleteFolder(this.ticKet, this.id).subscribe(data => {
      this.toastr.success('Xóa mục thành công!', 'Thành công');
      this.router.navigate(['folder']);
    });
  }
  


  // tree

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
        this.listFolder.forEach(element => {
          if (element.data.isFile) {
            this.service.previewDocument(this.ticKet, element.data.id, "doclib").pipe(switchMap(blob =>
              this.convertBlobToBase64(blob))).subscribe(
                base64ImageUrl => element.thumbnail = base64ImageUrl
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
  onListSelect(event: TreeNode, isSelected) {
    console.log('onListSelect : ', event, this.selectedNode);
    this.selectedNode = event;
    this.nodeId = event.data.id;
    this.loading = true;
    const nodeId = event.data.id;
    this.service.getAllFolder(this.ticKet, nodeId, 3, this.oderBy, this.sortName, this.searchFields.size*(this.searchFields.page-1), this.searchFields.size).subscribe((res: any) => {
      const folderList = res.data.list.entries;
      this.paging.totalItems = res.data.list.pagination.totalItems;
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
          console.log('Lazy tree :: onNodeExpand this.listFolde = ', this.listFolder, event);
        }
        this.files = [...this.files];
      }, 250);
    });
    console.log('Lazy tree :: onNodeExpand event = ', event, this.files);
  }
  idcopy:string;
  selectcopy(id : string){
    this.idcopy=id;
  }
  copyFile( ){
    this.service.copyFile(this.ticKet, this.id,this.idcopy).subscribe(res => {
      this.toastr.success('Copy thành công!', 'Thành công');
      this.modal.close();
    })
  }
  moveFile( ){
    this.service.moveFile(this.ticKet, this.id,this.idcopy).subscribe(res => {
      this.toastr.success('Chuyển thành công!', 'Thành công');
      this.modal.close();
    })
  }
  listFileBeforUpload: any[] = new Array();
  uploadFile : any[] = new Array();
  nameupload;
  viewFileUpload(event: any) {
    this.listFileBeforUpload.push(event.target.files);
    console.log(this.listFileBeforUpload);
    this.uploadFile=this.listFileBeforUpload[0];
 
  }
  tai( ){
    console.log("workspace://SpacesStore/"+this.id);
    this.service.uploadFile(this.uploadFile, this.ticKet,this.uploadFile[0].name,"workspace://SpacesStore/"+this.id,"false","true","true").subscribe(res => {  
      console.log("workspace://SpacesStore/"+this.id);
      console.log("sdasdas",this.listFileBeforUpload)
      this.getproperties();
      this.modal.close();
    })
  }
  editproperties(name : string,title: string,description : string,author :string){
    console.log('name',name);
    console.log('title',title)
    this.service.editproperties(this.ticKet, this.id,name,title,description,author).subscribe(res => {  
      this.toastr.success('Thay đổi thành công!', 'Thành công');
      this.getproperties();
      this.modal.close();
    })
  }
  getStartNode() {
    this.bpmnService.getListStartNode(Constant.THREAD_TYPE.EXAM_FOR_OTHERS).subscribe(
      data => {
        this.listNextNode = data;
        console.log('getListStartNode :: this.listNextNode :', this.listNextNode);
        this.checkProcessDone();
      }
    );
  }
  getNextNode(nodeId) {
    this.bpmnService.getNextNode(nodeId).subscribe(
      data => {
        this.listNextNode = data;
        console.log('this.listNextNode :', this.listNextNode);
        this.checkProcessDone();
      }
    );
  }
  checkProcessDone() {
    const oldLength = this.listNextNode.length;
    this.listNextNode = this.listNextNode.filter(e => !e.lastNode );
    this.isshowDoneButton = this.listNextNode.length != oldLength;
    console.log('checkProcessDone', this.listNextNode, this.isshowDoneButton);
  }
  doTransferFolderFile(node) {
    console.log('doTransferFolderFile : ', this.id, node);
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
            this.service.copyFile(this.ticKet, this.id, item).subscribe(
              res => {
                this.toastr.success('Chuyển xử lý tệp thành công!', 'Thành công');
              },
              err => {
                this.toastr.error('Chuyển xử lý tệp thất bại!', 'thất bại');
              }
            );
          } else {
            // call move
            this.service.moveFile(this.ticKet, this.id, item).subscribe(
              res => {
                this.toastr.success('Chuyển xử lý tệp thành công!', 'Thành công');
                this.exit();
              },
              err => {
                this.toastr.error('Chuyển xử lý tệp thất bại!', 'thất bại');
              }
            );
          }
        }
      );
    } else {
      this.toastr.warning('Chưa cấu hình thư mục cho luồng ' + node.name + ' !', 'Thông báo');
    }
  }
}
