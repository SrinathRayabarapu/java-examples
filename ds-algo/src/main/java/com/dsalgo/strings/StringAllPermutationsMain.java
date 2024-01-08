package com.dsalgo.strings;

/**
 * given a string, find all it's permutation combinations
 * <p>
 * https://www.sanfoundry.com/java-program-permute-all-letters-input-string/
 *
 * Time Complexity: O(n*(n!) ) where n is the length of the string.
 *
 * #SoftwareAG
 *
 * @author Srinath.Rayabarapu
 */
public class StringAllPermutationsMain {

    public static void main(String[] args) {
        String input = "ABC";
        findAllPermutations(input, 0, input.length() - 1);
    }

    private static void findAllPermutations(String input, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            System.out.println(input);
        }

        for (int i = startIndex; i <= endIndex; i++) {
            input = swap(input, i, startIndex);
            findAllPermutations(input, startIndex+1, endIndex);
            input = swap(input, i, startIndex);
        }
    }

    private static String swap(String input, int i, int startIndex) {
        char[] chars = input.toCharArray();
        char temp = chars[i];
        chars[i] = chars[startIndex];
        chars[startIndex] = temp;
        return String.valueOf(chars);
    }

}