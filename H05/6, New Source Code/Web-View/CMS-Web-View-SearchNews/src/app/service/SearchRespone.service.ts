import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http';
import { Contains } from '../Common/Contains.model';

@Injectable({providedIn: 'root'})
export class SearchResponeService {
    constructor(private httpClient: HttpClient) { }
    public getAllSearchRespone(keyWord: any,start: number,pageSize: number){
        let url= Contains.baseUrl+'/o/news/app/search-new/get-all/'+Contains.groupId+'/'+Contains.languageId+'?keyword='+keyWord+'&start='+start+'&limit='+pageSize;
        return this.httpClient.get(url);
    }

    public getSearchLevel(keyWord: any,start: number,pageSize: number,categoryId: number,dateFrom: Date,dateTo: Date,title: string ){
        let url= Contains.baseUrl+'/o/news/app/search-new/get-all/'+Contains.groupId+'/'+Contains.languageId+'?keyword='+keyWord+'&start='+start+'&limit='+pageSize+'&categoryId='+categoryId+'&dateFrom='+dateFrom+'&dateTo='+dateTo+'&title='+title;
        return this.httpClient.get(url);
    }
    public searchNews(keyword:string){
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });
 
        let body={
            'categoryIds': new Array,
            'fromDate': '',
            'keyword': keyword,
            'tags': new Array,
            'toDate': ''
        }
        let url= Contains.baseUrl+'/o/news/app/search-new/get-all/'+Contains.languageId+'/'+Contains.groupId;
        return this.httpClient.post(url,body,{headers: headers});
    }
    
}