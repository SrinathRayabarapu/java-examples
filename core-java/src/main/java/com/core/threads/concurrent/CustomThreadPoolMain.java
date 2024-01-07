package com.core.threads.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * class to demo custom thread pool to cache and return threads
 * <p>
 * http://www.makeinjava.com/custom-thread-pool-example-without-using-executor-framework/
 *
 * @author Srinath.Rayabarapu
 */
public class CustomThreadPoolMain {

    private BlockingQueue<Runnable> queue;

    public static void main(String[] args) {

        CustomThreadPoolMain threadPool = new CustomThreadPoolMain(2, 4);

        //create 7 tasks and submit to pool
        for (int taskNumber = 0; taskNumber < 7; taskNumber++) {
            try {
                threadPool.submitTask(new TestTask(taskNumber));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public CustomThreadPoolMain(int queueSize, int numberOfThreads) {

        System.out.println("Creating CustomThreadPoolMain with QueueSize : " + queueSize + ", Number of Threads : " + numberOfThreads);
        this.queue = new LinkedBlockingDeque<>(queueSize);
        String threadName = null;
        TaskExecutor task = null;

        for (int count = 0; count < numberOfThreads; count++) {
            threadName = "Thread-" + count;
            task = new TaskExecutor(this.queue);
            Thread thread = new Thread(task, threadName);
            thread.start();
        }

    }

    public void submitTask(Runnable task) throws InterruptedException {
        System.out.println("Submitting task : " + task);
        this.queue.put(task);
    }

}