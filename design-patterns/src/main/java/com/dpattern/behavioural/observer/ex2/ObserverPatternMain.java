package com.dpattern.behavioural.observer.ex2;

/**
 * Ex. problems are :
 * 1. Product Notify me feature in Amazon.
 * 2. Weather broadcasting feature.
 */
public class ObserverPatternMain {

    public static void main(String[] args) {

        IObservable observable = new Observable();
        observable.addObserver(new Observer1());
        observable.addObserver(new Observer2());

        observable.setData(10);
    }

}
