package com.retail.billingsystem.services;

import java.util.List;

import com.retail.billingsystem.helper.Consumer;
import com.retail.billingsystem.helper.Item;

/**
 * The Interface BillCalculatorService.
 */
public interface BillCalculatorService {
	
	/**
	 * Calculate total payable amount.
	 *
	 * @param customer the customer
	 * @param items the items
	 * @return the double
	 */
	double calculateTotalPayableAmount(Consumer customer, List<Item> items);

}
