import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, NgForm } from '@angular/forms';
import { IBusinessLog } from '../../../core/model/domain/business-log';
import { BusinessLogService } from 'src/app/services/business-log.service';
import { ToastrService } from 'ngx-toastr';
import { ActivatedRoute } from '@angular/router';
import { HttpParams } from '@angular/common/http';
import { isThisSecond } from 'date-fns';
import { Constant } from '../../../core/config/constant';
import { CategoryService } from 'src/app/services/category.service';
import { ExportService } from 'src/app/services/export.service';


enum SearchTitles {
  CONTENT = 'CONTENT',
  CREATE_DATE = 'CREATE_DATE',
  USERNAME = 'USERNAME',
  DEVICE_IP = 'DEVICE_IP',
  DEVICE_NAME = 'DEVICE_IP',
  ACTION = 'ACTION',
  CLIENT_NAME = 'CLIENT_NAME',
  DOC_TYPE_NAME = 'OBJECT_TYPE',
  DOC_STATUS_NAME= 'DOC_STATUS_NAME'
}

@Component({
  selector: 'app-business-log',
  templateUrl: './business-log.component.html',
  styleUrls: ['./business-log.component.css']
})
export class BusinessLogComponent implements OnInit {

  categoryObjs = [
    {id: "1", name: 'Loai1'},
    {id: "2", name: 'Loai2'},
    {id: "3", name: 'Loai3'},
    {id: "4", name: 'Loai4'},
  ];

  urlQuery = {
    idCat: '',
    username: '',
    startDate: '',
    endDate: '',
    page: 1,
    sortBy: '',
    direction: Constant.SORT_TYPE.DECREASE,
    size: Constant.PAGING.SIZE,
  }

  searchTitles = SearchTitles
  pageSizeOptions = Constant.PAGE_SIZE_OPTION

  page: string;
  totalRecord: number;

  businessLogs: IBusinessLog[];

  paging = {
    // itemsPerPage: Constant.ITEMS_PER_PAGE,
    // currentPage: 1,
    totalRecord: '',
  }
  excelJson: any[];
  exportLog: any;

  constructor(private fb: FormBuilder,
     private businessLogService: BusinessLogService,
     private categoryService: CategoryService,
     private toastr: ToastrService,
     private exportService: ExportService,
     private route: ActivatedRoute ) { }

  // first time load data
  ngOnInit() {
    this.categoryService.getAllMapCategory().subscribe({
      next: data => {
        this.categoryObjs = data
      }
    })

    this.setParamsFromUrl();
    this.getAllBusinessLog(1)
    // this.businessLogService.searchBusinessLog(this.urlQuery).subscribe({
    //   next: data => {
    //     this.businessLogs = data.objList ? data.objList : [],
    //     this.paging.totalRecord = data.totalRecord,
    //     this.urlQuery.page = +this.urlQuery.page
    //   },
    //   error: err => console.log("error")
    // });
  }

  // search form action
  getAllBusinessLog(page: number): void {
    this.urlQuery.page = page,
    this.businessLogService.searchBusinessLog(this.urlQuery).subscribe({
      next: data => {
        this.businessLogs = data.objList ? data.objList : [],
        this.paging.totalRecord = data.totalRecord
        // this.urlQuery.page = 1
        if(this.businessLogs.length > 0) {
          this.urlQuery.page = page
          this.getExportLog(this.urlQuery);
        }
      },
      error: err => console.log("error")
    });
  }
  getExportLog(param) {
    this.businessLogService.exportBusinessLog(param).subscribe(
      data => {
        this.exportLog = data.objList ? data.objList : [];
      }
    );
  }
  // pagination action
  pageChanged($event) {
    this.getAllBusinessLog($event)
    // this.urlQuery.page = $event.toString();
    // this.urlQuery.page = $event
    // this.businessLogService.searchBusinessLog(this.urlQuery).subscribe({
    //   next: data => {
    //     this.businessLogs = data.objList ? data.objList : [],
    //     this.paging.totalRecord = data.totalRecord,
        
    //   },
    //   error: err => console.log("error")
    // });
  }

  private setParamsFromUrl(): void {
    this.route.queryParams.subscribe(params => {
      this.urlQuery.startDate = params['startDate'] ? params['startDate'] : '',
      this.urlQuery.endDate = params['endDate'] ? params['endDate'] : '',
      this.urlQuery.username = params['username'] ? params['username'] : '',
      this.urlQuery.idCat = params['idCat'] ? params['idCat'] : '',
      this.urlQuery.page = params['page'] ? params['page'] : ''
    });
  }
  prettyJSON(objlist){
    this.excelJson = [];
    for (let i = 0; i < objlist.length; i++) {
      this.excelJson.push(
        [
          i + 1,
          objlist[i].userName ? objlist[i].userName : '',
          objlist[i].ipDevice ? objlist[i].ipDevice : '',
          objlist[i].action ? objlist[i].action : '',
          objlist[i].category ? objlist[i].category : '',
          objlist[i].content ? objlist[i].content : '',
          objlist[i].createDate ? objlist[i].createDate : '',
        ]
      );
    }
  }
  exportExcel() {
    let header = [
      'STT',
      'Tên đăng nhập',
      'IP Thiết bị',
      'Hành động',
      'Loại Đối Tượng',
      'Nội Dung',
      'Thời Gian',
    ];
    this.prettyJSON(this.exportLog);
    this.exportService.generateExcelBusinessLog('THỐNG KÊ NGHIỆP VỤ', header, this.excelJson, 'THONG_KE_NGHIEP_VU');
  }

  sortByField(fieldName: string) {
    this.toggleSortType()
    this.urlQuery.sortBy = fieldName;
    this.getAllBusinessLog(this.urlQuery.page);
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
    this.getAllBusinessLog(1)
  }
}
