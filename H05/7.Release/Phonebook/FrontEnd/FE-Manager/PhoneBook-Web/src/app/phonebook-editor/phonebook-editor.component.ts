import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { PhoneBookService } from '../service/phonebook.service';
import { Constants } from '../common/constants';
import { NotifierService } from 'angular-notifier';
import { DateTimeAdapter } from 'ng-pick-datetime';
import { Organization } from '../model/organization.model';

declare const Liferay: any;

@Component({
    selector: 'app-signer-editor',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + '/o/PhoneBook-Web/app/phonebook-editor.component.html',
    styleUrls: [],
    providers: [],
})
export class PhonebookEditorComponent implements OnInit {

    userForm = this.fb.group({
        firstName: ['', [Validators.maxLength(75)]],
        middleName: ['', [Validators.maxLength(75)]],
        lastName: ['', [Validators.required, Validators.maxLength(75)]],
        birthDate: [new Date()],
        gender: ["1"],
        screenName: [{value: '', disabled: true}],
        email: ['', [Validators.required, Validators.email, Validators.maxLength(75)]],
        password: ['', [Validators.maxLength(75)]],
        passwordReset: [false],
        organizationId: [0],
        jobTitle: ['', [Validators.maxLength(75)]],
        phoneNumber: ['', Validators.pattern("[0-9]{12}")]
    });

    get firstName() {
        return this.userForm.get('firstName');
    };

    get middleName() {
        return this.userForm.get('middleName');
    };

    get lastName() {
        return this.userForm.get('lastName');
    };

    get email() {
        return this.userForm.get('email');
    };

    get password() {
        return this.userForm.get('password');
    };

    get jobTitle() {
        return this.userForm.get('jobTitle');
    };

    get phoneNumber() {
        return this.userForm.get('phoneNumber');
    };

    userId: any;
    organizationsList: Organization[] = new Array();

    constructor(private fb: FormBuilder, 
        private routes: ActivatedRoute, 
        private phonebookService: PhoneBookService, 
        private router: Router,
        private notifierService: NotifierService,
        dateTimeAdapter: DateTimeAdapter<any>) {
            dateTimeAdapter.setLocale("vi-VN"); 
        };

    ngOnInit() {
        this.routes.paramMap.subscribe(params => {
            if (params.get('id')) {
                this.userId = params.get('id');
                this.phonebookService.getUser(this.userId).subscribe((response: any) => {
                    console.log(response.data);
                    this.userForm.patchValue({
                        firstName: response.data.firstName,
                        middleName: response.data.middleName,
                        lastName: response.data.lastName,
                        birthDate: new Date(response.data.birthDate),
                        gender: response.data.gender.toString(),
                        screenName: response.data.screenName,
                        email: response.data.email,
                        passwordReset: response.data.passwordReset,
                        organizationId: response.data.organizationId,
                        jobTitle: response.data.jobTitle,
                        phoneNumber: response.data.phoneNumber
                    });
                });
            }
        });
        this.phonebookService.getAllOrganization().subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.organizationsList = this.phonebookService.convertTreeList(response.data, 0);
            }
        });
    };

    onSubmit() {
        this.phonebookService.submitUser(this.userForm, this.userId).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {              
                this.router.navigate(['/user-list']);
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    };

    setScreenName(event: any) {
        this.userForm.patchValue({
            screenName: event.target.value.substring(0, event.target.value.lastIndexOf('@')),
        });
    }
}