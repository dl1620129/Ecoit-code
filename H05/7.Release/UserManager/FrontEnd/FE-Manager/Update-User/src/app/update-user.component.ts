import { Component, OnInit } from '@angular/core';
import { UsersService } from './service/users.service';
import { UsersModel } from './model/user.model';
import { Constants } from './common/Constants';

import { NotifierService } from 'angular-notifier';

declare const Liferay: any;
@Component({
    selector: 'app-user',
    templateUrl:
        Liferay.ThemeDisplay.getPathContext() +
        '/o/Update-User/app/update-user.component.html'
})
export class UpdateUserComponent implements OnInit {
    userModel: UsersModel = new UsersModel();
    listChucVuDang: any;
    listCapBac: any;
    listOrgan: any = [];
    listOrgan2: any = [];
    listChucVu: any;
    constructor(private service: UsersService, private notifierService: NotifierService) { }
    ngOnInit() {
        this.service.getUserByMailParams().subscribe((res: any) => {
            console.log(res);
            this.userModel.displayName = res.data.displayName;
            this.userModel.mobile = res.data.mobile;
            this.userModel.mail = res.data.mail;
            this.userModel = res.data;
            this.userModel.organizationId = res.data.OrganizationIds;
            this.userModel.RoleIds = res.data.RoleIds;
            this.userModel.SiteIds = res.data.GroupIds;
            this.userModel.userId = res.data.userId;
            this.userModel.password = '';
            this.userModel.rePassword = '';
            this.service.getDetailUserRank(this.userModel.userId).subscribe((respone: any) => {
                this.userModel.positionId = respone.data.userPositionId;
                this.userModel.positionDangId = respone.data.userPositionDangId;
                this.userModel.urankId = respone.data.userRankId;
            })

        })
        this.getCapBacData();
        this.getChucVuData();
        this.getChucVuDangData();
        this.getOrganData();
    }

    getOrganData() {
        this.service.getAllOrgan().subscribe((res: any) => {
            this.listOrgan2 = res.data;
            this.service.convertTreeList(this.listOrgan2, 1, this.listOrgan);
        })
    }
    getCapBacData() {
        this.service.getCapBac().subscribe((res: any) => {
            this.listCapBac = res.data[0].userRank;;
        })
    }
    getChucVuDangData() {
        this.service.getChucVuDang().subscribe((res: any) => {
            this.listChucVuDang = res.data.userPoisition;
        })
    }
    getChucVuData() {
        this.service.getChucVu().subscribe((res: any) => {
            this.listChucVu = res.data[0].userChucDanh;
        })
    }
    saveUser() {
        if (this.userModel.password == this.userModel.rePassword) {
            this.service.updateUser(this.userModel).subscribe((response: any) => {
                if (response.error_code == Constants.SUCCESSFUL_CODE) {
                    this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
                    this.service.updateUserRankPoisition(this.userModel, this.userModel.userId).subscribe();
                } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                    this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
                } else {
                    this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
                }
            })
        } else {
            this.notifierService.notify('error', 'mật khẩu và nhập lại mật khẩu không trùng khớp');
        }

    }

}