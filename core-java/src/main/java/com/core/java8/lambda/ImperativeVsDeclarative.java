package com.core.java8.lambda;

import java.util.stream.IntStream;

public class ImperativeVsDeclarative {

    public static void main(String[] args) {

        // find the sum of all even numbers between 0 to 100

        // imperative = familiar
        int sum = 0;
        for (int i = 0; i <= 100 ; i++) {
            if(i%2 == 0){
                sum = sum + i; // not thread-safe since we are depending on mutable variable 'sum'
            }
        }
        System.out.println("Imperative sum = " + sum);

        // declarative
        int sum1 = IntStream.rangeClosed(0, 100).filter(i -> i % 2 == 0).sum(); // thread-safe
        System.out.println("Declarative sum1 = " + sum1);

    }

}
