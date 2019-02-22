export class CreateBorrowModel {
  userId: number;
  bookId: number;
  borrowDate: Date;
  requiredReturnDate: Date;
  returnDate: Date;
  isActive: boolean;
}
