import { Component, OnInit, Inject, LOCALE_ID, ViewChild } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Constants } from '../common/constants';
import { LichCongTacService } from '../service/lichcongtac.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Router } from '@angular/router';
import { NotifierService } from "angular-notifier";
import { LichCongTac } from '../model/lichcongtac.model';
import { LichConstants } from '../common/lich-constants';
import { LichChiTiet } from '../model/lichchitiet.model';
import { DateObject } from '../model/dateObject.model';
import { PreviewService } from '../service/preview.service';
import { Organization } from '../model/organization.model';
import { OrganizationService } from '../service/organization.service';
import { CommonService } from '../service/common.service';
import { LichChiTietService } from '../service/lichchitiet.service';
import { LichChiTietListComponent } from '../lichchitiet/lichchitiet-list.component';
import { NgbDropdownConfig } from '@ng-bootstrap/ng-bootstrap';
declare const Liferay: any;
declare var $: any;

@Component({
    selector: 'app-lichcongtac-list',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + '/o/LichCongTac-Web/app/lichcongtac-list.component.html',
    styleUrls: [],
    providers: [],
})
export class LichCongTacListComponent implements OnInit {

    pageSize = 5;
    collectionSize = 0;
    page = 1;
    oldOrgId = -1;
    organizationId = -1;
    oldSearchKey = "";
    searchKey: any = "";
    organizationsList: Organization[] = new Array();
    oldSearchForm: any;

    userPermissions: string[] = new Array();
    lichCongTacList: LichCongTac[] = new Array();
    lyDoTraVe: string = "";

    //lichCongTacDate = new Date();
    fromLichCongTacDate = new Date();
    toLichCongTacDate = new Date();

    currentWeek: number = 1;
    currentYear: number = 0;
    numberOfWeek: number = 0;

    constructor(private fb: FormBuilder,
        private lichCongTacService: LichCongTacService,
        private modalService: NgbModal,
        private router: Router,
        @Inject(LOCALE_ID) private locale: string,
        private notifierService: NotifierService,
        private previewService: PreviewService,
        private orgService : OrganizationService,
        private commonService: CommonService,
        private lichChiTietService: LichChiTietService,
        private dropdownConfig: NgbDropdownConfig){
            dropdownConfig.placement = "bottom-right";
        };

    get configuration () {
        return Constants.CONFIGURATION;
    }
    
    get LichConstants () {
        return LichConstants;
    }

    @ViewChild(LichChiTietListComponent) lichChiTietListComponent: LichChiTietListComponent;

    ngOnInit() {
        let now = new Date();
        let lichCongTacDate = new Date(now.getTime() + 7 * 24 * 60 * 60 * 1000);
        this.currentWeek = this.commonService.getWeek(lichCongTacDate);
        this.currentYear = lichCongTacDate.getFullYear();
        this.numberOfWeek = this.commonService.getNumberOfWeek(this.currentYear);
        this.getFromAndToDate();
        this.submitSearchForm();

        this.lichCongTacService.checkPermission().subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.userPermissions = response.data.permissions;
                        
                if (this.userPermissions.indexOf(LichConstants.PERMISSION_VIEW_ALL) != -1) {
                    this.orgService.getAllOrgan().subscribe((response: any) => {
                        console.log(response);
                        if (response.error_code == Constants.SUCCESSFUL_CODE) {
                            this.organizationsList = this.orgService.convertTreeList(response.data, 0);
                        }
                    });
                }
            }
        });
    }

    moveBackLichCongTac(event: any) {
        event.preventDefault();
        //this.lichCongTacDate = new Date(this.lichCongTacDate.getFullYear(), this.lichCongTacDate.getMonth(), this.lichCongTacDate.getDate() - 7);
        if (this.currentWeek == 1) {
            this.currentYear = this.currentYear - 1;
            this.numberOfWeek = this.commonService.getNumberOfWeek(this.currentYear);
            this.currentWeek = this.numberOfWeek;
        } else {
            this.currentWeek = this.currentWeek - 1;
        }

        this.getFromAndToDate();
    }

    moveForwardLichCongTac(event: any) {
        event.preventDefault();
        //this.lichCongTacDate = new Date(this.lichCongTacDate.getTime() + 7 * 24 * 60 * 60 * 1000);
        if (this.currentWeek == this.numberOfWeek) {
            this.currentYear = this.currentYear + 1;
            this.numberOfWeek = this.commonService.getNumberOfWeek(this.currentYear);
            this.currentWeek = 1;
        } else {
            this.currentWeek = this.currentWeek + 1;
        }
        
        this.getFromAndToDate();
    }

    getFromAndToDate() {
        /*let tempDate = new Date(this.lichCongTacDate.getFullYear(), this.lichCongTacDate.getMonth(), this.lichCongTacDate.getDate());     
        let firstDate = tempDate.getDate() - tempDate.getDay() + 1;
        this.fromLichCongTacDate = new Date(tempDate.setDate(firstDate));
        let lastDate = tempDate.getDate() - tempDate.getDay() + 7;
        this.toLichCongTacDate = new Date(tempDate.setDate(lastDate));*/
        if (this.currentWeek && this.currentWeek > 0
            && this.currentYear && this.currentYear > 0) {

            this.numberOfWeek = this.commonService.getNumberOfWeek(this.currentYear);
            if (this.currentWeek < this.numberOfWeek) {
                let tempDate = this.commonService.getDateFromWeek(this.currentWeek, this.currentYear);
                let firstDate = tempDate.getDate() - tempDate.getDay() + 1;
                this.fromLichCongTacDate = new Date(tempDate.setDate(firstDate));
                let lastDate = tempDate.getDate() - tempDate.getDay() + 7;
                this.toLichCongTacDate = new Date(tempDate.setDate(lastDate));
            
                this.page = 1;
                this.getFilteredLichCongTac(0);
                if (Constants.CONFIGURATION !== LichConstants.CONFIG_DRAFT) {
                    this.lichChiTietListComponent.submitSearchForm(this.oldOrgId, this.fromLichCongTacDate, this.toLichCongTacDate);
                }
            }
        }
    }

    pageChange(event : any) {
        let startPage = (event - 1) * this.pageSize;
        this.getFilteredLichCongTac(startPage);
    }

    //oldFromLichCongTacDate = new Date();
    //oldToLichCongTacDate = new Date();
    submitSearchForm() {
        //reset id list
        this.lichIdList = new Array();
        this.oldOrgId = this.organizationId;
        //this.oldFromLichCongTacDate = this.fromLichCongTacDate;
        //this.oldToLichCongTacDate = this.toLichCongTacDate;
        this.oldSearchKey = this.searchKey;
        this.page = 1;
        if (Constants.CONFIGURATION !== LichConstants.CONFIG_DRAFT) {
            this.lichChiTietListComponent.submitSearchForm(this.oldOrgId, this.fromLichCongTacDate, this.toLichCongTacDate);
        }
        this.getFilteredLichCongTac(0);
    }

    getFilteredLichCongTac(start: number) {
        this.lichCongTacService.getFilteredLichCongTac(0, 0, this.oldSearchKey, this.oldOrgId, this.fromLichCongTacDate, this.toLichCongTacDate).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.collectionSize = response.data.total;
                this.lichCongTacList = response.data.data;
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    gotoEdit(lichId: number) {
        this.router.navigate(['/lichcongtac-edit', lichId]);
    }

    currentLichCongTac: any;
    currentDetailList: DateObject[] = new Array();
    openDetailModal(lichCongTac: any, content: any) {
        this.currentLichCongTac = lichCongTac;
        //get lich chi tiet by date
        let objectList = new Array();
        let listDays = this.commonService.getListOfDays(new Date(lichCongTac.startDate), new Date(lichCongTac.endDate));
        listDays.forEach((day: any) => {
            let filterList = new Array();
            let dateObject = new DateObject();
            dateObject.day = day;
            lichCongTac.lichChiTietList.forEach((lichElement: any) => {
                let tempDate = new Date(lichElement.selectedDate);
                if (tempDate.getDate() == day.getDate() 
                    && tempDate.getMonth() == day.getMonth()
                    && tempDate.getFullYear() == day.getFullYear()) {
                    dateObject.isDisplay = true;
                    filterList.push(lichElement);
                }
            });
            dateObject.morningList = filterList;
            objectList.push(dateObject);
        });
        this.currentDetailList = objectList;
        this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow custom-scrollable-modal'});
    }

    dataURItoBlob(base64: any) {
        let byteString = atob(base64);
        const arrayBuffer = new ArrayBuffer(byteString.length);
        const int8Array = new Uint8Array(arrayBuffer);
        for (let i = 0; i < byteString.length; i++) {
            int8Array[i] = byteString.charCodeAt(i);
        }
        const blob = new Blob([int8Array], { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' });    
        return blob;
    }

    listOfDayObjects: DateObject[] = new Array();
    lichChiTietList: LichChiTiet[] = new Array();
    fromDate = new Date();
    toDate = new Date();
    currentDate = new Date();
    openPreviewModal(content: any) {
        this.currentDate = new Date();
        this.createListOfDays();
        this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow custom-scrollable-modal'});
    }

    moveBack(event: any) {
        event.preventDefault();
        this.currentDate = new Date(this.currentDate.getFullYear(), this.currentDate.getMonth(), this.currentDate.getDate() - 7);
        this.createListOfDays();
    }

    moveForward(event: any) {
        event.preventDefault();
        this.currentDate = new Date(this.currentDate.getTime() + 7 * 24 * 60 * 60 * 1000);
        this.createListOfDays();
    }

    createListOfDays() {
        this.calculateDiff();
        this.filterLichChiTiet();
    }

    filterLichChiTiet() {
        this.previewService.getFilteredLichChiTiet(this.fromDate, this.toDate).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.lichChiTietList = this.lichChiTietService.convertListDataToLichChiTiet(response.data);
                this.listOfDayObjects.forEach((element: any) => {
                    element = this.previewService.createDateObject(element, this.lichChiTietList);
                });
            }
        });
    }

    calculateDiff() {
        let tempDate = new Date(this.currentDate.getFullYear(), this.currentDate.getMonth(), this.currentDate.getDate());
        let week = [];
        
        for (let i = 1; i <= 7; i++) {
            let object = new DateObject();
            let first = tempDate.getDate() - tempDate.getDay() + i;
            if (i == 1) {
                this.fromDate = new Date(tempDate.setDate(first));
            }

            if (i == 7) {
                this.toDate = new Date(tempDate.setDate(first));
            }
            let day = new Date(tempDate.setDate(first));
            object.day = day;
            week.push(object)
        }
        this.listOfDayObjects = week;
        console.log(this.listOfDayObjects);
    }

    // Check Box Action
    lichIdList: number[] = new Array();
    updateLichCongTac(event: any, lichCongTacId :any){
        let isChecked = event.target.checked;
        if (isChecked) {
             this.lichIdList.push(lichCongTacId);
        } else {
             const index: number = this.lichIdList.indexOf(lichCongTacId);
             if (index !== -1) {
                 this.lichIdList.splice(index, 1);
             }        
        } 
        console.log('list: '+this.lichIdList);   
    }
    // Check Box Action

    //select all and deselect  
    selectAll() {
        this.lichCongTacList.forEach((lichCongTac: LichCongTac) => {
            if (this.lichIdList.indexOf(lichCongTac.lichCongTacId) < 0) {
                this.lichIdList.push(lichCongTac.lichCongTacId);
            }
        });
        console.log(this.lichIdList);
    }

    deselectAll() {
        this.lichIdList = new Array();
    }

    //list action update and delete
    openedReturnedModal: any;
    returnedLichCongTacId: any;
    openReturnModal(lichCongTacId: any, content: any) {
        this.returnedLichCongTacId = lichCongTacId;
        this.openedReturnedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow', backdrop: 'static', keyboard: false});
    }

    closeReturnedModal() {
        this.lyDoTraVe = '';
        this.openedReturnedModal.close();
    }

    updateStatus(action: number, lichCongTacId: any, coLyDo: boolean) {
        let lichList = new Array();
        if (typeof lichCongTacId == 'number') {
            lichList.push(lichCongTacId);
        } else if (Array.isArray(lichCongTacId)) {
            lichList = lichCongTacId;
        }
        this.lichCongTacService.updateStatus(action, lichList, this.lyDoTraVe, coLyDo).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getFilteredLichCongTac(startPage);
                if (this.openedReturnedModal) {
                    this.lyDoTraVe = '';
                    this.openedReturnedModal.close();
                }
                if (Constants.CONFIGURATION !== LichConstants.CONFIG_DRAFT) {
                    this.lichChiTietListComponent.getFilteredLichChiTiet();
                }
                this.lichIdList = new Array();
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    checkArray(content: any) {
        if (Array.isArray(content)) {
            return true;
        }
        return false;
    }
    //delete
    openedModal: any;
    removedLichCongTac: any;
    openDeleteModal(lichCongTac: any, content: any) {
        this.removedLichCongTac = lichCongTac;
        this.openedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow'});
    }

    deleteLichCongTac(lichCongTacId: any) {
        let lichList = new Array();
        if (typeof lichCongTacId == 'number') {
            lichList.push(lichCongTacId);
        } else if (Array.isArray(lichCongTacId)) {
            lichList = lichCongTacId;
        }
        this.lichCongTacService.deleteLichCongTac(lichList).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getFilteredLichCongTac(startPage);
                if (Constants.CONFIGURATION !== LichConstants.CONFIG_DRAFT) {
                    this.lichChiTietListComponent.getFilteredLichChiTiet();
                }
                this.openedModal.close();
                this.lichIdList = new Array();
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    exportFile() {
        this.lichCongTacService.exportExcelFile(this.lichIdList).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let base64String = response.data;
                let now = new Date();
                let excelFileName = 'lichxuat_' + now.getMilliseconds();
                let blob = this.dataURItoBlob(base64String);
                let file = new File([blob], excelFileName, { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' });
                var a = window.document.createElement('a');
                a.href = window.URL.createObjectURL(file);
                a.download = excelFileName;
                // Append anchor to body.
                document.body.appendChild(a)
                a.click();

                // Remove anchor from body
                document.body.removeChild(a)
            }
        });
    }
    
}