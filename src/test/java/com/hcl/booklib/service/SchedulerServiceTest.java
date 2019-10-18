
package com.hcl.booklib.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.booklib.entity.BookBorrow;
import com.hcl.booklib.repository.BorrowBookRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SchedulerServiceTest {

	@Mock
	private BorrowBookRepository borrowBookRepository;

	@InjectMocks
	private SchedulerServiceImpl schedulerServiceImpl;

	List<BookBorrow> bookBorrows = new ArrayList<>();
	List<BookBorrow> updateborrowedBooks = new ArrayList<>();

	@Test
	public void testRunTask() {

		BookBorrow bookBorrow = new BookBorrow();
		bookBorrow.setBookId(1);
		bookBorrow.setBookName("Ajith");
		bookBorrow.setBorrowedDate(LocalDateTime.now());
		bookBorrow.setBorrowId(1);
		bookBorrow.setBorrowStatus("BORROWED");
		bookBorrow.setDaysLeft(5);
		bookBorrow.setUserId(1);
		bookBorrows.add(bookBorrow);
		updateborrowedBooks.add(bookBorrow);

		Mockito.when(borrowBookRepository.findByBorrowStatusAndDaysLeft()).thenReturn(updateborrowedBooks);
		Mockito.when(borrowBookRepository.findByBorrowStatusAndBookId(Mockito.anyInt())).thenReturn(bookBorrow);
		
		List<BookBorrow> response= borrowBookRepository.findByBorrowStatusAndDaysLeft();
		assertEquals(updateborrowedBooks.size(), response.size());
		BookBorrow response2= borrowBookRepository.findByBorrowStatusAndBookId(Mockito.anyInt());
		assertEquals("Ajith",response2.getBookName());
	}
}
