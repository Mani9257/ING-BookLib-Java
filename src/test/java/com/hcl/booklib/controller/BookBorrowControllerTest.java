package com.hcl.booklib.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.booklib.dto.BorrowResponseDTO;
import com.hcl.booklib.entity.Book;
import com.hcl.booklib.entity.User;
import com.hcl.booklib.service.BorrowBookService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class BookBorrowControllerTest {

	@Mock
	BorrowBookService borrowBookService;

	private MockMvc mockMvc;

	@InjectMocks
	BorrowBookController borrowBookController;
	User user;
	Book book;
	BorrowResponseDTO borrowResponseDTO;

	@Before
	public void setUp() {

		mockMvc = MockMvcBuilders.standaloneSetup(borrowBookController).build();

		User user = new User();
		Book book = new Book();
		book.setAuthorName("aJITH");
		book.setBookId(1);
		book.setBookName("sECRET");
		book.setBookStatus("BORROWED");
		book.setCategoryId(1);

		user.setPassword("AJith");
		user.setUserId(1);

		BorrowResponseDTO borrowResponseDTO = new BorrowResponseDTO();

		borrowResponseDTO.setBorrowStatus("BORROWED");
		borrowResponseDTO.setMessage("Success");
		borrowResponseDTO.setStatusCode(HttpStatus.OK.value());
	}

	@Test
	public void testBorrowBook() {

		Mockito.when(borrowBookService.borowBook(Mockito.anyInt(), Mockito.anyInt())).thenReturn(borrowResponseDTO);
		ResponseEntity<BorrowResponseDTO> responseDto = borrowBookController.borowBook(1, 1);

		assertEquals(200, responseDto.getStatusCodeValue());
	}

}
