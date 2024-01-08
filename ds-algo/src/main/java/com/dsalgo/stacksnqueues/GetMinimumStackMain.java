package com.dsalgo.stacksnqueues;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * implement a stack where getMinimum() should return the minimum at any point in O(1)
 */
@Slf4j
public class GetMinimumStackMain {

    public static void main(String[] args) {

/*
        GetMinimumStackWithSpace stack = new GetMinimumStackWithSpace();
        stack.push(5);
        stack.push(2);
        stack.push(9);
        stack.push(7);
        stack.push(1);
        stack.push(0);
        stack.push(11);

//        stack.printAllStacks();

        log.info("Stack minimum : {}", stack.getMinimum());

        stack.pop();
        stack.pop();
        stack.pop();

        log.info("Stack minimum : {}", stack.getMinimum());
        */

        GetMinimumStackNoSpace stack = new GetMinimumStackNoSpace();
        stack.push(5);
        stack.push(2);
        stack.push(9);
        stack.push(7);
        stack.push(1);
        stack.push(0);
        stack.push(11);

//        stack.printAllStacks();

        log.info("Stack minimum : {}", stack.getMinimum());

        stack.pop();
        stack.pop();
        stack.pop();

        log.info("Stack minimum : {}", stack.getMinimum());
    }

}

@Slf4j
class GetMinimumStackNoSpace {

    int minimum = -1;
    int staticRandom = 9999;
    Stack<Integer> stack = new Stack<>();

    public int getMinimum() {
        return minimum;
    }

    public void push(Integer item) {

        // first time and every min time
        if (stack.isEmpty() || item < minimum) {
            minimum = item;
        }

        int push = item * staticRandom + minimum;
        log.info("Pushed : {}", item);
        stack.push(push);
    }

    public void pop() {

        if (stack.isEmpty()) {
            log.info("Stack is empty!");
            return;
        }

        Integer pop = stack.pop();

        if (!stack.isEmpty()) {
            minimum = stack.peek() % staticRandom;
        } else {
            minimum = -1;
        }

        log.info("Popped : {}", pop/staticRandom);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int peek() {
        return stack.peek()/staticRandom;
    }

    public void printAllStacks() {
        StackUtil.printStack(stack);
    }

}

/**
 * getMinimum
 * TC : O(1)
 * SC : O(n)
 */
class GetMinimumStackWithSpace {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> auxiliaryStack = new Stack<>();

    public int getMinimum() {
        return auxiliaryStack.peek();
    }

    public void push(Integer item) {
        stack.push(item);

        if (!auxiliaryStack.isEmpty()) {
            int peek = auxiliaryStack.peek();
            if (item < peek) {
                auxiliaryStack.push(item);
            } else {
                auxiliaryStack.push(peek);
            }
        } else {
            auxiliaryStack.push(item);
        }
    }

    public void pop() {
        stack.pop();
        auxiliaryStack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int peek() {
        return stack.peek();
    }

    public void printAllStacks() {
        StackUtil.printStack(stack);
        StackUtil.printStack(auxiliaryStack);
    }
}