package com.core.java8.lambda;

public class SimpleLambda {

    public static void main(String[] args) {
        new Thread(() -> System.out.println("Hey i'm from a Lambda!!")).start();
    }

}
