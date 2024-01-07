package com.core.strings;

import java.time.Duration;

/**
 * String practice program
 * 
 * @author srinath.rayabarapu
 */
public class StringMain {

	public static void main(String[] arg) {
		
		//testname();


		String a = "AAA_1121@@";
		System.out.println("a lowercase is : " + a.toLowerCase());

		
		System.out.println(Integer.parseInt((" 01").trim()));
		
		String abc = "01/01/2019 10:11";
		System.out.println(abc.trim().split(" ")[1]);

		String x = "x";
		String y = new String("x");
		if(x == y){
			System.out.println("same");
		} else
			System.out.println("not same");


		System.out.println("hsdjsdshd ,".split(",")[0]);

		Duration duration = Duration.ofMillis(5000);

		byte b = (byte)32;
		System.out.println(b);

		
	}

	private void printHashCode(String str1, String str2) {
		System.out.println("str1 hashcod:"+str1.hashCode());
		System.out.println("str2 hashcod:"+str2.hashCode());
	}
	
	public static void testname() {
		

		// str1 , str2 ,str3 are the string variables.
		String str1 = "hi";
		String str2 = "hi";
		StringMain stringMain = new StringMain();
		
		stringMain.printHashCode(str1, str2);
		
		String str3 = new String("hi");

		// comparing the string variables str1 and str2 which point to the same
		// memory location

		if (str1 == str2)
			System.out.println("both are equal");
		else
			System.out.println("both are not equal");

		// comparing the values of the string variables str1 and str2

		if (str1.equals(str2))
			System.out.println("both are Same");
		else
			System.out.println("not equal");

		// comparing the string variables str1 and str3 which are pointing to
		// different memory location
		if (str3 == str1)
			System.out.println("SAME");
		else
			System.out.println("NOT SAME");

		// comparing the values of the string variables str1 and str3
		if (str3.equals(str1))
			System.out.println("Both strings are same");
		else
			System.out.println("Both are not same");
		
	}
}