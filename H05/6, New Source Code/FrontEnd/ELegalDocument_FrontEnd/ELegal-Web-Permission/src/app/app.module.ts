import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NotifierModule } from 'angular-notifier';

import { AppComponent } from './app.component';
import { PermissionListComponent } from './permission/permission-list/permission-list.component';
import { PermissionEditorComponent } from './permission/permission-editor/permission-editor.component';
import { RouterModule } from '@angular/router';
import { AppRoutingModule, routingComponents } from './app-routing.module';
import { APP_BASE_HREF } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgbPaginationModule, NgbModalModule, NgbDropdownModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaxLengthValidator } from './validation/maxlength.validation';
import { EmptyStringValidator } from './validation/required.validation';

@NgModule({
	imports: [
		BrowserModule,
		RouterModule,
		AppRoutingModule,
		HttpClientModule,
		NgbPaginationModule,
		FormsModule,
		NgbModalModule,
		ReactiveFormsModule,
		NotifierModule,
		NgbDropdownModule
	],
	declarations: [
		AppComponent,
		PermissionEditorComponent,
		PermissionListComponent,
		routingComponents,
		MaxLengthValidator,
		EmptyStringValidator
	], 
	entryComponents: [AppComponent],
	bootstrap: [], // Don't bootstrap any component statically (see ngDoBootstrap() below)
	providers: [{provide: APP_BASE_HREF, useValue : '/' }],
	exports: [RouterModule]
})
export class AppModule {
	// Avoid bootstraping any component statically because we need to attach to
	// the portlet's DOM, which is different for each portlet instance and,
	// thus, cannot be determined until the page is rendered (during runtime).
	ngDoBootstrap() {}
}
