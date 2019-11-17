package com.retail.billingsystem.services;

import java.util.List;

import com.retail.billingsystem.helper.Consumer;
import com.retail.billingsystem.helper.ConsumerType;
import com.retail.billingsystem.helper.Item;

/**
 * The Class BillCalculatorServiceImpl.
 */
public class BillCalculatorServiceImpl implements BillCalculatorService {

	/** The Constant DISCOUNT_PER_HUNDRED. */
	private static final int DISCOUNT_PER_HUNDRED = 5;
	
	/** The total discounted price. */
	private double totalDiscountedPrice = 0;
	
	/* 
	 * 
	 * @see com.retail.billingsystem.services.BillCalculatorService#calculateTotalPayableAmount(com.retail.billingsystem.helper.Consumer, java.util.List)
	 */
	public double calculateTotalPayableAmount(Consumer customer, List<Item> items) {
		
		double discountPercentage = getDiscountPercentageForCustomer(customer);
		items.stream().forEach(dt->{
			totalDiscountedPrice = totalDiscountedPrice + dt.getDiscountedPrice(discountPercentage);
		});
		 
		return Math.round(totalDiscountedPrice - getDiscountBasedOnTotalAmount(totalDiscountedPrice));
	}


	/**
	 * Gets the discount percentage for customer.
	 *
	 * @param consumer the consumer
	 * @return the discount percentage for customer
	 */
	private double getDiscountPercentageForCustomer(Consumer consumer) {
		ConsumerType consumerType = consumer.getConsumerType();
		if(consumerType == ConsumerType.AFFILIATE || consumerType == ConsumerType.EMPLOYEE || consumer.isAvailableForLoyaltyDiscount()) {
			return consumerType.getDiscountPercentage();
		}
		return 0;
	}
	
	/**
	 * Gets the discount based on total amount.
	 *
	 * @param totalDiscountedPrice the total discounted price
	 * @return the discount based on total amount
	 */
	private double getDiscountBasedOnTotalAmount(double totalDiscountedPrice) {
		return Math.floor(totalDiscountedPrice / 100) * DISCOUNT_PER_HUNDRED;
	}
}
