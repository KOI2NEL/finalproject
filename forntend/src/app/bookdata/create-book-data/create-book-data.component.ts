import {Component, OnInit, ViewChild} from '@angular/core';
import {CreateBookDataModel} from '../../model/create/CreateBookData-model';
import {BookDataService} from '../../shared/BookDataService';
import {NgForm} from '@angular/forms';
import {AuthorResponeModel} from '../../model/response/AuthorRespone-model';
import {AuthorService} from '../../shared/AuthorService';

@Component({
  selector: 'app-create-book-data',
  templateUrl: './create-book-data.component.html',
  styleUrls: ['./create-book-data.component.css']
})
export class CreateBookDataComponent implements OnInit {
  createBookData: CreateBookDataModel = new CreateBookDataModel();
  authorList: AuthorResponeModel[] = [];
  @ViewChild('f') bookDataFrom: NgForm;
  authorToAdd: AuthorResponeModel;
  idToAdd: Number = 4;
  selectedAuthorList: AuthorResponeModel[] = [];

  constructor(private bookDataService: BookDataService, private authorService: AuthorService) {
  }

  ngOnInit() {
    this.getAuthorsList();
  }

  onSave() {
    this.addAuthorToList();
    this.bookDataService.createBookData(this.createBookData);
  }

  addAuthorToList() {

    this.createBookData.authorId.push(this.idToAdd);
    this.addAuthorToDisplay(this.idToAdd);
  }

  private getAuthorsList() {
    this.authorService.getAllAuthors().subscribe((authors: AuthorResponeModel[]) => {
      this.authorList = authors;
    });
  }


  private addAuthorToDisplay(id: Number) {

    console.log('asdas sadsdas' + id)
    this.authorList.forEach(a => {

      if (id.valueOf() == a.id.valueOf()) {
        this.selectedAuthorList.push(a);
      }
    });
  }
}
