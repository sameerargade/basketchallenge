package com.challenge.basket;

public class Item {
	
	Double price;
	Double shippingPrice;
	Integer rating;
	String name;
	//Category category;
	
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getShippingPrice() {
		return shippingPrice;
	}
	public void setShippingPrice(Double shippingPrice) {
		this.shippingPrice = shippingPrice;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
//	public Category getCategory() {
//		return category;
//	}
//	public void setCategory(Category category) {
//		this.category = category;
//	}
	@Override
	public String toString() {
		return "Item [price=" + price + ", shippingPrice=" + shippingPrice + ", rating=" + rating + "]";
	}
//	 @Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((category == null) ? 0 : category.hashCode());
//		return result;
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Item other = (Item) obj;
//		if (category == null) {
//			if (other.category != null)
//				return false;
//		} else if (!category.equals(other.category))
//			return false;
//		return true;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
