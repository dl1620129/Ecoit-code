import {Routes} from '@angular/router';

import {ModuleComponent} from "./module/module.component";
import {RoleComponent} from './role/role.component';

export const OperationRoute: Routes = [
  {
    path: '',
    children: [
      // {
      //   path: 'role',
      //   component: RoleComponent,
      //   data: {
      //     title: 'Quản lý vai trò',
      //     urls: [
      //       {title: 'Bảng điều khiển', url: '/'},
      //       {title: 'Quản lý vai trò'}
      //     ]
      //   }
      // },
      {
        path: 'module',
        component: ModuleComponent,
        data: {
          title: 'Quản lý chức năng',
          urls: [
            {title: 'Bảng điều khiển', url: '/'},
            {title: 'Quản lý chức năng'}
          ]
        }
      }
    ]
  }
];
