package com.hcl.booklib.service;

import org.springframework.stereotype.Service;

import com.hcl.booklib.dto.LoginResponseDto;
import com.hcl.booklib.dto.UserLoginDto;


@Service
public interface LoginService {
	/**
	 * This api is intended to login the customer
	 */
	public LoginResponseDto	 loginUser(UserLoginDto loginDto);
}