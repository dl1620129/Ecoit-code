import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { APP_BASE_HREF } from '@angular/common';
import { TagInputModule } from 'ngx-chips';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbPaginationModule, NgbTypeaheadModule, NgbModalModule, NgbDropdownModule } from '@ng-bootstrap/ng-bootstrap';
import { NotifierModule } from 'angular-notifier';
import { OwlDateTimeModule, OwlNativeDateTimeModule } from 'ng-pick-datetime';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule, routingComponents } from './app-routing.module';
import { ReportListComponent } from './report-list/report-list.component';
import { ReportEditorComponent } from './report-editor/report-editor.component';


@NgModule({
	imports: [BrowserModule, 
		ReactiveFormsModule, 
		FormsModule, 
		HttpClientModule, 
		AppRoutingModule,
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
			ReportListComponent, 
			ReportEditorComponent, 
			routingComponents
		],
	entryComponents: [AppComponent],
	bootstrap: [], // Don't bootstrap any component statically (see ngDoBootstrap() below)
	providers: [],
})
export class AppModule {
	// Avoid bootstraping any component statically because we need to attach to
	// the portlet's DOM, which is different for each portlet instance and,
	// thus, cannot be determined until the page is rendered (during runtime).
	ngDoBootstrap() {}
}
