package com.hcl.booklib.dto;



import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DonationRequestDto implements Serializable{

	private static final long serialVersionUID = 1;

	
	private String bookName;
	private String author;
	private String categoryName;
	
	
}
