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
 *  this controller will fetch allBooks and book belongs to
 *         particular category
 * @author Abhishek
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
@Slf4j
public class BookController {

	/**
	 * bookService will communicate with bookRepository
	 */
	@Autowired
	private BookService bookService;

	/**
	 * @param categoryId
	 * @return by taking categoryId it will show all the books belonging to that
	 *         categoryId
	 */
	@GetMapping(value = "/categories/{categoryId}/books")
	public ResponseEntity<List<Book>> getBookByCategoryId(@PathVariable("categoryId") Integer categoryId) {
		log.info("inside getBookBy Category Id method");
		return new ResponseEntity<>(bookService.getBooksByCategory(categoryId), HttpStatus.OK);
	}

	/**
	 * @return it will return allBooks irrespective of categoryId
	 */
	@GetMapping(value = "/books")
	public ResponseEntity<List<Book>> getAllBooks() {
		return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
	}

}
