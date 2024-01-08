package com.dsalgo.stacksnqueues;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

@Slf4j
public class StackUtil {

    public static void printStack(Stack<?> stack) {

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        log.info("Stack : {}", sb);
    }

}
