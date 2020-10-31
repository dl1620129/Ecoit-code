import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Constants } from '../common/Constants';
import { CommonService } from './common.service';
import { catchError } from 'rxjs/operators';

@Injectable({providedIn: 'root'})
export class OrganizationService {
    constructor(private httpClient: HttpClient) { }
    
    public getAllorganization(){
        let url= Constants.baseUrl+Constants.detailUrl+'getall/'+Constants.groupId+'/0';
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public getById(id: number){
        let url= Constants.baseUrl+Constants.detailUrl+'getall/'+Constants.groupId+'/'+id;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
}