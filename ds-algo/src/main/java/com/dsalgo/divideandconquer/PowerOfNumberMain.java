package com.dsalgo.divideandconquer;

import lombok.extern.slf4j.Slf4j;

/**
 * Problem: Calculate x raised to the power n (x^n) using Divide and Conquer
 * 
 * Interview Question: Implement pow(x, n) which calculates x raised to the power n
 * 
 * Approach:
 * - Divide: Split the problem into smaller subproblems
 * - Conquer: Solve the subproblems recursively
 * - Combine: Combine the results
 * 
 * Key Insight: x^n = x^(n/2) * x^(n/2) if n is even
 *              x^n = x^(n/2) * x^(n/2) * x if n is odd
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(log n) due to recursion stack
 * 
 * @author srayabar
 */
@Slf4j
public class PowerOfNumberMain {
    
    public static void main(String[] args) {
        // Test cases
        log.info("2^10 = {}", power(2, 10));
        log.info("3^5 = {}", power(3, 5));
        log.info("2^-3 = {}", power(2, -3));
        log.info("5^0 = {}", power(5, 0));
        
        // Edge cases
        log.info("0^5 = {}", power(0, 5));
        log.info("1^100 = {}", power(1, 100));
    }
    
    /**
     * Calculate x raised to the power n using divide and conquer
     * 
     * @param x base
     * @param n exponent
     * @return x^n
     */
    public static double power(double x, int n) {
        // Handle negative exponent
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        
        return powerHelper(x, n);
    }
    
    /**
     * Helper method for recursive calculation
     */
    private static double powerHelper(double x, int n) {
        // Base case
        if (n == 0) {
            return 1.0;
        }
        
        // Divide: Calculate x^(n/2)
        double half = powerHelper(x, n / 2);
        
        // Conquer and Combine
        if (n % 2 == 0) {
            // If n is even: x^n = (x^(n/2))^2
            return half * half;
        } else {
            // If n is odd: x^n = (x^(n/2))^2 * x
            return half * half * x;
        }
    }
    
    /**
     * Iterative version (more space efficient)
     * Time: O(log n), Space: O(1)
     */
    public static double powerIterative(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        
        double result = 1.0;
        double currentProduct = x;
        
        while (n > 0) {
            if (n % 2 == 1) {
                result *= currentProduct;
            }
            currentProduct *= currentProduct;
            n /= 2;
        }
        
        return result;
    }
}

