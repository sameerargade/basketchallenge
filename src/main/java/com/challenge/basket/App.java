package com.challenge.basket;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.challenge.basket.config.LoadProperties;
import com.challenge.basket.helper.CategoryHelper;
import com.challenge.basket.helper.ItemHelper;

public class App {
	CategoryHelper categoryHelper;
	ItemHelper itemHelper;
	LoadProperties properties;
	List<Category> categories;
	Map<String, Item> basket;
	Double cost = 0.0;
	Double budget = 0.0;

	App() {
		categoryHelper = new CategoryHelper();
		itemHelper = new ItemHelper();
		properties = new LoadProperties();
		budget = properties.getBudget();
	}

	public void generateCategories() {
		categories = categoryHelper.createCategoryList(properties.getNoOfCategories());// new ArrayList<Category>();
		for (Category category : categories) {
			category.setItems(itemHelper.creatItems(properties.getNoOfItemsPerCategory(), properties.getMinPrice(),
					properties.getMaxPrice(), properties.getMinShippingPrice(), properties.getMaxShippingPrice(),
					properties.getMinRating(), properties.getMaxRating()));
		}

	}

	public void pickItems() {
		basket = new HashMap<String, Item>();

		if (basket.values().isEmpty()) {
			pickRandomSingleItem();
		}

		while (cost <= budget - properties.getMinPrice() - properties.getMinShippingPrice()) {
			pickRandomSingleItem();
		}
	}

	public double calculateTotalCost(Collection<Item> items) {
		Double sum = 0.0;
		for (Item item : items) {
			sum = sum + item.getPrice() + item.getShippingPrice();
		}
		return sum;
	}

	public Integer calculateTotalRating(Collection<Item> items) {
		Integer sumOfRating = 0;
		for (Item item : items) {
			sumOfRating = sumOfRating + item.getRating();
		}
		return sumOfRating;
	}

	public void printBasket() {

		basket.forEach((key, value) -> {
			System.out.println(key + ":" + value);
		});
		System.out.println("Total cost " + calculateTotalCost(basket.values()));
		System.out.println("Total rating " + calculateTotalRating(basket.values()));

	}

	private void pickRandomSingleItem() {
		Collections.shuffle(categories);

		Category singleRandomCategory = categories.get(0);
		List<Item> allItems = singleRandomCategory.getItems();
		Collections.shuffle(allItems);
		Item singleItem = allItems.get(0);
		if (!basket.values().isEmpty()) {
			cost = calculateTotalCost(basket.values());
			System.out.println(cost);
			System.out.println(singleItem.getPrice() + " - " + singleItem.getShippingPrice());
			if (cost >= budget - singleItem.getPrice() - singleItem.getShippingPrice()) {
				return;
			}
		}
		basket.put(singleRandomCategory.getName(), singleItem);

	}

	public static void main(String args[]) {
		App app = new App();
		app.generateCategories();
		app.pickItems();
		app.printBasket();
	}

}
