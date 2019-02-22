import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {CommonModule} from '@angular/common';
import {HttpClientModule} from '@angular/common/http';
import {AuthorService} from './AuthorService';
import {FormsModule} from '@angular/forms';
import {BookDataService} from './BookDataService';

@NgModule({
    declarations: [],
    imports: [
      CommonModule,
      BrowserModule,
      HttpClientModule,
      FormsModule,
    ],
    providers: [AuthorService, BookDataService,],
    exports: [
      CommonModule,
      BrowserModule,
      HttpClientModule,
      FormsModule,
    ],
  },
)
export class SharredModule {
}
