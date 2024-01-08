package com.dsalgo.linkedlist;

import lombok.extern.slf4j.Slf4j;

import static com.dsalgo.linkedlist.LinkedListUtil.printLinkedList;
import static com.dsalgo.linkedlist.LinkedListUtil.printListInRecursive;

/**
 * given a singly linked list, reverse it.
 *
 * recursive and iteration implementations are below.
 *
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class ReverseLinkedListMain {

    public static void main(String[] args) {

        Node head = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node n5 = new Node(50);
        Node n6 = new Node(60);
        Node n7 = new Node(70);
        Node n8 = new Node(80);

        head.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n8);

        log.info("Printing original linked list - loop way : ");
        // printing list in loop
        printLinkedList(head);

        log.info("Printing original linked list - recursive way : ");
        // printing list in recursive
        printListInRecursive(head);

        log.info("Printing in Reverse order - No change to list: ");
        //simply print in reverse order - don't change original list structure
        printListInReverseRecursive(head);

        // it will change the original list!
        Node node = reverseLinkedListIterative(head);

        log.info("Printing Reversed Linked list: ");
        printLinkedList(node);

    }

    // print linked list in reverse - no change to original structure
    private static void printListInReverseRecursive(Node head) {
        if(head == null){
            return;
        }
        printListInReverseRecursive(head.getNext());
        log.info(head+"");
    }

    private static Node reverseLinkedListIterative(Node head) {
        Node current = head;
        Node previous = null; // required to make this as last node

        while(current != null){
            Node next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next; // required to go to next element in loop
        }

        return previous;
    }

}