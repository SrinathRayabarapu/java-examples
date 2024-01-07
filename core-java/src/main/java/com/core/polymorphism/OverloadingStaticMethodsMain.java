package com.core.polymorphism;

import com.util.LogUtil;

/**
 * static methods overloading - is possible since they are declared at compile time and clearly distinguishable
 * from each other
 *
 * @author Srinath.Rayabarapu
 */
public class OverloadingStaticMethodsMain {

    public static void main(String[] args) {
        StaticMethodsClass.printMe();
        StaticMethodsClass.printMe("srinath");
    }

}

class StaticMethodsClass {

    public static void printMe() {
        LogUtil.info("defaultMethod 1");
    }

    public static boolean printMe(String str) {
        LogUtil.info("defaultMethod 2 " + str);
        return false;
    }

}