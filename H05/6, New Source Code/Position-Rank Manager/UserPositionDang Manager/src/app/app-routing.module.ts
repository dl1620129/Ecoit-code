import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PositionDangComponent } from './position-list/position-list.component';
import { PositionDangEditorConponent } from './position-editor/position-editor.component';

export const routingComponents= [PositionDangComponent,PositionDangEditorConponent];

const routes: Routes = [
	{path: '', redirectTo: 'list', pathMatch: 'full'},
	{path: 'create', component: PositionDangEditorConponent},
  {path: 'list', component: PositionDangComponent},
  {path: 'view/:id', component: PositionDangEditorConponent}
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
