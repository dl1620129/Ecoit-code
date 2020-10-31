import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Constants } from '../common/constants';
import { ReportService } from '../service/report.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { NotifierService } from "angular-notifier";
import { MemberReport } from '../model/report.model';
import { DateTimeAdapter } from 'ng-pick-datetime';
import { OrganizationService } from '../service/organization.service';
import { Organization } from '../model/organization.model';
import { Router } from '@angular/router';
import { ReportConstants } from '../common/report-constants';
import { NgbDropdownConfig } from '@ng-bootstrap/ng-bootstrap';
declare const Liferay: any;
declare var $: any;

@Component({
    selector: 'app-report-list',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + '/o/MemberReport-Web/app/report-list.component.html',
    styleUrls: [],
    providers: [],
})
export class ReportListComponent implements OnInit {

    pageSize = 10;
    collectionSize = 0;
    page = 1;
    searchKey: any = "";
    
    oldSearchForm: any;
    userPermissions: string[] = [''];
    organizationsList: Organization[] = new Array();
    reportsList: MemberReport[] = new Array();

    constructor(private fb: FormBuilder,
        private reportService: ReportService,
        private modalService: NgbModal,
        private notifierService: NotifierService,
        private organService: OrganizationService,   private router: Router,private  dropdownConfig:NgbDropdownConfig,
        dateTimeAdapter: DateTimeAdapter<any>){
            dateTimeAdapter.setLocale("vi-VN"); 
            dropdownConfig.placement = "bottom-right";
        };

    searchForm = this.fb.group({
        modifiedDate: [''],
        unitId: -1
    });

    get ReportConstants() {
        return ReportConstants;
    }

    ngOnInit() {
        this.searchForm.patchValue({
            modifiedDate: new Date()
        });
        this.oldSearchForm = this.searchForm;
        this.organService.getAllOrgan().subscribe((response: any) => {
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.organizationsList = this.organService.convertTreeList(response.data, 0);
            }
        });

        this.reportService.getPermission().subscribe((res:any)=>{
            if (res.error_code == Constants.SUCCESSFUL_CODE) {
                this.userPermissions = res.data.permissions;
                if (this.userPermissions.indexOf(ReportConstants.PERMISSION_VIEWALL) == -1) {
                    this.organService.getOrganization().subscribe((orgResponse: any) => {
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

    pageChange(event : any) {
        let startPage = (event - 1) * this.pageSize;
        this.getFilteredReport(startPage);
    }

    submitSearchForm() {
        this.oldSearchForm = this.searchForm;
        this.page = 1;
        
        this.getFilteredReport(0);
    }
    gotoEdit(lichId: number) {
        this.router.navigate(['/report-edit', lichId]);
    }
    checkTime(event:any){
       
      if(this.searchForm.get('modifiedDate').value==null){
        this.searchForm.patchValue({
            modifiedDate: new Date()
        });
      }
        
    }
    tong:any;congTac:any;hocTap:any;nghiPhep:any;nghiOm:any;nghiBu:any;liDoKhac:any;note:any;
    getFilteredReport(start: number) {
        this.reportService.getFilteredReport(this.oldSearchForm, start, this.pageSize).subscribe((response: any) => {
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.collectionSize = response.data.total;
                this.reportsList = response.data.list;
                for (let index = 0; index < this.reportsList.length; index++) {
                    this.tong+= this.reportsList[index].tong;
                    this.congTac+= this.reportsList[index].congTac;
                    this.hocTap+= this.reportsList[index].hocTap;
                    this.nghiPhep+= this.reportsList[index].nghiPhep;
                    this.nghiOm+= this.reportsList[index].nghiOm;
                    this.nghiBu+= this.reportsList[index].nghiBu;
                    this.liDoKhac+= this.reportsList[index].liDoKhac;
                    this.note+=this.reportsList[index].note;
                }
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    openedModal: any;
    removedReport: any;
    openDeleteModal(memberReport: any, content: any) {
        this.removedReport = memberReport;
        this.openedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow'});
    }

    deleteReport(id: number) {
        this.reportService.deleteReport(id).subscribe((response: any) => {
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getFilteredReport(startPage);
                this.openedModal.close();
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }
}