package com.hcl.booklib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.booklib.entity.Book;
import com.hcl.booklib.service.BookService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Abhishek
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
@Slf4j
public class BookSearchController {

	/**
	 * bookService will have a repository call to get book details
	 */
	@Autowired
	private BookService bookService;

	/**
	 * @param bookName
	 * @return all books related to search criteria
	 */
	@GetMapping(value = "/books/{bookName}", produces = "application/json")
	public ResponseEntity<List<Book>> getBooksByName(@PathVariable("bookName") String bookName) {
		log.info("getting books{}", bookService.getAllBooksByName(bookName));
		return new ResponseEntity<>(bookService.getAllBooksByName(bookName), HttpStatus.OK);

	}

}
