package com.core.java8.lambda.binaryoperator;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class BinaryOperatorMain {

    public static void main(String[] args) {

        // BinaryOperator:apply takes a two params of type T and return the value of same type
        BinaryOperator<Integer> integerSumBinaryOperator = (integer, integer2) -> integer+integer2;
        System.out.println("integerSumBinaryOperator.apply(10,12) = " + integerSumBinaryOperator.apply(10, 12));

        List<Integer> integerList = List.of(12, 14, 16, 29, 35);

        List<Integer> sumList = getSumList(integerList, integerSumBinaryOperator);
        System.out.println("sumList = " + sumList);

    }

    private static <T> List<T> getSumList(List<T> integerList, BinaryOperator<T> integerSumBinaryOperator) {
        return integerList.stream().reduce(integerSumBinaryOperator).stream().collect(Collectors.toList());
    }

}
