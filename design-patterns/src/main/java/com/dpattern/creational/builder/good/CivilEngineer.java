package com.dpattern.creational.builder.good;

public class CivilEngineer {
	
	private HouseBuilder builder;

    public CivilEngineer(HouseBuilder builder) {
        this.builder = builder;
        System.out.println("Civil engineer got the empty house");
    }

    public void constructHouse() {
        builder.buildBasement();
        builder.buildStructure();
        builder.buildRoof();
        builder.buildInterior();
        System.out.println("Civil engineer constructed the house");
    }

    public House getHouse() {
        System.out.println("Civil engineer returning the house");
        return builder.getHouse();
    }

}