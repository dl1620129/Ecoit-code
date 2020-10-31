import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { APP_BASE_HREF } from '@angular/common';
import { NgbPaginationModule, NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule, routingComponents } from './app-routing.module';
import { NotifierModule } from 'angular-notifier';

import { AppComponent } from './app.component';
import { AdvertisementListComponent } from './advertisement-list/advertisement-list.component';
import { AdvertisementEditorComponent } from './advertisement-editor/advertisement-editor.component';

@NgModule({
	imports: [BrowserModule, HttpClientModule, FormsModule, ReactiveFormsModule, NgbPaginationModule, AppRoutingModule, NgbModalModule, NotifierModule],
	declarations: [AppComponent, AdvertisementEditorComponent, AdvertisementListComponent, routingComponents],
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
