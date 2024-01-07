package com.core.javapitfalls.book;

import java.math.BigDecimal;

public class TimeForaChange {
	
	public static void main(String[] args) {
		System.out.println(2.00 - 1.10);		
		System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.10")));		
	}
	
}
