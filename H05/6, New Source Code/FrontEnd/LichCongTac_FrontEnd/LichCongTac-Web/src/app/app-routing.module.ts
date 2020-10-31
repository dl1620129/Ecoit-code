import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LichCongTacEditorComponent } from './lichcongtac-editor/lichcongtac-editor.component';
import { LichCongTacListComponent } from './lichcongtac-list/lichcongtac-list.component';
import { LichChiTietEditorComponent } from './lichchitiet/lichchitiet-editor.component';
import { LichChiTietListComponent } from './lichchitiet/lichchitiet-list.component';

export const routingComponents = [LichCongTacEditorComponent, LichCongTacListComponent, LichChiTietEditorComponent, LichChiTietListComponent];
const routes: Routes = [
  {
    path: 'lichcongtac-create',
    component: LichCongTacEditorComponent
  },
  {
    path: 'lichcongtac-list',
    component: LichCongTacListComponent
  },
  {
    path: 'lichcongtac-edit/:id',
    component: LichCongTacEditorComponent
  },
  {
    path: 'lichchitiet-edit/:id',
    component: LichChiTietEditorComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
