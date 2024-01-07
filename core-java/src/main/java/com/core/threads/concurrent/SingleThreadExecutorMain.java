package com.core.threads.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Allows sequential execution of threads with a single worker thread.
 *
 * @author Srinath.Rayabarapu
 */
public class SingleThreadExecutorMain {

    public static void main(String[] args) {

        // cann't alter threads pool size - it's always 1
        ExecutorService service = Executors.newSingleThreadExecutor();

        for (int i = 1; i <= 10; i++) {
            service.submit(new TestTask(i));
        }

        service.shutdown();
    }

}