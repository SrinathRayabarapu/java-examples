package com.dsalgo.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * given an unordered linked list, remove duplicates from it.
 * <p>
 * Two approaches are below.
 *
 * @author Srinath.Rayabarapu
 */
public class RemoveDuplicatesInLinkedListMain {

    public static void main(String[] args) {
        // 10 20 10 40 20 60 10 80
        // 10 20 40 60 80
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

/*        System.out.println("Printing original list");
        LinkedListUtil.printLinkedList(head);

        head = removeDuplicatesApproach1(head);

        System.out.println("Printing after removing duplicates");
        LinkedListUtil.printLinkedList(head);*/

        System.out.println("Printing original list");
        LinkedListUtil.printLinkedList(head);

        head = removeDuplicatesUsingHashSet(head);

        System.out.println("Printing after removing duplicates");
        LinkedListUtil.printLinkedList(head);

    }

    /**
     * Faster but uses extra space
     *
     * TC: O(n) where n is length of the single linked list
     * SC: O(n) worst case : all elements of linked list are duplicates
     *
     * @param head
     * @return
     */
    private static Node removeDuplicatesUsingHashSet(Node head) {
        Node temp = head;
        Set<Integer> nodesSet = new HashSet<>();
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node current = head;
        Node prev = null;
        while (current != null) {
            if (nodesSet.contains(current.getData())) {
                prev.setNext(current.getNext());
            } else {
                nodesSet.add((Integer) current.getData());
                prev = current;
            }
            current = current.getNext();
        }
        return temp;
    }

    /**
     * Slower but uses constant space
     *
     * Idea:
     * 1. Create current, next and prev nodes and assign head to current
     * 2. Have a while loop for current and another for next.
     * 3. Use prev node whenever there are duplicates
     * <p>
     * Time complexity : O(n2)
     * Space complexity : O(1)
     *
     * @param head
     * @return
     */
    private static Node removeDuplicatesApproach1(Node head) {

        Node current = head;
        Node next;
        Node prev;

        if (current == null || current.getNext() == null) {
            return head;
        }

        while (current != null) {
            next = current.getNext();
            prev = current;
            while (next != null) {
                if (current.getData() == next.getData()) {
                    prev.setNext(next.getNext());
                }
                prev = next;
                next = next.getNext();
            }
            current = current.getNext();
        }

        return head;
    }

}
