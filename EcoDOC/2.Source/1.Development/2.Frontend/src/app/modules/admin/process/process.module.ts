import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AngularFileUploaderModule } from 'angular-file-uploader';
import { DateValueAccessorModule } from 'angular-date-value-accessor';
import { RouterModule } from '@angular/router';
import { ProcessListComponent } from './process-list/process-list.component';
import { ProcessEditComponent } from './process-edit/process-edit.component';
import { ProcessConfigComponent } from './process-config/process-config.component';
import { ProcessRouting } from './process.routing';
import { DiagramComponent } from './process-config/diagram/diagram.component';
import { TabletreeComponent } from './tabletree/tabletree.component';
import { DropDownTreeModule } from '@syncfusion/ej2-angular-dropdowns';
import { TreeTableModule } from 'primeng/treetable';


import { MatDialogModule, MatTableModule, MatPaginatorModule, MatPaginatorIntl, MatSelectModule, MatInputModule, MatCardModule, MatListModule, MatIconModule, MatSlideToggleModule } from '@angular/material';
import { NgxPaginationModule } from 'ngx-pagination';
import { FilterCallbackPipe } from 'src/app/pipes/filter-callback.pipe';
import { DndModule } from 'ngx-drag-drop';
import { AccordionModule } from 'primeng/accordion';
import { OrganizationTreeComponent } from './process-list/organization-tree/organization-tree.component';
import { SharedModule } from '../../shared/shared.module';
import {TranslateModule} from "@ngx-translate/core";

@NgModule({
  declarations: [ 
                  ProcessListComponent,
                  ProcessEditComponent,
                  ProcessConfigComponent,
                  DiagramComponent,
                  TabletreeComponent,
                  OrganizationTreeComponent],
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
        DndModule,
        DropDownTreeModule,
        TreeTableModule,
        AccordionModule,
        RouterModule.forChild(ProcessRouting),
        SharedModule,
        TranslateModule,
        SharedModule,
        ReactiveFormsModule
    ]
})
export class ProcessModule { }
