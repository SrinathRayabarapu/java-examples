package com.core.strings;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * Write an application that uses String method regionMatches to compare two strings input by the user.
 * The program should input the number of characters to be compared and the starting index of the comparison.
 * The program should state whether the first string is less than, equal or greater than the second string.
 * Ignore the case of the characters when performing the comparison.
 *
 * @author Srinath.Rayabarapu
 */
public class StringMatchMain {
	public static void main(String[] args) {
		StringComp strcmp = new StringComp();
		strcmp.compareStrings();
	}
}

class StringComp {
	String string1, string2;
	int no_of_chars, start_index1, start_index2;
	boolean result;
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	void compareStrings() {
		try {
			System.out.println("Enter String 1  ");
			string1 = br.readLine();
			System.out.println("Enter String 2 ");
			string2 = br.readLine();
			System.out.println("Enter the no.of characters to compare ");
			no_of_chars = Integer.parseInt(br.readLine());
			System.out.println("Enter the starting index of string1 ");
			start_index1 = Integer.parseInt(br.readLine());
			System.out.println("Enter the starting index of string2 ");
			start_index2 = Integer.parseInt(br.readLine());
			result = string1.regionMatches(true, start_index1, string2,
					start_index2, no_of_chars);
			if (result)
				System.out.println("The region Matches\n");
			else
				System.out.println("The region Doesn't match\n");

			if (string1.equalsIgnoreCase(string2))
				System.out.println("BOTH THE STRINGS ARE SAME");

			else if (string1.compareToIgnoreCase(string2) > 0)
				System.out.println("STRING1 IS GREATER THAN STRING2");

			else if (string1.compareToIgnoreCase(string2) < 0)
				System.out.println("STRING1 IS LESS THAN STRING2");
		} catch (Exception e) {
		}
	}
}
