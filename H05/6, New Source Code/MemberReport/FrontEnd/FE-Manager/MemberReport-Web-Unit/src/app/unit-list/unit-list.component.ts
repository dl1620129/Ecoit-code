import { Component, OnInit } from '@angular/core';
import { UnitService } from '../service/unit.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Constants } from '../common/constants';
import { NotifierService } from 'angular-notifier';
import { Unit } from '../model/unit.model';

declare const Liferay: any;

@Component({
    selector: 'app-unit-list',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + '/o/MemberReport-Web-Unit/app/unit-list.component.html',
    styleUrls: [],
    providers: [],
})
export class UnitListComponent implements OnInit {

    unitsList: Unit[] = new Array();

    constructor(private unitService: UnitService, private modalService: NgbModal, private notifierService: NotifierService){}

    pageSize = 10;
    page = 1;
    listSize = 0;
    searchKey = '';
    removedUnit: any;

    ngOnInit() {
        this.getAllUnits(0);
    }

    getAllUnits(start: number) {
        this.unitService.getAllUnits(start, this.pageSize, this.searchKey).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.listSize = response.data.total;
                this.unitsList = response.data.list;
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    pageChange(event : any) {
        let startPage = (event - 1) * this.pageSize;
        this.getAllUnits(startPage);
    }

    filterList() {
        this.page = 1;
        this.getAllUnits(0);
    }

    openedModal: any;
    openDeleteModal(unit: any, content: any) {
        this.removedUnit = unit;
        this.openedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow'});
    }

    deleteUnit(id: number) {
        this.unitService.deleteUnit(id).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getAllUnits(startPage);
                this.openedModal.close();
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else if (response.error_code == Constants.PARAM_ERROR) {
                this.notifierService.notify('warning', Constants.DELETE_PARAM_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }
}