package com.dsalgo.stacksnqueues;

public class CustomStackMain {
	
	public static void main(String[] args) {
		try {
			CustomStack<Integer> stack = new CustomStack<Integer>(10);
			stack.push(10);
			stack.push(12);
			stack.push(14);
			System.out.println(stack.peek());
			System.out.println("---");
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println("---");
			System.out.println(stack.peek());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
