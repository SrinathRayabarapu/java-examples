package com.dsalgo.linkedlist;

/**
 * class to have all cicular linked list related util methods
 *
 * @author Srinath.Rayabarapu
 */
public class CircularLinkedListUtilMain {

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
        n7.setNext(head);

        int length = findCircularLength(head);
        System.out.println(length);

    }

    private static int findCircularLength(Node head) {
        Node temp = head;
        int counter = 1;
        while (head != null){
            head = head.getNext();
            if(head == temp){
                break;
            }
            counter++;
        }
        return counter;
    }


}
