package com.core.java8.lambda;

public class MathOperationFunctionalInterfaceMain {
    public static void main(String[] args) {
        // interface can be used for multiplication
        MathOperationFunctionalInterface multiplyInterface = (a, b) -> System.out.println(a * b);
        multiplyInterface.operation(4,5);

        // same can be used for addition
        MathOperationFunctionalInterface addInterface = (a, b) -> System.out.println(a + b);
        addInterface.operation(4,5);
    }
}