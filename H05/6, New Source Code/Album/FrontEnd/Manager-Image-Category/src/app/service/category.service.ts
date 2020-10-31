import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Constants } from '../common/Constants';
import { catchError } from 'rxjs/operators';
import { CommonService } from './common.service';

@Injectable({providedIn: 'root'})
export class CategoryService {
    constructor(private httpClient: HttpClient) { }

    public getAllCategory(limit: number, start: number, keyWord: string){
        let url= Constants.baseUrl+Constants.detailUrl+'getall/'+Constants.groupId+'?limit='+limit+'&start='+start+'&q='+keyWord;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public getImageByCategory(limit: number, start: number,categoryId:number ){
        let url= Constants.baseUrl+Constants.imagelUrl+'get-by-category/'+Constants.groupId+'/'+categoryId+'?limit='+limit+'&start='+start;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
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
        let url= Constants.baseUrl+Constants.detailUrl+'getcategory/'+Constants.groupId+'/'+id+'/2';
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));

    }
    public createCategory(form: any){
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });
      
        let body = {
            'name': form.get('name').value,
            'description': form.get('description').value,
            'thuTu': form.get('thuTu').value,
            'tacGiaAlbum': form.get('tacGiaAlbum').value,
            
        };
        let url= Constants.baseUrl+Constants.detailUrl+'create/'+Constants.groupId;
        return this.httpClient.post(url, body, {headers: headers}).pipe(catchError(CommonService.handleError));
         
    }
    public updateCategory(form: any,id: number){
        let headers = new HttpHeaders({
            'Content-Type': 'application/json'
        });
      
        let body = {
            'name': form.get('name').value,
            'description': form.get('description').value,
            'thuTu': form.get('thuTu').value,
            'tacGiaAlbum': form.get('tacGiaAlbum').value,
            
        };
     
        let url= Constants.baseUrl+Constants.detailUrl+'update/'+Constants.groupId+'/'+id;
        return this.httpClient.put(url,body,{headers: headers}).pipe(catchError(CommonService.handleError));
    }

}