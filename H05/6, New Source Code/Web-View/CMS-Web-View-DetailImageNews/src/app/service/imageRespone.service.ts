import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Contains } from '../Common/Contains.model';
import { catchError } from 'rxjs/operators';
import { CommonService } from './common.service';

@Injectable({providedIn: 'root'})
export class ImageResponeService {
    constructor(private httpClient: HttpClient) { }
    // public getDetailImage(id: number){
    //     let url= Contains.baseUrl+Contains.detailUrl+'/'+Contains.groupId+'/'+Contains.userId+id;
    //     return this.httpClient.get(url).pipe(catchError(CommonService.handleError));;
    // }
    getImageByCategory(categoryId: number){
        let url= Contains.baseUrl+Contains.imagelUrl+'get-by-category/'+Contains.groupId+'/'+categoryId;
       
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));;
    }

    public getAllCategory(id: number,limit: number, start: number, keyWord: string){
        let url= Contains.baseUrl+Contains.categorylUrl+'getall-byid/'+Contains.groupId+'/'+id+'?limit='+limit+'&start='+start+'&q='+keyWord;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    getDetail(id:number){
        let url= Contains.baseUrl+Contains.categorylUrl+'getcategory/'+Contains.groupId+'/'+id+'/1';
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
}
