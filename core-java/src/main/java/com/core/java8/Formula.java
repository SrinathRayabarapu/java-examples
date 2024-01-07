package com.core.java8;

public interface Formula {
	
	double calculate(int a);
	
	default double sqrt(int a){
		System.out.println("Interface sqrt");
		return Math.sqrt(a);
	}
}
