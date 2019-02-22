import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {AuthorComponent} from './author/author.component';
import {WelcomeComponent} from './welcome/welcome.component';
import {BookdataComponent} from './bookdata/bookdata.component';
import {BookComponent} from './book/book.component';
import {UserComponent} from './user/user.component';

const routes: Routes = [
  {path: 'welcome', component: WelcomeComponent},
  {path: 'authors', component: AuthorComponent},
  {path: 'bookdatas', component: BookdataComponent},
  {path: 'books', component: BookComponent},
  {path: 'user', component: UserComponent},
  {path: '**', redirectTo: 'welcome'},

  ];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
