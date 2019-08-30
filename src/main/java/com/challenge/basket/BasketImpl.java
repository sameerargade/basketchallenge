package com.challenge.basket;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.challenge.basket.config.LoadProperties;
import com.challenge.basket.helper.CategoryHelper;
import com.challenge.basket.helper.ItemHelper;

public class BasketImpl implements IBasket {
	private CategoryHelper categoryHelper;
	private ItemHelper itemHelper;
	private ICategoryGenerator categoryGenerator;
	private LoadProperties properties;
	private List<Category> categories;
	private Map<String, Item> basket;
	private Double cost = 0.0;
	private Double budget = 0.0;

	BasketImpl() {
		basket = new HashMap<String, Item>();
		categoryHelper = new CategoryHelper();
		itemHelper = new ItemHelper();
		properties = new LoadProperties();
		budget = properties.getBudget();
		categoryGenerator = new CategoryGeneratorImpl(this.categoryHelper,this.itemHelper);
	}
	BasketImpl(CategoryHelper categoryHelper,ItemHelper itemHelper,LoadProperties properties,ICategoryGenerator categoryGenerator) {
		basket = new HashMap<String, Item>();
		this.categoryHelper = categoryHelper;
		this.itemHelper = itemHelper;
		this.properties = properties;
		this.budget = properties.getBudget();
		this.categoryGenerator = categoryGenerator;
	}

	public void setCategories() {
		categories = categoryGenerator.generateCategories( properties);
	}

	public void pickItems() {
		

		if (basket.values().isEmpty()) {
			pickRandomSingleItem();
		}

		while (cost <= (budget - properties.getMinPrice() - properties.getMinShippingPrice()) ) {
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
			
			Double newCost = cost+ singleItem.getPrice() + singleItem.getShippingPrice();
			
			if(Math.round(newCost) > budget) {
				return;
			}

		}
		basket.put(singleRandomCategory.getName(), singleItem);
		

	}
	public Map<String, Item> getBasket() {
		return basket;
	}
	public void setBasket(Map<String, Item> basket) {
		this.basket = basket;
	}

	public static void main(String args[]) {
		IBasket basket = new BasketImpl();
		basket.setCategories();
		basket.pickItems();
		basket.printBasket();
	}
	public List<Category> getCategories() {
		return categories;
	}
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	

}
