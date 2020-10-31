import {NgModule} from '@angular/core';
import {RouterModule} from '@angular/router';
import {OperationRoute} from './operation.routing';
import {PermissionComponent} from './permission/permission.component';
import {ModuleComponent} from './module/module.component';
import {CommonModule} from "@angular/common";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {FormsModule} from "@angular/forms";
import {NgMultiSelectDropDownModule} from "ng-multiselect-dropdown";
import {TranslateModule} from "@ngx-translate/core";
import { SharedModule } from '../shared/shared.module';
import {NgxPaginationModule} from "ngx-pagination";
import { TreeViewModule } from '@syncfusion/ej2-angular-navigations';

@NgModule({
  declarations: [
    PermissionComponent,
    ModuleComponent
  ],
    imports: [
        RouterModule.forChild(OperationRoute),
        CommonModule,
        NgbModule,
        FormsModule,
        NgMultiSelectDropDownModule,
        TranslateModule,
        SharedModule,
        NgxPaginationModule,
        TreeViewModule
    ]
})
export class OperationModule {
}
