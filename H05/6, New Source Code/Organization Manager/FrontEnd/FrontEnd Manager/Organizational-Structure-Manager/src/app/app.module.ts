import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AppRoutingModule, routingComponents } from './app-routing.module';
import { NgbModalModule, NgbPaginationModule,NgbDropdownModule } from '@ng-bootstrap/ng-bootstrap';
import { NotifierModule } from 'angular-notifier';
import { OrganizationComponent } from './organization-list/organization-list.component';
import { OrganizationEditorComponent } from './organization-editor/organization-editor.component';

@NgModule({
	imports: [BrowserModule, HttpClientModule, ReactiveFormsModule, AppRoutingModule, NgbPaginationModule, FormsModule, NgbModalModule, NotifierModule,NgbDropdownModule],
	declarations: [AppComponent, OrganizationComponent, OrganizationEditorComponent, routingComponents],
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
