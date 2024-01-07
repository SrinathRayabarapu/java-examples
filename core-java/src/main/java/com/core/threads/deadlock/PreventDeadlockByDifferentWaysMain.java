package com.core.threads.deadlock;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * class to demo different ways of acquiring locks without leading to deadlock
 *
 * @author Srinath.Rayabarapu
 */
public class PreventDeadlockByDifferentWaysMain {

    public static void main(String[] args) {

        try {

            Lock lock = new ReentrantLock();
            boolean isLocked = lock.tryLock(2, TimeUnit.SECONDS);
            if(isLocked){
                System.out.println("Successfully obtained lock!");
            }

            BlockingQueue queue = new ArrayBlockingQueue(10);
            queue.poll(2, TimeUnit.SECONDS);

            Semaphore semaphore = new Semaphore(1);
            semaphore.tryAcquire(2, TimeUnit.SECONDS);

            ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
            executorService.schedule(() -> { /* some task */}, 10, TimeUnit.SECONDS );

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
