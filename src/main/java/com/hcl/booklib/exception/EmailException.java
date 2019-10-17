package com.hcl.booklib.exception;



public class EmailException extends RuntimeException {

	private static final long serialVersionUID = 920762083967579400L;

	public EmailException(String message) {
		super(message);
	}

}
