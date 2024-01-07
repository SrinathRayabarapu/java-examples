package com.core.java8;

public interface FormulaOne {
	
	double calculate(int a);
	
	default double sqrt(int a){
		System.out.println("FormulaOne sqrt");
		return Math.sqrt(a);
	}

}
