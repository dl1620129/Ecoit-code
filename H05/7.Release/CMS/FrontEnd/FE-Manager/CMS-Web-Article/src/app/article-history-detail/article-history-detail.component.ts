import { Component, OnInit, Input } from '@angular/core';
import { ArticleService } from '../service/article.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Constants } from '../common/constants';
import { ArticleHistoryService } from '../service/article-history.service';
import { Router, ActivatedRoute } from '@angular/router';
import { NotifierService } from 'angular-notifier';

declare const Liferay: any;

@Component({
    selector: 'app-article-detail-list',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + 
    '/o/CMS-Web-Article/app/article-history/article-history-detail.component.html',
    styleUrls: [],
    providers: [],
})
export class ArticleHistoryDetailComponent implements OnInit {

    constructor(private articleHistoryService: ArticleHistoryService,
        private modalService: NgbModal,
        private routes: ActivatedRoute,
        private router: Router,
        private notifierService: NotifierService) { }

    articleId: any;
    articleHistoryId: any;
    oldDetailArticle: any = {};
    currentDetailArticle: any = {};
    ngOnInit() {
        this.routes.paramMap.subscribe(params => {
            if (params.get('historyId') && params.get('articleId')) {
                this.articleHistoryId = params.get('historyId');
                this.articleId = params.get('articleId');
                console.log(params);
                this.articleHistoryService.getArticleHistory(this.articleHistoryId).subscribe((response: any) => {
                    console.log(response);
                    if (response.error_code == Constants.SUCCESSFUL_CODE) {
                        this.oldDetailArticle = response.data.history;
                        this.currentDetailArticle = response.data.current;
                    } else {
                        this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
                    }
                });
            }
        });
    }

    showZoomModal(content: any) {
        let modal = this.modalService.open(content, { size: "lg", centered: true, windowClass: 'no-box-shadow modal-extra-large' });
    }

    openedModal: any;
    openReviveHistoryModal(content: any) {
        this.openedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow'});
    }

    reviveArticleHistory() {
        this.articleHistoryService.reviveArticleHistory(this.articleHistoryId, this.articleId).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.openedModal.close();
                this.router.navigate(['/article-edit', this.articleId]);
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }
}