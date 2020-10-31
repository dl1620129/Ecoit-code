import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NotifierModule } from 'angular-notifier';

import { AppComponent } from './app.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgbModalModule, NgbPaginationModule , NgbDropdownModule, NgbTypeaheadModule } from '@ng-bootstrap/ng-bootstrap';
import { AppRoutingModule,routingComponents } from './app-routing.module';
import { CategoryEditorComponent } from './category-editor/category-editor.component';
import { CategoryComponent } from './category-list/category-list.component';
import { ImageEditorComponent } from './image/image-editor.component';

@NgModule({
	imports: [BrowserModule,HttpClientModule,NgbPaginationModule,NgbModalModule,AppRoutingModule,FormsModule,ReactiveFormsModule,NotifierModule,NgbDropdownModule,NgbTypeaheadModule],
	declarations: [AppComponent,CategoryComponent,CategoryEditorComponent,ImageEditorComponent,routingComponents],
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
