import { Component, OnInit } from "@angular/core";

import { Routes } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { CategoryModel } from '../model/category.model';
import { CategoryService } from '../service/category.service';
import { Constants } from '../common/Constants';
import { NotifierService } from 'angular-notifier';
import { NgbDropdownConfig } from '@ng-bootstrap/ng-bootstrap';
declare const Liferay: any;
@Component({
    selector: 'app-list',
    templateUrl:
        Liferay.ThemeDisplay.getPathContext() +
        '/o/Manager-Category-Image/app/category-list.component.html'
})
export class CategoryComponent implements OnInit {
    pageSize = 10;
    page = 1;
    listSize = 0;
    searchKey = '';
    categoryModels: CategoryModel[];
    removedEvent: any;
    constructor(public categoryService: CategoryService, public modalService: NgbModal, public notifierService: NotifierService,private dropdownConfig: NgbDropdownConfig) { 
        dropdownConfig.placement = "bottom-right";
    }
    ngOnInit() {
        this.getCategoryData(0);
    }
    getCategoryData(start: number) {
        this.categoryService.getAllCategory(this.pageSize, start, this.searchKey).subscribe((res: any) => {
            if (res.error_code == Constants.SUCCESSFUL_CODE) {
                this.categoryModels = res.data.data;
                this.listSize = res.data.total;
            } else if (res.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        })
    }
    pageChange(event: any) {
        let startPage = (event - 1) * this.pageSize;
        this.getCategoryData(startPage);
    }
    removeCategory(id: number) {
        this.categoryService.deleteCategory(id).subscribe((response: any) => {
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getCategoryData(startPage);
                this.openedModal.close();
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.data == "image exsits") {
                this.notifierService.notify('error', "Bạn phải xóa hết ảnh thuộc chủ đề này");
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        })

    }
    openedModal: any;
    openDeleteModal(event: any, content: any) {
        this.removedEvent = event;
        this.openedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow' });

    }
    filterList() {
        this.page = 1;
        this.getCategoryData(0);
    }

}