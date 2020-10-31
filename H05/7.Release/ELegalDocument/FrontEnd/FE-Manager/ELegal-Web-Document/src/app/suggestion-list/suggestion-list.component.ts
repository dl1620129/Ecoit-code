import { Component, OnInit, Input } from '@angular/core';
import { SuggestionService } from '../service/suggestion.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Constants } from '../common/constants';
import { NotifierService } from 'angular-notifier';
import { Suggestion } from '../model/suggestion.model';

declare const Liferay: any;

@Component({
    selector: 'app-suggestion-list',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + 
    '/o/ELegal-Web-Document/app/suggestion/suggestion-list.component.html',
    styleUrls: [],
    providers: [],
})
export class SuggestionListComponent implements OnInit {

    @Input() docId: any;

    suggestionsList: Suggestion[] = new Array();
    pageSize = 10;
    page = 1;
    listSize = 0;
    constructor(private modalService: NgbModal,
        private suggestionService: SuggestionService,
        private notifierService: NotifierService) { }

    ngOnInit() {
        this.getAllSuggestions(0);
    }

    getAllSuggestions(start: number) {
        this.suggestionService.getAllSuggestions(start, this.pageSize, this.docId).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.listSize = response.data.total;
                this.suggestionsList = response.data.data;
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    pageChange(event : any) {
        let startPage = (event - 1) * this.pageSize;
        this.getAllSuggestions(startPage);
    }

    //delete suggestion
    removedSuggestion: any;
    openedModal: any;
    openDeleteModal(suggestion: any, content: any) {
        this.removedSuggestion = suggestion;
        this.openedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow'});
    }
    
    deleteSuggestion(id: number) {
        this.suggestionService.deleteSuggestion(id).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getAllSuggestions(startPage);
                this.openedModal.close();
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    approvedSuggestion(isApproved: boolean, sugId: number) {
        this.suggestionService.approvedSuggestion(isApproved, sugId).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getAllSuggestions(startPage);
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    } 
}