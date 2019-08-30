package com.challenge.basket.helper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.challenge.basket.Item;

class ItemHelperTest {
	ItemHelper helper;
	Double maxPrice;
	Double minPrice;
	Double maxShippingPrice;
	Double minShippingPrice;
	Integer minRating;
	Integer maxRating;
	Integer size;

	@BeforeEach
	void setUp() throws Exception {
		helper = new ItemHelper();
		maxPrice = 20.0;
		minPrice = 1.0;
		maxShippingPrice = 5.0;
		minShippingPrice = 2.0;
		minRating = 1;
		maxRating = 5;
		size = 10;
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("to test setPrice	")
	void testSetPrice() {
		Double price = helper.setPrice(1.0, 20.0);
		 assertTrue( maxPrice >= price);
		  assertTrue( minPrice  <= price);
	}
	@Test
	@DisplayName("to test setPrice for shipping	")
	void testShippingPrice() {
		Double price = helper.setPrice(minShippingPrice, maxShippingPrice);
		 assertTrue( maxShippingPrice >= price);
		  assertTrue( minShippingPrice  <= price);
	}
	@Test
	@DisplayName("to test set rating	")
	void testSetRating() {
		Integer rating = helper.setRating(minRating, maxRating);
		 assertTrue( maxRating >= rating);
		  assertTrue( minRating  <= rating);
	}
	
	@Test
	@DisplayName("to test CreateItems")
	void testCreateItems() {
		List<Item> items = helper.creatItems(size, minPrice, maxPrice, minShippingPrice, maxShippingPrice, minRating, maxRating);
		assertEquals(Integer.valueOf(size), Integer.valueOf(items.size()) ,"testCreateItems failed");
	}

}
