package com.hcl.booklib.exception;

public class NoBookFound extends RuntimeException {

	public NoBookFound() {
		super();
	}

	public NoBookFound(String message) {
		super(message);
	}

}
