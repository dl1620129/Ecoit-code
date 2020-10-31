import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LinksComponent } from './link-list/links.component';
import { LinksEditorComponent } from './link-editor/links-editor.component';

export const routingComponents= [LinksComponent,LinksEditorComponent];

const routes: Routes = [
	{path: '', redirectTo: 'list', pathMatch: 'full'},
	{path: 'create', component: LinksEditorComponent},
  {path: 'list', component: LinksComponent},
  {path: 'view/:id', component: LinksEditorComponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
