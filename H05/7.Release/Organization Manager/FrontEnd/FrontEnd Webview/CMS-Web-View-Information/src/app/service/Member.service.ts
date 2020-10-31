import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Constants } from '../common/Constants';
import { catchError } from 'rxjs/operators';
import { CommonService } from './common.service';
import { MemberModel } from '../model/member.model';

@Injectable({providedIn: 'root'})
export class MemberService {
    constructor(private httpClient: HttpClient) { }

    public getAllMemberByOrgan(limit: number, start: number, organizationId: number){
        let url= Constants.baseUrl+Constants.detailUrl+'get-by-organization/'+Constants.groupId+'/'+organizationId+'?limit='+limit+'&start='+start;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public getAllOrgan(parenId: number){
        let url= Constants.baseUrl+'/o/organizational/app/getall/'+Constants.groupId+'/'+parenId;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public deleteImage(id: number){
        let url= Constants.baseUrl+Constants.detailUrl+'delete/'+Constants.groupId+'/'+Constants.userId+'/'+id;
        return this.httpClient.delete(url).pipe(catchError(CommonService.handleError));
    }
  
    public getMember(id: number){
        let url= Constants.baseUrl+Constants.detailUrl+'getmember/'+Constants.groupId+'/'+Constants.userId+'/'+id;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
   

}