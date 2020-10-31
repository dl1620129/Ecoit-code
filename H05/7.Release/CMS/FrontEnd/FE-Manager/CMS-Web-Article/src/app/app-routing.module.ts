import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ArticleEditorComponent } from './article-editor/article-editor.component';
import { ArticleListComponent } from './article-list/article-list.component';
import { ArticleHistoryDetailComponent } from './article-history-detail/article-history-detail.component';

export const routingComponents = [ArticleEditorComponent, ArticleListComponent, ArticleHistoryDetailComponent];
const routes: Routes = [
  {
    path: 'article-create',
    component: ArticleEditorComponent
  },
  {
    path: 'article-list',
    component: ArticleListComponent
  },
  {
    path: 'article-edit/:id',
    component: ArticleEditorComponent
  },
  {
    path: 'article-history-detail/:articleId/:historyId',
    component: ArticleHistoryDetailComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
