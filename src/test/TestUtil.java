package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

import com.test.model.Product;
import com.test.utils.ProductList;

public class TestUtil {
	public Hashtable<String, Product> productList = new Hashtable<String, Product>();
	public Hashtable<String, Product> premiumProductList = new Hashtable<String, Product>();
	
	public Product getPremiumProduct(String urlName){
		Product p = null;
		if(urlName !=null && premiumProductList.containsKey(urlName)){
			p = premiumProductList.get(urlName);
		}
		return p;
	}
	
	public Product getProduct(String urlName){
		Product p = null;
		if(urlName !=null && productList.containsKey(urlName)){
			p = productList.get(urlName);
		}
		return p;
	}
	
	public void load(){
		try{
			String filePath = "WebContent/WEB-INF/premiumPriceList.txt";
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
				this.premiumProductList.put(data[0],new Product(data[0],data[1]));
			}
		}catch(IOException e){
			System.out.println("Cannot load premium price list. file not found.");
		}
		//load normal domains
		try{
			String filePath = "WebContent/WEB-INF/priceList.txt";
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
				this.productList.put(data[0],new Product(data[0],data[1]));
			}
		}catch(IOException e){
			System.out.println("Cannot load price list. file not found.");
		}
	}
}
