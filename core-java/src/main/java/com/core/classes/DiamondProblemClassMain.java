package com.core.classes;

/**
 * class to demo diamond problem variations
 *
 * @author Srinath.Rayabarapu
 */
public class DiamondProblemClassMain extends Interface1 implements Interface2 {

    @Override
    public void method1() {
        System.out.println("printing from Overriding class");
    }

    public static void main(String[] args) {
        // demonstrating diamond problem with interfaces and abstract classes
        Interface1 aClass = new DiamondProblemClassMain();
        aClass.method1();
    }

}
