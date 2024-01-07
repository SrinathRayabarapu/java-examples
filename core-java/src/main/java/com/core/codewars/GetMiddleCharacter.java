package com.core.codewars;

/**
 * https://www.codewars.com/kata/56747fd5cb988479af000028/solutions/java
 */
public class GetMiddleCharacter {
    public static String getMiddle(String word) {
        if(word.length() <= 1){
            return word;
        }
        if(word.length()%2 == 0){
            return String.valueOf(word.charAt((word.length()/2) - 1)) + String.valueOf(word.charAt(word.length()/2));
        } else {
            return String.valueOf(word.charAt(word.length()/2));
        }
    }

    // best solution from Kata
    public static String bestGetMiddle(String word) {
        String s = "";
        int length = word.length();
        int half = length/2;

        if (length % 2 == 0) {
            s = word.substring(half - 1, half + 1);
        } else {
            s = word.substring(half, half + 1);
        }
        return s;
    }
}