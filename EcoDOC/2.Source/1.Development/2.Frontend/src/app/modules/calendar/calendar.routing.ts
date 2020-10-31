import {Routes} from '@angular/router';
import {CalendarPersonComponent} from "./calendar-person/calendar-person.component";
import { CalendarActionComponent } from './caledar-action/calendar-action.component';
import {CalendarApprovedComponent} from './calendar-approved/calendar-approved.component';
export const CalendarRoute: Routes = [
  {
    path: 'calendar',
    children: [
      {
        path: 'person',
        component: CalendarPersonComponent,
        data: {
          title: 'Lịch cá nhân',
          urls: [
            {title: 'Bảng điều khiển', url: '/'},
            {title: 'Lịch cá nhân'}
          ]
        }
      },
      {
        path: 'department',
        component: CalendarActionComponent,
        data: {
          title: 'Lịch đơn vị',
          urls: [
            {title: 'Bảng điều khiển', url: '/'},
            {title: 'Lịch đơn vị'}
          ]
        }
      },
      {
        path: 'org',
        component: CalendarActionComponent,
        data: {
          title: 'Lịch tổ chức',
          urls: [
            {title: 'Bảng điều khiển', url: '/'},
            {title: 'Lịch tổ chức'}
          ]
        }
      },
      {
        path: 'add',
        component: CalendarActionComponent,
        data: {
          title: 'Thêm mới lịch làm việc',
          urls: [
            {title: 'Bảng điều khiển', url: '/'},
            {title: 'Thêm mới lịch làm việc'}
          ]
        }
      },
      {
        path: 'approved',
        component: CalendarApprovedComponent,
        data: {
          title: 'Phê duyêt lịch làm việc',
          urls: [
            {title: 'Bảng điều khiển', url: '/'},
            {title: 'Phê duyêt lịch làm việc'}
          ]
        }
      }
    ]
  }
];
