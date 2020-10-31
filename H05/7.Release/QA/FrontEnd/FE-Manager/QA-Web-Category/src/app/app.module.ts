import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { APP_BASE_HREF } from '@angular/common';
import { NgbPaginationModule, NgbModalModule, NgbDropdownModule } from '@ng-bootstrap/ng-bootstrap';
import { NotifierModule } from 'angular-notifier';

import { AppComponent } from './app.component';
import { AppRoutingModule, routingComponents } from './app-routing.module';
import { CategoryListComponent } from './category-list/category-list.component';
import { CategoryEditorComponent } from './category-editor/category-editor.component';
import { EmptyStringValidator } from './validation/required.validation';

@NgModule({
	imports: [BrowserModule, HttpClientModule, ReactiveFormsModule, AppRoutingModule, NgbPaginationModule, FormsModule, NgbModalModule, NotifierModule, NgbDropdownModule],
	declarations: [AppComponent, CategoryListComponent, CategoryEditorComponent, routingComponents, EmptyStringValidator],
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
