import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { FieldService } from '../service/field.service';
import { Constants } from '../common/constants';
import { NotifierService } from 'angular-notifier';

declare const Liferay: any;

@Component({
    selector: 'app-field-editor',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + '/o/ELegal-Web-Field/app/field-editor.component.html',
    styleUrls: [],
    providers: [],
})
export class FieldEditorComponent implements OnInit {

    fieldForm = this.fb.group({
        name: ['', [Validators.required, Validators.maxLength(200)]],
        description: ['', Validators.maxLength(500)],
        statusField: [false],
        position: [{value: 1}, [Validators.min(1)]]
    });

    legalFieldId: any;

    get name() {
        return this.fieldForm.get('name');
    };

    get description() {
        return this.fieldForm.get('description');
    };

    get position() {
        return this.fieldForm.get('position');
    };

    constructor(private fb: FormBuilder, 
        private routes: ActivatedRoute, 
        private fieldService: FieldService, 
        private router: Router,
        private notifierService: NotifierService) {};

    ngOnInit() {
        this.routes.paramMap.subscribe(params => {
            if (params.get('id')) {
                this.legalFieldId = params.get('id');
                this.fieldService.getField(this.legalFieldId).subscribe((response: any) => {
                    console.log(response.data);
                    this.fieldForm.patchValue({
                        name: response.data.name,
                        description: response.data.description,
                        statusField: response.data.statusField,
                        position: response.data.position
                    });
                });
            } else {
                this.fieldService.getMaxNumber().subscribe((response: any) => {
                    console.log(response);
                    if (response.error_code == Constants.SUCCESSFUL_CODE) {
                        this.fieldForm.patchValue({
                            position: (response.data.maxOrderNumber + 1)
                        });
                    }
                });
            }
        });
    };

    onSubmit() {
        this.fieldService.submitField(this.fieldForm, this.legalFieldId).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {              
                this.router.navigate(['/field-list']);
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    };
}