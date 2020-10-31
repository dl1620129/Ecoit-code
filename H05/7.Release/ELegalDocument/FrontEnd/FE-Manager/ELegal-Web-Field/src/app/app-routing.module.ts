import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FieldListComponent } from './field-list/field-list.component';
import { FieldEditorComponent } from './field-editor/field-editor.component';

export const routingComponents = [FieldEditorComponent, FieldListComponent];
const routes: Routes = [
  {
    path: 'field-create',
    component: FieldEditorComponent
  },
  {
    path: 'field-edit/:id',
    component: FieldEditorComponent
  },
  {
    path: 'field-list',
    component: FieldListComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true, onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
