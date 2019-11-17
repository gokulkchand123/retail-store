package com.retail.billing.input;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;

import com.retail.billingsystem.helper.Consumer;
import com.retail.billingsystem.helper.ConsumerType;
import com.retail.billingsystem.helper.Item;
import com.retail.billingsystem.helper.Product;

/**
 * The Class BillingInput.
 */
public class BillingInput {
	
	/** The Constant CONSUMER_LOYALTY_TIME_PERIOD_IN_YRS. */
	private static final int CONSUMER_LOYALTY_TIME_PERIOD_IN_YRS = 2;
	
	/**
	 * Gets the discountable product.
	 *
	 * @return the discountable product
	 */
	public static Product getDiscountableProduct() {
		Product product = new Product();
		product.setSku("TR1234123");
		product.setName("Wallsticker");
		product.setDiscountable(Boolean.TRUE);
		product.setPrice(57.99);
		
		return product;
	}
	
	/**
	 * Gets the non discountable product.
	 *
	 * @return the non discountable product
	 */
	public static Product getNonDiscountableProduct() {
		Product product = new Product();
		product.setSku("TR645252");
		product.setName("maggie");
		product.setDiscountable(Boolean.FALSE);
		product.setPrice(49.99);
		
		return product;
	}
	
	/**
	 * Gets the consumer with more than two year old.
	 *
	 * @return the consumer with more than two year old
	 */
	public static Consumer getConsumerWithMoreThanTwoYearOld() {
		Consumer customer = new Consumer(ConsumerType.CONSUMER, "customer300", "Krish", new DateTime().minusYears(CONSUMER_LOYALTY_TIME_PERIOD_IN_YRS).minusDays(1));
		return customer;
	}
	
	/**
	 * Gets the consumer with less than two year old.
	 *
	 * @return the consumer with less than two year old
	 */
	public static Consumer getConsumerWithLessThanTwoYearOld() {
		Consumer customer = new Consumer(ConsumerType.CONSUMER, "customer400", "Arun", new DateTime().minusYears(CONSUMER_LOYALTY_TIME_PERIOD_IN_YRS).plusDays(1));
		return customer;
	}
	
	/**
	 * Gets the affiliate consumer.
	 *
	 * @return the affiliate consumer
	 */
	public static Consumer getAffiliateConsumer() {
		Consumer customer = new Consumer(ConsumerType.AFFILIATE, "customer100", "ABC Affiliate", new DateTime().minusYears(3));
		return customer;
	}
	
	/**
	 * Gets the employee consumer.
	 *
	 * @return the employee consumer
	 */
	public static Consumer getEmployeeConsumer() {
		Consumer customer = new Consumer(ConsumerType.EMPLOYEE, "customer200", "Gokul", new DateTime().minusYears(3));
		return customer;
	}
	
	
	
	/**
	 * Gets the discountable product.
	 *
	 * @param quantity the quantity
	 * @return the discountable product
	 */
	public static Item getDiscountableProduct(int quantity) {
		return new Item(getDiscountableProduct(), quantity);
	}
	
	/**
	 * Gets the non discountable product.
	 *
	 * @param quantity the quantity
	 * @return the non discountable product
	 */
	public static Item getNonDiscountableProduct(int quantity) {
		return new Item(getNonDiscountableProduct(), quantity);
	}
	
	/**
	 * Gets the item list with multiple products.
	 *
	 * @return the item list with multiple products
	 */
	public static List<Item> getItemListWithMultipleProducts() {
		List<Item> items = new ArrayList<Item>();
		items.add(getDiscountableProduct(10));
		items.add(getNonDiscountableProduct(5));
		return items;
	}
}
