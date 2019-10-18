package com.hcl.booklib.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.booklib.constants.LibraryConstants;
import com.hcl.booklib.dto.DonationRequestDto;
import com.hcl.booklib.dto.DonationResponseDto;
import com.hcl.booklib.entity.Book;
import com.hcl.booklib.entity.Category;
import com.hcl.booklib.exception.UserDoesNotExistException;
import com.hcl.booklib.repository.BookRepository;
import com.hcl.booklib.repository.CategoryRepository;
import com.hcl.booklib.util.ExceptionConstants;

@Service
public class DonationServiceImpl implements DonationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DonationServiceImpl.class);

	@Autowired
	BookRepository bookRepository;

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	LibraryConstants constants;
	
	@Autowired
	ExceptionConstants exceptionConstants;

	@Override
	public DonationResponseDto donation(DonationRequestDto donationRequestDto) throws UserDoesNotExistException {

		Book book = null;
		DonationResponseDto donationResponseDto = null;

		if (donationRequestDto != null) {

			
			book = new Book();
	
			Category category=categoryRepository.findByCategoryName(donationRequestDto.getCategoryName());
			BeanUtils.copyProperties(donationRequestDto, book);
			book.setBookStatus(ExceptionConstants.BORROW_BOOK_STATUS_AVAILABLE);
			book.setAuthorName(donationRequestDto.getAuthor());
			book.setCategoryId(category.getCategoryId());
			bookRepository.save(book);
			donationResponseDto = new DonationResponseDto();
			LOGGER.info("INSIDE DONATION METHOD");
			donationResponseDto.setBookId(book.getBookId());
			donationResponseDto.setStatusCode(LibraryConstants.SUCCESS_STATUS_CODE);
			donationResponseDto.setStatusMessage(LibraryConstants.SUCCESS_DONATE_STATUS_MESSAGE);

		}
		else {
			throw new UserDoesNotExistException("Please enter details of book which your donating");
		}

		return donationResponseDto;
	}

}