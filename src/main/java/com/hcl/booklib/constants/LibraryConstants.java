package com.hcl.booklib.constants;

import org.springframework.stereotype.Component;

@Component
public class LibraryConstants {
	private LibraryConstants() {
		
	}

	public static final Integer SUCCESS_STATUS_CODE = 200;
	public static final String SUCCESS_STATUS_MESSAGE = "Successful";
	public static final String SUCCESS_DONATE_STATUS_MESSAGE = "Added Book Successfully ";
	public static final String NO_BOOK_FOUND = "no match available";

}
