package com.dpattern.structural.decorator.ex2;

public class MushroomDecorator extends ToppingDecorator{

    private BasePizza basePizza;

    public MushroomDecorator(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        System.out.println("Adding extra cheese 5 INR cost");
        return basePizza.cost() + 5;
    }

}
