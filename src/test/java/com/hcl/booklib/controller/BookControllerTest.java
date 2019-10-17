package com.hcl.booklib.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.booklib.entity.Book;
import com.hcl.booklib.service.BookServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class BookControllerTest {

	private MockMvc mockMvc;

	@InjectMocks
	BookController bookController;

	@Mock
	BookServiceImpl bookServiceImpl;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
	}

	@Test
	public void testGetBookByCategoryId() throws Exception {

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

		Mockito.when(bookServiceImpl.getBooksByCategory(11)).thenReturn(bookList);
		mockMvc.perform(MockMvcRequestBuilders.get("/categories/11/books"));
		// .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());

	}

	@Test
	public void testGetAllBooks() throws Exception {

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

		Mockito.when(bookServiceImpl.getAllBooks()).thenReturn(bookList);
		mockMvc.perform(MockMvcRequestBuilders.get("/books"));

	}

}
