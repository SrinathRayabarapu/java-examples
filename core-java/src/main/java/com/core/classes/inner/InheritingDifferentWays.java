package com.core.classes.inner;

/**
 * another way of inheriting class - implementing inner classes
 *
 * @author Srinath.Rayabarapu
 */
class SomeClass {
    static int a = 10;
    void print(){
        System.out.println("printing in A");
    }
}

public class InheritingDifferentWays{
    void methodA(){
        new SomeClass() {
            @Override
            void print() {
                System.out.println("printing in B");
            }
            // local scope - can only be called locally or like below
            void print1(){
                System.out.println("print1");
            }
        }.print1(); //can be accessed like this only
    }
}