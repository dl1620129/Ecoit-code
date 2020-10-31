import { Component, OnInit, Inject, ViewChild } from '@angular/core';
import { ProcessService } from 'src/app/services/process.service';
import { IProcess } from '../../../../core/model/domain/process';
import { NgbModal, NgbActiveModal, ModalDismissReasons, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { ToastrService } from 'ngx-toastr';
import { Organization } from 'src/app/core/model/domain/organization'
import { NgForm } from '@angular/forms';
import { DOCUMENT } from '@angular/common';
import { Constant } from '../../../../core/config/constant';
import 'rxjs/add/operator/map'
import { CommonUtils } from 'src/app/core/common/common-utils';
import { OrganizationService } from 'src/app/services/organization.service';

 enum DocumentType {
    INCOMING = "Văn bản đến",
    OUTCOMING = "Văn bản đi",
    EXAM_FOR_OTHERS = "thử nghiệm",
}

enum SearchTitles {
  NAME = 'NAME', 
  ACTIVE = 'ACTIVE',
  TYPEDOCUMENT = 'TYPEDOCUMENT',
  ORG = 'ORG'
}


@Component({
  selector: 'app-process-list',
  templateUrl: './process-list.component.html',
  styleUrls: ['./process-list.component.css']
})
export class ProcessListComponent implements OnInit {
  // processForm
  // @ViewChild('processForm',  {static: false}) ngForm: NgForm;
  processNameFocus: boolean

  urlQuery = {
    type: '',
    name: '',
    page: 1,
    sortBy: '',
    direction: Constant.SORT_TYPE.DECREASE,
    size: Constant.PAGING.SIZE,
  }

  currentModal: NgbModalRef

  rootOrg: Organization

  isOpenModal = true

  closeResult = ''

  inFilter: boolean = false

  typeDocuments = DocumentType;

  unSavedProcess: IProcess;

  _filteredProcesses: IProcess[]

  filteredConditionObject: IProcess = new IProcess()

  documentTypes = [
    // { id: "INCOMING", name: 'Văn bản đến' },
    // { id: "OUTCOMING", name: 'Văn bản đi' },
    { id: "EXAM_FOR_OTHERS", name: 'Thử nghiệm' },
  ];

  paging = {
    totalRecord: ''
  }

  searchTitles = SearchTitles
  pageSizeOptions = Constant.PAGE_SIZE_OPTION

  selectedOrg = new Organization();

  titleModal = ''


  // emptyProcessContent = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bpmn2:definitions xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:bpmn2=\"http://www.omg.org/spec/BPMN/20100524/MODEL\" xmlns:bpmndi=\"http://www.omg.org/spec/BPMN/20100524/DI\" xmlns:dc=\"http://www.omg.org/spec/DD/20100524/DC\" xmlns:di=\"http://www.omg.org/spec/DD/20100524/DI\" xmlns:ecoit=\"http://ecoit.asia/schema/1.0/bpmn\" id=\"sample-diagram\" targetNamespace=\"http://bpmn.io/schema/bpmn\" xsi:schemaLocation=\"http://www.omg.org/spec/BPMN/20100524/MODEL BPMN20.xsd\">\n  <bpmn2:process id=\"Process_1\" isExecutable=\"false\">\n    <bpmn2:startEvent id=\"Event_0i6ajdi\">\n      <bpmn2:outgoing>Flow_1t2rdbt</bpmn2:outgoing>\n    </bpmn2:startEvent>\n    <bpmn2:task id=\"Activity_1kxz7i5\">\n      <bpmn2:incoming>Flow_1t2rdbt</bpmn2:incoming>\n      <bpmn2:outgoing>Flow_0okvtyf</bpmn2:outgoing>\n    </bpmn2:task>\n    <bpmn2:sequenceFlow id=\"Flow_1t2rdbt\" sourceRef=\"Event_0i6ajdi\" targetRef=\"Activity_1kxz7i5\" />\n    <bpmn2:endEvent id=\"Event_1qnck3r\">\n      <bpmn2:incoming>Flow_0okvtyf</bpmn2:incoming>\n    </bpmn2:endEvent>\n    <bpmn2:sequenceFlow id=\"Flow_0okvtyf\" sourceRef=\"Activity_1kxz7i5\" targetRef=\"Event_1qnck3r\" />\n  </bpmn2:process>\n  <bpmndi:BPMNDiagram id=\"BPMNDiagram_1\">\n    <bpmndi:BPMNPlane id=\"BPMNPlane_1\" bpmnElement=\"Process_1\">\n      <bpmndi:BPMNEdge id=\"Flow_1t2rdbt_di\" bpmnElement=\"Flow_1t2rdbt\">\n        <di:waypoint x=\"238\" y=\"200\" />\n        <di:waypoint x=\"290\" y=\"200\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNEdge id=\"Flow_0okvtyf_di\" bpmnElement=\"Flow_0okvtyf\">\n        <di:waypoint x=\"390\" y=\"200\" />\n        <di:waypoint x=\"442\" y=\"200\" />\n      </bpmndi:BPMNEdge>\n      <bpmndi:BPMNShape id=\"Event_0i6ajdi_di\" bpmnElement=\"Event_0i6ajdi\">\n        <dc:Bounds x=\"202\" y=\"182\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Activity_1kxz7i5_di\" bpmnElement=\"Activity_1kxz7i5\">\n        <dc:Bounds x=\"290\" y=\"160\" width=\"100\" height=\"80\" />\n      </bpmndi:BPMNShape>\n      <bpmndi:BPMNShape id=\"Event_1qnck3r_di\" bpmnElement=\"Event_1qnck3r\">\n        <dc:Bounds x=\"442\" y=\"182\" width=\"36\" height=\"36\" />\n      </bpmndi:BPMNShape>\n    </bpmndi:BPMNPlane>\n  </bpmndi:BPMNDiagram>\n</bpmn2:definitions>\n"

  process: IProcess

  processes: IProcess[];

  serverSideErrors = {
    name: {
      hasError: false,
      isUnique: true,
    }
  }

  constructor(private processService: ProcessService,
    private modalService: NgbModal,
    private toastr: ToastrService,
    private activeModal: NgbActiveModal,
    private commonUtils: CommonUtils,
    private organizationService: OrganizationService,
    @Inject(DOCUMENT) document) { }

  ngOnInit() {
    this.process = new IProcess()
    // this.ngForm.form.valueChanges.subscribe(x => {
    //   console.log("aa", x);
    // })
    this.getAllProcesses();
  }

  set filteredProcesses(processes: IProcess[]) {
    this._filteredProcesses = processes
  }

  get filteredProcesses(): IProcess[]  {
    return this._filteredProcesses;
  }

  findRootOrg() {
    this.organizationService.searchRootOrganizations().subscribe({
      next: data => {
        console.log(data)
        this.rootOrg = data[0]
        this.selectedOrg = data[0]
        this.process.orgId = data[0].id
      }
    })
  }

  getAllProcesses($event = 1) {
    this.urlQuery.page = $event;
    
    this.processService.search(this.urlQuery).subscribe({
      next: data => {
        this.processes = data.content ? data.content : []
        this.urlQuery.page = data.number + 1,
        this.paging.totalRecord = data.totalElements
        // this.paging.itemsPerPage = data.size
        // this.paging.currentPage = $event
      }
    })
  }

  showNewOrEditProcessModal(content, id: number) {
    this.initDataModal(id);
    this.currentModal = this.modalService.open(content, { centered: true, size: 'lg', windowClass: 'modal-xl' })
  }

  initDataModal(id: number) {
    this.selectedOrg = new Organization();
    if (id == null) {
      this.findRootOrg()
      this.process = new IProcess();
      this.process.typeDocument = 'INCOMING'
      this.titleModal = "Thêm mới luồng";
    } else {
      this.titleModal = "Cập nhật luồng";
      this.processService.getById(id).subscribe({
      next: data => {
        this.process = data
        this.selectedOrg.name = this.process.org.name
      }
    });
    }
  }

  showLockOrUnLockProcessModal(process) {
    const message = `Bạn có chắc chắn muốn ${process.active ? 'khóa' : 'mở khóa'}?`;
    this.commonUtils.showPopupConfirm(message, () => {
      this.activeOrDeactiveProcess(process);
    });
  }

  showDeleteCategoryModal(content, categoryId) {
    this.isOpenModal = true

    this.modalService.open(content, { centered: true, size: 'sm' })
      .result.then(
        result => {
          if (result) {
            this.doDeleteProcess(categoryId);
          }
        }
      );
  }

  activeOrDeactiveProcess(process) {
    if (process.active) {
      process.active = false
      this.deactiveProcess(process);
    } else {
      process.active = true
      this.activeProcess(process);
    }
  }

  doDeleteProcess(process: IProcess) {
    // console.log("will do delete")
    this.processService.doDeleteProcess(process.id).subscribe(
      res => {
        this.toastr.success('Xóa luồng thành công!', 'Thành công');
        this.getAllProcesses();
      },
      err => {
        // this.toastr.error(err, 'Lỗi');
      }
    );
  }

  onReceiveOrg(org: Organization) {
    if (this.inFilter) {
      console.log("this.filteredConditionObject", this.filteredConditionObject)
      this.filteredConditionObject.orgId = org.id
      this.filteredConditionObject.org = org
      this.inFilter = false
    } 
    else {
      this.process.orgId = org.id
      this.selectedOrg.name = org.name
    }  
  }

  activeProcess(process) {
    this.processService.activeProcess(process).subscribe(
      res => {
        this.toastr.success('Mở khóa luồng thành công!', 'Thành công');
        this.getAllProcesses();
      },
      err => {
        // this.toastr.error(err, 'Lỗi');
        console.log(err);
      }
    );
  }

  deactiveProcess(process) {
    this.processService.deactiveProcess(process).subscribe(
      res => {
        this.toastr.success('Khóa luồng thành công!', 'Thành công');
        this.getAllProcesses();
      },
      err => {
        // this.toastr.error(err, 'Lỗi');
        console.log(err);
      }
    );
  }

  doSaveProcess(process, id) {
    console.log("created process", this.process)
    console.log(this.process)
    this.processService.doSaveProcess(process, id).subscribe(
      res => {
        this.serverSideErrors.name.hasError = false
        this.serverSideErrors.name.isUnique = true
        this.process = new IProcess()
        this.selectedOrg = new Organization();
        this.getAllProcesses();
        this.currentModal.close()
        this.toastr.success('Cập nhật luồng thành công!', 'Thành công');
      },
      err => {
        console.log(err);
        this.serverSideErrors.name.hasError = true
        this.serverSideErrors.name.isUnique = false
      }
    );
  }

  doSaveNewProcess(process) {
    this.process.org = null
    this.processService.doSaveNewProcess(process).subscribe(
      res => {
        this.serverSideErrors.name.hasError = false
        this.serverSideErrors.name.isUnique = true
        console.log("serverSideErrors", this.serverSideErrors)
        this.selectedOrg = new Organization();
        this.process = new IProcess()
        this.getAllProcesses();
        this.currentModal.close()
        this.toastr.success('Thêm mới luồng thành công!', 'Thành công');
      },
      err => {
        this.serverSideErrors.name.hasError = true
        this.serverSideErrors.name.isUnique = false
        console.log('err1', err);
      }
    );
  }

  openOrganizationTree(content, isFilter: boolean) {
    if (isFilter) {
      this.inFilter = true
    }
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title', size: 'lg'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    });
  }

  saveProcess(processForm: NgForm) {
    console.log(this.process) 
    if (this.process.id > 0) {
      this.doSaveProcess(this.process, this.process.id);
    } else {
      this.doSaveNewProcess(this.process);
    }
  }

  processNameChange() {
    this.serverSideErrors.name.isUnique = true
    this.serverSideErrors.name.hasError = false
  }

  sortByField(fieldName: string) {
    this.toggleSortType()
    this.urlQuery.sortBy = fieldName;
    this.getAllProcesses();
    if (fieldName) {
      this.urlQuery.sortBy = fieldName
    }
  }

  toggleSortType() {
    if (Constant.SORT_TYPE.DECREASE == this.urlQuery.direction) {
      this.urlQuery.direction = Constant.SORT_TYPE.INCREASE
    }
    else {
      this.urlQuery.direction = Constant.SORT_TYPE.DECREASE
    }
  }

  changePageSize($event) {
    this.urlQuery.size = $event
    this.urlQuery.page = 1
    this.getAllProcesses(1)
  }
}
