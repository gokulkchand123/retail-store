package com.retail.billingsystem.helper;

/**
 * The Class Product.
 */
public class Product {
	
	/** The name. */
	private String name;
	
	/** The sku. */
	private String sku;
	
	/** The is discountable. */
	private boolean isDiscountable;
	
	/** The price. */
	private double price;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the sku.
	 *
	 * @return the sku
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * Sets the sku.
	 *
	 * @param sku the new sku
	 */
	public void setSku(String sku) {
		this.sku = sku;
	}

	/**
	 * Checks if is discountable.
	 *
	 * @return true, if is discountable
	 */
	public boolean isDiscountable() {
		return isDiscountable;
	}

	/**
	 * Sets the discountable.
	 *
	 * @param isDiscountable the new discountable
	 */
	public void setDiscountable(boolean isDiscountable) {
		this.isDiscountable = isDiscountable;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
}
