package test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.test.model.Product;

public class OrderTest {
	@Test
	public void testPremium() {
		TestUtil tu = new TestUtil();
		tu.load();
		String url="apple.com.au";
		Product p = tu.getPremiumProduct(url);
		assertNotNull(p);
    }
	
	@Test
	public void testNormal(){
		TestUtil tu = new TestUtil();
		tu.load();
		String url=".com.au";
		Product p = tu.getProduct(url);
		assertNotNull(p);
		url=".net";p=null;
		p = tu.getProduct(url);
		assertNotNull(p);
		url="asdf";p=null;
		p = tu.getProduct(url);
		assertNull(p);
	}
}
