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

Book book = new Book();
Book book1 = new Book();
List<Book> bookList = new ArrayList<>();

@Before
public void setUp() {
mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();

book.setBookId(1);
book.setBookName("why i am good");
book.setBookStatus("available");
book.setCategoryId(10);

book1.setBookId(2);
book1.setBookName("why i am perfect");
book1.setBookStatus("available");
book1.setCategoryId(11);
}

@Test
public void testGetBookByCategoryId() {

List<Book> bookList = new ArrayList<>();

bookList.add(book);
bookList.add(book1);

Mockito.when(bookServiceImpl.getBooksByCategory(11)).thenReturn(bookList);
assertEquals(bookList, bookList);
try {
mockMvc.perform(MockMvcRequestBuilders.get("/categories/11/books"));
} catch (Exception e) {

}

}

@Test
public void testGetAllBooks() {

bookList.add(book);
bookList.add(book1);

Mockito.when(bookServiceImpl.getAllBooks()).thenReturn(bookList);
try {
mockMvc.perform(MockMvcRequestBuilders.get("/books"));
} catch (Exception e) {
}
assertEquals(bookList, bookList);

}

}