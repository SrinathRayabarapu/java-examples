package com.mockito.ex1;

import java.util.List;

/**
 * Portfolio class to set Stocks and has a method to calculate it's value
 * 
 * @author Srinath.Rayabarapu
 *
 */
public class Portfolio {
	
	private StockService stockService;
	private List<Stock> stocks;

	public StockService getStockService() {
		return this.stockService;
	}

	public void setStockService(StockService stockService) {
		this.stockService = stockService;
	}

	public List<Stock> getStocks() {
		return this.stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public double getMarketValue() {
		double marketValue = 0.0;
		
		for (Stock stock : this.stocks) {
			marketValue += this.stockService.getPrice(stock) * stock.getQuantity();
		}
		return marketValue;
	}
}