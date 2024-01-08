package com.dpattern.creational.builder.good;

import lombok.extern.slf4j.Slf4j;

/**
 * used to build - complex objects which has a lot of configurations
 *
 * idea: Have a base object which you want to create. Create a builder class for the base object which will add the behaviour and return the object.
 * Have another orchestrator who builds this object and return.
 */
@Slf4j
public class BuilderPatternGoodMain {
	public static void main(String[] args) {

		HouseBuilder houseBuilder = new ConcreteHouseBuilder();

		CivilEngineer civilEngineer = new CivilEngineer(houseBuilder);
		civilEngineer.constructHouse();
		House house = civilEngineer.getHouse();

		System.out.println("Final House : " + house);


		houseBuilder = new IglooHouseBuilder();
		civilEngineer = new CivilEngineer(houseBuilder);
		civilEngineer.constructHouse();

		house = civilEngineer.getHouse();
		System.out.println("Final House : " + house);

	}

}