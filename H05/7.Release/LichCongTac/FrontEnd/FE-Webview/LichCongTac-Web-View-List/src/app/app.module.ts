import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { registerLocaleData } from '@angular/common';
import { NgbPaginationModule, NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import { LOCALE_ID } from '@angular/core';
import localeVi from '@angular/common/locales/vi';
import { RouterModule } from '@angular/router';

import { APP_BASE_HREF } from '@angular/common';
import { AppComponent } from './app.component';
import { AppRoutingModule, routingComponents } from './app-routing.module';

registerLocaleData(localeVi);

@NgModule({
	imports: [BrowserModule, ReactiveFormsModule, HttpClientModule, NgbPaginationModule, AppRoutingModule, RouterModule, NgbModalModule, FormsModule],
	declarations: [AppComponent, routingComponents],
	entryComponents: [AppComponent],
	bootstrap: [], // Don't bootstrap any component statically (see ngDoBootstrap() below)
	providers: [{provide: APP_BASE_HREF, useValue : '/' }, {provide: LOCALE_ID, useValue: 'vi'}],
	exports: [RouterModule]
})
export class AppModule {
	// Avoid bootstraping any component statically because we need to attach to
	// the portlet's DOM, which is different for each portlet instance and,
	// thus, cannot be determined until the page is rendered (during runtime).
	ngDoBootstrap() {}
}
