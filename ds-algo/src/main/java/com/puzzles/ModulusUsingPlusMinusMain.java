package com.puzzles;

/**
 * Finding modulo using +/- only
 *
 * a)x(b
 * 	----
 * 	 c
 * 
 * a - divisor
 * x - dividend
 * b - quotient
 * c - remainder
 * 
 * Modulo is % = calculating remainder
 * 
 * @author Srinath.Rayabarapu
 */
public class ModulusUsingPlusMinusMain {
	
	public static void main(String[] args) {
		int a = 17, b = 6;
		//while b is less than (a-b)
		while(b<(a-b)){
			a = a - b;
		}
		System.out.println(a-b);
	}
}