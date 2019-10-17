package com.hcl.booklib.service;

import java.util.List;

import com.hcl.booklib.entity.Book;
import com.hcl.booklib.entity.Category;

public interface CategoryService {
	
//	List<Book> booksUnderCategory(Integer categoryId);
	
	Category getCategoryById(Integer categoryId);
	
	List<Category> getAllCategory();
	

}
