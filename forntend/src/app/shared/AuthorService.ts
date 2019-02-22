import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {CreateAuthorModel} from '../model/create/CreateAuthor-model';
import {Subject} from 'rxjs';

@Injectable()
export class AuthorService {
  constructor(private http: HttpClient) {
  }

  refreshAuthorList = new Subject();

  getAuthor() {
    return this.http.get('http://localhost:8080/author/18/');
  }

  getAllAuthors() {
    return this.http.get('http://localhost:8080/author/all/');
  }

  createAuthor(createAuthor: CreateAuthorModel) {
    this.http.post('http://localhost:8080/author/add/', createAuthor).subscribe(() => this.refreshAuthorList.next());
  }
}
