package com.hcl.booklib.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.booklib.dto.CategoryResponseDto;
import com.hcl.booklib.dto.DonationRequestDto;
import com.hcl.booklib.dto.DonationResponseDto;
import com.hcl.booklib.entity.Book;
import com.hcl.booklib.entity.Category;
import com.hcl.booklib.exception.UserDoesNotExistException;
import com.hcl.booklib.service.CategoryService;
import com.hcl.booklib.service.DonationService;

@RunWith(SpringJUnit4ClassRunner.class)

public class DonationControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	DonationController donationController;

	@Mock
	DonationService donationService;

	@Mock
	CategoryService categoryService;

	CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
	
	List<Category> categoryList = new ArrayList<>();
	
	DonationResponseDto donationResponseDto = new DonationResponseDto();
	
	DonationRequestDto donationRequestDto= new DonationRequestDto();
	
	Book book=new  Book();

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(donationController).build();

		List<String> categoryName = new ArrayList<>();
		categoryName.add("fiction");

		categoryResponseDto.setCategoryName(categoryName);
		categoryResponseDto.setMessage("SUCCESS");
		categoryResponseDto.setStatusCode(201);
		
		donationResponseDto.setBookId(1);
		donationResponseDto.setStatusCode(200);
		donationResponseDto.setStatusMessage("SUCCESS");
		
		donationRequestDto.setAuthor(book.getAuthorName());
		donationRequestDto.setCategoryName("fiction");
		donationRequestDto.setBookName("Secret");
		
		book.setBookName("Secret");
		book.setAuthorName("Rhonda");
		book.setBookId(1);
	}

	@Test
	public void testGetCategories() {

		Mockito.when(categoryService.getCategories()).thenReturn(categoryResponseDto);
		ResponseEntity<CategoryResponseDto> categoryResponseDto = donationController.getCategories();

		assertEquals(201, categoryResponseDto.getStatusCodeValue());

	}

	@Test
	public void testDonation() throws UserDoesNotExistException {

		Mockito.when(donationService.donation(Mockito.any())).thenReturn(donationResponseDto);
		ResponseEntity<DonationResponseDto> donationResponseDto = donationController.donation(donationRequestDto);

		assertEquals(donationResponseDto.getStatusCode(), donationResponseDto.getStatusCode());

	}
}
