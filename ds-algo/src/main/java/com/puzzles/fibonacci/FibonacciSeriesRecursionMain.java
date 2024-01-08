package com.puzzles.fibonacci;

import java.math.BigInteger;

/**
 * given a number, print fibinocci series till the number index, using recursion.
 *
 * Fibinocci series: 1 1 2 3 5 8 13 21 34 55...
 *
 * TC: O(2^n)
 * SC: O(n)
 * https://www.youtube.com/watch?v=oBt53YbR9Kk
 *
 * @author Srinath.Rayabarapu
 */
public class FibonacciSeriesRecursionMain {
	
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++)
			System.out.println(fibinocciNumberWithRecursion(i));
	}
	
	public static BigInteger fibinocciNumberWithRecursion(int index) {
		if(index <= 2){
			return BigInteger.ONE;
		}
		return (fibinocciNumberWithRecursion(index-1).add(fibinocciNumberWithRecursion(index-2)));
	}
	
}