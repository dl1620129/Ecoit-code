import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NgbModalModule, NgbPaginationModule } from '@ng-bootstrap/ng-bootstrap';
import { AppComponent } from './app.component';
import { VideoReponseComponent } from './video-new/videoRespone.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
	imports: [BrowserModule,HttpClientModule,NgbModalModule,NgbPaginationModule],
	declarations: [AppComponent,VideoReponseComponent],
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
