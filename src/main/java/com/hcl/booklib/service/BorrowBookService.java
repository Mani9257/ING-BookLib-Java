package com.hcl.booklib.service;

import com.hcl.booklib.dto.BorrowResponseDTO;
import com.hcl.booklib.exception.InvalidCredentialsException;

public interface BorrowBookService {

	BorrowResponseDTO borowBook(int userId,int bookId) throws InvalidCredentialsException;

}
