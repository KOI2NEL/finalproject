import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthorComponent } from './author/author.component';
import { BorrowComponent } from './borrow/borrow.component';
import { BookComponent } from './book/book.component';
import { BookdataComponent } from './bookdata/bookdata.component';
import { UserComponent } from './user/user.component';
import { RegisterComponent } from './register/register.component';
import {SharredModule} from './shared/sharred.module';
import { WelcomeComponent } from './welcome/welcome.component';
import { CreateAuthorComponent } from './author/create-author/create-author.component';
import { CreateBookDataComponent } from './bookdata/create-book-data/create-book-data.component';

@NgModule({
  declarations: [
    AppComponent,
    AuthorComponent,
    BorrowComponent,
    BookComponent,
    BookdataComponent,
    UserComponent,
    RegisterComponent,
    WelcomeComponent,
    CreateAuthorComponent,
    CreateBookDataComponent
  ],
  imports: [
    AppRoutingModule,
    SharredModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
