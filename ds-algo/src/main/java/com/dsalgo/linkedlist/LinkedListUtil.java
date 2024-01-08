package com.dsalgo.linkedlist;

import lombok.extern.slf4j.Slf4j;

/**
 * class to hold linked list util methods
 *
 * @author Srinath.Rayabarapu
 */

@Slf4j
public class LinkedListUtil {

    private LinkedListUtil() {
    }

    /**
     * prints passed linked list
     * @param head
     */
    public static void printLinkedList(Node head) {
        StringBuilder temp = new StringBuilder();
        while (head != null) {
            temp.append(head).append(" ");
            head = head.getNext();
        }
        log.info(temp.toString());
    }

    public static void printListInRecursive(Node head) {
        if(head == null)
            return;

        log.info("{}", head);
        printListInRecursive(head.getNext());
    }
    
}
