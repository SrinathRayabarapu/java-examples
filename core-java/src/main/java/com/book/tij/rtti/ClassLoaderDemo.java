package com.book.tij.rtti;

import java.util.Random;

class Initable1{
	//resolved at compile time
	static final int staticFinal1 = 49;
	//not resolved at compile time
	static final int staticFinal2 = ClassLoaderDemo.rand.nextInt(1000);
	static{
		System.out.println("From Initable1 static block");
	}
}
class Initable2{
	static int staticNonFinal1 = 45;
	static{
		System.out.println("From Initable2 static block");
	}
}
class Initable3{
	static int staticNonFinal1 = 34;
	static{
		System.out.println("From Initable3 static block");
	}
}
/**
 * demo class to understand how class loader loads a class
 * 
 */
public class ClassLoaderDemo {
	public static Random rand = new Random(47);
	public static void main(String[] args) throws ClassNotFoundException {
		
		//will load the class
		Class class1 = Initable1.class;
		System.out.println("Initable class reference is fetched");
		
		//loading and linking are done but doesn't initialize the class
		//final static - variables are initialized at compile time but not for all cases
		System.out.println(Initable1.staticFinal1);
		
		//in this case class loader initializes the class to access the value
		System.out.println(Initable1.staticFinal2);
		
		//non final variable - triggers class initialization
		System.out.println(Initable2.staticNonFinal1);
		
		//mandates Initable3 class initialization
		Class initiable3 = Class.forName("com.book.tij.rtti.Initable3");
		System.out.println(Initable3.staticNonFinal1);
	}
}