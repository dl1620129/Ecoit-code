import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ImageComponent } from './image-list/image-list.component';
import { ImageEditorComponent } from './image-editor/image-editor.component';

export const routingComponents = [ImageComponent, ImageEditorComponent];

const routes: Routes = [
  { path: '', redirectTo: 'list', pathMatch: 'full' },
  { path: 'create', component: ImageEditorComponent },
  { path: 'list', component: ImageComponent },
  { path: 'view/:id', component: ImageEditorComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
