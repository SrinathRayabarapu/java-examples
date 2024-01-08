package com.puzzles.palindrome;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * TODO - find better solutions
 *
 * #walmart
 */
public class LargestPalindromeInStreamOfStringsMain {

    static int maxLengthOfPolindrome = 0;
    static String firstHalfToken = null;
    static String maxPolindrome = "";

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("abc xyz abcba 1221 12345678987654321 101 asd");
        list.add("sa abc");

        for(String line : list){
            StringTokenizer stringTokenizer = new StringTokenizer(line);
            while (stringTokenizer.hasMoreTokens()){
                boolean isTheLastBrokenToken = !stringTokenizer.hasMoreTokens() && line.charAt(line.length()-1) != ' ';
                findMaxPolindromeStringLength(stringTokenizer.nextToken(), isTheLastBrokenToken);
            }
        }

        System.out.println("Max Polindrome : " + maxPolindrome);
        System.out.println("Max length of the polindrome : " + maxLengthOfPolindrome);
    }

    private static void findMaxPolindromeStringLength(String nextToken, boolean isBrokenToken) {

        // usecase 2 :
        if(isBrokenToken){
            firstHalfToken = nextToken;
            return;
        }

        if(firstHalfToken != null){
            nextToken += firstHalfToken + nextToken;
        }

        char[] chars = nextToken.toCharArray();

        // usecase : 1
        if(chars.length < maxLengthOfPolindrome){
            return;
        }

        int left = 0;
        int right = chars.length-1;

        boolean isPolindrome = true;

        while(left < right){
            if(chars[left] == chars[right]){
                left++;
                right--;
            } else {
                isPolindrome = false;
                break;
            }
        }

        if(isPolindrome){
            maxLengthOfPolindrome = Math.max(maxLengthOfPolindrome, chars.length);
            maxPolindrome = nextToken;
        }

    }

}
