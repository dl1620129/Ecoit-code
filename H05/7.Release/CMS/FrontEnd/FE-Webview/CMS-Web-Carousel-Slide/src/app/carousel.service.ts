import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Contains } from './common/Contains.model';

@Injectable({
    providedIn: 'root'
})
export class CarouselService {
    constructor(private httpClient: HttpClient) { }
    
    public getAllLatestNews(){
        let url= Contains.baseUrl+Contains.detailUrl+'get-all/'+Contains.languageId+'/'+Contains.groupId;
        console.log(url);

        return this.httpClient.get(url);
    }
    // public getAllNews(){
    //     let url= Contains.localUrl+'/search-new/get-all/'+Contains.groupId+'/'+Contains.languageId+'?keyword=&start=0&limit=10';
    //     return this.httpClient.get(url);
    // }
}