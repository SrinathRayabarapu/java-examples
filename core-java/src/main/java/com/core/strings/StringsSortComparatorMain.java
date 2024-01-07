package com.core.strings;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1. Create a Comparator that reverses the outcome of a comparison between two strings.
 * 2. Create an object of that Comparator.
 * 3. Pass both the array to be sorted and the Comparator to a version of java.util.Arrays.sort( )
 * that takes a comparator as an argument. When sort( ) returns, the array will be sorted in reverse.
 *
 * @author Srinath.Rayabarapu
 */
public class StringsSortComparatorMain {

	public static void main(String[] args) {

		String[] stringArray = { "apple", "zoo", "Jeep", "BMW", "ferrari" };

		System.out.println("Initial Order :: ------");
		for (String s : stringArray) {
			System.out.println(s);
		}

		RevStringcompare stringcompare = new RevStringcompare();
		IgnoreCaseComp caseComp = new IgnoreCaseComp();

		Arrays.sort(stringArray, stringcompare);

		System.out.println("Sorted in Comparator Order :: ------");
		for (String s : stringArray) {
			System.out.println(s);
		}

		Arrays.sort(stringArray);

		System.out.println("Sorted in Natutal Order :: ------");
		for (String s : stringArray) {
			System.out.println(s);
		}

		Arrays.sort(stringArray, caseComp);

		System.out.println("Sorted IgnoreCase Order :: ------");
		for (String s : stringArray) {
			System.out.println(s);
		}

	}

}

class RevStringcompare implements Comparator<String> {
	@Override
	public int compare(String string1, String string2) {
		return string2.compareTo(string1);
	}
}

class IgnoreCaseComp implements Comparator<String> {
	@Override
	public int compare(String string1, String string2) {
		return string1.compareToIgnoreCase(string2);
	}
}
