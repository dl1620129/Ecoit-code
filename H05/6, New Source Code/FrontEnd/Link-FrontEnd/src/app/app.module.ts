import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { LinksComponent } from './link-list/links.component';
import { Injectable } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { NgbDropdownModule, NgbModalModule, NgbPaginationModule } from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule,routingComponents } from './app-routing.module';
import { LinksEditorComponent } from './link-editor/links-editor.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { NotifierModule } from 'angular-notifier';

@NgModule({
	imports: [BrowserModule,HttpClientModule,NgbPaginationModule,NgbModalModule,AppRoutingModule,FormsModule,ReactiveFormsModule,NgbDropdownModule,NotifierModule],
	declarations: [AppComponent,LinksComponent,LinksEditorComponent,routingComponents],
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
