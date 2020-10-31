import { Injectable } from '@angular/core';
import { Constants } from '../common/Constants';
import { catchError } from 'rxjs/operators';
import { CommonService } from './common.service';
import { HttpClient } from '@angular/common/http';
HttpClient
@Injectable({providedIn: 'root'})
export class ClipService {
    constructor(private httpClient: HttpClient) { }

    // public getImageNews(){
    //     let url= Constants.baseUrl+Constants.imagelUrl+'getall/'+Constants.groupId;
    //     return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    // }
    // public getCategory(){
    //     let url= Constants.baseUrl+Constants.categorylUrl+'getall/'+Constants.groupId;
    //     return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    // }http://{{host}}:{{port}}/o/clip/app/getclipbycategory/{{groupId}}/2/?limit=&start=0&q=
    getAllClip(){
        let url= Constants.baseUrl+Constants.imagelUrl+'getall-display/'+Constants.groupId;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));;
    }
    getCLipByCategory(){
        let url= Constants.baseUrl+Constants.imagelUrl+'category/getall/'+Constants.groupId;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));;
    }
  

}