package com.dpattern.creational.builder.good;

public class IglooHouseBuilder implements HouseBuilder {

	private final House house;

	public IglooHouseBuilder() {
		this.house = new House();
		System.out.println("Igloo empty house is initialized");
	}

	@Override
	public void buildBasement() {
		house.setBasement("Ice Bars");
	}

	@Override
	public void buildStructure() {
		house.setStructure("Ice Blocks");
	}

	@Override
	public void buildRoof() {
		house.setRoof("Ice Carvings");
	}

	@Override
	public void buildInterior() {
		house.setInterior("Ice Dome");
	}

	@Override
	public House getHouse() {
		return this.house;
	}

}
