package com.core.java8.concurrent;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

/**
 * Demonstrates Java 8 CompletableFuture for asynchronous programming.
 * 
 * <p>CompletableFuture represents a future result of an asynchronous computation.
 * It provides a powerful way to write non-blocking, asynchronous code that can
 * be composed and combined.</p>
 * 
 * <h3>Key Features Demonstrated:</h3>
 * <ul>
 *   <li><b>runAsync()</b> - Run async task without return value (Runnable)</li>
 *   <li><b>supplyAsync()</b> - Run async task with return value (Supplier)</li>
 *   <li><b>thenApply()</b> - Transform the result (synchronous)</li>
 *   <li><b>thenApplyAsync()</b> - Transform the result (asynchronous)</li>
 *   <li><b>thenAccept()</b> - Consume the result (no return value)</li>
 *   <li><b>thenCompose()</b> - Chain dependent CompletableFutures (flatMap equivalent)</li>
 *   <li><b>thenCombine()</b> - Combine two independent CompletableFutures</li>
 *   <li><b>exceptionally()</b> - Handle exceptions in the async pipeline</li>
 * </ul>
 * 
 * <h3>Thread Pool Usage:</h3>
 * <ul>
 *   <li>By default, uses ForkJoinPool.commonPool()</li>
 *   <li>Can provide custom ExecutorService for better control</li>
 * </ul>
 * 
 * <h3>Blocking vs Non-Blocking:</h3>
 * <ul>
 *   <li>{@code get()} - Blocking call, waits for result</li>
 *   <li>{@code thenAccept()} - Non-blocking, executes callback when complete</li>
 * </ul>
 * 
 * @author Srinath.Rayabarapu
 * @see java.util.concurrent.CompletableFuture
 * @see java.util.concurrent.ExecutorService
 */
public class CompletableFutureMain {

    /**
     * Main method demonstrating various CompletableFuture operations.
     *
     * @param args command-line arguments (not used)
     */
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

    /**
     * Demonstrates exception handling with {@code exceptionally()}.
     * 
     * <p>The {@code exceptionally()} method provides a way to handle exceptions
     * that occur during async execution and return a fallback value.</p>
     */
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

    /**
     * Demonstrates combining two independent CompletableFutures with {@code thenCombine()}.
     * 
     * <p>Use {@code thenCombine()} when you have two independent async operations
     * and want to combine their results when both complete.</p>
     */
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

    /**
     * Demonstrates chaining dependent CompletableFutures with {@code thenCompose()}.
     * 
     * <p>Use {@code thenCompose()} when the second async operation depends on
     * the result of the first (similar to flatMap in streams).</p>
     */
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

    /**
     * Demonstrates {@code supplyAsync()} with a custom ExecutorService.
     * 
     * <p>Using a custom executor provides better control over thread pool
     * configuration and resource management.</p>
     */
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

    /**
     * Demonstrates {@code supplyAsync()} for async computation with return value.
     * 
     * <p>Uses the default ForkJoinPool.commonPool() for execution.</p>
     */
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

    /**
     * Demonstrates {@code runAsync()} for fire-and-forget async tasks.
     * 
     * <p>Use when you need to run an async task but don't need a return value.</p>
     */
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

    /**
     * Demonstrates the basic form of CompletableFuture with manual completion.
     *
     * @throws InterruptedException if the thread is interrupted while waiting
     * @throws ExecutionException if the computation threw an exception
     */
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

    /**
     * Demonstrates exception propagation in chained async operations.
     * 
     * <p>When an exception occurs in the chain, subsequent stages are skipped
     * and the exception propagates to the end.</p>
     *
     * @throws InterruptedException if the thread is interrupted while sleeping
     */
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

    /**
     * Demonstrates chaining multiple async operations.
     * 
     * <p>Shows how to chain {@code supplyAsync()}, {@code thenApplyAsync()},
     * {@code thenApply()}, and {@code thenAccept()} to build a processing pipeline.</p>
     *
     * @throws InterruptedException if the thread is interrupted while sleeping
     */
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

    /**
     * Calculates the number of days between two dates.
     *
     * @param startDate the start date in ISO format (yyyy-MM-dd)
     * @param endDate the end date in ISO format (yyyy-MM-dd)
     * @return the number of days between the two dates
     */
    long calculateDaysBetweenDates(String startDate, String endDate) {
        startDate = "2020-01-01";
        endDate = "2020-01-02";
        Duration duration = Duration.between(java.time.LocalDate.parse(startDate).atStartOfDay(), java.time.LocalDate.parse(endDate).atStartOfDay());
        return duration.toDays();
    }

}