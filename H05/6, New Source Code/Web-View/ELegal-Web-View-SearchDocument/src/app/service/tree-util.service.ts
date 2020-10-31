import { Injectable } from '@angular/core';
import { Organization } from '../model/organization.model';
import { LegalType } from '../model/legal-type.model';

declare const Liferay: any;

@Injectable({
    providedIn: 'root'
})export class TreeUtilService {

    public convertOrgTreeList(treeList: Organization[], level: number) {
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

            let childList = this.convertOrgTreeList(element.child, level+1);
            childList.forEach((childElement: Organization) => {
                newOrganizationList.push(childElement);
            });
        });
        return newOrganizationList;
    }

    public convertTypeTreeList(treeList: LegalType[], level: number) {
        let newTypeList = new Array();
        treeList.forEach((element: LegalType) => {
            let newTitle = '';
            for(let i = 0; i < level; i++) {
                newTitle += '\u00A0\u00A0\u00A0';
            }
            newTitle += element.name;
            let newElement = element;
            newElement.name = newTitle;
            newTypeList.push(newElement);

            let childList = this.convertTypeTreeList(element.child, level+1);
            childList.forEach((childElement: LegalType) => {
                newTypeList.push(childElement);
            });
        });
        return newTypeList;
    }
}