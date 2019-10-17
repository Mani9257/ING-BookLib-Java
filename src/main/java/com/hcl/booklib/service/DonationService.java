package com.hcl.booklib.service;

import com.hcl.booklib.dto.DonationRequestDto;
import com.hcl.booklib.dto.DonationResponseDto;

public interface DonationService {

	DonationResponseDto donation(DonationRequestDto donationRequestDto);

}
