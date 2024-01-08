package com.dsalgo.stacksnqueues;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Queue;

@Slf4j
public class QueueMain {

    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("hey");
        queue.offer("Srinath");

        while (!queue.isEmpty()){
            log.info(queue.poll());
        }
    }

}