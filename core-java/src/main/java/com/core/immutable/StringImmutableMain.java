package com.core.immutable;

/**
 * https://www.scientecheasy.com/2020/05/java-immutable-string.html/
 */
public class StringImmutableMain {

    public static void main(String[] args) {
        String str = "hello";
        str.concat("world!");
        System.out.println(str); //original string is not modified
    }

}
