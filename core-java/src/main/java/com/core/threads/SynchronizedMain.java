package com.core.threads;

/**
 * Demonstrates synchronized methods and synchronized blocks in Java.
 * 
 * <p>Synchronization is a mechanism that ensures only one thread can access
 * a shared resource at a time, preventing race conditions and data corruption.</p>
 * 
 * <h3>Types of Synchronization:</h3>
 * 
 * <h4>1. Synchronized Methods</h4>
 * <ul>
 *   <li>Acquires the intrinsic lock on the object instance (for instance methods)</li>
 *   <li>Acquires the lock on the Class object (for static methods)</li>
 *   <li>Other synchronized methods on the same object must wait</li>
 *   <li>Syntax: {@code public synchronized void method() { ... }}</li>
 * </ul>
 * 
 * <h4>2. Synchronized Blocks</h4>
 * <ul>
 *   <li>More flexible - can synchronize on any object</li>
 *   <li>Only the block is synchronized, not the entire method</li>
 *   <li>Allows finer-grained control over locking</li>
 *   <li>Syntax: {@code synchronized(lockObject) { ... }}</li>
 * </ul>
 * 
 * <h3>Key Difference:</h3>
 * <p>{@code synchronized(this)} is equivalent to a synchronized instance method.
 * Using separate lock objects allows multiple threads to access different
 * synchronized blocks in the same class simultaneously.</p>
 *
 * @author Srinath.Rayabarapu
 * @see java.util.concurrent.locks.ReentrantLock
 */
public class SynchronizedMain {

    /**
     * Demonstrates synchronized methods vs synchronized blocks with different lock objects.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        //TODO - test synchronized instance methods, static methods and other scenarios with multiple threads
        final SynchronizedMethodsClass c = new SynchronizedMethodsClass();
        Thread t1 = new Thread(() -> c.incrementer());
        t1.start();

        Thread t2 = new Thread(() -> c.decrementer());
        t2.start();
    }
}

/**
 * Helper class demonstrating synchronized methods and blocks.
 * 
 * <p>This class shows the difference between:</p>
 * <ul>
 *   <li>Synchronizing on a specific lock object</li>
 *   <li>Using a synchronized method (equivalent to synchronizing on 'this')</li>
 * </ul>
 */
class SynchronizedMethodsClass {
    /** Counter variable shared between threads. */
    int counter;
    
    /** Private lock object for incrementer method. */
    private Object lock1 = new Object();
    
    /** Reserved for future use - demonstrates multiple lock objects pattern. */
    private Object lock2 = new Object();

    /**
     * Synchronized block using a specific lock object.
     * 
     * <p>Using {@code lock1} instead of {@code this} allows the {@code decrementer()}
     * method to run concurrently since they don't compete for the same lock.</p>
     * 
     * <p>Note: Using {@code synchronized(this)} would be equivalent to making
     * this entire method synchronized.</p>
     */
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

    /**
     * Synchronized method that decrements the counter.
     * 
     * <p>This method acquires the intrinsic lock on {@code this} object.
     * It can run concurrently with {@code incrementer()} because
     * {@code incrementer()} uses a different lock object.</p>
     */
    public synchronized void decrementer() {
        while (true) {
            counter--;
            System.out.println("Counter in Decrementer :" + counter);
            if (counter == -100)
                break;
        }
    }
}