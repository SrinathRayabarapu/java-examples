package com.puzzles;

import static java.lang.Character.isDigit;


/**
 * Write a class that keeps a running total of all characters passed to it (one at a time) and throws an
 * exception if it is passed a non-alphabetic character
 *
 * @author Srinath.Rayabarapu
 */
class MyException extends Exception {

	String str;
	MyException() {
		System.out.println("It's not a Character");
	}

}

/******* CHECK THE PROGRAM WITH MULTIPLE INPUTS **********/
class Characters {
	char ch;
	int count = 0;

	void readChar() {
		System.out.println("enter the character");

		try {

			while (true) {
				ch = (char) System.in.read();

				if (isDigit(ch))
					throw new MyException();
				count++;
			}

		} catch (Exception e) {
		}
		System.out.println("the Total running Character is = " + count);

	}
}

class TotalCharacter {
	public static void main(String[] args) {
		Characters chars = new Characters();
		chars.readChar();
	}
}