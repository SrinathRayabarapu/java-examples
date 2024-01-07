package com.aaa;

import java.math.BigInteger;

/**
 * TODO: understand
 *
 */
public class FactorialMain {

    public static void main(String[] args) {
        BigInteger factorial = factorialAdv(10);
        System.out.println(factorial);
        int spaces = findSpaces(factorial);
        System.out.println(spaces);
    }

    private static int findSpaces(BigInteger factorial) {
        int count = 0;
        while (factorial.remainder(BigInteger.valueOf(10)) == BigInteger.ZERO){
            factorial = factorial.divide(BigInteger.valueOf(10));
            count++;
        }
        return count;
    }

    private static long factorial(int number) {
        long result = 1;
        if ((number == 0) || (number == 1)) {
            result = 1;
        } else {
            for (int i = 2; i <= number; i++) {
                result *= i;
            }
        }
        return result;
    }

    private static BigInteger factorialAdv(int number) {
        BigInteger factorial = new BigInteger("1");
        for (int i = 2; i <= number; i++){
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }


}
