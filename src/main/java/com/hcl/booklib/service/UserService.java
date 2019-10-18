package com.hcl.booklib.service;

import com.hcl.booklib.dto.RegistrationResponseDto;
import com.hcl.booklib.dto.UserDetailsDto;
import com.hcl.booklib.exception.UserDoesNotExistException;

public interface UserService {

	RegistrationResponseDto registration(UserDetailsDto userDetailsDto) throws UserDoesNotExistException;

	

}
