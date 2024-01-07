package com.core.binding;

public class BindingMain {

	public static void main(String[] args) {
		SuperClass superObjectOne = new SuperClass();
		SuperClass superObjectTwo = new SubClass();

		System.out.println(superObjectOne.message);
		System.out.println(superObjectTwo.message);

	}

}
