import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PermissionListComponent } from './permission/permission-list/permission-list.component';
import { PermissionEditorComponent } from './permission/permission-editor/permission-editor.component';
export const routingComponents= [PermissionListComponent, PermissionEditorComponent];

const routes: Routes = [
	{path: '', redirectTo: 'permission-list', pathMatch: 'full'},
	{path: 'permission-create', component: PermissionEditorComponent},
  {path: 'permission-list', component: PermissionListComponent},
  {path: 'permission-edit/:id', component: PermissionEditorComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
