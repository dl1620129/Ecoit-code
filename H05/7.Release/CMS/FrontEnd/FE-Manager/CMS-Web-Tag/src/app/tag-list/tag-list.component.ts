import { Component, OnInit } from '@angular/core';
import { TagService } from '../service/tag.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Constants } from '../common/constants';
import { NotifierService } from 'angular-notifier';

declare const Liferay: any;

@Component({
    selector: 'app-tag-list',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + '/o/CMS-Web-Tag/app/tag-list.component.html',
    styleUrls: [],
    providers: [],
})
export class TagListComponent implements OnInit {

    listOfTags: any = [];

    constructor(private tagService: TagService, private modalService: NgbModal, private notifierService: NotifierService){}

    pageSize = 5;
    page = 1;
    listSize = 0;
    searchKey = '';
    removedTag: any;

    ngOnInit() {
        this.getAllTags(0);
    }

    getAllTags(start: number) {
        this.tagService.getAllTags(start, this.pageSize, this.searchKey).subscribe((response: any) => {
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.listSize = response.data[0].total;
                this.listOfTags = response.data[0].data;
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    pageChange(event : any) {
        let startPage = (event - 1) * this.pageSize;
        this.getAllTags(startPage);
    }

    filterList() {
        this.page = 1;
        this.getAllTags(0);
    }

    openedModal: any;
    openDeleteModal(tag: any, content: any) {
        this.removedTag = tag;
        this.openedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow'});
    }

    deleteTag(id: number) {
        this.tagService.deleteTag(id).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getAllTags(startPage);
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