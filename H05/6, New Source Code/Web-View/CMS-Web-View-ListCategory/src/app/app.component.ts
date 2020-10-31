import { Component, OnInit } from '@angular/core';

import LiferayParams from '../types/LiferayParams'
import { CategoryService } from './service/category.service';
import { Constants } from './common/constants';
import { Category } from './model/Category';
import { URLConstants } from './common/URLConstants';
import { Config } from './model/config.model';
import { ConfigService } from './service/config.service';

declare const Liferay: any;
declare const $: any;
@Component({
	templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/CMS-Web-View-ListCategory/app/app.component.html'
})
export class AppComponent implements OnInit {
	params: LiferayParams;
	labels: any;
    mainCategory: Category;
    categoryList: Category[] = new Array();
    linkCategoryId: number = -1;
    currentConfig = new Config();
    isAdmin = false;
    optionCategoriesList: Category[] = new Array();
    arrayOne(n: number): any[] {
        return Array(n);
    }

	constructor(private categoryService: CategoryService, private configService : ConfigService) {
		this.labels = {        
			
			configuration: Liferay.Language.get('configuration'),
			
			portletNamespace: Liferay.Language.get('portlet-namespace'),
        	contextPath: Liferay.Language.get('context-path'),
			portletElementId: Liferay.Language.get('portlet-element-id'),
		}
	}

    get HOME_URL() {
        return URLConstants.HOME_URL;
	}
	
	get CURRENT_URL() {
		let currentUrl = Liferay.ThemeDisplay.getLayoutURL();
        return currentUrl;
    }

    ngOnInit() {
        let queryData = this.getQueryString();
        
		if (parseInt(queryData['categoryId'])) {
			this.linkCategoryId = queryData['categoryId'];
		}

		/*if (this.params.configuration.portletInstance.category) {
			this.categoryParam = this.params.configuration.portletInstance.category;
        };*/

        this.categoryService.checkAdmin().subscribe((response: any) => {
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
        
        this.configService.getConfig(this.params.portletNamespace).subscribe((response: any) => {
            this.currentConfig.portletId = this.params.portletNamespace;
            this.currentConfig.categoryId = 0;
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.currentConfig = response.data;
            }
            console.log(response);
            this.getCategoryData();
        });
    }
    

    saveConfig() {
        this.configService.submitConfig(this.currentConfig).subscribe((response: any) => {
            console.log(response.data);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.getCategoryData();
            }
        });
    }

    getCategoryData() {
        this.categoryService.getAllCategories(this.currentConfig.categoryId).subscribe((cateResponse: any) => {
            console.log(cateResponse);
            if (cateResponse.error_code == Constants.SUCCESSFUL_CODE) {
                if (cateResponse.data.length > 0) {
                    if (this.currentConfig.categoryId == 0) {
                        this.mainCategory = null;
                        this.categoryList = cateResponse.data;
                    } else {
                        this.mainCategory = cateResponse.data[0];
                        this.categoryList = this.mainCategory.child;
                    }

                }
            }
        });
    }

	displayDropDown(event: any) {
        event.preventDefault();
        console.log('testing');
        let isVisible = $(event.currentTarget).data('visible');
        $(event.currentTarget).data('visible', !isVisible);
        if (isVisible) {
            //switch to plus
            $(event.currentTarget).html('<i class="fa fa-chevron-right" aria-hidden="true"></i>');
        } else {
            //switch to minus
            $(event.currentTarget).html('<i class="fa fa-chevron-down" aria-hidden="true"></i>');
        }
        let targetLevel = $(event.currentTarget).data('target');
        let currentRow = $(event.currentTarget).parents('.panel-body').next();
        let currentLevel = $(currentRow).data('level');
        let mainVisible = isVisible;
        while (currentLevel > targetLevel) {
            let isShow = false;
            if (mainVisible) {
                if ($(currentRow).is(':visible')) {
                    $(currentRow).hide();
                }
            } else {
                isShow = true;
                $(currentRow).show();
            }

            if (($(currentRow).next().data('level') - targetLevel) == 1) {
                mainVisible = isVisible;
            } else {
                if ($(currentRow).find('.dropdown-btn').length > 0 && isShow) {
                    mainVisible = !$(currentRow).find('.dropdown-btn').data('visible');
                }
            }
            currentRow = $(currentRow).next();
            currentLevel = $(currentRow).data('level');
        }
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
