package com.dpattern.creational.builder.good;

public interface HouseBuilder {

	void buildBasement();

	void buildStructure();

	void buildRoof();

	void buildInterior();

	House getHouse();

}
