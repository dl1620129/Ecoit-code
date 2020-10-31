import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NewsModel } from '../model/news.model';
import { Contains } from '../Contains/Contains.model';


@Injectable({providedIn: 'root'})
export class NewsSerivce {
    constructor(private httpClient: HttpClient) { }
    searchNews(newsmodel: NewsModel){
        let url =Contains.baseUrl+'/app/search-new/get-all/'+Contains.groupId+'/'+Contains.languageId+'?tag=tag1';
        this.httpClient.get(url);
    }

}
 