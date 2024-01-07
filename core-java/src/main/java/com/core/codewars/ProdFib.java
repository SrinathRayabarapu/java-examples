package com.core.codewars;

import java.util.Arrays;

public class ProdFib {

    public static long[] productFib(long prod) {

        long first = 0;
        long second = 1;
        long fib = 0;

        for(int i=2; i<Integer.MAX_VALUE; i++){
            if(prod == first*second){
                long[] arr = {first, second, 1L};
                System.out.println(Arrays.toString(arr));
                return arr;
            } else if(first*second > prod) {
                long[] arr = {first, second, 0};
                System.out.println(Arrays.toString(arr));
                return arr;
            }
            fib = first + second;
            first = second;
            second = fib;
            System.out.printf("first : %d and second is : %d\n", first, second);
        }

        // your code
        return null;
    }

    // best solution Kata
    public static long[] bestProductFib(long prod) {
        long a = 0L;
        long b = 1L;
        while (a * b < prod) {
            long tmp = a;
            a = b;
            b = tmp + b;
        }
        return new long[] { a, b, a * b == prod ? 1 : 0 };
    }

}
