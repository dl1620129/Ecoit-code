import { Component, OnInit, Inject, LOCALE_ID } from '@angular/core';
import { ReportService } from '../service/report.service';
import LiferayParams from '../../types/LiferayParams';
import { Constants } from '../common/constants';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { NotifierService } from 'angular-notifier';
import { DateTimeAdapter } from 'ng-pick-datetime';
import { Validators } from '@angular/forms';
import { OrganizationService } from '../service/organization.service';
import { Organization } from '../model/organization.model';
import { ReportConstants } from '../common/report-constants';
import { HistoryService } from '../service/history.service';
import { HistoryModel } from '../model/history.model';
import { start } from 'repl';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

declare const Liferay: any;
declare var $: any;

@Component({
    selector: 'app-report-editor',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + 
    '/o/MemberReport-Web/app/report-editor.component.html',
    styleUrls: [],
    providers: [],
})
export class ReportEditorComponent implements OnInit {

    params: LiferayParams;
    reportId: number = 0;
    listHistory:HistoryModel[]= new Array();
    pageSize = 10;
    collectionSize = 0;
    page = 1;
    searchKey: any = "";
    organizationsList: Organization[] = new Array();
    modifiedDate: Date = new Date();
    listUser:any[]= new Array();
    congtacData:any;
    hocTapData:any;
    nghiOmData:any;
    nghiPhepData:any;
    nghiBuData:any;
    lyDoKhacData:any;
    orgName = "Người dùng này không thuộc đơn vị nào.";
    get configuration () {
        return Constants.CONFIGURATION;
    }

    reportForm = this.fb.group({
        tong: [0, [Validators.required, Validators.min(0)]],
        congTac: [0, [Validators.required, Validators.min(0)]],
        hocTap: [0, [Validators.required, Validators.min(0)]],
        nghiPhep: [0, [Validators.required, Validators.min(0)]],
        nghiOm: [0, [Validators.required, Validators.min(0)]],
        nghiBu: [0, [Validators.required, Validators.min(0)]],
        liDoKhac: [0, [Validators.required, Validators.min(0)]],
        note: ['', Validators.maxLength(500)],
        unitId: 0,
        listCongTac:[[],[Validators.required]],
        listHocTap:[[],[Validators.required]],
        listNghiPhep:[[],[Validators.required]],
        listNghiOm:[[],[Validators.required]],
        listNghiBu:[[],[Validators.required]],
        listLiDoKhac:[[],[Validators.required]],
    });
    
    get tong() {
        return this.reportForm.get('tong');
    };
    get listCongTac() {
        return this.reportForm.get('listCongTac');
    };

    get congTac() {
        return this.reportForm.get('congTac');
    };

    get hocTap() {
        return this.reportForm.get('hocTap');
    };

    get nghiPhep() {
        return this.reportForm.get('nghiPhep');
    };

    get nghiOm() {
        return this.reportForm.get('nghiOm');
    };

    get nghiBu() {
        return this.reportForm.get('nghiBu');
    };

    get liDoKhac() {
        return this.reportForm.get('liDoKhac');
    };

    get note() {
        return this.reportForm.get('note');
    };
    get ReportConstants (){
        return ReportConstants;
    }
    demCongTac(event:any){
        console.log('tuyen'+event);
    }
    onAdded(event:any){
 
         this.reportForm.controls['congTac'].setValue(this.reportForm.get('listCongTac').value.length);
         this.reportForm.controls['hocTap'].setValue(this.reportForm.get('listHocTap').value.length);
         this.reportForm.controls['nghiPhep'].setValue(this.reportForm.get('listNghiPhep').value.length);
         this.reportForm.controls['nghiOm'].setValue(this.reportForm.get('listNghiOm').value.length);
         this.reportForm.controls['nghiBu'].setValue(this.reportForm.get('listNghiBu').value.length);
         this.reportForm.controls['liDoKhac'].setValue(this.reportForm.get('listLiDoKhac').value.length);
    }
    onItemRemoved(event:any){
        this.reportForm.controls['congTac'].setValue(this.reportForm.get('listCongTac').value.length);
        this.reportForm.controls['hocTap'].setValue(this.reportForm.get('listHocTap').value.length);
        this.reportForm.controls['nghiPhep'].setValue(this.reportForm.get('listNghiPhep').value.length);
        this.reportForm.controls['nghiOm'].setValue(this.reportForm.get('listNghiOm').value.length);
        this.reportForm.controls['nghiBu'].setValue(this.reportForm.get('listNghiBu').value.length);
        this.reportForm.controls['liDoKhac'].setValue(this.reportForm.get('listLiDoKhac').value.length);
    }
    constructor(private reportService : ReportService,
        private routes: ActivatedRoute,
        private router: Router,
        @Inject(LOCALE_ID) private locale: string,
        private notifierService: NotifierService,
        private organService: OrganizationService,
        private fb: FormBuilder,
        dateTimeAdapter: DateTimeAdapter<any>,
        private historyService: HistoryService,
        private modalService: NgbModal) {
            dateTimeAdapter.setLocale("vi-VN"); 
    }
    usersList: any = [];
    userPermissions: string[] = new Array();
    pageChange(event : any) {
        let startPage = (event - 1) * this.pageSize;
        this.getListHistory(this.reportId,startPage);
    }

    filteredUsersList(event: any) {
        this.reportService.getSuggestedUsers(5, event).subscribe((response: any) => {
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.usersList = response.data;
            }
        });
    }
    openedModal: any;
    removedReport: any;
    openHistoryModal(memberReport: any, content: any) {
        this.removedReport = memberReport;
        this.openedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow'});
    }

    ngOnInit() {
        // this.reportService.getAlllUSer().subscribe((userRepone:any)=>{
        //     console.log(userRepone);
        //     this.listUser=userRepone.data.users;
        // })
        this.routes.paramMap.subscribe(params => {
            if (params.get('id')) {
                this.reportId = parseInt(params.get('id'));
                this.reportService.getReportDetail(this.reportId).subscribe((response: any) => {
                    if (response.error_code == Constants.SUCCESSFUL_CODE) {
                        let report = response.data;
                        this.congtacData= JSON.parse(response.data.listCongTac);
                        this.hocTapData= JSON.parse(response.data.listHocTap);
                        this.nghiPhepData= JSON.parse(response.data.listNghiPhep);
                        this.nghiOmData= JSON.parse(response.data.listNghiOm);
                        this.nghiBuData= JSON.parse(response.data.listNghiBu);
                        this.lyDoKhacData= JSON.parse(response.data.listLiDoKhac);
                        this.reportForm.patchValue({
                            tong: report.tong,
                            congTac: report.congTac,
                            hocTap: report.hocTap,
                            nghiPhep: report.nghiPhep,
                            nghiOm: report.nghiOm,
                            nghiBu: report.nghiBu,
                            liDoKhac: report.liDoKhac,
                            note: report.note,
                            unitId: report.unitId,
                            listCongTac:this.congtacData,
                            listHocTap:this.hocTapData,
                            listNghiPhep:this.nghiPhepData,
                            listNghiOm:this.nghiOmData,
                            listNghiBu:this.nghiBuData,
                            listLiDoKhac:this.lyDoKhacData
                        });
                        this.adjustMinValue();
                        this.modifiedDate = report.modifiedDate;
                    }
                });
            }
        });
       this.getListHistory(this.reportId,0);
        this.organService.getAllOrgan().subscribe((response: any) => {
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.organizationsList = this.organService.convertTreeList(response.data, 0);
            }
        });

        this.reportService.getPermission().subscribe((res:any)=>{
            if (res.error_code == Constants.SUCCESSFUL_CODE) {
                this.userPermissions = res.data.permissions;
                // if (this.userPermissions.indexOf(ReportConstants.PERMISSION_VIEWALL) == -1) {
                    this.organService.getOrganization().subscribe((orgResponse: any) => {
                        if (orgResponse.error_code == Constants.SUCCESSFUL_CODE) {
                            let orgId = 0;
                            if (orgResponse.data.Organizations.length > 0) {
                                orgId = orgResponse.data.Organizations[0].ID;
                                this.orgName = orgResponse.data.Organizations[0].name;
                                this.reportService.getAllusersByOrg(orgId).subscribe((userRepone:any)=>{
                                    console.log(userRepone);
                                    this.listUser=userRepone.data;
                                })
                            }
                            this.reportForm.patchValue({
                                unitId: orgId
                            });
                        }
                    });
                // }
            }        
        });
    }
    getListHistory(id: number,start:number){
        this.historyService.getHistoryByReport(id,start,this.pageSize).subscribe((resData:any)=>{
            this.listHistory=resData.data.data;
            this.collectionSize=resData.data.total;
        })
    }
    minValue = 0;
    adjustMinValue() {
        this.minValue = this.reportForm.get('congTac').value + this.reportForm.get('hocTap').value + this.reportForm.get('nghiPhep').value
                + this.reportForm.get('nghiOm').value + this.reportForm.get('nghiBu').value + this.reportForm.get('liDoKhac').value;
        this.reportForm.controls['tong'].setValidators([Validators.required, Validators.min(this.minValue)]);
    }

    saveForm() {
        
        if((this.reportForm.get('congTac').value + this.reportForm.get('hocTap').value + this.reportForm.get('nghiPhep').value
        + this.reportForm.get('nghiOm').value + this.reportForm.get('nghiBu').value + this.reportForm.get('liDoKhac').value)> this.reportForm.get('tong').value){
            this.notifierService.notify('error','Tổng đang nhỏ hơn các số bạn nhập, Hãy nhập lại');
        }else{
            if(this.reportId&& this.reportId>0){
                this.reportService.createHistory(this.reportForm,this.reportId,1).subscribe();
            }
            this.reportService.submitReportForm(this.reportForm, this.reportId).subscribe((response: any) => {
                if (response.error_code == Constants.SUCCESSFUL_CODE) {
                    if(this.reportId==null || this.reportId==undefined||this.reportId<=0){
                        this.reportService.createHistory(this.reportForm,response.data,2).subscribe();
                    }
                    this.router.navigate(['/report-list']);
                    this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
                } else if (response.data == 'khong them duoc') {
                    this.notifierService.notify('error','Ngày hôm nay đã có báo cáo, không thêm mới được');
                } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                    this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
                } else {
                    this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
                }
            });
        }
       
    }
}