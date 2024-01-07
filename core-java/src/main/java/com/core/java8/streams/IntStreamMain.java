package com.core.java8.streams;

import java.util.stream.IntStream;

public class IntStreamMain {

    public static void main(String[] args) {

        IntStream.range(1, 4) //for loop alternative and param1 inclusive and param2 exclusive
                .forEach(System.out::println);

        IntStream.range(1, 4) //mapping primitive to Object
                .mapToObj(i -> "a"+i)
                .forEach(System.out::println);

        int[] numbers = {1, 13, 40, 2, 9, 19, 3, 11};
        int min = IntStream.of(numbers).min().getAsInt();
        System.out.println("Minimum number: " + min);

        int max = IntStream.of(numbers).max().getAsInt();
        System.out.println("Maximum number: " + max);

        double asDouble = IntStream.of(numbers).average().getAsDouble();
        System.out.println("Average number: " + asDouble);

        long count = IntStream.of(numbers).count();
        System.out.println("Count number: " + count);

        int sum = IntStream.of(numbers).sum();
        System.out.println("Sum number: " + sum);

        // Original array is NOT mutated!
        IntStream.of(numbers).distinct().sorted().limit(3).forEach(System.out::println);

    }

}
