package com.hcl.booklib.service;

import com.hcl.booklib.dto.BorrowResponseDTO;

public interface BorrowBookService {

	BorrowResponseDTO borowBook(int userId,int bookId);

}
