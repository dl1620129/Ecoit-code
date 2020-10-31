import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { CategoryService } from '../service/category.service';
import { Router, ActivatedRoute } from '@angular/router';
import { TreeUtilService } from '../service/tree-util.service';
import { CategoryLayoutService } from '../service/category-layout.service';
import { Constants } from '../common/constants';
import { NotifierService } from 'angular-notifier';

declare const Liferay: any;

@Component({
    selector: 'app-category-editor',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + 
    '/o/CMS-Web-Category/app/category-editor.component.html',
    styleUrls: [],
    providers: [],
})
export class CategoryEditorComponent implements OnInit {

    categoriesList : any = [];
    layoutsList: any = [];

    cateId: any;
    originalData: any;
    mapCateLayoutId: any;

    categoryForm = this.fb.group({
        title: ['', [Validators.required, Validators.maxLength(200)]],
        parentId: 0,
        description: ['', [Validators.maxLength(500)]],
        orderNumber: [{value: 1, disabled: true}],
        link: [''],
        pageId: 0
    });

    get title() {
        return this.categoryForm.get('title');
    };

    get orderNumber() {
        return this.categoryForm.get('orderNumber');
    };

    get parentId() {
        return this.categoryForm.get('parentId');
    }

    get description() {
        return this.categoryForm.get('description');
    };

    constructor(private fb: FormBuilder, 
        private categoryService : CategoryService, 
        private routes: ActivatedRoute, 
        private treeUtilService: TreeUtilService,
        private router: Router,
        private categoryLayoutService: CategoryLayoutService,
        private notifierService: NotifierService) { }

    ngOnInit() {
        this.routes.paramMap.subscribe(params => {
            if (params.get('id')) {
                this.cateId = params.get('id');
                this.categoryService.getCategory(this.cateId).subscribe((response: any) => {
                    this.originalData = response.data[0];
                    this.categoryForm.patchValue({
                        title: response.data[0].title,
                        parentId: response.data[0].parentId,
                        orderNumber: response.data[0].orderNumber,
                        description: response.data[0].description,
                        link: response.data[0].link
                    });
                    this.categoryLayoutService.getCategoryLayout(this.cateId).subscribe((response:any) => {
                        if (response.error_code == Constants.SUCCESSFUL_CODE) {
                            this.mapCateLayoutId = response.data.data.mapCateLayoutId;
                            this.categoryForm.patchValue({
                                pageId: response.data.data.pageId
                            });
                        }
                    });
                });
            } else {
                this.setMaxOrderNumber(0);
            }

            this.categoryLayoutService.getAllCategoryLayouts().subscribe((response: any) => {
                console.log(params.get('id'));
                if (response.error_code == Constants.SUCCESSFUL_CODE) {
                    this.treeUtilService.convertTreeList(response.data.category, 1, this.categoriesList, params.get('id'));
                    this.layoutsList = response.data.layout;
                } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                    this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
                } else {
                    this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
                }
            });
        });
    };

    onSubmit() {
        this.categoryService.submitCategory(this.categoryForm, this.cateId).subscribe((response: any) => {
            console.log(response.data);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                if (this.categoryForm.get('pageId').value > 0) {
                    let categoryId = this.cateId;
                    if (response.data.categoryId) {
                        categoryId = response.data.categoryId;
                    }
                    this.categoryLayoutService.updateCategoryLayout(categoryId, this.categoryForm.get('pageId').value, this.mapCateLayoutId).subscribe((response: any) => console.log(response));
                }
                this.router.navigate(['/category-list']);
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }

        });
    };

    setMaxOrderNumber(parentId: any) {
        this.categoryService.getMaxOrderNumber(parentId).subscribe((response: any) => {
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                let maxOrderNumber = response.data.maxOrderNumber + 1;
                if (this.originalData && this.originalData.parentId == parentId) {
                    maxOrderNumber = this.originalData.orderNumber;
                }
                
                //set order number
                this.categoryForm.patchValue({
                    orderNumber: maxOrderNumber
                });
            }
            console.log(response);
        });
    }

}