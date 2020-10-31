import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsersEditorComponent } from './users-editor/user-editor.component';
import { UsersComponent } from './user-list/user-list.component';
export const routingComponents= [UsersComponent,UsersEditorComponent];

const routes: Routes = [
	{path: '', redirectTo: 'list', pathMatch: 'full'},
	{path: 'create', component: UsersEditorComponent},
  {path: 'list', component: UsersComponent},
  {path: 'view/:screenname', component: UsersEditorComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
