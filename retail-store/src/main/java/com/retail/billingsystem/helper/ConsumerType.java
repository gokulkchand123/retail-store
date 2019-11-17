package com.retail.billingsystem.helper;

/**
 * The Enum ConsumerType.
 */
public enum ConsumerType {
	
	/** The affiliate. */
	AFFILIATE(10),
	
	/** The employee. */
	EMPLOYEE(30),
	
	/** The consumer. */
	CONSUMER(5);
	
	/** The discount percentage. */
	private double discountPercentage;
	
	/**
	 * Instantiates a new consumer type.
	 *
	 * @param discountPercentage the discount percentage
	 */
	ConsumerType(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	
	/**
	 * Gets the discount percentage.
	 *
	 * @return the discount percentage
	 */
	public double getDiscountPercentage() {
		return discountPercentage;
	}

}
