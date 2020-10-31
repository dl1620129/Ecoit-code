import { Injectable } from '@angular/core';
import { Constants } from '../common/Constants';
import { catchError } from 'rxjs/operators';
import { CommonService } from './common.service';
import { HttpClient } from '@angular/common/http';
HttpClient
@Injectable({providedIn: 'root'})
export class NewsService {
    constructor(private httpClient: HttpClient) { }

    // public getImageNews(){
    //     let url= Constants.baseUrl+Constants.imagelUrl+'getall/'+Constants.groupId;
    //     return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    // }
    public getCategory(){
        let url= Constants.baseUrl+Constants.categorylUrl+'getall/'+Constants.groupId;
        console.log(url);
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    getImageByCategory(categoryId: number){
        let url= Constants.baseUrl+Constants.imagelUrl+'get-by-category/'+Constants.groupId+'/'+categoryId;
        console.log(url);
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));;
    }
  

}