package com.core.cloning;

/**
 * this class demonstrates following <br> 
 * 1. shallow 
 * 2. deep 
 * 3. clone  
 *  
 * @author srayabar
 *
 */
public class CloneScenariosMain {

	// TODO - find few more better examples for cloning : Shallow and Deep

	public static void main(String[] args) {
		
		Sheep motherSheep = new Sheep("dolly", "white");
		System.out.println("Mother : " + motherSheep);
		
		Sheep child1Sheep = motherSheep;
		System.out.println("Child1 : " + child1Sheep);
		
		child1Sheep.setColor("black");
		
		System.out.println("Child1 again : " + child1Sheep); //Shallow copy - direct object assignments
		System.out.println("Mother : " + motherSheep);
		
		System.out.println("---------------------------------");
		
		Sheep child2Sheep = new Sheep(); //deep copy - explicit object creation and copying properties
		//child2Sheep = motherSheep;
		child2Sheep.setColor(motherSheep.getColor());
		child2Sheep.setName(motherSheep.getName());
		
		child2Sheep.setColor("red");
		
		System.out.println("Child2 again : " + child2Sheep); //child is red 
		System.out.println("Mother : " + motherSheep); // mother is still black
		
		System.out.println("---------------------------------");
		
		Sheep child3Sheep = (Sheep)motherSheep.getClone(); //cloning - as same as deep copy but no manual copying properties
		System.out.println("child3Sheep : " + child3Sheep);
		
		child3Sheep.setColor("blue");
		
		System.out.println("child3Sheep : " + child3Sheep); //child is blue 
		System.out.println("Mother : " + motherSheep);// mother is still black - deep copy here as well

	}
	
}