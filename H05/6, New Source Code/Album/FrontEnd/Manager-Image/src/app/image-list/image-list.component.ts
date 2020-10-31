import { Component, OnInit } from "@angular/core";

import { Routes } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Constants } from '../common/Constants';
import { NotifierService } from 'angular-notifier';
import { ImageModel } from "../model/image.model";
import { ImageService } from '../service/image.service';

declare const Liferay: any;
@Component({
    selector: 'app-list',
    templateUrl:
        Liferay.ThemeDisplay.getPathContext() +
        '/o/Manager-Image/app/image-list.component.html'
})
export class ImageComponent implements OnInit {
    pageSize = 5;
    page = 1;
    listSize = 0;
    searchKey = '';
    imageModels: ImageModel[];
    removedEvent: any;
    masterSelected: boolean;
    listIdChecked: any = [];
    constructor(public ImageService: ImageService, public modalService: NgbModal, public notifierService: NotifierService) { }
    ngOnInit() {

        this.getImageData(0);
    }
    getImageData(start: number) {
        this.ImageService.getAllImage(this.pageSize, start, this.searchKey).subscribe((res: any) => {
            if (res.error_code == Constants.SUCCESSFUL_CODE) {
                this.imageModels = res.data[0].data;
                this.listSize = res.data[0].total;
            } else if (res.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        })
    }
    pageChange(event: any) {
        let startPage = (event - 1) * this.pageSize;
        this.getImageData(startPage);
    }
    removeImage(id: number) {
        this.ImageService.deleteImage(id).subscribe((response: any) => {
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getImageData(startPage);
                this.openedModal.close();
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
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
        this.getImageData(0);
    }
    selectAll() {
        for (let i = 0; i < this.imageModels.length; i++) {
            this.imageModels[i].selected = this.masterSelected;
            this.listIdChecked.push(this.imageModels[i].imageId);
        }


    }


    checkIfAllSelected(event: any) {
        this.masterSelected = this.imageModels.every(function (item: any) {
            return item.selected == true;
        })
        this.listIdChecked.push(event.target.value);
    }

}