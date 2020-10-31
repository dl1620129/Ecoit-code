import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import{ Constants } from '../common/constants';
import { CommonService } from './common.service';
import { LegalType } from '../model/legal-type.model';

@Injectable({
    providedIn: 'root'
})export class TypeService {

    constructor(private http: HttpClient) { };
    
    public convertTypeList(treeList: LegalType[], level: number) {
        let newOrganizationList = new Array();
        treeList.forEach((element: LegalType) => {
            let newTitle = '';
            for(let i = 0; i < level; i++) {
                newTitle += '\u00A0\u00A0\u00A0';
            }
            newTitle += element.name;
            let newElement = element;
            newElement.name = newTitle;
            newOrganizationList.push(newElement);

            let childList = this.convertTypeList(element.child, level+1);
            childList.forEach((childElement: LegalType) => {
                newOrganizationList.push(childElement);
            });
        });
        return newOrganizationList;
    }
}
