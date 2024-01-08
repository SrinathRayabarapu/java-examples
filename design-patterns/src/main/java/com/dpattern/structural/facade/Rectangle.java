package com.dpattern.structural.facade;

import com.dpattern.structural.decorator.IShape;

public class Rectangle implements IShape {

	@Override
	public void draw() {
		System.out.println("Drawing Rectangle..");
	}

}
