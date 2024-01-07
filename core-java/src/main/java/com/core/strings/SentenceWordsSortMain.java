package com.core.strings;

import java.util.StringTokenizer;

/** 
 * Write a program that sets up a String variable containing a paragraph of text of your choice.
 * Extract the words from the text and sort them into alphabetical order. Display the sorted list of words.
 * You could use simple sorting method called the bubble sort.
 *
 * To sort an array into ascending order the process is as follows.<br>
 * i. Starting with the first element in the array compare successive elements (0 and 1, 1 and 2, 2and 3
 * and so on)<br>
 * ii.	If the first element of any pair is greater than the second interchange the two elements.<br>
 * iii.	Repeat the process for the whole array until no interchanges are necessary. The array elements
 * will be now in ascending order.<br>
 *
 * @author Srinath.Rayabarapu
 */
class SortOne {

	String str = "this is a book";
	StringTokenizer tokenizer;
	String temp_str[], temp = null;
	int words;
	
	void wordSort() {
		tokenizer = new StringTokenizer(str);
		words = tokenizer.countTokens();
		temp_str = new String[words];

		while (tokenizer.hasMoreElements()) {
			for (int i = 0; i < words; i++)
				temp_str[i] = tokenizer.nextToken();
		}
		
		for (int i = 0; i < words; i++) {
			for (int j = i + 1; j < words; j++) {
				if ((temp_str[i].compareTo(temp_str[j])) > 0) {
					temp = temp_str[i];
					temp_str[i] = temp_str[j];
					temp_str[j] = temp;
				}
			}
		}
	}

	void display() {
		for (int i = 0; i < words; i++)
			System.out.println(temp_str[i]);
	}
}

public class SentenceWordsSortMain {
	public static void main(String[] v) {
		SortOne s = new SortOne();
		s.wordSort();
		s.display();
	}
}