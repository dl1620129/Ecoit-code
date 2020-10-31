import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OrganizationComponent } from './organization-list/organization-list.component';
import { OrganizationEditorComponent } from './organization-editor/organization-editor.component';

export const routingComponents = [OrganizationComponent, OrganizationEditorComponent];
const routes: Routes = [
	{path: '', redirectTo: 'list', pathMatch: 'full'},
	{path: 'create', component: OrganizationEditorComponent},
  {path: 'list', component: OrganizationComponent},
  {path: 'view/:id', component: OrganizationEditorComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true, onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
