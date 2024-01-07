package com.dsalgo.primes;

import lombok.extern.slf4j.Slf4j;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * program to find whether a number is prime or not</br>
 * 
 * program to list all the prime numbers till the number passed</br>
 * 
 * logic : prime is a number which cann't have any dividable
 * 
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class PrimeNumberMain {
	
	public static void main(String[] args) {
		
		log.info("Using lambda's : ");
		log.info("4 is " + (isPrimeUsingLambdas(4) ? "prime" : "not prime"));
		log.info("5 is " + (isPrimeUsingLambdas(5) ? "prime" : "not prime"));
		log.info("9 is " + (isPrimeUsingLambdas(9) ? "prime" : "not prime"));
		log.info("17 is " + (isPrimeUsingLambdas(17) ? "prime" : "not prime"));
		log.info("27 is " + (isPrimeUsingLambdas(27) ? "prime" : "not prime"));
		log.info("91 is " + (isPrimeUsingLambdas(91) ? "prime" : "not prime"));

		log.info("Using normal logic :-- ");
		log.info("Checking whether a passed number is Prime or not");
		log.info("4 is " + (isPrime(4) ? "prime" : "not prime"));
		log.info("5 is " + (isPrime(5) ? "prime" : "not prime"));
		log.info("9 is " + (isPrime(9) ? "prime" : "not prime"));
		log.info("17 is " + (isPrime(17) ? "prime" : "not prime"));
		log.info("27 is " + (isPrime(27) ? "prime" : "not prime"));
		log.info("91 is " + (isPrime(91) ? "prime" : "not prime"));

		log.info("Listing all the Prime numbers till the input number:");
		printAllthePrimeNumbersIn(4);
		printAllthePrimeNumbersIn(17);
		printAllthePrimeNumbersIn(23);
	}
	
	private static void printAllthePrimeNumbersIn(int i) {
		
		//2 is prime
		if(i == 2)
			System.out.print(i + " ");
		
		for(int n=2; n<i; n++) {
			if(isPrime(n)) {
				System.out.print(n + " ");
			}
		}

	}

	/**
	 * normal way
	 * 
	 * @param n
	 * @return
	 */
	private static boolean isPrime(int n) {
		boolean isPrime = true;
		
		if(n == 2)
			return true;
		
		for(int i=2; i<= n/2; i++) { //checking till half is enough
			if(n % i == 0) {
				isPrime = false;
				break;
			}
		}
		
		return isPrime;
	}

	private static boolean isPrimeUsingLambdas(int number) {
		//with predicate
		IntPredicate isDivisible = divisor -> number % divisor == 0;		
		return number > 1 && IntStream.range(2, number).noneMatch(isDivisible);
	}
}