package com.hcl.booklib.service;

import java.util.List;

import com.hcl.booklib.entity.Book;

public interface BookService {
	
	List<Book> getAllBooksByName(String bookName);
	
	List<Book> getBooksByCategory(Integer categoryId);
	
	List<Book> getAllBooks();
	
	
	
	

}
