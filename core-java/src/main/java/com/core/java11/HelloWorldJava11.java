package com.core.java11;

public class HelloWorldJava11 {

    public static void main(String[] args) {
        System.out.println("Hello Java 11!");

        var chant = " India!!         ";

        System.out.println("chant repeating 3 times : " + chant.repeat(3));
        System.out.println(chant.isBlank());
        System.out.println(chant.strip());
        System.out.println(chant.trim());
    }

}
