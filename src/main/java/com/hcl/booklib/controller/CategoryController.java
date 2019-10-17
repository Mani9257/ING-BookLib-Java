package com.hcl.booklib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.booklib.entity.Category;
import com.hcl.booklib.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Abhishek
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
@Slf4j
public class CategoryController {

	/**
	 * categoryService will communicate categoryRepository to get relevant details
	 */
	@Autowired
	private CategoryService categoryService;

	/**
	 * @param categoryId
	 * @return
	 */
	@GetMapping(value = "/categories/{categoryId}")
	public ResponseEntity<Category> getCategoryByCategoryId(@PathVariable("categoryId") Integer categoryId) {
		return new ResponseEntity<Category>(categoryService.getCategoryById(categoryId), HttpStatus.OK);
	}

	/**
	 * @return will return all categories
	 */
	@GetMapping(value = "/categories")
	public ResponseEntity<List<Category>> getAllCategories() {
		return new ResponseEntity<List<Category>>(categoryService.getAllCategory(), HttpStatus.OK);
	}

}
