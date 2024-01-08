package com.dsalgo.linkedlist;

/**
 * program to create a circular linked list
 * 
 * TODO - Need improvements - Check corner cases for all the operations 
 * 
 * @author Srinath.Rayabarapu
 */
public class CircularLinkedListMain {
	
	public static void main(String[] args) {
		
		CustomCircularLinkedList linkedList = new CustomCircularLinkedList();
		linkedList.insertAtFirst(10);
		linkedList.insertAtLast(20);
		linkedList.insertAtLast(30);
		linkedList.insertAtLast(40);
		linkedList.insertAtLast(50);
		linkedList.insertAtFirst(60);		
		linkedList.display();
		
		linkedList.deleteAtFirst();
		linkedList.display();
		
		linkedList.deleteAtLast();
		linkedList.display();
		
		linkedList.insetAtPos(2, 12);
		linkedList.display();
		
		linkedList.deleteAtPos(2);
		linkedList.display();
		
		linkedList.insetAtPos(7, 12);
		linkedList.display();
		
		linkedList.deleteAtPos(7);
		linkedList.display();
	}
}

/*
 * circular linkedlist class with below methods - 
 * 
 * isEmpty
 * getSize
 * insertAtFirst
 * insertAtLast
 * deleteAtFirst
 * deleteAtLast
 * insetAtIndex
 * deleteAtIndex
 * display
 * 
 * Note: last node always points to first node
 */
class CustomCircularLinkedList{
	private Node start;
	private Node end;
	int size;
	
	public CustomCircularLinkedList() {
		this.start = null;
		this.end = null;
		this.size = 0;
	}
	
	public boolean isEmpty(){
		return this.size == 0;
	}
	
	public int getSize(){
		return this.size;
	}
	
	public void deleteAtFirst(){
		Node node = this.start.getNext();
		this.start.setNext(null);
		this.start = node;
		this.end.setNext(this.start);
		System.out.println("\nDeleted at first - ");
	}
	
	public void deleteAtLast(){
		
		Node enode = this.end;
		Node snode = this.start;
		Node lbnode = null;
		
		while(snode.getNext() != this.start){
			//at the end - snode is last node
			if(snode.getNext().getNext() == this.start){
				lbnode = snode;
			}
			snode = snode.getNext();
		}
		//cann't be null - since it is cyclic list
		lbnode.setNext(this.start);
		enode.setNext(null);
		
		System.out.println("\nDeleted at last - ");
	}
	
	public void insertAtFirst(int val){
		Node node = new Node(val,null);
		if(!isEmpty()){
			node.setNext(this.start);
			this.start = node;
			this.end.setNext(this.start);
		}else{
			this.start = node;
			this.end = this.start;
		}
		this.size ++;
		System.out.println(val + " inserted at first");
	}
	
	public void insertAtLast(int val){
		Node node = new Node(val, null);
		if(!isEmpty()){
			this.end.setNext(node);
			node.setNext(this.start);
			this.end = node;
		}else{
			this.start = node;
			this.end = this.start;
		}
		this.size ++;
		System.out.println(val + " inserted at last");
	}
	
	//
	public void insetAtPos(int pos, int val){
		Node nnode = new Node(val, null);
		Node node = start;
		for(int i=1; i<=size; i++){
			if(i == pos-1){ //this is to find "but one" node to change the pointers
				nnode.setNext(node.getNext());
				node.setNext(nnode);				
				break;
			}
			node = node.getNext();
		}
		this.size ++;
		System.out.println("\nInserted value " + val + " position " + pos);
	}
	
	public void deleteAtPos(int pos){
		Node node = start;
		for(int i=1; i<=size; i++){
			if(i == pos-1){ //this is to find "but one" node to change the pointers				
				node.setNext(node.getNext().getNext());
				break;				
			}
			node = node.getNext();
		}
		this.size --;
		System.out.println("\nDeleted value at position " + pos);
	}
	
	public void display(){
		
		System.out.println("\nCircular Linked list - ");

		Node node = this.start;
		// empty linked list
		if(this.size == 0){
			System.out.println("empty");
		}
		//one node linked list
		if(node.getNext() == this.start){
			System.out.println(node.getData());
		}
		
		while(node.getNext() != this.start){
			System.out.println(node.getData());
			node = node.getNext();
		}
		System.out.println(node.getData());
	}	
}
