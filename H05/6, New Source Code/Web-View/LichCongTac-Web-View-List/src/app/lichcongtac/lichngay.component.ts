import { Component, OnInit } from '@angular/core';
import { LichCongTacService } from '../service/lichcongtac.service';
import { Constants } from '../common/constants';

import { ActivatedRoute, Router } from '@angular/router';
import { LichChiTiet } from '../model/lichchitiet.model';
import { DateObject } from '../model/dateObject.model';

declare const Liferay: any;
declare var $: any;

@Component({
    selector: 'app-lichngay',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + 
    '/o/LichCongTac-Web-View-List/app/lichngay.component.html',
    styleUrls: [],
    providers: [],
})
export class LichNgayComponent implements OnInit {

    lichChiTietList: LichChiTiet[] = new Array();
    dateObject: DateObject= new DateObject();
    currentDate = new Date();
    constructor(private lichCongTacService : LichCongTacService,
        private routes: ActivatedRoute,
        private router: Router) {
    }

    ngOnInit() {
        this.routes.paramMap.subscribe(params => {
            if (params.get('inputdate')) {
                this.currentDate = new Date(Number(params.get('inputdate')));
            }
            this.currentDate = new Date(this.currentDate.getFullYear(), this.currentDate.getMonth(), this.currentDate.getDate());
            this.filterLichChiTiet();
        });
    }
    
    moveBack(event: any) {
        event.preventDefault();
        this.currentDate = new Date(this.currentDate.getFullYear(), this.currentDate.getMonth(), this.currentDate.getDate() - 1);
        this.filterLichChiTiet();
    }

    moveForward(event: any) {
        event.preventDefault();
        this.currentDate = new Date(this.currentDate.getTime() + 24 * 60 * 60 * 1000);
        this.filterLichChiTiet();
    }

    filterLichChiTiet() {
        this.dateObject.day = this.currentDate;
        this.lichCongTacService.getFilteredLichChiTiet(this.currentDate, this.currentDate).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.lichChiTietList = this.lichCongTacService.convertDataToLichChiTiet(response.data);
                this.dateObject = this.lichCongTacService.createDateObject(this.dateObject, this.lichChiTietList);
            }
        });
    }
}