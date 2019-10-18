package com.hcl.booklib.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.booklib.dto.LoginResponseDto;
import com.hcl.booklib.dto.UserLoginDto;
import com.hcl.booklib.exception.UserDoesNotExistException;
import com.hcl.booklib.service.LoginServiceImpl;

@RestController
@RequestMapping("/api")

@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	LoginServiceImpl loginServiceImpl;

	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> loginUser(@RequestBody UserLoginDto loginDto) throws UserDoesNotExistException {
		logger.info("in login customer method");
		LoginResponseDto response = loginServiceImpl.loginUser(loginDto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
