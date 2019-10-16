package com.hcl.booklib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.booklib.dto.BorrowResponseDTO;
import com.hcl.booklib.service.BorrowBookService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Ajith
 *
 */
@RequestMapping("/api")
@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
@Slf4j
public class BorrowBookController {

	@Autowired
	private BorrowBookService borrowBookService;

	@PutMapping("users/{userId}/books/{bookId}/borrow")
	public ResponseEntity<BorrowResponseDTO> borowBook(@PathVariable int userId, @PathVariable int bookId) {
		log.info("borowBook-->");
		BorrowResponseDTO borrowedBook = borrowBookService.borowBook(userId, bookId);
		return new ResponseEntity<>(borrowedBook, HttpStatus.OK);
	}
}
