import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TypeListComponent } from './type-list/type-list.component';
import { TypeEditorComponent } from './type-editor/type-editor.component';

export const routingComponents = [TypeEditorComponent, TypeListComponent];
const routes: Routes = [
  {
    path: 'type-create',
    component: TypeEditorComponent
  },
  {
    path: 'type-edit/:id',
    component: TypeEditorComponent
  },
  {
    path: 'type-list',
    component: TypeListComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true, onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
