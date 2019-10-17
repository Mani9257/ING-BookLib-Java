package com.hcl.booklib.dto;

import java.io.Serializable;
import java.util.List;

import com.hcl.booklib.entity.Category;

import lombok.Getter;
import lombok.Setter;

public class CategoryResponseDto implements Serializable {

	private static final long serialVersionUID = 1;

	List<String> categoryName;
	private Integer statusCode;
	private String message;

	public List<String> getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(List<String> categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "CategoryResponseDto [categoryName=" + categoryName + ", statusCode=" + statusCode + ", message="
				+ message + "]";
	}

}
