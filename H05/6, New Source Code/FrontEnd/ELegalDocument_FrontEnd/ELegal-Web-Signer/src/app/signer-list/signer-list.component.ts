import { Component, OnInit } from '@angular/core';
import { SignerService } from '../service/signer.service';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { Constants } from '../common/constants';
import { NotifierService } from 'angular-notifier';
import { LegalSigner } from '../model/legal-signer.model';
import { Router } from '@angular/router';
import { NgbDropdownConfig } from '@ng-bootstrap/ng-bootstrap';

declare const Liferay: any;

@Component({
    selector: 'app-signer-list',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + '/o/ELegal-Web-Signer/app/signer-list.component.html',
    styleUrls: [],
    providers: [],
})
export class SignerListComponent implements OnInit {

    legalSignersList: LegalSigner[] = new Array();

    constructor(private signerService: SignerService, 
        private modalService: NgbModal, 
        private notifierService: NotifierService,
        private router: Router,
        private dropdownConfig: NgbDropdownConfig){
            dropdownConfig.placement = "bottom-right";
    }

    pageSize = 5;
    page = 1;
    listSize = 0;
    searchKey = '';
    removedSigner: any;

    ngOnInit() {
        this.getSignersList(0);
    }

    getSignersList(start: number) {
        this.signerService.getSignersList(start, this.pageSize, this.searchKey).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.listSize = response.data.total;
                this.legalSignersList = response.data.data;
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }

    pageChange(event : any) {
        let startPage = (event - 1) * this.pageSize;
        this.getSignersList(startPage);
    }

    filterList() {
        this.page = 1;
        this.sigIdList = new Array();
        this.getSignersList(0);
    }

    gotoEdit(sigId: number) {
        this.router.navigate(['/signer-edit', sigId]);
    }

    // Check Box Action
    sigIdList: number[] = new Array();
    updateSignerId(event: any, sigId :any){
        let isChecked = event.target.checked;
        if (isChecked) {
            this.sigIdList.push(sigId);
        } else {
            const index: number = this.sigIdList.indexOf(sigId);
            if (index !== -1) {
                this.sigIdList.splice(index, 1);
            }        
        } 
        console.log('list: '+ this.sigIdList);   
    }
    // Check Box Action

    checkArray(content: any) {
        if (Array.isArray(content)) {
            return true;
        }
        return false;
    }
    
    openedModal: any;
    openDeleteModal(legalSigner: any, content: any) {
        this.removedSigner = legalSigner;
        this.openedModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow'});
    }

    deleteSigner(sigId: number) {
        let sigList = new Array();
        if (typeof sigId == 'number') {
            sigList.push(sigId);
        } else if (Array.isArray(sigId)) {
            sigList = sigId;
        }
        this.signerService.deleteSigner(sigList).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let startPage = (this.page - 1) * this.pageSize;
                this.getSignersList(startPage);
                this.openedModal.close();
                this.sigIdList = new Array();
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else if (response.error_code == Constants.CONFLICT_ERROR) {
                this.notifierService.notify('warning', Constants.DELETE_PARAM_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }
}