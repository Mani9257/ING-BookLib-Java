package com.hcl.booklib.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hcl.booklib.entity.BookBorrow;

public interface BorrowBookRepository  extends JpaRepository<BookBorrow, Integer>{
	
	@Query(value="Select * from library.book_borrow where borrow_status='BORROWED' AND days_left>0",nativeQuery = true)
	List<BookBorrow> findByBorrowStatusAndDaysLeft();

	@Query(value="Select * from library.book_borrow where borrow_status='BORROW REQUEST RAISED' AND book_id=bookId",nativeQuery = true)
	List<BookBorrow> findByBorrowStatusAndBookId(Integer bookId);

}
