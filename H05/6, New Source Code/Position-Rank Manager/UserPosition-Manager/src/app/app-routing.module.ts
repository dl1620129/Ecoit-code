import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PositionComponent } from './position-list/position-list.component';
import { PositionEditorConponent } from './position-editor/position-editor.component';

export const routingComponents= [PositionComponent,PositionEditorConponent];

const routes: Routes = [
	{path: '', redirectTo: 'list', pathMatch: 'full'},
	{path: 'create', component: PositionEditorConponent},
  {path: 'list', component: PositionComponent},
  {path: 'view/:id', component: PositionEditorConponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
