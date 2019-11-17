package com.retail.billingsystem.helper;

import org.joda.time.DateTime;

/**
 * The Class Consumer.
 */
public class Consumer {
	
	/** The Constant CONSUMER_LOYALTY_TIME_PERIOD_IN_YRS. */
	private static final int CONSUMER_LOYALTY_TIME_PERIOD_IN_YRS = 2;
	
	/** The consumer type. */
	private ConsumerType consumerType;
	
	/** The purchase id. */
	private String purchaseId;
	
	/** The customer name. */
	private String customerName;
	
	/** The registration date. */
	private DateTime registrationDate;
	
	/**
	 * Instantiates a new consumer.
	 *
	 * @param consumerType the consumer type
	 * @param purchaseId the purchase id
	 * @param customerName the customer name
	 * @param registrationDate the registration date
	 */
	public Consumer(ConsumerType consumerType, String purchaseId, String customerName, DateTime registrationDate) {
		super();
		this.consumerType = consumerType;
		this.purchaseId = purchaseId;
		this.customerName = customerName;
		this.registrationDate = registrationDate;
	}

	

	/**
	 * Gets the consumer type.
	 *
	 * @return the consumer type
	 */
	public ConsumerType getConsumerType() {
		return consumerType;
	}



	/**
	 * Gets the purchase id.
	 *
	 * @return the purchase id
	 */
	public String getPurchaseId() {
		return purchaseId;
	}



	/**
	 * Sets the purchase id.
	 *
	 * @param purchaseId the new purchase id
	 */
	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}



	/**
	 * Gets the customer name.
	 *
	 * @return the customer name
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * Gets the registration date.
	 *
	 * @return the registration date
	 */
	public DateTime getRegistrationDate() {
		return registrationDate;
	}
	
	/**
	 * Checks if is available for loyalty discount.
	 *
	 * @return true, if is available for loyalty discount
	 */
	public boolean isAvailableForLoyaltyDiscount() {
		DateTime dateToCompare = DateTime.now().minusYears(CONSUMER_LOYALTY_TIME_PERIOD_IN_YRS);
		return registrationDate.isBefore(dateToCompare) && (ConsumerType.CONSUMER == consumerType);
	}
}
