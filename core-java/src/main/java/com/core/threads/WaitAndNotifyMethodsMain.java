package com.core.threads;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * https://www.youtube.com/watch?v=gx_YUORX5vk
 */
public class WaitAndNotifyMethodsMain {

    public static void main(String[] args) throws InterruptedException {

        WaitAndWaitProcessor processor = new WaitAndWaitProcessor();

        Thread t1 = new Thread(() -> {
            try {
                processor.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                processor.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

}

@Slf4j
class WaitAndWaitProcessor {

    public void produce() throws InterruptedException {
        //
        synchronized (this) {
            log.info("Producer thread running..");
            wait(); // gives intrinsic lock on monitor to other threads which needed
            log.info("Producer thread resumed!");
        }
    }

    public void consume() throws InterruptedException{

        log.info("Consumer thread running..");
        Thread.sleep(2000);

        synchronized (this) { // thread will get the object monitor intrinsic lock
            log.info("Please enter any key");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            log.info("Key pressed");
            notify(); // notifies one thread(arbitrarily) which can try to get the monitor lock
            Thread.sleep(5000);
        } // but once the current thread completes the synchronized block execution only then the lock is relinquished
    }

}