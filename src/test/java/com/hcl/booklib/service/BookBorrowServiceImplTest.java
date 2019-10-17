package com.hcl.booklib.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.booklib.dto.BorrowResponseDTO;
import com.hcl.booklib.entity.Book;
import com.hcl.booklib.entity.User;
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
	private BorrowBookRepository borrowBookRepository;;

	@Test
	public void bookBorrowTest() {

		User user = new User();
		user.setUserId(1);

		Book book = new Book();
		book.setBookId(1);
		book.setBookStatus("AVAILABLE");

		BorrowResponseDTO borrow = new BorrowResponseDTO();
		borrow.setBorrowStatus("BORROWED");
		borrow.setMessage("SUCCESSFUL");
		borrow.setStatusCode(200);

		when(userRepository.findByUserId(Mockito.anyInt())).thenReturn(Optional.of(user));
		when(bookRepository.findByBookId(Mockito.anyInt())).thenReturn(Optional.of(book));

		BorrowResponseDTO response = bookServiceImpl.borowBook(1, 1);

		assertEquals("SUCCESSFUL", response.getMessage());
		assertEquals(borrow.getStatusCode(), response.getStatusCode());
		assertEquals("BORROWED", response.getBorrowStatus());

	}

}
