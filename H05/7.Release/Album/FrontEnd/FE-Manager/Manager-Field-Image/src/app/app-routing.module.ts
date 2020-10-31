import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LinhVucComponent } from './linhvuc-list/linhvuc-list.component';
import { LinhVucEditorComponent } from './linhvuc-editor/linhvuc-editor.component';

export const routingComponents= [LinhVucComponent,LinhVucEditorComponent];

const routes: Routes = [
	{path: '', redirectTo: 'list', pathMatch: 'full'},
	{path: 'create', component: LinhVucEditorComponent},
  {path: 'list', component: LinhVucComponent},
  {path: 'view/:id', component: LinhVucEditorComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
