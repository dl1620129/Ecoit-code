import { Injectable } from '@angular/core';
import { LegalType } from '../model/type.model';

declare const Liferay: any;

@Injectable({
    providedIn: 'root'
})export class TreeUtilService {

    public convertTreeList(treeList: LegalType[], level: number, mainTypeId: any) {
        let newOrganizationList = new Array();
        treeList.forEach((element: LegalType) => {
            if (!mainTypeId || element.typeId != mainTypeId) {
                let newTitle = '';
                for(let i = 0; i < level; i++) {
                    newTitle += '\u00A0\u00A0\u00A0';
                }
                newTitle += element.name;
                let newElement = element;
                newElement.name = newTitle;
                newOrganizationList.push(newElement);

                let childList = this.convertTreeList(element.child, level+1, mainTypeId);
                childList.forEach((childElement: LegalType) => {
                    newOrganizationList.push(childElement);
                });
            }
        });
        return newOrganizationList;
    }
}