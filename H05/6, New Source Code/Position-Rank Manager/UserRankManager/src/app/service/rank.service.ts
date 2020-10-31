import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Constants } from '../common/Constants';
import { catchError } from 'rxjs/operators';
import { CommonService } from './common.service';

@Injectable({providedIn: 'root'})
export class RankService {
    constructor(private httpClient: HttpClient) { }

    public getAllCategory(limit: number, start: number, keyWord: string){
        let url= Constants.baseUrl+Constants.detailUrl+'getall/'+Constants.groupId+'?limit='+limit+'&start='+start+'&q='+keyWord;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public deleteMutiple(ids: any[]){
        let url= Constants.baseUrl+Constants.detailUrl+'delete-mutiple/'+Constants.groupId;
        const body= new FormData();
        body.append('ids',ids.toString());
        return this.httpClient.post(url,body).pipe(catchError(CommonService.handleError));
    }
  
    public getAllLinhVuc(){
        let url= Constants.baseUrl+'/o/image/app/field/getall/'+Constants.groupId+'?limit=&start=&q=';
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public deleteCategory(id: number){
        let url= Constants.baseUrl+Constants.detailUrl+'delete/'+Constants.groupId+'/'+id;
        return this.httpClient.delete(url).pipe(catchError(CommonService.handleError));
    }
  
    public getCategory(id: number){
        let url= Constants.baseUrl+Constants.detailUrl+'getrank/'+Constants.groupId+'/'+id;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));

    }
    public createCategory(form: any){
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });
      
        let body = {
            'userRankName': form.get('userRankName').value,
            'description': form.get('description').value
            
        };
        let url= Constants.baseUrl+Constants.detailUrl+'create/'+Constants.groupId;
        return this.httpClient.post(url, body, {headers: headers}).pipe(catchError(CommonService.handleError));
         
    }
    public updateCategory(form: any,id: number){
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });
      
        let body = {
            'userRankName': form.get('userRankName').value,
            'description': form.get('description').value
            
        };
     
        let url= Constants.baseUrl+Constants.detailUrl+'update/'+Constants.groupId+'/'+id;
        return this.httpClient.put(url,body,{headers: headers}).pipe(catchError(CommonService.handleError));
    }

}