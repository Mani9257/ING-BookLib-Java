package com.hcl.booklib.service;

import static com.hcl.booklib.constants.LibraryConstants.NO_BOOK_FOUND;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.booklib.entity.Book;
import com.hcl.booklib.exception.NoBookFound;
import com.hcl.booklib.repository.BookRepository;

import lombok.extern.slf4j.Slf4j;

// TODO: Auto-generated Javadoc
/**
 * The Class BookServiceImpl.
 *
 * @author Abhishek BookServiceImpl will fetch books details from bookRepository
 *         by passing bookName
 */
@Service

/** The Constant log. */
@Slf4j
public class BookServiceImpl implements BookService {

	/** bookRepository will query to DB. */
	@Autowired
	private BookRepository bookRepository;

	
	/**
	 * Gets the all books by name.
	 *
	 * @param bookName the book name
	 * @return the all books by name
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

	/**
	 * Gets the books by category.
	 *
	 * @param categoryId the category id
	 * @return the books by category
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.hcl.booklib.service.BookService#getBooksByCategory(java.lang.Integer)
	 */
	@Override
	public List<Book> getBooksByCategory(Integer categoryId) {
		log.debug("data is{}", bookRepository.findBookByCategoryId(categoryId));
		return bookRepository.findBookByCategoryId(categoryId);
	}

	/**
	 * Gets the all books.
	 *
	 * @return the all books
	 */
	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

}
