package com.core.java8;

import java.util.ArrayList;
import java.util.List;

/**
 * why default methods? with an example:
 * Is to enable the functionality of lambda expression in java
 *
 * @author Srinath.Rayabarapu
 */
public class DefaultMethodInterfaces3Main implements Moveable {

    public static void main(String[] args) {
        DefaultMethodInterfaces3Main main = new DefaultMethodInterfaces3Main();

        // now possible 1 - with method references
        Runnable runnable = main::move;
        runnable.run();

        List<DefaultMethodInterfaces3Main> list = new ArrayList();
        list.add(new DefaultMethodInterfaces3Main());
        list.add(new DefaultMethodInterfaces3Main());
        list.add(new DefaultMethodInterfaces3Main());

        //now possible 2 - Iterator code reduced to one line
        list.forEach((Moveable p) -> p.move());

    }

}

interface Moveable {
    default void move() {
        System.out.println("I am moving");
    }
}