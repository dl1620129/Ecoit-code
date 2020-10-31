import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { OrganizationService } from '../service/organization.service';
import { Router, ActivatedRoute } from '@angular/router';
import { TreeUtilService } from '../service/tree-util.service';
import { Constants } from '../common/constants';
import { NotifierService } from 'angular-notifier';

declare const Liferay: any;

@Component({
    selector: 'app-organization-editor',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + 
    '/o/ELegal-Web-Organization/app/organization-editor.component.html',
    styleUrls: [],
    providers: [],
})
export class OrganizationEditorComponent implements OnInit {

    organizationsList : any = [];

    organizationId: any;
    originalData: any;

    organizationForm = this.fb.group({
        name: ['', [Validators.required, Validators.maxLength(200)]],
        parentId: 0,
        description: ['', [Validators.maxLength(500)]],
        position: [{value: 1}, [Validators.min(1)]],
        status: [false]
    });

    get name() {
        return this.organizationForm.get('name');
    };

    get description() {
        return this.organizationForm.get('description');
    };

    get position() {
        return this.organizationForm.get('position');
    };

    constructor(private fb: FormBuilder, 
        private organizationService : OrganizationService, 
        private routes: ActivatedRoute, 
        private treeUtilService: TreeUtilService,
        private router: Router,
        private notifierService: NotifierService) { }

    ngOnInit() {
        this.routes.paramMap.subscribe(params => {
            if (params.get('id')) {
                this.organizationId = params.get('id');
                this.organizationService.getOrganization(this.organizationId).subscribe((response: any) => {
                    if (response.error_code == Constants.SUCCESSFUL_CODE) {
                        this.originalData = response.data;
                        this.organizationForm.patchValue({
                            name: response.data.name,
                            parentId: response.data.parentId,
                            position: response.data.position,
                            description: response.data.description,
                            status: response.data.statusOrg
                        });
                    } else {
                        this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
                    }

                });
            } else {
                this.setPosition(0);
            }

            this.organizationService.getAllOrganizations(0, -1, "").subscribe((response: any) => {
                console.log(response);
                if (response.error_code == Constants.SUCCESSFUL_CODE) {
                    this.organizationsList = this.treeUtilService.convertTreeList(response.data, 1, params.get('id'));
                }
            });
        });


    };

    onSubmit() {
        this.organizationService.submitOrganization(this.organizationForm, this.organizationId).subscribe((response: any) => {
            console.log(response.data);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.router.navigate(['/organization-list']);
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }

        });
    };

    setPosition(parentId: any) {
        this.organizationService.getPosition(parentId).subscribe((response: any) => {
            let position = response.data.maxOrderNumber + 1;
            if (this.originalData && this.originalData.parentId == parentId) {
                position = this.originalData.position;
            }
            
            //set order number
            this.organizationForm.patchValue({
                position: position
            });
            console.log(response);
        });
    }

}