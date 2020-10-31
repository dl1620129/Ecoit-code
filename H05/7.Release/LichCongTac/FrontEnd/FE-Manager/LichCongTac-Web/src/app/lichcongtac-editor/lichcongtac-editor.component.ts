import { Component, OnInit, Inject, LOCALE_ID } from '@angular/core';
import { LichCongTacService } from '../service/lichcongtac.service';
import { LichCongTac } from '../model/lichcongtac.model';
import LiferayParams from '../../types/LiferayParams';
import { Constants } from '../common/constants';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { ActivatedRoute, Router } from '@angular/router';
import { NotifierService } from 'angular-notifier';
import { DateTimeAdapter } from 'ng-pick-datetime';
import { LichChiTiet } from '../model/lichchitiet.model';
import { UserService } from '../service/user.service';
import { LichConstants } from '../common/lich-constants';
import { OrganizationService } from '../service/organization.service';
import { CommonService } from '../service/common.service';
import { PreviewService } from '../service/preview.service';
import { LichChiTietService } from '../service/lichchitiet.service';
import { User } from '../model/user.model';
import { of, Observable } from 'rxjs';
import {filter} from 'rxjs/operators';

declare const Liferay: any;
declare var $: any;

@Component({
    selector: 'app-lichcongtac-editor',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + 
    '/o/LichCongTac-Web/app/lichcongtac-editor.component.html',
    styleUrls: [],
    providers: [],
})
export class LichCongTacEditorComponent implements OnInit {

    params: LiferayParams;
    lichCongTacId: number = 0;

    lichCongTac = new LichCongTac();

    usersList: any = [];
    orgsList: any = [];
    userPermissions: string[] = [];
    orgName = 'Người dùng này không thuộc đơn vị nào.';
    stableDetailList: LichChiTiet[] = new Array();
    get configuration () {
        return Constants.CONFIGURATION;
    }

    get LichConstants () {
        return LichConstants;
    }

    listOfDays = new Array();
    lyDoTraVe: string = "";

    constructor(private lichCongTacService : LichCongTacService,
        private routes: ActivatedRoute,
        private router: Router,
        private notifierService: NotifierService,
        private userService: UserService,
        private orgService : OrganizationService,
        dateTimeAdapter: DateTimeAdapter<any>,
        private modalService: NgbModal,
        private commonService: CommonService,
        private previewService: PreviewService,
        private lichChiTietService: LichChiTietService) {
    }

    ngOnInit() {
        this.calculateDiff();
        this.routes.paramMap.subscribe(params => {
            if (params.get('id')) {
                this.lichCongTacId = parseInt(params.get('id'));
                this.lichCongTacService.getLichCongTac(this.lichCongTacId).subscribe((response: any) => {
                    console.log(response);
                    if (response.error_code == Constants.SUCCESSFUL_CODE) {
                        this.lichCongTac = this.lichCongTacService.convertDataToLichCongTac(response.data);
                        this.lichCongTac.organizationId = response.data.organizationId;
                        if (this.lichCongTac.organizationId != 0) {
                            this.orgName = response.data.organizationName;
                        } else if (this.configuration == LichConstants.CONFIG_PUBLISHED) {
                            this.orgName = 'Lịch công tác này không thuộc đơn vị nào.';
                        }
                        console.log(this.lichCongTac);
                        this.calculateDiff();
                        this.filterStableLichChiTiet();
                    }
                });
            } else {
                this.filterStableLichChiTiet();
                this.orgService.getOrganization().subscribe((orgResponse: any) => {
                    console.log(orgResponse);
                    if (orgResponse.error_code == Constants.SUCCESSFUL_CODE) {
                        let orgId = 0;
                        if (orgResponse.data.Organizations.length > 0) {
                            orgId = orgResponse.data.Organizations[0].ID;
                            this.orgName = orgResponse.data.Organizations[0].name;
                        }
                        this.lichCongTac.organizationId = orgId;
                    }
                });
            }
        });

        this.lichCongTacService.checkPermission().subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.userPermissions = response.data.permissions;
            }
        });
    }
    
    createListOfDays() {
        this.calculateDiff();
        this.filterLichChiTiet();
        this.filterStableLichChiTiet();
    }

    filterLichChiTiet() {
        this.lichCongTac.lichChiTietList = this.lichCongTac.lichChiTietList.filter((element: any) => {
            let isExisted = false;
            this.listOfDays.forEach((day: Date) => {
                if (day.getDate() == element.selectedDate.getDate() && day.getMonth() == element.selectedDate.getMonth() 
                && day.getFullYear() == element.selectedDate.getFullYear()) {
                    isExisted = true;
                }
            });
            return isExisted;
        });
        console.log(this.lichCongTac.lichChiTietList);
    }

    calculateDiff() {
        if (this.lichCongTac.startDate &&  this.lichCongTac.endDate) {
            if (this.lichCongTac.endDate < this.lichCongTac.startDate) {
                this.lichCongTac.endDate = this.lichCongTac.startDate;
            }
            //this.lichCongTac.endDate = this.lichCongTac.startDate;
            let tempStartDate = Date.UTC(this.lichCongTac.startDate.getFullYear(), this.lichCongTac.startDate.getMonth(), this.lichCongTac.startDate.getDate());
            let tempEndDate = Date.UTC(this.lichCongTac.endDate.getFullYear(), this.lichCongTac.endDate.getMonth(), this.lichCongTac.endDate.getDate());
            let difference = Math.round(tempEndDate - tempStartDate);
            let numberOfDay = difference / (1000 * 3600 * 24);
            let dateList = new Array();
            for (let i = 0; i <= numberOfDay; i++) {
                let newTime = new Date(this.lichCongTac.startDate.getTime() + (i * 1000 * 3600 * 24));
                dateList.push(newTime);
            }
            this.listOfDays = dateList;
            console.log(this.listOfDays);
        }
    }

    filterStableLichChiTiet() {
        if (Constants.CONFIGURATION != LichConstants.CONFIG_CO_DINH) {
            this.lichChiTietService.getFilteredLichChiTiet(0, 0, -1, this.lichCongTac.startDate, this.lichCongTac.endDate, LichConstants.CONFIG_CO_DINH).subscribe((response: any) => {
                console.log(response);
                if (response.error_code == Constants.SUCCESSFUL_CODE) {
                    this.stableDetailList = this.lichChiTietService.convertListDataToLichChiTiet(response.data.data);
                }
            });
        }
    }


    openedReturnedModal: any;
    returnedLichCongTac: any;
    openReturnModal(content: any) {
        this.openedReturnedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow', backdrop: 'static', keyboard: false});
    }

    closeReturnedModal() {
        this.lyDoTraVe = '';
        this.openedReturnedModal.close();
    }

    saveForm(action: number, coLyDo: boolean, event: any) {
        event.target.disabled = true;
        if (action == -1) {
            if (Constants.CONFIGURATION == LichConstants.CONFIG_CO_DINH) {
                action = LichConstants.SCHEDULE_CO_DINH;
            } else {
                if (!this.lichCongTacId || this.lichCongTacId <= 0) {
                    action = LichConstants.SCHEDULE_ADD;
                } else {
                    switch(Constants.CONFIGURATION) {
                        case LichConstants.CONFIG_ALL:
                            action = LichConstants.SCHEDULE_ADD;
                            break;
                        case LichConstants.CONFIG_DRAFT:
                            action = LichConstants.SCHEDULE_ADD;
                            break;
                        case LichConstants.CONFIG_PENDING:
                            action = LichConstants.SCHEDULE_PENDING;
                            break;
                        case LichConstants.CONFIG_APPROVED:
                            action = LichConstants.SCHEDULE_APPROVED;
                            break;
                        case LichConstants.CONFIG_PUBLISHED:
                            action = LichConstants.SCHEDULE_PENDING;
                            break;
                    }
                }
            }
        }
        this.lichCongTacService.submitLichCongTacForm(this.lichCongTac, this.lichCongTacId, action, coLyDo, this.lyDoTraVe).subscribe((response: any) => {
            event.target.disabled = false;
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                if (this.openedReturnedModal) {
                    this.lyDoTraVe = '';
                    this.openedReturnedModal.close();
                }
                this.router.navigate(['/lichcongtac-list']);
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    /* A custom collapse function */
    customCollapse(event: any) {
        let collapseParent = $(event.target).parents('.collapse-parent');
        if ($(collapseParent).find('.collapse').is(':visible')) {
            $(collapseParent).find('.collapse').removeClass('show');
            console.log("hide");
        } else {
            $(collapseParent).find('.collapse').addClass('show');
            console.log("show");
        }
    }

    addLichChiTiet(day: Date, event: any) {
        let lichChiTiet = new LichChiTiet();
        lichChiTiet.selectedDate = day;
        this.lichCongTac.lichChiTietList.push(lichChiTiet);
        let collapseParent = $(event.target).parents('.collapse-parent');
        if (!$(collapseParent).find('.collapse').is(':visible')) {
            $(collapseParent).find('.collapse').addClass('show');
            console.log("show");
        }
    }

    filteredUsersList(event: any) {
        this.userService.getSuggestedUsers(5, event).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.usersList = response.data;
            }
        });
    }

    public onAddingUser = (user: any): Observable<any> => {
        //let listSize = this.document.signerRels.length;
        let newUser = new User();
        if (typeof user == 'string') {
            newUser.id = user;
            newUser.name = user;
        } else {
            newUser.id = user.id;
            newUser.name = user.name;
        }
        return of(newUser).pipe(filter((temp: any) => temp));
    }

    checkAdd(event: any) {
        console.log(event);
    }

    filteredOrgsList(event: any) {
        this.lichCongTacService.getSuggestedOrgs(5, event).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.orgsList = response.data;
            }
        });
    }

    deleteLichChiTiet(i: number) {
        this.lichCongTac.lichChiTietList.splice(i, 1);
    }

    // Returns the ISO week of the date.
    getWeek(dataDate: Date) {
        return this.commonService.getWeek(dataDate);
    }

    testButton(event: any) {
        event.target.disabled = !event.target.disabled;
    }
}