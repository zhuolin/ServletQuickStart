package com.test.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.http.HttpServlet;

import com.test.model.Product;

public class AppInit extends HttpServlet{
	
	
	
	public void init(){
		//load premium domains
		try{
			String filePath = getServletContext().getRealPath("/") + "WEB-INF/premiumPriceList.txt";
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line = null;
			String data[] = null;
			while((line=br.readLine())!=null){
				if("name~yearprice".equalsIgnoreCase(line)){
					//read the file title
					continue;
				}
				data = line.split("~");
				if(data.length!=2){
					//bad data
					continue;
				}
				ProductList.premiumProductList.put(data[0],new Product(data[0],data[1]));
			}
		}catch(IOException e){
			System.out.println("Cannot load premium price list. file not found.");
		}
		//load normal domains
		try{
			String filePath = getServletContext().getRealPath("/") + "WEB-INF/priceList.txt";
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line = null;
			String data[] = null;
			ProductList.productList.put("Unknown",new Product("Unknown","0"));
			while((line=br.readLine())!=null){
				if("name~yearprice".equalsIgnoreCase(line)){
					//read the file title
					continue;
				}
				data = line.split("~");
				if(data.length!=2){
					//bad data
					continue;
				}
				ProductList.productList.put(data[0],new Product(data[0],data[1]));
			}
		}catch(IOException e){
			System.out.println("Cannot load price list. file not found.");
		}
		System.out.println("Premium products loaded:"+ProductList.premiumProductList.size());
		System.out.println("Normal products loaded:"+ProductList.productList.size());
	}

}
