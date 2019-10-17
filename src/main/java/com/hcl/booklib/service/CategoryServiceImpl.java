package com.hcl.booklib.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.booklib.dto.CategoryResponseDto;
import com.hcl.booklib.entity.Category;
import com.hcl.booklib.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryrepository;

	public CategoryResponseDto getCategories() {
		List<Category> list = categoryrepository.findAll();
		CategoryResponseDto categoryResponseDto = new CategoryResponseDto();
		List<String> categoryName = new ArrayList<>();
		list.forEach(name -> {
			String names = name.getCategoryName();
			categoryName.add(names);
		});
		categoryResponseDto.setCategoryName(categoryName);
		return categoryResponseDto;
	}

}
