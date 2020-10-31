import { NgModule } from '@angular/core';
import { NbCardModule, NbDatepickerModule } from '@nebular/theme';

import { ThemeModule } from '../../@theme/theme.module';
import { ArticleEditorComponent } from './article-editor.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  imports: [
    NbCardModule,
    ThemeModule,
    FormsModule,
    ReactiveFormsModule,
    NbDatepickerModule,
  ],
  declarations: [
    ArticleEditorComponent,
  ],
})
export class ArticleEditorModule { }
