import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Constants } from '../common/Constants';
import { catchError } from 'rxjs/operators';
import { CommonService } from './common.service';

@Injectable({providedIn: 'root'})
export class GroupLinkService {
    constructor(private httpClient: HttpClient) { }

    public getAllGroupLinks(limit: number, start: number, keyWord: string){
        let url= Constants.baseUrl+'/o/link/app/grouplink/getall/'+Constants.groupId+'?limit='+limit+'&start='+start+'&q='+keyWord;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public deleteGroupLinks(id: number){
        let url= Constants.baseUrl+'/o/link/app/grouplink/delete/'+Constants.groupId+'/'+id;
        return this.httpClient.delete(url).pipe(catchError(CommonService.handleError));
    }
  
    public getGroupLink(id: number){
        let url= Constants.baseUrl+'/o/link/app/grouplink/get/'+Constants.groupId+'/'+id;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));

    }
    public createGroupLinks(form: any){
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });
        let body={
            'groupName': form.value.groupName,
            'description': form.value.description
        }
    
        let url= Constants.baseUrl+'/o/link/app/grouplink/create/'+Constants.groupId;
        return this.httpClient.post(url, body, {headers: headers}).pipe(catchError(CommonService.handleError));
         
    }
    public updateGroupLinks(form: any,id: number){
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });
        let body={
            'groupName': form.value.groupName,
            'description': form.value.description
        }
     
        let url= Constants.baseUrl+'/o/link/app/grouplink/update/'+id+'/'+Constants.groupId;
        return this.httpClient.put(url,body,{headers: headers}).pipe(catchError(CommonService.handleError));
    }
    public deleteMutiple(ids: any[]){
        let url= Constants.baseUrl+'/o/link/app/grouplink/delete-mutiple/'+Constants.groupId;
        const body= new FormData();
        body.append('ids',ids.toString());
        return this.httpClient.post(url,body).pipe(catchError(CommonService.handleError));
    }

}