import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { Constants } from '../common/constants';
import { CommonService } from './common.service';
import { Category } from '../class/category';

declare const Liferay: any;

@Injectable({
    providedIn: 'root'
})export class CategoryService {

    private accessToken = '';
    constructor(private http: HttpClient) { };
    
    public getAllCategories() {
        let url = Constants.baseUrl + '/o/category/app/getall/' + Constants.scopeGroupId + '/' + Constants.languageId + '/' + Constants.userId + '?start=0&limit=-1&isArticle=true';   
        return this.http.get(url).pipe(catchError(CommonService.handleError));
    }

    public addCheckedToCategories(treeList: any[]) {
        let newCategories = new Array();
        treeList.forEach((element: any) => {
            let newObject = element;
            newObject.checked = false;
            newObject.child = this.addCheckedToCategories(element.child);
            newCategories.push(newObject);
        });
        return newCategories;
    }

    public checkedCategories(treeList: any[], articleCategories: any[]) {
        let newCategories = new Array();
        treeList.forEach((element: any) => {
            let newObject = element;
            let checked = false;
            articleCategories.forEach((existingElement: any) => {
                if (existingElement.id == element.cateId && existingElement.checked) {
                    checked = true;
                }
            });
            newObject.checked = checked;
            newObject.child = this.checkedCategories(element.child, articleCategories);
            newCategories.push(newObject);
        });
        return newCategories;
    }

    public convertTreeList(treeList: Category[], level: number) {
        let newCategoriesList = new Array();
        treeList.forEach((element: Category) => {
            let newTitle = '';
            for(let i = 0; i < level; i++) {
                newTitle += '\u00A0\u00A0\u00A0';
            }
            newTitle += element['title'];
            let newElement = new Category(newTitle, element.cateId, element.parentId, element.orderNumber, element.createDate, element.link, element.description, element.child);         
            newCategoriesList.push(newElement);
            let childList = this.convertTreeList(element.child, level+1);
            childList.forEach((childElement: Category) => {
                newCategoriesList.push(childElement);
            });
        });
        return newCategoriesList;
    }
}
