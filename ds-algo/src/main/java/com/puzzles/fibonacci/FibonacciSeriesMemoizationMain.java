package com.puzzles.fibonacci;

import java.math.BigInteger;
import java.time.Clock;
import java.util.HashMap;
import java.util.Map;

/**
 * program to calculate fibonacci series using memoization technique.
 *
 * Also compares different approaches
 * 
 * Fibinocci series : 1 1 2 3 5 8...
 *
 * TC: O(n)
 * SC: O(n)
 *
 * @author Srinath.Rayabarapu
 */
public class FibonacciSeriesMemoizationMain {

	public static void main(String[] args) {
		
		int input = 47;

		fibinocciNumberWithMemoization(input, new HashMap<>());

		compareDifferentFibinocciSerieses(input);
	}

	private static void compareDifferentFibinocciSerieses(int input) {
		Clock clock = Clock.systemDefaultZone();

		long startingTime = clock.millis();//equivalent to System.currentTimeMillis()
		BigInteger calculateCachedFibinocciNumber = fibinocciNumberWithMemoization(input, new HashMap<>());
		long endingTime = clock.millis();
		System.out.println("Memorization - Total time in millis : " + (endingTime-startingTime));
		System.out.println(calculateCachedFibinocciNumber);

		startingTime = clock.millis();
		calculateCachedFibinocciNumber = new FibonacciSeriesIterativeMain().fibinocciNumberWithIteration(input);
		endingTime = clock.millis();
		System.out.println("Simple Loop - Total time in millis : " + (endingTime-startingTime));
		System.out.println(calculateCachedFibinocciNumber);

		startingTime = clock.millis();
		calculateCachedFibinocciNumber = new FibonacciSeriesRecursionMain().fibinocciNumberWithRecursion(input);
		endingTime = clock.millis();
		System.out.println("Recursion - Total time in millis : " + (endingTime-startingTime));
		System.out.println(calculateCachedFibinocciNumber);
	}

	/**
	 * Memoization with HashMap - Used BigInteger for avoiding integer overflow
	 * 
	 * @param num
	 * @param cache
	 * @return
	 */
	public static BigInteger fibinocciNumberWithMemoization(int num, Map<Integer, BigInteger> cache) {
		
		if(cache.get(num) != null){
			return cache.get(num);
		}

		if(num <= 2) {
			return BigInteger.ONE;
		}

		cache.put(num, fibinocciNumberWithMemoization(num-1, cache).add(fibinocciNumberWithMemoization(num-2, cache)));
		
		return cache.get(num);
	}
	
}