package com.hcl.booklib.dto;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class LoginResponseDto implements Serializable {

	public LoginResponseDto() {
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;
	private String message;
	private Integer statusCode;
	private Integer userId;

}
