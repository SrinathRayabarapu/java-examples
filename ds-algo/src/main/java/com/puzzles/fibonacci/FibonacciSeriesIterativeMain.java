package com.puzzles.fibonacci;

import java.math.BigInteger;

/**
 * Print Fibinocci series example with simple loop - no recursion!
 * 
 * Fibinocci series : 1 1 2 3 5 8 13 21 34 55...
 * 
 * @author Srinath.Rayabarapu
 */
public class FibonacciSeriesIterativeMain {
	
	public static void main(String[] args) {
		for(int i=1; i<=15; i++){
			System.out.print(fibinocciNumberWithIteration(i)+" ");
		}
	}

	public static BigInteger fibinocciNumberWithIteration(int num) {

		if(num <= 2){
			return BigInteger.ONE;
		}

		BigInteger temp1 = BigInteger.ONE, temp2 = BigInteger.ONE;
		BigInteger fibinocci = BigInteger.ZERO;
		for(int i=3; i<=num; i++){
			fibinocci = temp1.add(temp2);
			temp1 = temp2;
			temp2 = fibinocci;
		}
		return fibinocci;
	}
	
}