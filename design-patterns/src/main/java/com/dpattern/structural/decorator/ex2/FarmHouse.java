package com.dpattern.structural.decorator.ex2;

public class FarmHouse extends BasePizza{
    @Override
    public int cost() {
        System.out.println("FarmHouse cost is 30 INR");
        return 30;
    }
}
