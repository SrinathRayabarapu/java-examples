package com.core.threads.racecondition;

public class ConsumerThread implements Runnable {

    private String name;

    public ConsumerThread(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println("Running : " + getName());
        SharedResource instance = SharedResource.getInstance();
        System.out.println(instance.toString());
    }
}