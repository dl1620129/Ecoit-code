import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ChucDanhComponent } from './position-list/position-list.component';
import { ChucDanhEditorComponent } from './position-editor/position-editor.component';

export const routingComponents= [ChucDanhComponent,ChucDanhEditorComponent];

const routes: Routes = [
	{path: '', redirectTo: 'list', pathMatch: 'full'},
	{path: 'create', component: ChucDanhEditorComponent},
  {path: 'list', component: ChucDanhComponent},
  {path: 'view/:id', component: ChucDanhEditorComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
