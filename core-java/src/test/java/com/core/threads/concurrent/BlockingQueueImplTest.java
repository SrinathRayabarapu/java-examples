package com.core.threads.concurrent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BlockingQueueImplTest {

    BlockingQueueImpl<String> blockingQueue;

    @BeforeEach
    void setUp() {
        blockingQueue = new BlockingQueueImpl<>(3);
    }

    @Test
    void testBlockingQueue() throws InterruptedException {

        Runnable runnable1 = () -> {
            int counter = 0;
            while(counter < 5){
                try {
                    System.out.println("Enqueuing :: " + "name-"+ counter);
                    blockingQueue.enqueue("name:"+ counter);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter++;
            }
        };

        Runnable runnable2 = () -> {
            int counter = 0;
            while(counter < 5){
                try {
                    System.out.println("Dequeuing :: " + blockingQueue.dequeue());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter++;
            }
        };

        Thread t1 = new Thread(runnable1);
        Thread t2 = new Thread(runnable2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

}