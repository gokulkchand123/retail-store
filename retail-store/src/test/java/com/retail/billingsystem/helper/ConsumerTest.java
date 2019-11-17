package com.retail.billingsystem.helper;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.retail.billing.input.BillingInput;
import com.retail.billingsystem.helper.Consumer;

@RunWith(MockitoJUnitRunner.class)
public class ConsumerTest {
	
	@Test
	public void shouldReturnTrueForMoreThanTwoYearOldRegistration() {
		Consumer customer = BillingInput.getConsumerWithMoreThanTwoYearOld();
		Assert.assertTrue(customer.isAvailableForLoyaltyDiscount());
	}
	
	@Test
	public void shouldReturnFalseForNonEmployee() {
		Consumer customer = BillingInput.getAffiliateConsumer();
		Assert.assertFalse(customer.isAvailableForLoyaltyDiscount());
	}
	
	@Test
	public void shouldReturnFalseForLessThanTwoYearOldRegistration() {
		Consumer customer = BillingInput.getConsumerWithLessThanTwoYearOld();
		Assert.assertFalse(customer.isAvailableForLoyaltyDiscount());
	}
}
