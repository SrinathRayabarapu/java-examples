package com.core.threads;

/**
 * practice on Callable interface
 *
 * @author Srinath.Rayabarapu
 */
public class CallableMain {

    public static void main(String[] args) {
        // Thread class doesn't have any constructors for Callable Interfaces
//        new Thread(new MyCallable());

        Runnable runnable = () -> new MyCallable();
        runnable.run();

    }

}