import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ReportEditorComponent } from './report-editor/report-editor.component';
import { ReportListComponent } from './report-list/report-list.component';

export const routingComponents = [ReportEditorComponent, ReportListComponent];
const routes: Routes = [
  {
    path: 'report-create',
    component: ReportEditorComponent
  },
  {
    path: 'report-list',
    component: ReportListComponent
  },
  {
    path: 'report-edit/:id',
    component: ReportEditorComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
