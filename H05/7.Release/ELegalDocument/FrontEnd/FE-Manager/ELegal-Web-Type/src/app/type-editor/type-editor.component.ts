import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { TypeService } from '../service/type.service';
import { Router, ActivatedRoute } from '@angular/router';
import { TreeUtilService } from '../service/tree-util.service';
import { Constants } from '../common/constants';
import { NotifierService } from 'angular-notifier';
import { LegalType } from '../model/type.model';

declare const Liferay: any;

@Component({
    selector: 'app-type-editor',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + 
    '/o/ELegal-Web-Type/app/type-editor.component.html',
    styleUrls: [],
    providers: [],
})
export class TypeEditorComponent implements OnInit {

    typesList : LegalType[] = new Array();

    typeId: any;
    originalData: any;

    typeForm = this.fb.group({
        name: ['', [Validators.required, Validators.maxLength(200)]],
        parentId: 0,
        description: ['', [Validators.maxLength(500)]],
        position: [{value: 1}, [Validators.min(1)]],
        statusType: [false]
    });

    get name() {
        return this.typeForm.get('name');
    };

    get description() {
        return this.typeForm.get('description');
    };

    get position() {
        return this.typeForm.get('position');
    };

    constructor(private fb: FormBuilder, 
        private typeService : TypeService, 
        private routes: ActivatedRoute, 
        private treeUtilService: TreeUtilService,
        private router: Router,
        private notifierService: NotifierService) { }

    ngOnInit() {
        this.routes.paramMap.subscribe(params => {
            if (params.get('id')) {
                this.typeId = params.get('id');
                this.typeService.getType(this.typeId).subscribe((response: any) => {
                    if (response.error_code == Constants.SUCCESSFUL_CODE) {
                        this.originalData = response.data;
                        this.typeForm.patchValue({
                            name: response.data.name,
                            parentId: response.data.parentId,
                            position: response.data.position,
                            description: response.data.description,
                            statusType: response.data.statusType
                        });
                    } else {
                        this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
                    }

                });
            } else {
                this.setPosition(0);
            }

            this.typeService.getTypesList(0, -1, "").subscribe((response: any) => {
                console.log(response);
                if (response.error_code == Constants.SUCCESSFUL_CODE) {
                    this.typesList = this.treeUtilService.convertTreeList(response.data, 1, params.get('id'));
                }
            });
        });


    };

    onSubmit() {
        this.typeService.submitType(this.typeForm, this.typeId).subscribe((response: any) => {
            console.log(response.data);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.router.navigate(['/type-list']);
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }

        });
    };

    setPosition(parentId: any) {
        this.typeService.getPosition(parentId).subscribe((response: any) => {
            let position = response.data.maxOrderNumber + 1;
            if (this.originalData && this.originalData.parentId == parentId) {
                position = this.originalData.position;
            }
            
            //set order number
            this.typeForm.patchValue({
                position: position
            });
            console.log(response);
        });
    }

}