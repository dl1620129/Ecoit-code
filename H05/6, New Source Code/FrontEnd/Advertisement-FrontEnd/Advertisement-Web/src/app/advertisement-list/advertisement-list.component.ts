import { Component, OnInit } from '@angular/core';
import { AdvertisementService } from '../service/advertisement.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Constants } from '../common/constants';
import { NotifierService } from 'angular-notifier';
import { Advertisement } from '../model/advertisement.model';

declare const Liferay: any;

@Component({
    selector: 'app-tag-list',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + '/o/Advertisement-Web/app/advertisement-list.component.html',
    styleUrls: [],
    providers: [],
})
export class AdvertisementListComponent implements OnInit {

    listOfAdvertisements: Advertisement[] = new Array();

    constructor(private advertisementService: AdvertisementService, private modalService: NgbModal, private notifierService: NotifierService){}

    pageSize = 5;
    page = 1;
    listSize = 0;
    searchKey = '';
    removedAdvertisement: any;

    ngOnInit() {
        this.getAllAdvertisements(0);
    }

    getAllAdvertisements(start: number) {
        this.advertisementService.getAllAdvertisements(start, this.pageSize, this.searchKey).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.listSize = response.data.total;
                this.listOfAdvertisements = response.data.data;
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    pageChange(event : any) {
        let startPage = (event - 1) * this.pageSize;
        this.getAllAdvertisements(startPage);
    }

    filterList() {
        this.page = 1;
        this.getAllAdvertisements(0);
    }

    openedModal: any;
    openDeleteModal(tag: any, content: any) {
        this.removedAdvertisement = tag;
        this.openedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow'});
    }

    deleteTag(id: number) {
        this.advertisementService.deleteAdvertisement(id).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getAllAdvertisements(startPage);
                this.openedModal.close();
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }
}