import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DocumentEditorComponent } from './document-editor/document-editor.component';
import { DocumentListComponent } from './document-list/document-list.component';
import { SuggestionEditorComponent } from './suggestion-editor/suggestion-editor.component';

export const routingComponents = [DocumentEditorComponent, DocumentListComponent, SuggestionEditorComponent];
const routes: Routes = [
  {
    path: 'document-create',
    component: DocumentEditorComponent
  },
  {
    path: 'document-list',
    component: DocumentListComponent
  },
  {
    path: 'document-edit/:id',
    component: DocumentEditorComponent
  },
  {
    path: 'suggestion-edit/:sugId/:docId',
    component: SuggestionEditorComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
