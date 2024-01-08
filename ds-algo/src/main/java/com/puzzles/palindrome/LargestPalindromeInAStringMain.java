package com.puzzles.palindrome;

/**
 * given a long string, find long palindromic substring.
 * <p>
 * Algo 1:
 * Steps: Its a brute force method
 * <p>
 * 1. Have 2 for loops
 * 2. for i = 1 to i less than array.length -1
 * 3. for j=i+1 to j less than array.length
 * 4. This way you can get substring of every possible combination from the array
 * 5. Have a palindrome function which checks if a string is palindrome
 * so for every substring (i,j) call this function, if it is a palindrome store it in a string variable
 * If you find next palindrome substring and if it is greater than the current one, replace it with current one.
 * Finally, your string variable will have the answer
 * <p>
 * Issues: Time complexity: O(n^3)
 *
 * @author Srinath.Rayabarapu
 */
public class LargestPalindromeInAStringMain {

    public static void main(String[] args) {
        findLargestPalindrome("ssdhsabccbakssdsd");
        //System.out.println(checkStringPalindromeOrNot("madam"));
    }

    public static void findLargestPalindrome(String inputString) {

        String largePalindrome = "";

        for (int i = 0; i < inputString.length(); i++) {
            for (int j = i + 1; j < inputString.length(); j++) {

                String subString = inputString.substring(i, j);
                if (isPalindrome(subString) && (largePalindrome.length() < subString.length())) {
                    largePalindrome = subString;
                }

            }
        }
        System.out.println("Biggest Palindrome : " + largePalindrome);
    }

    /**
     * simple method to check whether a string a palindrome or not
     *
     * @param string
     * @return
     */
    public static boolean isPalindrome(String string) {
        int i = 0;
        int j = string.length() - 1;
        while (i < j) {
            if (string.charAt(i) != string.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}