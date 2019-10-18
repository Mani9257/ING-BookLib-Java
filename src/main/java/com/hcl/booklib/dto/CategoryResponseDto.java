package com.hcl.booklib.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter

public class CategoryResponseDto implements Serializable {

	private static final long serialVersionUID = 1;

	private List<String> categoryName;
	private Integer statusCode;
	private String message;

	
}
