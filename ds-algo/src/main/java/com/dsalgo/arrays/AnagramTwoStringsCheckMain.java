package com.dsalgo.arrays;

/**
 * given two strings, check whether they are anagrams or not.
 * <p>
 * Anagram: Two strings should have same characters but in any order.
 * Ex: abcd dacb
 * <p>
 * Approach:
 * check lengths of two strings, if not equal then return false
 * find each string character repetition arrays and compare
 *
 * @author Srinath.Rayabarapu
 */
public class AnagramTwoStringsCheckMain {

    public static void main(String[] args) {

        String abc = "abcdf";
        String bcd = "acdbf";

        okApproach(abc, bcd);

    }

    private static void okApproach(String abc, String bcd) {

        if (abc == bcd) {
            System.out.printf("% and %s are anagrams\n", abc, bcd);
        }

        if (abc.length() != bcd.length()) {
            System.out.printf("% and %s are NOT anagrams\n", abc, bcd);
        }

        int[] repCharsArray1 = findRepeatedCharacters(abc);
        int[] repCharsArray2 = findRepeatedCharacters(bcd);

        int count = checkArraysForMatchingCount(repCharsArray1, repCharsArray2);

        if (count == abc.length()) {
            System.out.println(abc + "," + bcd + " are Anagrams!");
        } else {
            System.out.println(abc + "," + bcd + " are NOT Anagrams!");
        }

    }

    private static int checkArraysForMatchingCount(int[] array1, int[] array2) {

        int count = 0;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != 0 && array1[i] == array2[i]) {
                count++;
            }
        }
        return count;
    }

    private static int[] findRepeatedCharacters(String string) {
        int[] target = new int[256];
        for (char c : string.toCharArray()) {
            target[c]++;
        }
        return target;
    }

}