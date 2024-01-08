package com.dpattern.behavioural.observer.ex2;

public interface IObservable {

    void addObserver(IObserver observer);

    void removeObserver(IObserver observer);

    void notifyObserver();

    void setData(int data);
}
