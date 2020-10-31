import { Component, OnInit } from '@angular/core';
import { NewsService } from './imagenew.service';
import { Constants } from './common/Constants';
declare const Liferay: any;
@Component({
    selector: 'list-album',
    templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/ListAlbumImage-WEBVIEW/app/list-album.component.html'
})

export class ListAlbumComponent implements OnInit {
    public urlWebSite= Liferay.ThemeDisplay.getLayoutRelativeURL();
    pageSize = 9;
    page = 1;
    listSize = 0;
    searchKey='';
    newModel:any[]= new Array();
    constructor(public newService: NewsService){}
    get ARTICLE_URL() {
        return Constants.baseUrl + this.urlWebSite.substring(0,this.urlWebSite.lastIndexOf('/'))+ Constants.ARTICLE_URL;
        }
    ngOnInit() {
        this.getCategoryData(0);
     
    }

    getCategoryData(start: number) {
        this.newService.getAllCategory(this.pageSize, start, this.searchKey).subscribe((res: any) => {
                this.newModel = res.data.data;
                this.listSize = res.data.total;
        })
    }
    pageChange(event: any) {
        let startPage = (event - 1) * this.pageSize;
        this.getCategoryData(startPage);
    }
}