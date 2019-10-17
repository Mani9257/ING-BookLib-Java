package com.hcl.booklib.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class BorrowResponseDTO {
	private String message;
	private Integer statusCode;
	private String borrowStatus;
}
