import {AuthorResponeModel} from './AuthorRespone-model';

export class BookDataResponseModel {
  id: number;
  title: string;
  authorResponse: AuthorResponeModel[] = [];

}
