import { Component, OnInit } from "@angular/core";

import { Routes } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Constants } from '../common/Constants';
import { NotifierService } from 'angular-notifier';
import { UsersModel } from "../model/user.model";
import { UsersService } from '../service/users.service';
import { Router } from '@angular/router';
import { NgbDropdownConfig } from '@ng-bootstrap/ng-bootstrap';
import { ExcelService } from '../service/exportExecel.service';

declare const Liferay: any;
@Component({
    selector: 'app-list',
    templateUrl:
        Liferay.ThemeDisplay.getPathContext() +
        '/o/UserManager/app/users-list.component.html'
})
export class UsersComponent implements OnInit {
    listOrgan: any = [];
    listOrgan2: any = [];
    pageSize = 10;
    page = 1;
    listSize = 0;
    searchKey = '';
    usersModels: UsersModel[] = new Array();
    removedEvent: any;
    searchUser = '';
    orgIdCha: number;
    constructor(public usersService: UsersService, public modalService: NgbModal, public notifierService: NotifierService,
        public rt: Router, private dropdownConfig: NgbDropdownConfig, private excelService: ExcelService) {
        dropdownConfig.placement = "bottom-right";
    }
    ngOnInit() {

        this.getOrgCha();
        this.getOrganData();


    }
    getOrgCha() {
        this.usersService.getOrgCha().subscribe((data: any) => {
            this.orgIdCha = data.data[0].ID;
            this.getusersData(this.orgIdCha);
            console.log('---' + this.orgIdCha);
        })
    }
    search() {
        this.usersService.searchUser(this.searchUser).subscribe((result: any) => {
            this.usersModels = result.data.users;
            this.listSize = result.data.total;
        })
    }

    exportData: any[] = new Array();
    listJson: any = {
        'Họ và tên': '',
        'Số điện thoại': '',
        'Chức vụ ': '',
        'Đơn vị': ''
    }
    chucVu: any;
    getChucVu(id: number) {
        this.usersService.getChucVuDetail(id).subscribe((res1: any) => {
            if (res1.error_code == 'SUCCESSFUL') {
                this.chucVu = res1.data.name;
            } else
                this.chucVu = '';
        })
    }
    getOrganData() {
        this.usersService.getAllOrgan().subscribe((res: any) => {
            this.listOrgan2 = res.data;
            this.usersService.convertTreeList(this.listOrgan2, 1, this.listOrgan);
        })
    }
    selectXuat(event: any) {
        this.exportData = [];
        console.log(event.target.value);
        if (event.target.value == 0) {
            this.usersService.getAllusers(this.orgIdCha).subscribe((res: any) => {
                this.usersModels = res.data.users;
                this.listSize = res.data.total;
                if (event.target.value != 0) {
                    for (let index = 0; index < this.usersModels.length; index++) {
                        if (this.usersModels[index].OrganizationIds.length > 0) {
                            if (this.usersModels[index].OrganizationIds[0].ID == event.target.value) {
                                console.log('1');
                                this.listJson = {
                                    'Họ và tên': this.usersModels[index].displayName,
                                    'Số điện thoại': this.usersModels[index].mobile,
                                    'Chức vụ ': this.usersModels[index].chucVu,
                                    // 'Email ': this.usersModels[index].mail,
                                    'Đơn vị': this.usersModels[index].OrganizationIds[0].name
                                }
                                this.exportData.push(this.listJson);
                            } else { }
                        } else { }
                    }

                }
                else {
                    for (let index = 0; index < this.usersModels.length; index++) {
                        if (this.usersModels[index].OrganizationIds.length > 0) {
                            console.log('2');
                            this.listJson = {
                                'Họ và tên': this.usersModels[index].displayName,
                                'Số điện thoại': this.usersModels[index].mobile,
                                'Chức vụ ': this.usersModels[index].chucVu,
                                // 'Email ': this.usersModels[index].mail,
                                'Đơn vị': this.usersModels[index].OrganizationIds[0].name
                            }
                        } else {
                            console.log('3');
                            this.listJson = {
                                'Họ và tên': this.usersModels[index].displayName,
                                'Số điện thoại': this.usersModels[index].mobile,
                                'Chức vụ ': this.usersModels[index].chucVu,
                                // 'Email ': this.usersModels[index].mail,
                                // 'Đơn vị': this.usersModels[index].OrganizationIds[0].name
                            }
                        }

                        this.exportData.push(this.listJson);
                    }
                }
            })
        } else {
            this.usersService.getUserbyOrg(event.target.value).subscribe((data: any) => {
                this.usersModels = data.data;
                this.listSize = data.data.length;
                if (event.target.value != 0) {
                    for (let index = 0; index < this.usersModels.length; index++) {
                        if (this.usersModels[index].OrganizationIds.length > 0) {
                            if (this.usersModels[index].OrganizationIds[0].ID == event.target.value) {
                                console.log('4');
                                this.listJson = {
                                    'Họ và tên': this.usersModels[index].displayName,
                                    'Số điện thoại': this.usersModels[index].mobile,
                                    'Chức vụ ': this.usersModels[index].chucVu,
                                    // 'Email ': this.usersModels[index].mail,
                                    'Đơn vị': this.usersModels[index].OrganizationIds[0].name
                                }
                                console.log(this.exportData);
                                this.exportData.push(this.listJson);
                            } else { }
                        } else { }
                    }

                }
                else {
                    for (let index = 0; index < this.usersModels.length; index++) {
                        if (this.usersModels[index].OrganizationIds.length > 0) {
                            console.log('5');
                            this.listJson = {
                                'Họ và tên': this.usersModels[index].displayName,
                                'Số điện thoại': this.usersModels[index].mobile,
                                'Chức vụ ': this.usersModels[index].chucVu,
                                // 'Email ': this.usersModels[index].mail,
                                'Đơn vị': this.usersModels[index].OrganizationIds[0].name
                            }
                        } else {
                            console.log('6');
                            this.listJson = {
                                'Họ và tên': this.usersModels[index].displayName,
                                'Số điện thoại': this.usersModels[index].mobile,
                                'Chức vụ ': this.usersModels[index].chucVu,
                                // 'Email ': this.usersModels[index].mail,
                                // 'Đơn vị': this.usersModels[index].OrganizationIds[0].name
                            }
                        }

                        console.log(this.exportData);
                        this.exportData.push(this.listJson);
                    }
                }
            })
        }

    }
    exportAsXLSX(): void {
        console.log(this.exportData);
        if (this.exportData == [] || this.exportData.length == 0) {
            for (let index = 0; index < this.usersModels.length; index++) {
                if (this.usersModels[index].OrganizationIds.length > 0) {
                    console.log('7');
                    console.log('---'+this.usersModels[index].OrganizationIds[0].name)
                    this.listJson = {
                        'Họ và tên': this.usersModels[index].displayName,
                        'Số điện thoại': this.usersModels[index].mobile,
                        'Chức vụ ': this.usersModels[index].chucVu,
                        // 'Email ': this.usersModels[index].mail,
                        'Đơn vị': this.usersModels[index].OrganizationIds[0].name
                    }
                } else {
                    console.log('8');
                    this.listJson = {
                        'Họ và tên': this.usersModels[index].displayName,
                        'Số điện thoại': this.usersModels[index].mobile,
                        'Chức vụ ': this.usersModels[index].chucVu,
                        // 'Email ': this.usersModels[index].mail,
                    }
                }

                this.exportData.push(this.listJson);
            }
        }
        this.excelService.exportAsExcelFile(this.exportData, 'Danh bạ');
        this.exportData = [];
    }
    activeStatusUser(type: any, cn: any) {
        if (type == 'active') {
            this.usersService.activeUser(2, cn).subscribe((res: any) => {
                if (res.error_code == Constants.SUCCESSFUL_CODE) {
                    this.activemodal.close();
                    this.ngOnInit();
                    this.notifierService.notify('success', 'Bạn đã hủy kích hoạt tài khoản');
                } else {
                    this.notifierService.notify('error', 'không thể kích hoạt tài khoản');
                }
            });
        } else {
            this.usersService.activeUser(1, cn).subscribe((res: any) => {
                if (res.error_code == Constants.SUCCESSFUL_CODE) {
                    this.activemodal.close();
                    this.ngOnInit();
                    this.notifierService.notify('success', 'Bạn đã  kích hoạt tài khoản');
                } else {
                    this.notifierService.notify('error', 'không thể hủy kích hoạt tài khoản');
                }
            });

        }

    }
    getusersData(id:number) {
        this.usersService.getAllusers(id).subscribe((res: any) => {
            if (res.error_code == Constants.SUCCESSFUL_CODE) {
                this.usersModels = res.data.users;
                this.listSize = res.data.total;
            } else if (res.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        })

    }

    removeUsers(cn: string, id: number) {
        this.usersService.deleteUsers(cn).subscribe((response: any) => {
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.getusersData(this.orgIdCha);
                this.usersService.deleteChungThuSo(cn).subscribe();
                this.usersService.deleteUserRank(id).subscribe();
                this.openedModal.close();
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        })

    }
    openedModal: any;
    openDeleteModal(event: any, content: any) {
        this.removedEvent = event;
        this.openedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow' });

    }
    activemodal: any;
    openactivemodal(event: any, content: any) {
        this.removedEvent = event;
        this.activemodal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow' });

    }
    filterList() {
        this.page = 1;
        this.search();
    }

}