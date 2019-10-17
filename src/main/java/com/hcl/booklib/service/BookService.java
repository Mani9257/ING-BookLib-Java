package com.hcl.booklib.service;

import java.util.List;

import com.hcl.booklib.entity.Book;

/**
 * @author Abhishek
 *
 */
public interface BookService {
	
	List<Book> getAllBooksByName(String bookName);
	
	List<Book> getBooksByCategory(Integer categoryId);
	
	List<Book> getAllBooks();
	
	
	
	

}
