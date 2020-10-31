import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/operators';
import{ Constants } from '../common/constants';
import { CommonService } from './common.service';
import { Category } from '../model/category.model';

@Injectable({
    providedIn: 'root'
})export class CategoryService {

    constructor(private http: HttpClient) { };
    
    public convertCategoryList(treeList: Category[], level: number) {
        let newCategoryList = new Array();
        treeList.forEach((element: Category) => {
            let newTitle = '';
            for(let i = 0; i < level; i++) {
                newTitle += '\u00A0\u00A0\u00A0';
            }
            newTitle += element.name;
            let newElement = element;
            newElement.name = newTitle;
            newCategoryList.push(newElement);

            let childList = this.convertCategoryList(element.child, level+1);
            childList.forEach((childElement: Category) => {
                newCategoryList.push(childElement);
            });
        });
        return newCategoryList;
    }

    
    public getCategory() {
        let url = Constants.baseUrl + '/o/qacategory/app/getall-category/' + Constants.scopeGroupId;
        return this.http.get(url).pipe(catchError(CommonService.handleError));
    }
}
