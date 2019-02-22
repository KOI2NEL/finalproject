import {Component, OnInit} from '@angular/core';
import {BookDataResponseModel} from '../model/response/BookDataResponse-model';
import {BookDataService} from '../shared/BookDataService';
import {log} from 'util';
import {AuthorService} from '../shared/AuthorService';
import {AuthorResponeModel} from '../model/response/AuthorRespone-model';

@Component({
  selector: 'app-bookdata',
  templateUrl: './bookdata.component.html',
  styleUrls: ['./bookdata.component.css']
})
export class BookdataComponent implements OnInit {
  bookdatas: BookDataResponseModel[] = [];

  constructor(private bookDataService: BookDataService, private authorService: AuthorService) {
  }

  ngOnInit() {
    this.bookDataService.refreshBookDataList.subscribe(() => this.getBookDataList());
    this.bookDataService.refreshBookDataList.next();
  }


  private getBookDataList() {
    this.bookDataService.getAllBookData().subscribe((bookDatas: BookDataResponseModel []) => {

      this.bookdatas = bookDatas;
    });
  }

}
