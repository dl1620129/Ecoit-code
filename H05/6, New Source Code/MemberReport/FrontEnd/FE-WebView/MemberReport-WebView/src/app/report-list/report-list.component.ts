import { Component, OnInit, Inject, LOCALE_ID } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Constants } from '../common/constants';
import { ReportService } from '../service/report.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { NotifierService } from "angular-notifier";
import { MemberReport } from '../model/report.model';
import { DateTimeAdapter } from 'ng-pick-datetime';
import { Unit } from '../model/unit.model';
import { runInThisContext } from 'vm';
import { ReportConstants } from '../common/report-constants';

declare const Liferay: any;
declare var $: any;

@Component({
    selector: 'app-report-list',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + '/o/MemberReport-WebView/app/report-list.component.html',
    styleUrls: [],
    providers: [],
})
export class ReportListComponent implements OnInit {

    pageSize = 10;
    collectionSize = 0;
    page = 1;
    searchKey: any = "";

    oldSearchForm: any;

    unitsList: Unit[] = new Array();
    reportsList: MemberReport[] = new Array();

    constructor(private fb: FormBuilder,
        private reportService: ReportService,
        private modalService: NgbModal,
        private notifierService: NotifierService,
        dateTimeAdapter: DateTimeAdapter<any>) {
        dateTimeAdapter.setLocale("vi-VN");
    };

    searchForm = this.fb.group({
        modifiedDate: [''],
        unitId: -1
    });
    get ReportConstants() {
        return ReportConstants;
    }
    userPermissions: string[] = [''];
    checkTime(event:any){
       
        if(this.searchForm.get('modifiedDate').value==null){
          this.searchForm.patchValue({
              modifiedDate: new Date()
          });
        }
          
      }
    ngOnInit() {
        this.note=[];
        this.searchForm.patchValue({
            modifiedDate: new Date()
        });
        this.date = this.searchForm.get('modifiedDate').value.toLocaleDateString("vi-VN").toString();
        this.getOrganData();
        this.oldSearchForm = this.searchForm;
        // this.getFilteredReport(0);
        this.reportService.getAllUnits().subscribe((response: any) => {
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.unitsList = response.data.list;
            }
        });
        this.reportService.getPermission().subscribe((res:any)=>{
            console.log(res);
            if (res.error_code == Constants.SUCCESSFUL_CODE) {
                this.userPermissions = res.data.permissions;
                if (this.userPermissions.indexOf(ReportConstants.PERMISSION_VIEWALL) == -1) {
                    this.reportService.getOrganization().subscribe((orgResponse: any) => {
                        console.log(orgResponse);
                        if (orgResponse.error_code == Constants.SUCCESSFUL_CODE) {
                            let orgId = 0;
                            if (orgResponse.data.Organizations.length > 0) {
                                orgId = orgResponse.data.Organizations[0].ID;
                            }
                            this.searchForm.patchValue({
                                unitId: orgId
                            });
                        }
                        this.getFilteredReport(0);
                    });
                } else {
                    this.getFilteredReport(0);
                }
            }        
        });
      
        
    }

    pageChange(event: any) {
        let startPage = (event - 1) * this.pageSize;
        this.getFilteredReport(startPage);
    }

    submitSearchForm() {
        this.tong = 0;
        this.hocTap = 0;
        this.nghiPhep = 0;
        this.nghiOm = 0;
        this.nghiBu = 0;
        this.liDoKhac = 0;
        this.congTac = 0;
        this.note = [];
        this.oldSearchForm = this.searchForm;
        this.page = 1;
        this.date = this.searchForm.get('modifiedDate').value.toLocaleDateString("vi-VN").toString();
        this.getFilteredReport(0);
    }
    date: any;
    tong = 0;
    hocTap = 0;
    nghiPhep = 0;
    nghiOm = 0;
    nghiBu = 0;
    liDoKhac = 0;
    note: any[] = new Array();
    congTac = 0;
    getFilteredReport(start: number) {
        this.reportService.getFilteredReport(this.oldSearchForm, start, this.pageSize).subscribe((response: any) => {
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.tong = 0;
                this.hocTap = 0;
                this.nghiPhep = 0;
                this.nghiOm = 0;
                this.nghiBu = 0;
                this.liDoKhac = 0;
                this.note=[];
                this.collectionSize = response.data.total;
                this.reportsList = response.data.list;
                for (let index = 0; index < this.reportsList.length; index++) {
                    this.tong += this.reportsList[index].tong;
                    this.congTac += this.reportsList[index].congTac;
                    this.hocTap += this.reportsList[index].hocTap;
                    this.nghiPhep += this.reportsList[index].nghiPhep;
                    this.nghiOm += this.reportsList[index].nghiOm;
                    this.nghiBu += this.reportsList[index].nghiBu;
                    this.liDoKhac += this.reportsList[index].liDoKhac;
                    if (this.reportsList[index].note != '') {
                        this.note.push('-' + this.reportsList[index].note);
                    }

                }
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    } listOrgan: any = [];
    listOrgan2: any = [];
    getOrganData() {
        this.reportService.getAllOrgan().subscribe((res: any) => {
            this.listOrgan2 = res.data.data;
            this.reportService.convertTreeList(this.listOrgan2, 1, this.listOrgan);
        })
    }

}