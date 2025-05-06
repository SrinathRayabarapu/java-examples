package com.dpattern.creational.singleton;

enum SingletonEnum {
    INSTANCE;

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}

/**
 * enum are inhenrently serializable. so serialization and reflection will not break this.
 */
public class SingletonPatternEnumMain {
    public static void main(String[] args) {
        SingletonEnum singletonEnum = SingletonEnum.INSTANCE;

        System.out.println(singletonEnum.getValue());
        singletonEnum.setValue(10);
        System.out.println(singletonEnum.getValue());
    }
}