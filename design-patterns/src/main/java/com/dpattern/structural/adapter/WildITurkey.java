package com.dpattern.structural.adapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WildITurkey implements ITurkey {
	
	@Override
	public void fly() {
		log.info("Flying short distance..");
	}
	
	@Override
	public void gobble() {
		log.info("Gobble gobble..");
	}

}