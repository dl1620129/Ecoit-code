import { Component, OnInit } from "@angular/core";
import { URLConstants } from "../Common/URLConstants";
import { videoDetailService } from '../service/videoDetail.service';
import { ClipReponseModel } from '../model/videoRespone.model';
import { Contains } from '../Common/Contains.model';
declare const Liferay: any;
@Component({
    selector: 'clip-detail',
    templateUrl:
        Liferay.ThemeDisplay.getPathContext() +
        '/o/CMS-Web-View-DetailVideo/app/video-news.component.html'
})
export class VideoReponseComponent implements OnInit {
    public urlWebSite = Liferay.ThemeDisplay.getLayoutRelativeURL();
    keyWord: any;
    total: number;
    pageSize = 9;
    listSize = 0;
    page = 1;
    title = '';
    clipModel: ClipReponseModel = new ClipReponseModel;
    clipReponses: ClipReponseModel[] = new Array;
    clipId: any; searchKey = '';
    get ARTICLE_URL() {
        return Contains.baseUrl + this.urlWebSite.substring(0, this.urlWebSite.lastIndexOf('/')) + URLConstants.ARTICLE_URL;
    }
    constructor(public service: videoDetailService) { }
    ngOnInit() {
        let queryData = this.getQueryString();
        if (queryData['id']) {

            this.getImageNewData(queryData['id']);
        }
        this.getClipData(0);

    }
    getClipData(start: number) {
        let queryData = this.getQueryString();
        this.service.getAllClip(queryData['id'],this.pageSize, start, this.searchKey).subscribe((res: any) => {
            this.clipReponses = res.data[0].data;
            this.listSize = res.data[0].total;
        })
    }
    get HOME_URL() {
        return URLConstants.HOME_URL;
    }
    getImageNewData(id: number) {
        this.service.getClipById(id).subscribe((res: any) => {
            this.title = res.data.title;
            this.clipModel = res.data;
        })
    }

    getQueryString() {
        let hashMap = {};
        let queries = Liferay.currentURL.slice(Liferay.currentURL.indexOf('?') + 1).split('&');
        for (let i = 0; i < queries.length; i++) {
            let hash = queries[i].split('=');
            hashMap[hash[0]] = hash[1];
        }

        console.log(hashMap);
        return hashMap;
    }
    pageChange(event: any) {
        let startPage = (event - 1) * this.pageSize;
        this.getClipData(startPage);
    }



}