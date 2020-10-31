import { Injectable } from '@angular/core';
import { Organization } from '../model/organization.model';

declare const Liferay: any;

@Injectable({
    providedIn: 'root'
})export class TreeUtilService {

    public convertTreeList(treeList: Organization[], level: number, mainOrganizationId: any) {
        let newOrganizationList = new Array();
        treeList.forEach((element: Organization) => {
            if (!mainOrganizationId || element.organizationId != mainOrganizationId) {
                let newTitle = '';
                for(let i = 0; i < level; i++) {
                    newTitle += '\u00A0\u00A0\u00A0';
                }
                newTitle += element.name;
                let newElement = element;
                newElement.name = newTitle;
                newOrganizationList.push(newElement);

                let childList = this.convertTreeList(element.child, level+1, mainOrganizationId);
                childList.forEach((childElement: Organization) => {
                    newOrganizationList.push(childElement);
                });
            }
        });
        return newOrganizationList;
    }
}