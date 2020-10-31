import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { OrganizationListComponent } from './organization-list/organization-list.component';
import { OrganizationEditorComponent } from './organization-editor/organization-editor.component';

export const routingComponents = [OrganizationEditorComponent, OrganizationListComponent];
const routes: Routes = [
  {
    path: 'organization-create',
    component: OrganizationEditorComponent
  },
  {
    path: 'organization-edit/:id',
    component: OrganizationEditorComponent
  },
  {
    path: 'organization-list',
    component: OrganizationListComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true, onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
