package com.book.tij.rtti;

import java.util.Arrays;
import java.util.List;

abstract class Shape {	
	public void draw(){
		System.out.println(this + ".draw()");
	}
	public abstract String toString();
}

class Rectangle extends Shape{
	@Override
	public String toString() {
		return "Rectangle";
	}	
}

class Circle extends Shape{
	@Override
	public String toString() {
		return "Circle";
	}	
}

class Triangle extends Shape{
	@Override
	public String toString() {
		return "Triangle";
	}	
}

public class Shapes{
	public static void main(String[] args) {
		List<Shape> shapesList = Arrays.asList(new Rectangle(),new Circle(),new Triangle());
		for(Shape shape: shapesList){
			//runtime only the object type will be known
			if(shape instanceof Rectangle){
				Rectangle rect = (Rectangle)shape;
				rect.draw();				
				System.out.println("Rectangle detected !");
			}
			
			shape.draw();
		}
	}
}