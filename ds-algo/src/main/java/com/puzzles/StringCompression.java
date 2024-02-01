package com.puzzles;

/**
 * aabcccccaaa -> a2b1c5a3
 */
public class StringCompression {

    public static void main(String[] args) {
        String input = "aabcccccaaa";

        System.out.println(compressString(input));
    }

    /**
     * TC: O(n) where n is the length of the string
     *
     * @param input
     * @return
     */
    private static String compressString(String input) {
        String value = "";

        int counter=1;
        char temp = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            if(temp == input.charAt(i)){
                counter++;
            } else {
                value += temp + "" + counter;
                temp = input.charAt(i);
                counter=1;
            }
        }

        return value + temp + counter;
    }

}