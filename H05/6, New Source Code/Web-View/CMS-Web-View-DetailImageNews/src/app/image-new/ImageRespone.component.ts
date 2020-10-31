import { Component,OnInit } from "@angular/core";
import { ImageResponeService } from "../service/imageRespone.service";
import {  imageReponseModel } from '../model/imageRespone.model';
import { Console } from "console";
import { URLConstants } from "../Common/URLConstants";
import { Contains } from '../Common/Contains.model';
declare const Liferay: any;
@Component({
    selector: 'image-new-detail',
	templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/CMS-Web-View-DetailImageNews/app/image-news.component.html'
})
export class ImageReponseComponent implements OnInit{
    public urlWebSite= Liferay.ThemeDisplay.getLayoutRelativeURL();
    keyWord: any;
    total: number;
    pageSize = 9;
    listSize = 0;
    page = 1;
    name='';
    listCate:any;
    imageReponses : imageReponseModel[]= new Array;
    imageId: any;
    cateModel:any;
    searchKey='';
    get ARTICLE_URL() {
        return Contains.baseUrl + this.urlWebSite.substring(0,this.urlWebSite.lastIndexOf('/'))+ URLConstants.ARTICLE_URL;
        }
    constructor(public service: ImageResponeService){}
    ngOnInit() {
        let queryData = this.getQueryString();
        if (queryData['categoryId']) {
           
            this.getImageNewData(queryData['categoryId']);
        }
        this.service.getDetail(queryData['categoryId']).subscribe((resData:any)=>{
            this.cateModel=resData.data;
            this.cateModel.urlImag=this.imageReponses[0].imageUrl;
        })
       this.getCategoryData(0);

        
        
    }
    getCategoryData(start: number) {
        let queryData = this.getQueryString();
        this.service.getAllCategory(queryData['categoryId'],this.pageSize, start, this.searchKey).subscribe((res: any) => {
                this.listCate = res.data.data;
                this.listSize = res.data.total;
        })
    }
    get HOME_URL() {
        return URLConstants.HOME_URL;
         
    }
    getImageNewData(id: number){
        this.service.getImageByCategory(id).subscribe((res:any)=>{
            this.name=res.data[0].name;
            this.imageReponses= res.data[0].data;
         
            
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
    pageChange(event : any) {
        let startPage = (event - 1) * this.pageSize;
        this.getCategoryData(startPage);
    }
   


}