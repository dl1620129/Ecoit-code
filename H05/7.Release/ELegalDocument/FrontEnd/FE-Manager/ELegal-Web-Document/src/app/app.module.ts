import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { APP_BASE_HREF, registerLocaleData } from '@angular/common';
import { CKEditorModule } from 'ng2-ckeditor';
import { TagInputModule } from 'ngx-chips';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbPaginationModule, NgbTypeaheadModule, NgbModalModule, NgbDropdownModule } from '@ng-bootstrap/ng-bootstrap';
import { NotifierModule } from 'angular-notifier';
import { OwlDateTimeModule, OwlNativeDateTimeModule, OwlDateTimeIntl, OWL_DATE_TIME_FORMATS, DateTimeAdapter } from 'ng-pick-datetime';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { OWL_DATE_TIME_LOCALE } from 'ng-pick-datetime';
import localeVi from '@angular/common/locales/vi';

import { AppRoutingModule, routingComponents } from './app-routing.module';
import { DocumentEditorComponent } from './document-editor/document-editor.component';
import { DocumentListComponent } from './document-list/document-list.component';
import { SuggestionEditorComponent } from './suggestion-editor/suggestion-editor.component';
import { SuggestionListComponent } from './suggestion-list/suggestion-list.component';
import { MaxLengthValidator } from './validation/maxlength.validation';
import { EmptyStringValidator } from './validation/required.validation';
import { VietNamIntl } from './international.modules';
import { DateFnsDateTimeAdapter } from './date-fns-date-time-adapter';

registerLocaleData(localeVi);

export const MY_DFS_FORMATS = {
    parseInput: 'dd/MM/yyyy HH:mm || dd/MM/yyyy',
    fullPickerInput: 'dd/MM/yyyy HH:mm',
    datePickerInput: 'dd/MM/yyyy',
    timePickerInput: 'HH:mm',
    monthYearLabel: 'MMM yyyy',
    dateA11yLabel: 'MMMM yyyy',
    monthYearA11yLabel: 'MMMM yyyy',
};

@NgModule({
	imports: [BrowserModule, 
		ReactiveFormsModule, 
		FormsModule, 
		HttpClientModule, 
		AppRoutingModule, 
		CKEditorModule,
		NgbPaginationModule,
		NgbTypeaheadModule,
		NgbModalModule,
		NotifierModule,
		OwlDateTimeModule,
		OwlNativeDateTimeModule,
		BrowserAnimationsModule,
		NgbDropdownModule,
		TagInputModule],
	declarations: [AppComponent, 
		DocumentListComponent, 
		DocumentEditorComponent,
		SuggestionEditorComponent,
		SuggestionListComponent,
		routingComponents,
		MaxLengthValidator,
		EmptyStringValidator],
	entryComponents: [AppComponent],
	bootstrap: [], // Don't bootstrap any component statically (see ngDoBootstrap() below)
	providers: [{provide: APP_BASE_HREF, useValue: '/'}, {provide: OwlDateTimeIntl, useClass: VietNamIntl}, {provide: OWL_DATE_TIME_LOCALE, useValue: 'vi-VN'},
	            { provide: DateTimeAdapter, useClass: DateFnsDateTimeAdapter }, {provide: OWL_DATE_TIME_FORMATS, useValue: MY_DFS_FORMATS}],
})
export class AppModule {
	// Avoid bootstraping any component statically because we need to attach to
	// the portlet's DOM, which is different for each portlet instance and,
	// thus, cannot be determined until the page is rendered (during runtime).
	ngDoBootstrap() {}
}
