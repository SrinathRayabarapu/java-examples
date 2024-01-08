package com.dsalgo.linkedlist;


import com.dsalgo.dtos.Employee;

/**
 * second variation in linked list implementation
 * 
 * @author Srinath.Rayabarapu
 */
public class LinkedListCustomImplDemo2 {
	
	public static void main(String[] args) {
		
		Employee srinath = new Employee(1, "Srinath", 22);
		Employee siri = new Employee(2, "Siri", 12);
		Employee shubha = new Employee(3, "Shubha", 20);
		Employee srikanth = new Employee(1, "Srikanth", 31);
		Employee sathish = new Employee(1, "Sathish", 18);
		
		EmployeeLinkedList list = new EmployeeLinkedList();
		
		System.out.println(list.isEmpty());
		
		list.addToFront(srinath);
		list.addToFront(siri);
		list.addToFront(shubha);
		list.addToFront(srikanth);
		list.addToFront(sathish);
		
		list.printList();
		
		System.out.println("\n"+list.getSize());
		System.out.println(list.isEmpty());
		
		System.out.println("removing : " + list.removeFromFront());
		
		list.printList();
		
		System.out.println("\n"+list.getSize());
		
	}

}