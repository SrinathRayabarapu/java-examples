package com.book.scjp.qb1;

class MyClass {
	/*int myMethod(int a, int b) {
		return a*b;
	}*/
	
	static double myMethod(double a, double b) {
		return a*b;
	}
}

public class Que67 extends MyClass{
	public static void main(String[] args) {
		//double db = 12.00;
		int in = 12;
		System.out.println(myMethod(in, 15));
	}
}
