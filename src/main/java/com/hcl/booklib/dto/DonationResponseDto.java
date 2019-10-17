package com.hcl.booklib.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DonationResponseDto implements Serializable{

	private static final long serialVersionUID =1;

	private Integer bookId;
    private Integer statusCode;
	private String statusMessage;
	
}
