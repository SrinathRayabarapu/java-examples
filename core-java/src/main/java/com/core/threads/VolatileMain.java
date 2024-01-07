package com.core.threads;

/**
 * volatile is used to flag a variable which can be applied to multiple threads
 * <p>
 * idea - volatile keyword for a variable makes sure that the multiple threads doesn't cache the variable and
 * every time they read full value from disk. Useful for flags across threads.
 * <p>
 * https://dzone.com/articles/java-volatile-keyword-0
 *
 * @author Srinath.Rayabarapu
 */
public class VolatileMain {

    private static volatile int GLOBAL_INT = 0;

    public static void main(String[] args) {
        new ChangeListener().start();
        new ChangeMaker().start();
    }

    private static class ChangeListener extends Thread {
        @Override
        public void run() {
            int local = GLOBAL_INT;
            while (local < 5) {
                if (local != GLOBAL_INT) {
                    System.out.println("Got change for GLOBAL_INT : " + GLOBAL_INT);
                    local = GLOBAL_INT;
                }
            }
        }
    }

    private static class ChangeMaker extends Thread {
        @Override
        public void run() {
            int local = GLOBAL_INT;
            while (GLOBAL_INT < 5) {
                System.out.println("Incrementing GLOBAL_INT : " + (local + 1));
                GLOBAL_INT = ++local;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
