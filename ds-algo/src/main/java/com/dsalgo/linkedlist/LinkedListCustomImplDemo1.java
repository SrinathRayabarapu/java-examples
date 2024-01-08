package com.dsalgo.linkedlist;

/**
 * Custom implementation class for Linkedlist. Also has methods related to cyclic nature
 * 
 * @author Srinath.Rayabarapu
 *
 */
public class LinkedListCustomImplDemo1 {

	public static void main(String[] args) {

		CustomLinkedList custom = new CustomLinkedList();

		custom.add(10);
		custom.add(16.2);
		custom.add(20);
		custom.add(30);
		
		//checking basic list function
		/*
		custom.add(40, 2);
		System.out.println(custom.toString());
		
		custom.remove(2);
		System.out.println(custom.toString());
		
		System.out.println(custom.get(3));
		*/
		
		custom.add(10);
		System.out.println(custom.cyclic());
	}
}

/**
 * custom linked list class where all the impl is there
 * 
 * @author srayabar
 *
 */
class CustomLinkedList {

	private Node head;
	private int listCount;

	public CustomLinkedList() {
		this.head = new Node(null);
		this.listCount = 0;
	}

	/**
	 * appends data node at the end of the linked list
	 * 
	 * @param data
	 */
	public void add(Object data) {

		Node temNode = new Node(data);
		Node currentHead = this.head; //head has all the nodes linking

		while (currentHead.getNext() != null) { //goto last node and insert new node
			currentHead = currentHead.getNext();
		}

		currentHead.setNext(temNode);
		this.listCount++;

	}

	/**
	 * inserts a node at specific index
	 * 
	 * @param data
	 * @param index
	 */
	public void add(Object data, int index) {

		Node temNode = new Node(data);
		Node currentHead = this.head;

		for (int i = 1; i < index && currentHead.getNext() != null; i++) {
			currentHead = currentHead.getNext();
		}

		temNode.setNext(currentHead.getNext());
		currentHead.setNext(temNode);
		this.listCount++;

	}

	/**
	 * get a node by its index
	 * 
	 * @param index
	 * @return
	 */
	public Object get(int index) {

		if (index <= 0) {// 0 or -int case
			return null;
		}

		Node currentNode = this.head.getNext(); //head itself is not a first node
		for (int i = 1; i < index; i++) {
			if (currentNode.getNext() == null) {
				return null;
			}
			currentNode = currentNode.getNext(); // more than 2 case
		}
		return currentNode.getData(); // default : 1 case
	}

	/**
	 * removes a node by its index
	 * 
	 * @param index
	 * @return
	 */
	public boolean remove(int index) {

		// 0 or -1 case
		if (index < 1 || index > size()) {
			return false;
		}

		Node currentNode = this.head;
		for (int i = 1; i < index; i++) {// more than 2 case
			if (currentNode.getNext() == null) {
				return false;
			}
			currentNode = currentNode.getNext();
		}

		currentNode.setNext(currentNode.getNext().getNext());
		this.listCount--;

		return true;
	}

	public int size() {
		return this.listCount;
	}

	public boolean cyclic(){
		Node fast = this.head;
		Node slow = this.head;
		
		//caution - infinite loop
		while(slow.getNext() != null){
			slow = slow.getNext();
			fast = fast.getNext().getNext();
			
			if(slow == fast){
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public String toString() {

		Node currentNode = this.head.getNext();
		String outpust = "";
		while (currentNode != null) {
			outpust += currentNode.getData().toString() + ", ";
			currentNode = currentNode.getNext();
		}

		return outpust;
	}
}

