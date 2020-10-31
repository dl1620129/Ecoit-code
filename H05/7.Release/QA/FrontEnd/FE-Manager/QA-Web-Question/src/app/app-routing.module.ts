import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { QuestionEditorComponent } from './question-editor/question-editor.component';
import { QuestionListComponent } from './question-list/question-list.component';

export const routingComponents = [QuestionEditorComponent, QuestionListComponent];
const routes: Routes = [
  {
    path: 'question-create',
    component: QuestionEditorComponent
  },
  {
    path: 'question-list',
    component: QuestionListComponent
  },
  {
    path: 'question-edit/:id',
    component: QuestionEditorComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
