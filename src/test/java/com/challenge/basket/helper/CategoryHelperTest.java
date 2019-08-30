package com.challenge.basket.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.challenge.basket.Category;

class CategoryHelperTest {
	CategoryHelper helper;
	Integer size;
	@BeforeEach
	void setUp() throws Exception {
		helper = new CategoryHelper();
		size = 20;
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	
	@Test
	@DisplayName("to test createCategoryList")
	void test() {
		List<Category> categories = helper.createCategoryList(size);
		assertEquals(Integer.valueOf(size), Integer.valueOf(categories.size()),"test createCategoryList failed");
	}

}
