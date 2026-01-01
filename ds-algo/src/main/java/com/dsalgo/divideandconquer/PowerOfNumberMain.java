package com.dsalgo.divideandconquer;

import lombok.extern.slf4j.Slf4j;

/**
 * Demonstrates the Power of a Number calculation using Divide and Conquer strategy.
 * 
 * <h3>Problem Statement:</h3>
 * <p>Implement pow(x, n) which calculates x raised to the power n (x^n).</p>
 * 
 * <h3>Divide and Conquer Approach:</h3>
 * <ol>
 *   <li><b>Divide</b>: Split the problem - calculate x^(n/2)</li>
 *   <li><b>Conquer</b>: Recursively solve the smaller subproblems</li>
 *   <li><b>Combine</b>: Combine results based on whether n is even or odd</li>
 * </ol>
 * 
 * <h3>Key Mathematical Insight:</h3>
 * <ul>
 *   <li>If n is even: x^n = x^(n/2) × x^(n/2) = (x^(n/2))²</li>
 *   <li>If n is odd: x^n = x^(n/2) × x^(n/2) × x = (x^(n/2))² × x</li>
 * </ul>
 * 
 * <h3>Complexity Analysis:</h3>
 * <table border="1">
 *   <tr><th>Metric</th><th>Recursive</th><th>Iterative</th></tr>
 *   <tr><td>Time Complexity</td><td>O(log n)</td><td>O(log n)</td></tr>
 *   <tr><td>Space Complexity</td><td>O(log n)</td><td>O(1)</td></tr>
 * </table>
 * 
 * <h3>Edge Cases Handled:</h3>
 * <ul>
 *   <li>Negative exponents: x^(-n) = 1/(x^n)</li>
 *   <li>Zero exponent: x^0 = 1</li>
 *   <li>Base of 0 or 1</li>
 * </ul>
 * 
 * <h3>LeetCode Reference:</h3>
 * <p>Problem #50 - Pow(x, n)</p>
 * 
 * @author srayabar
 * @see <a href="https://leetcode.com/problems/powx-n/">LeetCode #50</a>
 */
@Slf4j
public class PowerOfNumberMain {
    
    /**
     * Main method demonstrating power calculation with various test cases.
     *
     * @param args command-line arguments (not used)
     */
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
     * Helper method that performs the recursive power calculation.
     * 
     * <p>This method assumes n is non-negative (negative case is handled by the public method).</p>
     *
     * @param x the base value
     * @param n the non-negative exponent
     * @return x raised to the power n
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

