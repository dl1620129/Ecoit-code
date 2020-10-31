import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {CategoriesComponent} from './categories/categories.component';
import {UsersComponent} from './users/users.component';
import {OrganizationsComponent} from './organizations/organizations.component';
import {SystemlogComponent} from './systemlog/systemlog.component';
import {FormComponent} from './form/form.component';
import {BusinessLogComponent} from './business-log/business-log.component';
import {UserDetailComponent} from './users/components/user-detail/user-detail.component';
import { RoleComponent } from '../operation/role/role.component';
import { SubmoduleGuard } from '../../core/authen/submodule-guard';
import {UserEditComponent} from './users/components/user-edit/user-edit.component';
import { DelegateflowComponent } from './delegateflow/delegateflow.component';
import { ModuleAdminComponent } from './module-admin/module-admin.component';
import { PreferencesComponent } from './preferences/preferences.component';
import {FormdetailComponent} from "./form/components/formdetail/formdetail.component";
import { FormpropertiesComponent } from './form/formproperties/formproperties.component';

const routes: Routes = [
  {
    path: '', redirectTo: 'users', pathMatch: 'full'
  },
  {
    path: 'users',
    component: UsersComponent,
    canActivate: [SubmoduleGuard],
    data: {
      title: 'Quản lý người dùng',
      urls: [
        {title: 'Quản trị hệ thống', url: '/admin'},
        {title: 'Quản lý người dùng'}
      ]
    }
  },
  {
    path: 'categories',
    component: CategoriesComponent,
    canActivate: [SubmoduleGuard],
    data: {
      title: 'Quản lý danh mục',
      urls: [
        {title: 'Bảng điều khiển', url: '/'},
        {title: 'Quản lý danh mục'}
      ]
    }
  },
  {
    path: 'module-admin',
    component: ModuleAdminComponent,
    canActivate: [SubmoduleGuard],
    data: {
      title: 'Quản lý module',
      urls: [
        {title: 'Bảng điều khiển', url: '/'},
        {title: 'Quản lý module'}
      ]
    }
  },
  {
    path: 'organizations',
    component: OrganizationsComponent,
    canActivate: [SubmoduleGuard],
    data: {
      title: 'Quản lý đơn vị',
      urls: [
        {title: 'Bảng điều khiển', url: '/'},
        {title: 'Quản lý đơn vị'}
      ]
    }
  },
  {
    path: 'log',
    component: SystemlogComponent,
    canActivate: [SubmoduleGuard],
    data: {
      title: 'Log hệ thống',
      urls: [
        {title: 'Bảng điều khiển', url: '/'},
        {title: 'Quản lý log hệ thống'}
      ]
    }
  },
  {
    path: 'log-business',
    component: BusinessLogComponent,
    canActivate: [SubmoduleGuard],
    data: {
      title: 'Log nghiệp vụ',
      urls: [
        {title: 'Bảng điều khiển', url: '/'},
        {title: 'Log nghiệp vụ'}
      ]
    }
  },
  {
    path: 'form',
    component: FormComponent,
    canActivate: [SubmoduleGuard],
    data: {
      title: 'Thuộc tính Form ',
      urls: [
        {title: 'Bảng điều khiển', url: '/'},
        {title: 'Quản lý thuộc tính form'}
      ]
    }
  },
  {
    path: 'form/:name',
    component: FormdetailComponent,
    canActivate: [SubmoduleGuard],
    data: {
      title: 'Chi tiết form ',
      urls: [
        {title: 'Bảng điều khiển', url: '/'},
        {title: 'Quản lý thuộc tính form'}
      ]
    }
  },
  {
    path: 'form/:name/:properties',
    component: FormpropertiesComponent,
    canActivate: [SubmoduleGuard],
    data: {
      title: 'Thuộc tính form ',
      urls: [
        {title: 'Bảng điều khiển', url: '/'},
        {title: 'Quản lý thuộc tính form'}
      ]
    }
  },
  {
    path: 'users/detail',
    component: UserDetailComponent,
    canActivate: [SubmoduleGuard],
    data: {
      title: 'Thông tin người dùng',
      urls: [
        {title: 'Bảng điều khiển', url: '/'},
        {title: 'Danh sách tài khoản', url: '/users'},
        {title: 'Thông tin người dùng'}
      ]
    }
  },
  {
    path: 'users/edit/:user',
    component: UserEditComponent,
    canActivate: [SubmoduleGuard],
    data: {
      title: 'Thông tin người dùng',
      urls: [
        {title: 'Bảng điều khiển', url: '/'},
        {title: 'Danh sách tài khoản', url: '/users'},
        {title: 'Thông tin người dùng'}
      ]
    }
  },
  {
    path: 'users/detail/:user',
    component: UserDetailComponent,
    canActivate: [SubmoduleGuard],
    data: {
      title: 'Thông tin người dùng',
      urls: [
        {title: 'Bảng điều khiển', url: '/'},
        {title: 'Danh sách tài khoản', url: '/users'},
        {title: 'Thông tin người dùng'}
      ]
    }
  },
  {
    path: 'role',
    component: RoleComponent,
    canActivate: [SubmoduleGuard],
    data: {
      title: 'Quản lý vai trò',
      urls: [
        {title: 'Bảng điều khiển', url: '/'},
        {title: 'Quản lý vai trò'}
      ]
    }
  },
  {
    path: 'delegate_flow',
    component: DelegateflowComponent,
    canActivate: [SubmoduleGuard],
    data: {
      title: 'Quản lý luồng ủy quyền',
      urls: [
        {title: 'Bảng điều khiển', url: '/'},
        {title: 'Quản lý luồng ủy quyền'}
      ]
    }
  },
  {
    path: 'preferences',
    component: PreferencesComponent,
    canActivate: [SubmoduleGuard],
    data: {
      title: 'Cấu hình file tải lên',
      urls: [
        {title: 'Bảng điều khiển', url: '/'},
        {title: 'Cấu hình file tải lên'}
      ]
    }
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule {
}
