import { NgModule, CUSTOM_ELEMENTS_SCHEMA  } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { APP_BASE_HREF } from '@angular/common';
import { CKEditorModule } from 'ng2-ckeditor';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbPaginationModule, NgbTypeaheadModule, NgbModalModule, NgbDropdownModule } from '@ng-bootstrap/ng-bootstrap';
import { NotifierModule } from 'angular-notifier';
import { OwlDateTimeModule, OwlNativeDateTimeModule } from 'ng-pick-datetime';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { TagInputModule } from 'ngx-chips';

import { AppRoutingModule, routingComponents } from './app-routing.module';
import { ArticleEditorComponent } from './article-editor/article-editor.component';
import { ArticleListComponent } from './article-list/article-list.component';
import { ArticleHistoryListComponent } from './article-history-list/article-history-list.component';
import { ArticleHistoryDetailComponent } from './article-history-detail/article-history-detail.component';
import { MaxLengthValidator } from './common/maxlength.validation';

@NgModule({
	imports: [BrowserModule, 
		ReactiveFormsModule, 
		FormsModule, 
		HttpClientModule, 
		AppRoutingModule, 
		CKEditorModule,
		NgbPaginationModule,
		NgbTypeaheadModule,
		NgbModalModule,
		NotifierModule,
		OwlDateTimeModule,
		OwlNativeDateTimeModule,
		BrowserAnimationsModule,
		NgbDropdownModule,
		TagInputModule],
	declarations: [AppComponent, 
		ArticleListComponent, 
		ArticleEditorComponent, 
		routingComponents, 
		ArticleHistoryListComponent, 
		ArticleHistoryDetailComponent,
		MaxLengthValidator],
	entryComponents: [AppComponent],
	schemas: [ CUSTOM_ELEMENTS_SCHEMA ],
	bootstrap: [], // Don't bootstrap any component statically (see ngDoBootstrap() below)
	providers: [{provide: APP_BASE_HREF, useValue: '/'}],
})
export class AppModule {
	// Avoid bootstraping any component statically because we need to attach to
	// the portlet's DOM, which is different for each portlet instance and,
	// thus, cannot be determined until the page is rendered (during runtime).
	ngDoBootstrap() {}
}
