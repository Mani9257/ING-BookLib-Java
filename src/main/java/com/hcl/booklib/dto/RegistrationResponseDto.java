package com.hcl.booklib.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationResponseDto implements Serializable{

	private static final long serialVersionUID =1;

	private Integer userId;
	private Integer statusCode;
	private String statusMessage;
	
}
