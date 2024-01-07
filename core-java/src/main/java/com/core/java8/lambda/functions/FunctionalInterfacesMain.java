package com.core.java8.lambda.functions;

import com.sri.strings.random.RandomSentences;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionalInterfacesMain {

    public static void main(String[] args) {

        // Function:apply takes a param T and return a value R
        Function<String, Integer> stringLengthFunction = s -> s.length();

        System.out.println("stringLengthFunction.apply(\"srinath\") = " + stringLengthFunction.apply("srinath"));

        List<String> randomNames = new RandomSentences().getOf(10);
        System.out.println("randomNames = " + randomNames);

        List<Integer> lengthsList = getRandomLengths(randomNames, stringLengthFunction);
        System.out.println("lengthsList = " + lengthsList);

    }

    private static <T, R> List<R> getRandomLengths(List<T> randomNames, Function<T, R> stringLengthFunction) {
        return randomNames.stream().map(stringLengthFunction).collect(Collectors.toList());
    }

}
