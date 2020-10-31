import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {TokenService} from "../../../core/authen/token.service";
import {MasterPageComponent} from "../../../layouts/master-page/master-page.component";
import {AuthGuard} from "../../../core/authen/auth-guard";
import {NotFoundComponent} from "../../../shared/error/not-found/not-found.component";
import {AuthenticationComponent} from '../authentication.component';
import {SharedPreferences} from "../../../core/config/shared-preferences";

@Component({
  selector: 'app-cas-authen',
  templateUrl: './cas-authen.component.html'
})
export class CasAuthenComponent implements OnInit {
  token: string

  constructor(private activatedRoute: ActivatedRoute,
              private tokenService: TokenService,
              private router: Router) {
    SharedPreferences.IS_LOADING_CONTEN = true;
    this.activatedRoute.queryParams.subscribe(params => {
      this.token = params['token'];
      console.log(this.token);
    });
  }

  checkIsLoading() {
    return SharedPreferences.IS_LOADING_CONTEN;
  }

  doGetLoginInfo() {
    this.tokenService.requestLoginInfo(this.token).subscribe(
      data => {
        this.tokenService.setToken(data.data.tokenInfo.accessToken);
        this.tokenService.setUserInfo(JSON.stringify(data.data.userInfo));
        this.tokenService.setModule(JSON.stringify(data.data.userInfo.authorize), data.data.moduleList);
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
            path: '**',
            component: NotFoundComponent
          }]);
        console.log('Login sucessed!!!');
        this.router.navigate(['/']);
      },
      error => {
      });
  }

  ngOnInit() {
    if (this.token != undefined) {
      this.doGetLoginInfo();
    }
  }

}
