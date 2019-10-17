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
import com.hcl.booklib.repository.BookRepository;
import com.hcl.booklib.repository.CategoryRepository;

@Service
public class DonationServiceImpl implements DonationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DonationServiceImpl.class);

	@Autowired
	BookRepository bookRepository;

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	LibraryConstants constants;

	@Override
	public DonationResponseDto donation(DonationRequestDto donationRequestDto) {

		Book book = null;
		DonationResponseDto donationResponseDto = null;

		if (donationRequestDto != null) {

			book = new Book();

			BeanUtils.copyProperties(donationRequestDto, book);
			bookRepository.save(book);
			donationResponseDto = new DonationResponseDto();
			LOGGER.info("INSIDE dONATION METHOD");

			donationResponseDto.setStatusCode(LibraryConstants.SUCCESS_STATUS_CODE);
			donationResponseDto.setStatusMessage(LibraryConstants.SUCCESS_DONATE_STATUS_MESSAGE);

		}

		return donationResponseDto;
	}

}