import { Component, OnInit } from '@angular/core';
import { LatestNewsService } from '../service/latest-new.service';
import { LatestNewModel } from '../Model/latest-news.model';
declare const Liferay: any;
@Component({
    selector: 'latese-news',
    templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/CMS-Web-View-ListNews2/app/latest-new/latest-new.component.html'
})

export class LatestNewsComponent implements OnInit {
    latestNewsModels: LatestNewModel[];
    constructor(public latestNewsService: LatestNewsService) { }

    ngOnInit() { 
        // this.latestNewsService.getAllNews().subscribe((respone: any) =>{
        //     this.latestNewsModels= respone.data.data;
        // })
        this.latestNewsService.getAllLatestNews().subscribe((res: any) =>{
            this.latestNewsModels= res.data.listTinMoiNhat;
        })
        
    }
}