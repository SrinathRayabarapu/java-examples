package com.core.java8;

public class FormulaImplMain implements Formula, FormulaOne { //when two interfaces has same default method,
	//concrete class must implement that method

	@Override
	public double calculate(int a) {
		return 0;
	}

	/**
	 * this is not implementation - rather deciding which of above interfaces default method should be called!
	 *
	 * @param a
	 * @return
	 */
	@Override
	public double sqrt(int a) {
		return FormulaOne.super.sqrt(a);
	}
	
	public static void main(String[] args) {
		System.out.println("Square root of 9 - " + new FormulaImplMain().sqrt(9));
	}
	
}