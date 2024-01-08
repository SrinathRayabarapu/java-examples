package com.dsalgo.linkedlist;

import lombok.extern.slf4j.Slf4j;

/**
 * given two linked lists which has common merging point, find it.
 * <p>
 * idea:
 * 1. find lengths of each linked list
 * 2. advance pointer of higher linked list to the difference in lengths
 * 3. traverse each node of two linked lists until the common node
 *
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class FindMergePointOfLinkedListsMain {

    public static void main(String[] args) {

        // list 1
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node n5 = new Node(50);
        Node n6 = new Node(60); // merging point
        Node n7 = new Node(70);
        Node n8 = new Node(80);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n8);

        // list 2
        Node m1 = new Node(11);
        Node m2 = new Node(21);
        Node m3 = new Node(60); // merging point
        Node m4 = new Node(70);
        Node m5 = new Node(80);

        m1.setNext(m2);
        m2.setNext(m3);
        m3.setNext(m4);
        m4.setNext(m5);

        findMergePoint(n1, m1);

    }

    private static void findMergePoint(Node n1, Node m1) {

        // finding lengths
        int length1 = findLength(n1);
        int length2 = findLength(m1);
        Node longer;
        Node shorter;

        // finding difference and identifying the longer and shorter linked lists
        int difference = 0;
        if (length1 < length2) {
            difference = length2 - length1;
            longer = m1;
            shorter = n1;
        } else {
            difference = length1 - length2;
            longer = n1;
            shorter = m1;
        }

        // advancing the longer linked list to the shorter
        while (difference > 0) {
            longer = longer.getNext();
            difference--;
        }

        // compare two linked lists
        while (longer.getData() != shorter.getData()) {
            longer = longer.getNext();
            shorter = shorter.getNext();
        }

        log.info("Merge point is at : {}", longer);

    }

    private static int findLength(Node node) {
        Node current = node;
        int length = 0;
        while (current != null) {
            current = current.getNext();
            length++;
        }
        return length;
    }

}
