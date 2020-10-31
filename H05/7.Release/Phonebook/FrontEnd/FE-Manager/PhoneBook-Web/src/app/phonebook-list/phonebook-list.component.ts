import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Constants } from '../common/constants';
import { PhoneBookService } from '../service/phonebook.service';
import { NotifierService } from "angular-notifier";
import { Organization } from '../model/organization.model';
import { User } from '../model/user.model';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

declare const Liferay: any;
declare var $: any;

@Component({
    selector: 'app-user-list',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + '/o/PhoneBook-Web/app/phonebook-list.component.html',
    styleUrls: [],
    providers: [],
})
export class PhonebookListComponent implements OnInit {

    pageSize = 5;
    collectionSize = 0;
    page = 1;
    searchKey: any;

    organizationsList: Organization[] = new Array();

    oldSearchForm: any;
    searchForm = this.fb.group({
        organizationId: 0,
        searchKey: ['']
    });
    usersList: User[] = new Array();

    constructor(private fb: FormBuilder,
        private phoneBookService: PhoneBookService,
        private notifierService: NotifierService,
        private modalService: NgbModal){
        };

    ngOnInit() {
        this.oldSearchForm = this.searchForm;
        this.page = 1;
        this.phoneBookService.getAllOrganization().subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.organizationsList = this.phoneBookService.convertTreeList(response.data, 0);
            }
        });
        this.getFilteredUsers();
    }
    
    submitSearchForm() {
        this.oldSearchForm = this.searchForm;
        this.page = 1;
        this.getFilteredUsers();
    }

    getFilteredUsers() {
        this.phoneBookService.getFilteredUsers(this.oldSearchForm).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.usersList = response.data;
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    removedUser: any;
    openedModal: any;
    openDeleteModal(user: any, content: any) {
        this.removedUser = user;
        this.openedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow'});
    }

    deleteUser(id: number) {
        this.phoneBookService.deleteUser(id).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.getFilteredUsers();
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