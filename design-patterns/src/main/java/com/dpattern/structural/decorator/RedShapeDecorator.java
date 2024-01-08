package com.dpattern.structural.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * this is to add extra functionality to an existing object - key class in this design pattern
 * 
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class RedShapeDecorator implements IShape{
	
	IShape decoratedShape;
	
	public RedShapeDecorator(IShape decoratedShape) {
		this.decoratedShape = decoratedShape;
	}
	
	@Override
	public void draw() {
		this.decoratedShape.draw();
		//adding extra functionality to passed shapeObject
		setRedBorder(this.decoratedShape);
	}
	
	//method to add color to border
	private void setRedBorder(IShape decoratedShape) {
		log.info("Adding Red color border!!");
	}
}