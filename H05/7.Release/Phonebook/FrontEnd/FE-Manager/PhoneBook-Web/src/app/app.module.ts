import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { APP_BASE_HREF } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbPaginationModule, NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import { NotifierModule } from 'angular-notifier';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { OwlDateTimeModule, OwlNativeDateTimeModule } from 'ng-pick-datetime';

import { AppRoutingModule, routingComponents } from './app-routing.module';
import { PhonebookListComponent } from './phonebook-list/phonebook-list.component';

@NgModule({
	imports: [BrowserModule, 
		ReactiveFormsModule, 
		FormsModule, 
		HttpClientModule,
		NgbPaginationModule,
		NotifierModule,
		BrowserAnimationsModule,
		NgbModalModule, 
		OwlDateTimeModule, 
		OwlNativeDateTimeModule,
		AppRoutingModule],
	declarations: [AppComponent, 
		PhonebookListComponent,
		routingComponents],
	entryComponents: [AppComponent],
	bootstrap: [], // Don't bootstrap any component statically (see ngDoBootstrap() below)
	providers: [{provide: APP_BASE_HREF, useValue: '/'}],
})
export class AppModule {
	// Avoid bootstraping any component statically because we need to attach to
	// the portlet's DOM, which is different for each portlet instance and,
	// thus, cannot be determined until the page is rendered (during runtime).
	ngDoBootstrap() {}
}
