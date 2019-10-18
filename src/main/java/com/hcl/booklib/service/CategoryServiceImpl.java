package com.hcl.booklib.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.booklib.constants.LibraryConstants;
import com.hcl.booklib.dto.CategoryResponseDto;
import com.hcl.booklib.entity.Category;
import com.hcl.booklib.repository.CategoryRepository;

/**
 * @author Abhishek
 *
 */

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired

	

	private CategoryRepository categoryRepository;

	public Category getCategoryById(Integer categoryId) {
		return categoryRepository.getByCategoryId(categoryId);
	}

	public List<Category> getAllCategory() {
		return categoryRepository.findAll();

	}

	public CategoryResponseDto getCategories() {
		List<Category> list = categoryRepository.findAll();

		CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
		List<String> categoryName = new ArrayList<>();
		list.forEach(name -> {
			String names = name.getCategoryName();
			categoryName.add(names);
		});

		categoryResponseDto.setCategoryName(categoryName);
		categoryResponseDto.setStatusCode(LibraryConstants.SUCCESS_STATUS_CODE);
		categoryResponseDto.setMessage(LibraryConstants.SUCCESS_STATUS_MESSAGE);
		return categoryResponseDto;

	}

}
