import { Component, OnInit } from "@angular/core";

import { Routes } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Constants } from '../common/Constants';
import { NotifierService } from 'angular-notifier';
import { OrganizationModel } from '../model/organization.model';
import { OrganizationService } from "../service/Organization.service";
import { NgbDropdownConfig } from '@ng-bootstrap/ng-bootstrap';

declare const Liferay: any;
declare const $: any;
@Component({
    selector: 'app-list',
    templateUrl:
        Liferay.ThemeDisplay.getPathContext() +
        '/o/Organizational-Structure-Manager/app/organization-list.component.html'
})
export class OrganizationComponent implements OnInit {
    // pageSize =100;
    // page = 1;
    // listSize = 0;
    searchKey = '';
    organId = 0;
    organizationModels: OrganizationModel[];
    removedEvent: any;
    masterSelected: boolean;
    listIdChecked: any = [];
    arrayOne(n: number): any[] {
        return Array(n);
    }
    constructor(public organizationService: OrganizationService, public modalService: NgbModal, public notifierService: NotifierService,private  dropdownConfig:NgbDropdownConfig) {  dropdownConfig.placement = "bottom-right";}
    ngOnInit() {
        this.getorganizationData(0);
        // this.getOrganData();
    }

    getorganizationData(start: number) {
        this.organizationService.getAllorganization(3, start, this.searchKey).subscribe((res: any) => {
            if (res.error_code == Constants.SUCCESSFUL_CODE) {
                console.log('data' + JSON.stringify(res));
                this.organizationModels = res.data.data;
                // this.listSize = res.data.total;
            } else if (res.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        })
    }
    getOrganData() {
        this.organizationService.getAllOrgan().subscribe((res: any) => {
            // this.listOrgan2=res.data.data;

            this.organizationModels = res.data.Organizations;
            console.log('data: ' + this.organizationModels);
            // this.listOrgan2=res.data.OrganizationIds
            // console.log(this.listOrgan2);
            // if(this.listOrgan2.length!=0){
            //     this.organizationService.convertTreeList(this.listOrgan2,1,this.listOrgan);
            // }

            // console.log(this.listOrgan);
        })
    }
    pageChange(event: any) {
        // let startPage = (event - 1) * this.pageSize;
        this.getorganizationData(0);
    }
    removeOrgan(id: number, coreId: number) {
        this.organizationService.deleteOrgCore(coreId).subscribe((respeone: any) => {
            if (respeone.error_code == Constants.SUCCESSFUL_CODE) {
                this.organizationService.deleteOrgan(id).subscribe((response: any) => {
                    if (respeone.error_code == Constants.SUCCESSFUL_CODE) {
                        // let startPage = (this.page - 1) * this.pageSize;
                        this.getorganizationData(0);
                        this.openedModal.close();
                        this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
                    } else if (response.data == 'can not delete') {
                        this.openedModal.close();
                        this.notifierService.notify('error', 'Bạn phải xóa thư mục con trước');
                    } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                        this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
                    } else {
                        this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
                    }
                })
            }
            else {
                this.notifierService.notify('error', 'Hiện đang có người dùng thuộc tổ chức này');
                this.openedModal.close();
            }
        })

    }
    openedModal: any;
    openDeleteModal(event: any, content: any) {
        this.removedEvent = event;
        this.openedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow' });
        

    }
    filterList() {
        // this.page = 0;
        this.getorganizationData(0);
    }

    displayDropDown(event: any) {
        event.preventDefault();
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