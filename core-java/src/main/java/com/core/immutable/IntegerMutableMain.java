package com.core.immutable;

import static java.lang.Thread.sleep;

public class IntegerMutableMain {

    public static void main(String[] args) {

        int number = 10;

        new Thread(new MutableThread(number)).start();

        // it doesn't print modified string
        new Thread(new ImmutableThread(number)).start();

    }

    static class MutableThread implements Runnable {

        int number;
        MutableThread(int input){
            number = input;
        }
        @Override
        public void run() {
            number += 10;
            while (true) {
                System.out.println("MutableThread : " + number);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    static class ImmutableThread implements Runnable {

        int number;
        ImmutableThread(int input){
            number = input;
        }
        @Override
        public void run() {
            while (true) {
                System.out.println("ImmutableThread : " + number);
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
