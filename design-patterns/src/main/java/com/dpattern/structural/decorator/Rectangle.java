package com.dpattern.structural.decorator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Rectangle implements IShape {

	@Override
	public void draw() {
		log.info("Drawing a Rectangle..");
	}
}