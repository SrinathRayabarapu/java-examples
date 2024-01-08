package com.dsalgo.primes;

/**
 * Program to find a number Prime or not
 *
 * Idea: divide given number x from 2 to x/2.
 * If divided the reminder is 0 then it's not a prime number otherwise yes it is.
 * 
 * @author Srinath.Rayabarapu
 */
public class FindPrimeNumberMain {

	public static void main(String[] args) {

		int input = 23;
		boolean isPrime = true;
		
		for (int i = 2; i < input / 2; i++) {
			if (input % i == 0) {
				isPrime = false;
				System.out.println(input + " is NOT prime!");
				break;
			}
		}
		
		if (isPrime)
			System.out.println(input + " is prime");
	}
	
}