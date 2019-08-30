package com.challenge.basket.helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.challenge.basket.Item;

public class ItemHelper {

	public List<Item> creatItems(Integer size, Double minPrice, Double maxPrice, Double minShipping, Double maxShipping,
			Integer minRating, Integer maxRating) {
		List<Item> items = new ArrayList<Item>(size);
		for (int i = 0; i < size; i++) {
			Item item = new Item();
			item.setName("Item" + i);
			item = populateItem(item, minPrice, maxPrice, minShipping, maxShipping, minRating, maxRating);
			items.add(item);
		}
		return items;
	}

	private Item populateItem(Item item, Double minPrice, Double maxPrice, Double minShipping, Double maxShipping,
			Integer minRating, Integer maxRating) {
		// item.setCategory(category);
		item.setPrice(setPrice(minPrice, maxPrice));
		item.setRating(setRating(minRating, maxRating));
		item.setShippingPrice(setPrice(minShipping, maxShipping));
		return item;
	}

	public Double setPrice(Double givenMinPrice, Double givenMaxPrice) {
		Random randomPrice = new Random();
		//Double price = randomPrice.nextDouble() * givenMaxPrice + givenMinPrice;
		//rangeMin + (rangeMax - rangeMin) * r.nextDouble();
		Double price = randomPrice.nextDouble() * (givenMaxPrice - givenMinPrice) + givenMinPrice;
		
		return price;
	}

	public Integer setRating(int minRating, int maxRating) {
		Random randomRating = new Random();
		Integer rating = randomRating.nextInt(maxRating) + minRating;
		return rating;
	}

}
