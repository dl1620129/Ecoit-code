import {
  Inject,
  AfterContentInit,
  Component,
  ElementRef,
  Input,
  OnChanges,
  OnDestroy,
  Output,
  ViewChild,
  SimpleChanges,
  EventEmitter
} from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { DOCUMENT } from '@angular/common';
import { catchError } from 'rxjs/operators';
import { ToastrService } from 'ngx-toastr';
import { is } from 'bpmn-js/lib/util/ModelUtil';

// declare var $: any;
import * as bootstrap from "bootstrap";

/**
 * You may include a different variant of BpmnJS:
 *
 * bpmn-viewer  - displays BPMN diagrams without the ability
 *                to navigate them
 * bpmn-modeler - bootstraps a full-fledged BPMN editor
 */
import * as BpmnJS from 'bpmn-js/dist/bpmn-modeler.production.min.js';
import BpmnModdle from 'bpmn-moddle';

import BpmnModeler from 'bpmn-js/lib/Modeler';

import { importDiagram } from './rx';

import { throwError } from 'rxjs';
import { ProcessService } from 'src/app/services/process.service';
import BpmnPalletteModule from 'bpmn-js/lib/features/palette';
import { Router, ActivatedRoute } from '@angular/router';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';

import { UserOrOrganization } from 'src/app/core/model/domain/user-or-organization'
import { IProcess } from 'src/app/core/model/domain/process';
import { remove } from '@syncfusion/ej2-base';


enum RemovedPallete {
  'create.intermediate-event',
  'create.subprocess-expanded',
  'create.data-object',
  'create.data-store',
  'create.participant-expanded',
  'create.group',
  'lasso-tool',
  'hand-tool',
  'space-tool'

}

enum RenamedPallete {
  'create.exclusive-gateway' = 'Điều kiện',
  'create.start-event' = 'Khởi tạo',
  'create.end-event' = 'Kết thúc',
  'global-connect-tool' = 'Đường Nối',
  'create.task' = 'Tạo node'
}

@Component({
  selector: 'app-diagram',
  templateUrl: './diagram.component.html',
  styleUrls: ['./diagram.component.css']
})
export class DiagramComponent implements AfterContentInit, OnChanges, OnDestroy {
  private bpmnJS: BpmnJS;
  diagramModeler: BpmnModeler;
  closeResult = '';
  selectedUsers = [];
  selectedOrgs = [];
  // selectedUserAndOrg: UserOrOrganization[];
  selectedUsersandOrgs = []

  hasNew = false;

  id: number;
  oganizationName: number;
  positionName: string;
  fullName: string;
  positionId: number;
  organizationId: number;
  userId: number;
  nodeName: string

  isOpenChoosedUsers = false

  @ViewChild('ref', { static: true }) private el: ElementRef;
  @Output() private importDone: EventEmitter<any> = new EventEmitter();

  @Input() private url: string;

  process: IProcess

  //TODO:=========================
  eventBus;
  taskList = [];

  selectedTaskName = ''
  selectedTaskId = ''

  constructor(private modalService: NgbModal,
              private http: HttpClient,
              private processService: ProcessService,
              private route: ActivatedRoute,
              private router: Router,
              private toastr: ToastrService,
              @Inject(DOCUMENT) document) {

    let id = +this.route.snapshot.paramMap.get('processId');
    this.getById(id);

    // this.selectedUserAndOrg = this.choosedList[0]["conditions"]

    this.bpmnJS = new BpmnJS({
      bpmnRenderer: {
        defaultFillColor: '#007ad9',
        defaultStrokeColor: '#333',
      }
    });
    const _self = this;

    this.bpmnJS.on('import.done', ({ error }) => {
      if (!error) {
        this.bpmnJS.get('canvas').zoom('fit-viewport');
        //TODO:=================
        this.eventBus = this.bpmnJS.get('eventBus');
        _self.onClickTask();
      }
    });

    // var _getPaletteEntries = BpmnPalletteModule.prototype.getPaletteEntries;
    // BpmnPalletteModule.prototype.getPaletteEntries = function(element) {
    //    var entries = _getPaletteEntries.apply(this);
    //    delete entries['create.task'];
    //    delete entries['create.data-store'];
    //      return entries;
    // }
  }

  // changePatteleLabels() {

  // }

  onOpened(opened: boolean) {
    this.isOpenChoosedUsers = opened
  }
  // TODO: WORKING===========
  // TODO: WORKING===========
  onClickTask() {
    const _self = this;
    // you may hook into any of the following events
    let events1 = [
      'element.dblclick',
    ];

    this.eventBus.on('elements.changed', function(event) {
      console.log('dragging end');
      console.log(event)
        _self.bpmnJS.saveXML({ format: true }, function (err, xml) {
          if(_self.process.content != xml) {
              _self.process.content = xml

            _self.updateWithoutReload(_self.process)
            _self.hasNew = false
          }
        });
      _self.hasNew = true
    });

    events1.forEach(function(event) {
      _self.eventBus.on(event, function(e) {
        if (e.element) {
          if (is(e.element, 'bpmn:Task') || is(e.element, 'bpmn:StartEvent') || is(e.element, 'bpmn:EndEvent')) {
            let taskId = e.element.id
            // console.log(taskId)
            console.log(e.element.businessObject)
            _self.selectedTaskId = e.element.id
            _self.nodeName = e.element.businessObject.name
            _self.selectedTaskName = e.element.businessObject.name
            // e.element.businessObject.name = "1"
            console.log("processa",_self.process)

            _self.isOpenChoosedUsers = true;

            let taskElement = e.element;
          }
        }
      });
    });
  }

  closeConfigPosition() {
    this.isOpenChoosedUsers = false
    console.log("close")
    console.log(this.isOpenChoosedUsers)
  }

  exportDiagram() {
    this.bpmnJS.saveXML({ format: true }, function (err, xml) {
        console.log(xml);
    });
  }

  ngAfterContentInit(): void {
    this.bpmnJS.attachTo(this.el.nativeElement);
  }

  ngOnChanges(changes: SimpleChanges) {
    // re-import whenever the url changes
    if (changes.url) {
      console.log('URL: ', this.url)
      // this.loadUrl(changes.url.currentValue);
    }
  }

  ngOnDestroy(): void {
    this.bpmnJS.destroy();
  }

  open(content) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title', size: 'lg'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    });
  }

  getById(id) {
    return (
      this.processService.getById(id).subscribe({
      next: data => {
        console.log("next", data)
        this.process = data
        this.importXml(data.content)
      },
      error: err => console.log("error")
    })
    );
  }

  getByIdAndImportNewName(id) {
    return (
      this.processService.getById(id).subscribe({
      next: data => {
        console.log("next", data)
        this.process = data
        this.importXml(data.content)
      },
      error: err => console.log("error")
    })
    );
  }

  getByIdWithoutImportXml(id) {
    return (
      this.processService.getById(id).subscribe({
      next: data => {
        console.log("next", data)
        this.process = data
      },
      error: err => console.log("error")
    })
    );
  }

  importXml(xml) {
    const _self = this;
    this.bpmnJS.importXML(xml, function(err, warnings) {

      // _self.bpmnJS.invoke(function(elementRegistry, modeling) {

      //   // once user updates id in input field
      //   var newName = 'SERVICE_TASK__1';

      //   var serviceTaskShape = elementRegistry.get('Activity_1u0a7sf');

      //   modeling.updateProperties(serviceTaskShape, {
      //     name: newName
      //   });
      // });

      _self.removeUnusedPalleteElements()
      _self.renameTitlePalleteElements();
      _self.cssPallete()

      if (err) {
        console.log("error when import")
      } else {
        // observer.next(warnings);
      }

      // observer.complete();
    });
  }

  importXmlWithNewName(xml, name: string) {
    const _self = this;
  }

  cssPallete() {
    if (document.getElementsByClassName("two-column")[0]) {
      document.getElementsByClassName("two-column")[0].classList.replace("two-column", "one-column")
    }
    if (document.getElementsByClassName("djs-palette")) {
      let djsPalette = document.getElementsByClassName("djs-palette")[0] as HTMLElement
      djsPalette.style.left = "auto"
      djsPalette.style.right = "20px"
    }

    // document.getElementsByClassName("djs-palette")[0].style.right="20px"

    // let items = document.getElementsByClassName("bpmn-icon-intermediate-event-none");

    // if (items) {
    //   for (let i = 0; i < items.length; i ++) {
    //     items[i].classList.remove("entry", "hide")
    //   }
    // }

    // for(let item of items) {
    //   item.style.display = "none"
    // }

  }

  removeUnusedPalleteElements() {
    for (const item in RemovedPallete) {
      if (item) {
        let removedPalleteElement = document.querySelector("[data-action=" + CSS.escape(RemovedPallete[item]) + "]") as HTMLElement;
        if(removedPalleteElement) {
          removedPalleteElement.style.display = 'none'
        }
      }
    }
  }

  renameTitlePalleteElements() {
    for (const item in RenamedPallete) {
      if (item) {
        let renamedPalleteElement = document.querySelector("[data-action=" + CSS.escape(item) + "]") as HTMLElement;
        if (renamedPalleteElement) {
          renamedPalleteElement.title = RenamedPallete[item]
        }
      }
    }
  }

  /**
   * Load diagram from URL and emit completion event
   */
  // loadUrl(url: string) {
  //   let id = +this.route.snapshot.paramMap.get('processId');
  //   return (
  //     this.processService.getById(id).pipe(
  //       catchError(err => throwError(err)),
  //       importDiagram(this.bpmnJS)
  //     ).subscribe(
  //       (warnings) => {
  //         this.importDone.emit({
  //           type: 'success',
  //           warnings
  //         });
  //       },
  //       (err) => {
  //         this.importDone.emit({
  //           type: 'error',
  //           error: err
  //         });
  //       }
  //     )
  //   );
  // }

  private findSelectedUserAndOrgByTaskId(taskId, taskList){
    if (taskList) {
      for (var i=0; i < taskList.length; i++) {
          if (taskList[i].ident === taskId) {
              return taskList[i].conditions;
          }
      }
    }
  }

  receiveSelectedUsersandOrgs(selectedUsersAndOrgs) {
    this.selectedUsersandOrgs = selectedUsersAndOrgs
  }

  updateWithoutReload(process: IProcess) {
    this.processService.doSaveProcess(process, process.id).subscribe(
      res => {
        this.isOpenChoosedUsers = false
        this.toastr.success('Cập nhật luồng thành công!', 'Thành công');
        this.getByIdWithoutImportXml(process.id)
      },
      err => {
        console.log(err);
        this.getById(process.id)
        this.toastr.error(err, 'Lỗi');
      }
    );
  }

  onUpdateProcess(process: IProcess) {
    this.process = process

    const _self = this
    let nodes = this.process.nodes;
    let newNodeName;
    for (var i = 0; i < nodes.length; i++) {
      if (nodes[i].ident == this.selectedTaskId) {
        newNodeName = this.process.nodes[i].name
        break;
      }
    }
    this.bpmnJS.importXML(process.content, function() {

      _self.bpmnJS.invoke(function(elementRegistry, modeling) {

        var serviceTaskShape = elementRegistry.get(_self.selectedTaskId);

        modeling.updateProperties(serviceTaskShape, {
          name: newNodeName
        });
      })
    });
    console.log("process content",  this.process.content)
    // this.processService.doSaveProcess(this.process, this.process.id).subscribe(
    //   res => {
    //     this.toastr.success('Cập nhật luồng thành công!', 'Thành công');
    //     this.isOpenChoosedUsers = false
    //     // this.getByIdWithoutImportXml(process.id)
    //   },
    //   err => {
    //     console.log(err);
    //     this.toastr.error('Cập nhật luồng không thành công!', 'Lỗi');
    //   }
    // );
  }
}
