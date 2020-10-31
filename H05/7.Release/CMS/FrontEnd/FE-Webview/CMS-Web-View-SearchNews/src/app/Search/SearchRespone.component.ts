import { Component,OnInit } from "@angular/core";
import { SearchResponeService } from '../service/SearchRespone.service';
import { SearchResponeModel } from '../model/SearchRespone.model';
import { URLConstants } from "../Common/URLConstants";
import { FormControl,FormGroup } from '@angular/forms';
import { HttpParameterCodec } from '@angular/common/http';
declare const Liferay: any;
@Component({
    selector: 'app-search',
	templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/CMS-Web-View-SearchNews/app/SearchRespone.component.html'
})
export class SearchResponeComponent implements OnInit{

    keyWord: any;
    total: number;
    pageSize = 8;
    listSize = 0;
    page = 1;
    SearchResponeModels: SearchResponeModel[];
    constructor(public SearchService: SearchResponeService){}
    ngOnInit() {
 
        this.showNewsData(0);
    }

    get HOME_URL() {
        return URLConstants.HOME_URL;
    }

    get ARTICLE_URL() {
        return URLConstants.ARTICLE_URL;
    }
    // searchForm = new FormGroup({
    //     fromDate: new FormControl[''],
    //     keyword:new FormControl[''],
    //     tags:new FormControl[''],
    //     toDate:new FormControl[''],
    //     categoryIds:new FormControl['']
    // })
    showNewsData(start: number){
        let queryData = this.getQueryString();
            this.keyWord = queryData['keyword'];
            if(this.keyWord == 'undefined'){
                this.keyWord = '';
            }
            this.keyWord=decodeURIComponent(this.keyWord)
            let re = /\+/gi;
            this.keyWord = this.keyWord.replace(re, " ");
            console.log(this.keyWord);
            this.SearchService.searchNews(this.keyWord).subscribe((res:any)=>{
                this.SearchResponeModels=res.data.data;
                this.listSize=res.data.total;
            })
            // this.SearchService.getAllSearchRespone(this.keyWord,start,this.pageSize).subscribe((response: any) => {
            //     this.SearchResponeModels= response.data.data;
            //     this.listSize=response.data.total;
            // });
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
    pageChange(event : any) {
        let startPage = (event - 1) * this.pageSize;
        this.showNewsData(startPage);
    }
    // onSearch(form:any){
    //     this.SearchService.searchNews(this.searchForm).subscribe((res:any)=> {
    //     })

    // }


}