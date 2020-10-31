import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ConfigListComponent } from './config-list/config-list.component';
import { ConfigEditorComponent } from './config-editor/config-editor.component';

export const routingComponents = [ConfigEditorComponent, ConfigListComponent];
const routes: Routes = [
  {
    path: 'config-create',
    component: ConfigEditorComponent
  },
  {
    path: 'config-edit/:id',
    component: ConfigEditorComponent
  },
  {
    path: 'config-list',
    component: ConfigListComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true, onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
