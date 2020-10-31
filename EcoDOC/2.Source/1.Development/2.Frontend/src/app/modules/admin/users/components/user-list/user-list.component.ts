import {Component, OnInit, ViewChild} from '@angular/core';
import {UserService} from 'src/app/services/user.service';
import {User} from 'src/app/core/model/domain/user';
import {NgbModal} from '@ng-bootstrap/ng-bootstrap';
import {ToastrService} from 'ngx-toastr';
import {MatDialogConfig, MatDialog} from '@angular/material';
import {UserComponent} from '../user/user.component';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {PermissionService} from 'src/app/services/permission.service';
import {OrganizationService} from 'src/app/services/organization.service';
import {Constant} from 'src/app/core/config/constant';
import {CategoryService} from 'src/app/services/category.service';
import {HttpParams} from '@angular/common/http';
import {CommonUtils} from 'src/app/core/common/common-utils';
import {Router, NavigationExtras} from "@angular/router";
import { SharedPreferences } from 'src/app/core/config/shared-preferences';

enum SearchTitles {
    UPDATEDATE = 'UPDATEDATE',
		FULLNAME = 'FULLNAME',
		ORG = 'ORG',
		POSITION = 'POSITION',
		BIRTHDAY = 'BIRTHDAY',
		PHONE = 'PHONE',
    ACTIVE = 'ACTIVE',
    IDENTITY= 'IDENTITY'
}

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css'],
})
export class UserListComponent implements OnInit {
  posList;
  orgList;
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
    page: null,
    sortBy: '',
    direction: Constant.SORT_TYPE.DECREASE,
    size: Constant.PAGING.SIZE,
  };

  searchTitles = SearchTitles
  pageSizeOptions = Constant.PAGE_SIZE_OPTION
  
  paging = {
    // itemsPerPage: Constant.ITEMS_PER_PAGE,
    // currentPage: 1,
    totalItems: -1,
  };
  // page
  config: any;
  users: User[];
  user = new User();
  action: number;
  gender: boolean;

  // Add for new table
  newuser: User;

  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;
  @ViewChild(MatSort, {static: true}) sort: MatSort;
  searchUserList: any;

  constructor(
    private userService: UserService,
    private permissionService: PermissionService,
    private modalService: NgbModal,
    private toastr: ToastrService,
    private dialog: MatDialog,
    private organizationService: OrganizationService,
    private categoryService: CategoryService,
    private commonUtils: CommonUtils,
    private sharedPreferences: SharedPreferences,
    private router: Router) 
  {
    let navigation = this.router.getCurrentNavigation();
    if (navigation && navigation.extras.state) {
      let action = navigation.extras.state.action;
      if (action && action === "back") {
        let user_query = this.sharedPreferences.getDataLocal("user_query");
        if (user_query)
          this.searchFields = user_query;
      }
    }
  }
// Add for new table
  onSearchBtClick() {
    this.searchFields.page = 1;
    // this.searchFields.currentPage = 1;
    this.onSearch(true, 1);
  }

  onSearch(showSuccess, pageNo: number) {
    this.searchFields.page = pageNo
    let params = new HttpParams()
      .set('fullName', this.searchFields.fullName)
      .set('userName', this.searchFields.userName)
      .set('email', this.searchFields.email)
      .set('phone', this.searchFields.phone)
      .set('sex', this.searchFields.sex == null ? '' : this.searchFields.sex)
      .set('indentity', this.searchFields.indentity)
      .set('title', this.searchFields.title == null ? '' : this.searchFields.title)
      .set('employeeId', this.searchFields.employeeId == null ? '' : this.searchFields.employeeId)
      .set('employeeCode', this.searchFields.employeeCode == null ? '' : this.searchFields.employeeCode)
      .set('salt', this.searchFields.salt == null ? '' : this.searchFields.salt)
      .set('org', this.searchFields.org == null ? '' : this.searchFields.org)
      .set('position', this.searchFields.position == null ? '' : this.searchFields.position)
      .set('lead', this.searchFields.lead == null ? '' : this.searchFields.lead)
      .set('birthday', this.searchFields.birthday ? this.searchFields.birthday.toString() : '')
      .set('page', this.searchFields.page == null ? 1 : this.searchFields.page)
      .set('sortBy', this.searchFields.sortBy)
      .set('direction', this.searchFields.direction)
      .set('size', this.searchFields.size.toString());
    this.userService.searchUser(params).subscribe(
      data => {
        this.searchUserList = data.content;
        this.paging.totalItems = data.totalElements;
          // this.paging.currentPage = this.searchFields.page;
        if (showSuccess == true) {
          if(this.searchFields.fullName!='' || this.searchFields.userName!='' || this.searchFields.phone!='' 
          || this.searchFields.email!='' || this.searchFields.title!=null || this.searchFields.org!=null || this.searchFields.birthday!=null||this.searchFields.indentity!=''){
          this.toastr.success('Tìm kiếm người dùng thành công!', 'Thành công');
          }
        }
        this.sharedPreferences.setDataLocal("user_query", this.searchFields);
      },
      err => {
        // this.toastr.error('Không tìm thấy người dùng nào!', 'Lỗi');
      }
    );
  }

  onAddNewUser() {
    this.newuser = {
      id: 0,
      gender: 0,
      photo: '',
      clientId: null,
      userName: '',
      fullName: '',
      birthday: null,
      birthday_tmp: null,
      sex: null,
      active: false,
      indentity: null,
      phone: null,
      email: '',
      org: null,
      position: null,
      lead: false,
      phoneCAProvider: '',
      phoneCA: '',
      signature: '',
      positionModel: {},
      address:'',
      nameToken:'',
      serialToken:'',
      startTimeToken:'',
      expiredTimeToken:'',
      orgToken:''
    };

    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.disableClose = true;
    dialogConfig.width = '50%';
    dialogConfig.data = this.newuser;
    this.dialog.open(UserComponent, dialogConfig).afterClosed().subscribe(res => {
      this.onSearch(false, this.searchFields.page);
    });
  }

  onUpdateUser(user) {
    // const dialogConfig = new MatDialogConfig();
    // dialogConfig.autoFocus = true;
    // dialogConfig.disableClose = true;
    // dialogConfig.width = '50%';
    //dialogConfig.data = user;
    const navigationExtras: NavigationExtras = {
      state: user
    }
    this.router.navigate(['users/detail', user.userName])
    // this.dialog.open(UserComponent, dialogConfig).afterClosed().subscribe(res => {
    //   this.onSearch(false);
    // });
  }

  activeOrDeactiveUser(user: User
  ) {
    let act = user.active;
    this.commonUtils.showPopupConfirm(act ? 'Bạn có muốn ngừng kích hoạt người dùng?' : 'Bạn có muốn kích hoạt người dùng?', () => {
      this.userService.ActiveDeactiveUser(user)
        .subscribe(
          data => {
            this.onSearch(false, this.searchFields.page);
            if (act) {
              this.toastr.success('Ngưng kích hoạt', 'Thành công!');
            } else {
              this.toastr.success('Kích hoạt người dùng', 'Thành công!');
            }
          },
          error => {
          }
        );
    });

  }

  getUserSex(sex
               :
               boolean
  ) {
    if (sex) {
      return 'Nam';
    }
    return 'Nữ';
  }

  ngOnInit() {
    this.getOrganizationList();
    this.getPositionList();
    // this.getAllUsers();
    this.searchFields.page = 1;
    // this.paging.currentPage = 1;
    this.onSearch(false, 1);
  }

  getOrganizationList() {
    this.organizationService.getOrganizations().subscribe(
      data => {
        if (data) {
          this.orgList = data;
        }
      }
    );
  }

  getOrgnameByID(id) {
    if (this.orgList) {
      for (let i = 0; i < this.orgList.length; i++) {
        if (this.orgList[i].id == id) {
          return this.orgList[i].name;
        }
      }
      return '';
    }
    return '';
  }

  getPositionList() {
    this.categoryService.getCategoryWithCode(Constant.CATEGORYTYPE_CODE.USER_POSITION).subscribe(
      data => {
        this.posList = data;
        this.sapxep('name')
      },
      err => {
        console.log(err);
      }
    );
  }
  column: string = 'CategoryName';
  isDesc: boolean = false;
  sapxep(property) {
    this.isDesc = !this.isDesc; //change the direction    
    this.column = property;
    let direction = this.isDesc ? 1 : -1;

    this.posList.sort(function (a, b) {
      if (a[property] < b[property]) {
        return -1 * direction;
      }
      else if (a[property] > b[property]) {
        return 1 * direction;
      }
      else {
        return 0;
      }
    });
  };
  getPosnameByID(id) {
    if (this.posList) {
      for (let i = 0; i < this.posList.length; i++) {
        if (this.posList[i].id == id) {
          return this.posList[i].name;
        }
      }
      return '';
    }
    return '';
  }

  pageChanged($event) {
    this.searchFields.page = $event.toString();
    this.onSearch(false, $event);
  }

  sortByField(fieldName: string) {
    this.toggleSortType()
    this.searchFields.sortBy = fieldName;
    this.onSearch(false, this.searchFields.page);
    if (fieldName) {
      this.searchFields.sortBy = fieldName
    }
  }

  toggleSortType() {
    if (Constant.SORT_TYPE.DECREASE == this.searchFields.direction) {
      this.searchFields.direction = Constant.SORT_TYPE.INCREASE
    }
    else {
      this.searchFields.direction = Constant.SORT_TYPE.DECREASE
    }
  }

  changePageSize($event) {
    this.searchFields.size = $event
    // this.searchFields.page = 1
    this.onSearch(false, 1)
  }
}
