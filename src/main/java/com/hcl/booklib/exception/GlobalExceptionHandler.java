package com.hcl.booklib.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<ResponseDto> invalidCredentialsExceptionHandler(InvalidCredentialsException ex) {
		ResponseDto error = new ResponseDto(ex.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(HttpStatusCodeException.class)
	public ResponseEntity<String> mortgageExceptionHandler(HttpStatusCodeException ex, WebRequest request) {
		return ResponseEntity.status(ex.getRawStatusCode()).body(ex.getResponseBodyAsString());

	}

}