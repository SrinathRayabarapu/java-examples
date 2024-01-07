package com.core.object;

public class ObjectComparison {

	public static void main(String[] args) {

		String abc_1 = new String("abc");
		String abc_2 = new String("abc");

		int a = abc_1.hashCode();
		int b = abc_2.hashCode();

		if (new Integer(a).equals(new Integer(b))) {
			System.out.println("Objects are shallow equal");
		} else
			System.out.println("Objects are not shallow equal");

		/*
		 * if(a == b) System.out.println("Objects same"); else
		 * System.out.println("Objects not same");
		 */

	}
}