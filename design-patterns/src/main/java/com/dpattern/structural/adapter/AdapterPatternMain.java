package com.dpattern.structural.adapter;

import lombok.extern.slf4j.Slf4j;

/**
 * The adapter pattern convert the interface of a class into another interface that client expects. Adapter lets
 * classes work together that couldn't otherwise because of incompatible interfaces.
 *
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class AdapterPatternMain {
	
	public static void main(String[] args) {
		
		IDuck mallardDuck = new MallardDuck();
		ITurkey wildTurkey = new WildITurkey();
		
		IDuck turkeyToIDuck = new TurkeytoIDuckAdapter(wildTurkey);
		
		log.info("The Duck says..");
		callDuck(mallardDuck);

		log.info("The Turkey says..");
		callTurkey(wildTurkey);

		log.info("The TurkeyAdapter says..");
		callDuck(turkeyToIDuck);
		
	}

	private static void callTurkey(ITurkey wildTurkey) {
		wildTurkey.gobble();
		wildTurkey.fly();
	}

	private static void callDuck(IDuck turkeyToIDuck) {
		turkeyToIDuck.quack();
		turkeyToIDuck.fly();
	}

}