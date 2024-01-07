package com.core;

/**
 * If A and B two classes are related to each other such that, B ceased to exist when A is destroyed, then the
 * association between two objects is known as Composition. An example is Car and Engine.
 *
 * Ref: https://javarevisited.blogspot.com/2014/02/ifference-between-association-vs-composition-vs-aggregation.html#axzz7TXj5Yd6k
 */
public class CompositionMain {

    public static void main(String[] args) {
        // Since Engine is-part-of Car, the relationship between them is Composition.
        Car newCar = new Car(new Engine("SUZUKI"));
    }

}

class Car {
    // final will make sure engine is initialised
    private final Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }
}

class Engine {
    private String type;
    public Engine(String type) {
        this.type = type;
    }
}
