package com.test.utils;

import java.util.Hashtable;
import com.test.model.Product;

public class ProductList {
	public static Hashtable<String, Product> productList = new Hashtable<String, Product>();
	public static Hashtable<String, Product> premiumProductList = new Hashtable<String, Product>();
	
	public static Product getPremiumProduct(String urlName){
		Product p = null;
		if(urlName !=null && premiumProductList.containsKey(urlName)){
			p = premiumProductList.get(urlName);
		}
		return p;
	}
	
	public static Product getProduct(String urlName){
		Product p = null;
		if(urlName !=null && productList.containsKey(urlName)){
			p = productList.get(urlName);
		}
		return p;
	}
}
