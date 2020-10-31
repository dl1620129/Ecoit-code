import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { UnitService } from '../service/unit.service';
import { Constants } from '../common/constants';
import { NotifierService } from 'angular-notifier';

declare const Liferay: any;

@Component({
    selector: 'app-unit-editor',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + '/o/MemberReport-Web-Unit/app/unit-editor.component.html',
    styleUrls: [],
    providers: [],
})
export class UnitEditorComponent implements OnInit {

    unitForm = this.fb.group({
        name: ['', [Validators.required, Validators.maxLength(300)]],
        description: ['', Validators.maxLength(500)]
    });

    unitId: any;

    get name() {
        return this.unitForm.get('name');
    };

    get description() {
        return this.unitForm.get('description');
    };

    constructor(private fb: FormBuilder, 
        private routes: ActivatedRoute, 
        private unitService: UnitService, 
        private router: Router,
        private notifierService: NotifierService) {};

    ngOnInit() {
        this.routes.paramMap.subscribe(params => {
            if (params.get('id')) {
                this.unitId = params.get('id');
                this.unitService.getUnit(this.unitId).subscribe((response: any) => {
                    console.log(response.data);
                    this.unitForm.patchValue({
                        name: response.data.name,
                        description: response.data.description
                    });
                });
            }
        });
    };

    onSubmit() {
        this.unitService.submitUnit(this.unitForm, this.unitId).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {              
                this.router.navigate(['/unit-list']);
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    };
}