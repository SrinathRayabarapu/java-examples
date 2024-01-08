package com.dsalgo.linkedlist;

/**
 * given a linked list, rotate it by n times.
 *
 * @author Srinath.Rayabarapu
 */
public class RotateLinkedListMain {

    public static void main(String[] args) {

        Node head = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(10);
        Node n4 = new Node(40);
        Node n5 = new Node(20);
        Node n6 = new Node(60);
        Node n7 = new Node(10);
        Node n8 = new Node(80);

        head.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n8);

        System.out.println("Printing Original List : ");
        LinkedListUtil.printLinkedList(head);

        head = rotateLinkedList(head, 1);

        System.out.println("Printing Rotated List : ");
        LinkedListUtil.printLinkedList(head);

    }

    private static Node rotateLinkedList(Node head, int rotateCount) {

        Node temp = head;
        Node current = head;

        // TODO -

        return null;
    }

}
