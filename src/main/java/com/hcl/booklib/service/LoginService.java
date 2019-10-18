package com.hcl.booklib.service;

import org.springframework.stereotype.Service;

import com.hcl.booklib.dto.LoginResponseDto;
import com.hcl.booklib.dto.UserLoginDto;
import com.hcl.booklib.exception.UserDoesNotExistException;


@Service
public interface LoginService {
	/**
	 * This api is intended to login the customer
	 * @throws UserDoesNotExistException 
	 */
	public LoginResponseDto	 loginUser(UserLoginDto loginDto) throws UserDoesNotExistException;
}