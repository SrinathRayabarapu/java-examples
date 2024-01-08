package com.dsalgo.strings;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * program to reverse a string
 * <p>
 * #siemens
 *
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class StringReverseMain {

    public static void main(String[] v) {

        String str = "abcdefg";

        aproach1(str);

        aproach2(str);

        String reverse = aproachRecursive(str, str.length(), "");
        log.info(reverse);

        char[] input = "SrinathRayabarapu".toCharArray();
        log.info("Before two pointer technique : {}", Arrays.toString(input));
        twoPointerTechnique(input);
        log.info("After two pointer technique : {}", Arrays.toString(input));

    }

    private static void twoPointerTechnique(char[] input) {
        int i = 0;
        int j = input.length - 1;
        while (i < j) {
			swap(input, i, j);
            i++;
            j--;
        }
    }

	public static void swap(char[] input, int i, int j) {
		char temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

    /**
     * reverse string recursively
     *
     * @param str
     * @param length
     * @param temp
     * @return
     */
    private static String aproachRecursive(String str, int length, String temp) {
        if (length > 0) {
            temp = temp + str.charAt(length - 1);
            return aproachRecursive(str, length - 1, temp);
        }
        return temp;
    }

    /**
     * taking an extra space
     *
     * @param str
     */
    private static void aproach2(String str) {
        String reversed = "";
        for (Character character : str.toCharArray()) {
            reversed = character + reversed;
        }
        log.info(reversed);
    }

    /**
     * without extra space
     *
     * @param str
     */
    private static void aproach1(String str) {
        for (int i = str.length() - 1; i >= 0; i--)
            System.out.print(str.charAt(i));
    }
}