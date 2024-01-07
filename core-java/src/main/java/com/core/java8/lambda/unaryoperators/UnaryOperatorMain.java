package com.core.java8.lambda.unaryoperators;

import com.sri.strings.random.RandomSentences;

import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class UnaryOperatorMain {

    public static void main(String[] args) {
        // UnaryOperator:apply takes a param T and return a value T
        UnaryOperator<String> stringUnaryOperator = s -> s.toUpperCase();
        System.out.println("stringUnaryOperator.apply(\"srinath\") = " + stringUnaryOperator.apply("srinath"));

        List<String> randomNames = new RandomSentences().getOf(10);
        System.out.println("randomNames = " + randomNames);
        List<String> upperStringsList = getUpperStrings(randomNames, stringUnaryOperator);
        System.out.println("upperStringsList = " + upperStringsList);
    }

    private static <T> List<T> getUpperStrings(List<T> randomNames, UnaryOperator<T> stringUnaryOperator) {
        return randomNames.stream().map(stringUnaryOperator).collect(Collectors.toList());
    }

}
