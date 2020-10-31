import { Component, OnInit } from "@angular/core";


import { NewsService } from '../service/news.service';
import { NewModel } from '../model/news.model';
import { Constants } from '../common/Constants';

declare const Liferay: any;
@Component({
     selector: 'app-list',
     templateUrl:
          Liferay.ThemeDisplay.getPathContext() +
          '/o/CMS-Web-ImageNews/app/new-list.component.html'
})
export class ListNewComponent implements OnInit {
     public urlWebSite = Liferay.ThemeDisplay.getLayoutRelativeURL();
     constructor(public newService: NewsService) { }
     newModel: NewModel[];
     get ARTICLE_URL() {
          return Constants.baseUrl + this.urlWebSite.substring(0, this.urlWebSite.lastIndexOf('/')) + Constants.ARTICLE_URL;
     }
     get LIST_ARTICLE() {
          return Constants.baseUrl + this.urlWebSite.substring(0, this.urlWebSite.lastIndexOf('/')) + Constants.LIST_ARTICLE;
     }
     ngOnInit() {
          this.newService.getCategory().subscribe((res: any) => {
               this.newModel = res.data.data;
          })

     }


}