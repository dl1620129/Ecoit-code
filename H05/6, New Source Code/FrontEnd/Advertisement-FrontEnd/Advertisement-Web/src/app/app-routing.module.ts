import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdvertisementListComponent } from './advertisement-list/advertisement-list.component';
import { AdvertisementEditorComponent } from './advertisement-editor/advertisement-editor.component';

export const routingComponents = [AdvertisementEditorComponent, AdvertisementListComponent];
const routes: Routes = [
  {
    path: 'advertisement-create',
    component: AdvertisementEditorComponent
  },
  {
    path: 'advertisement-edit/:id',
    component: AdvertisementEditorComponent
  },
  {
    path: 'advertisement-list',
    component: AdvertisementListComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true, onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
