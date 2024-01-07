package com.core.codewars;

import java.util.stream.Stream;

public class ShortestWord {

    public static int findShort(String s) {
        int min = Integer.MAX_VALUE;
        for(String word : s.split(" ")){
            min = Math.min(min, word.length());
        }
        return min;
    }

    // best solution from Kata
    public static int bestFindShort(String s) {
        return Stream.of(s.split(" "))
                .mapToInt(String::length)
                .min()
                .getAsInt();
    }

}
