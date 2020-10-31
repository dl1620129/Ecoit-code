import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CategoryListComponent } from './category-list/category-list.component';
import { CategoryEditorComponent } from './category-editor/category-editor.component';

export const routingComponents = [CategoryEditorComponent, CategoryListComponent];
const routes: Routes = [
  {
    path: 'category-create',
    component: CategoryEditorComponent
  },
  {
    path: 'category-edit/:id',
    component: CategoryEditorComponent
  },
  {
    path: 'category-list',
    component: CategoryListComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true, onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
