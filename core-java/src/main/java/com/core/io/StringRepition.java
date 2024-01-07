package com.core.io;

public class StringRepition {

	public static void main(String[] args) {

		String[] names = { "a", "b", "c", "d" };

		final int SIZE = 20;

		for (int i = 0; i < SIZE; i++) {
			System.out.println(names[i % names.length] + "....." + i);
		}
	}
}