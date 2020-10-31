import { Component, OnInit, Input } from '@angular/core';
import { ArticleService } from '../service/article.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Constants } from '../common/constants';
import { ArticleHistoryService } from '../service/article-history.service';
import { NotifierService } from 'angular-notifier';

declare const Liferay: any;

@Component({
    selector: 'app-article-history-list',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + 
    '/o/CMS-Web-Article/app/article-history/article-history-list.component.html',
    styleUrls: [],
    providers: [],
})
export class ArticleHistoryListComponent implements OnInit {

    @Input() articleId: any;

    articlesHistoriesList: any = [];
    articlesHistoriesSize: number;
    articleHistoryPageSize = 10;
    articleHistoryPage = 0;

    constructor(private modalService: NgbModal,
        private articleHistoryService: ArticleHistoryService,
        private notifierService: NotifierService) { }

    ngOnInit() {
        this.getFilteredArticleHistory(0);
    }

    pageHistoryChange(event : any) {
        let start = (event - 1) * this.articleHistoryPageSize;
        this.getFilteredArticleHistory(start);
    }

    getFilteredArticleHistory(start: number) {
        this.articleHistoryService.getArticleHistoriesList(start, this.articleHistoryPageSize, this.articleId).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.articlesHistoriesList = response.data.data;
                this.articlesHistoriesSize = response.data.total;
            }
        });
    }

    //delete history function
    removedArticleHistory: any;
    openedModal: any;
    openDeleteHistoryModal(event: any, content: any) {
        this.removedArticleHistory = event;
        this.openedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow'});
    }
    
    deleteArticleHistory(id: number) {
        this.articleHistoryService.deleteArticleHistory(id).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let start = (this.articleHistoryPage - 1) * this.articleHistoryPageSize;
                    this.getFilteredArticleHistory(start);
                    this.openedModal.close();
                    this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }
}