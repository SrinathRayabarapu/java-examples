package com.dsalgo.strings;

/**
 * given a string, find max repeating characters in the order of presence.
 *
 * @author Srinath.Rayabarapu
 */
public class MaxCharactersInStringMain {

    public static void main(String[] args) {
        String input = "lalalssalalalassssssssss";
        findMaxChar(input);
    }

    private static void findMaxChar(String input) {
        int[] countArray = new int[256]; //ASCII characters size

        //constructing character count array from the input string
        for (int i = 0; i < input.length(); i++) {
            countArray[input.charAt(i)]++; //char value gets converted to it's ASCII value
        }

        int max = -1;
        char result = ' ';

        // finding the max char value
        for (int i = 0; i < input.length(); i++) {
            if(max < countArray[input.charAt(i)]){
                max = countArray[input.charAt(i)];
                result = input.charAt(i);
            }
        }

        System.out.println("Max char : " + result);
    }

}