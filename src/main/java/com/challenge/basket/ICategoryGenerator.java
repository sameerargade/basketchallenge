package com.challenge.basket;

import java.util.List;

import com.challenge.basket.config.LoadProperties;

public interface ICategoryGenerator {
	public List<Category> generateCategories(LoadProperties properties);
}
