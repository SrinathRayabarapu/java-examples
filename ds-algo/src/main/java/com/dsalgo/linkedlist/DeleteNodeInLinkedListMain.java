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
        deleteNode(n1, 3);

        System.out.println("Printing list after node deletion: ");
        printList(n1);

    }

    public static void deleteNode(Node n1, Node deleteNode) {

        Node head = n1;
        Node previous = null;

        while(head != null) {
            if(head.getData().equals(deleteNode.getData())){
                if(deleteNode.getNext() != null && previous != null){
                    previous.setNext(deleteNode.getNext());
                } else {
                    if(previous != null) {
                        previous.setNext(null);
                    }
                }
            }
            previous = head;
            head = head.getNext();
        }
    }

    public static void deleteNode(Node n1, int index) {

        Node head = n1;
        Node previous = null;
        int count = 0;

        while(head != null) {
            if(count == index) {
                if(head.getNext() != null && previous != null){
                    previous.setNext(head.getNext());
                } else {
                    if(previous != null) {
                        previous.setNext(null);
                    }
                }
            }
            previous = head;
            head = head.getNext();
            count++;
        }
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
