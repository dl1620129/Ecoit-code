import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DocumentRoute } from './document.routing';
import { RouterModule } from '@angular/router';
import { DocumentListComponent } from './document-list/document-list.component';
import { FormsModule } from '@angular/forms';
import { TranslateModule } from '@ngx-translate/core';
import { MatDialogModule, MatTableModule, MatPaginatorModule, MatPaginatorIntl, MatSelectModule, MatInputModule, MatCardModule, MatListModule, MatIconModule, MatSlideToggleModule } from '@angular/material';
import { NgxPaginationModule } from 'ngx-pagination';
import { NgbDropdownModule, NgbModalModule, NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { DocumentViewFile } from './document-view-file/document-view-file.component';
import { PdfJsViewerModule } from 'ng2-pdfjs-viewer';
import { SharedModule } from '../shared/shared.module'
import { TreeTableModule } from 'primeng/treetable';
import { FolderManagerComponent } from './folder-manager/folder-manager.component';
import { ProgressComponent } from './document-list/progress/progress.component';
import { DndDirective } from './document-list/dnd.directive';
import { CKEditorModule } from 'ckeditor4-angular';
@NgModule({
  declarations: [
    DocumentListComponent,
    DocumentViewFile,
    FolderManagerComponent,
    ProgressComponent,
    DndDirective
  ],
  imports: [
    NgbModule,
    CommonModule,
    FormsModule,
    CKEditorModule,
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
    PdfJsViewerModule,
    SharedModule,
    TreeTableModule
  ]

})
export class DocumentModule { }