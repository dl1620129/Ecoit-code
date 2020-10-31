import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Constants } from '../common/constants';
import { catchError } from 'rxjs/operators';
import { CommonService } from './common.service';
import { Organization } from '../model/organization.model';

@Injectable({providedIn: 'root'})
export class OrganizationService {
    constructor(private httpClient: HttpClient) { }

    public getAllOrgan(){
        let url= Constants.baseUrl + '/o/ldap/app/get-organization-portal-all/'+Constants.groupId;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
  
    // public getorganization(id: number){
    //     let url= Constants.baseUrl+Constants.detailUrl+'getorganization/'+Constants.groupId+'/'+Constants.userId+'/'+id;
    //     return this.httpClient.get(url).pipe(catchError(CommonService.handleError));

    // }
 
    public getOrganization() {
        let url= Constants.baseUrl + '/o/ldap/app/get-userId-inOrg/' + Constants.userId;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }

    convertTreeList(treeList: Organization[], level: number) {
        let listOfOrganizations = new Array<Organization>();
        treeList.forEach((element: Organization) => {
            let newTitle = '';
            for(let i = 0; i < level; i++) {
                newTitle += '\u00A0\u00A0\u00A0';
            }
            newTitle += element['name'];
            let newElement = element;
            newElement.name = newTitle;
            listOfOrganizations.push(newElement);
            let childList = this.convertTreeList(element.children, level+1);
            childList.forEach((childElement: Organization) => {
                listOfOrganizations.push(childElement);
            });
        });
        return listOfOrganizations;
    }
}