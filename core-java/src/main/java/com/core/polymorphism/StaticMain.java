package com.core.polymorphism;

import java.util.HashMap;

public class StaticMain {

    public static void main(String[] args) {
        new StaticVariableClass().setValue("a", "A");
        System.out.println(new StaticVariableClass().getValue("a"));

        System.out.println(getString().hashCode());
        System.out.println(getString().hashCode());
        System.out.println(getString().hashCode());
        System.out.println(getString().hashCode());
        System.out.println(getString().hashCode());
    }

    public static String getString(){
        return new String("abc");
    }

}

class StaticVariableClass{
    private static HashMap<String, String> map = new HashMap<>();

    public static String getValue(String key) {
        return map.get(key);
    }

    public static void setValue(String key, String value) {
        map.put(key, value);
    }
}