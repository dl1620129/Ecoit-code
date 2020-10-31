import { Component, OnInit } from '@angular/core';
import { CategoryService } from '../service/category.service';
import { TreeUtilService } from '../service/tree-util.service';
import { Category } from '../class/category';
import { Constants } from '../common/constants';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { NotifierService } from 'angular-notifier';

declare const Liferay: any;
declare const $: any;

@Component({
    selector: 'app-category-list',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + '/o/CMS-Web-Category/app/category-list.component.html',
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
    listOfCategories : any = [];
    listOfFilterCategories: any = [];

    removedCategory: any;
    constructor(private categoryService : CategoryService,
        private modalService: NgbModal,
        private notifierService: NotifierService) { } 

    ngOnInit() {
        this.getAllCategories(0);
    }
    
    getAllCategories(start: number) {
        this.categoryService.getAllCategories(start, this.pageSize, this.searchKey).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.listOfCategories = response.data;
                this.listSize = this.listOfCategories.length;
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    filterList() {
        this.page = 1;
        this.getAllCategories(0);
    }

    openedModal: any;
    openDeleteModal(category: Category, content: any) {
        this.removedCategory = category;
        this.openedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow'});
    }

    deleteCategory(id: number) {
        this.categoryService.deleteCategory(id).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getAllCategories(startPage);
                this.openedModal.close();
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    /*pageChange(event : any) {
        console.log(event);
        let startPage = (event - 1) * this.pageSize;
        this.getAllCategories(startPage);
    }*/

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
}