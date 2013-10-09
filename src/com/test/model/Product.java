package com.test.model;

import java.math.BigDecimal;

public class Product {
	private String name;
	private BigDecimal price;
	
	public Product(String pName, String pPrice){
		try{
			BigDecimal x = new BigDecimal(pPrice);
			this.price=x;
		}catch(Exception e){
			this.price= new BigDecimal(0);
		}
		this.name=pName;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getPriceAsString(){
		return this.price.toString();
	}
	public double getPriceAsDouble(){
		return this.price.doubleValue();
	}
	public String getTotalPriceAsString(int years){
		if(years==0) return "0";
		return this.price.multiply(new BigDecimal(years)).toString();
	}
	public double getTotalPrice(int years){
		if(years==0) return 0;
		return this.price.multiply(new BigDecimal(years)).doubleValue();
	}
	
	public boolean isPremiumProdcut(){
		return false;
	}
}
