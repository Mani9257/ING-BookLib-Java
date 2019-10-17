package com.hcl.booklib.service;

import static com.hcl.booklib.constants.Constants.NO_BOOK_FOUND;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.booklib.entity.Book;
import com.hcl.booklib.exception.NoBookFound;
import com.hcl.booklib.repository.BookRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Abhishek 
 * BookServiceImpl will fetch books details from bookRepository
 *         by passing bookName
 *
 */
@Service
@Slf4j
public class BookServiceImpl implements BookService {

	/**
	 * bookRepository will query to DB
	 */
	@Autowired
	private BookRepository bookRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.hcl.booklib.service.BookService#getAllBooksByName(java.lang.String)
	 */
	@Override
	public List<Book> getAllBooksByName(String bookName) {
		log.info("getting books from repository {}}");
		List<Book> findByBookName = bookRepository.findByBookNameStartsWith(bookName);

		if (findByBookName.isEmpty()) {
			throw new NoBookFound(NO_BOOK_FOUND);

		}

		return findByBookName;
	}

	/* (non-Javadoc)
	 * @see com.hcl.booklib.service.BookService#getBooksByCategory(java.lang.Integer)
	 */
	@Override
	public List<Book> getBooksByCategory(Integer categoryId) {
		log.debug("data is{}",bookRepository.findBookByCategoryId(categoryId));
		return bookRepository.findBookByCategoryId(categoryId);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	
	
	
	

}
