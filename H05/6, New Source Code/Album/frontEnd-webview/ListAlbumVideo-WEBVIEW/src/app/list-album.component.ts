import { Component, OnInit } from '@angular/core';
import { NewsService } from './imagenew.service';
import { Constants } from './common/Constants';
declare const Liferay: any;
@Component({
    selector: 'list-album',
    templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/ListAlbumVideo-WEBVIEW/app/list-album.component.html'
})

export class ListAlbumComponent implements OnInit {
    
    public urlWebSite= Liferay.ThemeDisplay.getLayoutRelativeURL();
    pageSize = 10;
    page = 1;
    listSize = 0;
    searchKey='';
    newModel:any[]= new Array();
    constructor(public newService: NewsService){}
    get ARTICLE_URL() {
        return Constants.baseUrl + this.urlWebSite.substring(0,this.urlWebSite.lastIndexOf('/'))+ Constants.ARTICLE_URL;
        }
    ngOnInit() {
        let queryData = this.getQueryString();
        if (queryData['id']) {
           
            this.getbyCate(queryData['id']);
        }
        else{
            this.getCategoryData(0);
        }
      
     
    }
    getbyCate(id:number){
        this.newService.getImageByCategory(id).subscribe((res:any)=>{
            this.newModel=res.data.data;
        })
    }
    getCategoryData(start: number) {
        this.newService.getAllCategory(this.pageSize, start, this.searchKey).subscribe((res: any) => {
                this.newModel = res.data[0].data;
                this.listSize = res.data[0].total;
        })
    }
    getQueryString() {
        let hashMap = {};
        let queries = Liferay.currentURL.slice(Liferay.currentURL.indexOf('?') + 1).split('&');
        for (let i = 0; i < queries.length; i++) {
            let hash = queries[i].split('=');
            hashMap[hash[0]] = hash[1];
        }
    
        return hashMap;
    }
    pageChange(event: any) {
        let startPage = (event - 1) * this.pageSize;
        this.getCategoryData(startPage);
    }
}