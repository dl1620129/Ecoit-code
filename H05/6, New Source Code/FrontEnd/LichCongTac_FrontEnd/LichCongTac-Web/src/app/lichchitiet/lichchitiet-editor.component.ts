import { Component, OnInit, Inject, LOCALE_ID } from '@angular/core';
import { LichCongTacService } from '../service/lichcongtac.service';
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
import { LichChiTietService } from '../service/lichchitiet.service';
import { of, Observable } from 'rxjs';
import {filter} from 'rxjs/operators';
import { User } from '../model/user.model';

declare const Liferay: any;
declare var $: any;

@Component({
    selector: 'app-lichchitiet-editor',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + 
    '/o/LichCongTac-Web/app/lichchitiet-editor.component.html',
    styleUrls: [],
    providers: [],
})
export class LichChiTietEditorComponent implements OnInit {

    params: LiferayParams;
    lichChiTietId: number = 0;

    lichChiTiet = new LichChiTiet();

    usersList: any = [];
    orgsList: any = [];
    userPermissions: string[] = [];
    orgName = 'Người dùng này không thuộc đơn vị nào.';
    get configuration () {
        return Constants.CONFIGURATION;
    }

    get LichConstants () {
        return LichConstants;
    }

    lyDoTraVe: string = "";

    constructor(private lichChiTietService: LichChiTietService,
        private routes: ActivatedRoute,
        private router: Router,
        private notifierService: NotifierService,
        private userService: UserService,
        private orgService : OrganizationService,
        dateTimeAdapter: DateTimeAdapter<any>,
        private modalService: NgbModal,
        private commonService: CommonService,
        private lichCongTacService : LichCongTacService) {
    }

    ngOnInit() {
        this.routes.paramMap.subscribe(params => {
            if (params.get('id')) {
                this.lichChiTietId = parseInt(params.get('id'));
                this.lichChiTietService.getLichChiTiet(this.lichChiTietId).subscribe((response: any) => {
                    console.log(response);
                    if (response.error_code == Constants.SUCCESSFUL_CODE) {
                        this.lichChiTiet = this.lichChiTietService.convertDataToLichChiTiet(response.data);
                        if (this.lichChiTiet.organizationId != 0) {
                            this.orgName = response.data.organizationName;
                        } else if (this.configuration == LichConstants.CONFIG_PUBLISHED) {
                            this.orgName = 'Lịch công tác này không thuộc đơn vị nào.';
                        } 
                    }
                });
            } else {
                this.orgService.getOrganization().subscribe((orgResponse: any) => {
                    console.log(orgResponse);
                    if (orgResponse.error_code == Constants.SUCCESSFUL_CODE) {
                        let orgId = 0;
                        if (orgResponse.data.Organizations.length > 0) {
                            orgId = orgResponse.data.Organizations[0].ID;
                            this.orgName = orgResponse.data.Organizations[0].name;
                        }
                        this.lichChiTiet.organizationId = orgId;
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
            if (!this.lichChiTietId || this.lichChiTietId <= 0) {
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
        this.lichChiTietService.submitLichChiTietForm(this.lichChiTiet, this.lichChiTietId, action, coLyDo, this.lyDoTraVe).subscribe((response: any) => {
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

    // Returns the ISO week of the date.
    getWeek(dataDate: Date) {
        return this.commonService.getWeek(dataDate);
    }

}