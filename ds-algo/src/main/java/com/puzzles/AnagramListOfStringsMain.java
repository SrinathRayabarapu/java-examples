package com.puzzles;

import java.util.ArrayList;
import java.util.List;

/**
 * program to find max number of anagrams in a given list of strings
 *
 * Anagram def : abcd and dcab : same length and should have all the chars in both strings in any order
 * 
 * @author Srinath.Rayabarapu
 */
public class AnagramListOfStringsMain {

	public static void main(String[] args) {

		List<String> stringsList = new ArrayList<>();
		stringsList.add("bca");
		stringsList.add("abc");
		stringsList.add("abd");
		stringsList.add("ab");
		stringsList.add("ba");
		stringsList.add("ac");
		stringsList.add("ca");
		stringsList.add("cba");
		stringsList.add("ba");
		stringsList.add("ab");

		checkAndPrintAnagrams(stringsList);
		
	}

	private static void checkAndPrintAnagrams(List<String> stringsList) {
		
		int maxCount = 0;
		for (int i = 0; i < stringsList.size(); i++) {
			int counter = 0;
			//need count for self too - so j=i
			for (int j = i; j < stringsList.size(); j++) {
				if (isAnagram(stringsList.get(i), stringsList.get(j))) {
					//System.out.println(stringsList.get(j));
					counter++;
				}
			}
			if(maxCount < counter){
				maxCount = counter;
			}
		}
		System.out.println(maxCount);
	}

	/*
	 * 
	 * This method assumes both arguments are not null and in lowercase.
	 * 
	 * @return true, if both String are anagram
	 */
	public static boolean isAnagram(String word, String anagram) {

		// both strings length should be same
		if (word.length() != anagram.length()) {
			return false;
		}

		char[] chars = word.toCharArray();

		for (char c : chars) {
			int index = anagram.indexOf(c);
			if (index != -1) {
				//imp - take out the matched char, so all the chars are exactly checked
				anagram = anagram.substring(0, index) + anagram.substring(index+1, anagram.length());
			} else {
				return false;
			}
		}
		//if all the char's are matched then it must be empty
		return anagram.isEmpty();
	}
}