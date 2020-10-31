import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Constants } from '../common/Constants';
import { catchError } from 'rxjs/operators';
import { CommonService } from './common.service';

@Injectable({providedIn: 'root'})
export class LinhVucService {
    constructor(private httpClient: HttpClient) { }

    public getAllLinhVuc(limit: number, start: number, keyWord: string){
        let url= Constants.baseUrl+Constants.detailUrl+'getall/'+Constants.groupId+'?limit='+limit+'&start='+start+'&q='+keyWord;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public deleteLinhVuc(id: number){
        let url= Constants.baseUrl+Constants.detailUrl+'delete/'+Constants.groupId+'/'+id;
        return this.httpClient.delete(url).pipe(catchError(CommonService.handleError));
    }
  
    public getGroupLink(id: number){
        let url= Constants.baseUrl+Constants.detailUrl+'getfield/'+Constants.groupId+'/'+id;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));

    }
    public createLinhVuc(form: any){
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });
        let body={
            'name': form.value.name,
            'description': form.value.description
        }
    
        let url= Constants.baseUrl+Constants.detailUrl+'create/'+Constants.groupId;
        return this.httpClient.post(url, body, {headers: headers}).pipe(catchError(CommonService.handleError));
         
    }
    public updateLinhVuc(form: any,id: number){
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });
        let body={
            'name': form.value.name,
            'description': form.value.description
        }
     
        let url= Constants.baseUrl+Constants.detailUrl+'update/'+Constants.groupId+'/'+id;
        return this.httpClient.put(url,body,{headers: headers}).pipe(catchError(CommonService.handleError));
    }

}