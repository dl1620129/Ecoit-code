import { Component, OnInit } from '@angular/core';
import { CarouselService } from '../carousel.service';
import { CarouselModels } from '../model/carousel.model';
import { URLConstants } from '../common/URLConstants';
import { Contains } from '../common/Contains.model';

declare const Liferay: any;
@Component({
    selector: 'app-carousel',
    templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/CMS-Web-CarouselSlide/app/carousel.component.html'
})

export class CarouselComponent implements OnInit {
    public urlWebSite= Liferay.ThemeDisplay.getLayoutRelativeURL();
    constructor(public carouselService: CarouselService) { }
    carouselModels:CarouselModels[];
    get HOME_URL() {
        return URLConstants.HOME_URL;
    }

    get ARTICLE_URL() {
        return Contains.baseUrl1 + this.urlWebSite.substring(0,this.urlWebSite.lastIndexOf('/'))+ URLConstants.ARTICLE_URL;
    }
    carouselModelsFirst:CarouselModels= new CarouselModels();
    ngOnInit() { 
        // this.carouselService.getAllNews().subscribe((respone: any) =>{
        //     this.latestNewsModels= respone.data.data;
        // })
        this.carouselService.getAllLatestNews().subscribe((res: any) =>{
            this.carouselModelsFirst= res.data.listTinNoiBat[0];
            this.carouselModels= res.data.listTinNoiBat;
        })
        
    }
}