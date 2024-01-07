package com.core.threads.concurrent;

/**
 * a way to call interrupt() on a thread and handling it inside run() method
 */
public class ThreadInterruptedMain {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("MyThread started");

        Thread.sleep(1);

        // not safe to use and we don't have a way to handle/rollback the operations in run method
//        myThread.stop();

        myThread.interrupt();
    }

}

class MyThread extends Thread{
    @Override
    public void run() {

        for (;;){
            System.out.println("Running an infinite loop..");

            // interrupted can be handled!
            if(interrupted()){
                System.out.println("Thread is interrupted, gracefully handling the exit!");
                break;
            }

            // can be used in Runnable implementation
//            Thread.interrupted()

        }

    }
}