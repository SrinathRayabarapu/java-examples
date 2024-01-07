package com.core.java8.lambda.consumers;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerMain {

    public static void main(String[] args) {

        // Consumer takes a param and return nothing
        Consumer<Integer> intConsumer = integer -> System.out.println("integer = " + integer);
        intConsumer.accept(10);

        List<Integer> intList = List.of(1, 11, 23, 0, 56, 18);
        printList(intList, intConsumer);
    }

    private static <T> void printList(List<T> intList, Consumer<T> intConsumer) {
        intList.forEach(intConsumer);
    }

}