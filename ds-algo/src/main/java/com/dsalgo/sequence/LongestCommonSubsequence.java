package com.dsalgo.sequence;

/**
 * finding longest common subsequence in case of below scenarios -
 * <p>
 * 1. given two strings, find common longest subsequence
 * 2. given a string of repetitive characters, find common longest subsequence
 *
 * @author Srinath.Rayabarapu
 */
public class LongestCommonSubsequence {

//    https://www.youtube.com/watch?v=sSno9rV8Rhg

    public static void main(String[] args) {
        //TODO -

        // 2nd problem
        System.out.println(longestRepetitiveChars("ccccccaaaabbbbb")); // 6 c's
        System.out.println(longestRepetitiveChars("ccbbbaaaaddaa")); // 4 a's
        System.out.println(longestRepetitiveChars("abcdeeefeeeeeeeefppppppp")); // 8 e's

        System.out.println(longestRepetitiveChars1("ccccccaaaabbbbb")); // 6 c's
        System.out.println(longestRepetitiveChars1("ccbbbaaaaddaa")); // 4 a's
        System.out.println(longestRepetitiveChars1("abcdeeefeeeeeeeefppppppp")); // 8 e's
    }

    /**
     * my way - have an index starting from 0 and compare it with i. have a currentCounter and global counter and
     * assign it based on max count.
     *
     * @param input
     * @return
     */
    private static int longestRepetitiveChars(String input) {

        int counter = 0;
        for (int i = 1; i < input.length(); i++) {
            int currentCounter = 1, index = i - 1;
            while (i < input.length() && input.charAt(index) == input.charAt(i)) {
                index++;
                i++;
                currentCounter++;
            }
            if (counter < currentCounter) {
                counter = currentCounter;
            }
        }
        return counter;
    }

    /**
     * SOF - solution
     *
     * @param input
     * @return
     */
    private static int longestRepetitiveChars1(String input) {
        int currLen = 1, maxLen = 0;
        for (int currPos = 0; currPos < input.length() - 1; currPos++) {
            char currLet = input.charAt(currPos);
            //System.out.println("Curr char: "+currLet+"  Next Char: "+str.charAt(currPos+1));
            if (currLet == input.charAt(currPos + 1)) {
                currLen++;
            } else if (currLen > maxLen) {
                maxLen = currLen;
                currLen = 1;
            } else {
                currLen = 1;
            }
        }
        if (currLen > maxLen) {
            maxLen = currLen;
        }
        return maxLen;
    }

}