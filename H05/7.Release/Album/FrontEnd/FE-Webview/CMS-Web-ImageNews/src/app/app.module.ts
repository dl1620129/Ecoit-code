import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { ListNewComponent } from './lis-new/new-list.component';
import { NgbPaginationModule, NgbTypeaheadModule, NgbModalModule, NgbDropdownModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
	imports: [BrowserModule,HttpClientModule,FormsModule,ReactiveFormsModule,AppRoutingModule,NgbPaginationModule,NgbModalModule],
	declarations: [AppComponent,ListNewComponent],
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
