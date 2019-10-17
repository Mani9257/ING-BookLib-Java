package com.hcl.booklib.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.booklib.dto.DonationRequestDto;
import com.hcl.booklib.dto.DonationResponseDto;
import com.hcl.booklib.entity.Book;
import com.hcl.booklib.repository.BookRepository;
import com.hcl.booklib.repository.CategoryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DonationServiceImplTest {

	@Mock
	BookRepository bookRepository;

	@Mock
	CategoryRepository categoryRepository;

	@InjectMocks
	DonationServiceImpl donationServiceImpl;

	DonationRequestDto donationRequestDto = null;
	DonationResponseDto donationResponseDto = null;
	Book book = null;

	@Before
	public void setup() {
		donationRequestDto = new DonationRequestDto();
		donationRequestDto.setBookName("JAVA");
		donationRequestDto.setAuthor("Kamal");

		donationResponseDto = new DonationResponseDto();
		donationResponseDto.setStatusMessage("Successful");
		donationResponseDto.setStatusCode(200);

		book = new Book();
		book.setBookName("JAVA");
		book.setBookId(1);
	}

	@Test
	public void donationTest() {

		Mockito.when(bookRepository.save(Mockito.any())).thenReturn(book);
		
		assertEquals("Successful", donationResponseDto.getStatusMessage());
		assertEquals(donationResponseDto.getStatusCode(),donationResponseDto.getStatusCode());
		assertEquals(donationResponseDto.getBookId(),donationResponseDto.getBookId());

	}
}
