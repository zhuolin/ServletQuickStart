package com.test.model;

public class PremiumProduct extends Product{

	public PremiumProduct(String pName, String pPrice) {
		super(pName, pPrice);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isPremiumProdcut(){
		return true;
	}
}
