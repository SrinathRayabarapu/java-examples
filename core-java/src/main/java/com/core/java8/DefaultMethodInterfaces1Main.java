package com.core.java8;

/**
 * shows how to override methods in case of conflict from multiple interfaces
 *
 * default methods supports backward compatibility
 * 1. can have more than one default method
 *
 * https://jrebel.com/rebellabs/java-8-explained-default-methods/
 * https://howtodoinjava.com/java8/default-methods-in-java-8/
 *
 * @author Srinath.Rayabarapu
 */
public class DefaultMethodInterfaces1Main implements IDefaultInterface1, IDefaultInterface2 {
	
	public static void main(String[] args) {
		new DefaultMethodInterfaces1Main().printMe();
		new DefaultMethodInterfaces1Main().printMe("srinath");
	}

	/*
	 * method available in both interfaces hence conflict and need to specify explicitly
	 */
	@Override
	public void printMe() {
		IDefaultInterface1.super.printMe();
	}

	@Override
	public void printMe(String str) {
		IDefaultInterface2.super.printMe(str);
	}

}

/**
 * an interface can have multiple default interfaces
 */
interface IDefaultInterface1 {
	
	default void printMe() {
		System.out.println("IDefaultInterface1 - defaultMethod()");
	}

	default void printMe(String str){
		System.out.println("IDefaultInterface1 - defaultMethod(str) : " + str);
	}

}

interface IDefaultInterface2 {

	default void printMe() {
		System.out.println("IDefaultInterface2 - defaultMethod()");
	}

	default void printMe(String str){
		System.out.println("IDefaultInterface2 - defaultMethod(str) : " + str);
	}

}