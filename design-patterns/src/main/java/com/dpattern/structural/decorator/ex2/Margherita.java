package com.dpattern.structural.decorator.ex2;

public class Margherita extends BasePizza{
    @Override
    public int cost() {
        System.out.println("Margherita cost is 10 INR");
        return 10;
    }
}
