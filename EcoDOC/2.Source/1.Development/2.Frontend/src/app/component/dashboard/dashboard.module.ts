import {Component, NgModule, OnInit} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';

import {PerfectScrollbarModule} from 'ngx-perfect-scrollbar';
import {DropDownTreeModule} from '@syncfusion/ej2-angular-dropdowns';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {ChartsModule} from 'ng2-charts';
import {ChartistModule} from 'ng-chartist';
import {NgxChartsModule} from '@swimlane/ngx-charts';
import {NgxDatatableModule} from '@swimlane/ngx-datatable';
import {CalendarModule} from 'angular-calendar';
import {
  DeviceVisitsComponent,
  InfoBoxComponent,
  VisitorsComponent,
} from './dashboard-components';
import {DashboardComponent} from './dashboard.component';
import {DashboardRoutes} from './dashboard.routing';
import {TranslateModule} from '@ngx-translate/core';
import {UserEdit} from './dashboard-components/Edit/Edit.component';


@NgModule({
  imports: [
    FormsModule,
    CommonModule,
    NgbModule,
    ChartsModule,
    ChartistModule,
    RouterModule.forChild(DashboardRoutes),
    PerfectScrollbarModule,
    CalendarModule.forRoot(),
    NgxChartsModule,
    NgxDatatableModule,
    TranslateModule,
    DropDownTreeModule
  ],
  declarations: [
    DeviceVisitsComponent,
    InfoBoxComponent,
    VisitorsComponent,
    DashboardComponent,
    UserEdit
  ]
})
export class DashboardModule {
}
