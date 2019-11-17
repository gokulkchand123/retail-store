package com.retail.billingsystem.helper;


/**
 * The Class Item.
 */
public class Item {
	
	/** The product. */
	private Product product;
	
	/** The quantity. */
	private int quantity;
	
	/** The total cost. */
	private double totalCost;
	
	/**
	 * Instantiates a new item.
	 *
	 * @param product the product
	 * @param quantity the quantity
	 */
	public Item(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.totalCost = product.getPrice() * quantity;
	}

	/**
	 * Gets the product.
	 *
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * Gets the total cost.
	 *
	 * @return the total cost
	 */
	public double getTotalCost(){
		return totalCost; 
	}

	/**
	 * Gets the discounted price.
	 *
	 * @param discountPercentage the discount percentage
	 * @return the discounted price
	 */
	public double getDiscountedPrice(double discountPercentage) {
		if(product.isDiscountable() && discountPercentage != 0 ) {
			return (totalCost - totalCost * discountPercentage/100);
		}
		return totalCost;
	}

}
