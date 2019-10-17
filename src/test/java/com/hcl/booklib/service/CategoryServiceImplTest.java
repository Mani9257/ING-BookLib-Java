package com.hcl.booklib.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.booklib.entity.Category;
import com.hcl.booklib.repository.CategoryRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CategoryServiceImplTest {

	@Mock
	CategoryRepository categoryRepository;

	@InjectMocks
	CategoryServiceImpl categoryServiceImpl;

	@Test
	public void testGetCategories() {

		Category category = new Category();
		category.setCategoryId(1);
		category.setCategoryName("history");

		List<Category> cat = new ArrayList<>();
		cat.add(category);

		Mockito.when(categoryRepository.findAll()).thenReturn(cat);

		assertNotNull(cat);
		assertEquals("history", cat.get(0).getCategoryName());
	}

}
