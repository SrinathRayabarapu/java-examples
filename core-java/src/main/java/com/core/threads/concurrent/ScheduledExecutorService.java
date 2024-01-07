package com.core.threads.concurrent;

import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorService {

    static int count = 0;

    public static void main(String[] args) {
        java.util.concurrent.ScheduledExecutorService timerService = Executors.newSingleThreadScheduledExecutor();
        timerService.scheduleAtFixedRate(() -> reportTimeElapse(), 2, 5, TimeUnit.SECONDS);
    }

    private static void reportTimeElapse()  {
//        try {
        if (count == 3) {
            count++;
            throw new RuntimeException();
        }

        System.out.println(Instant.now() + " : Time elapsed..");
        count++;
//        } catch (Exception e){
//            System.out.println("error - ignoring");
//        }
    }

}
