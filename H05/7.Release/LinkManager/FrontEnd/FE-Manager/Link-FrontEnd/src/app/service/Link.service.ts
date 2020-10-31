import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Constants } from '../common/Constants';
import { catchError } from 'rxjs/operators';
import { CommonService } from './common.service';

@Injectable({providedIn: 'root'})
export class LinkService {
    constructor(private httpClient: HttpClient) { }

    public getAllLinks(limit: number, start: number, keyWord: string){
        let url= Constants.baseUrl+'/o/link/app/getall/'+Constants.groupId+'?limit='+limit+'&start='+start+'&q='+keyWord;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public deleteLinks(id: number){
        let url= Constants.baseUrl+'/o/link/app/delete/'+id+'/'+Constants.groupId;
        return this.httpClient.delete(url).pipe(catchError(CommonService.handleError));
    }
    public getGroupLink(){
        let url= Constants.baseUrl+'/o/link/app/grouplink/getall/'+Constants.groupId+'?limit=&start=0&q=';
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public getLink(id: number){
        let url= Constants.baseUrl+'/o/link/app/get/link/'+Constants.groupId+'/'+id;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));

    }
    public getGroupLinkById(id: number){
        let url= Constants.baseUrl+'/o/link/app/grouplink/get/'+Constants.groupId+'/'+id;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));

    }
    public createLinks(form: any){
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });
        let body={
            'name': form.value.name,
            'decription': form.value.decription,
            'url': form.value.url,
            'linksgroupid': form.value.linksgroupid,
        }
    
        let url= Constants.baseUrl+'/o/link/app/create/'+Constants.groupId;
        return this.httpClient.post(url, body, {headers: headers}).pipe(catchError(CommonService.handleError));
         
    }
    public updateLinks(form: any,id: number){
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });
        let body={
            'name': form.value.name,
            'decription': form.value.decription,
            'url': form.value.url,
            'linksgroupid': form.value.linksgroupid,
        }
     
        let url= Constants.baseUrl+'/o/link/app/update/'+id+'/'+Constants.groupId;
        console.log(url);
        return this.httpClient.put(url,body,{headers: headers}).pipe(catchError(CommonService.handleError));
    }
    public deleteMutiple(ids: any[]){
        let url= Constants.baseUrl+'/o/link/app/delete-mutiple/'+Constants.groupId;
        const body= new FormData();
        body.append('ids',ids.toString());
        return this.httpClient.post(url,body).pipe(catchError(CommonService.handleError));
    }


}