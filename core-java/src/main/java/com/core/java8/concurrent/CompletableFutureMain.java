package com.core.java8.concurrent;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * TODO - https://www.callicoder.com/java-8-completablefuture-tutorial/
 * https://www.youtube.com/watch?v=GJ5Tx43q6KM&ab_channel=JavaTechie
 *
 * @author Srinath.Rayabarapu
 */
public class CompletableFutureMain {

    public static void main(String[] args) {
        try {
//            basicForm();
//            chainOfActions();
            chainOfActionsWithExceptions();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void basicForm() throws InterruptedException, ExecutionException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        // below call is async
        /*completableFuture.thenAcceptAsync((result) -> {
            System.out.println(result);
        });*/
        completableFuture.complete("Done dona done!");
        String s = completableFuture.get(); // blocking call
        System.out.println(s);
//        Thread.sleep(1000);
    }

    long calculateDaysBetweenDates(String startDate, String endDate) {
        startDate = "2020-01-01";
        endDate = "2020-01-02";
        Duration duration = Duration.between(java.time.LocalDate.parse(startDate).atStartOfDay(),
                java.time.LocalDate.parse(endDate).atStartOfDay());
        return duration.toDays();
    }

    private static void chainOfActionsWithExceptions() throws InterruptedException {

        CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("first async exception");
        }).thenApplyAsync(result -> {
            return result + ", two";
        }).thenApply(result -> {
            return result + ", three";
        }).thenAccept(result -> {
            System.out.println(result);
        });

        Thread.sleep(2000);

    }

    private static void chainOfActions() throws InterruptedException {

        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000); //async call which takes 1 sec
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "one";
        }).thenApplyAsync(result -> {
            return result + ", two";
        }).thenApply(result -> {
            return result + ", three";
        }).thenAccept(result -> {
            System.out.println(result);
        });

        Thread.sleep(5000); //mimicking a running thread
    }

}