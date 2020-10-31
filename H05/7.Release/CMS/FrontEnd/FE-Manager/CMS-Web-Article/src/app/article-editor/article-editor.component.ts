import { Component, OnInit, Inject, LOCALE_ID } from '@angular/core';
import { ArticleService } from '../service/article.service';
import { Observable } from 'rxjs';
import {debounceTime, map} from 'rxjs/operators';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { CategoryService } from '../service/category.service';
import { TagService } from '../service/tag.service';
import { EventService } from '../service/event.service';
import { CommonService } from '../service/common.service';
import { UserService } from '../service/user.service';

import { Article } from '../class/article';
import LiferayParams from '../../types/LiferayParams';
import { Constants } from '../common/constants';

import { ActivatedRoute, Router } from '@angular/router';
import { ArticleConstants } from '../common/article-constants';
import { formatDate } from '@angular/common';
import { NotifierService } from 'angular-notifier';
import { CommentService } from '../service/comment.service';

import { TagInput } from '../class/tagInput.model';
import { of } from 'rxjs';
import {filter} from 'rxjs/operators';

declare const Liferay: any;
declare var $: any;

@Component({
    selector: 'app-article-editor',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + 
    '/o/CMS-Web-Article/app/article-editor.component.html',
    styleUrls: [],
    providers: [],
})
export class ArticleEditorComponent implements OnInit {

    arrayOne(n: number): any[] {
        return Array(n);
    }
    
    today = new Date();
    params: LiferayParams;
    articleId: any;
    article: Article = new Article(
        0,
        '',
        '',
        '',
        '',
        '',
        '',
        null,
        new Array(),
        new Array(),
        new Array(),
        false,
        false,
        false,
        "1",
        new Array(),
        new Array(),
        new Array(),
        false,
        new Date(),
        true,
        '',
        '',
        ['EDIT', 'PENDING', 'PUBLISH', 'REMOVE'],
        {}
    );

    selectedCategories: any = [];

    categories: any = [];
    usersList: any =[];
    groups: any = [];

    tagsList: any = [];

    eventsList: any = [];

    articlesList: any;

    sitesList: any =[];

    sourcesList: any;

    //image variable
    isImageExisted = false;
    imageId: number;
    imgSrc: any;

    get ArticleConstants () {
        return ArticleConstants;
    }

    get configuration () {
        return Constants.CONFIGURATION;
    }

    commentPage = 1;
    commentPageSize = 10;
    commentSize = 0;

    constructor(private articleService : ArticleService, 
        private modalService: NgbModal, 
        private categoryService: CategoryService,
        private eventService: EventService,
        private tagService: TagService,
        private commonService: CommonService,
        private userService: UserService,
        private routes: ActivatedRoute,
        private router: Router,
        @Inject(LOCALE_ID) private locale: string,
        private notifierService: NotifierService,
        private commentService: CommentService) { }

    ngOnInit() {
        this.routes.paramMap.subscribe(params => {
            if (params.get('id')) {
                this.articleId = params.get('id');
                this.getEditArticle(params.get('id'));
            } else {
                this.articleService.getSubsites().subscribe((response: any) => {
                    if (response.error_code == Constants.SUCCESSFUL_CODE) {
                        this.article.site = this.commonService.parseXmlList(response.data.subsite);
                    } else {
                        this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
                    }
                });

                this.categoryService.getAllCategories().subscribe((response: any) => {
                    console.log(response);
                    if (response.error_code == Constants.SUCCESSFUL_CODE) {
                        this.categories = this.categoryService.addCheckedToCategories(response.data);
                        console.log(this.categories);
                    } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                        this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
                    } else {
                        this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
                    }
                });
            }
        });
    }

    getEditArticle(articleId: any) {
        this.articleService.getArticle(articleId).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                if (response.data.imageUrl) {
                    this.imageId = response.data.image;
                    this.imgSrc = response.data.imageUrl;
                }

                this.article = this.articleService.convertArticleResponse(response.data);
                if (this.article.comment) {
                    this.commentSize = this.article.comment.parentCommentList.length;
                }
                this.categoryService.getAllCategories().subscribe((cateResponse: any) => {
                    console.log(cateResponse);
                    if (cateResponse.error_code == Constants.SUCCESSFUL_CODE) {
                        this.categories = this.categoryService.checkedCategories(cateResponse.data, this.article.category);
                    } else if (cateResponse.error_code == Constants.NOT_ACCESS_CODE) {
                        this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
                    } else {
                        this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
                    }
                });
                this.article.site = this.commonService.parseXmlList(response.data.subsite);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }
    

    saveForm(action: number) {
        console.log(this.article);
        if (this.article.category.length == 0) {
            alert(ArticleConstants.CATEGORY_NOT_SELECTED);
        } else if (this.article.content.length == 0) {
            alert(ArticleConstants.CONTENT_EMPTY);
        } else {
            if (action == ArticleConstants.ARTICLE_ADD && this.articleId && this.articleId > 0) {
                action = ArticleConstants.SAVE_ART;
            }
            this.articleService.submitArticleForm(this.article, this.articleId, action).subscribe((response: any) => {
                console.log(response);
                if (response.error_code == Constants.SUCCESSFUL_CODE) {
                    this.router.navigate(['/article-list']);
                    this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
                } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                    this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
                } else {
                    this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
                }
            });
        }
    }

    fetchSelectedCategory(item: any, target: any) {
        if ($(target).prop('checked')) {
            let newObj = {};
            newObj['id'] = item.cateId;
            newObj['name'] = item.title;
            newObj['checked'] = true;
            this.article.category.push(newObj);
            let parentListItems = $(target).parent().parent().parents('li');
            if (parentListItems.length > 0) {
                let inputCheck =  $(parentListItems[0]).children('.form-check').find('input[name="categoryCheck"]');
                if (!$(inputCheck).prop('checked')) {
                    $(inputCheck).click();
                }
            }

            let childListItems = $(target).parent().parent().find('ul');
            if (childListItems.length > 0) {
                let isClicked = false;
                //check to see if this is a parent or not
                childListItems.find('li').each(function(index: number, element: any){
                    let inputCheck = $(element).children('.form-check').find('input[name="categoryCheck"]');
                    if ($(inputCheck).prop('checked')) {
                        isClicked = true;
                    } 
                });

                //only click on child element.
                if (!isClicked) {
                    childListItems.children('li').each(function(index: number, element: any){
                        let inputCheck = $(element).children('.form-check').find('input[name="categoryCheck"]');
                        if (!$(inputCheck).prop('checked')) {
                            $(inputCheck).click();
                        } 
                    });
                }
            }


        } else {
            this.article.category.forEach((element: any, index: any) => {
                if (element.id == item.cateId) {
                    this.article.category.splice(index, 1);
                }
            });
            let sameLvlListItems = $(target).parent().parent().parent();
            if (sameLvlListItems.length > 0) {
                let isCheckedParent = false;
                sameLvlListItems.children('li').each(function(index: number, element: any){
                    let inputCheck = $(element).children('.form-check').find('input[name="categoryCheck"]');
                    if ($(inputCheck).prop('checked')) {
                        isCheckedParent = true;
                    } 
                });
                if (!isCheckedParent) {
                    let parentListItems = $(sameLvlListItems).parent();
                    if (parentListItems.length > 0) {
                        let inputCheck =  $(parentListItems[0]).children('.form-check').find('input[name="categoryCheck"]');
                        if ($(inputCheck).prop('checked')) {
                            $(inputCheck).click();
                        }
                    }
                }
            }

            let childrenListItems = $(target).parent().next('ul');
            if (childrenListItems.length > 0) {
                let inputChecks =  $(childrenListItems).children('li');         
                inputChecks.each(function(index: number, element: any) {
                    let checkBox = $(element).children('.form-check').find('input[name="categoryCheck"]');
                    if($(checkBox).prop('checked')) {
                        $(checkBox).click();
                    }
                });
            }
        }
        console.log(this.article.category);
    }

    searchSource = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(100),
      map(term => term.length < 1 ? []
        : this.sourcesList.map((obj:any) => obj.name).filter((name: any) => name.toLowerCase().indexOf(term.toLowerCase()) > -1))
    )

    /*searchArticle = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(100),
      map(term => term.length < 1 ? []: this.articlesList.filter((obj: any) => {
        let isContained = false;
        this.article.involve.forEach((element: any) => {
            if (element.key == obj.key) {
                isContained = true;
            }
        });
        return (obj.name.toLowerCase().indexOf(term.toLowerCase()) > -1 && !isContained);
      }))  
    )*/

    filteredArticlesList(title: any) {
        this.articleService.getSourceInvolveArticle(title, this.article.source, 5).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.articlesList = response.data.involve;
                this.sourcesList = response.data.source;
            }
        });
    }
    
    /*searchEvent = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(100),
      map(term => term.length < 1 ? [] : this.eventsList.filter((obj: Event) => {
            let isContained = false;
            this.article.events.forEach((element: any) => {
                if (element.id == obj.id) {
                    isContained = true;
                }
            });
            return (obj.name.toLowerCase().indexOf(term.toLowerCase()) > -1 && !isContained);
        }))
    )*/

    filteredEventsList(event: any) {
        this.eventService.getFilteredEvents(0, 5, event).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.eventsList = response.data.data;
            }
        });
    }

    /*searchTag = (text$: Observable<string>) =>
    text$.pipe(
      debounceTime(100),
      map(term => term.length < 1 ? []: this.tagsList.filter((obj: Tag) => {
            let isContained = false;
            this.article.tags.forEach((element: any) => {
                if (element.id == obj.id) {
                    isContained = true;
                }
            });
            return (obj.name.toLowerCase().indexOf(term.toLowerCase()) > -1 && !isContained)
        }))
    )*/

    filteredTagsList(event: any) {
        this.tagService.getFilteredTags(0, 5, event).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.tagsList = response.data[0].data;
            }
        });
    }

    filteredUsersList(event: any) {
        this.userService.getUsers(event).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.usersList = response.data;
            }
        });
    }
    
   /* formatter = (obj: any) => obj.name;

    relatedArticleText = "";
    addRelatedArticle(event : any) {
        event.preventDefault();
        this.articlesList.forEach((element: any) => {
            if (element.key == event.item.key) {
                let newItem = {};
                newItem['id'] = event.item.key;
                newItem['title'] = event.item.name;
                this.article.involve.push(newItem);
                return;
            }
        });
        this.relatedArticleText = "";
    }

    relatedEventText = "";
    addRelatedEvents(event : any) {
        event.preventDefault();
        this.addToList(event.item, this.eventsList, this.article.events);
        this.relatedEventText = "";
    }

    relatedTagText = "";
    addRelatedTags(event : any) {
        event.preventDefault();
        this.addToList(event.item, this.tagsList, this.article.tags);
        this.relatedTagText = "";
    }

    addToList(value: any, fromList: any, toList: any) {
        fromList.forEach((element: any) => {
            if (element.id == value.id) {
                let newItem = {};
                newItem['id'] = value.id;
                newItem['name'] = value.name;
                toList.push(newItem);
                return;
            }
        });
    }

    removeRelatedArticle(index: number) {
        this.article.involve.splice(index, 1);
    }

    removeRelatedTags(index: number) {
        this.article.tags.splice(index, 1);
    }

    removeEventTypes(index: number) {
        this.article.events.splice(index, 1);
    }*/

    showPreviewModal(content: any) {
        this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'custom-scrollable-modal' });
    }
    
    validExts = [".jpg", ".png",".jpeg",".gif"];
    processFile(event: any) {
        let fileExt = event.target.value;

        if(fileExt != ''){
            fileExt = fileExt.substring(fileExt.lastIndexOf('.'));
            console.log(fileExt);
            if (this.validExts.indexOf(fileExt.toLowerCase()) < 0) {
                alert("Không đúng định dạng " +
                       this.validExts.toString());
                return false;
            } else {
                let totalSize = event.target.files[0].size;
                let fSExt = new Array('Bytes', 'KB', 'MB', 'GB');
                let fSize = totalSize; 
                let i=0;
                while(fSize>900){fSize/=1024;i++;}
                var total = (Math.round(fSize*100)/100);
                if(fSExt[i] == 'MB'){
                    if(total >= 3){
                        alert("File đính kèm ảnh không được quá 3 Mb");
                        return false;
                    } else {
                        let F = event.target.files;
                        if(F && F[0]) this.readImage( F[0]);
                    }
                } else {
                    var F = event.target.files;
                    if(F && F[0]) this.readImage( F[0]);
                }
            }
        }
    }

    readImage(file: any) {
        const reader = new FileReader();
        this.article.images = file;
        reader.onload = (e: any) => {
            this.imgSrc = e.target.result;
            var w = e.target.width;
            if (w < 100) {
                alert("Kích thước ảnh không hợp lệ width >= 656");
            }
        };
        reader.readAsDataURL(file);
    }

    //delete image
    deleteImage() {
        this.articleService.deleteImage(this.articleId, this.imageId).subscribe((response: any) => {
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.isImageExisted = false;
                this.imgSrc = null;
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    formatDate(event: any) {
        console.log(event);
        let formattedDate = formatDate(event.value, 'dd/MM/yyyy HH:mm', this.locale);
        $(event.input).val(formattedDate);
    }

    approvedComment(comment: any) {
        this.commentService.approvedComment(comment.commentId).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                comment.approved = !comment.approved;
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }


    openedModal: any;
    removedComment: any;
    openDeleteCommentModal(event: any, content: any) {
        this.removedComment = event;
        this.openedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow'});
    }

    deleteComment(id: number) {
        this.commentService.deleteComment(id).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.getEditArticle(this.articleId);
                this.openedModal.close();
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    public onAddingTag = (tag: any): Observable<any> => {
        let tagModel = new TagInput;
        if (typeof tag == 'string') {
            let listSize = this.article.tags.length;
            tagModel.id = 0 - listSize;
            tagModel.name = tag;
        } else {
            tagModel.id = tag.id;
            tagModel.name = tag.name;
        }
        return of(tagModel).pipe(filter((temp: any) => temp));
    }

    public onAddingEvent = (tag: any): Observable<any> => {
        let tagModel = new TagInput;
        if (typeof tag == 'string') {
            let listSize = this.article.events.length;
            tagModel.id = 0 - listSize;
            tagModel.name = tag;
        } else {
            tagModel.id = tag.id;
            tagModel.name = tag.name;
        }
        return of(tagModel).pipe(filter((temp: any) => temp));
    }

    public checkUser() {
        console.log(this.article.humanAccessArticle);
    }

    public onAddingInvolve = (tag: any): Observable<any> => {
        let tagModel = {id: '', title: ''};
        tagModel.id = tag.key;
        tagModel.title = tag.name;
        return of(tagModel).pipe(filter((temp: any) => temp));
    }

}