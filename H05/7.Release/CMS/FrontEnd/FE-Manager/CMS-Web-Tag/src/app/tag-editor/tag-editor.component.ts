import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { TagService } from '../service/tag.service';
import { Constants } from '../common/constants';
import { NotifierService } from 'angular-notifier';

declare const Liferay: any;

@Component({
    selector: 'app-tag-editor',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + '/o/CMS-Web-Tag/app/tag-editor.component.html',
    styleUrls: [],
    providers: [],
})
export class TagEditorComponent implements OnInit {

    tagForm = this.fb.group({
        name: ['', [Validators.required, Validators.maxLength(200)]],
        description: ['', [Validators.maxLength(500)]]
    });

    tagId: any;

    get name() {
        return this.tagForm.get('name');
    };

    get description() {
        return this.tagForm.get('description');
    };

    constructor(private fb: FormBuilder, 
        private routes: ActivatedRoute, 
        private tagService: TagService, 
        private router: Router,
        private notifierService: NotifierService) {};

    ngOnInit() {
        this.routes.paramMap.subscribe(params => {
            if (params.get('id')) {
                this.tagId = params.get('id');
                this.tagService.getTag(this.tagId).subscribe((response: any) => {
                    console.log(response.data);
                    this.tagForm.patchValue({
                        name: response.data.name,
                        description: response.data.description
                    });
                });
            }
        });
    };

    onSubmit() {
        this.tagService.submitTag(this.tagForm, this.tagId).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {              
                this.router.navigate(['/tag-list']);
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    };
}