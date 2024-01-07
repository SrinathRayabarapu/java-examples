package com.core.classes;

import com.core.classes.InterfaceInClass.Interface1;

public class InterfaceInClassMain implements Interface1 {

	@Override
	public void print() {
		System.out
				.println("Printing from Inside class Interface implementation!");
	}

	public static void main(String[] args) {
		InterfaceInClassMain.DefaultConstructor().print();
	}

	public static InterfaceInClassMain DefaultConstructor() {
		return new InterfaceInClassMain();
	}

}
