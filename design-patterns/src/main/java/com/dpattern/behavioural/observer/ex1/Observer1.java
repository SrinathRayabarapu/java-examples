package com.dpattern.behavioural.observer.ex1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Observer1 extends Observer {

    public Observer1(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
        log.info("Adding Observer1 {}", this.getClass().getSimpleName());
    }

    @Override
    public void update() {
        log.info("Observer1 is updated with..{}", this.subject.getState());
    }

}
