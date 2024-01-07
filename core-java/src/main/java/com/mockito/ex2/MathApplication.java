package com.mockito.ex2;

/**
 * wrapper class for {@link CalculatorService} interface
 * 
 * @author srayabar
 *
 */
public class MathApplication {
	private CalculatorService calcService;

	public void setCalculatorService(CalculatorService calcService) {
		this.calcService = calcService;
	}

	public double add(double input1, double input2) {
		return this.calcService.add(input1, input2);
	}

	public double subtract(double input1, double input2) {
		return this.calcService.subtract(input1, input2);
	}

	public double multiply(double input1, double input2) {
		return this.calcService.multiply(input1, input2);
	}

	public double divide(double input1, double input2) {
		return this.calcService.divide(input1, input2);
	}
}