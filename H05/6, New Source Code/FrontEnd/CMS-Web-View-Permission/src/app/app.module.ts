import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NotifierModule } from 'angular-notifier';

import { AppComponent } from './app.component';
import { permissionsComponent } from './permissions/permission-list/permissions.component';
import { childComponent } from './permissions/child/child.component';
import { RouterModule } from '@angular/router';
import { AppRoutingModule, routingComponents } from './app-routing.module';
import { APP_BASE_HREF } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { PermissionService } from './service/permission.service';
import { NgbPaginationModule, NgbTypeaheadModule, NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
@NgModule({
	imports: [BrowserModule,HttpClientModule,NgbPaginationModule,NgbModalModule,AppRoutingModule,FormsModule,ReactiveFormsModule,NotifierModule],
	declarations: [
		AppComponent,
		childComponent,
		permissionsComponent,
		routingComponents
	], 
	entryComponents: [AppComponent],
	bootstrap: [], // Don't bootstrap any component statically (see ngDoBootstrap() below)
	providers: [{provide: APP_BASE_HREF, useValue : '/' }, PermissionService],
	exports: [RouterModule]
})
export class AppModule {
	// Avoid bootstraping any component statically because we need to attach to
	// the portlet's DOM, which is different for each portlet instance and,
	// thus, cannot be determined until the page is rendered (during runtime).
	ngDoBootstrap() {}
}
