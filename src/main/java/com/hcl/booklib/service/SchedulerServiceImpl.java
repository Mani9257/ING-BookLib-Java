package com.hcl.booklib.service;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.booklib.entity.BookBorrow;
import com.hcl.booklib.repository.BorrowBookRepository;

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

	

	@Override
	public void runTask() {

		log.info("SchedulerServiceImpl :: runTask - starts");

		List<BookBorrow> borrowedBooks = borrowBookRepository.findByBorrowStatusAndDaysLeft();
		borrowedBooks.stream().forEach(borrowedBook -> {
		
			Integer daysLeft=borrowedBook.getDaysLeft();
		if(daysLeft>0) {
			daysLeft--;
			log.info("DaysLeft={}",daysLeft);
			borrowedBook.setDaysLeft(daysLeft);
			borrowBookRepository.save(borrowedBook);

		}
		else if (daysLeft==0){
			
			List<BookBorrow> requestedBooks=borrowBookRepository.findByBorrowStatusAndBookId(borrowedBook.getBookId());
			
			
			
			
			
		}

			log.info("SchedulerServiceImpl :: runTask - borrowedBook : ");
		

			

		});

		log.info("SchedulerServiceImpl :: runTask - END");
	}
}
