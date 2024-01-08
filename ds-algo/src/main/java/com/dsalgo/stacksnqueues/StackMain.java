package com.dsalgo.stacksnqueues;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

import static com.dsalgo.stacksnqueues.StackUtil.printStack;

@Slf4j
public class StackMain {

    public static void main(String[] args) {
        Stack<String> stack = buildStack();
        printStack(stack);

        stack = buildStack();
        reversePrintStack(stack);

        stack = buildStack();
        reverseStack(stack);
        printStack(stack);
    }

    private static void reverseStack(Stack<String> stack) {
        // TODO
    }

    private static Stack<String> buildStack() {
        Stack<String> stack = new Stack();

        stack.push("hey");
        stack.push("srinath");
        stack.push("rayabarapu");

        return stack;
    }

    private static void reversePrintStack(Stack<String> stack) {
        while (!stack.isEmpty()){
            String temp = stack.pop();
            reversePrintStack(stack);
            log.info(temp);
        }
    }

}
