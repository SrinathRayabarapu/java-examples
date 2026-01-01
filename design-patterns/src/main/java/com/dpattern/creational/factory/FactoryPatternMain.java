package com.dpattern.creational.factory;

/**
 * Demonstrates the Factory Design Pattern - one of the Gang of Four (GoF) Creational patterns.
 * 
 * <p>The Factory pattern defines an interface for creating objects but lets subclasses
 * decide which class to instantiate. It promotes loose coupling by eliminating the need
 * to bind application-specific classes into the code.</p>
 * 
 * <h3>Key Benefits:</h3>
 * <ul>
 *   <li><b>Encapsulation</b> - Creation logic is hidden from the client</li>
 *   <li><b>Loose Coupling</b> - Client works with interfaces, not concrete classes</li>
 *   <li><b>Single Responsibility</b> - Object creation is centralized in factory</li>
 *   <li><b>Open/Closed Principle</b> - New types can be added without modifying client code</li>
 * </ul>
 * 
 * <h3>Pattern Structure:</h3>
 * <ul>
 *   <li><b>Product Interface</b> ({@link IShape}) - Defines the interface for created objects</li>
 *   <li><b>Concrete Products</b> ({@link CircleShape}, {@link SquareShape}, {@link TriangleShape}) - Implement the product interface</li>
 *   <li><b>Factory</b> ({@link ShapeFactory}) - Contains the creation logic</li>
 *   <li><b>Client</b> - Uses factory to get products without knowing concrete types</li>
 * </ul>
 * 
 * <h3>When to Use:</h3>
 * <ul>
 *   <li>When the exact type of object to create is determined at runtime</li>
 *   <li>When you want to centralize complex creation logic</li>
 *   <li>When you want to decouple object creation from usage</li>
 * </ul>
 * 
 * @author Srinath.Rayabarapu
 * @see ShapeFactory
 * @see IShape
 */
public class FactoryPatternMain {
	
	/**
	 * Demonstrates the Factory pattern by creating different shapes
	 * using the ShapeFactory without knowing concrete implementations.
	 *
	 * @param args command-line arguments (not used)
	 */
	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();
		
		IShape shape = shapeFactory.getShape(Shapes.CIRCLE);
		shape.draw();
		
		shape = shapeFactory.getShape(Shapes.SQUARE);
		shape.draw();
		
		shape = shapeFactory.getShape(Shapes.TRIANGLE);
		shape.draw();
	}

}