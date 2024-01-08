package com.dpattern.structural.decorator.ex2;

public class ExtraCheeseDecorator extends ToppingDecorator{

    private BasePizza basePizza;

    public ExtraCheeseDecorator(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        System.out.println("Adding extra cheese 10 INR cost");
        return basePizza.cost() + 10;
    }

}
