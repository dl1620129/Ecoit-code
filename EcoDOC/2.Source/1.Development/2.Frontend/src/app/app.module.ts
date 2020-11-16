import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {
  CommonModule,
  LocationStrategy,
  HashLocationStrategy
} from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HttpClient, HTTP_INTERCEPTORS } from '@angular/common/http';
import { PreloadAllModules, RouterModule } from '@angular/router';
import { ErrorInterceptor } from './core/rest/error-interceptor';
import { NgbModule, NgbDateParserFormatter } from '@ng-bootstrap/ng-bootstrap';
import { SlimLoadingBarModule } from 'ng2-slim-loading-bar';
import { NavigationComponent } from './shared/header-navigation/navigation.component';
import { SidebarComponent } from './shared/sidebar/sidebar.component';
import { BreadcrumbComponent } from './shared/breadcrumb/breadcrumb.component';
import { Approutes } from './app-routing.module';
import { AppComponent } from './app.component';
import { SpinnerComponent } from './shared/spinner.component';
import { PerfectScrollbarModule } from 'ngx-perfect-scrollbar';
import { PERFECT_SCROLLBAR_CONFIG } from 'ngx-perfect-scrollbar';
import { PerfectScrollbarConfigInterface } from 'ngx-perfect-scrollbar';
import { AuthenticationComponent } from './component/authentication/authentication.component';
import { NotFoundComponent } from './shared/error/not-found/not-found.component';
import { MasterPageComponent } from './layouts/master-page/master-page.component';
import { BlankComponent } from './layouts/blank-page/blank.component';
import { RequestInterceptor } from './core/rest/request-interceptor';
import { ToastrModule } from 'ngx-toastr';
import { NgxPaginationModule } from 'ngx-pagination';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { ConfirmPopupComponent } from './shared/popup/confirm-popup/confirm-popup.component';
import { SharedModule } from './modules/shared/shared.module';
import { CustomDateFormat } from './pipes/custom-date-format';
import { OwlDateTimeModule, OwlNativeDateTimeModule } from 'ng-pick-datetime';
import { PdfJsViewerModule } from 'ng2-pdfjs-viewer';
import { PdfViewComponent } from './shared/pdf-view/pdf-view.component';
import { EditButtonComponent } from './shared/edit-button/edit-button.component';
import { LoadingButtonComponent } from './shared/loading-button/loading-button.component';
import { CasAuthenComponent } from './component/authentication/cas-authen/cas-authen.component';
import { DatePipe } from '@angular/common';

const DEFAULT_PERFECT_SCROLLBAR_CONFIG: PerfectScrollbarConfigInterface = {
  suppressScrollX: true,
  wheelSpeed: 1,
  wheelPropagation: true,
  minScrollbarLength: 20
};

@NgModule({
  declarations: [
    AppComponent,
    SpinnerComponent,
    NavigationComponent,
    BreadcrumbComponent,
    SidebarComponent,
    AuthenticationComponent,
    CasAuthenComponent,
    NotFoundComponent,
    MasterPageComponent,
    BlankComponent,
    PdfViewComponent,
    ConfirmPopupComponent,
    EditButtonComponent,
    LoadingButtonComponent,
    CasAuthenComponent
  ],
  imports: [
    CommonModule,
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    NgbModule,
    SlimLoadingBarModule.forRoot(),
    RouterModule.forRoot(Approutes, { preloadingStrategy: PreloadAllModules }),
    PerfectScrollbarModule,
    ReactiveFormsModule,
    SharedModule,
    PdfJsViewerModule,
    ToastrModule.forRoot({
      timeOut: 3000,
      positionClass: 'toast-top-right',
      preventDuplicates: true,
    }),
    NgxPaginationModule,
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps: [HttpClient]
      }
    }),
    OwlDateTimeModule,
    OwlNativeDateTimeModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: ErrorInterceptor,
      multi: true
    }, {
      provide: HTTP_INTERCEPTORS,
      useClass: RequestInterceptor,
      multi: true
    },
    {
      provide: PERFECT_SCROLLBAR_CONFIG,
      useValue: DEFAULT_PERFECT_SCROLLBAR_CONFIG
    },
    {
      provide: LocationStrategy,
      useClass: HashLocationStrategy
    },
    { provide: NgbDateParserFormatter, useClass: CustomDateFormat },
    { provide: NgbDateParserFormatter, useClass: CustomDateFormat }
    , DatePipe
  ],
  bootstrap: [AppComponent],
  exports: [
    SpinnerComponent
  ],
  entryComponents: [
    ConfirmPopupComponent
  ]
})
export class AppModule {
}

export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http, 'assets/i18n/', '.json');
}
