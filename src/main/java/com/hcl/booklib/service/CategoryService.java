package com.hcl.booklib.service;



import org.springframework.stereotype.Service;

import com.hcl.booklib.dto.CategoryResponseDto;



@Service
public interface CategoryService {
	
	CategoryResponseDto getCategories();

}
