import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Constants } from '../common/Constants';
import { catchError } from 'rxjs/operators';
import { CommonService } from './common.service';
import { GroupClipModel } from '../model/groupClip.model';

@Injectable({providedIn: 'root'})
export class GroupClipService {
    constructor(private httpClient: HttpClient) { }

    public getAllGroupClips(limit: number, start: number, keyWord: string){
        let url= Constants.baseUrl+Constants.detailUrl+'getall/'+Constants.groupId+'?limit='+limit+'&start='+start+'&q='+keyWord;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public deleteGroupClips(id: number){
        let url= Constants.baseUrl+Constants.detailUrl+'delete/'+Constants.groupId+'/'+Constants.userId+'/'+id;
        return this.httpClient.delete(url).pipe(catchError(CommonService.handleError));
    }
  
    public getGroupClip(id: number){
        let url= Constants.baseUrl+Constants.detailUrl+'getcategory/'+Constants.groupId+'/'+Constants.userId+'/'+id;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));

    }
    public createGroupLinks(form: any){
     
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });
        let body={
            'title': form.value.title.trim(),
            'description': form.value.description.trim()
        }
    
        let url= Constants.baseUrl+Constants.detailUrl+'create/'+Constants.groupId+'/'+Constants.userId;
        return this.httpClient.post(url, body,{headers: headers}).pipe(catchError(CommonService.handleError));
         
    }
    public updateGroupLinks(form: any,id: number){
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });
        let body={
            'title': form.value.title.trim(),
            'description': form.value.description.trim()
        }
        let url= Constants.baseUrl+Constants.detailUrl+'update/'+Constants.groupId+'/'+Constants.userId+'/'+id;
        return this.httpClient.put(url,body,{headers: headers}).pipe(catchError(CommonService.handleError));
    }
    public deleteMutiple(ids: any[]){
        let url= Constants.baseUrl+Constants.detailUrl+'delete-mutiple/'+Constants.groupId+'/'+Constants.userId;
        const body= new FormData();
        body.append('ids',ids.toString());
        return this.httpClient.post(url,body).pipe(catchError(CommonService.handleError));
    }

}