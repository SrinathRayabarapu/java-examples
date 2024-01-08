package com.dpattern.structural.decorator.ex2;

public class DecoratorPatternMain {

    public static void main(String[] args) {
        BasePizza pizza = new MushroomDecorator(new ExtraCheeseDecorator((new VegDelight())));
        System.out.println("Total pizza cost : " + pizza.cost());


        pizza = new ExtraCheeseDecorator(new MushroomDecorator((new FarmHouse())));
        System.out.println("Total pizza cost : " + pizza.cost());

    }

}
