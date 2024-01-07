package com.core.polymorphism;

/**
 * constructor creation and its overriding demo
 *
 * @author Srinath.Rayabarapu
 */
public class ConstructorOverloadingMain {
	public static void main(String[] args) {
		new ChildConst();
		new ChildConst("Valtech");
	}
}

class ParentConst {
	public ParentConst(String s) {
		System.out.println("Parent constructor called..." + s);
	}
}

class ChildConst extends ParentConst {
	public ChildConst() {
		// since there is no default constructor in parent, calling this is mandatory
		super("srinath");
		System.out.println("Child constructor called...");
	}

	public ChildConst(String s) {
		super(s);
		System.out.println("Child constructor called...");
	}
}