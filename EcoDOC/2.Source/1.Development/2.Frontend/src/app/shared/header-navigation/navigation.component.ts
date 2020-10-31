import {Component, AfterViewInit, EventEmitter, Output} from '@angular/core';
import {
  NgbModal
} from '@ng-bootstrap/ng-bootstrap';
import {PerfectScrollbarConfigInterface} from 'ngx-perfect-scrollbar';
import {TokenService} from "../../core/authen/token.service";
import {Router} from "@angular/router";
import { User } from 'src/app/core/model/domain/user';
import { NotificationService } from 'src/app/services/notification.service';
import { PermissionService } from 'src/app/services/permission.service';
import {MasterPageComponent} from '../../layouts/master-page/master-page.component';
import {NotFoundComponent} from '../../shared/error/not-found/not-found.component';
import { AuthenticationComponent } from 'src/app/component/authentication/authentication.component';
import { AuthGuard } from 'src/app/core/authen/auth-guard';
import { SharedPreferences } from 'src/app/core/config/shared-preferences';
import { SharedService } from 'src/app/services/shared.service';
import { Constant } from 'src/app/core/config/constant';
import { ToastrService } from 'ngx-toastr';
import { Logout } from 'src/app/core/authen/logout';
import { UserService } from 'src/app/services/user.service';
// import { DatePipe } from '@angular/common';

declare var $: any;

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements AfterViewInit {
  @Output() toggleSidebar = new EventEmitter<void>();

  public config: PerfectScrollbarConfigInterface = {};
  userLogin: User;
  public showSearch = false;
  portalUrl = Constant.PORTAL_URL
  emailUrl = Constant.EMAIL_URL
  authArr;
  listNot;
  // unReadNot: any;
  roles: any;
  roleList: any;
  moduleList: any;
  defaultRole: any;

  constructor(
    private modalService: NgbModal,
    private tokenService: TokenService,
    private router: Router,
    public notificationService: NotificationService,
    private permissionService: PermissionService,
    private shareService: SharedService,
    private toastr: ToastrService,
    private userService: UserService
    ) {}

  ngOnInit() {
    this.userLogin = JSON.parse(this.tokenService.getUserInfo());
    console.log('userLogin : ', this.userLogin);
    this.getListNot();
    this.getRoles();
    this.defaultRole = this.tokenService.getLocalDefaultRole();
    this.tokenService.getCurrentRoleName(this.tokenService.getLocalCurrentRole());
  }

  ngAfterViewInit() {
  }

  logout() {
    this.tokenService.currentRoleName = null;
    this.tokenService.logout();
  }
  checkRoleInNotification(not) {
    if(not.docStatus == 'DA_THU_HOI' || not.docStatus == 'DA_THU_HOI_BH'){
      this.notificationService.updateStatus(not).subscribe(
        data => {
          this.notificationService.countUnreadNotification();
        }
      );
      return;
    }
    this.notificationService.checkRoleInNotification(not.id).subscribe(
      data => {
        console.log('data : ', data);
        if(data.listModule == null) {
          this.gotoSubMenu(not);
        } else {
          this.moduleList = JSON.parse(this.tokenService.getModuleAll());
          this.tokenService.setLocalCurrentRole(data.roleId);
          this.tokenService.getCurrentRoleName(data.roleId);
          this.authArr = data.listModule;
          this.tokenService.setModule( JSON.stringify(this.authArr), this.moduleList);
          this.tokenService.setAuthorize(this.authArr);
          this.router.resetConfig([{
            path: '',
            component: MasterPageComponent,
            canActivate: [AuthGuard],
            children: this.tokenService.initiateRouter()
          },
            {
              path: 'login',
              component: AuthenticationComponent
            },
            {
              path: 'logout',
              component: AuthenticationComponent,
              canActivate: [Logout],
            },
            {
              path: '**',
              component: NotFoundComponent
            }]);
          // this.router.navigate(['/']);
          this.toastr.warning('Bạn đã chuyển sang vai trò ' + this.tokenService.currentRoleName , 'Thông báo');
          this.gotoSubMenu(not);
        }
      }
    );
  }
  gotoSubMenu(not){
    if(not.docType == 'Văn bản đi') {
      switch (not.docStatus) {
        case 'CHO_XU_LY':
          // console.log('goto : ', not.docType, ' - status : ', not.docStatus, ' - docid : ', not.docId);
          this.shareService.setCurrentMenuDocIn(Constant.DOCUMENT_IN_MENU.HANDLE);
          this.shareService.setCurrentTabDocIn('waitHandleTab');
          this.router.navigateByUrl('/document-in/draft-handle/').then(
            () => {
            this.router.navigate(['/document-in/draft-handle/draft-detail/' + not.docId]);
            }
          );
          break;
        case 'CHO_Y_KIEN':
          // console.log('goto : ', not.docType, ' - status : ', not.docStatus, ' - docid : ', not.docId);
          this.shareService.setCurrentMenuDocIn(Constant.DOCUMENT_IN_MENU.HANDLE);
          this.shareService.setCurrentTabDocIn('waitCommentTab');
          this.router.navigateByUrl('/document-in/draft-handle/').then(
            () => {
              // this.router.navigate(['/document-in/draft-handle/draft-detail/' + not.docId]);
              this.router.navigate(['/document-in/draft-handle/draft-detail/' + not.docId], { queryParams: { allowedComment: true } });
            }
          );
          break;
        case 'DA_BAN_HANH':
          // console.log('goto : ', not.docType, ' - status : ', not.docStatus, ' - docid : ', not.docId);
          this.shareService.setCurrentMenuDocIn(Constant.DOCUMENT_IN_MENU.DOC_IN);
          // this.shareService.setCurrentTabDocIn('issued');
          this.router.navigateByUrl('/document-in/list/').then(
            () => {
              this.router.navigate(['/document-in/list/draft-detail/' + not.docId]);
            }
          );
          break;
        case 'CHO_BAN_HANH':
          // console.log('goto : ', not.docType, ' - status : ', not.docStatus, ' - docid : ', not.docId);
          this.shareService.setCurrentMenuDocIn(Constant.DOCUMENT_IN_MENU.ISSUED);
          this.shareService.setCurrentTabDocIn('waitIssued');
          this.router.navigateByUrl('/document-in/draft-issued/').then(
            () => {
              this.router.navigate(['/document-in/draft-issued/issued-detail/' + not.docId]);
            }
          );
          break;
        case 'BI_TRA_LAI':
          // console.log('goto : ', not.docType, ' - status : ', not.docStatus, ' - docid : ', not.docId);
          if(not.moduleCode == 'DRAFT_LIST') {
            this.shareService.setCurrentMenuDocIn(Constant.DOCUMENT_IN_MENU.DRAF);
            this.shareService.setCurrentTabDocIn('draft');
            this.router.navigateByUrl('/document-in/draft-list/').then(
              () => {
                this.router.navigate(['/document-in/draft-list/draft-detail/' + not.docId]);
              }
            );
          } else {
            this.shareService.setCurrentMenuDocIn(Constant.DOCUMENT_IN_MENU.HANDLE);
            this.shareService.setCurrentTabDocIn('waitHandleTab');
            this.router.navigateByUrl('/document-in/draft-handle/').then(
              () => {
              this.router.navigate(['/document-in/draft-handle/draft-detail/' + not.docId]);
              }
            );
          }
          break;
        case 'CHO_XU_LY_UQ':
          // console.log('goto : ', not.docType, ' - status : ', not.docStatus, ' - docid : ', not.docId);
          this.router.navigateByUrl('/delegate/out/').then(
            () => {
              this.router.navigate(['/delegate/out/detail/' + not.docId + '/true']);
            }
          );
          break;
        case 'BI_TRA_LAI_UQ':
          // console.log('goto : ', not.docType, ' - status : ', not.docStatus, ' - docid : ', not.docId);
          this.router.navigateByUrl('/delegate/out/').then(
            () => {
              this.router.navigate(['/delegate/out/detail/' + not.docId + '/true']);
            }
          );
          break;
        default:
          break;
      }
    } else if(not.docType == 'Văn bản đến') {
      switch (not.docStatus) {
        case 'BI_TRA_LAI':
          // console.log('goto : ', not.docType, ' - status : ', not.docStatus, ' - docid : ', not.docId);
          // this.shareService.setCurrentMenuDocIn(Constant.DOCUMENT_IN_MENU.HANDLE);
          // this.shareService.setCurrentTabDocIn('waitCommentTab');
          this.router.navigateByUrl('/document-out/list/').then(
            () => {
            this.router.navigate(['/document-out/list/detail/' + not.docId]);
            }
          );
          break;
        case 'NHAN_DE_BIET':
          // console.log('goto : ', not.docType, ' - status : ', not.docStatus, ' - docid : ', not.docId);
          // this.shareService.setCurrentMenuDocIn(Constant.DOCUMENT_IN_MENU.HANDLE);
          // this.shareService.setCurrentTabDocIn('waitHandleTab');
          this.router.navigateByUrl('/document-out/know/').then(
            () => {
            this.router.navigate(['/document-out/know/detail/' + not.docId]);
            }
          );
          break;
        case 'XU_LY_CHINH':
          // console.log('goto : ', not.docType, ' - status : ', not.docStatus, ' - docid : ', not.docId);
          // this.shareService.setCurrentMenuDocIn(Constant.DOCUMENT_IN_MENU.HANDLE);
          // this.shareService.setCurrentTabDocIn('waitCommentTab');
          this.router.navigateByUrl('/document-out/main/').then(
            () => {
            this.router.navigate(['/document-out/main/detail/' + not.docId]);
            }
          );
          break;
        case 'PHOI_HOP':
          // console.log('goto : ', not.docType, ' - status : ', not.docStatus, ' - docid : ', not.docId);
          // this.shareService.setCurrentMenuDocIn(Constant.DOCUMENT_IN_MENU.DOC_IN);
          // this.shareService.setCurrentTabDocIn('issued');
          this.router.navigateByUrl('/document-out/combine/').then(
            () => {
            this.router.navigate(['/document-out/combine/detail/' + not.docId]);
            }
          );
          break;
        case 'XU_LY_CHINH_UQ':
          this.router.navigateByUrl('/delegate/in/').then(
            () => {
            // this.router.navigate(['/delegate/in/detail/' + not.docId + '/true']);
            this.router.navigate([`/delegate/in/detail/${not.docId}/true`], { queryParams: { tab: 'XU_LY_CHINH', notId: not.id }, });
            this.shareService.setDelegateTab('MAIN_HANDLE');
            }
          );
          break;
        case 'PHOI_HOP_UQ':
          this.router.navigateByUrl('/delegate/in/').then(
            () => {
            // this.router.navigate(['/delegate/in/detail/' + not.docId + '/true']);
            this.router.navigate([`/delegate/in/detail/${not.docId}/true`], { queryParams: { tab: 'XU_LY_PHOI_HOP', notId: not.id }, });
            this.shareService.setDelegateTab('COMBINE_HANDLE');
            }
          );
          break;
        case 'BI_TRA_LAI_UQ':
          this.router.navigateByUrl('/delegate/in/').then(
            () => {
            // this.router.navigate(['/delegate/in/detail/' + not.docId + '/true']);
            this.router.navigate([`/delegate/in/detail/${not.docId}/true`], { queryParams: { tab: 'XU_LY_CHINH', notId: not.id }, });
            this.shareService.setDelegateTab('MAIN_HANDLE');
            }
          );
            break;
        default:
          break;
      }
      // if(not.docId != null) {
      //   this.router.navigateByUrl('/document-out/waiting/').then(
      //     () => {
      //       this.router.navigate(['/document-out/waiting/detail/' + not.docId]);
      //     }
      //   );
      // }
    }
    // this.notificationService.updateStatus(not).subscribe(
    //   data => {
    //     this.getListNot();
    //   }
    // );
  }
  getListNot() {
    this.notificationService.getAllNotification().subscribe(
      data => {
        this.listNot = data.objList;
        // this.unReadNot = data.totalUnread;
        this.notificationService.countUnReadNotification = data.totalUnread;
      }
    );
  }

  getDate(date) {
    const options = {hour12 : true, hour: 'numeric', minute: 'numeric', weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' };
    let temp = new Date(date);
    return temp.toLocaleDateString('vi-VI', options);
  }
  deleteAllNot() {
    this.notificationService.deleteAll().subscribe(
      data => {
        this.getListNot();
      }
    );
  }
  removeNot(not){
    console.log('removeNot : ', not);
    this.notificationService.deleteNotById(not).subscribe(
      data => {
        this.getListNot();
      }
    );
  }
  getRoles() {
    this.roles = JSON.parse(this.tokenService.getUserInfo()).roles;
    if(!this.roleList){
      this.permissionService.getRole().subscribe(data => {
        if (data) {
          this.roleList = data;
        }
      });
    }
  }
  setUserRole(role) {
    if(this.tokenService.getLocalCurrentRole() != role.id) {
      this.moduleList = JSON.parse(this.tokenService.getModuleAll());
      this.tokenService.getAuthorizeByRole(role.id).subscribe(
        data => {
          this.tokenService.setLocalCurrentRole(role.id);
          this.tokenService.getCurrentRoleName(role.id);
          this.authArr = data;
          this.tokenService.setModule( JSON.stringify(this.authArr), this.moduleList);
          this.tokenService.setAuthorize(this.authArr);
          this.toastr.success('Bạn đã chuyển sang vai trò ' + this.tokenService.currentRoleName , 'Thành công');
          this.router.resetConfig([{
            path: '',
            component: MasterPageComponent,
            canActivate: [AuthGuard],
            children: this.tokenService.initiateRouter()
          },
            {
              path: 'login',
              component: AuthenticationComponent
            },
            {
              path: 'logout',
              component: AuthenticationComponent,
              canActivate: [Logout],
            },
            {
              path: '**',
              component: NotFoundComponent
            }]);
          this.router.navigate(['/']);
        }
      );
    }
  }

  setUserDefaultRole(role) {
    this.tokenService.updateDefaultRole(role.id).subscribe(
      data => {
        this.tokenService.setLocalDefaultRole(role.id);
        this.defaultRole = this.tokenService.getLocalDefaultRole();
        this.toastr.success('Thiết lập vai trò mặc định thành công' , 'Thành công');
      }
    );
  }
  openChange(isOpen) {
    if(isOpen) {
      this.getListNot();
    }
  }

  goToCurrentUserEditPageInfor() {
    if (localStorage.userInfo) {
      this.userService.goToEditPageInfo(JSON.parse(localStorage.userInfo).userName, false)
    }
  }

}
