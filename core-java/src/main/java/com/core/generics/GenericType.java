package com.core.generics;

/**
 * T is a type parameter which will be replaced by a real object
 */
public class GenericType<T> {

	T ob;
	
	public GenericType(T o) {
		ob = o;
	}
	
	T getOb() {
		return ob;
	}
	
	void showType() {
		System.out.println("Type of T is " + ob.getClass().getName());
	}
	
}
