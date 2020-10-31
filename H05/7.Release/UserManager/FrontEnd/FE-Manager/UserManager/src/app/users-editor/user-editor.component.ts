import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, ParamMap, Router, Params } from '@angular/router';
import { Constants } from '../common/Constants';
import { NotifierService } from 'angular-notifier';
import { UsersService } from '../service/users.service';
import { UsersModel } from '../model/user.model';
import { DatePipe } from '@angular/common';
import { GetTokenInfoService } from '../service/getTokenInforService.service';
import { SignatureService } from '../service/Signature.service';
declare const Liferay: any;
@Component({
    selector: 'app-editor',
    templateUrl:
        Liferay.ThemeDisplay.getPathContext() +
        '/o/UserManager/app/users-editor.component.html'
})
export class UsersEditorComponent implements OnInit {
    pipe = new DatePipe('en-US');
    pageSize = 10;
    page = 1;
    listSize = 0;
    imgSrc: any;
    disableSc = false;
    constructor(public router: ActivatedRoute, public rt: Router, public notifierService: NotifierService, public service: UsersService, public signService: GetTokenInfoService, private serviceTest: SignatureService) { }
    screenName: any;
    userRankId: any;
    fields: any;
    listImageusers: any;
    listOrgan: any = [];
    listOrgan2: any = [];
    userModel: UsersModel = new UsersModel();
    listChucVuDang: any;
    listCapBac: any;
    listChucVu: any;
    listRole: any;
    listSite: any;
    selectUserRoleList: any = new Array();
    selectUserSiteList: any = new Array();
    listName: any = new Array();
    text = '';
    showChungCoSo = false;
    hienPass = true;
    ngOnInit() {
        this.router.params.subscribe((params: any) => {
            this.screenName = params.screenname;
        })

        if (this.screenName != null) {
            this.hienPass = false;

            this.service.getUserByCnParams(this.screenName).subscribe((res: any) => {
                this.userModel = res.data;
                this.userModel.organizationId = res.data.OrganizationIds;
                this.userModel.RoleIds = res.data.RoleIds;
                this.userModel.SiteIds = res.data.GroupIds;
                this.userModel.password = '';
                this.userModel.rePassword = '';
                this.disableSc = true;
                this.userModel.userId = res.data.userId;
                this.service.getDetailUserRank(this.userModel.userId).subscribe((respone: any) => {
                    this.userModel.positionId = respone.data.userPositionId;
                    this.userModel.positionDangId = respone.data.userPositionDangId;
                    this.userModel.urankId = respone.data.userRankId;
                })
            });
            this.service.getChungThuSoByScreenName(this.screenName).subscribe((result: any) => {
                if (result.error_code == Constants.SUCCESSFUL_CODE) {
                    this.userModel.SerialNumber = result.data.serialNumber;
                    this.userModel.ExpireDate = this.pipe.transform(result.data.fromDate, 'dd/MM/yyyy')
                    this.userModel.ValidDate = this.pipe.transform(result.data.fromDate, 'dd/MM/yyyy')
                    this.userModel.CommonName = result.data.userName;
                    this.userModel.rawData = result.data.rawData;
                    this.pos = result.data.organizationId.split(",");
                    this.subject = this.pos[3].slice(3, this.pos[3].length);
                    this.userModel.organization = result.data.organizationId;
                    this.showChungCoSo = true;
                } else {
                    this.showChungCoSo = false;
                }


            })

        } else {
            this.disableSc = false;
        }
        this.getOrganData();
        this.getChucVuDangData();
        this.getCapBacData();
        this.getRoleData();
        this.getSiteData();
        this.getChucVuData();
    }

    tokenInfo: any;
    tokenInfoUtf8: any;

    pos: any;
    subject: any;

    chechChungCoSo() {
        if (!this.showChungCoSo){
            this.showChungCoSo = true;
            this.getDataToke();
        }
            
        else this.showChungCoSo = false;
      
       

    }
    getDataToke() {
        this.serviceTest.getTokenInfo((data:any) => {
            if (data != '') {
                        this.tokenInfo = JSON.parse(atob(data));
                        this.tokenInfoUtf8 = JSON.parse(decodeURIComponent(escape(JSON.stringify(this.tokenInfo))));
                        console.log(this.tokenInfoUtf8);
                        this.userModel.SerialNumber = this.tokenInfoUtf8.SerialNumber;
                        this.userModel.ExpireDate = this.tokenInfoUtf8.ExpireDate;
                        this.userModel.ValidDate = this.tokenInfoUtf8.ValidDate;
                        this.userModel.CommonName = this.tokenInfoUtf8.CommonName;
                        this.userModel.details = this.tokenInfoUtf8;
                        this.userModel.organization = this.tokenInfoUtf8.Subject;
                        this.pos = this.tokenInfoUtf8.Subject.split(",");
                        this.subject = this.pos[3].slice(3, this.pos[3].length);
                        this.userModel.Issuer = this.tokenInfoUtf8.Issuer;
                        this.userModel.Thumbprint = this.tokenInfoUtf8.Thumbprint;
                    } else {
        
                    }
        
          });
       
    }
    addUserSite(id: number) {
        this.selectUserSiteList.push(id);
        console.log('site:' + this.selectUserSiteList);
    }

    selectRole(id: number) {
        this.selectUserRoleList.push(id);
        console.log('role:' + this.selectUserRoleList);
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

    getRoleData() {
        this.service.getUserRole().subscribe((res: any) => {
            this.listRole = res.data;
        })
    }
    getSiteData() {
        this.service.getUSerSite().subscribe((res: any) => {
            this.listSite = res.data;

        })
    }
    getCapBacData() {
        this.service.getCapBac().subscribe((res: any) => {
            this.listCapBac = res.data[0].userRank;;
        })
    }
    getOrganData() {
        this.service.getAllOrgan().subscribe((res: any) => {
            this.listOrgan2 = res.data;
            this.service.convertTreeList(this.listOrgan2, 1, this.listOrgan);
        })
    }
    selectValueEmail(event: any) {
        let email = event.target.value;
        this.userModel.mail = email + '@portal.bca';
    }
    onSubmit() {
        this.router.params.subscribe((params: any) => {
            this.screenName = params.screenname;
        })

        if (this.userModel.password == this.userModel.rePassword) {
            if (this.screenName != null) {
                this.service.getUserByCnParams(this.userModel.cn).subscribe((resparams: any) => {
                    this.service.updateUser(this.userModel, this.selectUserRoleList, this.selectUserSiteList).subscribe((response: any) => {
                        if (response.error_code == Constants.SUCCESSFUL_CODE) {
                            const userId = response.data.userId;
                            const uid = response.data.uid;
                            if (this.showChungCoSo) {
                                this.service.getChungThuSoByScreenName(uid).subscribe((dataRes: any) => {
                                    console.log(dataRes);
                                    if (dataRes.error_code == Constants.SUCCESSFUL_CODE) {
                                        console.log('update');
                                        this.service.updateChungThuSo(this.userModel, userId, uid).subscribe((res11:any)=>{
                                            console.log(res11);
                                            if(res11.error_code == Constants.IS_DUPLICATE) {
                                                this.notifierService.notify('error',Constants.NOT_IS_DUPLICATE);
                                            }
                                        });
                                    }
                                    else {
                                        console.log('add');
                                        this.service.addChungThuSo(this.userModel, userId, uid).subscribe();
                                    }
                                })
                            }
                            else{
                                this.service.deleteChungThuSo(uid).subscribe();
                            }
                            this.rt.navigate(['/list']);
                            this.service.updateUserRankPoisition(this.userModel, userId).subscribe();
                            this.notifierService.notify('success', Constants.USER_UPDATE);
                        } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                            this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
                        } else if (response.data == 'com.liferay.portal.kernel.exception.UserPasswordException$MustNotBeEqualToCurrent') {
                            this.notifierService.notify('error', Constants.CHECK_PASS);
                        } else {
                            this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
                        }
                    })
                });

            }
            else {
                this.service.getUserByCnParams(this.userModel.cn).subscribe((resparams: any) => {
                    if (resparams.data != null) {
                        this.notifierService.notify('error', 'Tên đăng nhập đã tồn tại. Mời nhập tên khác');
                    } else {
                        this.service.getUserByMailParams(this.userModel.mail).subscribe((resparamsMail: any) => {
                            if (resparamsMail.data != null) {
                                this.notifierService.notify('error', 'Email đã tồn tại. Mời nhập Email khác');
                            } else {
                                this.service.getChungThuSoBySerialNumber(this.userModel.SerialNumber).subscribe((respones: any) => {
                                    if (respones.error_code == Constants.SUCCESSFUL_CODE && this.showChungCoSo == true) {
                                        this.notifierService.notify('error', 'ký số đã được đăng ký bởi người dùng khác');
                                    } else {
                                        this.service.createusers(this.userModel, this.selectUserRoleList, this.selectUserSiteList).subscribe((res: any) => {
                                            let checkMailPortal = 'A user with company 20101 and email address ' + this.userModel.mail + ' is already in use'
                                            let checkMail = 'Email name address ' + this.userModel.mail + ' must validate with com.liferay.portal.kernel.security.auth.DefaultEmailAddressValidator';
                                            let checkCn = 'com.liferay.portal.kernel.exception.UserScreenNameException$MustNotBeDuplicate';
                                            console.log(res);
                                            if (res.error_code == Constants.SUCCESSFUL_CODE) {


                                                const userId = res.data.userId;
                                                const uid = res.data.uid;
                                                if (this.showChungCoSo) {

                                                    this.service.addChungThuSo(this.userModel, userId, uid).subscribe();
                                                }
                                                this.rt.navigate(['/list']);
                                                this.service.createUserRankPosition(this.userModel, userId).subscribe();
                                                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
                                            } else if (res.error_code == Constants.NOT_ACCESS_CODE) {
                                                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);

                                            } else if (res.data === checkMail) {
                                                this.notifierService.notify('error', 'Email không hợp lệ');
                                            }
                                            else if (res.data === checkMailPortal) {
                                                this.notifierService.notify('error', 'Email đã tồn tại');
                                            } else if (res.data === checkCn) {
                                                this.notifierService.notify('error', 'Tên đăng nhập đã tồn tai');
                                            } else {
                                                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
                                            }
                                        })
                                    }
                                })
                            }
                        })
                    }
                });
            }




        }
        else {
            this.notifierService.notify('error', 'mật khẩu và nhập lại mật khẩu không trùng khớp');
        }


    }


}