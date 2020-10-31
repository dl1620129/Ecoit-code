import { Injectable } from '@angular/core';
import { Constants } from '../common/Constants';
import { catchError } from 'rxjs/operators';
import { CommonService } from './common.service';
import { HttpClient } from '@angular/common/http';
import { CategoryModel } from '../model/category.model';
HttpClient
@Injectable({providedIn: 'root'})
export class QuestionService {
    constructor(private httpClient: HttpClient) { }

    public getQuestion(form: any){
        let body={
            'searchKey':form.value.searchKey,
            'categoryId': form.value.categoryId
        }
        let url= Constants.baseUrl+Constants.questionUrl+'get-publish/'+ Constants.languageId + '/' + Constants.groupId;
        return this.httpClient.post(url,body).pipe(catchError(CommonService.handleError));
    }
    public getCategory(){
        let url= Constants.baseUrl+Constants.categoryUrl+'getall-category/' + Constants.groupId;
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
    public getQuestionCountView(){
        let url= Constants.baseUrl+Constants.questionUrl+'get/popular/' + Constants.languageId + '/' + Constants.groupId + '?limit=5';
        return this.httpClient.get(url).pipe(catchError(CommonService.handleError));
    }
   
    public convertTreeList(treeList: CategoryModel[], level: number) {
        let newCategoriesList = new Array();
        treeList.forEach((element: CategoryModel) => {
            let newTitle = '';
            for(let i = 0; i < level; i++) {
                newTitle += '\u00A0\u00A0\u00A0';
            }
            newTitle += element.name;
            let newElement = element;
            newElement.name = newTitle;
            newCategoriesList.push(newElement);

            let childList = this.convertTreeList(element.child, level+1);
            childList.forEach((childElement: CategoryModel) => {
                newCategoriesList.push(childElement);
            });
        });
        return newCategoriesList;
    }

}