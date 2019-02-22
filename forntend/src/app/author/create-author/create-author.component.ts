import {Component, OnInit, ViewChild} from '@angular/core';
import {CreateAuthorModel} from '../../model/create/CreateAuthor-model';
import {AuthorService} from '../../shared/AuthorService';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-create-author',
  templateUrl: './create-author.component.html',
  styleUrls: ['./create-author.component.css']
})
export class CreateAuthorComponent implements OnInit {
  createAuthor: CreateAuthorModel = new CreateAuthorModel();

  @ViewChild ('f') authorForm: NgForm;

  constructor(private authorService: AuthorService) {
  }

  ngOnInit() {
  }

  onSave() {
    this.authorService.createAuthor(this.createAuthor);
  }
}
