package com.dpattern.creational.factory;

public class ShapeFactory {

	public IShape getShape(Shapes shape) {
		if(shape.equals(Shapes.CIRCLE)) {
			return new CircleShape();
		}
		if(shape.equals(Shapes.TRIANGLE)) {
			return new TriangleShape();
		}
		if(shape.equals(Shapes.SQUARE)) {
			return new SquareShape();
		}
		return null;
	}

}