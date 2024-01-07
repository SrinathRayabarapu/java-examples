package com.core.classes;

import com.util.LogUtil;

/**
 * main class can also be Abstract
 * <p>
 * parent abstract methods should be defined in child classes
 * <p>
 *
 * @author Srinath.Rayabarapu
 */
abstract class AbstractClass {

    String name;
    public AbstractClass(String a) {
        this.name = a;
        LogUtil.info("Abstract demo constructor called with - " + a);
    }

    public abstract void fly();

}

public class AbstractImplMain extends AbstractClass {

    public AbstractImplMain() {
        super("srinath");
    }

    public void fly() {
        LogUtil.info("Hey, "+ name +". I'm flying........");
    }

    public static void main(String[] args) {
        new AbstractImplMain().fly();
    }

}