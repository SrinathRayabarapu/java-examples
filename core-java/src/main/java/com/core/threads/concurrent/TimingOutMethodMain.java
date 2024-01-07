package com.core.threads.concurrent;

import java.util.concurrent.*;

/**
 * Timing out a method using ExecutorPool class
 *
 * @author srinathrayabarapu
 */
public class TimingOutMethodMain {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        Callable<Object> task = new Callable<Object>() {
            public Object call() {
                try {
                    Thread.sleep(6000); //doing some operation which takes more than 5 sec time
                } catch (InterruptedException e) {
                    //ignore
                }
                return null;
            }
        };
        Future<Object> future = executor.submit(task);
        try {
            Object result = future.get(5, TimeUnit.SECONDS); //method times out in 5 secs
        } catch (TimeoutException ex) {
            System.out.println("Timed Out!!");
            // handle the timeout
        } catch (InterruptedException e) {
            // handle the interrupts
        } catch (ExecutionException e) {
            // handle other exceptions
        } finally {
            future.cancel(true); // may or may not desire this
            executor.shutdown();
        }
    }

}
