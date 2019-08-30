package com.challenge.basket;

import java.util.Collection;

public interface IBasket {
	public void setCategories();
	public void pickItems() ;
	public double calculateTotalCost(Collection<Item> items);
	public Integer calculateTotalRating(Collection<Item> items);
	public void printBasket();
}
	