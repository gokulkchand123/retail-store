package com.retail.billingsystem.services;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.retail.billing.input.BillingInput;
import com.retail.billingsystem.helper.Consumer;
import com.retail.billingsystem.helper.Item;
import com.retail.billingsystem.services.BillCalculatorService;
import com.retail.billingsystem.services.BillCalculatorServiceImpl;

/*
 * Following is the goal of this program
 * 
 * On a retail website, the following discounts apply: 
 * 
 * 1. If the user is an employee of the store, he gets a 30% discount 
 * 2. If the user is an affiliate of the store, he gets a 10% discount 
 * 3. If the user has been a customer for over 2 years, he gets a 5% discount. 
 * 4. For every $100 on the bill, there would be a $ 5 discount (e.g. for $ 990, you get $ 45 as a discount). 
 * 5. The percentage based discounts do not apply on groceries. 
 * 6. A user can get only one of the percentage based discounts on a bill.  
 * 
 * 
 * 
 * Finds the net payable amount. 
 * 
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class BillCalculatorServiceImplTest {
	
	@Mock
	private BillCalculatorService billCalculatorService;
	private List<Item> items;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		billCalculatorService = new BillCalculatorServiceImpl();
		items = BillingInput.getItemListWithMultipleProducts();
	}
	
	//user has been a customer for over 2 years, he gets a 5% discount
	@Test
	public void shouldCalculateBillForDiscountEligibleCustomer() {
		Consumer customer = BillingInput.getConsumerWithMoreThanTwoYearOld();
		Assert.assertEquals(761.00, billCalculatorService.calculateTotalPayableAmount(customer, items), 0);
	}
	
	//user has not been a customer for over 2 years, he is not eligible for discounts
	@Test
	public void shouldCalculateBillForNonEligibleCustomer() {
		Consumer customer = BillingInput.getConsumerWithLessThanTwoYearOld();
		Assert.assertEquals(790.00, billCalculatorService.calculateTotalPayableAmount(customer, items), 0);
	}
	
	//user is an affiliate of the store, he gets a 10% discount
	@Test
	public void shouldCalculateBillforAffiliateCustomer() {
		Consumer affiliateCustomer = BillingInput.getAffiliateConsumer();
		Assert.assertEquals(737.00, billCalculatorService.calculateTotalPayableAmount(affiliateCustomer, items), 0);
	}
	
	//user is an employee of the store, he gets a 30% discount
	@Test
	public void shouldCalculateBillForEmployeeCustomer() {
		Consumer employeeCustomer = BillingInput.getEmployeeConsumer();
		Assert.assertEquals(626.00, billCalculatorService.calculateTotalPayableAmount(employeeCustomer, items), 0);
	}
}
