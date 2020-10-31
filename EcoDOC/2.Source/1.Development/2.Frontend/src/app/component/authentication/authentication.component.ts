import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {MasterPageComponent} from '../../layouts/master-page/master-page.component';
import {NotFoundComponent} from '../../shared/error/not-found/not-found.component';
import { TokenService } from 'src/app/core/authen/token.service';
import { AuthGuard } from 'src/app/core/authen/auth-guard';
import { Logout } from 'src/app/core/authen/logout';
import {NgbCarouselConfig} from '@ng-bootstrap/ng-bootstrap';
import { TokenInfoService } from 'src/app/services/tokeninfo.service';
import { CommonUtils } from 'src/app/core/common/common-utils';
import { TranslateService } from '@ngx-translate/core';
import { ToastrService } from 'ngx-toastr';


@Component({
  selector: 'app-authentication',
  templateUrl: './authentication.component.html',
  styleUrls: ['./authentication.component.css'],
})
export class AuthenticationComponent implements OnInit {

  showNavigationArrows = false;
  showNavigationIndicators = false;

  constructor(private router: Router, 
              private tokenService: TokenService,
              config: NgbCarouselConfig, 
              private tokenInfoService: TokenInfoService,
              private commonUtils: CommonUtils,
              private toastr: ToastrService,
              private translateService: TranslateService
    ) {
      config.showNavigationArrows = true;
      config.showNavigationIndicators = true;
  }

  loading = false;
  error: string;
  loginForm = new FormGroup({
    userName: new FormControl(''),
    password: new FormControl(''),
  });
  
  
  doLogin() {
    // TODO: Use EventEmitter with form value
    console.warn(this.loginForm.value);
    this.loading = true;
    this.tokenService.requestToken(this.loginForm.controls.userName.value, this.loginForm.controls.password.value).subscribe(
      data => {
        this.tokenService.setToken(data.data.tokenInfo.accessToken);
        this.tokenService.setUserInfo(JSON.stringify(data.data.userInfo));
        this.tokenService.setModule(JSON.stringify(data.data.userInfo.authorize), data.data.moduleList);
        this.tokenService.getCurrentRoleName(this.tokenService.getLocalDefaultRole());
        this.tokenService.requestTickets().subscribe(ticket => {
          this.tokenService.setTickets(ticket.id)
        });
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
        console.log('Login sucessed!!!');
        this.router.navigate(['/']);
      },
      error => {
        this.error = error;
        this.loading = false;
        console.log('Login failed!!! error == ', error);
      });
  }

  // tslint:disable-next-line: member-ordering
  loginform = false;
  // tslint:disable-next-line: member-ordering
  recoverform = false;

  showRecoverForm() {
    this.loginform = !this.loginform;
    this.recoverform = !this.recoverform;
  }

  ngOnInit(): void {
  }

  loginCA(){
    let serialNumber = "";
    this.tokenInfoService.getTokenInfo((data) => {
      if (data == ""){
        this.commonUtils.showPopupOK("Lỗi khi lấy thông tin chứng thư số");
      }else if (data == '-100') {
        this.commonUtils.showPopupOK(this.translateService.instant('signature.sign-no-connect'));
      }else {
        let tokenInfo = JSON.parse(this.tokenInfoService.b64DecodeUnicode(data));
        serialNumber = tokenInfo.SerialNumber;
        this.doLoginCA(serialNumber);
      }
    })
  }
  
  doLoginCA(serialNumber) {
    this.tokenInfoService.LoginBySerial(serialNumber).subscribe(data => {
      console.log(data)
      if (data.userInfo.serialToken !== serialNumber) {
        this.toastr.error("Lỗi", "Bạn dùng không đúng chứng thư số");
        return;
      }
      this.tokenService.setToken(data.tokenInfo.accessToken);
      this.tokenService.setUserInfo(JSON.stringify(data.userInfo));
      this.tokenService.setModule(JSON.stringify(data.userInfo.authorize), data.moduleList);
      this.tokenService.getCurrentRoleName(this.tokenService.getLocalDefaultRole());
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
    })

    
    // TODO: Use EventEmitter with form value
    // console.log(this.loginForm.value);
    // this.loading = true;
    // this.tokenService.requestToken(this.loginForm.controls.userName.value, this.loginForm.controls.password.value).subscribe(
    //   data => {
    //     console.log(data)
    //     if (data.data.userInfo.serialToken !== serialNumber) {
    //       this.toastr.error("Lỗi", "Bạn dùng không đúng chứng thư số");
    //       return;
    //     }
        
    //     this.tokenService.setToken(data.data.tokenInfo.accessToken);
    //     this.tokenService.setUserInfo(JSON.stringify(data.data.userInfo));
    //     this.tokenService.setModule(JSON.stringify(data.data.userInfo.authorize), data.data.moduleList);
    //     this.tokenService.getCurrentRoleName(this.tokenService.getLocalDefaultRole());
    //     this.router.resetConfig([{
    //       path: '',
    //       component: MasterPageComponent,
    //       canActivate: [AuthGuard],
    //       children: this.tokenService.initiateRouter()
    //     },
    //       {
    //         path: 'login',
    //         component: AuthenticationComponent
    //       },
    //       {
    //         path: 'logout',
    //         component: AuthenticationComponent,
    //         canActivate: [Logout],
    //       },
    //       {
    //         path: '**',
    //         component: NotFoundComponent
    //       }]);
    //     console.log('Login sucessed!!!'); 
    //     this.router.navigate(['/']);
    //   },
    //   error => {
    //     this.error = error;
    //     this.loading = false;
    //     console.log('Login failed!!! error ==', error);
    //   });
  }
}
