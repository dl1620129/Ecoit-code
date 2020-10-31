import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UnitListComponent } from './unit-list/unit-list.component';
import { UnitEditorComponent } from './unit-editor/unit-editor.component';

export const routingComponents = [UnitEditorComponent, UnitListComponent];
const routes: Routes = [
  {
    path: 'unit-create',
    component: UnitEditorComponent
  },
  {
    path: 'unit-edit/:id',
    component: UnitEditorComponent
  },
  {
    path: 'unit-list',
    component: UnitListComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true, onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
