package com.dsalgo.linkedlist;



import com.dsalgo.dtos.Employee;

import java.util.Objects;

/**
 * Doubly linked list class
 * 
 * @author srayabar
 */
public class EmployeeDoublyLinkedList {
	
	private EmployeeNode head;
	private EmployeeNode tail;
	private int size;
	
	public void addToFront(Employee employee) {
		
		EmployeeNode employeeNode = new EmployeeNode(employee);
		employeeNode.setNext(this.head); //head is next to the new node
		
		if(Objects.isNull(this.head)) { //if head is null, then new node is tail too
			this.tail = employeeNode;
		} else {
			this.head.setPrevious(employeeNode); //else head previous is set to new node
		}
		
		this.head = employeeNode; //head is replaced by new node
		setSize(getSize() + 1);
	}
	
	public void addToEnd(Employee employee) {
		
		EmployeeNode employeeNode = new EmployeeNode(employee);
		
		if(Objects.isNull(this.tail)) {
			this.head = employeeNode;
		} else {
			this.tail.setNext(employeeNode);
			employeeNode.setPrevious(this.tail);
		}
		
		this.tail = employeeNode;
		setSize(getSize() + 1);
	}
	
	public boolean isEmpty() {
		return Objects.isNull(this.head);
	}
	
	public EmployeeNode removeFromFront() {
		//TODO
		EmployeeNode head = this.head;
		
		if(Objects.isNull(head))
			return null;
		
		EmployeeNode next = head.getNext();
		next.setPrevious(null);
		this.head = next;
		
		setSize(getSize() - 1);
		
		return head;
	}
	
	public EmployeeNode removeFromEnd() {
		//TODO
		
		
		return null;
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
	
	public void printList() {
		EmployeeNode node = this.head;
		System.out.print("HEAD -> ");
		while(node != null) {
			System.out.print(node);
			System.out.print(" <-> ");
			node = node.getNext();
		}
		System.out.println("null");
	}
	
}
