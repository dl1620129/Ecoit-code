import { Component, OnInit } from '@angular/core';
import { LichCongTacService } from '../service/lichcongtac.service';
import { Constants } from '../common/constants';

import { LichChiTiet } from '../model/lichchitiet.model';
import { MonthObject } from '../model/monthObject.model';

declare const Liferay: any;
declare var $: any;

@Component({
    selector: 'app-lichthang',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + 
    '/o/LichCongTac-Web-View-List/app/lichthang.component.html',
    styleUrls: [],
    providers: [],
})
export class LichThangComponent implements OnInit {

    arrayOne(n: number): any[] {
        return Array(n);
    }

    listOfDayObjects: MonthObject[] = new Array();
    lichChiTietList: LichChiTiet[] = new Array();
    fromDate: Date = new Date();
    toDate: Date = new Date();
    numberOfRows = 5;

    currentDate = new Date();
    constructor(private lichCongTacService : LichCongTacService) {
    }

    ngOnInit() {
        this.calculateDiff();
        this.filterLichChiTiet();
    }
    
    moveBack(event: any) {
        event.preventDefault();
        this.currentDate = new Date(this.currentDate.getFullYear(), this.currentDate.getMonth() - 1, this.currentDate.getDate());
        this.calculateDiff();
        this.filterLichChiTiet();
    }

    moveForward(event: any) {
        event.preventDefault();
        this.currentDate = new Date(this.currentDate.getFullYear(), this.currentDate.getMonth() + 1, this.currentDate.getDate());
        this.calculateDiff();
        this.filterLichChiTiet();
    }

    filterLichChiTiet() {
        this.lichCongTacService.getFilteredLichChiTiet(this.fromDate, this.toDate).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.lichChiTietList = this.lichCongTacService.convertDataToLichChiTiet(response.data);
                this.listOfDayObjects.forEach((element: any) => {
                    let filterLichChiTiet = new Array();
                    this.lichChiTietList.forEach((lichElement: any) => {
                        if (lichElement.selectedDate.getDate() == element.day.getDate() && (lichElement.selectedDate.getMonth() == element.day.getMonth())) {
                            filterLichChiTiet.push(lichElement);
                        }
                    });
                    element.chitietList = filterLichChiTiet;
                });
            }
        });
    }

    calculateDiff() {
        let tempDate = new Date(this.currentDate.getFullYear(), this.currentDate.getMonth() + 1, 0);
        let numberOfDay = tempDate.getDate();
        let daysInMonth = [];
        
        this.fromDate = new Date(this.currentDate.getFullYear(), this.currentDate.getMonth(), 1);
        this.toDate = new Date(this.currentDate.getFullYear(), this.currentDate.getMonth(), numberOfDay);
        for(let i = this.fromDate.getDay() - 0; i > 0; i--) {
            let dayBefore = new Date(this.fromDate.getFullYear(), this.fromDate.getMonth(), this.fromDate.getDate() - i);
            let object = new MonthObject();
            object.day = dayBefore;
            daysInMonth.push(object);
        }

        for (let i = 1; i <= numberOfDay; i++) {
            let object = new MonthObject();
            let day = new Date(this.currentDate.getFullYear(), this.currentDate.getMonth(), i);
            object.day = day;
            object.isDisplay = true;
            daysInMonth.push(object);
        }

        for(let i = 1; i <= (6 - this.toDate.getDay()); i++) {
            let dayAfter = new Date(this.toDate.getFullYear(), this.toDate.getMonth(), this.toDate.getDate() + i);
            let object = new MonthObject();
            object.day = dayAfter;
            daysInMonth.push(object);
        }
        this.listOfDayObjects = daysInMonth;
        this.numberOfRows = this.listOfDayObjects.length/7;
        console.log(this.listOfDayObjects);
    }
}