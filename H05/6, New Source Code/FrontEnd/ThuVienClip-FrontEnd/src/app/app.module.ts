import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NotifierModule } from 'angular-notifier';
import { AppComponent } from './app.component';
import { Injectable } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { NgbModalModule, NgbPaginationModule, NgbDropdownModule, NgbTypeaheadModule } from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule, routingComponents } from './app-routing.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ClipComponent } from './clip-list/clip-list.component';
import { MaxLengthValidator } from './common/maxlength.validation';

import { ClipEditorComponent } from './clip-editor/clip-editor.component';
@NgModule({
	imports: [BrowserModule, HttpClientModule, NgbPaginationModule, NgbModalModule, AppRoutingModule, FormsModule, ReactiveFormsModule, NotifierModule, NgbDropdownModule, NgbTypeaheadModule],
	declarations: [AppComponent, ClipComponent, ClipEditorComponent, routingComponents, MaxLengthValidator],
	entryComponents: [AppComponent],
	bootstrap: [], // Don't bootstrap any component statically (see ngDoBootstrap() below)
	providers: [],

})
export class AppModule {
	// Avoid bootstraping any component statically because we need to attach to
	// the portlet's DOM, which is different for each portlet instance and,
	// thus, cannot be determined until the page is rendered (during runtime).
	ngDoBootstrap() { }
}
