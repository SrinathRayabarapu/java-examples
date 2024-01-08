package com.puzzles.palindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestPalindromicSubStringMainTest {

    @Test
    void findLongestPalindromicSubString() {
        assertEquals("geeksskeeg", LongestPalindromicSubStringMain.findLongestPalindromicSubString("forgeeksskeegfor"));
    }

}