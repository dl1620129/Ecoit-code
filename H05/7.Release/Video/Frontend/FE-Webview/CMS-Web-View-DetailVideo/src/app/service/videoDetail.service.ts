import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Contains } from '../Common/Contains.model';
import { catchError } from 'rxjs/operators';
import { CommonService } from './common.service';

@Injectable({providedIn: 'root'})
export class videoDetailService {
    constructor(private httpClient: HttpClient) { }
  
    public getAllClip(id:number,limit: number, start: number, keyWord: string){
        let url=Contains.baseUrl+Contains.clipUrl+'getall-byid/'+Contains.groupId+'/'+id+'?limit='+limit+'&start='+start+'&q='+keyWord;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public getClipById(id: number){
        let url= Contains.baseUrl+Contains.clipUrl+'getclip/'+Contains.groupId+'/'+Contains.userId+'/'+id;
        return   this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
}