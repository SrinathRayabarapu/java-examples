package com.dpattern.creational.abstractfactory;

/**
 * consumer class and entry point for abstract factory implementation
 */
public class ComputerFactory {

	public static Computer getComputer(ComputerAbstractFactory factory){
		return factory.createComputer();
	}

}
