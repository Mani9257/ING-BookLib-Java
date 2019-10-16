package com.hcl.booklib.util;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;


@Component
public class ExceptionConstants {
	
	public static final String BORROW_BOOK_STATUS_AVAILABLE = "AVAILABLE";
	public static final String BORROW_BOOK_STATUS_BORROWED = "BORROWED";
	public static final String SUCCESS_MESSAGE="SUCCESSFUL";
	public static final Integer SUCCESS_STATUS_CODE= HttpStatus.OK.value();
	public static final String REQUEST_FOR_BORROWED_BOOK="BORROW REQUEST RAISED";
	public static final Integer DAYS_LEFT_TO_RETURN_BOOK=5;
	public static final Integer DAYS_LEFT_TO_BORROW_BOOK = 5;
	public static final String INVALID_CREDENTIALS_MESSAGE="User is not found";

}
