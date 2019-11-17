package com.retail.billingsystem.helper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.retail.billing.input.BillingInput;
import com.retail.billingsystem.helper.Item;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ItemTest {
	
	
	@Test
	public void shouldGetNoDiscountForNonDiscountableProduct() {
		Product product = BillingInput.getNonDiscountableProduct();
		Item item = new Item(product, 4);
		Assert.assertEquals(199.96, item.getDiscountedPrice(5), 0);
	}
	
	@Test
	public void shouldGetDiscountedPriceForDiscountableProduct() {
		Product product = BillingInput.getDiscountableProduct();
		Item item = new Item(product, 4);
		Assert.assertEquals(220.36, item.getDiscountedPrice(5), 0.1);
	}
	
	@Test
	public void shouldGetNoDiscountForZeroDiscountPercentage() {
		Product product = BillingInput.getDiscountableProduct();
		Item item = new Item(product, 4);
		Assert.assertEquals(231.96, item.getDiscountedPrice(0), 0);
		
	}

}
