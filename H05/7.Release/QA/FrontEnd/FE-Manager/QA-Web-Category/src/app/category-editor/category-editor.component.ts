import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { CategoryService } from '../service/category.service';
import { Router, ActivatedRoute } from '@angular/router';
import { TreeUtilService } from '../service/tree-util.service';
import { Constants } from '../common/constants';
import { NotifierService } from 'angular-notifier';
import { Category } from '../model/category.model';

declare const Liferay: any;

@Component({
    selector: 'app-category-editor',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + 
    '/o/QA-Web-Category/app/category-editor.component.html',
    styleUrls: [],
    providers: [],
})
export class CategoryEditorComponent implements OnInit {

    categoriesList : Category[] = new Array();

    categoryId: any;
    originalData: any;

    categoryForm = this.fb.group({
        name: ['', [Validators.required, Validators.maxLength(300)]],
        parentId: 0,
        description: ['', [Validators.maxLength(500)]],
        position: [{value: 1, disabled: true}]
    });

    get name() {
        return this.categoryForm.get('name');
    };

    get description() {
        return this.categoryForm.get('description');
    };

    constructor(private fb: FormBuilder, 
        private categoryService : CategoryService, 
        private routes: ActivatedRoute, 
        private treeUtilService: TreeUtilService,
        private router: Router,
        private notifierService: NotifierService) { }

    ngOnInit() {
        this.routes.paramMap.subscribe(params => {
            if (params.get('id')) {
                this.categoryId = params.get('id');
                this.categoryService.getCategory(this.categoryId).subscribe((response: any) => {
                    if (response.error_code == Constants.SUCCESSFUL_CODE) {
                        this.originalData = response.data;
                        this.categoryForm.patchValue({
                            name: response.data.name,
                            parentId: response.data.parentId,
                            position: response.data.position,
                            description: response.data.description
                        });
                    } else {
                        this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
                    }

                });
            } else {
                this.setPosition(0);
            }

            this.categoryService.getCategoriesList(0, -1, "").subscribe((response: any) => {
                console.log(response);
                if (response.error_code == Constants.SUCCESSFUL_CODE) {
                    this.categoriesList = this.treeUtilService.convertTreeList(response.data.categories, 1, params.get('id'));
                }
            });
        });


    };

    onSubmit() {
        this.categoryService.submitCategory(this.categoryForm, this.categoryId).subscribe((response: any) => {
            console.log(response.data);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.router.navigate(['/category-list']);
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }

        });
    };

    setPosition(parentId: any) {
        this.categoryService.getPosition(parentId).subscribe((response: any) => {
            let position = response.data.maxOrderNumber + 1;
            if (this.originalData && this.originalData.parentId == parentId) {
                position = this.originalData.position;
            }
            
            //set order number
            this.categoryForm.patchValue({
                position: position
            });
            console.log(response);
        });
    }

}