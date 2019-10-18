package com.hcl.booklib.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.booklib.dto.BorrowResponseDTO;
import com.hcl.booklib.entity.Book;
import com.hcl.booklib.entity.User;
import com.hcl.booklib.exception.InvalidCredentialsException;
import com.hcl.booklib.repository.BookRepository;
import com.hcl.booklib.repository.BorrowBookRepository;
import com.hcl.booklib.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class BookBorrowServiceImplTest {

	@Mock
	private BookRepository bookRepository;

	@InjectMocks
	private BorrowBookServiceImpl bookServiceImpl;

	@Mock
	private UserRepository userRepository;

	@Mock
	private BorrowBookRepository borrowBookRepository;
	
	User user = new User();
	
	User user2 = new User();
	Book book = new Book();

	BorrowResponseDTO borrow = new BorrowResponseDTO();

	BorrowResponseDTO borrow2 = new BorrowResponseDTO();
	
	@Before
	public void setUp() {
	
		user.setUserId(1);

		
		book.setBookId(1);
		

		borrow.setBorrowStatus("BORROWED");
		borrow.setMessage("SUCCESSFUL");
		borrow.setStatusCode(200);
		
		
		borrow2.setBorrowStatus("BORROW REQUEST RAISED");
		borrow2.setMessage("SUCCESSFUL");
		borrow2.setStatusCode(200);

	}

	@Test
	public void bookBorrowTest() throws InvalidCredentialsException {

	
		book.setBookStatus("AVAILABLE");
		when(userRepository.findByUserId(Mockito.anyInt())).thenReturn(Optional.of(user));
		when(bookRepository.findByBookId(Mockito.anyInt())).thenReturn(Optional.of(book));

		BorrowResponseDTO response = bookServiceImpl.borowBook(1, 1);

		assertEquals("SUCCESSFUL", response.getMessage());
		assertEquals(borrow.getStatusCode(), response.getStatusCode());
		assertEquals("BORROWED", response.getBorrowStatus());

	}
	
	@Test
	public void bookBorrowedTest() throws InvalidCredentialsException {

	
		book.setBookStatus("BORROW REQUEST RAISED");
		when(userRepository.findByUserId(Mockito.anyInt())).thenReturn(Optional.of(user));
		when(bookRepository.findByBookId(Mockito.anyInt())).thenReturn(Optional.of(book));

		BorrowResponseDTO response = bookServiceImpl.borowBook(1, 1);

		assertEquals("SUCCESSFUL", response.getMessage());
		assertEquals(borrow.getStatusCode(), response.getStatusCode());
		assertEquals("BORROW REQUEST RAISED", response.getBorrowStatus());

	}

	@Test(expected = InvalidCredentialsException.class)
	public void bookBorrowInvalidTest() throws InvalidCredentialsException {

		
	
		when(userRepository.findByUserId(0)).thenReturn(Optional.empty());
		when(bookRepository.findByBookId(Mockito.anyInt())).thenReturn(Optional.of(book));
		BorrowResponseDTO response = bookServiceImpl.borowBook(0, 1);

		assertEquals("SUCCESSFUL", response.getMessage());
		assertEquals(borrow.getStatusCode(), response.getStatusCode());
		assertEquals("BORROWED", response.getBorrowStatus());

	}

}
