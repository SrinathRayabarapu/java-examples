package com.dpattern.behavioural.observer.ex2;

import java.util.ArrayList;
import java.util.List;

public class Observable implements IObservable{

    private int data = 0;

    private final List<IObserver> observerList;

    public Observable() {
        this.observerList = new ArrayList<>();
    }

    @Override
    public void addObserver(IObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observerList.forEach(observer -> observer.update(data));
    }

    @Override
    public void setData(int data) {
        this.data = data;
        notifyObserver();
    }

}
