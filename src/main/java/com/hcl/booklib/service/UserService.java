package com.hcl.booklib.service;

import com.hcl.booklib.dto.RegistrationResponseDto;
import com.hcl.booklib.dto.UserDetailsDto;

public interface UserService {

	RegistrationResponseDto registration(UserDetailsDto userDetailsDto);

}
