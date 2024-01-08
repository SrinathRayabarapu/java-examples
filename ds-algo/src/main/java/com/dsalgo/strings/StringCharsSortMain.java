package com.dsalgo.strings;

import java.util.Arrays;

/**
 * given a random string, print a sorted string
 *
 * idea:
 * 1. using Arrays.sort()
 * 2. change characters to their ASCII numbers and sort
 *
 * @author Srinath.Rayabarapu
 */
public class StringCharsSortMain {

    public static void main(String[] args) {

        //random string
        String abc = "suaxang";
        char[] charArray = abc.toCharArray();

        // uses dual pivot quicksort - O(n logn) complexity
        Arrays.sort(charArray);

        abc = new String(charArray);
        //sorted string array
        System.out.println(abc);

        //TODO - need an algorithmic way
    }
}