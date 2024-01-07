package com.core.threads.communication;

/**
 * print odd and even numbers sequence with three threads
 * <p>
 * #cisco
 *
 * @author Srinath.Rayabarapu
 */
public class OddEvenNumberSequenceThreeThreadsMain {

    private static volatile int count = 1;
    private static volatile int threadIdToRun = 1;
    private static Object monitor = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(new Printer(1));
        Thread t2 = new Thread(new Printer(2));
        Thread t3 = new Thread(new Printer(3));
        t1.start();
        t2.start();
        t3.start();
    }

    static class Printer implements Runnable {
        private int threadId;

        public Printer(int i) {
            this.threadId = i;
        }

        @Override
        public void run() {

            try {
                while (count <= 20) {
                    synchronized (monitor) {
                        if (threadId != threadIdToRun) {
                            monitor.wait();
                        } else {
                            System.out.println("Thread " + threadId + ", printed " + count);
                            count += 1;

                            if (threadId == 1 || threadId == 2) {
                                threadIdToRun = threadIdToRun + 1;
                            } else {
                                threadIdToRun = 1;
                            }
                            monitor.notifyAll();

                            Thread.sleep(1000);
                        }
                    }
                }
            } catch (Exception e) {

            }

        }
    }

}
