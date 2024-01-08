package com.dpattern.structural.facade;

/**
 * Facade pattern - Exposing an Interface to callers there by hiding it's concrete implementations. Callers do not have 
 * to worry about how they have been implemented
 *
 * Ex: 	java.sql.Connection - implementation is left to vendor driver
 * 		SessionFacade - read it
 *
 * @author Srinath.Rayabarapu
 */
public class FacadePatternMain {

	public static void main(String[] args) {
		
		IShapeMakerFacade facade = new ShapeMakerFacade();
		
		//hiding all the drawings complexity to the caller
		facade.drawShapes();
	}
}