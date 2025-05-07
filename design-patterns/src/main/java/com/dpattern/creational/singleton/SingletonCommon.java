package com.dpattern.creational.singleton;

import lombok.extern.slf4j.Slf4j;

import javax.management.RuntimeErrorException;
import java.io.Serializable;

/**
 * common solution - private constructor creates singletonCommon object
 */
@Slf4j
public class SingletonCommon implements Serializable, Cloneable {

    private static SingletonCommon singletonCommon = null;

    //private constructor methods will only be called by class loader
    private SingletonCommon() {
        if (singletonCommon != null) {
            // this avoids to create instance thru Reflection
            throw new RuntimeErrorException(null, "Can not create a new instance, please call getInstance() method");
        }
        log.info("Creating..");
    }

    //only global point of access
    public static SingletonCommon getInstance() {
        if (singletonCommon == null) {
            singletonCommon = new SingletonCommon(); //lazy approach
        }
        return singletonCommon;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
