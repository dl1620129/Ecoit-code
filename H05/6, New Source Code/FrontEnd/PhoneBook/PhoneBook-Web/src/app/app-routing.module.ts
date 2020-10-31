import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PhonebookListComponent } from './phonebook-list/phonebook-list.component';
import { PhonebookEditorComponent } from './phonebook-editor/phonebook-editor.component';

export const routingComponents = [PhonebookEditorComponent, PhonebookListComponent];
const routes: Routes = [
  {
    path: 'user-create',
    component: PhonebookEditorComponent
  }
  /*{
    path: 'user-edit/:id',
    component: PhonebookEditorComponent
  },
  {
    path: 'user-list',
    component: PhonebookListComponent
  }*/
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true, onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
