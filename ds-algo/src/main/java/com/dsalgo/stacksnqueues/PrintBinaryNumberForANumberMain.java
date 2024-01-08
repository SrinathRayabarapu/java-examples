package com.dsalgo.stacksnqueues;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

@Slf4j
public class PrintBinaryNumberForANumberMain {

    public static void main(String[] args) {
        printBinaryUsingQueue(10);
    }

    public static void printBinaryUsingQueue(int n) {
        if (n <= 0) {
            log.info("Nothing to print\n");
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        for (int i = 1; i <= n; i++) {
            Integer current = queue.remove(); //removing elements from head
            log.info(current+"");

            queue.add(current * 10); //adding to the queue at the end
            queue.add(current * 10 + 1);
        }

    }

}
