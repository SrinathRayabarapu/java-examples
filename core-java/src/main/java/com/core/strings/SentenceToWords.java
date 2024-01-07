package com.core.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * uses stringtokenizer class to tell no of words in a class
 * 
 * @author Sreekanth
 */
public class SentenceToWords {
	private String string;
	int count = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new SentenceToWords();
	}

	public SentenceToWords() {
		// One way of reading from cosole
		/*
		 * Scanner scanner = new Scanner(System.in); String name =
		 * scanner.nextLine(); System.out.println(name);
		 */
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		try {
			System.out.println("Please enter a sentence");
			string = bufferedReader.readLine();
			StringTokenizer tokenizer = new StringTokenizer(string, "a");
			System.out.println("tokenization starts..");

			while (tokenizer.hasMoreTokens()) {
				String string = tokenizer.nextToken();
				System.out.println("tokens are : " + string);
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Total tokens are : " + count);
	}
}
