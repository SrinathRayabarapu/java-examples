package com.dsalgo.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * given a linked list, delete a node.
 *
 * @author Srinath.Rayabarapu
 */
public class DeleteNodeInLinkedListMain {

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

        System.out.println("Original List: ");
        printList(n1);

//        System.out.println("\nDeleting Node " + n4.getData());
//        deleteNode(n1, n4);

        System.out.println("\nDeleting node with index " + 3);
        n1 = deleteNode(n1, 3);

        System.out.println("Printing list after node deletion: ");
        printList(n1);

    }

    public static Node deleteNode(Node n1, int index) {

        // if index is 0 then return next node
        if(index == 0){
            return n1.getNext();
        }

        Node head = n1;
        Node previous = null;
        int counter = 0;

        while(head != null) {
            // if the index is found, then skip that node
            if(counter == index) {
                previous.setNext(previous.getNext().getNext());
            }
            previous = head;
            head = head.getNext();
            counter++;
        }

        return n1;
    }


    private static void deleteDuplicateNodes(Node n1) {
        Node head = n1;
        Set<Integer> set = new HashSet<>();
        Node previous = null;
        while (head != null){
            if(set.contains(head.getData())){
                previous.setNext(head.getNext());
                previous = head.getNext();
            } else {
                set.add((int)head.getData());
                previous = head;
            }
            head = head.getNext();
        }
    }

    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head + " ");
            head = head.getNext();
        }
    }
}
