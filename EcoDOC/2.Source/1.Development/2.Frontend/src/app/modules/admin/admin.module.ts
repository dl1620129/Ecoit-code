import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {AdminRoutingModule} from './admin-routing.module';
import {CategoriesComponent} from './categories/categories.component';
import {CategoryComponent} from './categories/category/category.component';
import {CategoryTypeComponent} from './categories/category-type/category-type.component';
import {UsersComponent} from './users/users.component';
import {UserComponent} from './users/components/user/user.component';
import {UserListComponent} from './users/components/user-list/user-list.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {UserEditComponent} from './users/components/user-edit/user-edit.component';
import {
  MatDialogModule,
  MatTableModule,
  MatPaginatorModule,
  MatPaginatorIntl,
  MatSelectModule,
  MatInputModule,
  MatCardModule,
  MatListModule,
  MatIconModule,
  MatSlideToggleModule,
  MatSortModule
} from '@angular/material';
import {OrganizationsComponent} from './organizations/organizations.component';
import {NgxPaginationModule} from 'ngx-pagination';
import {AdminlogComponent} from './systemlog/components/adminlog/adminlog.component';
import {SystemlogComponent} from './systemlog/systemlog.component';
import {DocumentlogComponent} from './systemlog/components/documentlog/documentlog.component';
import {FilterCallbackPipe} from 'src/app/pipes/filter-callback.pipe';
import {FormComponent} from './form/form.component';
import {DndModule} from 'ngx-drag-drop';
import {BusinessLogComponent} from './business-log/business-log.component';
import {PaginationComponent} from './business-log/pagination/pagination.component';
import {DropDownTreeModule} from '@syncfusion/ej2-angular-dropdowns';
import {ProcessModule} from './process/process.module'
import {TreeTableModule} from 'primeng/treetable';
import {AccordionModule} from 'primeng/accordion';
import {TabletreeComponent} from './users/components/tabletree/tabletree.component';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {MaxNumber} from 'src/app/directive/shared/max-number.directive';
import {SharedModule} from '../shared/shared.module';
import {TranslateModule} from '@ngx-translate/core';
import {UserDetailComponent} from './users/components/user-detail/user-detail.component';
import {RoleComponent} from '../operation/role/role.component';
import {TreeViewModule} from '@syncfusion/ej2-angular-navigations';
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {OrderModule} from 'ngx-order-pipe';
import { DelegateflowComponent } from './delegateflow/delegateflow.component';
import { ModuleAdminComponent } from './module-admin/module-admin.component';
import { PreferencesComponent } from './preferences/preferences.component';
import {FormdetailComponent} from './form/components/formdetail/formdetail.component';
import { FormpropertiesComponent } from './form/formproperties/formproperties.component';
@NgModule({
  declarations: [CategoriesComponent,
    CategoryComponent,
    CategoryTypeComponent,
    UsersComponent,
    UserComponent,
    UserListComponent,
    OrganizationsComponent,
    SystemlogComponent,
    AdminlogComponent,
    DocumentlogComponent,
    FilterCallbackPipe,
    FormComponent,
    FormdetailComponent,
    BusinessLogComponent,
    PaginationComponent,
    TabletreeComponent,
    // IndexByPageNumberPipe,
    MaxNumber,
    UserDetailComponent,
    UserEditComponent,
    RoleComponent,
    DelegateflowComponent,
    ModuleAdminComponent,
    PreferencesComponent,
    FormpropertiesComponent,
  ],

  imports: [
    CommonModule,
    FormsModule,
    MatDialogModule,
    MatTableModule,
    AdminRoutingModule,
    NgxPaginationModule,
    MatPaginatorModule,
    MatSelectModule,
    MatInputModule,
    MatCardModule,
    MatSortModule,
    MatSlideToggleModule,
    DndModule,
    DropDownTreeModule,
    TreeTableModule,
    AccordionModule,
    ProcessModule,
    SharedModule,
    TranslateModule,
    ReactiveFormsModule,
    TreeViewModule,
    NgbModule,
    OrderModule
  ],
  entryComponents: [
    UserComponent,
    SystemlogComponent
  ],
  providers: [NgbActiveModal]
})
export class AdminModule {
}
