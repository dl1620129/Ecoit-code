import { Component, OnInit } from "@angular/core";
import { QuestionService } from '../service/question.service';
import { Question } from "../model/question.model";
import { CategoryModel } from '../model/category.model';
import { FormBuilder,FormGroup,FormControl,Validators } from '@angular/forms';
import { URLConstants } from "../common/URLConstants";
import { Constants } from "../common/Constants";

declare const Liferay: any;
declare const $: any;
@Component({
    selector: 'app-question',
    templateUrl: 
		Liferay.ThemeDisplay.getPathContext() + 
		'/o/CMS-Web-View-Question/app/question.component.html'
})
export class QuestionComponent implements OnInit{

     arrayOne(n: number): any[] {
         return Array(n);
     }

     pageSize= 10;
     page = 1;
     listSize = 0;
     questionModel: Question[];
     categoryModel: CategoryModel[];
     selectCategory:  CategoryModel[] = new Array();
     questionModelView: Question[];
     public urlWebSite= Liferay.ThemeDisplay.getLayoutRelativeURL();
     constructor(public questionService: QuestionService){}
     searchForm = new FormGroup({
         'searchKey': new FormControl(''),
         'categoryId': new FormControl(0),
     })
     get searchKey(){
         return this.searchForm.get('searchKey');
     }
     get categoryId(){
         return this.searchForm.get('categoryId');
     }

     get HOME_URL() {
          return URLConstants.HOME_URL;
     }

     get CAU_HOI_URL() {
         return Constants.baseUrl + this.urlWebSite.substring(0,this.urlWebSite.lastIndexOf('/'))+ URLConstants.CAU_HOI_URL;
     }

     get CHI_TIET_PHAN_HOI_URL() {
         return Constants.baseUrl + this.urlWebSite.substring(0,this.urlWebSite.lastIndexOf('/'))+ URLConstants.CHI_TIET_PHAN_HOI_URL;
     }

     get CURRENT_URL() {
	    let currentUrl = Liferay.ThemeDisplay.getLayoutURL();
         return currentUrl;
     }

     ngOnInit(){
         let queryData = this.getQueryString();
         if (parseInt(queryData['categoryId'])) {
             this.searchForm.patchValue({
                 categoryId: parseInt(queryData['categoryId'])
             });
         }
         this.getQuestionData();
         this.getCategoryData();
         this.getView();
     }


	getQueryString() {
          let hashMap = {};
          let queries = Liferay.currentURL.slice(Liferay.currentURL.indexOf('?') + 1).split('&');
          for (let i = 0; i < queries.length; i++) {
              let hash = queries[i].split('=');
              hashMap[hash[0]] = hash[1];
          }
          console.log(hashMap);
          return hashMap;
     }

     getQuestionData(){
          this.questionService.getQuestion(this.searchForm).subscribe((res: any)=>{
               this.questionModel= res.data.questions;
               this.listSize= res.data.total;
          })
     }
     getCategoryData(){
          this.questionService.getCategory().subscribe((result: any)=>{
               console.log(result.data);
               this.categoryModel= result.data;
               this.selectCategory = this.questionService.convertTreeList(result.data, 0);
          })
     }
     onSubmit(){
          this.questionService.getQuestion(this.searchForm).subscribe((res: any)=>{
               this.questionModel= res.data.questions;
               this.listSize= res.data.total;
          })
     }
     getView(){
          this.questionService.getQuestionCountView().subscribe((respone: any)=>{
               this.questionModelView= respone.data;
          })
     }

     displayDropDown(event: any) {
          event.preventDefault();
          console.log('testing');
          let isVisible = $(event.currentTarget).data('visible');
          $(event.currentTarget).data('visible', !isVisible);
          if (isVisible) {
              //switch to plus
              $(event.currentTarget).html('<i class="fa fa-plus bg-white" aria-hidden="true"></i>');
          } else {
              //switch to minus
              $(event.currentTarget).html('<i class="fa fa-minus bg-white" aria-hidden="true"></i>');
          }
          let targetLevel = $(event.currentTarget).data('target');
          let currentRow = $(event.currentTarget).parents('li').next();
          let currentLevel = $(currentRow).data('level');
          let mainVisible = isVisible;
          while (currentLevel > targetLevel) {
              let isShow = false;
              if (mainVisible) {
                  if ($(currentRow).is(':visible')) {
                      $(currentRow).hide();
                  }
              } else {
                  isShow = true;
                  $(currentRow).show();
              }
  
              if (($(currentRow).next().data('level') - targetLevel) == 1) {
                  mainVisible = isVisible;
              } else {
                  if ($(currentRow).find('.dropdown-btn').length > 0 && isShow) {
                      mainVisible = !$(currentRow).find('.dropdown-btn').data('visible');
                  }
              }
              currentRow = $(currentRow).next();
              currentLevel = $(currentRow).data('level');
          }
     }
}