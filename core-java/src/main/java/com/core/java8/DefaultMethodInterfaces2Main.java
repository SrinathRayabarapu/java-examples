package com.core.java8;

/**
 * shows how methods will be accessed if there inheritance across two interfaces
 *
 * default methods supports backward compatibility
 * 1. can have more than one default method
 *
 * https://jrebel.com/rebellabs/java-8-explained-default-methods/
 * https://howtodoinjava.com/java8/default-methods-in-java-8/
 *
 * @author Srinath.Rayabarapu
 */
public class DefaultMethodInterfaces2Main implements IDefaultInterface3{

    public static void main(String[] args) {
        new DefaultMethodInterfaces2Main().print();
    }

    private void print() {
        printMe(); // would print IDefaultInterface3 method as it's closer
    }

}

/**
 * interface inheritance
 */
interface IDefaultInterface3 extends IDefaultInterface1{

    default void printMe() {
        System.out.println("IDefaultInterface3 - defaultMethod()");
    }

    default void printMe(String str){
        System.out.println("IDefaultInterface3 - defaultMethod(str) : " + str);
    }

}