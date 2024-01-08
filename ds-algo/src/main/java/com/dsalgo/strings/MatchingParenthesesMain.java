package com.dsalgo.strings;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Stack;

/**
 * given a string, check whether it has matching parentheses
 */
@Slf4j
public class MatchingParenthesesMain {

    public static void main(String[] args) {

        String input1 = "(abc[he]lala{})";
        checkMatchingParentheses(input1);

    }

    // trick is to put the values in stack and compare against the keys from String
    private static void checkMatchingParentheses(String input1) {

        Map<Character, Character> tokensMap = Map.of(']', '[',
                ')', '(',
                '}', '{');

        Stack<Character> stack = new Stack<>();

        for(char c : input1.toCharArray()) {
            if(tokensMap.containsValue(c)){
                stack.push(c);
            } else if(tokensMap.containsKey(c) && stack.peek().equals(tokensMap.get(c))) {
                stack.pop();
            }
        }

        if(!stack.isEmpty()) {
            log.info("Input string doesn't have matching parentheses!");
        } else {
            log.info("String has matching parentheses");
        }

    }

}