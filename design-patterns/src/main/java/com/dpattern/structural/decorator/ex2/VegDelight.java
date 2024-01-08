package com.dpattern.structural.decorator.ex2;

public class VegDelight extends BasePizza{
    @Override
    public int cost() {
        System.out.println("VegDelight cost is 20 INR");
        return 20;
    }
}
