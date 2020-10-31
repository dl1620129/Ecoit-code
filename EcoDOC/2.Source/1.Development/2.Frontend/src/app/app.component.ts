import {Component, OnDestroy} from '@angular/core';
import {Router, NavigationStart, NavigationEnd, NavigationCancel, NavigationError} from '@angular/router';
import {SlimLoadingBarService} from 'ng2-slim-loading-bar';
import {AuthenticationComponent} from './component/authentication/authentication.component';
import {NotFoundComponent} from './shared/error/not-found/not-found.component';
import {MasterPageComponent} from './layouts/master-page/master-page.component';
import {TokenService} from './core/authen/token.service';
import {AuthGuard} from './core/authen/auth-guard';
import {TranslateService} from '@ngx-translate/core';
import {CasAuthenComponent} from './component/authentication/cas-authen/cas-authen.component';
import { Logout } from './core/authen/logout';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnDestroy {
  private sub: any;

  constructor(private slimLoader: SlimLoadingBarService,
              private router: Router,
              private tokenService: TokenService,
              private translate: TranslateService) {

    /*add locale translate*/
    translate.setDefaultLang('vi');

    this.sub = this.router.events.subscribe(event => {
      if (event instanceof NavigationStart) {
        this.slimLoader.start();
      } else if (event instanceof NavigationEnd ||
        event instanceof NavigationCancel ||
        event instanceof NavigationError) {
        this.slimLoader.complete();
      }
    }, (error: any) => {
      this.slimLoader.complete();
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
        path: 'authen',
        component: CasAuthenComponent
      },
      {
        path: '**',
        component: NotFoundComponent
      }]);
  }

  ngOnDestroy(): any {
    this.sub.unsubscribe();
  }
}
