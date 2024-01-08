package com.dsalgo.linkedlist;

import lombok.extern.slf4j.Slf4j;

import static com.dsalgo.linkedlist.LinkedListUtil.printLinkedList;

@Slf4j
public class DeleteMiddleElementInLinkedLIstMain {

    public static void main(String[] args) {

        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node n5 = new Node(50);
        Node n6 = new Node(60);
        Node n7 = new Node(70);
        Node n8 = new Node(80);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n8);

        log.info("Before deleting the Middle : ");
        printLinkedList(n1);

        deleteMiddleElement(n1);

        log.info("After deleting the Middle : ");
        printLinkedList(n1);
    }

    // slow and fast nodes concept
    private static void deleteMiddleElement(Node node1) {

        if(node1 == null || node1.getNext() == null){
            return;
        }

        Node slow = node1;
        Node fast = node1;
        Node previous = node1;

        while (fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            previous = slow;
            slow = slow.getNext();
        }

        log.info("Deleting {}", slow.getData());

        previous.setNext(slow.getNext());
    }

}