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

    public convertTreeList(treeList: Category[], level: number, listOfCategories: Category[], mainCateId: any) {
        treeList.forEach((element: Category) => {
            let newTitle = '';
            for(let i = 0; i < level; i++) {
                newTitle += '\u00A0\u00A0\u00A0';
            }
            newTitle += element['title'];
            let newElement = new Category(newTitle, element.cateId, element.parentId, element.orderNumber, element.createDate, element.link, element.description, element.child);
            listOfCategories.push(newElement);
            if (!mainCateId || element.cateId != mainCateId) {
                this.convertTreeList(element['child'], level+1, listOfCategories, mainCateId);
            }
        });
    }
}