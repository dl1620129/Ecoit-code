import { Component, OnInit, AfterViewInit, ElementRef, ViewChild, AfterViewChecked } from '@angular/core';
import { LichCongTacService } from '../service/lichcongtac.service';
import { Constants } from '../common/constants';

import { LichChiTiet } from '../model/lichchitiet.model';
import { DateObject } from '../model/dateObject.model';

declare const Liferay: any;
declare var $: any;

@Component({
    selector: 'app-print',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + 
    '/o/LichCongTac-Web-View-List/app/printLich.component.html',
    styleUrls: [],
    providers: [],
})
export class PrintComponent implements OnInit, AfterViewChecked {


    listOfDayObjects: DateObject[] = new Array();
    lichChiTietList: LichChiTiet[] = new Array();
    fromDate = new Date();
    toDate = new Date();
    currentDate = new Date();
    isLoaded = false;

    @ViewChild('printDoc') printDoc: ElementRef;
    constructor(private lichCongTacService : LichCongTacService) {
    }

    get Constants() {
        return Constants;
    }

    ngOnInit() {
        let queryData = this.getQueryString();
        if (queryData['currentDate']) {
            this.currentDate = new Date(Number(queryData['currentDate']));
        }
        this.createListOfDays();
    }

    ngAfterViewChecked() {
        if (this.isLoaded) {
            let restorePage = $('body').html();
            let printContent = $(this.printDoc.nativeElement).clone();
            $('body').empty().html(printContent);
            window.print();
            console.log(this.printDoc.nativeElement);
        }
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
                this.isLoaded = true;
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

    getQueryString() {
        let hashMap = {};
        let queries = Liferay.currentURL.slice(Liferay.currentURL.indexOf('?') + 1).split('&');
        for (let i = 0; i < queries.length; i++) {
            let hash = queries[i].split('=');
            hashMap[hash[0]] = hash[1];
        }
        console.log(hashMap);
        return hashMap;
    }
}