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

import com.hcl.booklib.dto.RegistrationResponseDto;
import com.hcl.booklib.dto.UserDetailsDto;
import com.hcl.booklib.service.UserService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class RegistrationController {
	private static final Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

	@Autowired
	UserService userService;

	@PostMapping("/registration")
	public ResponseEntity<RegistrationResponseDto> registration(@RequestBody UserDetailsDto userDetailsDto) {
		LOGGER.info("inside registration");
		RegistrationResponseDto registrationResponseDto = userService.registration(userDetailsDto);
		return new ResponseEntity<>(registrationResponseDto, HttpStatus.CREATED);
	}

}
