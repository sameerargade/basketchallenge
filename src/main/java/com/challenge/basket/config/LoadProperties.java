package com.challenge.basket.config;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class LoadProperties {
	ResourceBundle resourceBundle;// = ResourceBundle.getBundle("application");
	Integer noOfCategories;
	Integer noOfItemsPerCategory;
	Integer minRating;
	Integer maxRating;
	Double minPrice;
	Double maxPrice;
	Double minShippingPrice;
	Double maxShippingPrice;
	Integer optimizedRating;
	Double budget;

	public Integer getNoOfCategories() {
		return noOfCategories;
	}

	public void setNoOfCategories(Integer noOfCategories) {
		this.noOfCategories = noOfCategories;
	}

	public Integer getNoOfItemsPerCategory() {
		return noOfItemsPerCategory;
	}

	public void setNoOfItemsPerCategory(Integer noOfItemsPerCategory) {
		this.noOfItemsPerCategory = noOfItemsPerCategory;
	}

	public Integer getMinRating() {
		return minRating;
	}

	public void setMinRating(Integer minRating) {
		this.minRating = minRating;
	}

	public Integer getMaxRating() {
		return maxRating;
	}

	public void setMaxRating(Integer maxRating) {
		this.maxRating = maxRating;
	}

	public Double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}

	public Double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Double getMinShippingPrice() {
		return minShippingPrice;
	}

	public void setMinShippingPrice(Double minShippingPrice) {
		this.minShippingPrice = minShippingPrice;
	}

	public Double getMaxShippingPrice() {
		return maxShippingPrice;
	}

	public void setMaxShippingPrice(Double maxShippingPrice) {
		this.maxShippingPrice = maxShippingPrice;
	}

	public Integer getOptimizedRating() {
		return optimizedRating;
	}

	public void setOptimizedRating(Integer optimizedRating) {
		this.optimizedRating = optimizedRating;
	}

	public LoadProperties() {
		// TODO Auto-generated constructor stub
		resourceBundle = ResourceBundle.getBundle("application");
		Enumeration<String> keys = resourceBundle.getKeys();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
//			 String value = resourceBundle.getString(key);
//			 System.out.println(key + ": " + value);
			switch (key) {
			case "noOfCategories":
				
				this.noOfCategories =  parseIntegerValue(key);
				//System.out.println(key + ": " + this.noOfCategories);
				break;
			case "noOfItemsPerCategory":
				this.noOfItemsPerCategory = parseIntegerValue(key);
				break;
			case "minRating":
				this.minRating = parseIntegerValue(key);
				break;
			case "maxRating":
				this.maxRating = parseIntegerValue(key);
				break;
			case "minPrice":
				this.minPrice = parseDoubleValue(key);
				break;
			case "maxPrice":
				this.maxPrice = parseDoubleValue(key);
				break;
			case "minShippingPrice":
				this.minShippingPrice = parseDoubleValue(key);
				break;
			case "maxShippingPrice":
				this.maxShippingPrice = parseDoubleValue(key);
				break;
			case "optimizedRating":
				this.optimizedRating = parseIntegerValue(key);
				break;
			case "budget":
				this.budget = parseDoubleValue(key);
				break;
			}
		}

	}
	
	private Double parseDoubleValue(String key){
		return Double.parseDouble(resourceBundle.getString(key));
	}
	private Integer parseIntegerValue(String key){
		return	Integer.parseInt(resourceBundle.getString(key));
	}

	public Double getBudget() {
		return budget;
	}

	public void setBudget(Double budget) {
		this.budget = budget;
	}

//	Map<String, String> convertResourceBundleToMap(ResourceBundle resource) {
//		Map<String, String> map = new HashMap<String, String>();
//
//		Enumeration<String> keys = resource.getKeys();
//		while (keys.hasMoreElements()) {
//			String key = keys.nextElement();
//			map.put(key, resource.getString(key));
//		}
//
//		return map;
//	}

}
