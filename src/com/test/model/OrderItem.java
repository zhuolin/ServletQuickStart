package com.test.model;

public class OrderItem {
	private Product product;
	private String url;
	private int years;
	private String total;
	
	public OrderItem(Product pProduct, int pYears){
		this.product = pProduct;
		this.years = pYears;
		this.total = this.product.getTotalPriceAsString(years);
	}
	
	public OrderItem(Product pProduct, int pYears, String pUrl){
		this.product = pProduct;
		this.years = pYears;
		this.url = pUrl;
		this.total = this.product.getTotalPriceAsString(years);
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
