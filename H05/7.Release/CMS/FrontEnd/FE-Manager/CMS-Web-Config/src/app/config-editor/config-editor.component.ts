import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { CategoryService } from '../service/category.service';
import { Router, ActivatedRoute } from '@angular/router';
import { TreeUtilService } from '../service/tree-util.service';
import { Constants } from '../common/constants';
import { NotifierService } from 'angular-notifier';
import { ConfigService } from '../service/config.service';

declare const Liferay: any;

@Component({
    selector: 'app-config-editor',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + 
    '/o/CMS-Web-Config/app/config-editor.component.html',
    styleUrls: [],
    providers: [],
})
export class ConfigEditorComponent implements OnInit {

    categoriesList : any = [];

    categoryId: any = 0;
    portletId: any;

    constructor(private fb: FormBuilder, 
        private categoryService : CategoryService, 
        private routes: ActivatedRoute, 
        private treeUtilService: TreeUtilService,
        private router: Router,
        private configService : ConfigService,
        private notifierService: NotifierService) { }

    ngOnInit() {
        this.routes.paramMap.subscribe(params => {
            if (params.get('id')) {
                this.portletId = params.get('id');
                this.configService.getConfig(this.portletId).subscribe((response: any) => {
                    if (response.error_code == Constants.SUCCESSFUL_CODE) {
                        this.categoryId = response.data.categoryId;
                    }
                });
            }

        });

        
        this.categoryService.getAllCategories().subscribe((response: any) => {
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.categoriesList = this.treeUtilService.convertTreeList(response.data, 0);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    };

    onSubmit() {
        this.configService.submitConfig(this.categoryId, this.portletId).subscribe((response: any) => {
            console.log(response.data);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.router.navigate(['/config-list']);
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }

        });
    };
}