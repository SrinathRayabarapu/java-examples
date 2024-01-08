package com.dpattern.structural.facade;

import com.dpattern.structural.decorator.IShape;

public class Triangle implements IShape {

	@Override
	public void draw() {
		System.out.println("Drawing Triangle..");
	}

}
