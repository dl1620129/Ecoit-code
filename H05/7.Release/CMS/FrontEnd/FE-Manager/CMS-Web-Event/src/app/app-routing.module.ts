import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EventListComponent } from './event-list/event-list.component';
import { EventEditorComponent } from './event-editor/event-editor.component';

export const routingComponents = [EventEditorComponent, EventListComponent];
const routes: Routes = [
  {
    path: 'event-create',
    component: EventEditorComponent
  },
  {
    path: 'event-edit/:id',
    component: EventEditorComponent
  },
  {
    path: 'event-list',
    component: EventListComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true, onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
