import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Organization } from '../model/organization.model';

declare const Liferay: any;

@Injectable({
    providedIn: 'root'
})export class OrganizationService {

    constructor(private http: HttpClient) { };
    
    public convertOrganizationList(treeList: Organization[], level: number) {
        let newOrganizationList = new Array();
        treeList.forEach((element: Organization) => {
            let newTitle = '';
            for(let i = 0; i < level; i++) {
                newTitle += '\u00A0\u00A0\u00A0';
            }
            newTitle += element.name;
            let newElement = element;
            newElement.name = newTitle;
            newOrganizationList.push(newElement);

            let childList = this.convertOrganizationList(element.child, level+1);
            childList.forEach((childElement: Organization) => {
                newOrganizationList.push(childElement);
            });
        });
        return newOrganizationList;
    }
}
