package com.core.wrapperclasses;

public class WrapperDemo {
	public static void main(String a[]) {
		int i = 100;
		Integer i1 = new Integer(i);
		System.out.println("wraper int value:" + i1.intValue());
		String s1 = "123";
		String s2 = "4645";
		System.out.println(Integer.parseInt(s1) + Integer.parseInt(s2));
	}
}
