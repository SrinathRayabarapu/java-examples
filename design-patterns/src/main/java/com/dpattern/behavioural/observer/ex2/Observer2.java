package com.dpattern.behavioural.observer.ex2;

public class Observer2 implements IObserver{

    @Override
    public void update(int data) {
        System.out.println("Observer2 is notified with data: " + data);
    }

}
