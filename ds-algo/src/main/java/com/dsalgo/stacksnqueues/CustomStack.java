package com.dsalgo.stacksnqueues;

import lombok.extern.slf4j.Slf4j;

/**
 * generic stack class to do push, pop, peek operations.
 * 
 * @author srayabar
 *
 * @param <T>
 */
@Slf4j
class CustomStack<T> {

	private T[] stackArray;
	private int size;
	private int top; //

	public CustomStack(int size) {
		this.stackArray = (T[]) new Object[size];
		this.size = size;
		this.top = -1;
	}

	public T peek() {
		return this.stackArray[this.top];
	}

	public boolean isFull() {
		return this.top == this.size - 1;
	}

	public boolean isEmpty() {
		return this.top == -1;
	}

	public void push(T t) {
		if (isFull()) {
			log.debug("Stack is Full, increasing the capacity! {}", "");
			increaseStackCapacity();
		}
		this.stackArray[++this.top] = t;
		log.debug("Pushing : {}", t);
	}

	public T pop() throws Exception {
		if (isEmpty()) {
			throw new Exception("Stack is empty, Cann't pop an element");
		}
		log.debug("Popping : {}", peek());
		return this.stackArray[this.top--];
	}

	private void increaseStackCapacity() {
		T[] newStackArray = (T[]) new Object[this.size * 2];
		for (int i = 0; i < this.stackArray.length; i++) {
			newStackArray[i] = this.stackArray[i];
		}
		this.stackArray = newStackArray;
		this.size = this.stackArray.length;
	}
}