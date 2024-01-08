package com.dsalgo.strings;

import java.util.Stack;

/**
 * given a string, check the number of matching brackets.
 * 
 * @author Srinath.Rayabarapu
 */
public class StringBracketMatchesStackMain {
	
	public static void main(String[] args) {
		
		String str = "(()())";
		findNumberOfMatches(str);
		
		String str1 = "(((())))";
		findNumberOfMatches(str1);
		
		String equ = "(a+(b*c)-d)";
		findNumberOfMatches(equ);
	}

	/**
	 * assumption is : user doesn't pass invalid strings(")(())")
	 * @param str
	 */
	private static void findNumberOfMatches(String str) {
		
		Stack<String> stack = new Stack<>();
		int matches = 0;
		
		for(int i=0; i<str.length(); i++) {
			char charct = str.charAt(i);
			if( '(' == charct ){
				stack.push(charct+"");
				
			} else if( ')' == charct ){
				if(!stack.isEmpty() && stack.peek().equals("(")) {
					stack.pop();
					matches++;
				}
			}
		}
		if(stack.isEmpty())
			System.out.println("Stack is empty");
		else
			System.out.println("Final Stack is : " + stack);
		
		System.out.println("Number of Matches : " + matches);
	}

}
