import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { permissionsComponent } from './permissions/permission-list/permissions.component';
import { childComponent } from './permissions/child/child.component';
export const routingComponents= [permissionsComponent,childComponent];

const routes: Routes = [
	{path: '', redirectTo: 'list', pathMatch: 'full'},
	{path: 'create', component: childComponent},
  {path: 'list', component: permissionsComponent},
  {path: 'view/:id', component: childComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
