package com.dsalgo.linkedlist;

/**
 * given a linked list, insert a node at Nth position
 *
 * @author Srinath.Rayabarapu
 */
public class InsertAtNPositionLinkedListMain {

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

        Node node = new Node(35);
        int position = 4;

        System.out.printf("Inserting node %d at %d %n", node.getData(), position);
        insertAtPosition(head, node, position);

        System.out.println("Printing list:");
        printList(head);

    }

    private static void insertAtPosition(Node head, Node insertNode, int position) {

        Node previous = null;
        int count = 1;

        while (head != null && count < position) {
            previous = head;
            head = head.getNext();
            count++;
        }

        insertNode.setNext(previous.getNext());
        previous.setNext(insertNode);

    }

    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head + " ");
            head = head.getNext();
        }
    }

}
