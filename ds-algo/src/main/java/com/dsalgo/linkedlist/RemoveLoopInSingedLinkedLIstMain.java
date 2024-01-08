package com.dsalgo.linkedlist;

import static com.dsalgo.linkedlist.CheckLinkedListCyclicMain.printLinkedList;
import static com.dsalgo.linkedlist.CheckLinkedListCyclicMain.removeCycleAndReturnHead;

/**
 * Given a single linked list, find whether it has a loop and remove it.
 */
public class RemoveLoopInSingedLinkedLIstMain {

    public static void main(String[] args) {

        Node n1 = new Node(10);

        Node n2 = new Node(20);

        Node n3 = new Node(30);

        Node n4 = new Node(40);

        Node n5 = new Node(50);

        // creating a loop
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n3);

        Node node = removeCycleAndReturnHead(n1);

        printLinkedList(node);

    }

}
