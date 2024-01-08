package com.dsalgo.linkedlist;

/**
 * given a linked list, insert a node at the end
 *
 * @author Srinath.Rayabarapu
 */
public class InsertAtEndLinkedListMain {

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

        Node insertNode = new Node(90);

        System.out.println("Inserting node : " + insertNode);
        insertAtEnd(n1, insertNode);

        System.out.println("Printing list:");
        printList(n1);

    }

    private static void insertAtEnd(Node head, Node insertNode) {
        Node lastNode = null;
        while (head != null) {
            lastNode = head;
            head = head.getNext();
        }
        lastNode.setNext(insertNode);
    }

    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head + " ");
            head = head.getNext();
        }
    }

}
