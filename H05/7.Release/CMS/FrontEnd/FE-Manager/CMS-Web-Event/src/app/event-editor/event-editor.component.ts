import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { EventService } from '../service/event.service';
import { Constants } from '../common/constants';
import { NotifierService } from 'angular-notifier';

declare const Liferay: any;

@Component({
    selector: 'app-event-editor',
    templateUrl: Liferay.ThemeDisplay.getPathContext() + '/o/CMS-Web-Event/app/event-editor.component.html',
    styleUrls: [],
    providers: [EventService],
})
export class EventEditorComponent implements OnInit {

    eventForm = this.fb.group({
        name: ['', [Validators.required, Validators.maxLength(200)]],
        description: ['', [Validators.maxLength(500)]]
    });

    eventId: any;

    get name() {
        return this.eventForm.get('name');
    };

    get description() {
        return this.eventForm.get('description');
    };

    constructor(private fb: FormBuilder, 
        private routes: ActivatedRoute, 
        private eventService: EventService, 
        private router: Router,
        private notifierService: NotifierService) {};

    ngOnInit() {
        this.routes.paramMap.subscribe(params => {
            if (params.get('id')) {
                this.eventId = params.get('id');
                this.eventService.getEvent(this.eventId).subscribe((response: any) => {
                    console.log(response.data);
                    this.eventForm.patchValue({
                        name: response.data.name,
                        description: response.data.description
                    });
                });
            }
        });
    };

    onSubmit() {
        this.eventService.submitEvent(this.eventForm, this.eventId).subscribe((response: any) => {
            console.log(response);
            if (response.error_code == Constants.SUCCESSFUL_CODE) {
                this.router.navigate(['/event-list']);
                this.notifierService.notify('success', Constants.SYSTEM_SUCCESS_MESSAGE);
            } else if (response.error_code == Constants.NOT_ACCESS_CODE) {
                this.notifierService.notify('error', Constants.NOT_ACCESS_MESSAGE);
            } else {
                this.notifierService.notify('error', Constants.SYSTEM_ERROR_MESSAGE);
            }
        });
    };
}