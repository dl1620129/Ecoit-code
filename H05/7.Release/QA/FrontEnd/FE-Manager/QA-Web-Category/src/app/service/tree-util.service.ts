import { Injectable } from '@angular/core';
import { Category } from '../model/category.model';

declare const Liferay: any;

@Injectable({
    providedIn: 'root'
})export class TreeUtilService {

    public convertTreeList(treeList: Category[], level: number, mainCategoryId: any) {
        let newCategoriesList = new Array();
        treeList.forEach((element: Category) => {
            if (!mainCategoryId || element.categoryId != mainCategoryId) {
                let newTitle = '';
                for(let i = 0; i < level; i++) {
                    newTitle += '\u00A0\u00A0\u00A0';
                }
                newTitle += element.name;
                let newElement = element;
                newElement.name = newTitle;
                newCategoriesList.push(newElement);

                let childList = this.convertTreeList(element.child, level+1, mainCategoryId);
                childList.forEach((childElement: Category) => {
                    newCategoriesList.push(childElement);
                });
            }
        });
        return newCategoriesList;
    }
}