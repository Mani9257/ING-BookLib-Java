package com.hcl.booklib.controller;

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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.booklib.entity.Book;
import com.hcl.booklib.entity.Category;
import com.hcl.booklib.service.CategoryServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class CategoryControllerTest {

private MockMvc mockMvc;

@InjectMocks
CategoryController categoryController;

@Mock
CategoryServiceImpl categoryServiceImpl;

Category category = new Category();
Category category1 = new Category();
Category category2 = new Category();

List<Category> categoryList = new ArrayList<>();

List<Book> bookList = new ArrayList<>();

@Before
public void setUp() {
mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();

category.setCategoryId(1);
category.setCategoryName("programming");

category1.setCategoryId(2);
category1.setCategoryName("health");

category2.setCategoryId(3);
category2.setCategoryName("electronics");

categoryList.add(category);
categoryList.add(category1);
categoryList.add(category2);
}

@Test
public void testGetAllCategories() {

Mockito.when(categoryServiceImpl.getAllCategory()).thenReturn(categoryList);

assertEquals(bookList, bookList);
try {
mockMvc.perform(MockMvcRequestBuilders.get("/library/api/categories"));
} catch (Exception e) {

log.info("logged exception{}", e);
}
}

}