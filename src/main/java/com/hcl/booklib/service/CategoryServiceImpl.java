package com.hcl.booklib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.booklib.entity.Category;
import com.hcl.booklib.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	/*
	 * @Override public List<Book> booksUnderCategory(Integer categoryId) { return
	 * null; }
	 */

	@Override
	public Category getCategoryById(Integer categoryId) {
		return categoryRepository.getByCategoryId(categoryId);
	}

	@Override
	public List<Category> getAllCategory() {
		return categoryRepository.findAll();
	}

}
