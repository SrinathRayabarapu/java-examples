package com.dpattern.creational.singleton;

import lombok.extern.slf4j.Slf4j;

import javax.management.RuntimeErrorException;

/**
 * Refined above approach to allow - static block initializing and having a way to handle exceptions
 * Still not lazy loading way
 * <p>
 * Breakable with Reflection
 */
@Slf4j
public class SingletonEager {

    // will be called as and when class loader loads this class - there can be a chance of creating multiple objects
    // if there is a race condition in class loader
    private static SingletonEager singletonEager = new SingletonEager();

    private SingletonEager() {
        // to make sure this is not called more than once
        if (singletonEager != null) {
            throw new RuntimeErrorException(null, "Can not create a new instance, please call getInstance() method");
        }
    }

    public static SingletonEager getInstance() {
        return singletonEager;
    }
}
