import { Component, OnInit, Inject, LOCALE_ID } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { TagService } from '../service/tag.service';
import { EventService } from '../service/event.service';
import { Observable } from 'rxjs';
import { debounceTime, map } from 'rxjs/operators';
import { Constants } from '../common/constants';
import { ArticleService } from '../service/article.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { ArticleConstants } from '../common/article-constants';
import { Router } from '@angular/router';
import { formatDate } from '@angular/common';
import { NotifierService } from "angular-notifier";
import { NgbDropdownConfig } from '@ng-bootstrap/ng-bootstrap';
import { Article } from '../class/article';
import { CategoryService } from '../service/category.service';

declare const Liferay: any;
declare var $: any;

@Component({
    selector: 'app-article-list',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + '/o/CMS-Web-Article/app/article-list.component.html',
    styleUrls: [],
    providers: [],
})
export class ArticleListComponent implements OnInit {

    pageSize = 5;
    collectionSize = 0;
    page = 1;
    searchKey: any;

    today = new Date();
    tagsList: any = [];
    eventsList: any = [];

    categoriesList : any = [];
    permissions: String[] = [];
    oldSearchForm: any;
    searchForm = this.fb.group({
        searchKey: [''],
        categoryId: 0,
        inTitle: false,
        eventNames: [''],
        tagNames: [''],
        inSummary: false,
        inContent: false,
        inDate: false,
        fromDate: [''],
        toDate: [''],
        inAuthor: false,
        userKiemDuyet: false,
    });

    articlesList: any;
    removedArticle: any;
    isAdvancedSearch = true;

    get fromDate() {
        return this.searchForm.get("fromDate");
    }

    get toDate() {
        return this.searchForm.get("toDate");
    }

    constructor(private fb: FormBuilder, 
        private eventService: EventService,
        private tagService: TagService,
        private articleService: ArticleService,
        private modalService: NgbModal,
        private router: Router,
        @Inject(LOCALE_ID) private locale: string,
        private notifierService: NotifierService,
        dropdownConfig: NgbDropdownConfig,
        private categoryService: CategoryService){
            dropdownConfig.placement = "bottom-right";
        };

    maxDate = new Date(2020, 6, 30, 0, 0, 0);
    ngOnInit() {
        this.oldSearchForm = this.searchForm;
        this.page = 1;
        this.getFilteredArticle(0);
        this.isAdvancedSearch = false;
        this.categoryService.getAllCategories().subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.categoriesList = this.categoryService.convertTreeList(response.data, 0);
            }
        });
    }

    get ArticleConstants () {
        return ArticleConstants;
    }

    get configuration () {
        return Constants.CONFIGURATION;
    }

    closedForm = this.fb.group({
        categoryId: 0,
        inTitle: false,
        eventNames: [''],
        tagNames: [''],
        inSummary: false,
        inContent: false,
        inDate: false,
        fromDate: [''],
        toDate: [''],
        inAuthor: false,
        userKiemDuyet: false,
    });
    openCloseAdvancedSearch($event: any) {
        $event.preventDefault();
        if (this.isAdvancedSearch) {
            $($event.target).css('transform', '');
            //store form value before reset
            this.closedForm.patchValue({
                categoryId: this.searchForm.get('categoryId').value,
                inTitle: this.searchForm.get('inTitle').value,
                eventNames: this.searchForm.get('eventNames').value,
                tagNames: this.searchForm.get('tagNames').value,
                inSummary: this.searchForm.get('inSummary').value,
                inContent: this.searchForm.get('inContent').value,
                inDate: this.searchForm.get('inDate').value,
                fromDate: this.searchForm.get('fromDate').value,
                toDate: this.searchForm.get('toDate').value,
                inAuthor: this.searchForm.get('inAuthor').value,
                userKiemDuyet: this.searchForm.get('userKiemDuyet').value
            });
            //reset form value before close
            this.searchForm.patchValue({
                categoryId: 0,
                inTitle: false,
                eventNames: '',
                tagNames: '',
                inSummary: false,
                inContent: false,
                inDate: false,
                fromDate: '',
                toDate: '',
                inAuthor: false,
                userKiemDuyet: false,
            });
            this.isAdvancedSearch = false;
        } else {
            $($event.target).css('transform', 'rotate(180deg)');
            //restore old form value when open
            this.searchForm.patchValue({
                categoryId: this.closedForm.get('categoryId').value,
                inTitle: this.closedForm.get('inTitle').value,
                eventNames: this.closedForm.get('eventNames').value,
                tagNames: this.closedForm.get('tagNames').value,
                inSummary: this.closedForm.get('inSummary').value,
                inContent: this.closedForm.get('inContent').value,
                inDate: this.closedForm.get('inDate').value,
                fromDate: this.closedForm.get('fromDate').value,
                toDate: this.closedForm.get('toDate').value,
                inAuthor: this.closedForm.get('inAuthor').value,
                userKiemDuyet: this.closedForm.get('userKiemDuyet').value
            });
            this.isAdvancedSearch = true;
        }
    } 

    submitSearchForm() {
        this.oldSearchForm = this.searchForm;
        this.page = 1;
        this.getFilteredArticle(0);
    }

    pageChange(event : any) {
        let startPage = (event - 1) * this.pageSize;
        this.getFilteredArticle(startPage);
    }

    getFilteredArticle(start: number) {
        this.articleService.getFilteredArticle(this.oldSearchForm, start, this.pageSize).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.collectionSize = response.data.total;
                this.articlesList = response.data.data;
                this.permissions = response.data.permissions;
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    searchEvent = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(100),
      map(term => term.length < 1 ? []
        : this.eventsList.map((obj:any) => obj.name).filter((name: any) => name.toLowerCase().indexOf(term.toLowerCase()) > -1))
    )

    filteredEventsList(event: any) {
        this.eventService.getFilteredEvents(0, 3, event.target.value).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.eventsList = response.data.data;
            }
        });
    }

    searchTag = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(100),
      map(term => term.length < 1 ? []
        : this.tagsList.map((obj:any) => obj.name).filter((name: any) => name.toLowerCase().indexOf(term.toLowerCase()) > -1))
    )

    filteredTagsList(event: any) {
        this.tagService.getFilteredTags(0, 3, event.target.value).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.tagsList = response.data[0].data;
            }
        });
    }

    openedModal: any;
    openDeleteModal(event: any, content: any) {
        this.removedArticle = event;
        this.openedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow'});
    }

    deleteArticle(id: number) {
        this.articleService.deleteArticle(id).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getFilteredArticle(startPage);
                this.openedModal.close();
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }
 
    sendPendingArticle(id: number) {
        this.articleService.pendingArticle(id).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getFilteredArticle(startPage);
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    sendAprroveArticle(id: number) {
        this.articleService.approveArticle(id).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getFilteredArticle(startPage);
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    sendPublishArticle(id: number) {
        this.articleService.publishArticle(id).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getFilteredArticle(startPage);
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    sendDeniedApprovedArticle(id: number) {
        this.articleService.denyApprovedArticle(id).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getFilteredArticle(startPage);
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    sendDeniedPublishedArticle(id: number) {
        this.articleService.denyPublishedArticle(id).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getFilteredArticle(startPage);
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    previewArticle: Article;
    showPreviewModal(content: any, articleId: any) {
        this.articleService.getArticle(articleId).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let article = this.articleService.convertArticleResponse(response.data);
                let preivewModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'custom-scrollable-modal' });
                //preivewModal.componentInstance.article = article;
                this.previewArticle = article;
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    gotoEdit(articleId: number) {
        this.router.navigate(['/article-edit', articleId]);
    }

    formatDate(event: any) {
        console.log(event);
        let formattedDate = formatDate(event.value, 'dd/MM/yyyy HH:mm', this.locale);
        $(event.input).val(formattedDate);
    }
}