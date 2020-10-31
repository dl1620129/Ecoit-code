import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListClipComponent } from './clip-new/clip-list.component';


const routes: Routes = [
	{path: '', redirectTo: 'list', pathMatch: 'full'},
	{path: 'list', component: ListClipComponent },

  ];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash:true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
