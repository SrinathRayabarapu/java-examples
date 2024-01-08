package com.dsalgo.strings;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * https://leetcode.com/problems/backspace-string-compare/
 */
@Slf4j
public class TypedOutStrings {

    /**
     * TC: O(a + b) where a and b are lengths of s and t strings respectively
     * SC: O(a + b)
     *
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare(String s, String t) {

        Stack<Character> stack = new Stack<>();

        s = typeOutHashCharsOk(s, stack);

        t = typeOutHashCharsOk(t, stack);

        log.info("s : {}, t : {}", s, t);

        return s.equals(t);
    }

    /**
     * hints:
     * 1. use original strings
     * 2. use 2 pointer technique
     * 3. start from string end
     *
     * @param input1
     * @param input2
     * @return
     */
    private boolean typeOutHashCharsGood(String input1, String input2) {
        return true;
    }

    private String typeOutHashCharsOk(String input, Stack<Character> stack) {

        stack.clear();

        char[] chars = input.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(chars[i]);
            }
        }
        return stack.toString();
    }

}
