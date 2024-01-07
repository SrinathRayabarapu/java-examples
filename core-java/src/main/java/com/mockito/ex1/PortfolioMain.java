package com.mockito.ex1;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * demo portfolio class to implement mockito capabilities 
 * 
 * @author Srinath.Rayabarapu
 *
 */
public class PortfolioMain {
	
	Portfolio portfolio;
	StockService stockService;

	public static void main(String[] args) {
		PortfolioMain tester = new PortfolioMain();
		tester.setup();
		//log.debug(tester.testMarketValue() ? "Pass" : "Fail");
		System.out.println(tester.testMarketValue() ? "Pass" : "Fail");
	}

	private void setup() {
		// Create a portfolio object which is to be tested
		this.portfolio = new Portfolio();
		this.stockService = mock(StockService.class);
		this.portfolio.setStockService(this.stockService);
	}

	private boolean testMarketValue() {
		// Creates a list of stocks to be added to the portfolio
		List<Stock> stocks = new ArrayList<>();
		Stock googleStock = new Stock("1", "Google", 10);
		Stock microsoftStock = new Stock("2", "Microsoft", 100);

		stocks.add(googleStock);
		stocks.add(microsoftStock);

		// add stocks to the portfolio
		this.portfolio.setStocks(stocks);
		
		//stubbing the data
		when(this.stockService.getPrice(googleStock)).thenReturn(50.00);
		when(this.stockService.getPrice(microsoftStock)).thenReturn(1000.00);
		
		double marketValue = this.portfolio.getMarketValue();
		
		return marketValue == 100500.0;
	}
}