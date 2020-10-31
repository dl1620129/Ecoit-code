import { Component, OnInit, Inject, LOCALE_ID } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Constants } from '../common/constants';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { NotifierService } from "angular-notifier";
import { LichConstants } from '../common/lich-constants';
import { LichChiTiet } from '../model/lichchitiet.model';
import { PreviewService } from '../service/preview.service';
import { OrganizationService } from '../service/organization.service';
import { CommonService } from '../service/common.service';
import { LichChiTietService } from '../service/lichchitiet.service';
import { NgbDropdownConfig } from '@ng-bootstrap/ng-bootstrap';

declare const Liferay: any;
declare var $: any;

@Component({
    selector: 'app-lichchitiet-list',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + '/o/LichCongTac-Web/app/lichchitiet-list.component.html',
    styleUrls: [],
    providers: [],
})
export class LichChiTietListComponent implements OnInit {

    pageSize = 5;
    collectionSize = 0;
    page = 1;
    oldSearchForm: any;

    userPermissions: string[] = new Array();
    lichChiTietList: LichChiTiet[] = new Array();
    lyDoTraVe: string = "";

    /*organizationId = -1;
    lichChiTietDate = new Date();
    fromLichChiTietDate = new Date();
    toLichChiTietDate = new Date();*/

    constructor(private fb: FormBuilder,
        private lichChiTietService: LichChiTietService,
        private modalService: NgbModal,
        private router: Router,
        @Inject(LOCALE_ID) private locale: string,
        private notifierService: NotifierService,
        private dropdownConfig: NgbDropdownConfig){
            dropdownConfig.placement = "bottom-right";
        };

    get configuration () {
        return Constants.CONFIGURATION;
    }
    
    get LichConstants () {
        return LichConstants;
    }

    private startPosition = 0;
    ngOnInit() {
        //this.lichChiTietDate = new Date(this.lichChiTietDate.getTime() + 7 * 24 * 60 * 60 * 1000);
        //this.getFromAndToDate();
        //this.submitSearchForm();

        /*if (Constants.CONFIGURATION == LichConstants.CONFIG_PUBLISHED) {
            this.orgService.getAllOrgan().subscribe((response: any) => {
                console.log(response);
                if (response.error_code == Constants.SUCCESSFUL_CODE) {
                    this.organizationsList = this.orgService.convertTreeList(response.data, 0);
                }
            });
        }*/
    }

    pageChange(event : any) {
        this.startPosition = (event - 1) * this.pageSize;
        this.getFilteredLichChiTiet();
    }

    
    oldOrgId = -1;
    oldFromLichCongTacDate = new Date();
    oldToLichCongTacDate = new Date();
    submitSearchForm(organizationId: number, fromLichChiTietDate: Date, toLichChiTietDate: Date) {
        this.oldOrgId = organizationId;
        this.oldFromLichCongTacDate = fromLichChiTietDate;
        this.oldToLichCongTacDate = toLichChiTietDate;
        this.getFilteredLichChiTiet();
    }

    getFilteredLichChiTiet() {
        this.lichChiTietService.getFilteredLichChiTiet(this.startPosition, this.pageSize, this.oldOrgId, this.oldFromLichCongTacDate, this.oldToLichCongTacDate, Constants.CONFIGURATION).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.collectionSize = response.data.total;
                this.lichChiTietList = response.data.data;
                this.userPermissions = response.data.permissions;
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    gotoEdit(lichId: number) {
        this.router.navigate(['/lichchitiet-edit', lichId]);
    }

    openedModal: any;
    removedLichChiTiet: any;
    openDeleteModal(lichChiTiet: any, content: any) {
        this.removedLichChiTiet = lichChiTiet;
        this.openedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow'});
    }

    deleteLichChiTiet(id: number) {
        this.lichChiTietService.deleteLichChiTiet(id).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.startPosition = (this.page - 1) * this.pageSize;
                this.getFilteredLichChiTiet();
                this.openedModal.close();
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    openedReturnedModal: any;
    returnedLichChiTiet: any;
    openReturnModal(lichChiTiet: any, content: any) {
        this.returnedLichChiTiet = lichChiTiet;
        this.openedReturnedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow', backdrop: 'static', keyboard: false});
    }

    closeReturnedModal() {
        this.lyDoTraVe = '';
        this.openedReturnedModal.close();
    }

    updateStatus(action: number, lichCongTacId: number, coLyDo: boolean) {
        this.lichChiTietService.updateStatusLichChiTiet(action, lichCongTacId, this.lyDoTraVe, coLyDo).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.startPosition = (this.page - 1) * this.pageSize;
                this.getFilteredLichChiTiet();
                if (this.openedReturnedModal) {
                    this.lyDoTraVe = '';
                    this.openedReturnedModal.close();
                }
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }
}