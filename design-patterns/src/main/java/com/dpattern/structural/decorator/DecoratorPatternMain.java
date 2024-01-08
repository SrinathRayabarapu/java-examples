package com.dpattern.structural.decorator;

/**
 * It's a Structural pattern - Decorator pattern allows a user to add new functionality to an existing object without
 * altering its structure (operates at Object level, not at class level).
 *
 * Acts as a wrapper to existing class.
 *
 * This pattern creates a decorator class which wraps the original class and provides additional functionality keeping
 * class methods' signature intact.
 *
 * Examples:
 * 1. Pizza maker and calculate the cost
 * 2. Design Coffee maker
 *
 * @author Srinath.Rayabarapu
 */
public class DecoratorPatternMain {
	
	public static void main(String[] args) {

		// original objects are passed to a decorator
		IShape redCircle = new RedShapeDecorator(new Circle());
		IShape redRectangle = new RedShapeDecorator(new Rectangle());
		
		//draw adds extra  functionality
		redCircle.draw();
		redRectangle.draw();
	}

}