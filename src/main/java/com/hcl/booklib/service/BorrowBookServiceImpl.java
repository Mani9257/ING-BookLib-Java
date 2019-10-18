package com.hcl.booklib.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.booklib.dto.BorrowResponseDTO;
import com.hcl.booklib.entity.Book;
import com.hcl.booklib.entity.BookBorrow;
import com.hcl.booklib.entity.User;
import com.hcl.booklib.exception.InvalidCredentialsException;
import com.hcl.booklib.repository.BookRepository;
import com.hcl.booklib.repository.BorrowBookRepository;
import com.hcl.booklib.repository.UserRepository;
import com.hcl.booklib.util.ExceptionConstants;

@Service
public class BorrowBookServiceImpl implements BorrowBookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BorrowBookRepository borrowBookRepository;

	@Autowired
	private ExceptionConstants exceptionConstants;

	public BorrowResponseDTO borowBook(int userId, int bookId) throws InvalidCredentialsException {

		Optional<User> user = userRepository.findByUserId(userId);
		Optional<Book> book = bookRepository.findByBookId(bookId);

		BorrowResponseDTO borrowResponseDTO = new BorrowResponseDTO();
		BookBorrow bookBorrow = new BookBorrow();

		if (user.isPresent()) {
			if (book.isPresent()) {
				Book book1 = book.get();
				if (book.get().getBookStatus().equalsIgnoreCase(ExceptionConstants.BORROW_BOOK_STATUS_AVAILABLE)) {

					borrowResponseDTO.setBorrowStatus(ExceptionConstants.BORROW_BOOK_STATUS_BORROWED);
					borrowResponseDTO.setMessage(ExceptionConstants.SUCCESS_MESSAGE);
					borrowResponseDTO.setStatusCode(ExceptionConstants.SUCCESS_STATUS_CODE);
					book1.setBookStatus(ExceptionConstants.BORROW_BOOK_STATUS_BORROWED);
					bookRepository.save(book1);

					bookBorrow.setBookName(book1.getBookName());
					bookBorrow.setBookId(book1.getBookId());
					bookBorrow.setBorrowStatus(ExceptionConstants.BORROW_BOOK_STATUS_BORROWED);
					bookBorrow.setDaysLeft(ExceptionConstants.DAYS_LEFT_TO_RETURN_BOOK);
					bookBorrow.setBorrowedDate(LocalDateTime.now());
					bookBorrow.setUserId(userId);
					borrowBookRepository.save(bookBorrow);

				} else {

					borrowResponseDTO.setBorrowStatus(ExceptionConstants.REQUEST_FOR_BORROWED_BOOK);
					borrowResponseDTO.setMessage(ExceptionConstants.SUCCESS_MESSAGE);
					borrowResponseDTO.setStatusCode(ExceptionConstants.SUCCESS_STATUS_CODE);
					book1.setBookStatus(ExceptionConstants.REQUEST_FOR_BORROWED_BOOK);
					bookRepository.save(book1);

					bookBorrow.setBookName(book1.getBookName());
					bookBorrow.setBookId(book1.getBookId());
					bookBorrow.setBorrowStatus(ExceptionConstants.REQUEST_FOR_BORROWED_BOOK);
					bookBorrow.setBorrowedDate(LocalDateTime.now());
					bookBorrow.setDaysLeft(ExceptionConstants.DAYS_LEFT_TO_BORROW_BOOK);
					bookBorrow.setUserId(userId);
					borrowBookRepository.save(bookBorrow);

				}
			}
		} else {
			throw new InvalidCredentialsException(ExceptionConstants.INVALID_CREDENTIALS_MESSAGE);
		}
		return borrowResponseDTO;
	}
}
