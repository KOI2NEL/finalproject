import {UserResponseModel} from './UserResponse-model';

export class BorrowResponseModel {
  id: number;
  userRespone: UserResponseModel;
  bookResponse: BorrowResponseModel;
  borrowData: Date;
  requiredReturnDate: Date;
  returnDate: Date;
  fine: number;
  isActive: boolean;
}
