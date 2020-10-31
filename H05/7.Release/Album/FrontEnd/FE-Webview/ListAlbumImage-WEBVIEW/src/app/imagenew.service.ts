import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { CommonService } from './common.service';
import { HttpClient } from '@angular/common/http';
import { Constants } from './common/Constants';
HttpClient
@Injectable({providedIn: 'root'})
export class NewsService {
    constructor(private httpClient: HttpClient) { }

    // public getImageNews(){
    //     let url= Constants.baseUrl+Constants.imagelUrl+'getall/'+Constants.groupId;
    //     return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    // }
  
    public getAllCategory(limit: number, start: number, keyWord: string){
        let url= Constants.baseUrl+Constants.categorylUrl+'getall/'+Constants.groupId+'?limit='+limit+'&start='+start+'&q='+keyWord;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    getImageByCategory(categoryId: number){
        let url= Constants.baseUrl+Constants.imagelUrl+'get-by-category/'+Constants.groupId+'/'+categoryId;
        console.log(url);
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));;
    }
  

}