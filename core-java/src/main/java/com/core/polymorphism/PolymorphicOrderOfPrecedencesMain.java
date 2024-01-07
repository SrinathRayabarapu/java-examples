package com.core.polymorphism;

import com.util.LogUtil;

/**
 * class to demo order of precedence in static block/class level calls/constructor blocks in overriding
 * <p>
 * 1. static block (super class -> child class)
 * 2. class level calls
 * 3. constructors (super class -> child class)
 *
 * @author Srinath.Rayabarapu
 */
public class PolymorphicOrderOfPrecedencesMain extends X {
    static {
        LogUtil.info("static : Z"); //2
    }

    Y y = new Y(); //6

    PolymorphicOrderOfPrecedencesMain() {
        LogUtil.info("con: Z"); //7
    }

    public static void main(String[] args) {
        new PolymorphicOrderOfPrecedencesMain();
    }
}

class X {
    static {
        LogUtil.info("static : X"); //1
    }

    Y b = new Y();

    X() {
        LogUtil.info("con: X"); //5
    }
}

class Y {
    static {
        LogUtil.info("static : Y"); //3
    }

    Y() {
        LogUtil.info("con: Y"); //4
    }
}

/*
static : X
static : Z
static : Y
con: Y
con: X
con: Y
con: Z
 */