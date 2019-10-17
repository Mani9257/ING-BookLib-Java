package com.hcl.booklib.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.booklib.entity.Book;
import com.hcl.booklib.exception.NoBookFound;
import com.hcl.booklib.repository.BookRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class BookServiceImplTest {

	@Mock
	BookRepository bookRepository;

	@InjectMocks
	BookServiceImpl bookServiceImpl;

	@Test
	public void testgetAllBooksByName() {

		Book book = new Book();
		book.setBookId(1);
		book.setBookName("why i am good");
		book.setBookStatus("available");
		book.setCategoryId(10);

		Book book1 = new Book();
		book1.setBookId(2);
		book1.setBookName("why i am perfect");
		book1.setBookStatus("available");
		book1.setCategoryId(11);

		List<Book> bookList = new ArrayList<Book>();

		bookList.add(book);
		bookList.add(book1);

		Mockito.when(bookRepository.findByBookNameStartsWith(Mockito.anyString())).thenReturn(bookList);


		List<Book> response=bookServiceImpl.getAllBooksByName(Mockito.anyString());
		assertEquals(bookList.size(), response.size());
	}

	@Test
	public void testGetBooksByCategory() {

		Book book = new Book();
		book.setBookId(1);
		book.setBookName("why i am good");
		book.setBookStatus("available");
		book.setCategoryId(11);

		Book book1 = new Book();
		book1.setBookId(2);
		book1.setBookName("why i am perfect");
		book1.setBookStatus("available");
		book1.setCategoryId(11);

		List<Book> bookList = new ArrayList<Book>();

		bookList.add(book);
		bookList.add(book1);

		Mockito.when(bookRepository.findBookByCategoryId(11)).thenReturn(bookList);
		
		List<Book> response=bookServiceImpl.getBooksByCategory(11);
		assertEquals(bookList.size(), response.size());


	}

	@Test
	public void testGetAllBooks() {

		Book book = new Book();
		book.setBookId(1);
		book.setBookName("why i am good");
		book.setBookStatus("available");
		book.setCategoryId(11);

		Book book1 = new Book();
		book1.setBookId(2);
		book1.setBookName("why i am perfect");
		book1.setBookStatus("available");
		book1.setCategoryId(11);

		List<Book> bookList = new ArrayList<Book>();

		bookList.add(book);
		bookList.add(book1);

		Mockito.when(bookRepository.findAll()).thenReturn(bookList);

		List<Book> bookList1 = bookServiceImpl.getAllBooks();
		assertEquals(bookList, bookList1);
		assertEquals(bookList.size(),bookList1.size());
	}

}
