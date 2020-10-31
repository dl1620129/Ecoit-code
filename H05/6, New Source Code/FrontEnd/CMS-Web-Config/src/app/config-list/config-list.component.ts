import { Component, OnInit } from '@angular/core';
import { Constants } from '../common/constants';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { NotifierService } from 'angular-notifier';
import { ConfigService } from '../service/config.service';
import { Config } from '../class/config.model';
declare const Liferay: any;
declare const $: any;

@Component({
    selector: 'app-config-list',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + '/o/CMS-Web-Config/app/config-list.component.html',
    styleUrls: [],
    providers: [],
})
export class ConfigListComponent implements OnInit {

    arrayOne(n: number): any[] {
        return Array(n);
    }

    pageSize = 5;
    page = 1;
    listSize = 0;
    searchKey = '';

    //declare list of categories
    listOfConfigs : any = [];

    removedConfig: any;
    constructor(private configService : ConfigService,
        private modalService: NgbModal,
        private notifierService: NotifierService) { } 

    ngOnInit() {
        this.getAllConfig(0);
    }
    
    getAllConfig(start: number) {
        this.configService.getAllConfig(start, this.pageSize, this.searchKey).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.listSize = response.data.total;
                this.listOfConfigs = response.data.data;
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    filterList() {
        this.page = 1;
        this.getAllConfig(0);
    }

    openedModal: any;
    openDeleteModal(config: Config, content: any) {
        this.removedConfig = config;
        this.openedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow'});
    }

    deleteConfig(id: number) {
        this.configService.deleteConfig(id).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getAllConfig(startPage);
                this.openedModal.close();
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    pageChange(event : any) {
        console.log(event);
        let startPage = (event - 1) * this.pageSize;
        this.getAllConfig(startPage);
    }
}