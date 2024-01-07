package com.core.classes;

/**
 * explained basic funda here, same can also be achieved by Annotations 
 * 
 * @author srayabar
 */
public class MarkerInterfacesMain extends A	{

	public static void main(String[] args) {

		MarkerInterfacesMain a = new MarkerInterfacesMain();
		B b = new B();

		try {
			a.m1(); // Calling m1() and will print
			b.m1();
		} catch (MyException e) {
			System.out.println(e);
		}
	}
}

//marker interface
interface Marker {
}

class MyException extends Exception {
	public MyException(String s) {
		super(s);
	}
}

//A is proving the behavior for Marker interface
class A implements Marker {
	void m1() throws MyException {
		if ((this instanceof Marker)) {
			System.out.println("successfull");
		} else {
			throw new MyException("Unsuccessful  class must implement interface Marker ");
		}
	}
}

/*
 * Class B has not implemented Maker interface . will not work & print
 * unsuccessful Must implement interface Marker
 */
class B extends A {

}