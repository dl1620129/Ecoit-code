import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClipEditorComponent } from './clip-editor/clip-editor.component';
import { ClipComponent } from './clip-list/clip-list.component';

export const routingComponents= [ClipComponent,ClipEditorComponent];

const routes: Routes = [
	{path: '', redirectTo: 'list', pathMatch: 'full'},
	{path: 'create', component: ClipEditorComponent},
  {path: 'list', component: ClipComponent},
  {path: 'view/:id', component: ClipEditorComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
