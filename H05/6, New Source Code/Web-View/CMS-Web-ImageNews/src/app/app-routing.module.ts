import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListNewComponent } from './lis-new/new-list.component';


const routes: Routes = [
	{path: '', redirectTo: 'list', pathMatch: 'full'},
	{path: 'list', component: ListNewComponent },

  ];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
