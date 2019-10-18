
package com.hcl.booklib.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.booklib.entity.Category;
import com.hcl.booklib.repository.CategoryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryServiceImplTest {

	@Mock
	CategoryRepository categoryRepository;

	@InjectMocks
	CategoryServiceImpl categoryServiceImpl;

	Category category = new Category();
	Category category1 = new Category();
	Category category2 = new Category();

	List<Category> categoryList = new ArrayList<>();

	@Before
	public void setup() {

		category.setCategoryId(1);
		category.setCategoryName("programming");

		

		categoryList.add(category);
		

	}

	@Test
	public void testGetAllCategory() {
		Mockito.when(categoryRepository.findAll()).thenReturn(categoryList);
		List<Category> categoryList1 = categoryServiceImpl.getAllCategory();
		assertEquals(categoryList, categoryList1);
	}

	@Test
	public void testGetCategoryById() {
		Mockito.when(categoryRepository.getByCategoryId(1)).thenReturn(category);

		Category category5 = categoryServiceImpl.getCategoryById(1);
		assertEquals(category, category5);

	}
	
	@Test
	public void testGetCategories() {
		Mockito.when(categoryRepository.findAll()).thenReturn(categoryList);
		List<Category> categoryList1 = categoryServiceImpl.getAllCategory();
		assertEquals(categoryList, categoryList1);
	}

}