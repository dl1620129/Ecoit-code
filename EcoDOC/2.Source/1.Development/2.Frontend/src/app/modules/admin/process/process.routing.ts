import {Routes} from '@angular/router';
import { ProcessEditComponent } from "./process-edit/process-edit.component";
import { ProcessListComponent } from "./process-list/process-list.component";
import { ProcessConfigComponent } from "./process-config/process-config.component";

export const ProcessRouting: Routes = [
  {
    path: 'process',
    children: [
      {
        path: 'edit/:processId',
        component: ProcessEditComponent,
        data: {
          title: 'Cấu Hình Luồng',
          urls: [
            {title: 'Quản Trị Luồng', url: '/admin'},
            {title: 'Quản Lý Luồng'}
          ]
        }
      },
     
      {
        path: '',
        component: ProcessListComponent,
        data: {
          title: 'Cấu Hình Luồng',
          urls: [
            {title: 'Bảng điều khiển', url: '/admin'},
            {title: 'Danh Sách Luồng'}
          ]
        }
      },
      {
        path: 'config/:processId',
        component: ProcessConfigComponent,
        data: {
          title: 'Cấu Hình Luồng',
          urls: [
            {title: 'Bảng điều khiển', url: '/admin'},
            {title: 'Danh sách luồng', url: '/process'},
            {title: 'Cấu Hình Luồng'}
          ]
        }
      }
    ]
  }
];
