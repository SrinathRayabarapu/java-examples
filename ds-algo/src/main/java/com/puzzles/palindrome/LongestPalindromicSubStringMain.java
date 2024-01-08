package com.puzzles.palindrome;

/**
 * ALGO:
 *
 * 1. Maintain a variable 'maxLength = 1' (for storing LPS(Largest Palindrome SubString) length) and 'start =0'
 * (for storing starting index of LPS).
 *
 * 2. The idea is very simple, we will traverse through the entire string with i=0 to i<(length of string).
 *      while traversing, initialize 'low' and 'high' pointer such that low= i-1 and high= i+1.
 *      keep incrementing 'high' until str[high]==str[i].
 *      similarly keep decrementing 'low' until str[low]==str[i].
 *      finally we will keep incrementing 'high' and decrementing 'low' until str[low]==str[high].
 *      calculate length=high-low-1, if length > maxLength then maxLength = length and start = low+1 .
 *
 * 3. Print the LPS and return maxLength.
 *
 * TC: O(n^2)
 * SC: O(1)
 */
public class LongestPalindromicSubStringMain {

    public static String findLongestPalindromicSubString(String inputString) {

        System.out.println("inputString = " + inputString);

        if(inputString.length() < 2){
            return inputString;
        }

        int length = inputString.length();
        int low;
        int high;
        int maxLength = 0;
        int start = 0;

        for (int i = 0; i < length; i++) {

            low = i-1;
            high = i+1;

            while( 0 <= low && inputString.charAt(low) == (inputString.charAt(i))){
                low--;
            }

            while( high < length && inputString.charAt(high) == (inputString.charAt(i))){
                high++;
            }

            while(0 <= low && high < length && inputString.charAt(high) == inputString.charAt(low)){
                low--;
                high++;
            }

            System.out.println("inputString.charAt(i) : " + inputString.charAt(i));
            System.out.println("i = " + i + " low = " + low + " high = " + high);

            int len = high - low - 1;

            System.out.println("len = " + len);

            if(maxLength < len){
                maxLength = len;
                start = low + 1;
            }

        }

        String outputString = inputString.substring(start, start + maxLength);
        System.out.println("Largest Palindrome is : " + outputString);

        return outputString;
    }

}