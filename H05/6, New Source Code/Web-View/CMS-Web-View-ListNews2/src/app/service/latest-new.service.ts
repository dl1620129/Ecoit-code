import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Contains } from '../common/Contains.model';
import { LatestNewModel } from '../Model/latest-news.model';

@Injectable({
    providedIn: 'root'
})
export class LatestNewsService {
    constructor(private httpClient: HttpClient) { }
    
    public getAllLatestNews(){
        let url= Contains.baseUrl+'/featured-new/get-all/'+Contains.groupId+'/'+Contains.languageId;
        return this.httpClient.get(url);
    }
    public getAllNews(){
        let url= Contains.localUrl+'/search-new/get-all/'+Contains.groupId+'/'+Contains.languageId+'?keyword=&start=0&limit=10';
        return this.httpClient.get(url);
    }
}