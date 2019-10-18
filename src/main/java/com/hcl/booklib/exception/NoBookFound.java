package com.hcl.booklib.exception;


public class NoBookFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoBookFound() {
		super();
	}

	public NoBookFound(String message) {
		super(message);
	}

}
