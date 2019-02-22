import {Component, OnInit} from '@angular/core';
import {AuthorService} from '../shared/AuthorService';
import {AuthorResponeModel} from '../model/response/AuthorRespone-model';

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit {
  authors: AuthorResponeModel[] = [];

  constructor(private authorService: AuthorService) {
  }

  ngOnInit() {
    this.authorService.refreshAuthorList.subscribe(() => this.getAuthorsList());
    this.authorService.refreshAuthorList.next();
  }

  private getAuthorsList() {
    this.authorService.getAllAuthors().subscribe((authors: any[]) => {
      this.authors = authors;
    });
  }
}
