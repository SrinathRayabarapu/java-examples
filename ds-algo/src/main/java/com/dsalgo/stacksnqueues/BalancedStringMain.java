package com.dsalgo.stacksnqueues;

import java.util.Stack;

/**
 * class to check whether a given string is balanced or not.
 * <p>
 * https://www.hackerrank.com/challenges/java-stack/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=30-day-campaign
 *
 * @author Srinath.Rayabarapu
 */
public class BalancedStringMain {

    public boolean checkStrngBalanced(final String inputString) {
        CustomStack<Character> charStack = new CustomStack<>(inputString.length());

        for (char charInString : inputString.toCharArray()) {

            if (charInString == '[' || charInString == '{' || charInString == '(') {
                charStack.push(charInString);
            } else if (charStack.peek().equals(']') || charStack.peek().equals('}') || charStack.peek().equals(')')) {
                return false;
            } else if (charStack.peek().equals('[') || charInString == ']') {
                try {
                    charStack.pop();
                } catch (Exception ignored) {
                }
            } else if (charStack.peek().equals('(') || charInString == ')') {
                try {
                    charStack.pop();
                } catch (Exception ignored) {
                }
            } else if (charStack.peek().equals('{') || charInString == '}') {
                try {
                    charStack.pop();
                } catch (Exception ignored) {
                }
            }
        } // for ends

        if (charStack.isEmpty()) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        BalancedStringMain balancedString = new BalancedStringMain();
        while (sc.hasNext()) {
            String input = sc.next();
            System.out.println(balancedString.checkStringBalanced(input));
        }*/


        int balanced = isBalanced("(())()");
        System.out.println(balanced);
    }

    static int isBalanced(String s) {
        Stack<Character> st = new Stack<Character>();
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                st.pop();
                counter++;
            }
        }
        return (counter > 0) ? counter : -1;
    }

}