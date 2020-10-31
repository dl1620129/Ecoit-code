import { Routes } from '@angular/router';
import {DashboardComponent} from './dashboard.component';
import {UserEdit} from './dashboard-components/Edit/Edit.component';

export const DashboardRoutes: Routes = [
  {
    path: '',
    children: [
      {
        path: '',
        component: DashboardComponent,
        data: {
          title: 'Bảng điều khiển',
          model: 'user',
          urls: [
            { title: 'Bảng điều khiển', url: 'dashboard' },
            { title: 'Bảng điều khiển' }
          ]
        }
      },
      {
        path: 'edit/:user',
        component: UserEdit,
        data: {
          title: 'Chỉnh sửa thông tin cá nhân',
          model: 'user',
          urls: [
            { title: 'Chỉnh sửa thông tin cá nhân', url: 'dashboard' },
            { title: 'Chỉnh sửa thông tin cá nhân' }
          ]
        }
      },
    ]
  }
];
