import { Component, OnInit } from '@angular/core';
import { Sort } from '@angular/material';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { TranslateService } from '@ngx-translate/core';
import { ToastrService } from 'ngx-toastr';
import { TokenService } from 'src/app/core/authen/token.service';
import { CommonUtils } from 'src/app/core/common/common-utils';
import { Constant } from 'src/app/core/config/constant';
import { SharedPreferences } from 'src/app/core/config/shared-preferences';
import { InputError } from 'src/app/core/model/domain/error/input-error';
import { Preferences } from 'src/app/core/model/domain/preferences';
import { PreferencesService } from 'src/app/services/preferences.service';

enum SearchTitles {
  NAME = 'NAME',
  MAXSIZE = 'MAXSIZE',
  ACTIVE = 'ACTIVE',
}

@Component({
  selector: 'app-preferences',
  templateUrl: './preferences.component.html',
  styleUrls: ['./preferences.component.css']
})
export class PreferencesComponent implements OnInit {

  constructor(
    private translateService: TranslateService, 
    private preferencesService: PreferencesService, 
    private modalService: NgbModal,
    private tokenService: TokenService,
    private toastr: ToastrService,
    private commonUtils: CommonUtils
  ) { }

  ngOnInit() {
    this.status = Constant.STATUS;
    this.getAllPreferences();
    // this.initSearchForm()
  }

  status = {};
  listPreferences: any[];
  preferences: Preferences = new Preferences();
  page: number = 1;
  size : number = Constant.PAGING.SIZE;
  searchTitles = SearchTitles
  currentModal: NgbModalRef;
  showSuccess: boolean = false;

  searchFields = {
    name: '',
    maxSize: '',
    sortBy: '',
    direction: Constant.SORT_TYPE.DECREASE,
    size: Constant.PAGING.SIZE,
  };

  getAllPreferences(){
    this.preferencesService.getAllPreferences().subscribe(result => {
      if (result)
        this.listPreferences = result.data;
      SharedPreferences.IS_LOADING_CONTEN = false;
    })
  }

  showPreferencesModal(content, preferencesId) {
    this.initDataModal(preferencesId);
    this.currentModal = this.modalService.open(content, {centered: true, size: 'lg', windowClass: 'modal-xl'})
  }

  updatePreferences
  selectedItem
  titleModal
  initDataModal(preferencesId) {
    if (preferencesId == null) {
      this.preferences = {
        name: '',
        active: true,
        orgId: null,
        extension: '',
        maxSize: null,
        preType: '',
      }
      this.titleModal = "Thêm mới";
    } else {
      console.log(preferencesId)
      this.listPreferences.forEach(element => {
        if (element.id == preferencesId){
          this.updatePreferences = element;
        }
      });
      this.titleModal = "Cập nhật";
      this.preferences = Object.assign({}, this.updatePreferences);
    }
  }

  createorUpdatePreferences(preferences){
    console.log(preferences)
    if (preferences.id > 0){
      this.doSavePreferences(this.preferences, preferences.id);
    }else {
      this.doSaveNewPreferences(this.preferences);
    }
  }

  doSaveNewPreferences(preferences) {
    this.preferencesService.doSaveNewPreferences(preferences).subscribe(
      res => {
        this.toastr.success('Thêm mới thành công!', 'Thành công');
        this.currentModal.close()
        this.getAllPreferences();
      },
      err => {
        console.log(err);
        if (err.status == Constant.ERROR_STATUS.INPUT_ERROR) {
          this.convertErrorResponse(JSON.parse(err.error.message))
        }
        else {
          // this.toastr.error(err, 'Lỗi');
        }
      }
    );
  }

  doSavePreferences(preferences, preferencesId){
    this.preferencesService.doSavePreferences(preferences, preferencesId).subscribe(
      res => {
        this.toastr.success('Cập nhật thành công!', 'Thành công');
        this.currentModal.close()
        this.getAllPreferences();
      },
      err => {
        if (err.status == Constant.ERROR_STATUS.INPUT_ERROR) {
          this.convertErrorResponse(JSON.parse(err.error.message))
        }
        else {
          // this.toastr.error(err, 'Lỗi');
        }
      }
    )
  }

  showLockOrUnLockPreferencesModal(preferences) {
    const message = `Bạn có chắc chắn muốn ${preferences.active ? 'khóa' : 'mở khóa'}?`;
    this.commonUtils.showPopupConfirm(message, () => {
      this.activeOrDeactivePreferences(preferences);
    });
  }

  activeOrDeactivePreferences(preferences) {
    if (preferences.active) {
      this.deactivePreferences(preferences.id);
    } else {
      this.activePreferences(preferences.id);
    }
  }

  activePreferences(preferencesId) {
    console.log("MỞ KHÓA")
    this.preferencesService.activePreferences(preferencesId).subscribe(
      res => {
        console.log(res)
        this.toastr.success('Mở khóa thành công!', 'Thành công');
        this.getAllPreferences();
      },
      err => {
        this.toastr.error(err, 'Lỗi');
        console.log(err);
      }
    );
  }

  deactivePreferences(preferencesId) {
    console.log("KHÓA")
    this.preferencesService.deactivePreferences(preferencesId).subscribe(
      res => {
        this.toastr.success('Khóa thành công!', 'Thành công');
        this.getAllPreferences();
      },
      err => {
        // this.toastr.error(err, 'Lỗi');
        console.log(err);
      }
    );
  }

  changePageSize($event) {
    this.size = $event
    this.page = 1
    this.getAllPreferences();
  }
  

  errorViewer = {}
  convertErrorResponse(errorResponse: InputError) {
    this.errorViewer[errorResponse.field] = errorResponse.message
    console.log('this.errorViewer[errorResponse.field]', this.errorViewer[errorResponse.field])
  }

  onSearch() {
    console.log(this.searchFields)
    this.preferencesService.searchPreferences(this.searchFields).subscribe(
      data => {
        this.listPreferences = data;
        this.showSuccess = true;
        if (this.showSuccess == true) {
          this.toastr.success('Tìm kiếm thành phần mở rộng thành công!', 'Thành công');
        }
      },
      err => {
        this.toastr.error('Không tìm thấy thành phần mở rộng nào!', 'Lỗi');
      }
    );
  }

  sortData(sort: Sort) {
    this.listPreferences = this.listPreferences.sort((a, b) => {
      const isAsc = sort.direction === 'asc';
      switch (sort.active) {
        case 'name': return compare(a.name, b.name, isAsc);
        case 'maxSize': return compare(a.maxSize, b.maxSize, isAsc);
        case 'extension': return compare(a.extension, b.extension, isAsc);
        default: return 0;
      }
    });
  }

}

function compare(a: number | string, b: number | string, isAsc: boolean) {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}