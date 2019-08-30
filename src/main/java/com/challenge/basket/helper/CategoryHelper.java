package com.challenge.basket.helper;
import java.util.ArrayList;
import java.util.List;

import com.challenge.basket.Category;

public class CategoryHelper {

	public List<Category> createCategoryList(int size) {
		List<Category> categories = new ArrayList<Category>(size);
		for(int i = 0; i< size; i++) {
			Category category = new Category();
			category.setName("Category" + i);
			categories.add(category);
		}
		return categories;
	}
}
