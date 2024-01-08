package com.hackerrank;

public class IntToString {

	public static void main(String[] args) {

		int n = 100;

		String s = "";
		// copy
		int temp = n;
		while (temp != 0) {
			s = (temp % 10) + "" + s;
			temp = temp / 10;
		}
		if(n == 0) {
			s = "0";
		}
		System.out.println(s);

		if (n == Integer.parseInt(s)) {
			System.out.println("Good job");
		} else {
			System.out.println("Wrong answer.");
		}

	}

}
