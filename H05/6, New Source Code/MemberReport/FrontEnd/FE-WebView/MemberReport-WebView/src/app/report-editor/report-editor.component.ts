import { Component, OnInit, Inject, LOCALE_ID } from '@angular/core';
import { ReportService } from '../service/report.service';
import LiferayParams from '../../types/LiferayParams';
import { Constants } from '../common/constants';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { NotifierService } from 'angular-notifier';
import { DateTimeAdapter } from 'ng-pick-datetime';
import { Unit } from '../model/unit.model';
import { Validators } from '@angular/forms';
import { ReportConstants } from '../common/report-constants';

declare const Liferay: any;
declare var $: any;

@Component({
    selector: 'app-report-editor',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + 
    '/o/MemberReport-WebView/app/report-editor.component.html',
    styleUrls: [],
    providers: [],
})
export class ReportEditorComponent implements OnInit {
    disableReport= false;
    params: LiferayParams;
    reportId: number = 0;

    unitsList: Unit[] = new Array();
    modifiedDate: Date = new Date();
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
        unitId: 0
    });
    
    userPermissions: string[] = new Array();

    constructor(private reportService : ReportService,
        private routes: ActivatedRoute,
        private router: Router,
        @Inject(LOCALE_ID) private locale: string,
        private notifierService: NotifierService,
        private fb: FormBuilder,
        dateTimeAdapter: DateTimeAdapter<any>) {
            dateTimeAdapter.setLocale("vi-VN"); 
    }

    ngOnInit() {
        this.reportService.getPermission().subscribe((res:any)=>{
            if (res.error_code == Constants.SUCCESSFUL_CODE) {
                console.log(res);
                this.userPermissions = res.data.permissions;
                if (this.userPermissions.indexOf(ReportConstants.PERMISSION_VIEWALL) == -1) {
                    this.reportService.getOrganization().subscribe((orgResponse: any) => {
                        console.log(orgResponse);
                        if (orgResponse.error_code == Constants.SUCCESSFUL_CODE) {
                            let orgId = 0;
                            if (orgResponse.data.Organizations.length > 0) {
                                orgId = orgResponse.data.Organizations[0].ID;
                            }
                            this.reportForm.patchValue({
                                unitId: orgId
                            });
                        }
                    });
                }
            }        
        });
        this.getOrganData();
        this.disableReport=true;
        this.routes.paramMap.subscribe(params => {
            if (params.get('id')) {
                this.reportId = parseInt(params.get('id'));
                this.reportService.getReportDetail(this.reportId).subscribe((response: any) => {
                    console.log(response);
                    if (response.error_code == Constants.SUCCESSFUL_CODE) {
                        let report = response.data;
                        this.reportForm.patchValue({
                            tong: report.tong,
                            congTac: report.congTac,
                            hocTap: report.hocTap,
                            nghiPhep: report.nghiPhep,
                            nghiOm: report.nghiOm,
                            nghiBu: report.nghiBu,
                            liDoKhac: report.liDoKhac,
                            note: report.note,
                            unitId: report.unitId
                        });
                        this.adjustMinValue();
                        this.modifiedDate = report.modifiedDate;
                    }
                });
            }
        });

        this.reportService.getAllUnits().subscribe((response: any) => {
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.unitsList = response.data.list;
            }
        });
    }

    minValue = 0;
    adjustMinValue() {
        this.minValue = this.reportForm.get('congTac').value + this.reportForm.get('hocTap').value + this.reportForm.get('nghiPhep').value
                + this.reportForm.get('nghiOm').value + this.reportForm.get('nghiBu').value + this.reportForm.get('liDoKhac').value;
        this.reportForm.controls['tong'].setValidators([Validators.required, Validators.min(this.minValue)]);
    }

    saveForm() {
        this.reportService.submitReportForm(this.reportForm, this.reportId).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.router.navigate(['/report-list']);
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }
    listOrgan: any=[];
    listOrgan2: any=[];
    getOrganData(){
        this.reportService.getAllOrgan().subscribe((res: any)=>{
            this.listOrgan2=res.data.data;
            this.reportService.convertTreeList(this.listOrgan2,1,this.listOrgan);
            console.log('co cau: '+this.listOrgan);
        })
    }
}
