package com.puzzles;

import java.util.Stack;

/**
 * given a number, find largest prime which divides the number.
 *
 * @author Srinath.Rayabarapu
 */
public class LargestPrimeFactorMain {

    private static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {

        System.out.println(maxPrimeFactors(3));

    }

    // function to find largest prime factor
    static long maxPrimeFactors(int n) {
        // Initialize the maximum prime
        // factor variable with the
        // lowest one
        long maxPrime = -1;

        // Print the number of 2s
        // that divide n
        while (n % 2 == 0) {
            maxPrime = 2;

            // equivalent to n /= 2
            n >>= 1;
        }

        // n must be odd at this point,
        // thus skip the even numbers
        // and iterate only for odd
        // integers
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                maxPrime = i;
                n = n / i;
            }
        }

        // This condition is to handle
        // the case when n is a prime
        // number greater than 2
        if (n > 2)
            maxPrime = n;

        return maxPrime;
    }

}
