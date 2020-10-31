import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RankComponent } from './rank-list/rank-list.component';
import { RankkEditorConponent } from './rank-editor/rank-editor.component';

export const routingComponents= [RankComponent,RankkEditorConponent];

const routes: Routes = [
	{path: '', redirectTo: 'list', pathMatch: 'full'},
	{path: 'create', component: RankkEditorConponent},
  {path: 'list', component: RankComponent},
  {path: 'view/:id', component: RankkEditorConponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
