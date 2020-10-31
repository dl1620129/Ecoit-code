import { Component, OnInit } from '@angular/core';
import { CategoryService } from '../service/category.service';
import { Category } from '../model/category.model';
import { Constants } from '../common/constants';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { NotifierService } from 'angular-notifier';
import { Router } from '@angular/router';
import { NgbDropdownConfig } from '@ng-bootstrap/ng-bootstrap';

declare const Liferay: any;
declare const $: any;

@Component({
    selector: 'app-category-list',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + '/o/QA-Web-Category/app/category-list.component.html',
    styleUrls: [],
    providers: [],
})
export class CategoryListComponent implements OnInit {

    arrayOne(n: number): any[] {
        return Array(n);
    }

    pageSize = 5;
    page = 1;
    listSize = 0;
    searchKey = '';

    //declare list of categories
    listOfCategories : Category[] = [];

    removedCategory: any;
    constructor(private categoryService : CategoryService,
        private modalService: NgbModal,
        private notifierService: NotifierService,
        private router: Router,
        private dropdownConfig: NgbDropdownConfig) { 
            dropdownConfig.placement = "bottom-right";
    } 

    ngOnInit() {
        this.getCategoriesList(0);
    }
    
    getCategoriesList(start: number) {
        this.categoryService.getCategoriesList(start, this.pageSize, this.searchKey).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.listSize = response.data.total;
                this.listOfCategories = response.data.categories;
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    filterList() {
        this.page = 1;
        this.categoryIdList = new Array();
        this.getCategoriesList(0);
    }

    // Check Box Action
    categoryIdList: number[] = new Array();
    updateCategoryId(event: any, categoryId :any){
        let isChecked = event.target.checked;
        if (isChecked) {
            this.categoryIdList.push(categoryId);
        } else {
            const index: number = this.categoryIdList.indexOf(categoryId);
            if (index !== -1) { 
                this.categoryIdList.splice(index, 1);
            }        
        } 
        console.log('list: '+ this.categoryIdList);   
    }
    // Check Box Action

    checkArray(content: any) {
        if (Array.isArray(content)) {
            return true;
        }
        return false;
    }

    openedModal: any;
    openDeleteModal(category: Category, content: any) {
        this.removedCategory = category;
        this.openedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow'});
    }

    deleteCategory(categoryId: any) {
        let categoryList = new Array();
        if (typeof categoryId == 'number') {
            categoryList.push(categoryId);
        } else if (Array.isArray(categoryId)) {
            categoryList = categoryId;
        }
        this.categoryService.deleteCategory(categoryList).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getCategoriesList(startPage);
                this.openedModal.close();
                this.categoryIdList = new Array();
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else if (response.error_code == Constants.CONFLICT_CODE) {
                this.notifierService.notify('error', Constants.CONFLICT_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    pageChange(event : any) {
        console.log(event);
        let startPage = (event - 1) * this.pageSize;
        this.getCategoriesList(startPage);
    }

    displayDropDown(event: any) {
        event.preventDefault();
        console.log('testing');
        let isVisible = $(event.currentTarget).data('visible');
        $(event.currentTarget).data('visible', !isVisible);
        if (isVisible) {
            //switch to plus
            $(event.currentTarget).html('<i class="fa fa-fw" aria-hidden="true"></i>');
        } else {
            //switch to minus
            $(event.currentTarget).html('<i class="fa fa-fw" aria-hidden="true"></i>');
        }
        let targetLevel = $(event.currentTarget).data('target');
        let currentRow = $(event.currentTarget).parents('tr').next();
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

    gotoEdit(categoryId: number) {
        this.router.navigate(['/category-edit', categoryId]);
    }
}