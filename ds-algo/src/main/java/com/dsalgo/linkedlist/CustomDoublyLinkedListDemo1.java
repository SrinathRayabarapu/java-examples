package com.dsalgo.linkedlist;

import java.util.NoSuchElementException;

/**
 * 
 * @author srayabar
 */
public class CustomDoublyLinkedListDemo1{
	
	public static void main(String[] args) {
		
		CustomDoublyLinkedList<Integer> dbLinkedList = new CustomDoublyLinkedList<>();
		dbLinkedList.addFirst(10);
		dbLinkedList.addLast(15);
		dbLinkedList.addLast(20);
		dbLinkedList.addLast(25);
		
		dbLinkedList.iterateForward();
		dbLinkedList.iterateForward();
		
		System.out.println(dbLinkedList.removeFirst());
		
		dbLinkedList.addFirst(10);
		
		System.out.println(dbLinkedList.removeLast());
	}

}

/**
 * generic custom doubly linked list implementation
 * @author srayabar
 *
 * @param <E>
 */
class CustomDoublyLinkedList<E> {
	
	private DoublyNode head;
	private DoublyNode tail;
	private int size;
	
	public CustomDoublyLinkedList() {
		this.size = 0;
	}

	public int size(){
		return this.size;
	}
	
	public boolean isEmpty(){
		return this.size == 0;
	}
	
	/**
	 * 1. create a temp element with passed value and pass head to next
	 * 2. if head is not null, then set head previous as temp
	 * 3. assign temp to head - it's head now
	 * 4. if tail is null then assign temp to tail
	 * 5. increase the size
	 * 
	 * @param element
	 */
	public void addFirst(E element){
		
		DoublyNode tmp = new DoublyNode(null, head, element);
		if(head != null){
			head.previous = tmp;
		}
		head = tmp;
		if(tail == null){
			tail = tmp;
		}
		size ++;
		System.out.println("Added element first :" + element);
	}
	
	public void addLast(E element){
		DoublyNode tmp = new DoublyNode(tail, null, element);
		if(tail != null){
			tail.next = tmp;			
		}
		tail = tmp;
		if(head == null){
			head = tmp;
		}
		size ++;
		System.out.println("Added element last :" + element);
	}
	
	public void iterateForward(){
		DoublyNode tmp = head;
		if(tmp != null){
			tmp = tmp.next; 
		}
		head = tmp;
		System.out.println(tmp.element);
	}
	
	public void iterateBackward(){
		DoublyNode tmp = head;
		if(tmp != null){
			tmp = tmp.previous; 
		}
		head = tmp;
		System.out.println(tmp.element);
	}
	
	public E removeFirst(){
		
		if(size == 0){
			throw new NoSuchElementException();
		}		
		DoublyNode tmp = head;
		head = head.next;
		head.previous = null;
		size --;
		
		return tmp.element;
	}
	
	public E removeLast(){
		if(size == 0){
			throw new NoSuchElementException();
		}
		
		DoublyNode tmp = tail;
		tail = tail.previous;
		tail.next = null;
		
		return tmp.element;
	}
	
	/*
	 *each node def. in doubly linked list
	 */
	private class DoublyNode{
		
		private DoublyNode previous;
		private DoublyNode next;
		private E element;
		
		public DoublyNode(DoublyNode previous, DoublyNode next, E element){
			this.previous = previous;
			this.next = next;
			this.element = element;
		}
	}

}