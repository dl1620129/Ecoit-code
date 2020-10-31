import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {CalendarPersonComponent} from "./calendar-person/calendar-person.component";
import {CalendarDepartmentComponent} from "./calendar-department/calendar-department.component";
import {CalendarOrgComponent} from "./calendar-org/calendar-org.component";
import {CalendarRoute} from "./calendar.routing";
import {CommonModule, DatePipe, DecimalPipe, registerLocaleData} from "@angular/common";
import {CalendarModule} from 'angular-calendar';
import {NgbDatepickerModule, NgbTabsetModule, NgbTimepickerModule, NgbTooltipModule} from '@ng-bootstrap/ng-bootstrap';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {CalendarActionComponent} from './caledar-action/calendar-action.component';
import {TranslateModule} from "@ngx-translate/core";
import {NgMultiSelectDropDownModule} from "ng-multiselect-dropdown";
import {MatInputModule} from "@angular/material/input";
import {MatAutocompleteModule} from "@angular/material/autocomplete";
import localeVi from '@angular/common/locales/vi';
import {OwlDateTimeModule} from "ng-pick-datetime";
import { CalendarApprovedComponent } from './calendar-approved/calendar-approved.component';

registerLocaleData(localeVi);

@NgModule({
  declarations: [
    CalendarPersonComponent,
    CalendarDepartmentComponent,
    CalendarOrgComponent,
    CalendarActionComponent,
    CalendarApprovedComponent
  ],
  imports: [
    RouterModule.forChild(CalendarRoute),
    CommonModule,
    CalendarModule.forRoot(),
    NgbTooltipModule,
    FormsModule,
    TranslateModule,
    NgMultiSelectDropDownModule,
    MatInputModule,
    MatAutocompleteModule,
    ReactiveFormsModule,
    NgbTimepickerModule,
    NgbDatepickerModule,
    OwlDateTimeModule,
    NgbTabsetModule
  ], providers: [
    DecimalPipe,
    DatePipe
  ]
})

export class CalendarfullModule {
}
