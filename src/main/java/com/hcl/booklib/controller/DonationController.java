package com.hcl.booklib.controller;





import java.util.List;
import java.util.Optional;

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
import com.hcl.booklib.entity.Category;
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
	
	
	
	CategoryResponseDto categoryResponseDto;
	
	
	@GetMapping(value = "/categories")
	public ResponseEntity<CategoryResponseDto> getCategories() {
		LOGGER.info("inside categories");
		CategoryResponseDto categoryResponseDto = categoryService.getCategories();
		return new ResponseEntity<>(categoryResponseDto, HttpStatus.CREATED);
	}
	
	@PostMapping("/donation")
	public ResponseEntity<DonationResponseDto> donation(@RequestBody DonationRequestDto donationRequestDto) {
		LOGGER.info("inside registration");
		DonationResponseDto donationResponseDto = donationService.donation(donationRequestDto);
		return new ResponseEntity<>(donationResponseDto, HttpStatus.CREATED);
	}

}
