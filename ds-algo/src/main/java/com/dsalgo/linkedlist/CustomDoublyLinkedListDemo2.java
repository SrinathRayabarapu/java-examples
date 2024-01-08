package com.dsalgo.linkedlist;


import com.dsalgo.dtos.Employee;

public class CustomDoublyLinkedListDemo2 {
	
	public static void main(String[] args) {
		
		Employee srinath = new Employee(1, "Srinath", 22);
		Employee siri = new Employee(2, "Siri", 12);
		Employee shubha = new Employee(3, "Shubha", 20);
		Employee srikanth = new Employee(1, "Srikanth", 31);
		Employee sathish = new Employee(1, "Sathish", 18);
		
		EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();
		
		list.addToFront(sathish);
		list.addToFront(srikanth);
		list.addToEnd(shubha);
		list.addToFront(siri);
		list.addToEnd(srinath);
		
		list.printList();
		System.out.println(list.getSize());
		System.out.println("isEmpty : " + list.isEmpty());
		
		list.removeFromFront();
		
		list.printList();
		System.out.println(list.getSize());
		System.out.println("isEmpty : " + list.isEmpty());
		
	}

}