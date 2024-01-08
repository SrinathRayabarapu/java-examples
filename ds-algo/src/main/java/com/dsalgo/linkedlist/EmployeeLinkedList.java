package com.dsalgo.linkedlist;



import com.dsalgo.dtos.Employee;

import java.util.Objects;

public class EmployeeLinkedList {
	
	private EmployeeNode head; //head node reference
	private int size;
	
	public void addToFront(Employee employee) {
		EmployeeNode employeeNode = new EmployeeNode(employee);//create a node
		employeeNode.setNext(this.head);//set existing head node to new node next
		this.head = employeeNode;//assign new node to head
		setSize(getSize() + 1);
	}
	
	public void printList() {
		EmployeeNode current = this.head;
		System.out.print("HEAD -> ");
		while(current != null) {//print head first and assign next element to head 
			System.out.print(current);
			System.out.print(" -> ");
			current = current.getNext();
		}
		System.out.print("null"); //finally print null
	}
	
	public EmployeeNode removeFromFront() {
		
		if(isEmpty())//if list is emply then return null
			return null;
		
		EmployeeNode remove = this.head; //get head element
		this.head = this.head.getNext(); //assign head as head.next
		this.size --;
		
		remove.setNext(null); //clean code
		return remove; //return node
	}

	public boolean isEmpty(){
		return Objects.isNull(this.head);
	}
	
	/**
	 * @return the size
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

}