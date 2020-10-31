import { Component, OnInit } from '@angular/core';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { DelegateFlow } from 'src/app/core/model/domain/delegate-flow';
import { DateTimeService } from 'src/app/services/date-time.service';
import { CommonUtils } from 'src/app/core/common/common-utils';
import { ToastrService } from 'ngx-toastr';
import { Constant } from 'src/app/core/config/constant';
import { TranslateService } from '@ngx-translate/core';
import { HttpParams } from '@angular/common/http';
import { CategoryService } from 'src/app/services/category.service';
import { DelegateFlowService } from 'src/app/services/delegate-flow.service';


enum SearchTitles {
  // FROM_USER_ORDER, TO_USER_ORDER
  FROM_POSITION = 'FROM_POSITION',
  TO_POSITION = 'TO_POSITION',
}
@Component({
  selector: 'app-delegateflow',
  templateUrl: './delegateflow.component.html',
  styleUrls: ['./delegateflow.component.css']
})
export class DelegateflowComponent implements OnInit {

  modalReference: NgbModalRef;
  currentDate: any;
  posList;
  toPosList;
  searchTitles = SearchTitles;
  pageSizeOptions = Constant.PAGE_SIZE_OPTION;
  searchField = {
    fromUserId: '',
    toUserId: '',

    // isAdvanceSearch: false,
    // quickSearchText: '',
    page: 1,
    sortBy: '',
    direction: Constant.SORT_TYPE.DECREASE,
    pageSize: Constant.PAGING.SIZE,
  };
  paging = {
    itemsPerPage: Constant.ITEMS_PER_PAGE,
    currentPage: 1,
    totalRecord: -1,
  };

  constructor(
    private modalService: NgbModal,
    private dateTimeService: DateTimeService,
    private commonUtils: CommonUtils,
    private toastr: ToastrService,
    private translateService: TranslateService,
    private categoryService: CategoryService,
    private delegateFlowService: DelegateFlowService
  ) { }
  isEditDelegate = false;
  isEditIndex;
  delegateAction = new DelegateFlow();
  delegateList: DelegateFlow[];


  ngOnInit() {
    this.currentDate = this.dateTimeService.convertStringDateToNgbDate(new Date().toString() , true);
    this.getPosList();
    this.doGetDelegateList(1);
  }
  getPosList() {
    this.categoryService.getCategoryWithCode('CVND').subscribe(
      data => {
        console.log('getPosList : ', data);
        this.posList = data;
      },
      err => {
        console.log(err);
      }
    );
  }
  doDeleteDelegate(index) {
    let temp = JSON.parse(JSON.stringify(this.delegateList[index]));
    console.log('doDeleteDelegate : ', temp);
    this.delegateFlowService.deleteDelegateFlow(temp.id).subscribe(
      data => {
        this.toastr.success('Xóa luồng uỷ quyền thành công!', this.translateService.instant('label.notification'));
        this.doGetDelegateList(1);
      }
    );
  }
  showConfirmDeleteDelegate(index) {
    const message = 'Bạn có chắc chắn muốn xóa luồng ủy quyền?';
    this.commonUtils.showPopupConfirm(message, () => {
      this.doDeleteDelegate(index);
    });
  }
  doActionDelegate(content, index, isEdit) {
    this.isEditDelegate = isEdit;
    if (isEdit && index > -1) {
      this.isEditIndex = index;
      this.delegateAction = JSON.parse(JSON.stringify(this.delegateList[index]));
    } else {
      this.initateNewDelegate();
    }
    // this.modalReference = this.modalService.open(content, {centered: true})
    this.modalReference = this.modalService.open(content, {centered: true, size: 'lg'});
    // this.modalService.open(content, {centered: true})
    this.modalReference.result.then(
      result => {
      }).catch(error => {
    });
  }
  initateNewDelegate() {
    this.isEditDelegate = false;
    this.delegateAction = new DelegateFlow();

    this.delegateAction.fromPosId = -1;
    this.delegateAction.toPosId = -1;

  }
  doSaveDelegate(){
    if(this.isEditDelegate) {
      const formData  = new FormData();
      console.log('Call updateDelegate : ', formData);
      // this.delegateService.updateDelegate(formData).subscribe(
      //   data => {
      //     console.log('data : ', data);
      //     this.modalReference.close();
      //     this.toastr.success('Cập nhật uỷ quyền thành công!', this.translateService.instant('label.notification'));
      //     this.doGetDelegateList(1);
      //   },
      //   err => {
      //     // this.toastr.error(err.error.message, 'Lỗi');
      //   }
      // );
    } else {
      const formData  = new FormData();
      formData.append('from', this.delegateAction.fromPosId.toString());
      formData.append('to', this.delegateAction.toPosId.toString());

      console.log('Call addDelegate : ', formData);
      this.delegateFlowService.addDelegateFlow(formData).subscribe(
        data => {
          console.log('Call addDelegate data : ', data);
          this.modalReference.close();
          this.toastr.success('Thêm mới luồng uỷ quyền thành công!', this.translateService.instant('label.notification'));
          this.doGetDelegateList(1);
        },
        err => {
          // this.toastr.error(err.error.message, 'Lỗi');
        }
      );
    }
  }


  // sort
  // doAdvanceSearchSubmit(currentPage: number){
  //   this.doAdvanceSearch(currentPage);
  // }

  // doBasicSearchSubmit(currentPage: number){
  //   this.doBasicSearch(currentPage);
  // }
  doBasicSearch(currentPage){
    // this.searchField.isAdvanceSearch = false;
    this.doBeforeLoadingResult(currentPage)
    let params = new HttpParams()
                    // .set('q', this.searchField.quickSearchText ? this.searchField.quickSearchText.toString() : '')
                    .set('page', currentPage.toString())
                    .set('sortBy', this.searchField.sortBy)
                    .set('direction', this.searchField.direction)
                    .set('size', this.searchField.pageSize.toString());
    console.log('call doBasicSearch');
    this.delegateFlowService.getDelegateFlowList(params).subscribe(
      data => {
        console.log(data);
        this.paging.totalRecord = data.totalElements;
        this.delegateList = data.content;
      }
    );
  }
  // doAdvanceSearch(pageNumber){
  //   this.doBeforeLoadingResult(pageNumber);
  //   this.searchField.isAdvanceSearch = true;

  //   let params = new HttpParams()
  //                   .set('fromUser', this.searchField.fromUserId.toString())
  //                   .set('toUser', this.searchField.toUserId.toString())

  //                   .set('page', this.paging.currentPage.toString())
  //                   .set('sortBy', this.searchField.sortBy)
  //                   .set('direction', this.searchField.direction)
  //                   .set('size', this.searchField.pageSize.toString());
  //   this.delegateService.searchAdvanceDelegate(params).subscribe(
  //     data => {
  //       console.log(data);
  //       this.paging.totalRecord = data.totalElements;
  //       this.delegateList = data.content;
  //     }
  //   );
  // }
  doBeforeLoadingResult(currentPage: number) {
    this.searchField.page = currentPage;
    this.paging.currentPage = currentPage;
  }
  sortByField(fieldName: string) {
    this.searchField.sortBy = fieldName;
    this.doSearch(null, fieldName);
  }
  doSearch(page: number, sortField='') {
    if (!page) {
      page = this.searchField.page;
    }

    if (sortField) {
      this.searchField.sortBy = sortField;
      this.toggleSortType();
    }

    // if (this.searchField.isAdvanceSearch) {
    //   this.doAdvanceSearch(page);
    // } else {
      this.doBasicSearch(page);
    // }
  }
  toggleSortType() {
    if (Constant.SORT_TYPE.DECREASE == this.searchField.direction) {
      this.searchField.direction = Constant.SORT_TYPE.INCREASE;
    }
    else {
      this.searchField.direction = Constant.SORT_TYPE.DECREASE;
    }
  }
  doGetDelegateList(page) {
    this.paging.currentPage = page;
    let param = new HttpParams()
        .set('page', this.paging.currentPage.toString())
        .set('sortBy', this.searchField.sortBy)
        .set('direction', this.searchField.direction)
        .set('size', this.searchField.pageSize.toString());
    this.delegateFlowService.getDelegateFlowList(param).subscribe(
      data => {
        console.log(data);
        this.paging.totalRecord = data.totalElements;
        this.delegateList = data.content;
      }
    );
  }
  // showAdvanceSearch() {
  //   this.searchField.isAdvanceSearch = !this.searchField.isAdvanceSearch;
  // }
  changePageSize($event) {
    this.searchField.pageSize = $event
    this.searchField.page = 1
    this.doSearch(1)
  }
  pageChanged($event) {
    // if (this.searchField.isAdvanceSearch) {
    //   this.doAdvanceSearch($event);
    // } else {
      this.doBasicSearch($event);
    // }
  }
  onChangeFromUser(event) {
    console.log('onChangeFromUser : ', this.delegateAction.fromPosId);
    if( this.delegateAction.fromPosId != -1 ) {
      this.toPosList = this.posList.filter(x => x.id != this.delegateAction.fromPosId);
    } else {
      this.delegateAction.toPosId = -1;
    }
  }
}
