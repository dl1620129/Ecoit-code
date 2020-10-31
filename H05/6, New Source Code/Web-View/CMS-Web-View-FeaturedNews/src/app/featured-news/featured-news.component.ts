import { Component, OnInit } from '@angular/core';
import { NewsService } from '../service/news.service';
import { Constants } from '../common/constants';
import { NewsArticle } from '../model/NewsArticle';
import { Category } from '../model/Category';
import { URLConstants } from '../common/URLConstants';
import { ConfigValue } from '../common/config_value';
import LiferayParams from '../../types/LiferayParams';
import { Config } from '../model/config.model';
import { CategoryService } from '../service/category.service';
import { ConfigService } from '../service/config.service';

declare const Liferay: any;

@Component({
    selector: 'app-featured-news-list',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + 
    '/o/CMS-Web-View-FeaturedNews/app/featured-news.component.html',
    styleUrls: [],
    providers: [],
}) export class FeaturedNewsComponent implements OnInit {
    public urlWebSite= Liferay.ThemeDisplay.getLayoutRelativeURL();
    params: LiferayParams;
    featuredNewsList: NewsArticle[];
    categoriesList : Category[] = new Array();

    constructor (private newsService: NewsService, private categoryService : CategoryService, private configService : ConfigService){};

    get HOME_URL() {
        return URLConstants.HOME_URL;
    }

    get ARTICLE_URL() {
        return Constants.baseUrl + this.urlWebSite.substring(0,this.urlWebSite.lastIndexOf('/'))+ URLConstants.ARTICLE_URL;
    }

    get CATEGORY_URL() {
        let mainUrl = Constants.baseUrl;
        switch (Constants.CONFIG_CATEGORY) {
            case ConfigValue.CONFIG_THONG_BAO:
                mainUrl += URLConstants.THONG_BAO_URL;
                break;
            case ConfigValue.CONFIG_DIEU_HANH_TAC_NGHIEP:
                mainUrl += URLConstants.DIEU_HANH_TAC_NGHIEP_URL;
                break;
            case ConfigValue.CONFIG_TIN_HOAT_DONG:
                mainUrl += URLConstants.TIN_HOAT_DONG_URL;
                break;
        }
        return mainUrl;
    }

    currentConfig = new Config();
    currentCategory: Category;
    isAdmin = false;

    saveConfig() {
        this.configService.submitConfig(this.currentConfig).subscribe((response: any) => {
            console.log(response.data);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.getNewsData();
            }
        });
    };

    ngOnInit() {
        this.newsService.checkAdmin().subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.isAdmin = response.data;
                if (this.isAdmin) {
                    this.categoryService.getcategorylayout().subscribe((response: any) => {
                        if (response.error_code == Constants.SUCCESSFUL_CODE) {
                            this.categoriesList = this.categoryService.convertTreeList(response.data.category, 0);
                        }
                    });
                }
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
        if (this.currentConfig.categoryId == 0) {
            this.currentCategory = null;
            this.newsService.getFeaturedNews().subscribe((featureNewsResponse: any) => {
                console.log(featureNewsResponse);
                if (featureNewsResponse.error_code == Constants.SUCCESSFUL_CODE) {
                    this.featuredNewsList = featureNewsResponse.data.listTinMoiNhat;
                }
            });
        } else {
            this.newsService.getAllCategories(this.currentConfig.categoryId).subscribe((cateResponse: any) => {
                console.log(cateResponse);
                if (cateResponse.error_code == Constants.SUCCESSFUL_CODE) {
                    if (cateResponse.data.length > 0) {
                        this.currentCategory = cateResponse.data[0];
                        this.newsService.getAllNews(this.currentCategory.cateId).subscribe((newsResponse: any) => {
                            console.log(newsResponse);
                            if (newsResponse.error_code == Constants.SUCCESSFUL_CODE) {
                                this.featuredNewsList = newsResponse.data[0].data;
                            }
                        });
                    }
                }
            });
        }
    }
}