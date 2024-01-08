package com.dpattern.structural.adapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MallardDuck implements IDuck{

	@Override
	public void quack() {
		log.info("Quack..");
	}
	
	@Override
	public void fly() {
		log.info("I'm flying..");
	}
}
