package com.hcl.booklib.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.booklib.entity.BookBorrow;
import com.hcl.booklib.repository.BorrowBookRepository;
import com.hcl.booklib.util.ExceptionConstants;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Ajith
 * @desc This service will take care of all transaction from account to mortgage
 *       account
 *
 */
@Service
@Slf4j
@Transactional
public class SchedulerServiceImpl implements SchedulerService {

	@Autowired
	private BorrowBookRepository borrowBookRepository;

	@Autowired
	private ExceptionConstants exceptionConstants;

	@Override
	public void runTask() {

		log.info("SchedulerServiceImpl :: runTask - starts");

		List<BookBorrow> updateborrowedBooks = new ArrayList<>();
		List<BookBorrow> borrowedBooks = borrowBookRepository.findByBorrowStatusAndDaysLeft();
		borrowedBooks.stream().forEach(borrowedBook -> {

			Integer daysLeft = borrowedBook.getDaysLeft();

			if (daysLeft > 0) {
				daysLeft--;
				log.info("DaysLeft={}", daysLeft);
				borrowedBook.setDaysLeft(daysLeft);
				updateborrowedBooks.add(borrowedBook);
				if (daysLeft == 0) {

					BookBorrow requestedBook = borrowBookRepository.findByBorrowStatusAndBookId(borrowedBook.getBookId());

					log.info("BorrowedDate={}", requestedBook.getBorrowedDate());
					requestedBook.setBorrowStatus(ExceptionConstants.BORROW_BOOK_STATUS_BORROWED);
					borrowBookRepository.save(requestedBook);
					borrowedBook.setBorrowStatus(ExceptionConstants.BORROW_BOOK_STATUS_SUBMITTED);
					updateborrowedBooks.add(borrowedBook);
				}
			}

		

			log.info("SchedulerServiceImpl :: runTask - borrowedBook : ");

		});

		borrowBookRepository.saveAll(updateborrowedBooks);
		log.info("SchedulerServiceImpl :: runTask - END");
	}
}
