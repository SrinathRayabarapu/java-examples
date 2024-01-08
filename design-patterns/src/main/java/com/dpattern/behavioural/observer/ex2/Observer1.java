package com.dpattern.behavioural.observer.ex2;

public class Observer1 implements IObserver{

    @Override
    public void update(int data) {
        System.out.println("Observer1 is notified with data: " + data);
    }

}
