package com.challenge.basket;

import java.util.List;

import com.challenge.basket.config.LoadProperties;
import com.challenge.basket.helper.CategoryHelper;
import com.challenge.basket.helper.ItemHelper;

public class CategoryGeneratorImpl implements ICategoryGenerator {
	CategoryHelper categoryHelper;
	ItemHelper itemHelper;

	public CategoryGeneratorImpl() {

	}

	public CategoryGeneratorImpl(CategoryHelper categoryHelper, ItemHelper itemHelper) {
		this.categoryHelper = categoryHelper;
		this.itemHelper = itemHelper;

	}

	public List<Category> generateCategories(LoadProperties properties) {
		List<Category> categories = categoryHelper.createCategoryList(properties.getNoOfCategories());// new ArrayList<Category>();
		for (Category category : categories) {
			category.setItems(itemHelper.creatItems(properties.getNoOfItemsPerCategory(), properties.getMinPrice(),
					properties.getMaxPrice(), properties.getMinShippingPrice(), properties.getMaxShippingPrice(),
					properties.getMinRating(), properties.getMaxRating()));
		}
		return categories;

	}
}
