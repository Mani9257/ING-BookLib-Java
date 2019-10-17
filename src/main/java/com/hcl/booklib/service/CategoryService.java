package com.hcl.booklib.service;

import java.util.List;

import com.hcl.booklib.dto.CategoryResponseDto;
import com.hcl.booklib.entity.Category;

/**
 * @author Abhishek
 *
 */
public interface CategoryService {

	Category getCategoryById(Integer categoryId);

	List<Category> getAllCategory();

	CategoryResponseDto getCategories();

}
