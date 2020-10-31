import { Injectable } from '@angular/core';
import { Category } from '../class/category';

declare const Liferay: any;

@Injectable({
    providedIn: 'root'
})export class TreeUtilService {
    
    public deleteElementFromTree(treeList: Category[], id: number) {
        treeList.forEach((element: Category, i: any) => {
            if (element['cateId'] == id) {
                treeList.splice(i, 1);
                return;
            }
            this.deleteElementFromTree(element['child'], id);
        });
    }

    public convertTreeList(treeList: Category[], level: number) {
        let newCategoryList = new Array();
        treeList.forEach((element: Category) => {
            let newTitle = '';
            for(let i = 0; i < level; i++) {
                newTitle += '\u00A0\u00A0\u00A0';
            }
            newTitle += element.title;
            let newElement = element;
            newElement.title = newTitle;
            newCategoryList.push(newElement);

            let childList = this.convertTreeList(element.child, level+1);
            childList.forEach((childElement: Category) => {
                newCategoryList.push(childElement);
            });
        });
        return newCategoryList;
    }
}