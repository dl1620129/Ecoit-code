import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TagListComponent } from './tag-list/tag-list.component';
import { TagEditorComponent } from './tag-editor/tag-editor.component';

export const routingComponents = [TagEditorComponent, TagListComponent];
const routes: Routes = [
  {
    path: 'tag-create',
    component: TagEditorComponent
  },
  {
    path: 'tag-edit/:id',
    component: TagEditorComponent
  },
  {
    path: 'tag-list',
    component: TagListComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true, onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
