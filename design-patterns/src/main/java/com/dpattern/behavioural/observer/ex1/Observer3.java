package com.dpattern.behavioural.observer.ex1;

public class Observer3 extends Observer {

    public Observer3(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
        System.out.println("Adding Observer1 " + this.getClass().getSimpleName());
    }

    @Override
    public void update() {
        System.out.println("Observer3 is updated with.." + this.subject.getState());
    }

}