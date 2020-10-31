import { Component, OnInit } from '@angular/core';
import { EventService } from '../service/event.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Constants } from '../common/constants';
import { NotifierService } from 'angular-notifier';

declare const Liferay: any;

@Component({
    selector: 'app-event-list',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + '/o/CMS-Web-Event/app/event-list.component.html',
    styleUrls: [],
    providers: [],
})
export class EventListComponent implements OnInit {

    listOfEvents: any = [];

    constructor(private eventService: EventService, 
        private modalService: NgbModal,
        private notifierService: NotifierService){}

    pageSize = 5;
    page = 1;
    listSize = 0;
    searchKey = '';
    removedEvent: any;

    ngOnInit() {
        this.getAllEvents(0);
    }

    getAllEvents(start: number) {
        this.eventService.getAllEvents(start, this.pageSize, this.searchKey).subscribe((response: any) => {
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.listSize = response.data.total;
                this.listOfEvents = response.data.data;
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    pageChange(event : any) {
        let startPage = (event - 1) * this.pageSize;
        this.getAllEvents(startPage);
    }

    filterList() {
        this.page = 1;
        this.getAllEvents(0);
    }

    openedModal: any;
    openDeleteModal(event: any, content: any) {
        this.removedEvent = event;
        this.openedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow'});
    }

    deleteEvent(id: number) {
        this.eventService.deleteEvent(id).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getAllEvents(startPage);
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