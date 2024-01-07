package com.core.threads.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CachedThreadPool: Threads are cached / reused / created on-demand if not sufficient available. Ideal for
 * many short lived threads/async tasks. Threads will be removed from cache after 60 seconds if they are not
 * used. So that pool performance is maintained.
 *
 * @author Srinath.Rayabarapu
 */
public class CachedThreadPoolExecutorMain {

    public static void main(String[] args) {

        // read javadoc
        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            service.execute(new TestTask(i));
        }

        service.shutdown();

    }

}

