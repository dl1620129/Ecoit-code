import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Article } from '../class/article';

@Component({
  selector: 'ngbd-modal-confirm',
  template: `
  <div class="modal-header">
    <h5 class="modal-title">Xem trước bài viết</h5>
    <button type="button" class="close" (click)="modal.dismiss()" aria-label="Close">
      <span aria-hidden="true">&times;</span>
    </button>
  </div>
  <div class="body-container">
    <div class="modal-body">
      <h5 class="text-break">{{article.title}}</h5>
      <span class="date-article-text">{{today | date: 'dd/MM/yyyy hh:mm:ss'}}</span>
      <p class="summary-article-text text-break">{{article.summary}}</p>
      <p class="text-break" [innerHTML]="article.content"></p>
      <b class="float-right">{{article.author}}</b>
    </div>
  </div>
  `
})
export class PreviewModalComponent {
  article: Article;
  today = new Date();
  constructor(public modal: NgbActiveModal) {}
}