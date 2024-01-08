package com.dpattern.creational.builder.good;

public class ConcreteHouseBuilder implements HouseBuilder {

	private final House house;

	public ConcreteHouseBuilder() {
		this.house = new House();
		System.out.println("Concrete empty house is initialized");
	}

	@Override
	public void buildBasement() {
		house.setBasement("Concrete Basement");
	}

	@Override
	public void buildStructure() {
		house.setStructure("Concrete Walls");
	}

	@Override
	public void buildRoof() {
		house.setRoof("Concrete Roof");
	}

	@Override
	public void buildInterior() {
		house.setInterior("Concrete Interior");
	}

	@Override
	public House getHouse() {
		return this.house;
	}

}
