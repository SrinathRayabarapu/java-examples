package com.core.threads;

/**
 * class to demo synchronized methods<br>
 * <p>
 * synchronized methods - would require intrinsic lock on the Class itself, meaning other synchronized blocks will
 * wait till the first thread comes out of any synchronized method in the class<br>
 * <p>
 * synchronized blocks - don't require an intrinsic lock, rather depends on a passed object lock. This will not stop
 * other threads to access any synchronized blocks in the same class.
 *
 * @author Srinath.Rayabarapu
 */
public class SynchronizedMain {

    public static void main(String[] args) {

        //TODO - test synchronized instance methods, static methods and other scenarios with multiple threads
        final SynchronizedMethodsClass c = new SynchronizedMethodsClass();
        Thread t1 = new Thread(() -> c.incrementer());
        t1.start();

        Thread t2 = new Thread(() -> c.decrementer());
        t2.start();
    }
}

class SynchronizedMethodsClass {
    int counter;
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void incrementer() {

        //'this' in synchronized block is as good as synchronized method
        //synchronized (this) {

        synchronized (lock1) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void decrementer() {
        while (true) {
            counter--;
            System.out.println("Counter in Decrementer :" + counter);
            if (counter == -100)
                break;
        }
    }
}