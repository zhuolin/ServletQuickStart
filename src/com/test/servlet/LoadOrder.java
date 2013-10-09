package com.test.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.test.model.OrderItem;
import com.test.model.Product;
import com.test.utils.ProductList;

public class LoadOrder extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String message = "";
		String domain;
		int orderYear;
		String[] domains = request.getParameterValues("domain");
		String[] orderYears = request.getParameterValues("year");
		ArrayList<OrderItem> order = new ArrayList<OrderItem>();
		if(domains==null || domains.length==0){
			message="No inputs.";
		}else{
			for(int i=0;i<domains.length;i++){
				domain = domains[i];
				try{
					orderYear = Integer.parseInt(orderYears[i]);
				}catch (Exception e) {
					orderYear = 0;
				}
				if(ProductList.getPremiumProduct(domain)!=null){
					order.add(new OrderItem(ProductList.getPremiumProduct(domain),orderYear,domain));
				}else{
					if(ProductList.getProduct(getDomainZone(domain))!=null){
						order.add(new OrderItem(ProductList.getProduct(getDomainZone(domain)),orderYear,domain));
					}else{
						order.add(new OrderItem(new Product("invalid","0"),orderYear,domain+"-invalid"));
					}
				}
				message = order.size()+" result(s) found.";
			}
		}
		float orderTotal = 0;
		for(int i=0;i<order.size();i++){
			orderTotal += Float.parseFloat(order.get(i).getTotal());
		}
		request.setAttribute("results", order);
		request.setAttribute("message", message);
		request.setAttribute("ordertotal", String.valueOf(orderTotal));
        try {
			request.getRequestDispatcher("/quote.jsp").forward(request, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
	}
	
	public String getDomainZone(String domain){
		if(domain==null || domain.length()==0){
			return null;
		}
		String[] x = domain.split("\\.");
		int spot = x.length;
		if("au".equalsIgnoreCase(x[spot-1])){
			return "."+x[spot-2]+"."+x[spot-1];
		}else{
			return "."+x[spot-1];
		}
	}

}
