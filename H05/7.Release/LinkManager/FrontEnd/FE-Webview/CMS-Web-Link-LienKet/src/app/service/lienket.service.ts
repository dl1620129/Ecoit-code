import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Constants } from '../common/Constants';

@Injectable({providedIn: 'root'})
export class LienKetService {
    constructor(private httpClient: HttpClient) { }
    
    public getAllLinks(){
        let url= Constants.baseUrl+'/o/link/app/getall/'+Constants.groupId+'?limit=&start=0&q=';
        return this.httpClient.get(url);
    }
    public getGroupLink(){
        let url= Constants.baseUrl+'/o/link/app/grouplink/getall/'+Constants.groupId+'?limit=&start=0&q=';
        return this.httpClient.get(url);
    }
    public getLinkByGroupLinkId(id: number){
        let url= Constants.baseUrl+'/o/link/app/getlinkbyparams/'+Constants.groupId+'/'+id;
        return this.httpClient.get(url);
    }
}