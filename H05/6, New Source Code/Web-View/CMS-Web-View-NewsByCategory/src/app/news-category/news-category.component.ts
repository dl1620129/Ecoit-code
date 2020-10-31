import { Component, OnInit } from '@angular/core';
import { NewsService } from '../service/news.service';
import { Constants } from '../common/constants';
import { URLConstants } from '../common/URLConstants';
import { Category } from '../model/Category';
import { FormBuilder } from '@angular/forms';
import { NewsArticle } from '../model/NewsArticle';
import { DateTimeAdapter } from 'ng-pick-datetime';
import { CategoryService } from '../service/category.service';
import { EventService } from '../service/event.service';
import { Config } from '../model/config.model';
import { ConfigService } from '../service/config.service';

declare const Liferay: any;

@Component({
    selector: 'app-news-category-list',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + 
    '/o/CMS-Web-View-NewsByCategory/app/news-category.component.html',
    styleUrls: [],
    providers: [],
}) export class NewsCategoryComponent implements OnInit {
    public urlWebSite= Liferay.ThemeDisplay.getLayoutRelativeURL();
    allNewsByCategories : NewsArticle[] = new Array();
     
    constructor (private newsService: NewsService, private categoryService: CategoryService, 
        private fb: FormBuilder, dateTimeAdapter: DateTimeAdapter<any>, 
        private eventService: EventService,
        private configService : ConfigService){
        dateTimeAdapter.setLocale("vi-VN");
    };

    oldSearchForm: any;
    searchForm = this.fb.group({
        tag: [[]],
        searchKey: [''],
        fromDate: [''],
        toDate: [''],
        categoryId: 0,
        eventId: 0
    });
    categoriesList: Category[] = new Array();
    eventsList: Event[] = new Array();

    pageSize = 7;
    collectionSize = 0;
    page = 1;
    //Config set category
    mainCategory: Category;
    mainCategoryId: number = -1;

    //Category id from URL
    linkCategoryId: number = -1;
    currentConfig = new Config();
    isAdmin = false;
    optionCategoriesList: Category[] = new Array();
    get HOME_URL() {
        return URLConstants.HOME_URL;
    }

    get ARTICLE_URL() {
        return Constants.baseUrl + this.urlWebSite.substring(0,this.urlWebSite.lastIndexOf('/'))+ URLConstants.ARTICLE_URL;
    }

    previousURL = Liferay.ThemeDisplay.getLayoutRelativeURL();

    ngOnInit() {
        this.oldSearchForm = this.searchForm;
        let queryData = this.getQueryString();
        if (parseInt(queryData['categoryId'])) {
            this.linkCategoryId = parseInt(queryData['categoryId']);
            this.searchForm.patchValue({
                categoryId: parseInt(queryData['categoryId'])
            });
        }

        this.newsService.checkAdmin().subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.isAdmin = response.data;
                if (this.isAdmin) {
                    this.categoryService.getcategorylayout().subscribe((response: any) => {
                        if (response.error_code == Constants.SUCCESSFUL_CODE) {
                            this.optionCategoriesList = this.categoryService.convertTreeList(response.data.category, 0);
                        }
                    });
                }
            }
        });

        this.eventService.getAllEvent().subscribe((response: any) => {
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.eventsList = response.data;
            }
        });

        this.configService.getConfig().subscribe((response: any) => {
            this.currentConfig.portletId = Constants.portletId;
            this.currentConfig.categoryId = 0;
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.currentConfig = response.data;
            }
            console.log(response);
            this.getNewsData();
        });
    }

    getNewsData() {
        this.categoryService.getAllCategories(this.currentConfig.categoryId).subscribe((cateResponse: any) => {
            console.log(cateResponse);
            if (cateResponse.error_code == Constants.SUCCESSFUL_CODE) {
                if (this.currentConfig.categoryId > 0) {
                    if (cateResponse.data.length > 0) {
                        this.mainCategory = cateResponse.data[0];
                        this.mainCategoryId = this.currentConfig.categoryId;
                        this.categoriesList = this.categoryService.convertTreeList(this.mainCategory.child, 0);
                    }
                } else {
                    this.categoriesList = this.categoryService.convertTreeList(cateResponse.data, 0);
                }
            }
            this.getFilteredNews(0);
        });
    }

    saveConfig() {
        this.configService.submitConfig(this.currentConfig).subscribe((response: any) => {
            console.log(response.data);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.getNewsData();
            }
        });
    }

   
    submitSearchForm() {
        this.oldSearchForm = this.searchForm;
        this.page = 1;
        this.getFilteredNews(0);
    }

    pageChange(event : any) {
        let startPage = (event - 1) * this.pageSize;
        this.getFilteredNews(startPage);
    }

    getFilteredNews(start: number) {
        this.newsService.getPageNews(this.oldSearchForm, start, this.pageSize, this.mainCategoryId).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.collectionSize = response.data.total;
                this.allNewsByCategories = response.data.data;
            }
        });
    }

    getQueryString() {
        let hashMap = {};
        let queries = Liferay.currentURL.slice(Liferay.currentURL.indexOf('?') + 1).split('&');
        for (let i = 0; i < queries.length; i++) {
            let hash = queries[i].split('=');
            hashMap[hash[0]] = hash[1];
        }
        console.log(hashMap);
        return hashMap;
    }
}