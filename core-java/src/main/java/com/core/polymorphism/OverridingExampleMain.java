package com.core.polymorphism;

/**
 * Overriding happens across classes - method signature should not change (params,return types etc)
 *
 * @author Srinath.Rayabarapu
 */
public class OverridingExampleMain {
	
	public static void main(String[] args) {
		A a = new B();
		a.callMe();
		a.m1();
		
		B b = new B();
		b.callMe();
		b.m1();
		
	}
}

class A {
	
	static void m1(){
		System.out.println("m1");
	}
	
	Object callMe() {
		System.out.println("From class A");
		// return 1;
		return null;
	}
	
	Object callMe(int a) {
		System.out.println("From class A");
		// return 1;
		return null;
	}
	Object callMe(int a, int b) {
		System.out.println("From class A");
		// return 1;
		return null;
	}

}

class B extends A {

	static void m1(){
		System.out.println("m1 - 1");
	}
	
	/*
	@Override
	void callMe() {
		System.out.println("From class B");
		super.callMe();
	}
	*/
	
	@Override
	String callMe(){
		System.out.println("From class B");
		return null;
	}
}
