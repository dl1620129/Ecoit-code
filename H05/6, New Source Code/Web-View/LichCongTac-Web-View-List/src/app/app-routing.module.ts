import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LichTuanComponent } from './lichcongtac/lichtuan.component';
import { LichNgayComponent } from './lichcongtac/lichngay.component';
import { LichThangComponent } from './lichcongtac/lichthang.component';

export const routingComponents = [LichTuanComponent, LichNgayComponent, LichThangComponent];
const routes: Routes = [
  {
    path: 'lichtuan',
    component: LichTuanComponent
  },
  {
    path: 'lichngay',
    component: LichNgayComponent
  },
  {
    path: 'lichchitiet/:inputdate',
    component: LichNgayComponent
  },
  {
    path: 'lichthang',
    component: LichThangComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }