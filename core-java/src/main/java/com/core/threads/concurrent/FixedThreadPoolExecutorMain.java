package com.core.threads.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Fixed thread pool with {@link TaskThread} class
 *
 * @author Srinath.Rayabarapu
 */
public class FixedThreadPoolExecutorMain {

    public static void main(String[] args) {

        // for CPU intensive operations - use below count
        int processorsCount = Runtime.getRuntime().availableProcessors();
        System.out.println("No. of processors available : " + processorsCount);
        // for I/O intensive operations(DB, N/W etc) - use higher count

        // we cann't alter the thread pool size
        ExecutorService service = Executors.newFixedThreadPool(4);

        // it can be altered here!
//        ThreadPoolExecutor service = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);

        TaskThread task;

        for (int i = 1; i <= 15; i++) {
            task = new TaskThread("Task" + i);
            System.out.println("New task added : " + task.getName());
            service.execute(task); // submitting runnable
        }
        System.out.println("All tasks are submitted");


        service.shutdown();
        try {
            service.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All tasks completed");
    }

}