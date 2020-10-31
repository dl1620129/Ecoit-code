import { Component, OnInit, Input } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { SuggestionService } from '../service/suggestion.service';
import { Constants } from '../common/constants';
import { Router, ActivatedRoute } from '@angular/router';
import { NotifierService } from 'angular-notifier';
import { Suggestion } from '../model/suggestion.model';

declare const Liferay: any;

@Component({
    selector: 'app-suggestion-edit',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + 
    '/o/ELegal-Web-Document/app/suggestion/suggestion-edit.component.html',
    styleUrls: [],
    providers: [],
})
export class SuggestionEditorComponent implements OnInit {

    constructor(private suggestionService: SuggestionService,
        private routes: ActivatedRoute,
        private router: Router,
        private notifierService: NotifierService,
        private fb: FormBuilder) { }

    docId: any;
    sugId: any;

    get name() {
        return this.suggestForm.get('name');
    };

    get email() {
        return this.suggestForm.get('email');
    };

    get title() {
        return this.suggestForm.get('title');
    };

    get content() {
        return this.suggestForm.get('content');
    };

    suggestForm = this.fb.group({
        email: ['', [Validators.required, Validators.email, Validators.maxLength(75)]],
        name: ['', [Validators.required, Validators.maxLength(200)]],
        title: ['', [Validators.required, Validators.maxLength(200)]],
        content: ['', [Validators.required, Validators.maxLength(500)]],
        isApproved: false
    });

    ngOnInit() {
        this.routes.paramMap.subscribe(params => {
            if (params.get('sugId') && params.get('docId')) {
                this.sugId = params.get('sugId');
                this.docId = params.get('docId');
                console.log(params);
                this.suggestionService.getSuggestion(this.sugId).subscribe((response: any) => {
                    console.log(response);
                    if (response.error_code == Constants.SUCCESSFUL_CODE) {
                        this.suggestForm.patchValue({
                            email: response.data.email,
                            name: response.data.userName,
                            title: response.data.title,
                            content: response.data.content,
                            isApproved: response.data.approved
                        });
                    } else {
                        this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
                    }
                });
            }
        });
    }

    onSubmit() {
        this.suggestionService.submitSuggestion(this.suggestForm, this.docId, this.sugId).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.router.navigate(['/document-edit', this.docId]);
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    }
}