package com.core.threads.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledThreadPool usage
 *
 * @author Srinath.Rayabarapu
 */
public class ScheduledThreadPoolExecutorMain {

    public static void main(String[] args) {

        ScheduledExecutorService service = Executors.newScheduledThreadPool(3);

        for (int i = 0; i < 10; i++) {
            // Creates and executes a one-shot action that becomes enabled after the given delay.
            service.schedule(new TestTask(i), 2, TimeUnit.SECONDS);
        }

        for (int i = 0; i < 5; i++) {
            // read javadoc
            service.scheduleAtFixedRate(new TestTask(i), 2, 4, TimeUnit.SECONDS);
        }

        service.shutdown();
    }

}
