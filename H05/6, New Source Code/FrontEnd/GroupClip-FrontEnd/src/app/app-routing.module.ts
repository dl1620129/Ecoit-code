import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GroupClipComponent } from './groupclip-list/groupclip-list.component';
import { GroupClipEditorComponent } from './groupclip-editor/groupclip-editor.component';

export const routingComponents= [GroupClipComponent,GroupClipEditorComponent];

const routes: Routes = [
	{path: '', redirectTo: 'list', pathMatch: 'full'},
	{path: 'create', component: GroupClipEditorComponent},
  {path: 'list', component: GroupClipComponent},
  {path: 'view/:id', component: GroupClipEditorComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
