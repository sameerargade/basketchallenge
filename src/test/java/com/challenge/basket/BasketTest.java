package com.challenge.basket;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.challenge.basket.config.LoadProperties;
import com.challenge.basket.helper.CategoryHelper;
import com.challenge.basket.helper.ItemHelper;

@DisplayName("Test class to test Basket	")
class BasketTest {

	BasketImpl basket;
	LoadProperties loadProperties;
	CategoryHelper categoryHelper;
	ItemHelper itemHelper;
	ICategoryGenerator categoryGenerator;
	Double budget;

	@BeforeEach
	void setUp() throws Exception {
		loadProperties = new LoadProperties();
		categoryHelper = new CategoryHelper();
		itemHelper = new ItemHelper();
		budget = loadProperties.getBudget();
		categoryGenerator = new CategoryGeneratorImpl(this.categoryHelper, this.itemHelper);
		basket = new BasketImpl(categoryHelper, itemHelper, loadProperties, categoryGenerator);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("to test pickItems	")
	void testPickItems() {
		basket.setCategories();
		basket.pickItems();
		Double cost = basket.getCost();
		assertTrue(cost <= budget);

	}

	@Test
	@DisplayName("to test getCategories	")
	void testGetItems() {
		basket.setCategories();
		List<Category> categories = basket.getCategories();
		assertEquals(20, categories.size(), "testFillItems failed");

	}

}
