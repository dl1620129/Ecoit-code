import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { TranslateService } from '@ngx-translate/core';
import { Constant } from 'src/app/core/config/constant';
import { ModuleAdminService } from "../../../services/moduleadmin.service";
import { ModuleAdmin, ModuleAdminSearch} from 'src/app/core/model/domain/model-admin';
import {SharedPreferences} from "../../../core/config/shared-preferences";
import { HttpParams } from '@angular/common/http';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { TokenService } from 'src/app/core/authen/token.service';
import { ToastrService } from 'ngx-toastr';
import { InputError } from 'src/app/core/model/domain/error/input-error';
import { CommonUtils } from 'src/app/core/common/common-utils';
import { Sort } from '@angular/material';

@Component({
  selector: 'app-module-admin',
  templateUrl: './module-admin.component.html',
  styleUrls: ['./module-admin.component.css']
})
export class ModuleAdminComponent implements OnInit {

  constructor(
            private translateService: TranslateService, 
            private moduleadminService: ModuleAdminService, 
            private modalService: NgbModal,
            private tokenService: TokenService,
            private toastr: ToastrService,
            private commonUtils: CommonUtils
            ) { }

  ngOnInit() {
    this.status = Constant.STATUS;
    this.getAllModuleAdmin();
    this.initSearchForm();
  }

  listModuleAdmin: ModuleAdmin[];
  status = {};
  moduleadmin: ModuleAdmin = new ModuleAdmin();
  currentModal: NgbModalRef;
  
  updateModelAdmin
  selectedItem
  titleModal
  errorViewer = {}


  paging = {
    totalRecord: ''
  }

  urlQuery = {
    name: '',
    code: '',
    active: '',
    startDateSearch: '',
    enddateSearch: '',
    page: 1,
    size: Constant.PAGING.SIZE
  }

  initSearchForm() {
    this.urlQuery.name = ''
    this.urlQuery.code = ''
    this.urlQuery.active = ''
    this.urlQuery.startDateSearch = ''
    this.urlQuery.enddateSearch = ''
  }

  getMaxOrder() {
    if (this.selectedItem) {
      if (this.selectedItem.orgs && this.selectedItem.orgs.length > 0) {
        return Math.max(...this.selectedItem.orgs.map(o=>o.order)) + 1; 
      } 
      else if (this.selectedItem.orgs && this.selectedItem.orgs.length == 0) {
        return 1
      } 
    } 
  }

  showModelAdminModal(content, moduleadminId) {
    this.initDataModal(moduleadminId);
    this.currentModal = this.modalService.open(content, {centered: true, size: 'lg', windowClass: 'modal-xl'})
    
  }

  initDataModal(moduleadminId) {
    if (moduleadminId == null) {
      this.moduleadmin = {
        id: 0,
        name: null,
        parentId: 0,
        active: true,
        createDate: null,
        code: null,
        order: null,
        routerPath: null,
        faIcon: null,
        componentName: null,
        description: null,
      }
      this.titleModal = "Thêm mới module";
    } else {
      this.listModuleAdmin.forEach(element => {
        if (element.id == moduleadminId){
          this.updateModelAdmin = element;
        }
      });
      this.titleModal = "Cập nhật module";
      this.moduleadmin = Object.assign({}, this.updateModelAdmin);
    }
  }

  getAllModuleAdmin() {
    this.moduleadminService.getAllModuleAdmin().subscribe(result => {
      if (result)
        this.listModuleAdmin = result;
        this.paging.totalRecord = result.totalElements
      SharedPreferences.IS_LOADING_CONTEN = false;
    })
  }

  createorUpdateModuleAdmin(moduleadmin) {
    if (moduleadmin.id > 0) {
      this.doSaveModuleAdmin(this.moduleadmin, moduleadmin.id);
    } else {
      this.doSaveNewModuleAdmin(this.moduleadmin);
    }
  }

  doSaveModuleAdmin(moduleadmin, moduleadminId) {
    this.moduleadminService.doSaveModuleAdmin(moduleadmin, moduleadminId).subscribe(
      res => {
        this.toastr.success('Cập nhật đơn vị thành công!', 'Thành công');
        this.currentModal.close()
        this.getAllModuleAdmin();
      },
      err => {
        if (err.status == Constant.ERROR_STATUS.INPUT_ERROR) {
          this.convertErrorResponse(JSON.parse(err.error.message))
        }
        else {
          this.toastr.error(err, 'Lỗi');
        }
      }
    );
  }
  
  doSaveNewModuleAdmin(moduleadmin) {
    if (moduleadmin.parentId == 0) {
      moduleadmin.parentId = null;
    } 
    this.moduleadminService.doSaveNewModuleAdmin(moduleadmin).subscribe(
      res => {
        this.toastr.success('Thêm mới đơn vị thành công!', 'Thành công');
        this.currentModal.close()
        this.getAllModuleAdmin();
      },
      err => {
        console.log(err);
        if (err.status == Constant.ERROR_STATUS.INPUT_ERROR) {
          this.convertErrorResponse(JSON.parse(err.error.message))
        }
        else {
          this.toastr.error(err, 'Lỗi');
        }
      }
    );
  }

  convertErrorResponse(errorResponse: InputError) {
    this.errorViewer[errorResponse.field] = errorResponse.message
    console.log('this.errorViewer[errorResponse.field]', this.errorViewer[errorResponse.field])
  }

  showLockOrUnLockModuleAdminModal(moduleadmin) {
    const message = `Bạn có chắc chắn muốn ${moduleadmin.active ? 'khóa' : 'mở khóa'}?`;
    this.commonUtils.showPopupConfirm(message, () => {
      this.activeOrDeactiveModuleAdmin(moduleadmin);
    });
  }

  activeOrDeactiveModuleAdmin(moduleadmin) {
    if (moduleadmin.active) {
      this.deactiveModuleAdmin(moduleadmin.id);
    } else {
      this.activeModuleAdmin(moduleadmin.id);
    }
  }

  activeModuleAdmin(moduleadminId) {
    console.log("MỞ KHÓA")
    this.moduleadminService.activeModuleAdmin(moduleadminId).subscribe(
      res => {
        this.toastr.success('Mở khóa danh mục thành công!', 'Thành công');
        this.getAllModuleAdmin();
      },
      err => {
        this.toastr.error(err, 'Lỗi');
        console.log(err);
      }
    );
  }

  deactiveModuleAdmin(moduleadminId) {
    console.log("KHÓA")
    this.moduleadminService.deactiveModuleAdmin(moduleadminId).subscribe(
      res => {
        this.toastr.success('Khóa danh mục thành công!', 'Thành công');
        this.getAllModuleAdmin();
      },
      err => {
        this.toastr.error(err, 'Lỗi');
        console.log(err);
      }
    );
  }

  changePageSize($event) {
    this.urlQuery.size = $event
    this.urlQuery.page = 1
    this.getAllModuleAdmin();
  }

  showSuccess: boolean = false;
  onSearch() {
    console.log(this.urlQuery)
    this.moduleadminService.searchModuleAdmin(this.urlQuery).subscribe(
      data => {
        this.listModuleAdmin = data;
        this.showSuccess = true;
        if (this.showSuccess == true) {
          this.toastr.success('Tìm kiếm module thành công!', 'Thành công');
        }
      },
      err => {
        this.toastr.error('Không tìm thấy module nào!', 'Lỗi');
      }
    );
  }

  sortData(sort: Sort) {
    this.listModuleAdmin = this.listModuleAdmin.sort((a, b) => {
      const isAsc = sort.direction === 'asc';
      switch (sort.active) {
        case 'name': return compare(a.name, b.name, isAsc);
        case 'createDate': return compare(a.createDate, b.createDate, isAsc);
        default: return 0;
      }
    });
  }
}

function compare(a: number | string | Date, b: number | string | Date, isAsc: boolean) {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}