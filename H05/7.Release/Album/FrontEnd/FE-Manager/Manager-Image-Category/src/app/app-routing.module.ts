import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {  CategoryComponent } from './category-list/category-list.component';
import {  CategoryEditorComponent } from './category-editor/category-editor.component';
import { ImageEditorComponent } from './image/image-editor.component';

export const routingComponents= [CategoryComponent,CategoryEditorComponent,ImageEditorComponent];

const routes: Routes = [
	{path: '', redirectTo: 'list', pathMatch: 'full'},
	{path: 'create', component: CategoryEditorComponent},
  {path: 'list', component: CategoryComponent},
  {path: 'view/:id', component: CategoryEditorComponent},
  {path: 'view/image/:id', component: ImageEditorComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
