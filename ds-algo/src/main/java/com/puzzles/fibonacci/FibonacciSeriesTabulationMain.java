package com.puzzles.fibonacci;

import java.math.BigInteger;

/**
 * Print Fibinocci series example with simple loop - no recursion!
 * 
 * Fibinocci series : 1 1 2 3 5 8 13 21 34 55...
 * 
 * @author Srinath.Rayabarapu
 */
public class FibonacciSeriesTabulationMain {
	
	public static void main(String[] args) {
		for(int i=1; i<=15; i++){
			System.out.print(fibinocciNumberWithTabulation(i)+" ");
		}
	}

	public static BigInteger fibinocciNumberWithTabulation(int num) {

		if(num <= 2) {
			return BigInteger.ONE;
		}

		BigInteger prev2 = BigInteger.ONE, prev1 = BigInteger.ONE;
		BigInteger fibinocci = BigInteger.ZERO;
		for(int i=3; i<=num; i++){
			fibinocci = prev2.add(prev1);
			prev2 = prev1;
			prev1 = fibinocci;
			System.out.println(fibinocci);
		}
		return fibinocci;
	}
	
}