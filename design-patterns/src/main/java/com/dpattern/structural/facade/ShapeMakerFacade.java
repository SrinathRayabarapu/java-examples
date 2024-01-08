package com.dpattern.structural.facade;

/**
 * sample complex class for complex job
 * 
 * @author Srinath.Rayabarapu
 */
public class ShapeMakerFacade implements IShapeMakerFacade {

	private Circle circle;
	private Rectangle rectangle;
	private Triangle triangle;
	
	public ShapeMakerFacade() {
		this.circle = new Circle();
		this.rectangle = new Rectangle();
		this.triangle = new Triangle();
	}
	
	private void drawCircle() {
		this.circle.draw();
	}

	private void drawTriangle() {
		this.rectangle.draw();
	}

	private void drawRectangle() {
		this.triangle.draw();
	}
	
	//doing some complex job
	@Override
	public void drawShapes() {
		drawCircle();
		drawTriangle();
		drawRectangle();
	}

}