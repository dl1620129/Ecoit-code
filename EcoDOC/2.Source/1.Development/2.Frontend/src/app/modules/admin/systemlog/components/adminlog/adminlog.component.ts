import { Component, OnInit, ViewChild } from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';

import { Logtrace } from 'src/app/core/model/domain/logtrace';
import { LogtraceService } from 'src/app/services/logtrace.service';

import { User } from 'src/app/core/model/domain/user';
import { UserService } from 'src/app/services/user.service';

import { HttpParams } from '@angular/common/http';
import { ClientService } from 'src/app/services/client.service';
import { ToastrService } from 'ngx-toastr';
import { Constant } from 'src/app/core/config/constant';


enum SearchTitles {
  CONTENT = 'CONTENT',
  CREATE_DATE = 'CREATE_DATE',
  USERNAME = 'USERNAME',
  DEVICE_IP = 'DEVICE_IP',
  DEVICE_NAME = 'DEVICE_IP',
  ACTION = 'ACTION',
  CLIENT_NAME = 'CLIENT_NAME',
  DOC_TYPE_NAME = 'DOC_TYPE_NAME',
  DOC_STATUS_NAME= 'DOC_STATUS_NAME',
  ACCESS_COUNT = 'ACCESS_COUNT'
}

@Component({
  selector: 'app-adminlog',
  templateUrl: './adminlog.component.html',
  styleUrls: ['./adminlog.component.css']
})
export class AdminlogComponent implements OnInit {

  // get search form data

  urlQuery = {
    startDateSearch: '',
    endDateSearch: '',
    clientNameSearch: '',
    quarterlySearch: '',
    monthSearch: '',
    yearSearch: (new Date()).getFullYear().toString(),
    page: 1,
    sortBy: '',
    direction: Constant.SORT_TYPE.DECREASE,
    size: Constant.PAGING.SIZE
  }

  searchTitles = SearchTitles
  pageSizeOptions = Constant.PAGE_SIZE_OPTION

  paging = {
    totalRecord: ''
  }

  yearObjs

  quarterlyObjs = [
    {value: 1, description: 'Quý 1'},
    {value: 2, description: 'Quý 2'},
    {value: 3, description: 'Quý 3'},
    {value: 4, description: 'Quý 4'},
  ];

  monthObjs = [
    {value: 1, description: 'Tháng 1'},
    {value: 2, description: 'Tháng 2'},
    {value: 3, description: 'Tháng 3'},
    {value: 4, description: 'Tháng 4'},
    {value: 5, description: 'Tháng 5'},
    {value: 6, description: 'Tháng 6'},
    {value: 7, description: 'Tháng 7'},
    {value: 8, description: 'Tháng 8'},
    {value: 9, description: 'Tháng 9'},
    {value: 10, description: 'Tháng 10'},
    {value: 11, description: 'Tháng 11'},
    {value: 12, description: 'Tháng 12'},
  ];

  logs;
  log;

  clients;
  client;

  showNoData;

  constructor(
    private logService: LogtraceService,
    private userService: UserService,
    private clientService: ClientService,
    private toastr: ToastrService,
  ) {}

  onSearch(pageNo: number) {
    this.urlQuery.page = pageNo
    // startDate=2019-05-07&endDate=2021-05-07&page=1&quarterly=2&month=5&year=2020&idCat=1
    const params = new HttpParams()
                    .set('startDate', this.urlQuery.startDateSearch)
                    .set('endDate', this.urlQuery.endDateSearch)
                    .set('page', '1')
                    .set('quarterly', this.urlQuery.quarterlySearch)
                    .set('month', this.urlQuery.monthSearch)
                    .set('year', this.urlQuery.yearSearch)
                    .set('idCat', this.urlQuery.clientNameSearch)
                    .set('sortBy', this.urlQuery.sortBy)
                    .set('direction', this.urlQuery.direction)
                    .set('size', this.urlQuery.size.toString());
                    console.log('searchFormData: ', params.toString());
    this.logService.searchAdmin(params.toString()).subscribe(
      data => {
        console.log(data);
        if (data) {
          const obj = JSON.parse(JSON.stringify(data));
          console.log('obj : ', obj.objList);
          this.paging.totalRecord = data.totalRecord
          this.logs = obj.objList;
          this.showNoData = true;
          this.toastr.success('Tìm kiếm tần suất truy cập hệ thống thành công!', 'Thành công');
        }
      },
      err => {
        console.log(err);
        // this.toastr.error('Tìm kiếm tần suất truy cập hệ thống không thành công!', 'Lỗi');
      }
      );
  }

  ngOnInit() {
    let today = new Date();
    let dd = String(today.getDate()).padStart(2, '0');
    let mm = String(today.getMonth() + 1).padStart(2, '0');
    let yyyy = today.getFullYear();

    this.urlQuery.endDateSearch = yyyy + '-' + mm + '-' + dd;
    this.urlQuery.startDateSearch = yyyy + '-' + mm + '-' + dd;
    console.log('endDateSearch : ', this.urlQuery.endDateSearch);
    if (!this.yearObjs) {
      const year = new Date().getFullYear();
      this.yearObjs = [];
      for (let i = -10; i < 10; i++) {
        this.yearObjs.push(year + i);
      }
    }
    if (!this.clients) {
      this.clientService.getClients().subscribe(
        data => {
          console.log(data);
          if (data) {
            this.clients = data;
            console.log(this.clients);
          }
        }
      );
    }
  }

  pageChanged($event) {
    this.onSearch($event)
  }

  sortByField(fieldName: string) {
    this.toggleSortType()
    this.urlQuery.sortBy = fieldName;
    this.onSearch(this.urlQuery.page);
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
    this.onSearch(1)
  }
}
