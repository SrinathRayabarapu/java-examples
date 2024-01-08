package com.dsalgo.linkedlist;

import lombok.extern.slf4j.Slf4j;

import static com.dsalgo.linkedlist.LinkedListUtil.printLinkedList;

/**
 * given two sorted linked lists, merge them so that final list is sorted!
 * https://www.geeksforgeeks.org/merge-two-sorted-lists-place/?ref=lbp
 *
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class MergeTwoSortedLinkedListsMain {

    public static void main(String[] args) {

        // sorted list 1
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

        log.info("First list : ");
        printLinkedList(n1);

        // sorted list 2
        Node p1 = new Node(11);
        Node p2 = new Node(21);
        Node p3 = new Node(31);
        Node p4 = new Node(41);
        Node p5 = new Node(51);
        Node p6 = new Node(61);
        Node p7 = new Node(71);
        Node p8 = new Node(81);

        p1.setNext(p2);
        p2.setNext(p3);
        p3.setNext(p4);
        p4.setNext(p5);
        p5.setNext(p6);
        p6.setNext(p7);
        p7.setNext(p8);

        log.info("Second list : ");
        printLinkedList(p1);

        Node t1 = mergeTwoLinkedListsRecursive(n1, p1);

        log.info("Print list after merging: ");
        printLinkedList(t1);

    }

    /**
     * TC: O(n + k) where n and k are lengths of respective linked lists
     * SC: O(1)
     * @param n1
     * @param p1
     * @return
     */
    private static Node mergeTwoLinkedListsRecursive(Node n1, Node p1) {

        if(n1 == null)
            return p1;

        if(p1 == null)
            return n1;

        if((int)n1.getData() < (int)p1.getData()){
            n1.setNext(mergeTwoLinkedListsRecursive(n1.getNext(), p1));
            return n1;
        } else {
            p1.setNext(mergeTwoLinkedListsRecursive(n1, p1.getNext()));
            return p1;
        }
    }

}