import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DocumentRoute } from './document.routing';
import { RouterModule } from '@angular/router';
import { DocumentListComponent } from './document-list/document-list.component';
import { FormsModule } from '@angular/forms';
import { TranslateModule } from '@ngx-translate/core';
import { MatDialogModule, MatTableModule, MatPaginatorModule, MatPaginatorIntl, MatSelectModule, MatInputModule, MatCardModule, MatListModule, MatIconModule, MatSlideToggleModule } from '@angular/material';
import { NgxPaginationModule } from 'ngx-pagination';
import { NgbDropdownModule, NgbModalModule } from '@ng-bootstrap/ng-bootstrap';
import { DocumentViewFile } from './document-view-file/document-view-file.component';
import { PdfViewerModule } from 'ng2-pdf-viewer'; 
import { NgxDocViewerModule } from 'ngx-doc-viewer';
import { PdfJsViewerModule } from 'ng2-pdfjs-viewer';
import {SharedModule} from '../shared/shared.module'
import {TreeTableModule} from 'primeng/treetable';

@NgModule({
  declarations: [
    DocumentListComponent,
    DocumentViewFile,
    
  ],
  imports: [
    CommonModule,
    FormsModule,
    MatDialogModule,
    MatTableModule,
    NgxPaginationModule,
    MatPaginatorModule,
    MatSelectModule,
    MatInputModule,
    MatCardModule,
    MatSlideToggleModule,
    TranslateModule,
    NgxPaginationModule,
    NgbModalModule,
    NgbDropdownModule,
    RouterModule.forChild(DocumentRoute),
    PdfViewerModule,
    NgxDocViewerModule,
    PdfJsViewerModule,
    SharedModule,
    TreeTableModule
  ]

})
export class DocumentModule { }
