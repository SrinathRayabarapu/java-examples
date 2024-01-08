package com.dpattern.creational.abstractfactory;

import lombok.extern.slf4j.Slf4j;

/**
 * In Abstract Factory pattern, we get rid of if-else block and have a factory class for each sub-class.
 * Then an Abstract Factory class that will return the sub-class based on the input factory class
 * 
 * It's a factory of factories!
 *
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class AbstractFactoryPatternMain {
	
	public static void main(String[] args) {

		Computer pc = ComputerFactory.getComputer(new PCFactory("2 GB","500 GB","2.4 GHz"));
		Computer server = ComputerFactory.getComputer(new ServerFactory("16 GB","1 TB","2.9 GHz"));

		log.info("AbstractFactory PC Config:: {}", pc);
		log.info("AbstractFactory Server Config:: {}", server);
	}

}