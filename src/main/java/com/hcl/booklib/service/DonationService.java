package com.hcl.booklib.service;

import com.hcl.booklib.dto.DonationRequestDto;
import com.hcl.booklib.dto.DonationResponseDto;
import com.hcl.booklib.exception.UserDoesNotExistException;

public interface DonationService {

	DonationResponseDto donation(DonationRequestDto donationRequestDto) throws UserDoesNotExistException;

}
