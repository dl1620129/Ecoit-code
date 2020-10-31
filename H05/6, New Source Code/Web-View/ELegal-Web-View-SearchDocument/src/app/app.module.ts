import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule  } from '@angular/forms';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { SearchDocumentComponent } from './search-document/search-document.component';
import { NgbPaginationModule, NgbPopoverModule } from '@ng-bootstrap/ng-bootstrap';
import { OwlDateTimeModule, OwlNativeDateTimeModule, OwlDateTimeIntl } from 'ng-pick-datetime';
import { VietNamIntl } from './international.modules';

@NgModule({
	imports: [BrowserModule, 
		FormsModule, 
		HttpClientModule, 
		NgbPaginationModule, 
		OwlDateTimeModule, 
		OwlNativeDateTimeModule, 
		ReactiveFormsModule, 
		BrowserAnimationsModule, 
		NgbPopoverModule],
	declarations: [AppComponent, SearchDocumentComponent],
	entryComponents: [AppComponent],
	bootstrap: [], // Don't bootstrap any component statically (see ngDoBootstrap() below)
	providers: [ {provide: OwlDateTimeIntl, useClass: VietNamIntl}],
})
export class AppModule {
	// Avoid bootstraping any component statically because we need to attach to
	// the portlet's DOM, which is different for each portlet instance and,
	// thus, cannot be determined until the page is rendered (during runtime).
	ngDoBootstrap() {}
}
