import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignerListComponent } from './signer-list/signer-list.component';
import { SignerEditorComponent } from './signer-editor/signer-editor.component';

export const routingComponents = [SignerEditorComponent, SignerListComponent];
const routes: Routes = [
  {
    path: 'signer-create',
    component: SignerEditorComponent
  },
  {
    path: 'signer-edit/:id',
    component: SignerEditorComponent
  },
  {
    path: 'signer-list',
    component: SignerListComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true, onSameUrlNavigation: 'reload'})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
