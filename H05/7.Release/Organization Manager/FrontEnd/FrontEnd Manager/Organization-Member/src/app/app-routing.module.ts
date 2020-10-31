import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MemberComponent } from './member-list/member-list.component';
import { MemberEditorComponent } from './member-editor/member-editor.component';

export const routingComponents= [MemberComponent,MemberEditorComponent];

const routes: Routes = [
	{path: '', redirectTo: 'list', pathMatch: 'full'},
	{path: 'create', component: MemberEditorComponent},
  {path: 'list', component: MemberComponent},
  {path: 'view/:id', component: MemberEditorComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
