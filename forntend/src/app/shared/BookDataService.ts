import {HttpClient} from '@angular/common/http';
import {Subject} from 'rxjs';
import {CreateBookDataModel} from '../model/create/CreateBookData-model';
import {Injectable} from '@angular/core';

@Injectable()
export class BookDataService {
  constructor(private  http: HttpClient) {
  }

  refreshBookDataList = new Subject();

  getBookData() {
    return this.http.get('http://localhost:8080/bookdata/18/');
  }

  getAllBookData() {
    return this.http.get('http://localhost:8080/bookdata/all/');
  }

  createBookData(createBookData: CreateBookDataModel) {
    this.http.post('http://localhost:8080/bookdata/add/', createBookData).subscribe(() => this.refreshBookDataList.next());
  }


}
