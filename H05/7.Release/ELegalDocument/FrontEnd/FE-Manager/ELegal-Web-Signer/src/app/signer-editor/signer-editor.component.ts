import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { SignerService } from '../service/signer.service';
import { Constants } from '../common/constants';
import { NotifierService } from 'angular-notifier';
import { Language } from '../model/language.model';

declare const Liferay: any;

@Component({
    selector: 'app-signer-editor',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + '/o/ELegal-Web-Signer/app/signer-editor.component.html',
    styleUrls: [],
    providers: [],
})
export class SignerEditorComponent implements OnInit {

    signerForm = this.fb.group({
        firstName: ['', [Validators.required, Validators.maxLength(200)]],
        lastName: ['', [Validators.required, Validators.maxLength(200)]],
        language: [Constants.languageId]
    });

    languagesList: Language[] = new Array();

    legalSignerId: any;

    get firstName() {
        return this.signerForm.get('firstName');
    };

    get lastName() {
        return this.signerForm.get('lastName');
    };

    constructor(private fb: FormBuilder, 
        private routes: ActivatedRoute, 
        private signerService: SignerService, 
        private router: Router,
        private notifierService: NotifierService) {};

    ngOnInit() {
        this.routes.paramMap.subscribe(params => {
            if (params.get('id')) {
                this.legalSignerId = params.get('id');
                this.signerService.getSigner(this.legalSignerId).subscribe((response: any) => {
                    console.log(response.data);
                    this.signerForm.patchValue({
                        firstName: response.data.firstName,
                        lastName: response.data.lastName,
                        language: response.data.language
                    });
                });
            }
        });
        this.signerService.getLanguagesList().subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.languagesList = response.data;
            }
        });
    };

    onSubmit() {
        this.signerService.submitField(this.signerForm, this.legalSignerId).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {              
                this.router.navigate(['/signer-list']);
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    };
}