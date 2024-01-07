package com.core.oops;

public class InterfaceClassesMain {
    public static void main(String[] args) {
        z z = (z)new y();
        System.out.println("printed");
    }
}

interface x{}
class y implements x{}
class z extends y{}