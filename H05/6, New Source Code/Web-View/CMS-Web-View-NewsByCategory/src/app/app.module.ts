import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { NgbPaginationModule } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule, ReactiveFormsModule  } from '@angular/forms';
import { TagInputModule } from 'ngx-chips';
import { OwlDateTimeModule, OwlNativeDateTimeModule } from 'ng-pick-datetime';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppComponent } from './app.component';
import { NewsCategoryComponent } from './news-category/news-category.component';


@NgModule({
	imports: [BrowserModule, 
		HttpClientModule, 
		NgbPaginationModule, 
		OwlDateTimeModule, 
		OwlNativeDateTimeModule, 
		TagInputModule, 
		ReactiveFormsModule, 
		FormsModule, 
		BrowserAnimationsModule],
	declarations: [AppComponent, NewsCategoryComponent],
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
