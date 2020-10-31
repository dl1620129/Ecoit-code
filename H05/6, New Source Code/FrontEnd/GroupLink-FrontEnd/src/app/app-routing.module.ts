import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GroupLinkComponent } from './grouplink-list/grouplink-list.component';
import { GroupLinkEditorComponent } from './grouplink-editor/grouplink-editor.component';

export const routingComponents= [GroupLinkComponent,GroupLinkEditorComponent];

const routes: Routes = [
	{path: '', redirectTo: 'list', pathMatch: 'full'},
	{path: 'create', component: GroupLinkEditorComponent},
  {path: 'list', component: GroupLinkComponent},
  {path: 'view/:id', component: GroupLinkEditorComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
