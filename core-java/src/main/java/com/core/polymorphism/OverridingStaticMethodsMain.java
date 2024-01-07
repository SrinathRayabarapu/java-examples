package com.core.polymorphism;

import com.util.LogUtil;

/**
 * static methods overriding - since static methods are initialized with class, base class method can only
 * hides static method but not overrides it.
 *
 * Overriding:
 * If a subclass provides a specific implementation of a method that is already provided by its parent class,
 * it is known as Method Overriding. The parameters must be same in case of overriding.
 *
 * @author Srinath.Rayabarapu
 */
public class OverridingStaticMethodsMain {

    public static void main(String[] args) {

        Super superObj = new Super();
        superObj.printMe();

        superObj = new Base();
        superObj.printMe();

        Base base = new Base();
        base.printMe();
    }
}

class Super {
    public static void printMe() {
        LogUtil.info("Super class print method called.");
    }
}

class Base extends Super {
    public static void printMe() {
        LogUtil.info("Base class print method called.");
    }
}