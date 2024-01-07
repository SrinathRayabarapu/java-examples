package com.core.threads;

import lombok.extern.slf4j.Slf4j;

/**
 * The ThreadLocal class in Java enables you to create variables that can only be read and written by the same
 * thread. Thus, even if two threads are executing the same code, and the code has a reference to a ThreadLocal
 * variable, then the two threads cannot see each other's ThreadLocal variables.
 * <p>
 * https://www.youtube.com/watch?v=sjMe9aecW_A&t=22s
 * http://tutorials.jenkov.com/java-concurrency/threadlocal.html
 *
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class ThreadLocalMain {

    public static void main(String[] args) throws Exception {

        LocalValueRunnable localValueRunnable = new LocalValueRunnable();
        // creating 2 threads with same localValueRunnable object is the key
        Thread t1 = new Thread(localValueRunnable);
        Thread t2 = new Thread(localValueRunnable);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        log.info("-----------------");

        ThreadLocalRunnable threadLocalRunnable = new ThreadLocalRunnable();
        // creating 2 threads with same threadLocalRunnable object is the key
        t1 = new Thread(threadLocalRunnable);
        t2 = new Thread(threadLocalRunnable);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

}

@Slf4j
class ThreadLocalRunnable implements Runnable {

    ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    @Override
    public void run() {
        int number = (int) (Math.random() * 100D);
        log.info("{} setting value : {}", Thread.currentThread().getName(), number);
        threadLocal.set(number); // each thread will set value separately but the values are maintained
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(Thread.currentThread().getName() + ":" + threadLocal.get());
    }

}

@Slf4j
class LocalValueRunnable implements Runnable {

    int localValue = 0;

    @Override
    public void run() {
        localValue = (int) (Math.random() * 100D);
        log.info("{} setting value : {}", Thread.currentThread().getName(), localValue);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(Thread.currentThread().getName() + ":" + localValue);
    }

}