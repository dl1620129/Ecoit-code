import { Component, OnInit } from "@angular/core";
import { ClipModel } from '../model/clip.model';
import { ClipService } from '../service/clip.service';
import { Constants } from '../common/Constants';



declare const Liferay: any;
@Component({
    selector: 'app-list-clip',
    templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/CMS-Web-VideoNew/app/clip-new.component.html'
})
export class ListClipComponent implements OnInit{
     public urlWebSite= Liferay.ThemeDisplay.getLayoutRelativeURL();
    constructor(public clipService: ClipService){}
    clipModel: ClipModel[]= new Array();
    categories:any[]= new Array();
    model: ClipModel= new ClipModel();
    ngOnInit(){
         this.getClipData();
         this.getCategory();

    }
    get ARTICLE_URL() {
     return Constants.baseUrl + this.urlWebSite.substring(0,this.urlWebSite.lastIndexOf('/'))+ Constants.ARTICLE_URL;
     }
     get CLIP_URL() {
          return Constants.baseUrl + this.urlWebSite.substring(0,this.urlWebSite.lastIndexOf('/'))+ '/danh-sach-tin-video';
          }
    getClipData(){
         this.clipService.getAllClip().subscribe((res:any)=>{
              this.clipModel= res.data[0].data;
              this.model= this.clipModel[0];
         })
    }
    getCategory(){
         this.clipService.getCLipByCategory().subscribe((respone:any)=>{
              this.categories= respone.data[0].data;
         })
    }
    
}