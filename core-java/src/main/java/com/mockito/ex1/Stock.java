package com.mockito.ex1;

/**
 * Stock class
 * 
 * @author Srinath.Rayabarapu
 *
 */
public class Stock {
	
	private String stockId;
	private String name;
	private int quantity;
	
	public Stock(String stockId, String name, int quantity) {
		this.stockId = stockId;
		this.name = name;
		this.quantity = quantity;
	}
	
	/**
	 * @return the stockId
	 */
	public String getStockId() {
		return stockId;
	}
	/**
	 * @param stockId the stockId to set
	 */
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}