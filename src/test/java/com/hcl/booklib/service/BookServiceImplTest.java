package com.hcl.booklib.service;

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

import com.hcl.booklib.entity.Book;
import com.hcl.booklib.exception.NoBookFound;
import com.hcl.booklib.repository.BookRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class BookServiceImplTest {

@Mock
BookRepository bookRepository;

@InjectMocks
BookServiceImpl bookServiceImpl;

Book book = new Book();
Book book1 = new Book();
List<Book> bookList = new ArrayList<>();

@Before
public void setup() {

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
public void testGetAllBooksByName() {

bookList.add(book);
bookList.add(book1);

Mockito.when(bookRepository.findByBookNameStartsWith("why")).thenReturn(bookList);

List<Book> bookList1 = bookServiceImpl.getAllBooksByName("why");
assertEquals(bookList1, bookList);

}

@Test(expected = NoBookFound.class)
public void testgetAllBooksByNameIfNotAvailable() {

Mockito.when(bookRepository.findByBookNameStartsWith("po")).thenReturn(bookList);

List<Book> bookList1 = bookServiceImpl.getAllBooksByName(null);
assertEquals(null, bookList1.size());

}

@Test
public void testGetBooksByCategory() {

bookList.add(book);
bookList.add(book1);

Mockito.when(bookRepository.findBookByCategoryId(11)).thenReturn(bookList);

List<Book> bookList1 = bookServiceImpl.getBooksByCategory(11);

assertEquals(bookList1, bookList);

}

@Test
public void testGetAllBooks() {

bookList.add(book);
bookList.add(book1);

Mockito.when(bookRepository.findAll()).thenReturn(bookList);

List<Book> bookList1 = bookServiceImpl.getAllBooks();
assertEquals(bookList, bookList1);
}

}
