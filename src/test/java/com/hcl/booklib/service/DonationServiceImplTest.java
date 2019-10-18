package com.hcl.booklib.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.hcl.booklib.dto.DonationRequestDto;
import com.hcl.booklib.dto.DonationResponseDto;
import com.hcl.booklib.entity.Book;
import com.hcl.booklib.exception.UserDoesNotExistException;
import com.hcl.booklib.repository.BookRepository;
import com.hcl.booklib.repository.CategoryRepository;

@RunWith(SpringRunner.class)
public class DonationServiceImplTest {

	@Mock
	BookRepository bookRepository;

	@Mock
	CategoryRepository categoryRepository;

	@InjectMocks
	DonationServiceImpl donationServiceImpl;

	DonationRequestDto donationRequestDto = new DonationRequestDto();
	DonationResponseDto donationResponseDto = new DonationResponseDto();
	DonationRequestDto donationRequestDto2 = new DonationRequestDto();
	Book book = new Book();
	Book book2 = new Book();

	@Before
	public void setup() {

		donationRequestDto.setBookName("JAVA");
		donationRequestDto.setAuthor("Kamal");

		donationResponseDto.setStatusMessage("Successful");
		donationResponseDto.setStatusCode(200);

		book.setBookName("JAVA");
		book.setBookId(1);
	}

	@Test
	public void donationTest() {

		Mockito.when(bookRepository.save(Mockito.any())).thenReturn(book);

		assertEquals("Successful", donationResponseDto.getStatusMessage());
		assertEquals(donationResponseDto.getStatusCode(), donationResponseDto.getStatusCode());
		assertEquals(donationResponseDto.getBookId(), donationResponseDto.getBookId());

	}

	@Test(expected = UserDoesNotExistException.class)
	public void donationInvalidTest() throws UserDoesNotExistException {

		Mockito.when(bookRepository.save(Mockito.any())).thenReturn(book2);
		donationServiceImpl.donation(null);

	}
}
