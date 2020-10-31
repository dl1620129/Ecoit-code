import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AtLeastOneWord } from 'src/app/directive/shared/at-least-one-word.directive';
import { MustBeAlphanumeric } from 'src/app/directive/shared/must-be-alphanumeric.directive';
import { MaxLengthDirective } from 'src/app/directive/shared/max-length.directive';
import { OnlyNumber } from 'src/app/directive/shared/only-number.directive';
import { OnlyPositiveNumber } from 'src/app/directive/shared/only-positive-number.directive';
import { OnlyWord } from 'src/app/directive/shared/only-word.directive';
import { AtLeastOneCharacter } from 'src/app/directive/shared/at-least-one-character.directive';
import { IndexByPageNumberPipe } from 'src/app/pipes/index-by-page-number.pipe';
import { UserAvatarUrlPipe } from 'src/app/pipes/user-avatar-url.pipe';
import { Unique } from 'src/app/directive/shared/unique.directive';
import { DocumentCommentPipe } from '../pipe/comment.pipe';
import { SortButtonComponent } from 'src/app/shared/sort-button/sort-button.component';
import { PageSizeComponent } from 'src/app/shared/page-size/page-size.component';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';
import { TranslateModule } from '@ngx-translate/core';
import { MinNumber } from 'src/app/directive/shared/min-number.directive';
import { SortByPipe } from 'src/app/pipes/sort-by.pipe';
// import { PageSizeComponent } from './page-size/page-size.component';


@NgModule({
  declarations: [
    AtLeastOneWord,
    MaxLengthDirective,
    OnlyNumber,
    OnlyPositiveNumber,
    OnlyWord,
    AtLeastOneCharacter,
    UserAvatarUrlPipe,
    IndexByPageNumberPipe,
    SortByPipe,
    MustBeAlphanumeric,
    Unique,
    DocumentCommentPipe,
    SortButtonComponent,
    PageSizeComponent,
    MinNumber,
  ],
  imports: [
    CommonModule,
    TranslateModule,
    FormsModule
  ],
  exports: [
    AtLeastOneWord,
    MustBeAlphanumeric,
    MaxLengthDirective,
    OnlyNumber,
    OnlyPositiveNumber,
    OnlyWord,
    AtLeastOneCharacter,
    UserAvatarUrlPipe,
    IndexByPageNumberPipe,
    Unique,
    DocumentCommentPipe,
    SortButtonComponent,
    PageSizeComponent,
    MinNumber
  ]
})
export class SharedModule { }
