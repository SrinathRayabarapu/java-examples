package com.dsalgo.stacksnqueues;

import java.util.Stack;

/**
 * given stack data structures, implement queue
 * 
 * @author Srinath.Rayabarapu
 */
public class QueueUsingStacksMain {
	
	public static void main(String[] args) {
		//in type reference - no need to pass String to new Object
		QueueUsingStacks<String> queue = new QueueUsingStacks<>();
		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		System.out.println(queue.dequeue());

		queue.enqueue("c");
		queue.enqueue("d");
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());

		System.out.println("Queue size is : " + queue.size());
	}
}

/*
 * generic queue class
 */
class QueueUsingStacks<E>{
	
	private Stack<E> inbound = new Stack<E>();
	private Stack<E> outbound = new Stack<E>();
	
	public void enqueue(E element){
		this.inbound.push(element);
	}
	
	public E dequeue(){
		// O(n) complexity
		while(!this.inbound.isEmpty()){
			this.outbound.push(this.inbound.pop());
		}
		return this.outbound.pop();
	}

	public int size(){
		return inbound.size() + outbound.size();
	}
}