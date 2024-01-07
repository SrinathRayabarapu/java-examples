package com.core.immutable;

/**
 * program to check different immutability scenarios
 * 1. primitive types - java passes primitives by value
 * 2. objects - java passes objects by reference
 *
 * @author Srinath.Rayabarapu
 *
 */
public class CheckImmutabilityMain {

    public static void main(String[] args) {
        CheckImmutabilityMain demo = new CheckImmutabilityMain();
        demo.checkIntegerImmutability();
        System.out.println("-------------------");
        demo.checkStringImmutability();
        System.out.println("-------------------");
        checkObjectImmutability();
    }

    private void checkIntegerImmutability() {

//        int one = 1;
        Integer one = new Integer(1);
        System.out.println("One--> " + one);
//        int two = one;
        Integer two = one;
        System.out.println("One is changed to 2");
        one = new Integer(2);

        System.out.println("Modified one--> " + one);
        System.out.println("two--> " + two);
        System.out.println("Integers sensitive to changes, hence they are mutable");
    }

    private void checkStringImmutability() {

        String a = "A";
        System.out.println("a--> " + a);
        String b = a;
        System.out.println("Assigned a to b");
        a = "AB";

        System.out.println("Modified a--> " + a);
        System.out.println("b--> " + b);
        System.out.println("Strings are not sensitive to changes, hence they are immutable");
    }

    private static void checkObjectImmutability() {
        A a = new A(11, "srinath");
        A b = a;
        a.i++;
        a.a = "shubha";
        System.out.println(a);
        System.out.println(b);
    }

}

class A {
    int i;
    String a;

    A(int ii, String aa) {
        this.i = ii;
        this.a = aa;
    }

    @Override
    public String toString() {
        return "i value is " + i + " and a value is " + a;
    }
}
