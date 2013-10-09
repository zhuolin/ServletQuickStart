package test;

import org.junit.Test;

import com.test.model.Product;

import static org.junit.Assert.assertEquals;

public class productTest{
	@Test
    public void testAdd() {
		String name="test";
		String price = "12.2";
		Product p = new Product(name, price);
		assertEquals(p.getName(),name);
		assertEquals(p.getPrice().toString(),price);
		
    }
}
