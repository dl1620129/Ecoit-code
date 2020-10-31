import { Component, OnInit, ElementRef, ViewChild } from '@angular/core';
import { LichCongTacService } from '../service/lichcongtac.service';
import { Constants } from '../common/constants';

import { LichChiTiet } from '../model/lichchitiet.model';
import { DateObject } from '../model/dateObject.model';
import { URLConstants } from '../common/URLConstants';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

declare const Liferay: any;
declare var $: any;

@Component({
    selector: 'app-lichtuan',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + 
    '/o/LichCongTac-Web-View-List/app/lichtuan.component.html',
    styleUrls: [],
    providers: [],
})
export class LichTuanComponent implements OnInit {

    listOfDayObjects: DateObject[] = new Array();
    lichChiTietList: LichChiTiet[] = new Array();
    fromDate = new Date();
    toDate = new Date();
    currentDate = new Date();
    printNumber = 0;
    constructor(private lichCongTacService : LichCongTacService, private modalService: NgbModal) {
    }

    public changePrintNumber() {
        Constants.printNumber = this.printNumber;
    }

    get CURRENT_URL() {
        return URLConstants.CURRENT_URL;
    }

    ngOnInit() {
        this.createListOfDays();
    }
    
    moveBack(event: any) {
        event.preventDefault();
        this.currentDate = new Date(this.currentDate.getFullYear(), this.currentDate.getMonth(), this.currentDate.getDate() - 7);
        this.createListOfDays();
    }

    moveForward(event: any) {
        event.preventDefault();
        this.currentDate = new Date(this.currentDate.getTime() + 7 * 24 * 60 * 60 * 1000);
        this.createListOfDays();
    }

    createListOfDays() {
        this.calculateDiff();
        this.filterLichChiTiet();
    }

    filterLichChiTiet() {
        this.lichCongTacService.getFilteredLichChiTiet(this.fromDate, this.toDate).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.lichChiTietList = this.lichCongTacService.convertDataToLichChiTiet(response.data);
                this.listOfDayObjects.forEach((element: any) => {
                    element = this.lichCongTacService.createDateObject(element, this.lichChiTietList);
                });
            }
        });
    }

    calculateDiff() {
        let tempDate = new Date(this.currentDate.getFullYear(), this.currentDate.getMonth(), this.currentDate.getDate());
        let week = [];
        
        for (let i = 1; i <= 7; i++) {
            let object = new DateObject();
            let first = tempDate.getDate() - tempDate.getDay() + i;
            if (i == 1) {
                this.fromDate = new Date(tempDate.setDate(first));
            }

            if (i == 7) {
                this.toDate = new Date(tempDate.setDate(first));
            }
            let day = new Date(tempDate.setDate(first));
            object.day = day;
            week.push(object)
        }
        this.listOfDayObjects = week;
        console.log(this.listOfDayObjects);
    }

    openedPrintModal: any;
    openPrintModal(event: any, content: any) {
        event.preventDefault();
        this.openedPrintModal = this.modalService.open(content, { size: 'lg', centered: true, windowClass: 'no-box-shadow'});
    }

    closePrintModal() {
        this.openedPrintModal.close();
    }

    @ViewChild('printDoc') printDoc: ElementRef;
    printNews(event: any) {
        let restorePage = $('body').html();
        //let restoreHeader = $('head title').text();
        //let restoreFooter = $('footer').html();
        let printContent = $(this.printDoc.nativeElement).clone();
        $('body').empty().html(printContent);
        //$('head title').text('');
        //$('footer').empty();
        window.print();
        $('body').html(restorePage);
        //$('head title').text(restoreHeader);
       // $('footer').html(restoreFooter);
        console.log(this.printDoc.nativeElement);
    }
}