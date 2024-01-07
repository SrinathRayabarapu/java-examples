package com.core.java8.lambda.suppliers;

import java.util.function.Supplier;

public class SupplierMain {

    public static void main(String[] args) {

        // Supplier takes nothing but returns a value
        Supplier<String> stringSupplier = () -> "Hey, it's from String Supplier";
        System.out.println("stringSupplier.get() = " + stringSupplier.get());

        Supplier<Double> randomDoubleSupplier = Math::random;
        System.out.println("randomDoubleSupplier.get() = " + randomDoubleSupplier.get());

    }

}
