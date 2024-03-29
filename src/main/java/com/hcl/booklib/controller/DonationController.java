package com.hcl.booklib.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.booklib.dto.CategoryResponseDto;
import com.hcl.booklib.dto.DonationRequestDto;
import com.hcl.booklib.dto.DonationResponseDto;
import com.hcl.booklib.exception.UserDoesNotExistException;
import com.hcl.booklib.service.CategoryService;
import com.hcl.booklib.service.DonationService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class DonationController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DonationController.class);

	@Autowired
	DonationService donationService;

	@Autowired
	CategoryService categoryService;
	
	
	
/**
 * 
 * @return this method use to get all the categories
 */
	@GetMapping(value = "/donation/categories")
	public ResponseEntity<CategoryResponseDto> getCategories() {
		LOGGER.info("inside categories");
		CategoryResponseDto categoryResponseDto = categoryService.getCategories();
		return new ResponseEntity<>(categoryResponseDto, HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * @param donationRequestDto
	 * @return this method is used to donate a book 
	 * @throws UserDoesNotExistException
	 */

	@PostMapping("/donation")
	public ResponseEntity<DonationResponseDto> donation(@RequestBody DonationRequestDto donationRequestDto) throws UserDoesNotExistException {
		LOGGER.info("inside registration");
		DonationResponseDto donationResponseDto;
	
			donationResponseDto = donationService.donation(donationRequestDto);
		
		return new ResponseEntity<>(donationResponseDto, HttpStatus.CREATED);
	}

}
