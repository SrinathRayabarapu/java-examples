package com.core.java8.concurrent;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

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


        runAsync();

        runSupplyAsync();

        runSupplyAsyncWithExecutor();

        thenCompose();

        thenCombine();

        // allOf();

        // anyOf();

        exceptionally();

    }

    private static void exceptionally() {
        CompletableFuture<Integer> exceptionCompletable = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("Something unexpected happend!");
        });

        CompletableFuture<Integer> exceptionally = exceptionCompletable.exceptionally(exception -> {
            System.out.println("Handing exception : " + exception);
            return -1;
        });

        try {
            System.out.println("Exceptional outcome " + exceptionally.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }

    private static void thenCombine() {
        CompletableFuture<Integer> getHeight = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> getWeight = CompletableFuture.supplyAsync(() -> 20);

        CompletableFuture<Integer> bmi = getHeight.thenCombine(getWeight, (height, weight) -> height * weight);
        try {
            System.out.println("thenCombine() : " + bmi.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private static void thenCompose() {
        CompletableFuture<Integer> getRadius = CompletableFuture.supplyAsync(() -> 10);

        // one completable future depending on the other - chaining
        CompletableFuture<Double> getArea = getRadius.thenCompose(radius -> CompletableFuture.supplyAsync(() -> Math.PI * radius * radius));
        try {
            System.out.println("Area of the Circle using thenCompose(): " + getArea.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private static void runSupplyAsyncWithExecutor() {

        Supplier<String> supplier = () -> {
            System.out.println(Thread.currentThread().getName());
            return "I'm not accepting any value but returning a value. Since I'm a Supplier!!";
        };

        ExecutorService executorService = Executors.newFixedThreadPool(1);

        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(supplier, executorService);
        try {
            String returnedValue = stringCompletableFuture.get(); //blocking call
            System.out.println(returnedValue);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();
        }

    }

    private static void runSupplyAsync() {

        Supplier<String> supplier = () -> {
            System.out.println(Thread.currentThread().getName());
            return "I'm not accepting any value but returning a value. Since I'm a Supplier!!";
        };

        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(supplier);
        try {
            String returnedValue = stringCompletableFuture.get(); //blocking call
            System.out.println(returnedValue);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }

    private static void runAsync() {

        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("I'm just printing something and not returning any since I'm runAsync method!!");
        };

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(runnable);
        try {
            voidCompletableFuture.get(); // blocking call
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
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

    long calculateDaysBetweenDates(String startDate, String endDate) {
        startDate = "2020-01-01";
        endDate = "2020-01-02";
        Duration duration = Duration.between(java.time.LocalDate.parse(startDate).atStartOfDay(), java.time.LocalDate.parse(endDate).atStartOfDay());
        return duration.toDays();
    }

}