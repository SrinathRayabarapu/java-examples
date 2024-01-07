package com.core.memory;

import javassist.CannotCompileException;
import javassist.ClassPool;

/**
 * ways to create OOMError through Object and Class metadata creation
 *
 * @author Srinath.Rayabarapu
 */
public class HeapSpaceMain {

    static ClassPool classPool = ClassPool.getDefault();

    public static void main(String[] args) throws CannotCompileException {

        // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
//        Integer[] intArray = new Integer[100000000 * 100000000];

        for (int i = 0; i < 100000000 * 100000000; i++) {
            Class c = classPool.makeClass("com.saket.demo.Metaspace" + i).toClass();
//            System.out.println(c);
        }

    }

}