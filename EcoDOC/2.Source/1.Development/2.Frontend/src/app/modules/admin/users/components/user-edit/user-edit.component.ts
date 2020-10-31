import {Component, OnInit, HostListener} from '@angular/core';
import {User} from "../../../../../core/model/domain/user";
import {Constant} from "../../../../../core/config/constant";
import {UploadFileService} from "../../../../../services/upload-file.service";
import {ToastrService} from "ngx-toastr";
import {CalendarService} from "../../../../../services/calendar.service";
import {TranslateService} from "@ngx-translate/core";
import {HttpEventType, HttpResponse} from "@angular/common/http";
import {OrganizationService} from "../../../../../services/organization.service";
import {CommonUtils} from "../../../../../core/common/common-utils";
import {SharedPreferences} from "../../../../../core/config/shared-preferences";
import {UserService} from "../../../../../services/user.service";
import {ActivatedRoute, Router, NavigationExtras} from "@angular/router";
import {CategoryService} from "../../../../../services/category.service";
import { TokenService } from 'src/app/core/authen/token.service';
import { ValidationService } from 'src/app/services/validation.service';
import { DateTimeService } from 'src/app/services/date-time.service';
import { NgbModal, NgbModalRef } from '@ng-bootstrap/ng-bootstrap';
import { SharedService } from 'src/app/services/shared.service';

@Component({
  selector: 'app-user-edit',
  templateUrl: './user-edit.component.html',
  styleUrls: ['./user-edit.component.css']
})
export class UserEditComponent implements OnInit {
  isUpdateUser = false;
  constructor(private uploadFileService: UploadFileService,
              private toastr: ToastrService,
              private common: CommonUtils,
              private userService: UserService,
              private organizationService: OrganizationService,
              private tokenService: TokenService,
              private categoryService: CategoryService,
              private activateRoute: ActivatedRoute,
              private router: Router,
              public validationService: ValidationService,
              private dateTimeService: DateTimeService,
              private translateService: TranslateService,
              private modalService: NgbModal,
              private sharedService: SharedService,
              private activatedRoute: ActivatedRoute) {
    SharedPreferences.IS_LOADING_CONTEN = true;
  }

  allowedFileExtensions = Constant.ALLOWED_FILE_IMAGE

  currentModal: NgbModalRef
  
  passwordForm = {
    currentPassword: "",
    newPassword: "",
    newPasswordConfirmation: ""
  }

  passwordValidation = {
    isSameAsCurrent: false,
    isNewPassWordConfirmWrong: false
  }

  isAdmin=true

  ngOnInit() {
    this.activatedRoute.queryParams.subscribe(params => {
     this.isAdmin = (params.isAdmin == "true")
     console.log('this.isAdmin', this.isAdmin)
    });
    this.getOrganizationList();
    this.activateRoute.paramMap.subscribe(
      params => {
        this.userName = params.get("user");
        console.log('this.userName', this.userName)
      }
    );
    if (this.userName != undefined) {
      this.isUpdateUser = true;
      this.getUserInfo();
    } else {
      this.isUpdateUser = false;
      this.doInitiateData();
    }
    // this.common.getCategoryByCode(Constant.CATEGORYTYPE_CODE.USER_POSITION).subscribe(data => {
    //   this.position = data;
    // });

    this.categoryService.getCategoryWithCode(Constant.CATEGORYTYPE_CODE.USER_POSITION).subscribe(data => {
        this.position = data;
         console.log("aaaaaaaa")
        console.log(this.user);
        console.log("bbbb")
      }
    );
  }

  position;
  userName;
  user: User = new User;
  nameAvatarTemp: string = 'Chọn ảnh đại diện';
  userAvatar: any;
  nameSignatureTemp: string = 'Chọn chữ ký';
  userSignature: any;
  orgList;
  orgObject;
  orgModel = [];
  orgLoaded: Promise<boolean>;

  getUserInfo() {
    this.userService.findByUserName(this.userName).subscribe(data => {
      this.user = data.data;
      console.log(this.user)
      this.user.birthday_tmp = this.dateTimeService.convertStringDateToNgbDate(this.user.birthday, true);
      console.log(this.user.birthday_tmp)
      if (this.user.signature) {
        this.nameSignatureTemp = "Cập nhật chữ ký"
      }
      this.orgModel = ['' + this.user.org];
      this.orgLoaded = Promise.resolve(true);
      console.log('getUserInfo : ', this.orgModel, this.user.org);
    })
  }

  showChangePassWordPopUp(content) {
    this.currentModal = this.modalService.open(content, {centered: true, size: 'lg', windowClass: 'modal-xl'})
  }

  validateChangePasswordForm() {
    this.resetValidatedPasswordForm()
    if (this.passwordForm.currentPassword == this.passwordForm.newPassword) {
      this.passwordValidation.isSameAsCurrent = true
      return false;
    }

    if (this.passwordForm.newPassword != this.passwordForm.newPasswordConfirmation) {
      this.passwordValidation.isNewPassWordConfirmWrong = true
      return false
    }

    return true
  }

  resetValidatedPasswordForm() {
    this.passwordValidation.isNewPassWordConfirmWrong = false
    this.passwordValidation.isSameAsCurrent = false
  }

  changePassword() {
    this.userService.changePassword(this.passwordForm.currentPassword, this.passwordForm.newPassword).subscribe(
      res => {
        this.toastr.success('Đổi mật khẩu thành công !', 'Thành công');
        this.closeModal()
      },
      err => {
      }
    );
  }

  closeModal() {
    this.passwordForm.currentPassword = ""
    this.passwordForm.newPassword = ""
    this.passwordForm.newPasswordConfirmation = ""
    this.currentModal.close();
  }

  doInitiateData() {
    this.user = new User();
    this.user.gender = 0;
    this.user.position = 0;
    this.user.lead = false;
    this.user.phoneCAProvider = "";
    this.user.signature = "";
  }

  checkParent(id, list) {
    for (let i = 0; i < list.length; i++) {
      if (list[i].parentId == id) {
        return true;
      }
    }
    return false;
  }

  getOrganizationList() {
    this.organizationService.getOrganizations().subscribe(data => {
      if (data != undefined) {
        this.orgList = data;
        for (let i = 0; i < this.orgList.length; i++) {
          if (this.orgList[i].parentId != null) {
            if (this.checkParent(this.orgList[i].id, this.orgList)) {
              this.orgList[i].haschild = true;
              this.orgList[i].nodeIcon = 'fas fa-check';
            } else {
              this.orgList[i].haschild = false;
              this.orgList[i].nodeIcon = 'fas fa-check';
            }
          } else {
            this.orgList[i].haschild = true;
            this.orgList[i].nodeIcon = 'fa fa-university';
          }
        }
        this.orgObject = {
          dataSource: this.orgList, value: 'id',
          text: 'name', parentValue: 'parentId', hasChildren: 'haschild', iconCss: 'nodeIcon'
        };
        if (this.user.org != undefined)
          this.orgModel = [''+ this.user.org];
        SharedPreferences.IS_LOADING_CONTEN = false;
      } else {
        this.orgList = [];
        SharedPreferences.IS_LOADING_CONTEN = false;
      }
    })
  }

  doUploadSignatureFile() {
    console.log(this.userSignature);
    return this.uploadFileService.uploadFile(this.userSignature).subscribe(
      res => {
        this.user.signature = res.message;
        this.toastr.success("Tải chữ ký thành công", "Thành công");
      },
      err => {
        // this.toastr.error("Tải chữ ký thất bại", "Lỗi");
      });
  }

  doSelectSignatureFiles(event) {
    console.log(event.target.files[0])
    if (!this.uploadFileService.doCheckFileExtensionImage(event.target.files)) {
      this.toastr.error(this.translateService.instant('Định dạng ảnh không hợp lệ'), this.translateService.instant('label.notification'));
      return false;
    }

    if (!this.doCheckFilesSize(event.target.files[0])) {
      this.toastr.error(this.translateService.instant('Dung lượng ảnh không hợp lệ'), this.translateService.instant('label.notification'));
      return false;
    }
    this.userSignature = event.target.files[0];
    this.nameSignatureTemp = this.userSignature.name;
  }

  doUploadFile() {
    return this.uploadFileService.uploadFile(this.userAvatar).subscribe(
      event => {
        console.log('upload done');
      });
  }

  doSelectFiles(event) {
    console.log(event)
    if (!this.uploadFileService.doCheckFileExtensionImage(event.target.files)) {
      this.toastr.error(this.translateService.instant('Định dạng ảnh không hợp lệ'), this.translateService.instant('label.notification'));
      return false;
    }

    if (!this.doCheckFilesSize(event.target.files[0])) {
      this.toastr.error(this.translateService.instant('Dung lượng ảnh không hợp lệ'), this.translateService.instant('label.notification'));
      return false;
    }
    this.userAvatar = event.target.files[0];
    this.nameAvatarTemp = this.userAvatar.name;
  }

  doCheckFilesSize(file): boolean {
    if (file && file.size <= Constant.MAX_SIZE_FILE_UPLOAD) return true;
    return false;
  }

  doValidate() {
    if (!this.user.fullName) {
      this.toastr.error(this.translateService.instant('Đề nghị nhập thông tin họ và tên'), this.translateService.instant('label.notification'));
      return false;
    }
    if (!this.user.userName) {
      this.toastr.error(this.translateService.instant('Đề nghị nhập thông tin tên đăng nhập'), this.translateService.instant('label.notification'));
      return false;
    }
    if (!this.user.position) {
      this.toastr.error(this.translateService.instant('Đề nghị lựa chọn chức danh cá nhân'), this.translateService.instant('label.notification'));
      return false;
    }
    if (!this.orgModel || !this.orgModel.length) {
      this.toastr.error(this.translateService.instant('Đề nghị lựa chọn đơn vị'), this.translateService.instant('label.notification'));
      return false;
    } else {
      this.user.org = parseInt(this.orgModel[0]);
    }
    return true;
  }

  doSave() {
    console.log(this.user)
    if (!this.doValidate()) {
      return;
    }
    this.user.birthday = this.dateTimeService.getDateCalendar(this.user.birthday_tmp);
    if (this.user.id > 0) {
      this.userService.updateUser(this.user).subscribe(data => {
          let userInfo = JSON.parse(this.tokenService.getUserInfo());
          if (userInfo.id == data.data.id) {
            this.tokenService.setUserInfo(JSON.stringify(data.data));
          }
          this.toastr.success('Cập nhật thông tin người dùng', 'Thành công!');
          
        },
        error => {
          this.toastr.error('Cập nhật thông tin người dùng!', 'Lỗi!');
        });
    } else {
      this.userService.addUser(this.user).subscribe(data => {
        this.toastr.success('Thêm mới người dùng', 'Thành công!');
        
      });
    }
  }

  
  @HostListener('window:popstate', ['$event'])
  onPopState(event) {
    console.log('Back button pressed');
    
  }
}
