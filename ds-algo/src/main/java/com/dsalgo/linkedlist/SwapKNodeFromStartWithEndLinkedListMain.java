package com.dsalgo.linkedlist;

/**
 * given a linked list, swap Kth node from beginning with end.
 *
 * @author Srinath.Rayabarapu
 */
public class SwapKNodeFromStartWithEndLinkedListMain {

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

        System.out.println("Swapping nodes..");
        swapNodes(n1, 3);

        System.out.println("Printing list:");
        printList(n1);

    }

    private static void swapNodes(Node head, int position) {
        Node slow = head, fast = head;
        int count = position;

        Node previous1 = null, previous2 = null;

        // finding first position
        while (slow != null && slow.getNext() != null && 1 < count) {
            previous1 = slow;
            slow = slow.getNext();
            count--;
        }

        Node first = slow;
        System.out.println("first: " + first);


        // finding last position
        slow = head;
        count = position;
        System.out.println(count);
        while (fast != null && fast.getNext() != null && 1 < count) {
            fast = fast.getNext();
            count--;
        }

        while (slow.getNext() != null && fast.getNext() != null) {
            previous2 = slow;
            slow = slow.getNext();
            fast = fast.getNext();
        }

        Node last = slow;
        System.out.println("last: " + last);


        // swapping the nodes
        Node tmp1 = first.getNext();
        Node tmp2 = last.getNext();

        last.setNext(tmp1);
        previous1.setNext(last);

        first.setNext(tmp2);
        previous2.setNext(first);

    }

    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head + " ");
            head = head.getNext();
        }
    }

}
