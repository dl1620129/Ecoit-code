import {Routes} from '@angular/router';

import {MasterPageComponent} from './layouts/master-page/master-page.component';
import {AuthenticationComponent} from './component/authentication/authentication.component';
import {NotFoundComponent} from './shared/error/not-found/not-found.component';
import {AuthGuard} from './core/authen/auth-guard';
import { PdfViewComponent } from './shared/pdf-view/pdf-view.component';
import {CasAuthenComponent} from './component/authentication/cas-authen/cas-authen.component';
import { Logout } from './core/authen/logout';


export const Approutes: Routes = [
  {
    path: '',
    component: MasterPageComponent,
    canActivate: [AuthGuard],
    children: [
      {
        path: '',
        loadChildren: './component/dashboard/dashboard.module#DashboardModule'
      },
      {
        path: '',
        loadChildren: './modules/admin/admin.module#AdminModule'
      },
      {
        path: '',
        loadChildren: './modules/operation/operation.module#OperationModule'
      },
      {
        path: '',
        loadChildren: './modules/calendar/calendarfull.module#CalendarfullModule'
      },
      {
        path: '',
        loadChildren: './modules/document/document.module#DocumentModule'
      },
      {
        path: 'pdfView',
        component: PdfViewComponent
      },
    ]
  },
  {
    path: 'login',
    component: AuthenticationComponent
  },
  {
    path: 'authen',
    component: CasAuthenComponent
  },
  {
    path: 'logout',
    component: AuthenticationComponent,
    canActivate: [Logout],
  },
  {
    path: '**',
    component: NotFoundComponent
  }
];
